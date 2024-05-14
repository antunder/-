package org.example.management.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.BillDetailMapper;
import org.example.management.mapper.GoodMapper;
import org.example.management.mapper.SlipMapper;
import org.example.management.pojo.BillDetail;
import org.example.management.pojo.Good;
import org.example.management.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BillDetailServiceImpl implements BillDetailService {
    @Autowired
    private BillDetailMapper billDetailMapper;
    @Autowired
    private SlipMapper slipMapper;
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public List<BillDetail> list(Integer slipId) {
        return billDetailMapper.list(slipId);
    }

    @Override
    public void save(List<BillDetail> billDetails) {
        billDetailMapper.insert(billDetails);
    }

    @Override
    public void update(Integer slipId,List<BillDetail> billDetails) {
        List<BillDetail> ori = billDetailMapper.list(slipId);
        List<BillDetail> deleteList = new ArrayList<>(ori);
        List<Integer> deleteIds = new ArrayList<>();
        if(billDetails == null && billDetails.isEmpty()){
            if(deleteList != null && !deleteList.isEmpty()){
                for(BillDetail sp : deleteList){
                    deleteIds.add(sp.getId());
                }
                billDetailMapper.delete(deleteIds);
                log.info("删除细节：{}",deleteList);
            }
        }else{
            List<BillDetail> addList  = new ArrayList<>();
            List<BillDetail> updateList = new ArrayList<>();
            for(BillDetail sp : billDetails){
                if(sp.getId()==null){
                    addList.add(sp);
                }else{
                    updateList.add(sp);
                }
            }
            if (addList != null && !addList.isEmpty()){
                billDetailMapper.insert(addList);
                log.info("插入新细节：{}",addList);
            }
            if (updateList != null && !updateList.isEmpty()){
                billDetailMapper.update(updateList);
                log.info("更新新细节：{}",updateList);
            }

            for(BillDetail sp : deleteList){
                deleteIds.add(sp.getId());
            }
            for(BillDetail sp :updateList){
                deleteIds.remove(sp.getId());
            }
            if(deleteIds != null && !deleteIds.isEmpty()){
                billDetailMapper.delete(deleteIds);
            }

        }

    }

    @Override
    public void delete(List<Integer> ids) {
        billDetailMapper.delete(ids);
    }

    @Override
    public BillDetail getById(Integer id) {
        return billDetailMapper.findById(id);
    }

    @Override
    public void pass(Integer slipId) {
        List<BillDetail> billDetails = billDetailMapper.list(slipId);
        for(BillDetail bd : billDetails){
            List<Good> goods = goodMapper.list(bd.getName(),null,bd.getStoreId(),bd.getDecri());
            if(goods.isEmpty()){
                Good good = new Good(null,bd.getName(),1,bd.getDecri(),bd.getStoreId(),bd.getJhPri(),0.0,0.0,bd.getNumber(), LocalDateTime.now());
                goodMapper.insert(good);
            }else {
                for(Good good : goods){
                   Good exist = goodMapper.findById(good.getId());
                   Double average = (exist.getJhPri()*exist.getStorage()+bd.getJhPri()*bd.getNumber())/(exist.getStorage()+bd.getNumber());
                   exist.setStorage(exist.getStorage()+bd.getNumber());
                   exist.setJhPri(average);
                   goodMapper.update(exist);
                }
            }
        }
    }
}
