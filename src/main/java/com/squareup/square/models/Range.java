
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for Range type.
 */
public class Range {
    private final OptionalNullable<String> min;
    private final OptionalNullable<String> max;

    /**
     * Initialization constructor.
     * @param  min  String value for min.
     * @param  max  String value for max.
     */
    @JsonCreator
    public Range(
            @JsonProperty("min") String min,
            @JsonProperty("max") String max) {
        this.min = OptionalNullable.of(min);
        this.max = OptionalNullable.of(max);
    }

    /**
     * Internal initialization constructor.
     */
    protected Range(OptionalNullable<String> min, OptionalNullable<String> max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Internal Getter for Min.
     * The lower bound of the number range. At least one of `min` or `max` must be specified. If
     * unspecified, the results will have no minimum value.
     * @return Returns the Internal String
     */
    @JsonGetter("min")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMin() {
        return this.min;
    }

    /**
     * Getter for Min.
     * The lower bound of the number range. At least one of `min` or `max` must be specified. If
     * unspecified, the results will have no minimum value.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMin() {
        return OptionalNullable.getFrom(min);
    }

    /**
     * Internal Getter for Max.
     * The upper bound of the number range. At least one of `min` or `max` must be specified. If
     * unspecified, the results will have no maximum value.
     * @return Returns the Internal String
     */
    @JsonGetter("max")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetMax() {
        return this.max;
    }

    /**
     * Getter for Max.
     * The upper bound of the number range. At least one of `min` or `max` must be specified. If
     * unspecified, the results will have no maximum value.
     * @return Returns the String
     */
    @JsonIgnore
    public String getMax() {
        return OptionalNullable.getFrom(max);
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
        Builder builder = new Builder();
        builder.min = internalGetMin();
        builder.max = internalGetMax();
        return builder;
    }

    /**
     * Class to build instances of {@link Range}.
     */
    public static class Builder {
        private OptionalNullable<String> min;
        private OptionalNullable<String> max;



        /**
         * Setter for min.
         * @param  min  String value for min.
         * @return Builder
         */
        public Builder min(String min) {
            this.min = OptionalNullable.of(min);
            return this;
        }

        /**
         * UnSetter for min.
         * @return Builder
         */
        public Builder unsetMin() {
            min = null;
            return this;
        }

        /**
         * Setter for max.
         * @param  max  String value for max.
         * @return Builder
         */
        public Builder max(String max) {
            this.max = OptionalNullable.of(max);
            return this;
        }

        /**
         * UnSetter for max.
         * @return Builder
         */
        public Builder unsetMax() {
            max = null;
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
