package org.example.management.controller;
import lombok.extern.slf4j.Slf4j;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Result;
import org.example.management.pojo.User;
import org.example.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,Short kind,Short gender){
        log.info("分页查询，参数：{}，{},{},{}",page,pageSize,name,kind);
        PageBean pageBean = userService.page(page, pageSize, name, kind,gender);
        return Result.success(pageBean);
    }
    @PostMapping
    public Result save(@RequestBody User user){
        //记录日志
        log.info("新增用户，user:{}",user);
        //调用业务层功能
        userService.save(user);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }
    //批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        userService.delete(ids);
        return Result.success();
    }
    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        User user =  userService.getById(id);
        return Result.success(user);
    }
    @GetMapping("/all")
    public Result getAll(){
        List<User> userList = userService.getAll();
        return Result.success(userList);
    }
}
