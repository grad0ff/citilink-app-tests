package ru.citilink.enums;

import java.util.Random;

public enum Cities {
    MOSCOW("Москва"),
    SPB("Санкт-Петербург"),
    KAZAN("Казань"),
    UFA("Уфа");

    private static final Cities[] cities = Cities.values();
    private final String cityName;

    Cities(String cityName) {
        this.cityName = cityName;
    }

    public static Cities getRandomCity() {
        int randomNum = new Random().nextInt(cities.length);
        return cities[randomNum];
    }

    @Override
    public String toString() {
        return this.cityName;
    }
}
