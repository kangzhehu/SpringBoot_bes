package com.example.bes.mapper;

import com.example.bes.entity.ListQueryDTO;
import com.example.bes.entity.Table;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TableMapper {
    /**
     *
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @return
     */
    List<Table> queryTableByPage(ListQueryDTO listQueryDTO);




}
