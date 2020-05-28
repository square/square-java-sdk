package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveLoyaltyAccountResponse type.
 */
public class RetrieveLoyaltyAccountResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param loyaltyAccount
     */
    @JsonCreator
    public RetrieveLoyaltyAccountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("loyalty_account") LoyaltyAccount loyaltyAccount) {
        this.errors = errors;
        this.loyaltyAccount = loyaltyAccount;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyAccount loyaltyAccount;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for LoyaltyAccount.
     * Describes a loyalty account. For more information, see 
     * [Loyalty Overview](https://developer.squareup.com/docs/docs/loyalty/overview).
     */
    @JsonGetter("loyalty_account")
    public LoyaltyAccount getLoyaltyAccount() {
        return this.loyaltyAccount;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, loyaltyAccount);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveLoyaltyAccountResponse)) {
            return false;
        }
        RetrieveLoyaltyAccountResponse retrieveLoyaltyAccountResponse = (RetrieveLoyaltyAccountResponse) obj;
        return Objects.equals(errors, retrieveLoyaltyAccountResponse.errors) &&
            Objects.equals(loyaltyAccount, retrieveLoyaltyAccountResponse.loyaltyAccount);
    }

    /**
     * Builds a new {@link RetrieveLoyaltyAccountResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveLoyaltyAccountResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .loyaltyAccount(getLoyaltyAccount());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveLoyaltyAccountResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyAccount loyaltyAccount;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for loyaltyAccount
         * @param loyaltyAccount
         * @return Builder
         */
        public Builder loyaltyAccount(LoyaltyAccount loyaltyAccount) {
            this.loyaltyAccount = loyaltyAccount;
            return this;
        }

        /**
         * Builds a new {@link RetrieveLoyaltyAccountResponse} object using the set fields.
         * @return {@link RetrieveLoyaltyAccountResponse}
         */
        public RetrieveLoyaltyAccountResponse build() {
            RetrieveLoyaltyAccountResponse model = new RetrieveLoyaltyAccountResponse(errors,
                loyaltyAccount);
            model.httpContext = httpContext;
            return model;
        }
    }
}
