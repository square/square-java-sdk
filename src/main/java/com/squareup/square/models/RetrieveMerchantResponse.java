package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveMerchantResponse type.
 */
public class RetrieveMerchantResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param merchant
     */
    @JsonCreator
    public RetrieveMerchantResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("merchant") Merchant merchant) {
        this.errors = errors;
        this.merchant = merchant;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Merchant merchant;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Merchant.
     * Represents a Square seller.
     */
    @JsonGetter("merchant")
    public Merchant getMerchant() {
        return this.merchant;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, merchant);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveMerchantResponse)) {
            return false;
        }
        RetrieveMerchantResponse retrieveMerchantResponse = (RetrieveMerchantResponse) obj;
        return Objects.equals(errors, retrieveMerchantResponse.errors) &&
            Objects.equals(merchant, retrieveMerchantResponse.merchant);
    }

    /**
     * Builds a new {@link RetrieveMerchantResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveMerchantResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .merchant(getMerchant());
            return builder;
    }

    /**
     * Class to build instances of {@link RetrieveMerchantResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Merchant merchant;

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
         * Setter for merchant
         * @param merchant
         * @return Builder
         */
        public Builder merchant(Merchant merchant) {
            this.merchant = merchant;
            return this;
        }

        /**
         * Builds a new {@link RetrieveMerchantResponse} object using the set fields.
         * @return {@link RetrieveMerchantResponse}
         */
        public RetrieveMerchantResponse build() {
            RetrieveMerchantResponse model = new RetrieveMerchantResponse(errors,
                merchant);
            model.httpContext = httpContext;
            return model;
        }
    }
}
