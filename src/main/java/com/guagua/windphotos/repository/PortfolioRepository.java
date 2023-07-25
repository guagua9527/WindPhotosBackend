package com.guagua.windphotos.repository;

import com.guagua.windphotos.entity.Portfolio;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends MainRepository<Portfolio, Integer> {
}
