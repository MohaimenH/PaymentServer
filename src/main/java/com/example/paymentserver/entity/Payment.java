package com.example.paymentserver.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic
    private int id;

    @Basic
    private String userId;

    @Basic
    private String itemId;

    @Basic
    private String paidAt = Instant.now().toString();

    @Basic
    private String method;

    @Basic
    private String uuid = String.valueOf(UUID.randomUUID());

    public Payment() {}

    public Payment(String userId, String itemId, String method) {
        this.userId = userId;
        this.itemId = itemId;
        this.method = method;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(String paidAt) {
        this.paidAt = paidAt;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
