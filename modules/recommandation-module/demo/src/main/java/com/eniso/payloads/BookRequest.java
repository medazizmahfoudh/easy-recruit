package com.eniso.payloads;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class BookRequest {

    private String title;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
