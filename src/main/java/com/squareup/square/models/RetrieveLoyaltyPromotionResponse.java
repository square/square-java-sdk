
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
 * This is a model class for RetrieveLoyaltyPromotionResponse type.
 */
public class RetrieveLoyaltyPromotionResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyPromotion loyaltyPromotion;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  loyaltyPromotion  LoyaltyPromotion value for loyaltyPromotion.
     */
    @JsonCreator
    public RetrieveLoyaltyPromotionResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("loyalty_promotion") LoyaltyPromotion loyaltyPromotion) {
        this.errors = errors;
        this.loyaltyPromotion = loyaltyPromotion;
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
     * Getter for LoyaltyPromotion.
     * Represents a promotion for a [loyalty program]($m/LoyaltyProgram). Loyalty promotions enable
     * buyers to earn extra points on top of those earned from the base program. A loyalty program
     * can have a maximum of 10 loyalty promotions with an `ACTIVE` or `SCHEDULED` status.
     * @return Returns the LoyaltyPromotion
     */
    @JsonGetter("loyalty_promotion")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyPromotion getLoyaltyPromotion() {
        return loyaltyPromotion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, loyaltyPromotion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveLoyaltyPromotionResponse)) {
            return false;
        }
        RetrieveLoyaltyPromotionResponse other = (RetrieveLoyaltyPromotionResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(loyaltyPromotion, other.loyaltyPromotion);
    }

    /**
     * Converts this RetrieveLoyaltyPromotionResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveLoyaltyPromotionResponse [" + "errors=" + errors + ", loyaltyPromotion="
                + loyaltyPromotion + "]";
    }

    /**
     * Builds a new {@link RetrieveLoyaltyPromotionResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveLoyaltyPromotionResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .loyaltyPromotion(getLoyaltyPromotion());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveLoyaltyPromotionResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyPromotion loyaltyPromotion;



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
         * Setter for loyaltyPromotion.
         * @param  loyaltyPromotion  LoyaltyPromotion value for loyaltyPromotion.
         * @return Builder
         */
        public Builder loyaltyPromotion(LoyaltyPromotion loyaltyPromotion) {
            this.loyaltyPromotion = loyaltyPromotion;
            return this;
        }

        /**
         * Builds a new {@link RetrieveLoyaltyPromotionResponse} object using the set fields.
         * @return {@link RetrieveLoyaltyPromotionResponse}
         */
        public RetrieveLoyaltyPromotionResponse build() {
            RetrieveLoyaltyPromotionResponse model =
                    new RetrieveLoyaltyPromotionResponse(errors, loyaltyPromotion);
            model.httpContext = httpContext;
            return model;
        }
    }
}
