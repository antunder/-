package org.example.management.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.GoodMapper;
import org.example.management.mapper.SlipDetailMapper;
import org.example.management.mapper.SlipMapper;
import org.example.management.pojo.Good;
import org.example.management.pojo.PageBean;
import org.example.management.pojo.Slip;
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
    @Autowired
    private SlipMapper slipMapper;
    @Autowired
    private GoodMapper goodMapper;
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
        List<SlipDetail> deleteList = new ArrayList<>(ori);
        List<Integer> deleteIds = new ArrayList<>();
        if(slipDetails == null || slipDetails.isEmpty()){
            if(deleteList != null && !deleteList.isEmpty()){
                for(SlipDetail sp : deleteList){
                    deleteIds.add(sp.getId());
                }
                slipDetailMapper.delete(deleteIds);
                log.info("删除细节：{}",deleteList);
            }
        }else{
            List<SlipDetail> addList  = new ArrayList<>();
            List<SlipDetail> updateList = new ArrayList<>();
            for(SlipDetail sp : slipDetails){
                if(sp.getId()==null){
                    addList.add(sp);
                }else{
                    updateList.add(sp);
                }
            }
            if (addList != null && !addList.isEmpty()){
                slipDetailMapper.insert(addList);
                log.info("插入新细节：{}",addList);
            }
            if (updateList != null && !updateList.isEmpty()){
                slipDetailMapper.update(updateList);
                log.info("更新新细节：{}",updateList);
            }

            for(SlipDetail sp : deleteList){
                deleteIds.add(sp.getId());
            }
            for(SlipDetail sp :updateList){
                deleteIds.remove(sp.getId());
            }
            if(deleteIds != null && !deleteIds.isEmpty()){
                slipDetailMapper.delete(deleteIds);
            }

        }

    }

    @Override
    public void delete(List<Integer> ids) {
        slipDetailMapper.delete(ids);
    }

    @Override
    public SlipDetail getById(Integer id) {
        return slipDetailMapper.findById(id);
    }

    @Override
    public void reject(Integer slipId) {
        List<SlipDetail> slipDetails = slipDetailMapper.list(slipId,null);
        Slip slip = slipMapper.findById(slipId);
        Short state = 6;
        slip.setState(state);
        slipMapper.update(slip);//更改slip状态
        Integer ori,now;
        for(SlipDetail sp : slipDetails){
            Integer goodId = sp.getGoodId();
            Good good = goodMapper.findById(goodId);
            ori = good.getStorage();
            now = ori+sp.getNumber();
            good.setStorage(now);
            goodMapper.update(good);
        }
    }
}
