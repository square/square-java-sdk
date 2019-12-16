package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerCreationSourceFilter {

    @JsonCreator
    public CustomerCreationSourceFilter(
            @JsonProperty("values") List<String> values,
            @JsonProperty("rule") String rule) {
        this.values = values;
        this.rule = rule;
    }

    private final List<String> values;
    private final String rule;

    @Override
    public int hashCode() {
        return Objects.hash(values, rule);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerCreationSourceFilter)) {
            return false;
        }
        CustomerCreationSourceFilter customerCreationSourceFilter = (CustomerCreationSourceFilter) o;
        return Objects.equals(values, customerCreationSourceFilter.values) &&
            Objects.equals(rule, customerCreationSourceFilter.rule);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .values(getValues())
            .rule(getRule());
            return builder;
    }

    public static class Builder {
        private List<String> values;
        private String rule;

        public Builder() { }

        public Builder values(List<String> value) {
            values = value;
            return this;
        }
        public Builder rule(String value) {
            rule = value;
            return this;
        }

        public CustomerCreationSourceFilter build() {
            return new CustomerCreationSourceFilter(values,
                rule);
        }
    }
}
