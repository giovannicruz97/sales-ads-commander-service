package com.giocruz.salesadscommanderservice.domain.usecase.request;

import java.math.BigDecimal;

public record CreateSaleAdRequest(String description, BigDecimal price, String image, Long lifetime) {}
