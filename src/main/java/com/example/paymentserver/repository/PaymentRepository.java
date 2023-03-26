package com.example.paymentserver.repository;

import com.example.paymentserver.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    Optional<Payment> findByUuid(String uuid);
}
