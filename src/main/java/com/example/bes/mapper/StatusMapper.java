package com.example.bes.mapper;

import com.example.bes.entity.Status;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusMapper {

    int insertStatus(Status status);

    int updateStatus(Status status);

    int deleteStatus(Status status);

    int updateDate(String name, String time);

    Status getSelectStatusByName(String name);
}
