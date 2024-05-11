package org.example.management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.GoodMapper;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Good;
import org.example.management.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short state,Integer storeId,String decri) {
        PageHelper.startPage(page,pageSize);
        List<Good> goodList = goodMapper.list(name, state,storeId,decri);
        Page<Good> p = (Page<Good>) goodList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public List<Good> list(String name, Short state, Integer storeId, String decri) {
        return goodMapper.list(name, state, storeId, decri);
    }

    @Override
    public void save(Good good) {
        good.setCreateTime(LocalDateTime.now());
        goodMapper.insert(good);
    }

    @Override
    public void update(Good good) {
        goodMapper.update(good);
    }

    @Override
    public void delete(List<Integer> ids) {
        goodMapper.delete(ids);
    }

    @Override
    public List<Good> getAll() {
        return goodMapper.getAll();
    }

    @Override
    public Good getById(Integer id) {
        return goodMapper.findById(id);
    }
}
