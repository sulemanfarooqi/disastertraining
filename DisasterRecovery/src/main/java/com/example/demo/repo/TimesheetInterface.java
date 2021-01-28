package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TimeSheet;

public interface TimesheetInterface extends JpaRepository<TimeSheet, Integer> {

}
