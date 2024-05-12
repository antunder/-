package org.example.management.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.SlipDetailMapper;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.SlipDetail;
import org.example.management.service.SlipDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void update(Integer slipId,List<SlipDetail> slipDetails) {
        List<SlipDetail> ori = slipDetailMapper.list(slipId,null);
        List<SlipDetail> addList  = new ArrayList<>();
        List<SlipDetail> updateList = new ArrayList<>();
        List<SlipDetail> deleteList = new ArrayList<>(ori);
        for(SlipDetail sp : slipDetails){
            if(sp.getId()==null){
                addList.add(sp);
            }else{
                updateList.add(sp);
            }
        }
        slipDetailMapper.insert(addList);
        slipDetailMapper.update(updateList);
        List<Integer> deleteIds = new ArrayList<>();
        for(SlipDetail sp : deleteList){
            deleteIds.add(sp.getId());
        }
        for(SlipDetail sp :updateList){
            deleteIds.remove(sp.getId());
        }
        slipDetailMapper.delete(deleteIds);
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
