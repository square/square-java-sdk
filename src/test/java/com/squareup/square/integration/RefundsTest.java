package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SquareApiException;
import com.squareup.square.core.SyncPage;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.CreatePaymentRequest;
import com.squareup.square.types.CreatePaymentResponse;
import com.squareup.square.types.GetPaymentRefundResponse;
import com.squareup.square.types.GetRefundsRequest;
import com.squareup.square.types.ListRefundsRequest;
import com.squareup.square.types.Payment;
import com.squareup.square.types.PaymentRefund;
import com.squareup.square.types.RefundPaymentRequest;
import com.squareup.square.types.RefundPaymentResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class RefundsTest {
    private SquareClient client;
    private String paymentId;
    private String refundId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Create payment for testing refunds
        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .sourceId("cnon:card-nonce-ok")
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .appFeeMoney(Helpers.newTestMoney(10))
                .autocomplete(true)
                .build();
        CreatePaymentResponse paymentResponse = client.payments().create(paymentRequest);
        Optional<Payment> payment = paymentResponse.getPayment();
        if (!payment.isPresent()) {
            throw new RuntimeException("Payment or Payment ID is null.");
        }
        if (!payment.get().getId().isPresent()) {
            throw new RuntimeException("Payment ID is null.");
        }
        paymentId = payment.get().getId().get();

        // Create initial refund for testing
        RefundPaymentRequest refundRequest = RefundPaymentRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .paymentId(paymentId)
                .build();
        RefundPaymentResponse refundResponse = client.refunds().refundPayment(refundRequest);
        Optional<PaymentRefund> refund = refundResponse.getRefund();
        if (!refund.isPresent()) {
            throw new RuntimeException("Refund is null.");
        }

        refundId = refund.get().getId();
    }

    @Test
    public void testListPaymentRefunds() {
        ListRefundsRequest listRequest = ListRefundsRequest.builder().build();
        SyncPagingIterable<PaymentRefund> response = client.refunds().list(listRequest);
        SyncPage<PaymentRefund> page = response.nextPage();
        List<PaymentRefund> refunds = page.getItems();
        Assertions.assertFalse(refunds.isEmpty());
    }

    @Test
    public void testRefundPayment() {
        // Create new payment to refund
        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .sourceId("cnon:card-nonce-ok")
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .appFeeMoney(Helpers.newTestMoney(10))
                .autocomplete(true)
                .build();
        CreatePaymentResponse paymentResponse = client.payments().create(paymentRequest);
        Optional<Payment> payment = paymentResponse.getPayment();
        if (!payment.isPresent()) {
            throw new RuntimeException("Payment or Payment ID is null.");
        }
        if (!payment.get().getId().isPresent()) {
            throw new RuntimeException("Payment ID is null.");
        }
        paymentId = payment.get().getId().get();

        RefundPaymentRequest refundRequest = RefundPaymentRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .paymentId(paymentId)
                .build();
        RefundPaymentResponse response = client.refunds().refundPayment(refundRequest);

        Assertions.assertTrue(response.getRefund().isPresent());
        Assertions.assertEquals(
                paymentId, response.getRefund().get().getPaymentId().get());
    }

    @Test
    public void testGetPaymentRefund() {
        GetPaymentRefundResponse response = client.refunds()
                .get(GetRefundsRequest.builder().refundId(refundId).build());

        Assertions.assertTrue(response.getRefund().isPresent());
        Assertions.assertEquals(refundId, response.getRefund().get().getId());
        Assertions.assertEquals(
                paymentId, response.getRefund().get().getPaymentId().get());
    }

    @Test
    public void testHandleInvalidRefundId() {
        Assertions.assertThrows(SquareApiException.class, () -> {
            client.refunds()
                    .get(GetRefundsRequest.builder().refundId("invalid-id").build());
        });
    }
}
