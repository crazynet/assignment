package com.example.assignment.uniqordr;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CustomerOrderId {
    private String outletId;
    private String productId;
    private String qty;

    @Override
    public int hashCode() {
        return Objects.hash(outletId, productId, qty);
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode()==obj.hashCode();
    }
}
