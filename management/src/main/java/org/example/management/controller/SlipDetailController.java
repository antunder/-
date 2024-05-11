package org.example.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.pojo.SlipDetail;
import org.example.management.service.SlipDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/slipDetails")
public class SlipDetailController {
    @Autowired
    private SlipDetailService slipDetailService;
    //根据开单和货品id查询开单细节
    @GetMapping
    public Result list(Integer slipId,Integer goodId ){
        List<SlipDetail> slipDetailList = slipDetailService.list(slipId,goodId);
        return Result.success(slipDetailList);
    }
    @PostMapping
    public Result save(@RequestBody SlipDetail slipDetail){
        //记录日志
        log.info("新增开单细节，slipDetail:{}",slipDetail);
        //调用业务层功能
        slipDetailService.save(slipDetail);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody SlipDetail slipDetail){
        slipDetailService.update(slipDetail);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        slipDetailService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        SlipDetail slipDetail =  slipDetailService.getById(id);
        return Result.success(slipDetail);
    }

}
