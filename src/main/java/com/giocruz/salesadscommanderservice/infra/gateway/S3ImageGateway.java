package com.giocruz.salesadscommanderservice.infra.gateway;

import com.giocruz.salesadscommanderservice.domain.gateway.ImageGateway;
import org.springframework.stereotype.Component;

@Component
public class S3ImageGateway implements ImageGateway {
    @Override
    public String saveImageToStorage(String base64Image) {
        return "show";
    }
}
