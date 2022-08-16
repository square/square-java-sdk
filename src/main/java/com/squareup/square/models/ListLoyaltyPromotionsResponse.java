
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
 * This is a model class for ListLoyaltyPromotionsResponse type.
 */
public class ListLoyaltyPromotionsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyPromotion> loyaltyPromotions;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  loyaltyPromotions  List of LoyaltyPromotion value for loyaltyPromotions.
     * @param  cursor  String value for cursor.
     */
    @JsonCreator
    public ListLoyaltyPromotionsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("loyalty_promotions") List<LoyaltyPromotion> loyaltyPromotions,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.loyaltyPromotions = loyaltyPromotions;
        this.cursor = cursor;
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
     * Getter for LoyaltyPromotions.
     * The retrieved loyalty promotions.
     * @return Returns the List of LoyaltyPromotion
     */
    @JsonGetter("loyalty_promotions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<LoyaltyPromotion> getLoyaltyPromotions() {
        return loyaltyPromotions;
    }

    /**
     * Getter for Cursor.
     * The cursor to use in your next call to this endpoint to retrieve the next page of results for
     * your original request. This field is present only if the request succeeded and additional
     * results are available. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, loyaltyPromotions, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListLoyaltyPromotionsResponse)) {
            return false;
        }
        ListLoyaltyPromotionsResponse other = (ListLoyaltyPromotionsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(loyaltyPromotions, other.loyaltyPromotions)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this ListLoyaltyPromotionsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListLoyaltyPromotionsResponse [" + "errors=" + errors + ", loyaltyPromotions="
                + loyaltyPromotions + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link ListLoyaltyPromotionsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListLoyaltyPromotionsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .loyaltyPromotions(getLoyaltyPromotions())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link ListLoyaltyPromotionsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyPromotion> loyaltyPromotions;
        private String cursor;



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
         * Setter for loyaltyPromotions.
         * @param  loyaltyPromotions  List of LoyaltyPromotion value for loyaltyPromotions.
         * @return Builder
         */
        public Builder loyaltyPromotions(List<LoyaltyPromotion> loyaltyPromotions) {
            this.loyaltyPromotions = loyaltyPromotions;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link ListLoyaltyPromotionsResponse} object using the set fields.
         * @return {@link ListLoyaltyPromotionsResponse}
         */
        public ListLoyaltyPromotionsResponse build() {
            ListLoyaltyPromotionsResponse model =
                    new ListLoyaltyPromotionsResponse(errors, loyaltyPromotions, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
