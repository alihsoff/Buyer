package com.buyer;

import com.buyer.TCPClient.TCPConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuyerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuyerApplication.class, args);
        TCPConnection con = new TCPConnection("localhost", 6789);
        con.startConnection();
    }

}
