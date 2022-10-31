package com.practice.hospitalapi.parser;

import com.practice.hospitalapi.domain.Hospital;

import java.time.LocalDateTime;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {
        String[] row = str.split("\",\"");
        try{
        int id = Integer.parseInt(row[0].replace("\"",""));
        String service = row[1];
        int localCode = Integer.parseInt(row[3]);
        String manageNum = row[4];
        LocalDateTime licenseDate = strConverterToDate(row[5]);
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
        } catch (Exception e) {
            //파싱 실패한 경우 로그 남기고 null 반환
            System.out.printf("파싱이 불가능합니다, 실패한 병원 : %s\n", str.substring(0, 20));
            return null;
        }
    }

    public LocalDateTime strConverterToDate(String str){
        int year = Integer.parseInt(str.substring(0,4));
        int month = Integer.parseInt(str.substring(4,6));
        int day = Integer.parseInt(str.substring(6,8));
        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }
}
