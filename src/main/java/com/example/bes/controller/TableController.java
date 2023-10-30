package com.example.bes.controller;

import com.example.bes.entity.ListQueryDTO;
import com.example.bes.entity.Table;
import com.example.bes.service.TableService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/table")
public class TableController {


    private TableService tableService;


    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }


    @PostMapping("/mine-products")
    @ResponseBody
    public Object getALlData1(HttpServletRequest res) {
        ListQueryDTO listQuery = new ListQueryDTO();
        listQuery.setPage(Integer.valueOf(res.getParameter("page").trim()));
        listQuery.setLimit(Integer.valueOf(res.getParameter("limit").trim()));
        listQuery.setName(res.getParameter("name").trim());
        listQuery.setRegion(res.getParameter("region").trim());
        listQuery.setClassification(res.getParameter("classification").trim());
        listQuery.setSort(res.getParameter("sort").trim());

        List<Table> results = tableService.getMineProducts(listQuery);

        long count  = tableService.getMineCount(listQuery);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("count", count);
        result.put("list", results);
        return result;
    }



    @PostMapping("/add")
    public ResponseEntity<?> createRecord(@RequestBody Table temp) {
        if(tableService.saveTable(temp)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加数据失败:");
        }
    }




    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateRecord(HttpServletRequest res){
        Table tb = new Table();
        tb.setId(Integer.valueOf(res.getParameter("id").trim()));
        tb.setNumber(res.getParameter("number").trim());
        tb.setName(res.getParameter("name").trim());
        tb.setRegion(res.getParameter("region").trim());
        tb.setClassification(res.getParameter("classification").trim());
        tb.setArea(res.getParameter("area").trim());
        tb.setLon(Double.valueOf(res.getParameter("lon").trim()));
        tb.setLat(Double.valueOf(res.getParameter("lat").trim()));
        tb.setProducts(res.getParameter("products").trim());
        tb.setNotes(res.getParameter("notes").trim());
        tb.setState(res.getParameter("state").trim());
        tb.setTungsten(Double.valueOf(res.getParameter("tungsten").trim()));
        tb.setCutter(Double.valueOf(res.getParameter("cutter").trim()));
        tb.setCopper(Double.valueOf(res.getParameter("copper").trim()));
        tb.setSilver(Double.valueOf(res.getParameter("silver").trim()));
        tb.setLead(Double.valueOf(res.getParameter("lead").trim()));
        tb.setZinc(Double.valueOf(res.getParameter("zinc").trim()));
        tb.setTantalum(Double.valueOf(res.getParameter("tantalum").trim()));
        tb.setNiobium(Double.valueOf(res.getParameter("niobium").trim()));
        tb.setTombarthite(Double.valueOf(res.getParameter("tombarthite").trim()));
        tb.setFluorite(Double.valueOf(res.getParameter("fluorite").trim()));
        tb.setOther(Double.valueOf(res.getParameter("other").trim()));

        if(tableService.updateTable(tb)){
            return ResponseEntity.ok("ok");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新失败");
        }
    }

    @PutMapping("/state")
    public ResponseEntity<?> deleteRecord(@RequestBody Table temp){
        if(tableService.deleteTable(temp)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("删除失败");
        }

    }


    @PostMapping("/img")
    public Object receive(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "error";
        }
        String fileName = file.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")
                +"src/main/resources"+System.getProperty("file.separator")+"pic";
        String name = file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
        File file1 = new File(filePath);
        //获取当前时间
        LocalDateTime now = LocalDateTime.now();
        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        Boolean flagUptime= tableService.updateDate(name, formattedNow);
        System.out.println(flagUptime);
        System.out.println(formattedNow);
        if(!file1.exists()){
            file1.mkdir();
        }
        File dest = new File(filePath+File.separator+fileName);
        try {
            file.transferTo(dest);
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            return  "ok";
        }

    }


    @GetMapping("/time/{name}")
    public Object getMineDate(@PathVariable("name") String name){
        return tableService.getStatusDate(name);
    }

}
