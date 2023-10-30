package com.example.bes.service;


import com.example.bes.entity.ListQueryDTO;
import com.example.bes.entity.Status;
import com.example.bes.entity.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService {

     List<Table> getMineProducts(ListQueryDTO listQueryDTO);

     Long getMineCount(ListQueryDTO listQuery);

     boolean saveTable(Table table);


     boolean updateTable(Table table);

     boolean updateDate(String name, String time);

     boolean deleteTable(Table table);


     Status getStatusDate(String name);
}
