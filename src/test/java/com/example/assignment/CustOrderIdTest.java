package com.example.assignment;


import com.example.assignment.uniqordr.Adjustment;
import com.example.assignment.uniqordr.CustOrder;
import com.example.assignment.uniqordr.CustomerOrderId;
import com.example.assignment.uniqordr.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.example.assignment.uniqordr.OrderDB.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustOrderIdTest {


    @Test
    void createOrder() throws IOException {
        CustOrder custOrder = getCustOrderTestData();
        createOrder(custOrder);
        createOrder(custOrder);
        createOrder(custOrder);
        createOrder(custOrder);
        assertEquals(1,getTotalCnt());
    }

    private CustOrder getCustOrderTestData() {
        Adjustment adj = Adjustment.builder().adjustment("").desc("adjustment desc").amount("0.00").build();
        Item item = Item.builder()
                .product("12345678901234")
                .desc("ABCD 12 pack")
                .qty("1")
                .basePrice("5.00")
                .itemPrice("0.00")
                .adjustments(List.of(adj))
                .build();
        CustOrder custOrder = CustOrder.builder()
                .outletId("001234567")
                .netInvoice("30.25")
                .deliveryFee("10.00")
                .movFee("15.00")
                .totalTax("0.25")
                .totalCouponDiscount("5.00")
                .totalOrderValuePostDiscount("5.00")
                .totalDiscount("0.0")
                .totalOrderValue("5.00").item(List.of(item))
                .build();
        return custOrder;
    }

    private synchronized void createOrder(CustOrder custOrder) {
        if (getUniqRecordByKey(CustomerOrderId.builder().outletId(custOrder.getOutletId()).productId(custOrder.getItem().get(0).getProduct()).qty(custOrder.getItem().get(0).getQty()).build()) == null) {
            System.out.println("creatae a new record " + custOrder.getOutletId());
            createRecord(custOrder);
        } else {
            System.out.println("record already exists " + custOrder.getOutletId());
        }
        System.out.println(getUniqRecordByKey(CustomerOrderId.builder().outletId(custOrder.getOutletId()).productId(custOrder.getItem().get(0).getProduct()).qty(custOrder.getItem().get(0).getQty()).build()));
    }


}
