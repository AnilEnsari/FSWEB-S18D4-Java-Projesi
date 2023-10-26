package com.example.onetomany.dto;

public record AccountResponse(int id, String accountName, double moneyAmount, CustomerResponse customerResponse) {
}
