
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
 * This is a model class for CreateGiftCardActivityResponse type.
 */
public class CreateGiftCardActivityResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final GiftCardActivity giftCardActivity;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  giftCardActivity  GiftCardActivity value for giftCardActivity.
     */
    @JsonCreator
    public CreateGiftCardActivityResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("gift_card_activity") GiftCardActivity giftCardActivity) {
        this.errors = errors;
        this.giftCardActivity = giftCardActivity;
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
     * Getter for GiftCardActivity.
     * Represents an action performed on a [gift card]($m/GiftCard) that affects its state or
     * balance. A gift card activity contains information about a specific activity type. For
     * example, a `REDEEM` activity includes a `redeem_activity_details` field that contains
     * information about the redemption.
     * @return Returns the GiftCardActivity
     */
    @JsonGetter("gift_card_activity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public GiftCardActivity getGiftCardActivity() {
        return giftCardActivity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, giftCardActivity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateGiftCardActivityResponse)) {
            return false;
        }
        CreateGiftCardActivityResponse other = (CreateGiftCardActivityResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(giftCardActivity, other.giftCardActivity);
    }

    /**
     * Converts this CreateGiftCardActivityResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateGiftCardActivityResponse [" + "errors=" + errors + ", giftCardActivity="
                + giftCardActivity + "]";
    }

    /**
     * Builds a new {@link CreateGiftCardActivityResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateGiftCardActivityResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .giftCardActivity(getGiftCardActivity());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateGiftCardActivityResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private GiftCardActivity giftCardActivity;



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
         * Setter for giftCardActivity.
         * @param  giftCardActivity  GiftCardActivity value for giftCardActivity.
         * @return Builder
         */
        public Builder giftCardActivity(GiftCardActivity giftCardActivity) {
            this.giftCardActivity = giftCardActivity;
            return this;
        }

        /**
         * Builds a new {@link CreateGiftCardActivityResponse} object using the set fields.
         * @return {@link CreateGiftCardActivityResponse}
         */
        public CreateGiftCardActivityResponse build() {
            CreateGiftCardActivityResponse model =
                    new CreateGiftCardActivityResponse(errors, giftCardActivity);
            model.httpContext = httpContext;
            return model;
        }
    }
}
