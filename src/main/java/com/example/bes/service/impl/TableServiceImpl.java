package com.example.bes.service.impl;

import com.example.bes.entity.*;
import com.example.bes.mapper.MineMapper;
import com.example.bes.mapper.ProductMapper;
import com.example.bes.mapper.StatusMapper;
import com.example.bes.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private MineMapper mineMapper;
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public List<Table> getMineProducts(ListQueryDTO listQuery) {
        int offset = (listQuery.getPage() - 1) * listQuery.getLimit();
        List<Table> result = mineMapper.selectMineProducts(listQuery.getName(),
                listQuery.getRegion(), listQuery.getClassification(),
                listQuery.getSort(), offset, listQuery.getLimit());
        return result;
    }

    @Override
    public Long getMineCount(ListQueryDTO listQuery) {
        return mineMapper.selectCountMine(listQuery.getName(),
                listQuery.getRegion(), listQuery.getClassification());
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveTable(Table table) {
        Mine mine = new Mine();
        mine.setId(table.getId());
        mine.setNumber(table.getNumber());
        mine.setName(table.getName());
        mine.setRegion(table.getRegion());
        mine.setClassification(table.getClassification());
        mine.setArea(table.getArea());
        mine.setLat(table.getLat());
        mine.setLon(table.getLon());
        mine.setProducts(table.getProducts());
        mine.setNotes(table.getNotes());
        Boolean flag1= mineMapper.insertMine(mine)>0?true:false;

        Product product = new Product();
        product.setId(table.getId());
        product.setNumber(table.getNumber());
        product.setName(table.getName());
        product.setTungsten(table.getTungsten());
        product.setCutter(table.getCutter());
        product.setCopper(table.getCopper());
        product.setSilver(table.getSilver());
        product.setLead(table.getLead());
        product.setZinc(table.getZinc());
        product.setTantalum(table.getTantalum());
        product.setNiobium(table.getNiobium());
        product.setTombarthite(table.getTombarthite());
        product.setFluorite(table.getFluorite());
        product.setOther(table.getOther());

        Boolean flag2 = productMapper.insertProduct(product)>0?true:false;
        Status status = new Status();
        status.setId(table.getId());
        status.setNumber(table.getNumber());
        status.setName(table.getName());
        status.setState(table.getState());

        Boolean flag3 = statusMapper.insertStatus(status)>0?true:false;
        if(flag1&&flag2&&flag3){
            return true;
        }else{
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateTable(Table table) {
        Mine mine = new Mine();
        mine.setId(table.getId());
        mine.setNumber(table.getNumber());
        mine.setName(table.getName());
        mine.setRegion(table.getRegion());
        mine.setClassification(table.getClassification());
        mine.setArea(table.getArea());
        mine.setLat(table.getLat());
        mine.setLon(table.getLon());
        mine.setProducts(table.getProducts());
        mine.setNotes(table.getNotes());
        Boolean flag1= mineMapper.updateMine(mine)>0?true:false;

        Product product = new Product();
        product.setId(table.getId());
        product.setNumber(table.getNumber());
        product.setName(table.getName());
        product.setTungsten(table.getTungsten());
        product.setCutter(table.getCutter());
        product.setCopper(table.getCopper());
        product.setSilver(table.getSilver());
        product.setLead(table.getLead());
        product.setZinc(table.getZinc());
        product.setTantalum(table.getTantalum());
        product.setNiobium(table.getNiobium());
        product.setTombarthite(table.getTombarthite());
        product.setFluorite(table.getFluorite());
        product.setOther(table.getOther());

        Boolean flag2 = productMapper.updateProduct(product)>0?true:false;
        Status status = new Status();
        status.setId(table.getId());
        status.setNumber(table.getNumber());
        status.setName(table.getName());
        status.setState(table.getState());

        Boolean flag3 = statusMapper.updateStatus(status)>0?true:false;
        if(flag1&&flag2&&flag3){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateDate(String name, String time) {
        Boolean flag = statusMapper.updateDate(name, time) >0 ?true:false;
        return flag;
    }

    @Override
    public boolean deleteTable(Table table) {
        Status status = new Status();
        status.setId(table.getId());
        status.setNumber(table.getNumber());
        status.setName(table.getName());
        status.setState(table.getState());
        return statusMapper.deleteStatus(status)>0?true:false;

    }

    @Override
    public Status getStatusDate(String name) {
        return statusMapper.getSelectStatusByName(name);
    }


}
