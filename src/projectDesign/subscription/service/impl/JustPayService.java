package projectDesign.subscription.service.impl;

import projectDesign.subscription.service.Order;
import projectDesign.subscription.service.PaymentMethods;

public class JustPayService implements PaymentMethods, Order{
    @Override
    public void createOrder() {
        System.out.println("Order created");
    }

    @Override
    public void cardPayment() {
        System.out.println("Doing payment via card");
    }

    @Override
    public void netBankingPayment() {
        System.out.println("Doing payment via net banking");
    }

    @Override
    public void upiPayment() {
        System.out.println("Doing payment via upi banking");
    }
}
