package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateMobileAuthorizationCodeResponse type.
 */
public class CreateMobileAuthorizationCodeResponse {
    private HttpContext httpContext;
    private final String authorizationCode;
    private final String expiresAt;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  authorizationCode  String value for authorizationCode.
     * @param  expiresAt  String value for expiresAt.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CreateMobileAuthorizationCodeResponse(
            @JsonProperty("authorization_code") String authorizationCode,
            @JsonProperty("expires_at") String expiresAt,
            @JsonProperty("errors") List<Error> errors) {
        this.authorizationCode = authorizationCode;
        this.expiresAt = expiresAt;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for AuthorizationCode.
     * The generated authorization code that connects a mobile application instance to a Square
     * account.
     * @return Returns the String
     */
    @JsonGetter("authorization_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Getter for ExpiresAt.
     * The timestamp when `authorization_code` expires, in [RFC
     * 3339](https://tools.ietf.org/html/rfc3339) format (for example, "2016-09-04T23:59:33.123Z").
     * @return Returns the String
     */
    @JsonGetter("expires_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorizationCode, expiresAt, errors);
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
                && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CreateMobileAuthorizationCodeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateMobileAuthorizationCodeResponse [" + "authorizationCode=" + authorizationCode + ", expiresAt="
                + expiresAt + ", errors=" + errors + "]";
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
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateMobileAuthorizationCodeResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String authorizationCode;
        private String expiresAt;
        private List<Error> errors;

        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for authorizationCode.
         * @param  authorizationCode  String value for authorizationCode.
         * @return Builder
         */
        public Builder authorizationCode(String authorizationCode) {
            this.authorizationCode = authorizationCode;
            return this;
        }

        /**
         * Setter for expiresAt.
         * @param  expiresAt  String value for expiresAt.
         * @return Builder
         */
        public Builder expiresAt(String expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link CreateMobileAuthorizationCodeResponse} object using the set fields.
         * @return {@link CreateMobileAuthorizationCodeResponse}
         */
        public CreateMobileAuthorizationCodeResponse build() {
            CreateMobileAuthorizationCodeResponse model =
                    new CreateMobileAuthorizationCodeResponse(authorizationCode, expiresAt, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
