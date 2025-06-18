package com.application.talononeintegration.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class CartItem {

    private String sku;
    private int quantity;
    private String productName;
    private BigDecimal price;
    private String category;
    private Map<String, Object> attributes;
}
