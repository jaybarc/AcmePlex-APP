package Control;

import Entity.Payment;
import Entity.UserBankingInfo;

import java.util.Date;

public class PaymentController {

    private Payment payment;

    public PaymentController(Payment payment) {
        this.payment = payment;
    }

    /**
     * Processes a payment for a reservation.
     *
     * @param amount     The payment amount.
     * @param userBankingInfo The user's banking info.
     * @return The Payment object if successful.
     * @throws IllegalArgumentException if the payment fails.
     */
    public Payment processPayment(double amount, UserBankingInfo userBankingInfo) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount.");
        }
        if (userBankingInfo.getCardNumber() == null) {
            throw new IllegalArgumentException("Invalid card number.");
        }

        // Simulate payment processing (integration with a payment gateway would go here)
        boolean paymentSuccess = true; // Assume payment is always successful for simplicity

        if (paymentSuccess) {
            Payment payment = new Payment(
                    generatePaymentId(),
                    amount,
                    new Date(),
                    userBankingInfo
            );
            System.out.println("Payment successful: " + payment);
            return payment;
        } else {
            throw new IllegalArgumentException("Payment processing failed.");
        }
    }

    /**
     * Processes a refund for a cancelled reservation.
     *
     * @param amount   The amount to refund.
     * @param ticketId The ID of the ticket being refunded.
     * @return True if the refund is successful, false otherwise.
     */
    public boolean processRefund(double amount, String ticketId) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid refund amount.");
        }

        // Simulate refund processing
        boolean refundSuccess = true; // Assume refund is always successful for simplicity

        if (refundSuccess) {
            System.out.println("Refund successful for ticket ID: " + ticketId);
            return true;
        } else {
            System.out.println("Refund failed for ticket ID: " + ticketId);
            return false;
        }
    }

    /**
     * Generates a unique payment ID.
     *
     * @return A unique string identifier for the payment.
     */
    private String generatePaymentId() {
        return "PAY" + System.currentTimeMillis();
    }
}
