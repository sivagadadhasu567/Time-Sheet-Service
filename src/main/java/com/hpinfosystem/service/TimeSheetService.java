package com.hpinfosystem.service;

import com.hpinfosystem.model.Timesheet;
import reactor.core.publisher.Mono;

public interface TimeSheetService {

    Mono<Object> addNewTimesheet(Timesheet timesheet);
}
