package com.practice.hospitalapi.parser;

import com.practice.hospitalapi.domain.Hospital;

import java.time.LocalDateTime;
import java.util.Arrays;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {
        String[] row = str.split("\",\"");
        System.out.println(Arrays.toString(row));

        int id = Integer.parseInt(row[0].replace("\"",""));
        String service = row[1];
        int localCode = Integer.parseInt(row[3]);
        String manageNum = row[4];
        LocalDateTime licenseDate = dateConverter(row[5]);
        int businessStatus = Integer.parseInt(row[7]);
        int businessCode = Integer.parseInt(row[9]);
        String phone = row[15];
        String address = row[18];
        String roadAddress = row[19];
        String name = row[21];
        String businessType = row[25];
        int providerNum = Integer.parseInt(row[29]);
        int roomNum = Integer.parseInt(row[30]);
        int bedNum = Integer.parseInt(row[31]);
        float area = Float.parseFloat(row[32].replace("\"", ""));
        Hospital hospital = new Hospital(id, service, localCode, manageNum, licenseDate, businessStatus, businessCode,
                phone, address, roadAddress, name, businessType, providerNum, roomNum, bedNum, area);
        return hospital;
    }

    public LocalDateTime dateConverter(String str){
        int year = Integer.parseInt(str.substring(0,4));
        int month = Integer.parseInt(str.substring(4,6));
        int day = Integer.parseInt(str.substring(6,8));
        return LocalDateTime.of(year, month, day, 0, 0, 0);

    }
}
