package com.squareup.square.utilities;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility to help with <a href="https://developer.squareup.com/docs/webhooks/overview">Square Webhooks</a>
 */
public class WebhooksHelper {
  private static final String HMAC_SHA_256 = "HmacSHA256";

  /**
   * Verifies and validates an event notification. See the <a href="https://developer.squareup.com/docs/webhooks/step3validate">documentation</a> for more details.
   *
   * @param requestBody     The JSON body of the request.
   * @param signatureHeader The value for the {@code x-square-hmacsha256-signature} header.
   * @param signatureKey    The signature key from the <a href="https://developer.squareup.com/apps">Square Developer portal</a> for the webhook subscription.
   * @param notificationUrl The notification endpoint URL as defined in the <a href="https://developer.squareup.com/apps">Square Developer portal</a> for the webhook subscription.
   * @return {@code true} if the signature is valid, indicating that the event can be trusted as it came from Square.<br/>
   * {@code false} if the signature validation fails, indicating that the event did not come from Square, so it may be malicious and should be discarded.
   */
  public static boolean isValidWebhookEventSignature(String requestBody, String signatureHeader,
      String signatureKey, String notificationUrl) {
    if (requestBody == null) {
      return false;
    }
    if (signatureKey == null || signatureKey.isEmpty()) {
      throw new IllegalArgumentException("signatureKey is null or empty");
    }
    if (notificationUrl == null || notificationUrl.isEmpty()) {
      throw new IllegalArgumentException("notificationUrl is null or empty");
    }

    String payload = notificationUrl.concat(requestBody);
    byte[] payloadBytes = payload.getBytes(StandardCharsets.UTF_8);
    byte[] signatureKeyBytes = signatureKey.getBytes(StandardCharsets.UTF_8);

    Mac mac;
    try {
      mac = Mac.getInstance(HMAC_SHA_256);
      SecretKeySpec secret = new SecretKeySpec(signatureKeyBytes, HMAC_SHA_256);
      mac.init(secret);
    } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalArgumentException e) {
      return false;
    }

    byte[] hashBytes = mac.doFinal(payloadBytes);
    String hashString = Base64.getEncoder().encodeToString(hashBytes);
    return hashString.equals(signatureHeader);
  }
}
