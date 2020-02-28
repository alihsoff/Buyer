package com.buyer.controller;

import com.buyer.TCPClient.TCPConnection;
import com.buyer.model.dto.GoodsDTO;
import com.buyer.model.entity.TGoods;
import com.buyer.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.buyer.service.GoodsServer;

@RequestMapping("/buyer")
@RestController
public class BuyerController {

    private final GoodsServer goodsServer;
    private final GoodsService service;

    public BuyerController(GoodsService service, GoodsServer goodsServer) {
        this.service = service;
        this.goodsServer = goodsServer;
    }

    @ApiOperation("order goods by order code from service")
    @PostMapping("orderGoods/{gCode}/{qty}")
    public String orderGoods(
            @PathVariable("gCode") int gCode,
            @PathVariable("qty") int qty
    ) {
        GoodsDTO goodsDTO = goodsServer.receiveGoods(gCode, qty);
        if (goodsDTO != null) {
            service.insertGoods(goodsDTO);
            return "Order Successful!";
        } else {
            return "Order Failed!";
        }
    }

    @ApiOperation("sell goods to customers")
    @PutMapping("/sellGoods/{goodsId}")
    public void sellGoods(
            @PathVariable("goodsId") int goodsId
    ) {
        TGoods goods = service.getById(goodsId);
        if (goods.getGQty() > 5) {
            goods.setGQty(goods.getGQty() - 1);
        } else {
            TCPConnection.sendMessage("There are only 5 " + goods.getGName() + " left");
            GoodsDTO goodsDTO = goodsServer.receiveGoods(goods.getGCode(), 50);
            if (goodsDTO != null) {
                goods.setGQty(goodsDTO.getQty()+goods.getGQty()-1);
            }
        }
        service.updateGoods(goods);
    }

}
