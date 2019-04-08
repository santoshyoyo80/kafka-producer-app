package com.nexensus.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexensus.domain.Company;
import com.nexensus.domain.repository.CompanyRepository;
import com.nexensus.model.Employee;
import com.nexensus.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestProducer {
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private CompanyRepository companyRepository;

    @PostConstruct
    public void test() throws JsonProcessingException {
        Employee e = new Employee();
        e.setEmailId("santosh@gmail.com");
        e.setEmpId(100);
        e.setFirstName("santosh");
        e.setLastName("kumar");
        e.setPassword("qwerty16868");
        Company company = companyRepository.findByCin("L00219KA1991PLC012579");
        String payload = mapper.writeValueAsString(company);
        producerService.send(payload);
    }
}
