package org.example.management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.SlipMapper;
import org.example.management.pojo.Slip;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Slip;
import org.example.management.service.SlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class SlipServiceImpl implements SlipService {
    @Autowired
    private SlipMapper slipMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, Short kind, Short state, Integer storeId, Integer custId,LocalDate begin,LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Slip> custList = slipMapper.list( kind,state,storeId,custId,begin,end);
        Page<Slip> p = (Page<Slip>) custList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public List<Slip> list(Short kind, Short state, Integer storeId, Integer custId, LocalDate begin, LocalDate end) {
        return slipMapper.list( kind,state,storeId,custId,begin,end);
    }

    @Override
    public void save(Slip slip) {
        slip.setCreateTime(LocalDate.now());
        slipMapper.update(slip);
    }

    @Override
    public List<Slip> getAll() {
        return slipMapper.getAll();
    }

    @Override
    public Slip getById(Integer id) {
        return slipMapper.findById(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        slipMapper.delete(ids);
    }

    @Override
    public void update(Slip slip) {
        slipMapper.update(slip);
    }
}
