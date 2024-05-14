package org.example.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.Result;
import org.example.management.pojo.BillDetail;
import org.example.management.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/billDetails")
public class BillDetailController {
    @Autowired
    private BillDetailService billDetailService;
    @GetMapping
    public Result list(Integer slipId ){
        List<BillDetail> slipDetailList = billDetailService.list(slipId);
        return Result.success(slipDetailList);
    }
    @PostMapping
    public Result save(@RequestBody List<BillDetail> slipDetails){
        //记录日志
        log.info("新增开单细节，slipDetail:{}",slipDetails);
        //调用业务层功能
        billDetailService.save(slipDetails);
        return Result.success();
    }
    @PutMapping("/{slipId}")
    public Result update(@PathVariable Integer slipId, @RequestBody List<BillDetail> slipDetails){
        billDetailService.update(slipId,slipDetails);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        billDetailService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        BillDetail slipDetail =  billDetailService.getById(id);
        return Result.success(slipDetail);
    }
    @PostMapping("/pass/{slipId}")
    public Result pass(@PathVariable Integer slipId){
        billDetailService.pass(slipId);
        return Result.success();
    }
}
