package com.giocruz.salesadscommanderservice.domain.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.UUID;

public class SaleAd {

    private final UUID id;
    private String description;
    private BigDecimal price;
    private String url;
    private String image;
    private Calendar lifetime;
    private Boolean active;

    public SaleAd(String description, BigDecimal price, String url, String image, Calendar lifetime, Boolean active) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.price = price;
        this.url = url;
        this.image = image;
        this.lifetime = lifetime;
        this.active = active;
    }


    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public Calendar getLifetime() {
        return lifetime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLifetime(Calendar lifetime) {
        this.lifetime = lifetime;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
