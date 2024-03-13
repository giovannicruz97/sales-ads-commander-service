package com.giocruz.salesadscommanderservice.infra.entity;

import com.giocruz.salesadscommanderservice.domain.entity.SaleAd;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class SaleAdJpaEntity {
    @Id
    private UUID id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, length = 255)
    private String url;

    @Column(nullable = false, length = 255)
    private String image;

    @Column(nullable = false)
    private Timestamp lifetime;

    @Column(nullable = false)
    private Boolean active;

    public SaleAdJpaEntity(UUID id, BigDecimal price, String url, String image, Timestamp lifetime, Boolean active) {
        this.id = id;
        this.price = price;
        this.url = url;
        this.image = image;
        this.lifetime = lifetime;
        this.active = active;
    }

    public SaleAdJpaEntity() {

    }

    public static SaleAdJpaEntity convertFromDomain(SaleAd saleAd) {
        return new SaleAdJpaEntity(
                saleAd.getId(),
                saleAd.getPrice(),
                saleAd.getUrl(),
                saleAd.getImage(),
                new Timestamp(saleAd.getLifetime().getTimeInMillis()),
                saleAd.getActive()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getLifetime() {
        return lifetime;
    }

    public void setLifetime(Timestamp lifetime) {
        this.lifetime = lifetime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
