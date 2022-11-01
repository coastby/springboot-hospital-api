package com.practice.hospitalapi.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.practice.hospitalapi.domain.Hospital;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public List<Hospital> read(String filename) throws FileNotFoundException {
        String[] row;
        List<Hospital> hospitalList = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(filename)));

        try {
            csvReader.readNext();       //제목줄은 제거
            do{
                row = csvReader.readNext();
                int id = 0;
                String service = null;
                int localCode = 0;
                String manageNum = null;
                LocalDateTime licenseDate = null;
                int businessStatus = 0;
                int businessCode = 0;
                String phone = null;
                String address = null;
                String roadAddress = null;
                String name = null;
                String businessType = null;
                int providerNum = 0;
                int roomNum = 0;
                int bedNum = 0;
                float area = 0;
                try {
                    id = Integer.parseInt(row[0]);
                    System.out.println(id);
                    service = row[1];
                    localCode = Integer.parseInt(row[3]);
                    manageNum = row[4];
                    licenseDate = strConverterToDate(row[5]);
                    businessStatus = Integer.parseInt(row[7]);
                    businessCode = Integer.parseInt(row[9]);
                    phone = row[15];
                    address = row[18];
                    roadAddress = row[19];
                    name = row[21];
                    System.out.println(name);
                    businessType = row[25];
                    providerNum = Integer.parseInt(row[29]);
                    roomNum = Integer.parseInt(row[30]);
                    bedNum = Integer.parseInt(row[31]);
                    area = Float.parseFloat(row[32].replace("\"", ""));
                } catch (NumberFormatException | DateTimeException | NullPointerException e) {
                    System.out.println("빈 값이 있습니다.");
                }
                Hospital hospital = new Hospital(id, service, localCode, manageNum, licenseDate, businessStatus, businessCode,
                        phone, address, roadAddress, name, businessType, providerNum, roomNum, bedNum, area);
                hospitalList.add(hospital);
            }while(row != null);
        } catch (IOException e) {
            System.out.println("파싱을 실패했습니다.");
        } catch (CsvValidationException e) {
            System.out.println("파싱을 실패했습니다.");
        }
        return hospitalList;
    }
    public LocalDateTime strConverterToDate(String str){
        int year = Integer.parseInt(str.substring(0,4));
        int month = Integer.parseInt(str.substring(4,6));
        int day = Integer.parseInt(str.substring(6,8));
        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }
}
