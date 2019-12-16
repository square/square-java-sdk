package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateMobileAuthorizationCodeResponse {

    @JsonCreator
    public CreateMobileAuthorizationCodeResponse(
            @JsonProperty("authorization_code") String authorizationCode,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("error") Error error) {
        this.authorizationCode = authorizationCode;
        this.expiresAt = expiresAt;
        this.error = error;
    }

    private HttpContext httpContext;
    private final String authorizationCode;
    private final String expiresAt;
    private final Error error;

    @Override
    public int hashCode() {
        return Objects.hash(authorizationCode, expiresAt, error);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateMobileAuthorizationCodeResponse)) {
            return false;
        }
        CreateMobileAuthorizationCodeResponse createMobileAuthorizationCodeResponse = (CreateMobileAuthorizationCodeResponse) o;
        return Objects.equals(authorizationCode, createMobileAuthorizationCodeResponse.authorizationCode) &&
            Objects.equals(expiresAt, createMobileAuthorizationCodeResponse.expiresAt) &&
            Objects.equals(error, createMobileAuthorizationCodeResponse.error);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AuthorizationCode.
     * Generated authorization code that connects a mobile application instance
     * to a Square account.
     */
    @JsonGetter("authorization_code")
    public String getAuthorizationCode() { 
        return this.authorizationCode;
    }

    /**
     * Getter for ExpiresAt.
     * The timestamp when `authorization_code` expires in
     * [RFC 3339](https://tools.ietf.org/html/rfc3339) format, e.g., "2016-09-04T23:59:33.123Z".
     */
    @JsonGetter("expires_at")
    public String getExpiresAt() { 
        return this.expiresAt;
    }

    /**
     * Getter for Error.
     * Represents an error encountered during a request to the Connect API.
     * See [Handling errors](#handlingerrors) for more information.
     */
    @JsonGetter("error")
    public Error getError() { 
        return this.error;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .authorizationCode(getAuthorizationCode())
            .expiresAt(getExpiresAt())
            .error(getError());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String authorizationCode;
        private String expiresAt;
        private Error error;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder authorizationCode(String value) {
            authorizationCode = value;
            return this;
        }
        public Builder expiresAt(String value) {
            expiresAt = value;
            return this;
        }
        public Builder error(Error value) {
            error = value;
            return this;
        }

        public CreateMobileAuthorizationCodeResponse build() {
            CreateMobileAuthorizationCodeResponse model = new CreateMobileAuthorizationCodeResponse(authorizationCode,
                expiresAt,
                error);
            model.httpContext = httpContext;
            return model;
        }
    }
}
