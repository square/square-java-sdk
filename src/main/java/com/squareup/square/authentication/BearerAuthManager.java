
package com.squareup.square.authentication;

import com.squareup.square.BearerAuthCredentials;
import io.apimatic.core.authentication.HeaderAuth;
import java.util.Collections;

/**
 * Utility class for authorization and token management.
 */
public class BearerAuthManager extends HeaderAuth implements BearerAuthCredentials {

    /**
     * Private instance of the auth model containing the auth credentials.
     */
    private BearerAuthModel authModel;

    /**
     * Constructor.
     * @param authModel The instance of auth credentials.
     */
    public BearerAuthManager(BearerAuthModel authModel) {
        super(Collections.singletonMap("Authorization",
                applyBearerPrefix(authModel.getAccessToken())));
        this.authModel = authModel;
    }

    /**
     * applies bearer prefix to the access token.
     * @param accessToken The actual access token.
     * @return The access token with 'Bearer' as prefix.
     */
    private static String applyBearerPrefix(String accessToken) {
        if (accessToken == null || accessToken == "") {
            return null;
        }

        return "Bearer " + accessToken;
    }

    /**
     * String value for accessToken.
     * @return accessToken
     */
    public String getAccessToken() {
        return authModel.getAccessToken();
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
        return "BearerAuthManager [" + "accessToken=" + getAccessToken() + "]";
    }
    /**
    * Returns the error message if the auth credentials are not valid.
    * @return the auth specific error message.
    */
    @Override
    public String getErrorMessage() {
        String errorMessage = super.getErrorMessage();
        if (errorMessage == null) {
            return null;
        }

        return "BearerAuth - " + errorMessage;
     }

}