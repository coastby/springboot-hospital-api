package com.practice.hospitalapi.dao;

import com.practice.hospitalapi.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Hospital hospital) {
        this.jdbcTemplate.update(
                "INSERT INTO `likelion`.`hospitals_in_korea`\n" +
                "(`id`, `open_service_name`, `open_local_goverment_code`, `management_number`, `license_date`, `business_status`, `business_status_code`, `phone`, `full_address`, `road_name_address`, `hospital_name`, `business_type_name`, `healthcare_provider_count`, `patient_room_count`, `total_number_of_beds`, `total_area_size`) " +
                "VALUES (?, ?, ?,\n" +
                "?, ?, ?, ?,\n" +
                "?, ?, ?, " +
                "?, ?, ?, ?, ?, ?);",
                hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(), hospital.getFullAddress(), hospital.getRoadNameAddress(),
                hospital.getHospitalName(), hospital.getBusinessTypeName(), hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize());
    }

    public void deleteAll(){
        this.jdbcTemplate.update("DELETE FROM hospitals_in_korea;");
    }

    public int getCount(){
        return this.jdbcTemplate.queryForObject("SELECT COUNT(id) FROM hospitals_in_korea", Integer.class);
    }

    public int deleteById (int id){
        return jdbcTemplate.update("DELETE FROM hospitals_in_korea where id = ?;", id);
    }
    public Hospital findById(int id) {
        String sql = "SELECT * FROM hospitals_in_korea where id = ?";
        RowMapper<Hospital> rowMapper = new RowMapper<Hospital>() {
            @Override
            public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
                Hospital hospital = new Hospital(rs.getInt("id"), rs.getString("open_service_name"), rs.getInt("open_local_goverment_code"), rs.getString("management_number"), rs.getTimestamp("license_date").toLocalDateTime(), rs.getInt("business_status"), rs.getInt("business_status_code"), rs.getString("phone"), rs.getString("full_address"), rs.getString("road_name_address"), rs.getString("hospital_name"), rs.getString("business_type_name"), rs.getInt("healthcare_provider_count"), rs.getInt("patient_room_count"), rs.getInt("total_number_of_beds"), rs.getFloat("total_area_size"));
                return hospital;
            }
        };
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }







}
