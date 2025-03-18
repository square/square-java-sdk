package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchOrdersFulfillmentFilter type.
 */
public class SearchOrdersFulfillmentFilter {
    private final OptionalNullable<List<String>> fulfillmentTypes;
    private final OptionalNullable<List<String>> fulfillmentStates;

    /**
     * Initialization constructor.
     * @param  fulfillmentTypes  List of String value for fulfillmentTypes.
     * @param  fulfillmentStates  List of String value for fulfillmentStates.
     */
    @JsonCreator
    public SearchOrdersFulfillmentFilter(
            @JsonProperty("fulfillment_types") List<String> fulfillmentTypes,
            @JsonProperty("fulfillment_states") List<String> fulfillmentStates) {
        this.fulfillmentTypes = OptionalNullable.of(fulfillmentTypes);
        this.fulfillmentStates = OptionalNullable.of(fulfillmentStates);
    }

    /**
     * Initialization constructor.
     * @param  fulfillmentTypes  List of String value for fulfillmentTypes.
     * @param  fulfillmentStates  List of String value for fulfillmentStates.
     */
    protected SearchOrdersFulfillmentFilter(
            OptionalNullable<List<String>> fulfillmentTypes, OptionalNullable<List<String>> fulfillmentStates) {
        this.fulfillmentTypes = fulfillmentTypes;
        this.fulfillmentStates = fulfillmentStates;
    }

    /**
     * Internal Getter for FulfillmentTypes.
     * A list of [fulfillment types](entity:FulfillmentType) to filter for. The list returns orders
     * if any of its fulfillments match any of the fulfillment types listed in this field. See
     * [FulfillmentType](#type-fulfillmenttype) for possible values
     * @return Returns the Internal List of String
     */
    @JsonGetter("fulfillment_types")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetFulfillmentTypes() {
        return this.fulfillmentTypes;
    }

    /**
     * Getter for FulfillmentTypes.
     * A list of [fulfillment types](entity:FulfillmentType) to filter for. The list returns orders
     * if any of its fulfillments match any of the fulfillment types listed in this field. See
     * [FulfillmentType](#type-fulfillmenttype) for possible values
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getFulfillmentTypes() {
        return OptionalNullable.getFrom(fulfillmentTypes);
    }

    /**
     * Internal Getter for FulfillmentStates.
     * A list of [fulfillment states](entity:FulfillmentState) to filter for. The list returns
     * orders if any of its fulfillments match any of the fulfillment states listed in this field.
     * See [FulfillmentState](#type-fulfillmentstate) for possible values
     * @return Returns the Internal List of String
     */
    @JsonGetter("fulfillment_states")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetFulfillmentStates() {
        return this.fulfillmentStates;
    }

    /**
     * Getter for FulfillmentStates.
     * A list of [fulfillment states](entity:FulfillmentState) to filter for. The list returns
     * orders if any of its fulfillments match any of the fulfillment states listed in this field.
     * See [FulfillmentState](#type-fulfillmentstate) for possible values
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getFulfillmentStates() {
        return OptionalNullable.getFrom(fulfillmentStates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fulfillmentTypes, fulfillmentStates);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchOrdersFulfillmentFilter)) {
            return false;
        }
        SearchOrdersFulfillmentFilter other = (SearchOrdersFulfillmentFilter) obj;
        return Objects.equals(fulfillmentTypes, other.fulfillmentTypes)
                && Objects.equals(fulfillmentStates, other.fulfillmentStates);
    }

    /**
     * Converts this SearchOrdersFulfillmentFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchOrdersFulfillmentFilter [" + "fulfillmentTypes=" + fulfillmentTypes + ", fulfillmentStates="
                + fulfillmentStates + "]";
    }

    /**
     * Builds a new {@link SearchOrdersFulfillmentFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchOrdersFulfillmentFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.fulfillmentTypes = internalGetFulfillmentTypes();
        builder.fulfillmentStates = internalGetFulfillmentStates();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchOrdersFulfillmentFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> fulfillmentTypes;
        private OptionalNullable<List<String>> fulfillmentStates;

        /**
         * Setter for fulfillmentTypes.
         * @param  fulfillmentTypes  List of String value for fulfillmentTypes.
         * @return Builder
         */
        public Builder fulfillmentTypes(List<String> fulfillmentTypes) {
            this.fulfillmentTypes = OptionalNullable.of(fulfillmentTypes);
            return this;
        }

        /**
         * UnSetter for fulfillmentTypes.
         * @return Builder
         */
        public Builder unsetFulfillmentTypes() {
            fulfillmentTypes = null;
            return this;
        }

        /**
         * Setter for fulfillmentStates.
         * @param  fulfillmentStates  List of String value for fulfillmentStates.
         * @return Builder
         */
        public Builder fulfillmentStates(List<String> fulfillmentStates) {
            this.fulfillmentStates = OptionalNullable.of(fulfillmentStates);
            return this;
        }

        /**
         * UnSetter for fulfillmentStates.
         * @return Builder
         */
        public Builder unsetFulfillmentStates() {
            fulfillmentStates = null;
            return this;
        }

        /**
         * Builds a new {@link SearchOrdersFulfillmentFilter} object using the set fields.
         * @return {@link SearchOrdersFulfillmentFilter}
         */
        public SearchOrdersFulfillmentFilter build() {
            return new SearchOrdersFulfillmentFilter(fulfillmentTypes, fulfillmentStates);
        }
    }
}
