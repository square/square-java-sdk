
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for FilterValue type.
 */
public class FilterValue {
    private final List<String> all;
    private final List<String> any;
    private final List<String> none;

    /**
     * Initialization constructor.
     * @param all List of String value for all.
     * @param any List of String value for any.
     * @param none List of String value for none.
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

    /**
     * Getter for All.
     * A list of terms that must be present on the field of the resource.
     * @return Returns the List of String
     */
    @JsonGetter("all")
    public List<String> getAll() {
        return this.all;
    }

    /**
     * Getter for Any.
     * A list of terms where at least one of them must be present on the field of the resource.
     * @return Returns the List of String
     */
    @JsonGetter("any")
    public List<String> getAny() {
        return this.any;
    }

    /**
     * Getter for None.
     * A list of terms that must not be present on the field the resource
     * @return Returns the List of String
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FilterValue)) {
            return false;
        }
        FilterValue other = (FilterValue) obj;
        return Objects.equals(all, other.all)
            && Objects.equals(any, other.any)
            && Objects.equals(none, other.none);
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
     * Class to build instances of {@link FilterValue}.
     */
    public static class Builder {
        private List<String> all;
        private List<String> any;
        private List<String> none;



        /**
         * Setter for all.
         * @param all List of String value for all.
         * @return Builder
         */
        public Builder all(List<String> all) {
            this.all = all;
            return this;
        }

        /**
         * Setter for any.
         * @param any List of String value for any.
         * @return Builder
         */
        public Builder any(List<String> any) {
            this.any = any;
            return this;
        }

        /**
         * Setter for none.
         * @param none List of String value for none.
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
