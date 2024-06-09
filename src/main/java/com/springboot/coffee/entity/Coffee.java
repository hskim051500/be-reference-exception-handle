package com.springboot.coffee.entity;

import com.springboot.values.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coffee {
    private long coffeeId;
    private String korName;
    private String engName;
    private Money price;
}
