package com.giocruz.salesadscommanderservice.domain.usecase.impl;

import com.giocruz.salesadscommanderservice.domain.gateway.ImageGateway;
import com.giocruz.salesadscommanderservice.domain.entity.SaleAd;
import com.giocruz.salesadscommanderservice.domain.repository.SaleAdRepository;
import com.giocruz.salesadscommanderservice.domain.usecase.request.CreateSaleAdRequest;
import com.giocruz.salesadscommanderservice.domain.usecase.CreateSaleAdUseCase;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Calendar;

@Service
public class CreateSaleAdUseCaseImpl implements CreateSaleAdUseCase {

    private SaleAdRepository saleAdRepository;
    private ImageGateway imageGateway;

    private String generateUrl(String description, BigDecimal price) {
        return BCrypt.hashpw(description + price.toString() + Instant.now().toString(), BCrypt.gensalt());
    }

    @Override
    public void execute(CreateSaleAdRequest request) {
        String url = generateUrl(request.description(), request.price());
        String image = imageGateway.saveImageToStorage(request.image());
        Calendar lifetime = Calendar.getInstance();
        lifetime.setTimeInMillis(request.lifetime());
        Boolean active = true;
        SaleAd newSaleAd = new SaleAd(
                request.description(),
                request.price(),
                url,
                image,
                lifetime,
                active
        );
        saleAdRepository.createSaleAd(newSaleAd);
    }
}
