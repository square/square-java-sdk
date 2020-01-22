package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomerCreationSourceFilter type.
 */
public class CustomerCreationSourceFilter {

    /**
     * Initialization constructor.
     * @param values
     * @param rule
     */
    @JsonCreator
    public CustomerCreationSourceFilter(
            @JsonProperty("values") List<String> values,
            @JsonProperty("rule") String rule) {
        this.values = values;
        this.rule = rule;
    }

    private final List<String> values;
    private final String rule;
    /**
     * Getter for Values.
     * The list of creation sources used as filtering criteria.
     * See [CustomerCreationSource](#type-customercreationsource) for possible values
     */
    @JsonGetter("values")
    public List<String> getValues() {
        return this.values;
    }

    /**
     * Getter for Rule.
     * Indicates whether customers should be included in, or excluded from,
     * the result set when they match the filtering criteria.
     */
    @JsonGetter("rule")
    public String getRule() {
        return this.rule;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(values, rule);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomerCreationSourceFilter)) {
            return false;
        }
        CustomerCreationSourceFilter customerCreationSourceFilter = (CustomerCreationSourceFilter) obj;
        return Objects.equals(values, customerCreationSourceFilter.values) &&
            Objects.equals(rule, customerCreationSourceFilter.rule);
    }

    /**
     * Builds a new {@link CustomerCreationSourceFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerCreationSourceFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .values(getValues())
            .rule(getRule());
            return builder;
    }

    /**
     * Class to build instances of {@link CustomerCreationSourceFilter}
     */
    public static class Builder {
        private List<String> values;
        private String rule;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for values
         * @param values
         * @return Builder
         */
        public Builder values(List<String> values) {
            this.values = values;
            return this;
        }
        /**
         * Setter for rule
         * @param rule
         * @return Builder
         */
        public Builder rule(String rule) {
            this.rule = rule;
            return this;
        }

        /**
         * Builds a new {@link CustomerCreationSourceFilter} object using the set fields.
         * @return {@link CustomerCreationSourceFilter}
         */
        public CustomerCreationSourceFilter build() {
            return new CustomerCreationSourceFilter(values,
                rule);
        }
    }
}
