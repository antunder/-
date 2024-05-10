package org.example.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.pojo.Store;
import org.example.management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;
    //仓库信息查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,Short kind){
        log.info("分页查询，参数：{}，{},{},{}",page,pageSize,name,kind);
        PageBean pageBean = storeService.page(page, pageSize, name, kind);
        return Result.success(pageBean);
    }
    @PostMapping
    public Result save(@RequestBody Store store){
        //记录日志
        log.info("新增仓库，store:{}",store);
        //调用业务层功能
        storeService.save(store);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Store store){
        storeService.update(store);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        storeService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Store store =  storeService.getById(id);
        return Result.success(store);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<Store> storeList = storeService.getAll();
        return Result.success(storeList);
    }
}
