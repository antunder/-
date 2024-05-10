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
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short kind,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询，参数：{}，{},{},{}",page,pageSize,name,kind);
        PageBean pageBean = slipService.page(page, pageSize, name, kind);
        return Result.success(pageBean);
    }
    @PostMapping
    public Result save(@RequestBody Slip slip){
        //记录日志
        log.info("新增开单，slip:{}",slip);
        //调用业务层功能
        slipService.save(slip);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Slip slip){
        slipService.update(slip);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        slipService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Slip slip =  slipService.getById(id);
        return Result.success(slip);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<Slip> slipList = slipService.getAll();
        return Result.success(slipList);
    }
}
