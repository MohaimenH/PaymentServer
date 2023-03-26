package com.example.paymentserver.controller;

import com.example.paymentserver.entity.Payment;
import com.example.paymentserver.facade.PaymentFacade;
import com.example.paymentserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentFacade paymentFacade;

    @PostMapping("/")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentFacade.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Payment>> getAllPayments() {
        Iterable<Payment> payments = paymentFacade.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        Optional<Payment> paymentOptional = paymentFacade.getPaymentById(id);

        if (paymentOptional.isPresent()) {
            return new ResponseEntity<>(paymentOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<Payment> getPaymentByUUID(@PathVariable String uuid) {
        Optional<Payment> paymentOptional = paymentFacade.getPaymentByUUID(uuid);

        if (paymentOptional.isPresent()) {
            return new ResponseEntity<>(paymentOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        Payment updatedPayment = paymentFacade.updatePayment(id, payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable int id) {
        paymentFacade.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
