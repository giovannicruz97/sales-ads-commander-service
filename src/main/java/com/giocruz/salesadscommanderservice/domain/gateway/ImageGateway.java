package com.giocruz.salesadscommanderservice.domain.gateway;

public interface ImageGateway {
    public String saveImageToStorage(String base64Image);
}
