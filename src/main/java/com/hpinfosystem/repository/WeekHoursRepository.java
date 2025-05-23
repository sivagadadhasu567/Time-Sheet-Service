package com.hpinfosystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hpinfosystem.model.WeekHours;

@Repository
public interface WeekHoursRepository extends JpaRepository<WeekHours, Integer> {

}
