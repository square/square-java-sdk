package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListMerchantsResponse type.
 */
public class ListMerchantsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param merchant
     * @param cursor
     */
    @JsonCreator
    public ListMerchantsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("merchant") List<Merchant> merchant,
            @JsonProperty("cursor") Integer cursor) {
        this.errors = errors;
        this.merchant = merchant;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<Merchant> merchant;
    private final Integer cursor;

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
     * The requested `Merchant` entities.
     */
    @JsonGetter("merchant")
    public List<Merchant> getMerchant() {
        return this.merchant;
    }

    /**
     * Getter for Cursor.
     * If the  response is truncated, the cursor to use in next  request to fetch next set of objects.
     */
    @JsonGetter("cursor")
    public Integer getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, merchant, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListMerchantsResponse)) {
            return false;
        }
        ListMerchantsResponse listMerchantsResponse = (ListMerchantsResponse) obj;
        return Objects.equals(errors, listMerchantsResponse.errors) &&
            Objects.equals(merchant, listMerchantsResponse.merchant) &&
            Objects.equals(cursor, listMerchantsResponse.cursor);
    }

    /**
     * Builds a new {@link ListMerchantsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListMerchantsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .merchant(getMerchant())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListMerchantsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Merchant> merchant;
        private Integer cursor;

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
        public Builder merchant(List<Merchant> merchant) {
            this.merchant = merchant;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(Integer cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListMerchantsResponse} object using the set fields.
         * @return {@link ListMerchantsResponse}
         */
        public ListMerchantsResponse build() {
            ListMerchantsResponse model = new ListMerchantsResponse(errors,
                merchant,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
