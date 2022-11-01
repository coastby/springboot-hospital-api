package com.practice.hospitalapi.dao;

import com.practice.hospitalapi.domain.Hospital;
import com.practice.hospitalapi.parser.HospitalParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalDaoTest {
    @Autowired
    HospitalDao hospitalDao;
    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
    @Test
    void addAndFindTest(){
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);
        hospitalDao.add(hospital);

        Hospital hospital1 = hospitalDao.findById(1);
        assertEquals(hospital.getHospitalName(), hospital1.getHospitalName());

        hospitalDao.deleteAll();
        assertThrows(EmptyResultDataAccessException.class, ()->{
            hospitalDao.findById(1);
        });
    }



}