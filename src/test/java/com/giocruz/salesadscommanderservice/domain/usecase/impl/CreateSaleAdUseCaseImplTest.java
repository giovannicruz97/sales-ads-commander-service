package com.giocruz.salesadscommanderservice.domain.usecase.impl;

import com.giocruz.salesadscommanderservice.domain.entity.SaleAd;
import com.giocruz.salesadscommanderservice.domain.gateway.ImageGateway;
import com.giocruz.salesadscommanderservice.domain.repository.SaleAdRepository;
import com.giocruz.salesadscommanderservice.domain.usecase.request.CreateSaleAdRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateSaleAdUseCaseImplTest {

    @Mock
    private SaleAdRepository saleAdRepository;

    @Mock
    private ImageGateway imageGateway;

    @InjectMocks
    private CreateSaleAdUseCaseImpl createSaleAdUseCase;

    @BeforeEach
    public void setUp() {
        // Configurar o comportamento dos mocks antes de cada teste, se necessário
    }

    @Test
    public void testExecute() {
        // Configurar os mocks
        CreateSaleAdRequest request = new CreateSaleAdRequest(
                "Test Description",
                BigDecimal.valueOf(100),
                "test-image",
                Calendar.getInstance().getTimeInMillis()
        );
        when(imageGateway.saveImageToStorage(any())).thenReturn("url-to-image");

        // Chamar o método a ser testado
        createSaleAdUseCase.execute(request);

        // Verificar se o método correto do SaleAdRepository foi chamado com os parâmetros corretos
        verify(saleAdRepository).createSaleAd(any(SaleAd.class));
    }
}
