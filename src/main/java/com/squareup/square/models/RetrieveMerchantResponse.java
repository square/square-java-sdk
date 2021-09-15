
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
 * This is a model class for RetrieveMerchantResponse type.
 */
public class RetrieveMerchantResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Merchant merchant;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  merchant  Merchant value for merchant.
     */
    @JsonCreator
    public RetrieveMerchantResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("merchant") Merchant merchant) {
        this.errors = errors;
        this.merchant = merchant;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Merchant.
     * Represents a Square seller.
     * @return Returns the Merchant
     */
    @JsonGetter("merchant")
    public Merchant getMerchant() {
        return merchant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, merchant);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveMerchantResponse)) {
            return false;
        }
        RetrieveMerchantResponse other = (RetrieveMerchantResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(merchant, other.merchant);
    }

    /**
     * Converts this RetrieveMerchantResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveMerchantResponse [" + "errors=" + errors + ", merchant=" + merchant + "]";
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
     * Class to build instances of {@link RetrieveMerchantResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Merchant merchant;



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
         * Setter for merchant.
         * @param  merchant  Merchant value for merchant.
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
            RetrieveMerchantResponse model =
                    new RetrieveMerchantResponse(errors, merchant);
            model.httpContext = httpContext;
            return model;
        }
    }
}
