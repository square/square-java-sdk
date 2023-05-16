
package com.squareup.square.models;

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
 * This is a model class for FilterValue type.
 */
public class FilterValue {
    private final OptionalNullable<List<String>> all;
    private final OptionalNullable<List<String>> any;
    private final OptionalNullable<List<String>> none;

    /**
     * Initialization constructor.
     * @param  all  List of String value for all.
     * @param  any  List of String value for any.
     * @param  none  List of String value for none.
     */
    @JsonCreator
    public FilterValue(
            @JsonProperty("all") List<String> all,
            @JsonProperty("any") List<String> any,
            @JsonProperty("none") List<String> none) {
        this.all = OptionalNullable.of(all);
        this.any = OptionalNullable.of(any);
        this.none = OptionalNullable.of(none);
    }

    /**
     * Internal initialization constructor.
     */
    protected FilterValue(OptionalNullable<List<String>> all, OptionalNullable<List<String>> any,
            OptionalNullable<List<String>> none) {
        this.all = all;
        this.any = any;
        this.none = none;
    }

    /**
     * Internal Getter for All.
     * A list of terms that must be present on the field of the resource.
     * @return Returns the Internal List of String
     */
    @JsonGetter("all")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetAll() {
        return this.all;
    }

    /**
     * Getter for All.
     * A list of terms that must be present on the field of the resource.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getAll() {
        return OptionalNullable.getFrom(all);
    }

    /**
     * Internal Getter for Any.
     * A list of terms where at least one of them must be present on the field of the resource.
     * @return Returns the Internal List of String
     */
    @JsonGetter("any")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetAny() {
        return this.any;
    }

    /**
     * Getter for Any.
     * A list of terms where at least one of them must be present on the field of the resource.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getAny() {
        return OptionalNullable.getFrom(any);
    }

    /**
     * Internal Getter for None.
     * A list of terms that must not be present on the field the resource
     * @return Returns the Internal List of String
     */
    @JsonGetter("none")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetNone() {
        return this.none;
    }

    /**
     * Getter for None.
     * A list of terms that must not be present on the field the resource
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getNone() {
        return OptionalNullable.getFrom(none);
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
     * Converts this FilterValue into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "FilterValue [" + "all=" + all + ", any=" + any + ", none=" + none + "]";
    }

    /**
     * Builds a new {@link FilterValue.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link FilterValue.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.all = internalGetAll();
        builder.any = internalGetAny();
        builder.none = internalGetNone();
        return builder;
    }

    /**
     * Class to build instances of {@link FilterValue}.
     */
    public static class Builder {
        private OptionalNullable<List<String>> all;
        private OptionalNullable<List<String>> any;
        private OptionalNullable<List<String>> none;



        /**
         * Setter for all.
         * @param  all  List of String value for all.
         * @return Builder
         */
        public Builder all(List<String> all) {
            this.all = OptionalNullable.of(all);
            return this;
        }

        /**
         * UnSetter for all.
         * @return Builder
         */
        public Builder unsetAll() {
            all = null;
            return this;
        }

        /**
         * Setter for any.
         * @param  any  List of String value for any.
         * @return Builder
         */
        public Builder any(List<String> any) {
            this.any = OptionalNullable.of(any);
            return this;
        }

        /**
         * UnSetter for any.
         * @return Builder
         */
        public Builder unsetAny() {
            any = null;
            return this;
        }

        /**
         * Setter for none.
         * @param  none  List of String value for none.
         * @return Builder
         */
        public Builder none(List<String> none) {
            this.none = OptionalNullable.of(none);
            return this;
        }

        /**
         * UnSetter for none.
         * @return Builder
         */
        public Builder unsetNone() {
            none = null;
            return this;
        }

        /**
         * Builds a new {@link FilterValue} object using the set fields.
         * @return {@link FilterValue}
         */
        public FilterValue build() {
            return new FilterValue(all, any, none);
        }
    }
}
