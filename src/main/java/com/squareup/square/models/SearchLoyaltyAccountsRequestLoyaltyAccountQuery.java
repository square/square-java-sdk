
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchLoyaltyAccountsRequestLoyaltyAccountQuery type.
 */
public class SearchLoyaltyAccountsRequestLoyaltyAccountQuery {
    private final OptionalNullable<List<LoyaltyAccountMapping>> mappings;
    private final OptionalNullable<List<String>> customerIds;

    /**
     * Initialization constructor.
     * @param  mappings  List of LoyaltyAccountMapping value for mappings.
     * @param  customerIds  List of String value for customerIds.
     */
    @JsonCreator
    public SearchLoyaltyAccountsRequestLoyaltyAccountQuery(
            @JsonProperty("mappings") List<LoyaltyAccountMapping> mappings,
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.mappings = OptionalNullable.of(mappings);
        this.customerIds = OptionalNullable.of(customerIds);
    }

    /**
     * Internal initialization constructor.
     */
    protected SearchLoyaltyAccountsRequestLoyaltyAccountQuery(
            OptionalNullable<List<LoyaltyAccountMapping>> mappings,
            OptionalNullable<List<String>> customerIds) {
        this.mappings = mappings;
        this.customerIds = customerIds;
    }

    /**
     * Internal Getter for Mappings.
     * The set of mappings to use in the loyalty account search. This cannot be combined with
     * `customer_ids`. Max: 30 mappings
     * @return Returns the Internal List of LoyaltyAccountMapping
     */
    @JsonGetter("mappings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<LoyaltyAccountMapping>> internalGetMappings() {
        return this.mappings;
    }

    /**
     * Getter for Mappings.
     * The set of mappings to use in the loyalty account search. This cannot be combined with
     * `customer_ids`. Max: 30 mappings
     * @return Returns the List of LoyaltyAccountMapping
     */
    @JsonIgnore
    public List<LoyaltyAccountMapping> getMappings() {
        return OptionalNullable.getFrom(mappings);
    }

    /**
     * Internal Getter for CustomerIds.
     * The set of customer IDs to use in the loyalty account search. This cannot be combined with
     * `mappings`. Max: 30 customer IDs
     * @return Returns the Internal List of String
     */
    @JsonGetter("customer_ids")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetCustomerIds() {
        return this.customerIds;
    }

    /**
     * Getter for CustomerIds.
     * The set of customer IDs to use in the loyalty account search. This cannot be combined with
     * `mappings`. Max: 30 customer IDs
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getCustomerIds() {
        return OptionalNullable.getFrom(customerIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mappings, customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchLoyaltyAccountsRequestLoyaltyAccountQuery)) {
            return false;
        }
        SearchLoyaltyAccountsRequestLoyaltyAccountQuery other =
                (SearchLoyaltyAccountsRequestLoyaltyAccountQuery) obj;
        return Objects.equals(mappings, other.mappings)
            && Objects.equals(customerIds, other.customerIds);
    }

    /**
     * Converts this SearchLoyaltyAccountsRequestLoyaltyAccountQuery into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchLoyaltyAccountsRequestLoyaltyAccountQuery [" + "mappings=" + mappings
                + ", customerIds=" + customerIds + "]";
    }

    /**
     * Builds a new {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.mappings = internalGetMappings();
        builder.customerIds = internalGetCustomerIds();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery}.
     */
    public static class Builder {
        private OptionalNullable<List<LoyaltyAccountMapping>> mappings;
        private OptionalNullable<List<String>> customerIds;



        /**
         * Setter for mappings.
         * @param  mappings  List of LoyaltyAccountMapping value for mappings.
         * @return Builder
         */
        public Builder mappings(List<LoyaltyAccountMapping> mappings) {
            this.mappings = OptionalNullable.of(mappings);
            return this;
        }

        /**
         * UnSetter for mappings.
         * @return Builder
         */
        public Builder unsetMappings() {
            mappings = null;
            return this;
        }

        /**
         * Setter for customerIds.
         * @param  customerIds  List of String value for customerIds.
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = OptionalNullable.of(customerIds);
            return this;
        }

        /**
         * UnSetter for customerIds.
         * @return Builder
         */
        public Builder unsetCustomerIds() {
            customerIds = null;
            return this;
        }

        /**
         * Builds a new {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery} object using the set
         * fields.
         * @return {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery}
         */
        public SearchLoyaltyAccountsRequestLoyaltyAccountQuery build() {
            return new SearchLoyaltyAccountsRequestLoyaltyAccountQuery(mappings, customerIds);
        }
    }
}
