package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchLoyaltyAccountsRequestLoyaltyAccountQuery type.
 */
public class SearchLoyaltyAccountsRequestLoyaltyAccountQuery {

    /**
     * Initialization constructor.
     * @param mappings
     */
    @JsonCreator
    public SearchLoyaltyAccountsRequestLoyaltyAccountQuery(
            @JsonProperty("mappings") List<LoyaltyAccountMapping> mappings) {
        this.mappings = mappings;
    }

    private final List<LoyaltyAccountMapping> mappings;
    /**
     * Getter for Mappings.
     * The set of mappings to use in the loyalty account search.
     */
    @JsonGetter("mappings")
    public List<LoyaltyAccountMapping> getMappings() {
        return this.mappings;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(mappings);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchLoyaltyAccountsRequestLoyaltyAccountQuery)) {
            return false;
        }
        SearchLoyaltyAccountsRequestLoyaltyAccountQuery searchLoyaltyAccountsRequestLoyaltyAccountQuery = (SearchLoyaltyAccountsRequestLoyaltyAccountQuery) obj;
        return Objects.equals(mappings, searchLoyaltyAccountsRequestLoyaltyAccountQuery.mappings);
    }

    /**
     * Builds a new {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .mappings(getMappings());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery}
     */
    public static class Builder {
        private List<LoyaltyAccountMapping> mappings;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for mappings
         * @param mappings
         * @return Builder
         */
        public Builder mappings(List<LoyaltyAccountMapping> mappings) {
            this.mappings = mappings;
            return this;
        }

        /**
         * Builds a new {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery} object using the set fields.
         * @return {@link SearchLoyaltyAccountsRequestLoyaltyAccountQuery}
         */
        public SearchLoyaltyAccountsRequestLoyaltyAccountQuery build() {
            return new SearchLoyaltyAccountsRequestLoyaltyAccountQuery(mappings);
        }
    }
}
