package org.example.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.Good;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private GoodService goodService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short state,Integer storeId,String decri){
        log.info("分页查询，参数：{}，{},{},{},{},{}",page,pageSize,name,state,storeId,decri);
        PageBean pageBean = goodService.page(page, pageSize, name, state,storeId,decri);
        return Result.success(pageBean);
    }
    @PostMapping
    public Result save(@RequestBody Good good){
        //记录日志
        log.info("新增货品，good:{}",good);
        //调用业务层功能
        goodService.save(good);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Good good){
        goodService.update(good);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        goodService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Good good =  goodService.getById(id);
        return Result.success(good);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<Good> goodList = goodService.getAll();
        return Result.success(goodList);
    }
}
