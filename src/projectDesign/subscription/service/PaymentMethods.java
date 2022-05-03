package projectDesign.subscription.service;

public interface PaymentMethods {
    void cardPayment();
    void netBankingPayment();
    void upiPayment();
}
