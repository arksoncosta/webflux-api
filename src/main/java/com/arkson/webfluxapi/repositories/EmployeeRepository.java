package com.arkson.webfluxapi.repositories;

import com.arkson.webfluxapi.domain.Employee;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private static final Map<String, Employee> EMPLOYEE_DATA;

    static {
        EMPLOYEE_DATA = new HashMap<>();
        EMPLOYEE_DATA.put("1", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("2", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("3", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("4", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("5", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("6", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("7", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("8", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("9", new Employee("1", "Employee 1"));
        EMPLOYEE_DATA.put("10", new Employee("1", "Employee 1"));
    }

    public Flux<Employee> findAllEmployees() {
        return Flux.fromIterable(EMPLOYEE_DATA.values());
    }

    public Mono<Employee> findEmployeeById(String id) {
        return Mono.just(EMPLOYEE_DATA.get(id));
    }

}
