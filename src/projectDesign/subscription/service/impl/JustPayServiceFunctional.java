package projectDesign.subscription.service.impl;

import projectDesign.subscription.service.Order;
import projectDesign.subscription.service.PaymentMethods;

public class JustPayServiceFunctional implements PaymentMethods {
    Order order = () -> System.out.println("Order created");
    @Override
    public void cardPayment() {
        order.createOrder();
    }

    @Override
    public void netBankingPayment() {

    }

    @Override
    public void upiPayment() {

    }
}
