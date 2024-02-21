
package com.squareup.square.authentication;

/**
 * A data class for OAuth 2 Bearer token credentials.
 */
public class BearerAuthModel {
    private String accessToken;

    /**
     * A Constructor for BearerAuthModel.
     */
    private BearerAuthModel(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Getter for accessToken.
     * @return accessToken The value of AccessToken.
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Builds a new {@link BearerAuthModel.Builder} object.
     * Creates the instance with the state of the current auth model.
     * @return a new {@link BearerAuthModel.Builder} object.
     */
    public Builder toBuilder() {
        return new Builder(getAccessToken());
    }

    /**
     * A Builder class for OAuth 2 Bearer token credentials.
     */
    public static class Builder {
        private String accessToken;

        /**
         * The constructor with required auth credentials.
         * @param accessToken The value of AccessToken.
         */
        public Builder(String accessToken) {
            if (accessToken == null) {
                throw new NullPointerException("AccessToken cannot be null.");
            }

            this.accessToken = accessToken;
        }

        /**
         * Setter for accessToken.
         * @param accessToken The value of AccessToken.
         * @return Builder The current instance of Builder.
         */
        public Builder accessToken(String accessToken) {
            if (accessToken == null) {
                throw new NullPointerException("AccessToken cannot be null.");
            }

            this.accessToken = accessToken;
            return this;
        }

        /**
         * Builds the instance of BearerAuthModel using the provided credentials.
         * @return The instance of BearerAuthModel.
         */
        public BearerAuthModel build() {
            return new BearerAuthModel(accessToken);
        }
    }
}