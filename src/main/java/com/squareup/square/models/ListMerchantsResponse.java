
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListMerchantsResponse type.
 */
public class ListMerchantsResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Merchant> merchant;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  merchant  List of Merchant value for merchant.
     * @param  cursor  Integer value for cursor.
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
     * The requested `Merchant` entities.
     * @return Returns the List of Merchant
     */
    @JsonGetter("merchant")
    public List<Merchant> getMerchant() {
        return merchant;
    }

    /**
     * Getter for Cursor.
     * If the response is truncated, the cursor to use in next request to fetch next set of objects.
     * @return Returns the Integer
     */
    @JsonGetter("cursor")
    public Integer getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, merchant, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListMerchantsResponse)) {
            return false;
        }
        ListMerchantsResponse other = (ListMerchantsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(merchant, other.merchant)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListMerchantsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListMerchantsResponse [" + "errors=" + errors + ", merchant=" + merchant
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link ListMerchantsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<Merchant> merchant;
        private Integer cursor;



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
         * @param  merchant  List of Merchant value for merchant.
         * @return Builder
         */
        public Builder merchant(List<Merchant> merchant) {
            this.merchant = merchant;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  Integer value for cursor.
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
            ListMerchantsResponse model =
                    new ListMerchantsResponse(errors, merchant, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
