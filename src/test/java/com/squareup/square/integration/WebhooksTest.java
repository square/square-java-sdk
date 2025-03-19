package com.squareup.square.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.utilities.WebhooksHelper;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class WebhooksTest {
    private static final String REQUEST_BODY =
            "{\"merchant_id\":\"MLEFBHHSJGVHD\",\"type\":\"webhooks.test_notification\",\"event_id\":\"ac3ac95b-f97d-458c-a6e6-18981597e05f\",\"created_at\":\"2022-07-13T20:30:59.037339943Z\",\"data\":{\"type\":\"webhooks\",\"id\":\"bc368e64-01aa-407e-b46e-3231809b1129\"}}";
    private static final String SIGNATURE_HEADER = "GF4YkrJgGBDZ9NIYbNXBnMzqb2HoL4RW/S6vkZ9/2N4=";
    private static final String SIGNATURE_KEY = "Ibxx_5AKakO-3qeNVR61Dw";
    private static final String NOTIFICATION_URL = "https://webhook.site/679a4f3a-dcfa-49ee-bac5-9d0edad886b9";

    @Test
    public void testSignatureValidationPass() {
        boolean isValid =
                WebhooksHelper.verifySignature(REQUEST_BODY, SIGNATURE_HEADER, SIGNATURE_KEY, NOTIFICATION_URL);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testSignatureUnescapedCharsValidationPass() {
        String url = "https://webhook.site/webhooks";
        String sigKey = "signature-key";
        String specialCharacterBody = "{\"data\":{\"type\":\"webhooks\",\"id\":\"fake_id\"}}";
        String expectedSignatureHeader = "W3FlCNk5IA3ZQ2LHTWoajvzfaDu/OwY2tNHIHC3IUOA=";

        boolean isValid = WebhooksHelper.verifySignature(specialCharacterBody, expectedSignatureHeader, sigKey, url);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testSignatureWithEscapedCharacters() {
        String url = "https://webhook.site/webhooks";
        String sigKey = "signature-key";
        String specialCharacterBody = "{\"data\":{\"type\":\"webhooks\",\"id\":\">id<\"}}";
        String expectedSignatureHeader = "Cxt7+aTi4rKgcA0bC4g9EHdVtLSDWdqccmL5MvihU4U=";

        boolean isValid = WebhooksHelper.verifySignature(specialCharacterBody, expectedSignatureHeader, sigKey, url);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testSignatureValidationFailsOnNotificationUrlMismatch() {
        boolean isValid = WebhooksHelper.verifySignature(
                REQUEST_BODY,
                SIGNATURE_HEADER,
                SIGNATURE_KEY,
                "https://webhook.site/79a4f3a-dcfa-49ee-bac5-9d0edad886b9");
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testSignatureValidationFailsOnInvalidSignatureKey() {
        boolean isValid = WebhooksHelper.verifySignature(
                REQUEST_BODY, SIGNATURE_HEADER, "MCmhFRxGX82xMwg5FsaoQA", NOTIFICATION_URL);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testSignatureValidationFailsOnInvalidSignatureHeader() {
        boolean isValid = WebhooksHelper.verifySignature(
                REQUEST_BODY, "1z2n3DEJJiUPKcPzQo1ftvbxGdw=", SIGNATURE_KEY, NOTIFICATION_URL);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testSignatureValidationFailsOnRequestBodyMismatch() {
        boolean isValid = WebhooksHelper.verifySignature(
                "{\"merchant_id\":\"MLEFBHHSJGVHD\",\"type\":\"webhooks.test_notification\",\"event_id\":\"ac3ac95b-f97d-458c-a6e6-18981597e05f\",\"created_at\":\"2022-06-13T20:30:59.037339943Z\",\"data\":{\"type\":\"webhooks\",\"id\":\"bc368e64-01aa-407e-b46e-3231809b1129\"}}",
                SIGNATURE_HEADER,
                SIGNATURE_KEY,
                NOTIFICATION_URL);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testSignatureValidationFailsOnRequestBodyFormatted() {
        String requestBody;
        try {
            requestBody = ObjectMappers.JSON_MAPPER.writeValueAsString(new HashMap<String, Object>() {
                {
                    put("merchant_id", "MLEFBHHSJGVHD");
                    put("type", "webhooks.test_notification");
                    put("event_id", "ac3ac95b-f97d-458c-a6e6-18981597e05f");
                    put("created_at", "2022-07-13T20:30:59.037339943Z");
                    put("data", new HashMap<String, Object>() {
                        {
                            put("type", "webhooks");
                            put("id", "bc368e64-01aa-407e-b46e-3231809b1129");
                        }
                    });
                }
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        boolean isValid =
                WebhooksHelper.verifySignature(requestBody, SIGNATURE_HEADER, SIGNATURE_KEY, NOTIFICATION_URL);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testThrowsErrorOnEmptySignatureKey() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            WebhooksHelper.verifySignature(REQUEST_BODY, SIGNATURE_HEADER, "", NOTIFICATION_URL);
        });
        Assertions.assertEquals("signatureKey is null or empty", e.getMessage());
    }

    @Test
    public void testThrowsErrorOnEmptyNotificationUrl() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            WebhooksHelper.verifySignature(REQUEST_BODY, SIGNATURE_HEADER, SIGNATURE_KEY, "");
        });
        Assertions.assertEquals("notificationUrl is null or empty", e.getMessage());
    }
}
