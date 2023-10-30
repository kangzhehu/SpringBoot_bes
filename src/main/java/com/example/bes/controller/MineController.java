package com.example.bes.controller;

import com.example.bes.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MineController {

    private MineService mineService;
    @Autowired
    public MineController(MineService mineService) {
        this.mineService = mineService;
    }
    @GetMapping("/all")
    public Object getAllMines(){
        return  mineService.selectAllMine();
    }
    @GetMapping("/id/{id}")
    public Object getMineById(@PathVariable("id")Integer id){
        return mineService.selectMineById(id);
    }
    @GetMapping("name/{name}")
    public Object getMineByName(@PathVariable("name")String name){
        return mineService.selectMineByName(name);
    }
    @GetMapping("region/{region}")
    public Object getMineByRegion(@PathVariable("region")String region){
        return  mineService.selectMineByRegion(region);
    }

    @GetMapping("class/{classification}")
    public Object getMineByClass(@PathVariable("classification")String classification){
        return  mineService.selectMineByClassification(classification);
    }
    @GetMapping("product/{product}")
    public Object getMineByProduct(@PathVariable("product")String product){
        return  mineService.selectMineByProduct(product);
    }

    @GetMapping("word/{word}")
    public Object getMineByword(@PathVariable("word")String word){
        return mineService.selectByword(word);
    }


}
