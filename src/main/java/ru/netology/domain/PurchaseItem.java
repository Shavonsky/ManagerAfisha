package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PurchaseItem {
    private int id;
    private int productId;
    private String productName;
    private int productPrice;
    private int count;

    public PurchaseItem(int id, int productId, String productName, int productPrice, int count) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.count = count;
    }

    public int getId() {
        return id;
    }
}
