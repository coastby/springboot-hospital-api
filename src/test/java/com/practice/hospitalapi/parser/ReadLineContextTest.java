package com.practice.hospitalapi.parser;

import com.practice.hospitalapi.domain.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReadLineContextTest {
    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;
    @Test
    void name() throws IOException {
        String filename = "../data/전국병원리스트.csv";
        List<Hospital> hospitalList = hospitalReadLineContext.readLines(filename);

        assertTrue(hospitalList.size() > 100000);
        System.out.println(hospitalList.size());        //총 개수 111919개
        for (int i = 100000; i < 101000; i++) {
            System.out.println(hospitalList.get(i).getId());
        }
    }


}