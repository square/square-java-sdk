package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for MethodErrorCodes type.
 */
public class MethodErrorCodes {

    /**
     * Initialization constructor.
     * @param value
     */
    @JsonCreator
    public MethodErrorCodes(
            @JsonProperty("value") List<String> value) {
        this.value = value;
    }

    private final List<String> value;
    /**
     * Getter for Value.
     * See [ErrorCode](#type-errorcode) for possible values
     */
    @JsonGetter("value")
    public List<String> getValue() {
        return this.value;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof MethodErrorCodes)) {
            return false;
        }
        MethodErrorCodes methodErrorCodes = (MethodErrorCodes) obj;
        return Objects.equals(value, methodErrorCodes.value);
    }

    /**
     * Builds a new {@link MethodErrorCodes.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link MethodErrorCodes.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .value(getValue());
            return builder;
    }

    /**
     * Class to build instances of {@link MethodErrorCodes}
     */
    public static class Builder {
        private List<String> value;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for value
         * @param value
         * @return Builder
         */
        public Builder value(List<String> value) {
            this.value = value;
            return this;
        }

        /**
         * Builds a new {@link MethodErrorCodes} object using the set fields.
         * @return {@link MethodErrorCodes}
         */
        public MethodErrorCodes build() {
            return new MethodErrorCodes(value);
        }
    }
}
