package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class RetrieveMerchantResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, merchant);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RetrieveMerchantResponse)) {
            return false;
        }
        RetrieveMerchantResponse retrieveMerchantResponse = (RetrieveMerchantResponse) o;
        return Objects.equals(errors, retrieveMerchantResponse.errors) &&
            Objects.equals(merchant, retrieveMerchantResponse.merchant);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .merchant(getMerchant());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Merchant merchant;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder merchant(Merchant value) {
            merchant = value;
            return this;
        }

        public RetrieveMerchantResponse build() {
            RetrieveMerchantResponse model = new RetrieveMerchantResponse(errors,
                merchant);
            model.httpContext = httpContext;
            return model;
        }
    }
}
