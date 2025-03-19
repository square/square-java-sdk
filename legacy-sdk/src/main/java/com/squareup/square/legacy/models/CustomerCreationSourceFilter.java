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
 * This is a model class for CustomerCreationSourceFilter type.
 */
public class CustomerCreationSourceFilter {
    private final OptionalNullable<List<String>> values;
    private final String rule;

    /**
     * Initialization constructor.
     * @param  values  List of String value for values.
     * @param  rule  String value for rule.
     */
    @JsonCreator
    public CustomerCreationSourceFilter(
            @JsonProperty("values") List<String> values, @JsonProperty("rule") String rule) {
        this.values = OptionalNullable.of(values);
        this.rule = rule;
    }

    /**
     * Initialization constructor.
     * @param  values  List of String value for values.
     * @param  rule  String value for rule.
     */
    protected CustomerCreationSourceFilter(OptionalNullable<List<String>> values, String rule) {
        this.values = values;
        this.rule = rule;
    }

    /**
     * Internal Getter for Values.
     * The list of creation sources used as filtering criteria. See
     * [CustomerCreationSource](#type-customercreationsource) for possible values
     * @return Returns the Internal List of String
     */
    @JsonGetter("values")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetValues() {
        return this.values;
    }

    /**
     * Getter for Values.
     * The list of creation sources used as filtering criteria. See
     * [CustomerCreationSource](#type-customercreationsource) for possible values
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getValues() {
        return OptionalNullable.getFrom(values);
    }

    /**
     * Getter for Rule.
     * Indicates whether customers should be included in, or excluded from, the result set when they
     * match the filtering criteria.
     * @return Returns the String
     */
    @JsonGetter("rule")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getRule() {
        return rule;
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, rule);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerCreationSourceFilter)) {
            return false;
        }
        CustomerCreationSourceFilter other = (CustomerCreationSourceFilter) obj;
        return Objects.equals(values, other.values) && Objects.equals(rule, other.rule);
    }

    /**
     * Converts this CustomerCreationSourceFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerCreationSourceFilter [" + "values=" + values + ", rule=" + rule + "]";
    }

    /**
     * Builds a new {@link CustomerCreationSourceFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerCreationSourceFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().rule(getRule());
        builder.values = internalGetValues();
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerCreationSourceFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> values;
        private String rule;

        /**
         * Setter for values.
         * @param  values  List of String value for values.
         * @return Builder
         */
        public Builder values(List<String> values) {
            this.values = OptionalNullable.of(values);
            return this;
        }

        /**
         * UnSetter for values.
         * @return Builder
         */
        public Builder unsetValues() {
            values = null;
            return this;
        }

        /**
         * Setter for rule.
         * @param  rule  String value for rule.
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
            return new CustomerCreationSourceFilter(values, rule);
        }
    }
}
