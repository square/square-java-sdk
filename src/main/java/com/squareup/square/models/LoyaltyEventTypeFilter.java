
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for LoyaltyEventTypeFilter type.
 */
public class LoyaltyEventTypeFilter {
    private final List<String> types;

    /**
     * Initialization constructor.
     * @param  types  List of String value for types.
     */
    @JsonCreator
    public LoyaltyEventTypeFilter(
            @JsonProperty("types") List<String> types) {
        this.types = types;
    }

    /**
     * Getter for Types.
     * The loyalty event types used to filter the result. If multiple values are specified, the
     * endpoint uses a logical OR to combine them. See [LoyaltyEventType](#type-loyaltyeventtype)
     * for possible values
     * @return Returns the List of String
     */
    @JsonGetter("types")
    public List<String> getTypes() {
        return types;
    }

    @Override
    public int hashCode() {
        return Objects.hash(types);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyEventTypeFilter)) {
            return false;
        }
        LoyaltyEventTypeFilter other = (LoyaltyEventTypeFilter) obj;
        return Objects.equals(types, other.types);
    }

    /**
     * Converts this LoyaltyEventTypeFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyEventTypeFilter [" + "types=" + types + "]";
    }

    /**
     * Builds a new {@link LoyaltyEventTypeFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyEventTypeFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(types);
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyEventTypeFilter}.
     */
    public static class Builder {
        private List<String> types;

        /**
         * Initialization constructor.
         * @param  types  List of String value for types.
         */
        public Builder(List<String> types) {
            this.types = types;
        }

        /**
         * Setter for types.
         * @param  types  List of String value for types.
         * @return Builder
         */
        public Builder types(List<String> types) {
            this.types = types;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyEventTypeFilter} object using the set fields.
         * @return {@link LoyaltyEventTypeFilter}
         */
        public LoyaltyEventTypeFilter build() {
            return new LoyaltyEventTypeFilter(types);
        }
    }
}
