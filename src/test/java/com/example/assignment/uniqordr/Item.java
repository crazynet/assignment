package com.example.assignment.uniqordr;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Item {
    public String product;
    public String desc;
    public String qty;
    public String basePrice;
    public String itemPrice;
    public List<Adjustment> adjustments;
}
