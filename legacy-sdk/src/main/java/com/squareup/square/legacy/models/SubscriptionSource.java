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
 * This is a model class for SubscriptionSource type.
 */
public class SubscriptionSource {
    private final OptionalNullable<String> name;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     */
    @JsonCreator
    public SubscriptionSource(@JsonProperty("name") String name) {
        this.name = OptionalNullable.of(name);
    }

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     */
    protected SubscriptionSource(OptionalNullable<String> name) {
        this.name = name;
    }

    /**
     * Internal Getter for Name.
     * The name used to identify the place (physical or digital) that a subscription originates. If
     * unset, the name defaults to the name of the application that created the subscription.
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * The name used to identify the place (physical or digital) that a subscription originates. If
     * unset, the name defaults to the name of the application that created the subscription.
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionSource)) {
            return false;
        }
        SubscriptionSource other = (SubscriptionSource) obj;
        return Objects.equals(name, other.name);
    }

    /**
     * Converts this SubscriptionSource into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionSource [" + "name=" + name + "]";
    }

    /**
     * Builds a new {@link SubscriptionSource.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionSource.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.name = internalGetName();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionSource}.
     */
    public static class Builder {
        private OptionalNullable<String> name;

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
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
         * Builds a new {@link SubscriptionSource} object using the set fields.
         * @return {@link SubscriptionSource}
         */
        public SubscriptionSource build() {
            return new SubscriptionSource(name);
        }
    }
}
