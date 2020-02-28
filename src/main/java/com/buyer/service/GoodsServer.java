package com.buyer.service;

import com.buyer.model.dto.GoodsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${service.supplier.url}", name = "SERVICE")
public interface GoodsServer {

    @PostMapping("/{gId}/{qty}/buyer/1")
    public GoodsDTO receiveGoods(
            @PathVariable("gId") int gId,
            @PathVariable("qty") int qty
    );
}
