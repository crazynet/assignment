package com.example.assignment.uniqordr;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Adjustment {
    public String adjustment;
    public String amount;
    public String desc;
    public String product;
    public String qty;
    public String basePrice;
    public String itemPrice;
    public List<Adjustment> adjustments;
}
