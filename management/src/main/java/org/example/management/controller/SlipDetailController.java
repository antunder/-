package org.example.management.controller;

import lombok.extern.slf4j.Slf4j;
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
    public Result save(@RequestBody List<SlipDetail> slipDetails){
        //记录日志
        log.info("新增开单细节，slipDetail:{}",slipDetails);
        //调用业务层功能
        slipDetailService.save(slipDetails);
        return Result.success();
    }
    @PutMapping("/{slipId}")
    public Result update(@PathVariable Integer slipId, @RequestBody List<SlipDetail> slipDetails){
        slipDetailService.update(slipId,slipDetails);
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
    //整单退货
    @PutMapping("/reject/{slipId}")
    public Result reject(@PathVariable Integer slipId){
        slipDetailService.reject(slipId);
        return Result.success();
    }

}
