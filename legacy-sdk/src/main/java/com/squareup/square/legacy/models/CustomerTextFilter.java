package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CustomerTextFilter type.
 */
public class CustomerTextFilter {
    private final OptionalNullable<String> exact;
    private final OptionalNullable<String> fuzzy;

    /**
     * Initialization constructor.
     * @param  exact  String value for exact.
     * @param  fuzzy  String value for fuzzy.
     */
    @JsonCreator
    public CustomerTextFilter(@JsonProperty("exact") String exact, @JsonProperty("fuzzy") String fuzzy) {
        this.exact = OptionalNullable.of(exact);
        this.fuzzy = OptionalNullable.of(fuzzy);
    }

    /**
     * Initialization constructor.
     * @param  exact  String value for exact.
     * @param  fuzzy  String value for fuzzy.
     */
    protected CustomerTextFilter(OptionalNullable<String> exact, OptionalNullable<String> fuzzy) {
        this.exact = exact;
        this.fuzzy = fuzzy;
    }

    /**
     * Internal Getter for Exact.
     * Use the exact filter to select customers whose attributes match exactly the specified query.
     * @return Returns the Internal String
     */
    @JsonGetter("exact")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetExact() {
        return this.exact;
    }

    /**
     * Getter for Exact.
     * Use the exact filter to select customers whose attributes match exactly the specified query.
     * @return Returns the String
     */
    @JsonIgnore
    public String getExact() {
        return OptionalNullable.getFrom(exact);
    }

    /**
     * Internal Getter for Fuzzy.
     * Use the fuzzy filter to select customers whose attributes match the specified query in a
     * fuzzy manner. When the fuzzy option is used, search queries are tokenized, and then each
     * query token must be matched somewhere in the searched attribute. For single token queries,
     * this is effectively the same behavior as a partial match operation.
     * @return Returns the Internal String
     */
    @JsonGetter("fuzzy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFuzzy() {
        return this.fuzzy;
    }

    /**
     * Getter for Fuzzy.
     * Use the fuzzy filter to select customers whose attributes match the specified query in a
     * fuzzy manner. When the fuzzy option is used, search queries are tokenized, and then each
     * query token must be matched somewhere in the searched attribute. For single token queries,
     * this is effectively the same behavior as a partial match operation.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFuzzy() {
        return OptionalNullable.getFrom(fuzzy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exact, fuzzy);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerTextFilter)) {
            return false;
        }
        CustomerTextFilter other = (CustomerTextFilter) obj;
        return Objects.equals(exact, other.exact) && Objects.equals(fuzzy, other.fuzzy);
    }

    /**
     * Converts this CustomerTextFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerTextFilter [" + "exact=" + exact + ", fuzzy=" + fuzzy + "]";
    }

    /**
     * Builds a new {@link CustomerTextFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerTextFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.exact = internalGetExact();
        builder.fuzzy = internalGetFuzzy();
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerTextFilter}.
     */
    public static class Builder {
        private OptionalNullable<String> exact;
        private OptionalNullable<String> fuzzy;

        /**
         * Setter for exact.
         * @param  exact  String value for exact.
         * @return Builder
         */
        public Builder exact(String exact) {
            this.exact = OptionalNullable.of(exact);
            return this;
        }

        /**
         * UnSetter for exact.
         * @return Builder
         */
        public Builder unsetExact() {
            exact = null;
            return this;
        }

        /**
         * Setter for fuzzy.
         * @param  fuzzy  String value for fuzzy.
         * @return Builder
         */
        public Builder fuzzy(String fuzzy) {
            this.fuzzy = OptionalNullable.of(fuzzy);
            return this;
        }

        /**
         * UnSetter for fuzzy.
         * @return Builder
         */
        public Builder unsetFuzzy() {
            fuzzy = null;
            return this;
        }

        /**
         * Builds a new {@link CustomerTextFilter} object using the set fields.
         * @return {@link CustomerTextFilter}
         */
        public CustomerTextFilter build() {
            return new CustomerTextFilter(exact, fuzzy);
        }
    }
}
