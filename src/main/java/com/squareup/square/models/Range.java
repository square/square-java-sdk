
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for Range type.
 */
public class Range {
    private final String min;
    private final String max;

    /**
     * Initialization constructor.
     * @param min String value for min.
     * @param max String value for max.
     */
    @JsonCreator
    public Range(
            @JsonProperty("min") String min,
            @JsonProperty("max") String max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Getter for Min.
     * The lower bound of the number range.
     * @return Returns the String
     */
    @JsonGetter("min")
    public String getMin() {
        return this.min;
    }

    /**
     * Getter for Max.
     * The upper bound of the number range.
     * @return Returns the String
     */
    @JsonGetter("max")
    public String getMax() {
        return this.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range other = (Range) obj;
        return Objects.equals(min, other.min)
            && Objects.equals(max, other.max);
    }

    /**
     * Converts this Range into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Range [" + "min=" + min + ", max=" + max + "]";
    }

    /**
     * Builds a new {@link Range.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Range.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .min(getMin())
                .max(getMax());
        return builder;
    }

    /**
     * Class to build instances of {@link Range}.
     */
    public static class Builder {
        private String min;
        private String max;



        /**
         * Setter for min.
         * @param min String value for min.
         * @return Builder
         */
        public Builder min(String min) {
            this.min = min;
            return this;
        }

        /**
         * Setter for max.
         * @param max String value for max.
         * @return Builder
         */
        public Builder max(String max) {
            this.max = max;
            return this;
        }

        /**
         * Builds a new {@link Range} object using the set fields.
         * @return {@link Range}
         */
        public Range build() {
            return new Range(min, max);
        }
    }
}
