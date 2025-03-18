package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.core.Environment;

public final class TestClientFactory {
    public static SquareClient create() {
        return SquareClient.builder()
                .environment(Environment.SANDBOX)
                .token(token())
                .build();
    }

    public static SquareClient create(int maxRetries) {
        return SquareClient.builder()
                .environment(Environment.SANDBOX)
                .token(token())
                .maxRetries(maxRetries)
                .build();
    }

    private static String token() {
        String token = System.getenv("TEST_SQUARE_TOKEN");

        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Please provide an API key to run tests");
        }

        return token;
    }
}
