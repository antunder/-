package org.example.management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.StoreMapper;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Store;
import org.example.management.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short kind) {
        PageHelper.startPage(page,pageSize);
        List<Store> storeList = storeMapper.list(name, kind);
        Page<Store> p = (Page<Store>) storeList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void save(Store store) {
        store.setCreateTime(LocalDateTime.now());
        storeMapper.insert(store);
    }

    @Override
    public void update(Store store) {
        storeMapper.update(store);
    }

    @Override
    public void delete(List<Integer> ids) {
        storeMapper.delete(ids);
    }

    @Override
    public List<Store> getAll() {
        return storeMapper.getAll();
    }

    @Override
    public Store getById(Integer id) {
        return storeMapper.findById(id);
    }
}
