package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for FilterValue type.
 */
public class FilterValue {

    /**
     * Initialization constructor.
     * @param all
     * @param any
     * @param none
     */
    @JsonCreator
    public FilterValue(
            @JsonProperty("all") List<String> all,
            @JsonProperty("any") List<String> any,
            @JsonProperty("none") List<String> none) {
        this.all = all;
        this.any = any;
        this.none = none;
    }

    private final List<String> all;
    private final List<String> any;
    private final List<String> none;
    /**
     * Getter for All.
     * A list of terms that must be present on the field of the resource.
     */
    @JsonGetter("all")
    public List<String> getAll() {
        return this.all;
    }

    /**
     * Getter for Any.
     * A list of terms where at least one of them must be present on the
     * field of the resource.
     */
    @JsonGetter("any")
    public List<String> getAny() {
        return this.any;
    }

    /**
     * Getter for None.
     * A list of terms that must not be present on the field the resource
     */
    @JsonGetter("none")
    public List<String> getNone() {
        return this.none;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(all, any, none);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof FilterValue)) {
            return false;
        }
        FilterValue filterValue = (FilterValue) obj;
        return Objects.equals(all, filterValue.all) &&
            Objects.equals(any, filterValue.any) &&
            Objects.equals(none, filterValue.none);
    }

    /**
     * Builds a new {@link FilterValue.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link FilterValue.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .all(getAll())
            .any(getAny())
            .none(getNone());
            return builder;
    }

    /**
     * Class to build instances of {@link FilterValue}
     */
    public static class Builder {
        private List<String> all;
        private List<String> any;
        private List<String> none;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for all
         * @param all
         * @return Builder
         */
        public Builder all(List<String> all) {
            this.all = all;
            return this;
        }
        /**
         * Setter for any
         * @param any
         * @return Builder
         */
        public Builder any(List<String> any) {
            this.any = any;
            return this;
        }
        /**
         * Setter for none
         * @param none
         * @return Builder
         */
        public Builder none(List<String> none) {
            this.none = none;
            return this;
        }

        /**
         * Builds a new {@link FilterValue} object using the set fields.
         * @return {@link FilterValue}
         */
        public FilterValue build() {
            return new FilterValue(all,
                any,
                none);
        }
    }
}
