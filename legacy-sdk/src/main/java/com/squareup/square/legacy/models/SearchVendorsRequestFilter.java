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
 * This is a model class for SearchVendorsRequestFilter type.
 */
public class SearchVendorsRequestFilter {
    private final OptionalNullable<List<String>> name;
    private final OptionalNullable<List<String>> status;

    /**
     * Initialization constructor.
     * @param  name  List of String value for name.
     * @param  status  List of String value for status.
     */
    @JsonCreator
    public SearchVendorsRequestFilter(
            @JsonProperty("name") List<String> name, @JsonProperty("status") List<String> status) {
        this.name = OptionalNullable.of(name);
        this.status = OptionalNullable.of(status);
    }

    /**
     * Initialization constructor.
     * @param  name  List of String value for name.
     * @param  status  List of String value for status.
     */
    protected SearchVendorsRequestFilter(OptionalNullable<List<String>> name, OptionalNullable<List<String>> status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Internal Getter for Name.
     * The names of the [Vendor](entity:Vendor) objects to retrieve.
     * @return Returns the Internal List of String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The names of the [Vendor](entity:Vendor) objects to retrieve.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getName() {
        return OptionalNullable.getFrom(name);
    }

    /**
     * Internal Getter for Status.
     * The statuses of the [Vendor](entity:Vendor) objects to retrieve. See
     * [VendorStatus](#type-vendorstatus) for possible values
     * @return Returns the Internal List of String
     */
    @JsonGetter("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetStatus() {
        return this.status;
    }

    /**
     * Getter for Status.
     * The statuses of the [Vendor](entity:Vendor) objects to retrieve. See
     * [VendorStatus](#type-vendorstatus) for possible values
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getStatus() {
        return OptionalNullable.getFrom(status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchVendorsRequestFilter)) {
            return false;
        }
        SearchVendorsRequestFilter other = (SearchVendorsRequestFilter) obj;
        return Objects.equals(name, other.name) && Objects.equals(status, other.status);
    }

    /**
     * Converts this SearchVendorsRequestFilter into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchVendorsRequestFilter [" + "name=" + name + ", status=" + status + "]";
    }

    /**
     * Builds a new {@link SearchVendorsRequestFilter.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchVendorsRequestFilter.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.name = internalGetName();
        builder.status = internalGetStatus();
        return builder;
    }

    /**
     * Class to build instances of {@link SearchVendorsRequestFilter}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> name;
        private OptionalNullable<List<String>> status;

        /**
         * Setter for name.
         * @param  name  List of String value for name.
         * @return Builder
         */
        public Builder name(List<String> name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
            return this;
        }

        /**
         * Setter for status.
         * @param  status  List of String value for status.
         * @return Builder
         */
        public Builder status(List<String> status) {
            this.status = OptionalNullable.of(status);
            return this;
        }

        /**
         * UnSetter for status.
         * @return Builder
         */
        public Builder unsetStatus() {
            status = null;
            return this;
        }

        /**
         * Builds a new {@link SearchVendorsRequestFilter} object using the set fields.
         * @return {@link SearchVendorsRequestFilter}
         */
        public SearchVendorsRequestFilter build() {
            return new SearchVendorsRequestFilter(name, status);
        }
    }
}
