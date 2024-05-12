package org.example.management.controller;
import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.pojo.Slip;
import org.example.management.service.SlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/slips")
public class SlipController {
    @Autowired
    private SlipService slipService;
    //条件分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize, Short kind, Short state,Integer storeId,Integer custId,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        //记录日志
        log.info("分页查询，参数：{}，{},{},{},{},{},{},{}",page,pageSize,kind,state,storeId,custId,begin,end);
        //调用业务层分页查询功能
        PageBean pageBean = slipService.page(page,pageSize,kind,state,storeId,custId,begin,end);
        //响应
        return Result.success(pageBean);
    }
    //仅条件查询
    @GetMapping("/list")
    public Result list(Short kind, Short state,Integer storeId,Integer custId,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        //记录日志
        log.info("条件查询，参数：{},{},{},{},{},{}",kind,state,storeId,custId,begin,end);
        //调用业务层分页查询功能
        List<Slip> slipList = slipService.list(kind,state,storeId,custId,begin,end);
        //响应
        return Result.success(slipList);
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        slipService.delete(ids);
        return Result.success();
    }

    //新增
    @PostMapping
    public Result save(@RequestBody Slip slip){
        //记录日志
        log.info("新增开单，slip:{}",slip);
        //调用业务层功能
        Integer id = slipService.save(slip);
        return Result.success(id);
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Slip slip =  slipService.getById(id);
        return Result.success(slip);
    }

    //修改开单
    @PutMapping
    public  Result update(@RequestBody Slip slip){
        slipService.update(slip);
        return Result.success();
    }

    //获取所有开单
    @GetMapping("/all")
    public Result getAll(){
        List<Slip> slipList = slipService.getAll();
        return Result.success(slipList);
    }
}
