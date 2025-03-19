package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.disputes.types.DeleteEvidenceRequest;
import com.squareup.square.disputes.types.GetEvidenceRequest;
import com.squareup.square.disputes.types.ListEvidenceRequest;
import com.squareup.square.types.AcceptDisputeResponse;
import com.squareup.square.types.AcceptDisputesRequest;
import com.squareup.square.types.CardBrand;
import com.squareup.square.types.CreateDisputeEvidenceFileRequest;
import com.squareup.square.types.CreateDisputeEvidenceFileResponse;
import com.squareup.square.types.CreateDisputeEvidenceTextRequest;
import com.squareup.square.types.CreateDisputeEvidenceTextResponse;
import com.squareup.square.types.CreateEvidenceFileDisputesRequest;
import com.squareup.square.types.CreatePaymentRequest;
import com.squareup.square.types.DeleteDisputeEvidenceResponse;
import com.squareup.square.types.Dispute;
import com.squareup.square.types.DisputeEvidence;
import com.squareup.square.types.DisputeEvidenceType;
import com.squareup.square.types.DisputeReason;
import com.squareup.square.types.DisputeState;
import com.squareup.square.types.GetDisputeEvidenceResponse;
import com.squareup.square.types.GetDisputeResponse;
import com.squareup.square.types.GetDisputesRequest;
import com.squareup.square.types.ListDisputesRequest;
import com.squareup.square.types.SubmitEvidenceDisputesRequest;
import com.squareup.square.types.SubmitEvidenceResponse;
import java.io.File;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class DisputesTest {
    private SquareClient client;
    private String disputeId;
    private String textEvidenceId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Create a payment that will generate a dispute
        client.payments()
                .create(CreatePaymentRequest.builder()
                        .sourceId("cnon:card-nonce-ok")
                        .idempotencyKey(UUID.randomUUID().toString())
                        .amountMoney(Helpers.newTestMoney(8803))
                        .build());

        // Poll for dispute to be created
        for (int i = 0; i < 100; i++) {
            SyncPagingIterable<Dispute> disputeResponse = client.disputes()
                    .list(ListDisputesRequest.builder()
                            .states(DisputeState.EVIDENCE_REQUIRED)
                            .build());
            if (!disputeResponse.getItems().isEmpty()) {
                if (!disputeResponse.getItems().get(0).getId().isPresent()) {
                    throw new RuntimeException("Could not get dispute ID");
                }
                disputeId = disputeResponse.getItems().get(0).getId().get();
                break;
            }
            // Wait for 2 seconds before polling again
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (disputeId == null) {
            throw new RuntimeException("Dispute was not created within the expected time frame.");
        }

        // Create evidence text for testing
        CreateDisputeEvidenceTextResponse evidenceResponse = client.disputes()
                .createEvidenceText(CreateDisputeEvidenceTextRequest.builder()
                        .disputeId(disputeId)
                        .idempotencyKey(UUID.randomUUID().toString())
                        .evidenceText("This is not a duplicate")
                        .evidenceType(DisputeEvidenceType.GENERIC_EVIDENCE)
                        .build());
        Optional<DisputeEvidence> evidence = evidenceResponse.getEvidence();
        if (!evidence.isPresent()) {
            throw new RuntimeException("Evidence was not created within the expected time frame.");
        }
        if (!evidence.get().getId().isPresent()) {
            throw new RuntimeException("Evidence ID is null.");
        }
        textEvidenceId = evidence.get().getId().get();
    }

    @AfterEach
    public void after() {
        // Clean up evidence if it exists
        try {
            client.disputes()
                    .evidence()
                    .delete(DeleteEvidenceRequest.builder()
                            .disputeId(disputeId)
                            .evidenceId(textEvidenceId)
                            .build());
        } catch (Exception e) {
            // Evidence might already be deleted by test
        }
    }

    @Test
    public void testListDisputes() {
        SyncPagingIterable<Dispute> response = client.disputes()
                .list(ListDisputesRequest.builder()
                        .states(DisputeState.EVIDENCE_REQUIRED)
                        .build());
        Assertions.assertFalse(response.getItems().isEmpty());
        Assertions.assertEquals(
                DisputeReason.DUPLICATE, response.getItems().get(0).getReason().get());
        Assertions.assertEquals(
                DisputeState.EVIDENCE_REQUIRED,
                response.getItems().get(0).getState().get());
        Assertions.assertEquals(
                CardBrand.VISA, response.getItems().get(0).getCardBrand().get());
    }

    @Test
    public void testRetrieveDispute() {
        GetDisputeResponse response = client.disputes()
                .get(GetDisputesRequest.builder().disputeId(disputeId).build());
        Assertions.assertTrue(response.getDispute().isPresent());
        Assertions.assertEquals(disputeId, response.getDispute().get().getId().get());
    }

    @Test
    public void testCreateDisputeEvidenceText() {
        CreateDisputeEvidenceTextResponse response = client.disputes()
                .createEvidenceText(CreateDisputeEvidenceTextRequest.builder()
                        .disputeId(disputeId)
                        .idempotencyKey(UUID.randomUUID().toString())
                        .evidenceText("This is not a duplicate")
                        .evidenceType(DisputeEvidenceType.GENERIC_EVIDENCE)
                        .build());
        Assertions.assertTrue(response.getEvidence().isPresent());
    }

    @Test
    public void testRetrieveDisputeEvidence() {
        GetDisputeEvidenceResponse response = client.disputes()
                .evidence()
                .get(GetEvidenceRequest.builder()
                        .disputeId(disputeId)
                        .evidenceId(textEvidenceId)
                        .build());
        Assertions.assertTrue(response.getEvidence().isPresent());
        Assertions.assertEquals(
                textEvidenceId, response.getEvidence().get().getId().get());
    }

    @Test
    public void testListDisputeEvidence() {
        SyncPagingIterable<DisputeEvidence> response = client.disputes()
                .evidence()
                .list(ListEvidenceRequest.builder().disputeId(disputeId).build());
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testDeleteDisputeEvidence() {
        DeleteDisputeEvidenceResponse response = client.disputes()
                .evidence()
                .delete(DeleteEvidenceRequest.builder()
                        .disputeId(disputeId)
                        .evidenceId(textEvidenceId)
                        .build());
        Assertions.assertNotNull(response);
    }

    @Test
    public void testCreateDisputeEvidenceFile() {
        File imageFile = Helpers.getTestFile();

        CreateDisputeEvidenceFileResponse response = client.disputes()
                .createEvidenceFile(CreateEvidenceFileDisputesRequest.builder()
                        .disputeId(disputeId)
                        .imageFile(imageFile)
                        .request(CreateDisputeEvidenceFileRequest.builder()
                                .idempotencyKey(UUID.randomUUID().toString())
                                .contentType("image/jpeg")
                                .evidenceType(DisputeEvidenceType.GENERIC_EVIDENCE)
                                .build())
                        .build());

        Assertions.assertTrue(response.getEvidence().isPresent());
        Assertions.assertEquals(
                disputeId, response.getEvidence().get().getDisputeId().get());
    }

    @Test
    public void testSubmitEvidence() {
        SubmitEvidenceResponse response = client.disputes()
                .submitEvidence(SubmitEvidenceDisputesRequest.builder()
                        .disputeId(disputeId)
                        .build());
        Assertions.assertNotNull(response);
    }

    @Test
    public void testAcceptDispute() {
        AcceptDisputeResponse response = client.disputes()
                .accept(AcceptDisputesRequest.builder().disputeId(disputeId).build());
        Assertions.assertNotNull(response);
    }
}
