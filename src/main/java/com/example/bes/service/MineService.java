package com.example.bes.service;

import com.example.bes.entity.Mine;

import java.util.List;

public interface MineService {
    Mine selectMineById(Integer id);

    Mine selectMineByName(String name);

    List<Mine> selectAllMine();

    List<Mine> selectMineByRegion(String region);

    List<Mine> selectMineByClassification(String classification);

    List<Mine> selectMineByProduct(String product);

    List<Mine> selectMineByProducts(List<String> products);

    List<Mine> selectByword(String word);
}

