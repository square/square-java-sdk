
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CustomerCustomAttributeFilter type.
 */
public class CustomerCustomAttributeFilter {
    private final String key;
    private final CustomerCustomAttributeFilterValue filter;
    private final TimeRange updatedAt;

    /**
     * Initialization constructor.
     * @param  key  String value for key.
     * @param  filter  CustomerCustomAttributeFilterValue value for filter.
     * @param  updatedAt  TimeRange value for updatedAt.
     */
    @JsonCreator
    public CustomerCustomAttributeFilter(
            @JsonProperty("key") String key,
            @JsonProperty("filter") CustomerCustomAttributeFilterValue filter,
            @JsonProperty("updated_at") TimeRange updatedAt) {
        this.key = key;
        this.filter = filter;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for Key.
     * The `key` of the [custom attribute]($m/CustomAttribute) to filter by. The key is the
     * identifier of the custom attribute (and the corresponding custom attribute definition) and
     * can be retrieved using the [Customer Custom Attributes API]($e/CustomerCustomAttributes).
     * @return Returns the String
     */
    @JsonGetter("key")
    public String getKey() {
        return key;
    }

    /**
     * Getter for Filter.
     * A type-specific filter used in a [custom attribute filter]($m/CustomerCustomAttributeFilter)
     * to search based on the value of a customer-related [custom attribute]($m/CustomAttribute).
     * @return Returns the CustomerCustomAttributeFilterValue
     */
    @JsonGetter("filter")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerCustomAttributeFilterValue getFilter() {
        return filter;
    }

    /**
     * Getter for UpdatedAt.
     * Represents a generic time range. The start and end values are represented in RFC 3339 format.
     * Time ranges are customized to be inclusive or exclusive based on the needs of a particular
     * endpoint. Refer to the relevant endpoint-specific documentation to determine how time ranges
     * are handled.
     * @return Returns the TimeRange
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TimeRange getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, filter, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerCustomAttributeFilter)) {
            return false;
        }
        CustomerCustomAttributeFilter other = (CustomerCustomAttributeFilter) obj;
        return Objects.equals(key, other.key)
            && Objects.equals(filter, other.filter)
            && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this CustomerCustomAttributeFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerCustomAttributeFilter [" + "key=" + key + ", filter=" + filter
                + ", updatedAt=" + updatedAt + "]";
    }

    /**
     * Builds a new {@link CustomerCustomAttributeFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerCustomAttributeFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(key)
                .filter(getFilter())
                .updatedAt(getUpdatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerCustomAttributeFilter}.
     */
    public static class Builder {
        private String key;
        private CustomerCustomAttributeFilterValue filter;
        private TimeRange updatedAt;

        /**
         * Initialization constructor.
         * @param  key  String value for key.
         */
        public Builder(String key) {
            this.key = key;
        }

        /**
         * Setter for key.
         * @param  key  String value for key.
         * @return Builder
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }

        /**
         * Setter for filter.
         * @param  filter  CustomerCustomAttributeFilterValue value for filter.
         * @return Builder
         */
        public Builder filter(CustomerCustomAttributeFilterValue filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  TimeRange value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(TimeRange updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link CustomerCustomAttributeFilter} object using the set fields.
         * @return {@link CustomerCustomAttributeFilter}
         */
        public CustomerCustomAttributeFilter build() {
            return new CustomerCustomAttributeFilter(key, filter, updatedAt);
        }
    }
}
