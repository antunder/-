package org.example.management.controller;
import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.pojo.Cust;
import org.example.management.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/custs")
public class CustController {
    @Autowired
    private CustService custService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short kind,Short gender){
        log.info("分页查询，参数：{}，{},{},{},{}",page,pageSize,name,kind,gender);
        PageBean pageBean = custService.page(page, pageSize, name, kind,gender);
        return Result.success(pageBean);
    }
    @PostMapping
    public Result save(@RequestBody Cust cust){
        //记录日志
        log.info("新增客户，cust:{}",cust);
        //调用业务层功能
        custService.save(cust);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Cust cust){
        custService.update(cust);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        custService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Cust cust =  custService.getById(id);
        return Result.success(cust);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<Cust> custList = custService.getAll();
        return Result.success(custList);
    }
}
