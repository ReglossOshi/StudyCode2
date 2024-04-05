package org.zerock.service.finishedgoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.FinishedGoodsVO;
import org.zerock.mapper.finishedgoods.FinishedGoodsMapper;

import java.util.List;

@Service
public class FinishedGoodsServiceImpl implements FinishedGoodsService{
    @Autowired
    private FinishedGoodsMapper finishedGoodsMapper;

    @Override
    public List<FinishedGoodsVO> insertGoods(){
        List<FinishedGoodsVO> goods = finishedGoodsMapper.getGoodsList();
        return goods;
    }
}
