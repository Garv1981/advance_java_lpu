package com.prac;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UPI implements PaymentService {

    private final TransactionLogger logger;

    public UPI(TransactionLogger logger){
        this.logger = logger;
    }

    @Override
    public void processPayment(double amount){
        logger.log("UPI payment: " + amount);
        System.out.println("Paid via UPI");
    }
}