
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SubscriptionSource type.
 */
public class SubscriptionSource {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;

    /**
     * Initialization constructor.
     * @param  name  String value for name.
     */
    @JsonCreator
    public SubscriptionSource(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * Getter for Name.
     * The name used to identify the place (physical or digital) that a subscription originates. If
     * unset, the name defaults to the name of the application that created the subscription.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
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
        Builder builder = new Builder()
                .name(getName());
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionSource}.
     */
    public static class Builder {
        private String name;



        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
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
