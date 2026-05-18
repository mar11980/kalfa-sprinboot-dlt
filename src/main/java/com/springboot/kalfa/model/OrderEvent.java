package com.springboot.kalfa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {

    private String orderId;
    private String product;
    private Integer quantity;
    private String email;

 /*   @Override
    public String toString() {
        return "{\n" +
                "  \"orderId\":\"" + orderId + "\",\n" +
                "  \"product\":\"" + product + "\",\n" +
                "  \"quantity\":" + quantity + ",\n" +
                "  \"email\":\"" + email + "\"\n" +
                "}";
    }*/
}