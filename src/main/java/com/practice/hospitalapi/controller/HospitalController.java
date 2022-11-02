package com.practice.hospitalapi.controller;


import com.practice.hospitalapi.dao.HospitalDao;
import com.practice.hospitalapi.domain.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/hospitals")
@RestController
@Slf4j
public class HospitalController {
    private HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
    Map<Integer, String> statusCode = new HashMap<Integer, String>() {
        {put(2, "휴업");
        put(3, "폐업");
        put(13, "영업중");}
    };


    @GetMapping(value = "/{id}")
    public String getById(@PathVariable int id){
        Hospital hospital = hospitalDao.findById(id);
        log.info("ID:"+id+"가 조회되었습니다.");
        String status = statusCode.get(hospital.getBusinessStatusCode());
        return String.format("1. 병원 이름 : %s,\n2. 주소 : %s,\n3. 도로명 주소 : %s,\n4. 의료진 수 : %d,\n" +
                        "5. 병상 수 : %d,\n6. 면적 : %f,\n7. 폐업여부 : %s",
                hospital.getHospitalName(), hospital.getFullAddress(), hospital.getRoadNameAddress(), hospital.getHealthcareProviderCount(),
                hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize(), status);
    }

}
