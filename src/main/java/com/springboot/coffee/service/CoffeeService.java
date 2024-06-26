package com.springboot.coffee.service;

import com.springboot.coffee.entity.Coffee;
import com.springboot.values.Money;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee findCoffee(long coffeeId) {
        return new Coffee(coffeeId, "아메리카노", "Americano", new Money(2500));
    }

    public List<Coffee> findCoffees() {
        return List.of(
                new Coffee(1L, "아메리카노", "Americano", new Money(2500)),
                new Coffee(2L, "카라멜 라떼", "Caramel Latte", new Money(5000))
        );
    }

    public void deleteCoffee(long coffeeId) {
    }
}
