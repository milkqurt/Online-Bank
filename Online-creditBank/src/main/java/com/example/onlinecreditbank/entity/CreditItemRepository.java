package com.example.onlinecreditbank.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditItemRepository extends JpaRepository<CreditItem,Long> {
}
