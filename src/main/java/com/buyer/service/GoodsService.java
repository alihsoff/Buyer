package com.buyer.service;

import com.buyer.model.dto.GoodsDTO;
import com.buyer.model.entity.TGoods;
import com.buyer.repository.GoodsRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;

    public TGoods getById(int id) {
        return goodsRepository.findById(id).get();
    }

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void updateGoods(TGoods goods) {
        goodsRepository.save(goods);
    }

    public boolean insertGoods(GoodsDTO goodsDTO) {
        TGoods goods = new TGoods();
        goods.setGCode(goodsDTO.getId());
        goods.setGName(goodsDTO.getName());
        goods.setGQty(goodsDTO.getQty());
        goodsRepository.save(goods);
        return true;
    }

    public void deleteGoods(int id) {
        goodsRepository.deleteById(id);
    }

}
