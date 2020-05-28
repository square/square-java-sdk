package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomerTextFilter type.
 */
public class CustomerTextFilter {

    /**
     * Initialization constructor.
     * @param exact
     * @param fuzzy
     */
    @JsonCreator
    public CustomerTextFilter(
            @JsonProperty("exact") String exact,
            @JsonProperty("fuzzy") String fuzzy) {
        this.exact = exact;
        this.fuzzy = fuzzy;
    }

    private final String exact;
    private final String fuzzy;
    /**
     * Getter for Exact.
     * Use the exact filter to select customers whose attributes match exactly the specified query.
     */
    @JsonGetter("exact")
    public String getExact() {
        return this.exact;
    }

    /**
     * Getter for Fuzzy.
     * Use the fuzzy filter to select customers whose attributes match the specified query 
     * in a fuzzy manner. When the fuzzy option is used, search queries are tokenized, and then 
     * each query token must be matched somewhere in the searched attribute. For single token queries, 
     * this is effectively the same behavior as a partial match operation.
     */
    @JsonGetter("fuzzy")
    public String getFuzzy() {
        return this.fuzzy;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(exact, fuzzy);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomerTextFilter)) {
            return false;
        }
        CustomerTextFilter customerTextFilter = (CustomerTextFilter) obj;
        return Objects.equals(exact, customerTextFilter.exact) &&
            Objects.equals(fuzzy, customerTextFilter.fuzzy);
    }

    /**
     * Builds a new {@link CustomerTextFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerTextFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .exact(getExact())
            .fuzzy(getFuzzy());
            return builder;
    }

    /**
     * Class to build instances of {@link CustomerTextFilter}
     */
    public static class Builder {
        private String exact;
        private String fuzzy;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for exact
         * @param exact
         * @return Builder
         */
        public Builder exact(String exact) {
            this.exact = exact;
            return this;
        }
        /**
         * Setter for fuzzy
         * @param fuzzy
         * @return Builder
         */
        public Builder fuzzy(String fuzzy) {
            this.fuzzy = fuzzy;
            return this;
        }

        /**
         * Builds a new {@link CustomerTextFilter} object using the set fields.
         * @return {@link CustomerTextFilter}
         */
        public CustomerTextFilter build() {
            return new CustomerTextFilter(exact,
                fuzzy);
        }
    }
}
