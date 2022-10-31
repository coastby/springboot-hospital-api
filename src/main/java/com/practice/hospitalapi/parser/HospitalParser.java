package com.practice.hospitalapi.parser;

import com.practice.hospitalapi.domain.Hospital;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {
        String[] row = str.split("\",\"");
        System.out.println(Arrays.toString(row));

        Hospital hospital = new Hospital();
        String id = row[0].replace("\"","");
        String service = row[1];
        int localCode = Integer.parseInt(row[3]);
        String manageNum = row[4];
        LocalDateTime licenseDate = Integer.parseInt(row[5]);



        return null;
    }
}
