package com.arkson.webfluxapi.controllers;

import com.arkson.webfluxapi.domain.Employee;
import com.arkson.webfluxapi.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("employees")
@Slf4j
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping("{id}")
    public Mono<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.findEmployeeById(id);
    }

    @GetMapping
    public Flux<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
    }
}
