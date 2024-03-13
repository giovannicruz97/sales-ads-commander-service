package com.giocruz.salesadscommanderservice.domain.usecase;

import com.giocruz.salesadscommanderservice.domain.usecase.request.CreateSaleAdRequest;

public interface CreateSaleAdUseCase {
    public void execute(CreateSaleAdRequest request);
}
