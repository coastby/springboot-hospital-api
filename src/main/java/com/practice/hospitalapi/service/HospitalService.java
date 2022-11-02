package com.practice.hospitalapi.service;

import com.practice.hospitalapi.dao.HospitalDao;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private HospitalDao hospitalDao;

    public HospitalService(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
}
