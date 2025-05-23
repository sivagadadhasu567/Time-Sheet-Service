package com.hpinfosystem.controller;

import com.hpinfosystem.service.TimeSheetService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hpinfosystem.model.Timesheet;

import reactor.core.publisher.Mono;

@RestController
/*@SecurityRequirement(name = "ctasecurity")
@CrossOrigin(origins="*")*/
@EnableScheduling
@Slf4j
public class TimesheetController {
    
    private final TimeSheetService timeSheetService;
    //constructor injection
    public TimesheetController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

	@PostMapping("timesheet/addNewtimesheet")
	@Operation(summary = "api is to add the new timesheetas.")
	public Mono<Object> addTimesheet(@RequestBody Timesheet timesheet){
		return timeSheetService.addNewTimesheet(timesheet);
	}
  }
