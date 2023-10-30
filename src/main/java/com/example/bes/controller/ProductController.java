package com.example.bes.controller;

import com.example.bes.entity.PieChart;
import com.example.bes.entity.Product;
import com.example.bes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.*;

@RestController
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/pro/name/{name}")
    public Object getProduct(@PathVariable("name") String name){
        /*
        * {
        *   xData:[],
        *   serviceData:[
        *       {name:'', value:0},
        *       {name:'', value:0},
        *   ],
        * }
        * */
        Product pro = productService.selectProductByname(name);
        Map<String, String> attAliases = new HashMap<String, String>();
        List<String> xData = new ArrayList<String>();
        List<PieChart> seriesData = new ArrayList<PieChart>();
        attAliases.put("tungsten","钨");
        attAliases.put("cutter","铁");
        attAliases.put("copper","铜");
        attAliases.put("silver","银");
        attAliases.put("lead","铅");
        attAliases.put("zinc","锌");
        attAliases.put("tantalum","钽");
        attAliases.put("niobium","铌");
        attAliases.put("tombarthite","稀土");
        attAliases.put("fluorite","萤石");
        attAliases.put("other","其它");

        Field[] fields = pro.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++){
            //有的字段是用private修饰的 将他设置为可读,关闭安全检查，并提高反射速度
            fields[i].setAccessible(true);
            try{
                if(Objects.equals(fields[i].getGenericType().toString(), "double")){
                    if((double)fields[i].get(pro) > 0){
                        xData.add(attAliases.get(fields[i].getName()));
                        PieChart pc = new PieChart(attAliases.get(fields[i].getName()), (double)fields[i].get(pro));
                        seriesData.add(pc);
                    }

                }
            }catch (Exception e){
               e.printStackTrace();
            }
        }
        Map<String,List> pdata = new HashMap<String,List>();
        pdata.put("xData", xData);
        pdata.put("seriesData", seriesData);
        return pdata;
    }




}
