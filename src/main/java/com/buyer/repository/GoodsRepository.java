package com.buyer.repository;

import com.buyer.model.entity.TGoods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends CrudRepository<TGoods, Integer>{
    
}
