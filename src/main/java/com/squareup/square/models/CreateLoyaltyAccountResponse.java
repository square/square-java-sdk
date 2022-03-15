
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateLoyaltyAccountResponse type.
 */
public class CreateLoyaltyAccountResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyAccount loyaltyAccount;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  loyaltyAccount  LoyaltyAccount value for loyaltyAccount.
     */
    @JsonCreator
    public CreateLoyaltyAccountResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("loyalty_account") LoyaltyAccount loyaltyAccount) {
        this.errors = errors;
        this.loyaltyAccount = loyaltyAccount;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
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

    /**
     * Getter for LoyaltyAccount.
     * Describes a loyalty account in a [loyalty program]($m/LoyaltyProgram). For more information,
     * see [Create and Retrieve Loyalty
     * Accounts](https://developer.squareup.com/docs/loyalty-api/loyalty-accounts).
     * @return Returns the LoyaltyAccount
     */
    @JsonGetter("loyalty_account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyAccount getLoyaltyAccount() {
        return loyaltyAccount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, loyaltyAccount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateLoyaltyAccountResponse)) {
            return false;
        }
        CreateLoyaltyAccountResponse other = (CreateLoyaltyAccountResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(loyaltyAccount, other.loyaltyAccount);
    }

    /**
     * Converts this CreateLoyaltyAccountResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateLoyaltyAccountResponse [" + "errors=" + errors + ", loyaltyAccount="
                + loyaltyAccount + "]";
    }

    /**
     * Builds a new {@link CreateLoyaltyAccountResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyAccountResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .loyaltyAccount(getLoyaltyAccount());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyAccountResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyAccount loyaltyAccount;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for loyaltyAccount.
         * @param  loyaltyAccount  LoyaltyAccount value for loyaltyAccount.
         * @return Builder
         */
        public Builder loyaltyAccount(LoyaltyAccount loyaltyAccount) {
            this.loyaltyAccount = loyaltyAccount;
            return this;
        }

        /**
         * Builds a new {@link CreateLoyaltyAccountResponse} object using the set fields.
         * @return {@link CreateLoyaltyAccountResponse}
         */
        public CreateLoyaltyAccountResponse build() {
            CreateLoyaltyAccountResponse model =
                    new CreateLoyaltyAccountResponse(errors, loyaltyAccount);
            model.httpContext = httpContext;
            return model;
        }
    }
}
