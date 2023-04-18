
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BookingCustomAttributeDeleteResponse type.
 */
public class BookingCustomAttributeDeleteResponse {
    private final String bookingId;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  bookingId  String value for bookingId.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BookingCustomAttributeDeleteResponse(
            @JsonProperty("booking_id") String bookingId,
            @JsonProperty("errors") List<Error> errors) {
        this.bookingId = bookingId;
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
        return Objects.hash(bookingId, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BookingCustomAttributeDeleteResponse)) {
            return false;
        }
        BookingCustomAttributeDeleteResponse other = (BookingCustomAttributeDeleteResponse) obj;
        return Objects.equals(bookingId, other.bookingId)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BookingCustomAttributeDeleteResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BookingCustomAttributeDeleteResponse [" + "bookingId=" + bookingId + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link BookingCustomAttributeDeleteResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BookingCustomAttributeDeleteResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .bookingId(getBookingId())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BookingCustomAttributeDeleteResponse}.
     */
    public static class Builder {
        private String bookingId;
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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link BookingCustomAttributeDeleteResponse} object using the set fields.
         * @return {@link BookingCustomAttributeDeleteResponse}
         */
        public BookingCustomAttributeDeleteResponse build() {
            return new BookingCustomAttributeDeleteResponse(bookingId, errors);
        }
    }
}
