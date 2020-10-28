
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.Objects;


/**
 * This is a model class for CreateMobileAuthorizationCodeResponse type.
 */
public class CreateMobileAuthorizationCodeResponse {
    private HttpContext httpContext;
    private final String authorizationCode;
    private final String expiresAt;
    private final Error error;

    /**
     * Initialization constructor.
     * @param authorizationCode String value for authorizationCode.
     * @param expiresAt String value for expiresAt.
     * @param error Error value for error.
     */
    @JsonCreator
    public CreateMobileAuthorizationCodeResponse(
            @JsonProperty("authorization_code") String authorizationCode,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("error") Error error) {
        this.authorizationCode = authorizationCode;
        this.expiresAt = expiresAt;
        this.error = error;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AuthorizationCode.
     * Generated authorization code that connects a mobile application instance to a Square account.
     * @return Returns the String
     */
    @JsonGetter("authorization_code")
    public String getAuthorizationCode() {
        return this.authorizationCode;
    }

    /**
     * Getter for ExpiresAt.
     * The timestamp when `authorization_code` expires in [RFC
     * 3339](https://tools.ietf.org/html/rfc3339) format, e.g., "2016-09-04T23:59:33.123Z".
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() {
        return this.expiresAt;
    }

    /**
     * Getter for Error.
     * Represents an error encountered during a request to the Connect API. See [Handling
     * errors](#handlingerrors) for more information.
     * @return Returns the Error
     */
    @JsonGetter("error")
    public Error getError() {
        return this.error;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(authorizationCode, expiresAt, error);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateMobileAuthorizationCodeResponse)) {
            return false;
        }
        CreateMobileAuthorizationCodeResponse other = (CreateMobileAuthorizationCodeResponse) obj;
        return Objects.equals(authorizationCode, other.authorizationCode)
            && Objects.equals(expiresAt, other.expiresAt)
            && Objects.equals(error, other.error);
    }

    /**
     * Builds a new {@link CreateMobileAuthorizationCodeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateMobileAuthorizationCodeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .authorizationCode(getAuthorizationCode())
            .expiresAt(getExpiresAt())
            .error(getError());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateMobileAuthorizationCodeResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String authorizationCode;
        private String expiresAt;
        private Error error;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for authorizationCode.
         * @param authorizationCode String value for authorizationCode.
         * @return Builder
         */
        public Builder authorizationCode(String authorizationCode) {
            this.authorizationCode = authorizationCode;
            return this;
        }

        /**
         * Setter for expiresAt.
         * @param expiresAt String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * Setter for error.
         * @param error Error value for error.
         * @return Builder
         */
        public Builder error(Error error) {
            this.error = error;
            return this;
        }

        /**
         * Builds a new {@link CreateMobileAuthorizationCodeResponse} object using the set fields.
         * @return {@link CreateMobileAuthorizationCodeResponse}
         */
        public CreateMobileAuthorizationCodeResponse build() {
            CreateMobileAuthorizationCodeResponse model =
                    new CreateMobileAuthorizationCodeResponse(authorizationCode,
                            expiresAt,
                            error);
            model.httpContext = httpContext;
            return model;
        }
    }
}
