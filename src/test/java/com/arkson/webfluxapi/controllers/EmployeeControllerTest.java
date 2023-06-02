package com.arkson.webfluxapi.controllers;

import com.arkson.webfluxapi.domain.Employee;
import com.arkson.webfluxapi.repositories.EmployeeRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.BDDMockito.given;

@WebFluxTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    void testGetAllEmployees() {
        var employee =
                Employee
                        .builder()
                        .id("id")
                        .name("name")
                        .build();

        given(employeeRepository.findAllEmployees())
                .willReturn(Flux.just(employee));

        webTestClient
                .get()
                .uri("/employees")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$", CoreMatchers.hasItem(employee));
    }
}