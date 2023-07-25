package com.guagua.windphotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MainRepository<T, ID> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
