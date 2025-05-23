package com.hpinfosystem.service;

import com.hpinfosystem.model.Timesheet;
import com.hpinfosystem.repository.TimeSheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@Slf4j
public class TimeSheetServiceImpl implements TimeSheetService {

    private final TimeSheetRepository timeSheetRepository;

    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository) {
        this.timeSheetRepository = timeSheetRepository;
    }
    @Override
    public Mono<Object> addNewTimesheet(Timesheet timesheet) {
        log.debug("Inside addTimesheet method :: {}", timesheet);
        return timeSheetRepository.findByEmployeeIdAndStartDateAndEndDateAndProject(timesheet.getEmployeeId(),timesheet.getStartDate(),
                        timesheet.getEndDate(),timesheet.getProject())
                .flatMap(existing -> {
                    log.debug("Timesheet already exists for the selected dates: {}", existing);
                    return Mono.error(new RuntimeException(
                            "Timesheet has been submitted for the selected dates. Please update the timesheet if it needs change."));
                }).switchIfEmpty(timeSheetRepository.findByApprovedInAndEmployeeIdAndEmployeeName(List.of("Approved", "Rejected"),timesheet.getEmployeeId(),
                  timesheet.getEmployeeName())
                  .next().switchIfEmpty(Mono.defer(() -> {
                   log.debug("Employee ID and Name do not match records for employeeId: {} and employeeName: {}", timesheet.getEmployeeId(), timesheet.getEmployeeName());
                    return Mono.error(new RuntimeException("Employee Id and Name do not match the records."));
                    })).flatMap(employee -> {
                 log.debug("Employee record found: {}", employee);
                 timesheet.setTotalHours();
                 timesheet.setSubmitted("submitted");
                 timesheet.setApproved("Pending");
              return timeSheetRepository.save(timesheet)
               .doOnEach(signal -> {
                  if (signal.isOnNext()) {
                      log.debug("Timesheet saved successfully: {}", signal.get());}
                  else if (signal.isOnError()) {
                     log.debug("Timesheet cannot be saved due to: {}", signal.getThrowable().getMessage()); }
                                            });
                                })
                );
    }
}
