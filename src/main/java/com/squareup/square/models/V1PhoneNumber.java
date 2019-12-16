package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1PhoneNumber {

    @JsonCreator
    public V1PhoneNumber(
            @JsonProperty("calling_code") String callingCode,
            @JsonProperty("number") String number) {
        this.callingCode = callingCode;
        this.number = number;
    }

    private final String callingCode;
    private final String number;

    @Override
    public int hashCode() {
        return Objects.hash(callingCode, number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1PhoneNumber)) {
            return false;
        }
        V1PhoneNumber v1PhoneNumber = (V1PhoneNumber) o;
        return Objects.equals(callingCode, v1PhoneNumber.callingCode) &&
            Objects.equals(number, v1PhoneNumber.number);
    }

    /**
     * Getter for CallingCode.
     * The phone number's international calling code. For US phone numbers, this value is +1.
     */
    @JsonGetter("calling_code")
    public String getCallingCode() { 
        return this.callingCode;
    }

    /**
     * Getter for Number.
     * The phone number.
     */
    @JsonGetter("number")
    public String getNumber() { 
        return this.number;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(callingCode,
            number);
            return builder;
    }

    public static class Builder {
        private String callingCode;
        private String number;

        public Builder(String callingCode,
                String number) {
            this.callingCode = callingCode;
            this.number = number;
        }

        public Builder callingCode(String value) {
            callingCode = value;
            return this;
        }
        public Builder number(String value) {
            number = value;
            return this;
        }

        public V1PhoneNumber build() {
            return new V1PhoneNumber(callingCode,
                number);
        }
    }
}
