package com.example.paymentserver.facade;

import com.example.paymentserver.entity.Payment;
import com.example.paymentserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class PaymentFacade {
    @Autowired
    private PaymentService paymentService;

    public Payment createPayment(Payment payment) {
        return paymentService.savePayment(payment);
    }
    public Optional<Payment> getPaymentById(int id) {
        return paymentService.getPaymentById(id);
    }

    public Iterable<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    public Payment updatePayment(int id, Payment payment) {
        return paymentService.updatePayment(id, payment);
    }

    public void deletePayment(int id) {
        paymentService.deletePayment(id);
    }

    public Optional<Payment> getPaymentByUUID(String UUID) {
        return paymentService.getPaymentByUUID(UUID);
    }
}
