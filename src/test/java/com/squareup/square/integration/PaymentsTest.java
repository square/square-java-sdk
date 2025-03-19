package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPage;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.CancelPaymentByIdempotencyKeyRequest;
import com.squareup.square.types.CancelPaymentByIdempotencyKeyResponse;
import com.squareup.square.types.CancelPaymentResponse;
import com.squareup.square.types.CancelPaymentsRequest;
import com.squareup.square.types.CompletePaymentRequest;
import com.squareup.square.types.CompletePaymentResponse;
import com.squareup.square.types.CreatePaymentRequest;
import com.squareup.square.types.CreatePaymentResponse;
import com.squareup.square.types.GetPaymentResponse;
import com.squareup.square.types.GetPaymentsRequest;
import com.squareup.square.types.ListPaymentsRequest;
import com.squareup.square.types.Payment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class PaymentsTest {
    private SquareClient client;
    private String paymentId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
        // Create initial payment for testing
        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .sourceId("cnon:card-nonce-ok")
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .appFeeMoney(Helpers.newTestMoney(10))
                .autocomplete(false)
                .build();
        CreatePaymentResponse paymentResponse = client.payments().create(paymentRequest);
        Optional<Payment> payment = paymentResponse.getPayment();
        if (!payment.isPresent()) {
            throw new RuntimeException("Payment ID is null.");
        }
        if (!payment.get().getId().isPresent()) {
            throw new RuntimeException("Payment ID is null.");
        }
        paymentId = payment.get().getId().get();
    }

    @Test
    public void testListPayments() {
        ListPaymentsRequest listRequest = ListPaymentsRequest.builder().build();
        SyncPagingIterable<Payment> response = client.payments().list(listRequest);
        SyncPage<Payment> page = response.nextPage();
        List<Payment> payments = page.getItems();
        Assertions.assertFalse(payments.isEmpty());
    }

    @Test
    public void testCreatePayment() {
        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .sourceId("cnon:card-nonce-ok")
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .appFeeMoney(Helpers.newTestMoney(10))
                .autocomplete(false)
                .build();
        CreatePaymentResponse response = client.payments().create(paymentRequest);

        Assertions.assertTrue(response.getPayment().isPresent());
        Assertions.assertTrue(response.getPayment().get().getAppFeeMoney().isPresent());
        Assertions.assertEquals(
                10,
                response.getPayment().get().getAppFeeMoney().get().getAmount().get());
        Assertions.assertEquals(
                "USD",
                response.getPayment()
                        .get()
                        .getAppFeeMoney()
                        .get()
                        .getCurrency()
                        .get()
                        .toString());
        Assertions.assertTrue(response.getPayment().get().getAmountMoney().isPresent());
        Assertions.assertEquals(
                200,
                response.getPayment().get().getAmountMoney().get().getAmount().get());
        Assertions.assertEquals(
                "USD",
                response.getPayment()
                        .get()
                        .getAmountMoney()
                        .get()
                        .getCurrency()
                        .get()
                        .toString());
    }

    @Test
    public void testGetPayment() {
        GetPaymentResponse response = client.payments()
                .get(GetPaymentsRequest.builder().paymentId(paymentId).build());

        Assertions.assertTrue(response.getPayment().isPresent());
        Assertions.assertEquals(paymentId, response.getPayment().get().getId().get());
    }

    @Test
    public void testCancelPayment() {
        CancelPaymentResponse response = client.payments()
                .cancel(CancelPaymentsRequest.builder().paymentId(paymentId).build());

        Assertions.assertTrue(response.getPayment().isPresent());
        Assertions.assertEquals(paymentId, response.getPayment().get().getId().get());
    }

    @Test
    public void testCancelPaymentByIdempotencyKey() {
        String idempotencyKey = UUID.randomUUID().toString();

        // Create payment to cancel
        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .sourceId("cnon:card-nonce-ok")
                .idempotencyKey(idempotencyKey)
                .amountMoney(Helpers.newTestMoney(200))
                .appFeeMoney(Helpers.newTestMoney(10))
                .autocomplete(false)
                .build();
        client.payments().create(paymentRequest);

        // Cancel by idempotency key
        CancelPaymentByIdempotencyKeyRequest cancelRequest = CancelPaymentByIdempotencyKeyRequest.builder()
                .idempotencyKey(idempotencyKey)
                .build();
        CancelPaymentByIdempotencyKeyResponse response = client.payments().cancelByIdempotencyKey(cancelRequest);

        Assertions.assertNotNull(response);
    }

    @Test
    public void testCompletePayment() {
        // Create payment to complete
        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .sourceId("cnon:card-nonce-ok")
                .idempotencyKey(UUID.randomUUID().toString())
                .amountMoney(Helpers.newTestMoney(200))
                .appFeeMoney(Helpers.newTestMoney(10))
                .autocomplete(false)
                .build();
        CreatePaymentResponse createResponse = client.payments().create(paymentRequest);

        Optional<Payment> payment = createResponse.getPayment();
        if (!payment.isPresent()) {
            throw new RuntimeException("Payment ID is null.");
        }

        if (!payment.get().getId().isPresent()) {
            throw new RuntimeException("Payment ID is null.");
        }

        paymentId = payment.get().getId().get();
        CompletePaymentResponse response = client.payments()
                .complete(CompletePaymentRequest.builder().paymentId(paymentId).build());

        Assertions.assertTrue(response.getPayment().isPresent());
        Assertions.assertEquals(
                "COMPLETED", response.getPayment().get().getStatus().get());
    }
}
