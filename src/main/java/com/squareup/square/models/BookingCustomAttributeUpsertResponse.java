
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BookingCustomAttributeUpsertResponse type.
 */
public class BookingCustomAttributeUpsertResponse {
    private final String bookingId;
    private final CustomAttribute customAttribute;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  bookingId  String value for bookingId.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BookingCustomAttributeUpsertResponse(
            @JsonProperty("booking_id") String bookingId,
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("errors") List<Error> errors) {
        this.bookingId = bookingId;
        this.customAttribute = customAttribute;
        this.errors = errors;
    }

    /**
     * Getter for BookingId.
     * The ID of the [booking](entity:Booking) associated with the custom attribute.
     * @return Returns the String
     */
    @JsonGetter("booking_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Getter for CustomAttribute.
     * A custom attribute value. Each custom attribute value has a corresponding
     * `CustomAttributeDefinition` object.
     * @return Returns the CustomAttribute
     */
    @JsonGetter("custom_attribute")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred while processing the individual request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customAttribute, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BookingCustomAttributeUpsertResponse)) {
            return false;
        }
        BookingCustomAttributeUpsertResponse other = (BookingCustomAttributeUpsertResponse) obj;
        return Objects.equals(bookingId, other.bookingId)
            && Objects.equals(customAttribute, other.customAttribute)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BookingCustomAttributeUpsertResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BookingCustomAttributeUpsertResponse [" + "bookingId=" + bookingId
                + ", customAttribute=" + customAttribute + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BookingCustomAttributeUpsertResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BookingCustomAttributeUpsertResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .bookingId(getBookingId())
                .customAttribute(getCustomAttribute())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BookingCustomAttributeUpsertResponse}.
     */
    public static class Builder {
        private String bookingId;
        private CustomAttribute customAttribute;
        private List<Error> errors;



        /**
         * Setter for bookingId.
         * @param  bookingId  String value for bookingId.
         * @return Builder
         */
        public Builder bookingId(String bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        /**
         * Setter for customAttribute.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         * @return Builder
         */
        public Builder customAttribute(CustomAttribute customAttribute) {
            this.customAttribute = customAttribute;
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
         * Builds a new {@link BookingCustomAttributeUpsertResponse} object using the set fields.
         * @return {@link BookingCustomAttributeUpsertResponse}
         */
        public BookingCustomAttributeUpsertResponse build() {
            return new BookingCustomAttributeUpsertResponse(bookingId, customAttribute, errors);
        }
    }
}
