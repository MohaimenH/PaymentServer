package com.example.paymentserver.service;

import com.example.paymentserver.entity.Payment;
import com.example.paymentserver.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }

    public Optional<Payment> getPaymentById(int id) {
        return paymentRepository.findById(id);
    }

    public Payment updatePayment(int id, Payment payment) {
        Optional<Payment> existingPaymentOptional = paymentRepository.findById(id);

        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();

            existingPayment.setUserId(payment.getUserId());
            existingPayment.setItemId(payment.getItemId());
            existingPayment.setPaidAt(payment.getPaidAt());
            existingPayment.setMethod(payment.getMethod());
            existingPayment.setUuid(payment.getUuid());

            return paymentRepository.save(existingPayment);
        } else {
            return paymentRepository.save(payment);
        }
    }

    public Optional<Payment> getPaymentByUUID(String uuid) {
       return paymentRepository.findByUuid(uuid);
    }

}
