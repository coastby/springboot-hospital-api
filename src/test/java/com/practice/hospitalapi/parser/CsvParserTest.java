package com.practice.hospitalapi.parser;

import com.practice.hospitalapi.domain.Hospital;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvParserTest {
    @Test
    void csvParserTest() throws FileNotFoundException {
        CsvParser cp = new CsvParser();
        String filename = "../data/전국병원리스트_csv.csv";
        List<Hospital> hospitals= cp.read(filename);

        assertEquals(111918, hospitals.size());
    }

}