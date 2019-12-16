package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class ListMerchantsResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, merchant, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListMerchantsResponse)) {
            return false;
        }
        ListMerchantsResponse listMerchantsResponse = (ListMerchantsResponse) o;
        return Objects.equals(errors, listMerchantsResponse.errors) &&
            Objects.equals(merchant, listMerchantsResponse.merchant) &&
            Objects.equals(cursor, listMerchantsResponse.cursor);
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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .merchant(getMerchant())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Merchant> merchant;
        private Integer cursor;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder merchant(List<Merchant> value) {
            merchant = value;
            return this;
        }
        public Builder cursor(Integer value) {
            cursor = value;
            return this;
        }

        public ListMerchantsResponse build() {
            ListMerchantsResponse model = new ListMerchantsResponse(errors,
                merchant,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
