
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for V1PhoneNumber type.
 */
public class V1PhoneNumber {
    private final String callingCode;
    private final String number;

    /**
     * Initialization constructor.
     * @param callingCode String value for callingCode.
     * @param number String value for number.
     */
    @JsonCreator
    public V1PhoneNumber(
            @JsonProperty("calling_code") String callingCode,
            @JsonProperty("number") String number) {
        this.callingCode = callingCode;
        this.number = number;
    }

    /**
     * Getter for CallingCode.
     * The phone number's international calling code. For US phone numbers, this value is +1.
     * @return Returns the String
     */
    @JsonGetter("calling_code")
    public String getCallingCode() {
        return this.callingCode;
    }

    /**
     * Getter for Number.
     * The phone number.
     * @return Returns the String
     */
    @JsonGetter("number")
    public String getNumber() {
        return this.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(callingCode, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1PhoneNumber)) {
            return false;
        }
        V1PhoneNumber other = (V1PhoneNumber) obj;
        return Objects.equals(callingCode, other.callingCode)
            && Objects.equals(number, other.number);
    }

    /**
     * Converts this V1PhoneNumber into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1PhoneNumber [" + "callingCode=" + callingCode + ", number=" + number + "]";
    }

    /**
     * Builds a new {@link V1PhoneNumber.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1PhoneNumber.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(callingCode, number);
        return builder;
    }

    /**
     * Class to build instances of {@link V1PhoneNumber}.
     */
    public static class Builder {
        private String callingCode;
        private String number;

        /**
         * Initialization constructor.
         * @param callingCode String value for callingCode.
         * @param number String value for number.
         */
        public Builder(String callingCode,
                String number) {
            this.callingCode = callingCode;
            this.number = number;
        }

        /**
         * Setter for callingCode.
         * @param callingCode String value for callingCode.
         * @return Builder
         */
        public Builder callingCode(String callingCode) {
            this.callingCode = callingCode;
            return this;
        }

        /**
         * Setter for number.
         * @param number String value for number.
         * @return Builder
         */
        public Builder number(String number) {
            this.number = number;
            return this;
        }

        /**
         * Builds a new {@link V1PhoneNumber} object using the set fields.
         * @return {@link V1PhoneNumber}
         */
        public V1PhoneNumber build() {
            return new V1PhoneNumber(callingCode, number);
        }
    }
}
