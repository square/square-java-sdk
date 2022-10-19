
package com.squareup.square;

import io.apimatic.core.authentication.HeaderAuth;
import java.util.Collections;

/**
 * Utility class for authorization and token management.
 */
public class BearerAuthManager extends HeaderAuth implements BearerAuthCredentials {

    private String accessToken;

    /**
     * Constructor.
     * @param accessToken String value for accessToken.
     */
    public BearerAuthManager(String accessToken) {
        super(Collections.singletonMap("Authorization",
                "Bearer " + accessToken));
        this.accessToken = accessToken;
    }

    /**
     * String value for accessToken.
     * @return accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Checks if provided credentials matched with existing ones.
     * @param accessToken String value for credentials.
     * @return true if credentials matched.
     */
    public boolean equals(String accessToken) {
        return accessToken.equals(getAccessToken());
    }

    /**
     * Converts this BearerAuthManager into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BearerAuthManager [" + "accessToken=" + accessToken + "]";
    }

}