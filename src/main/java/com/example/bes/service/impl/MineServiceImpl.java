package com.example.bes.service.impl;

import com.example.bes.entity.Mine;
import com.example.bes.mapper.MineMapper;
import com.example.bes.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MineServiceImpl implements MineService {

    @Autowired
    private MineMapper mineMapper;
    @Override
    public Mine selectMineById(Integer id) {
        return mineMapper.selectMineById(id);
    }

    @Override
    public Mine selectMineByName(String name) {
        return mineMapper.selectMineByName(name);
    }

    @Override
    public List<Mine> selectAllMine() {
        return mineMapper.selectAllMine();
    }

    @Override
    public List<Mine> selectMineByRegion(String region) {
        return mineMapper.selectMineByRegion(region);
    }

    @Override
    public List<Mine> selectMineByClassification(String classification) {
        return mineMapper.selectMineByClassification(classification);
    }

    @Override
    public List<Mine> selectMineByProduct(String product) {
        return mineMapper.selectMineByProduct(product);
    }

    @Override
    public List<Mine> selectMineByProducts(List<String> products) {
        return mineMapper.selectMineByProducts(products);
    }

    @Override
    public List<Mine> selectByword(String word) {
        return mineMapper.selectByword(word);
    }
}
