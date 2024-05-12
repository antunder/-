package org.example.management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.CustMapper;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Cust;
import org.example.management.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CustServiceImpl implements CustService {
    @Autowired
    private CustMapper custMapper;
    @Override
    public PageBean pageCust(Integer page, Integer pageSize, String name, Short kind,Short gender) {
        PageHelper.startPage(page,pageSize);
        List<Cust> custList = custMapper.listCust(name, kind,gender);
        Page<Cust> p = (Page<Cust>) custList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public PageBean pageSup(Integer page, Integer pageSize, String name, Short gender) {
        PageHelper.startPage(page,pageSize);
        List<Cust> custList = custMapper.listSup(name,gender);
        Page<Cust> p = (Page<Cust>) custList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void save(Cust cust) {
        cust.setCreateTime(LocalDateTime.now());
        custMapper.insert(cust);
    }

    @Override
    public void update(Cust cust) {
        custMapper.update(cust);
    }

    @Override
    public void delete(List<Integer> ids) {
        custMapper.delete(ids);
    }

    @Override
    public List<Cust> getAll() {
        return custMapper.getAll();
    }

    @Override
    public Cust getById(Integer id) {
        return custMapper.findById(id);
    }
}
