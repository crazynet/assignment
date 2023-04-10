package com.example.assignment.uniqordr;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class CustOrder {
    public String totalOrderValue;
    public String totalDiscount;
    public String totalOrderValuePostDiscount;
    public String totalCouponDiscount;
    public String totalTax;
    public String movFee;
    public String deliveryFee;
    public String netInvoice;
    public String outletId;
    public List<Item> item;
}

