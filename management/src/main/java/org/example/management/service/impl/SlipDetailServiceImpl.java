package org.example.management.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.SlipDetailMapper;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.SlipDetail;
import org.example.management.service.SlipDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SlipDetailServiceImpl implements SlipDetailService {
    @Autowired
    private SlipDetailMapper slipDetailMapper;

    @Override
    public List<SlipDetail> list(Integer slipId, Integer goodId) {
        return slipDetailMapper.list(slipId,goodId);
    }

    @Override
    public void save(List<SlipDetail> slipDetails) {
        slipDetailMapper.insert(slipDetails);
    }

    @Override
    public void update(List<SlipDetail> slipDetails) {
        slipDetailMapper.update(slipDetails);
    }

    @Override
    public void delete(List<Integer> ids) {
        slipDetailMapper.delete(ids);
    }

    @Override
    public SlipDetail getById(Integer id) {
        return slipDetailMapper.findById(id);
    }
}
