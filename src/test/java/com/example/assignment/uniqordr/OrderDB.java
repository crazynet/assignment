package com.example.assignment.uniqordr;

import java.util.HashMap;
import java.util.Map;

public class OrderDB {
    static Map<CustomerOrderId, CustOrder> orderDB = new HashMap<CustomerOrderId, CustOrder>();

    public static void createRecord(CustOrder custOrder) {
        orderDB.put(CustomerOrderId.builder().outletId(custOrder.getOutletId()).productId(custOrder.getItem().get(0).getProduct()).qty(custOrder.getItem().get(0).getQty()).build(), custOrder);

    }

    public static CustOrder getUniqRecordByKey(CustomerOrderId key) {
        return orderDB.get(key);
    }

    public static int getTotalCnt() {
        return orderDB.size();
    }
}
