package com.giocruz.salesadscommanderservice.infra.repository;

import com.giocruz.salesadscommanderservice.infra.entity.SaleAdJpaEntity;
import com.giocruz.salesadscommanderservice.domain.entity.SaleAd;
import com.giocruz.salesadscommanderservice.domain.repository.SaleAdRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SaleAdRepositoryDatabase implements SaleAdRepository {

    private JpaRepository<SaleAdJpaEntity, UUID> jpaRepository;


    @Override
    public void createSaleAd(SaleAd saleAd) {
        jpaRepository.saveAndFlush(SaleAdJpaEntity.convertFromDomain(saleAd));
    }
}
