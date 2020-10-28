
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for UpdateCustomerGroupRequest type.
 */
public class UpdateCustomerGroupRequest {
    private final CustomerGroup group;

    /**
     * Initialization constructor.
     * @param group CustomerGroup value for group.
     */
    @JsonCreator
    public UpdateCustomerGroupRequest(
            @JsonProperty("group") CustomerGroup group) {
        this.group = group;
    }

    /**
     * Getter for Group.
     * Represents a group of customer profiles. Customer groups can be created, modified, and have
     * their membership defined either via the Customers API or within Customer Directory in the
     * Square Dashboard or Point of Sale.
     * @return Returns the CustomerGroup
     */
    @JsonGetter("group")
    public CustomerGroup getGroup() {
        return this.group;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(group);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateCustomerGroupRequest)) {
            return false;
        }
        UpdateCustomerGroupRequest other = (UpdateCustomerGroupRequest) obj;
        return Objects.equals(group, other.group);
    }

    /**
     * Builds a new {@link UpdateCustomerGroupRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateCustomerGroupRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(group);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateCustomerGroupRequest}.
     */
    public static class Builder {
        private CustomerGroup group;

        /**
         * Initialization constructor.
         * @param group CustomerGroup value for group.
         */
        public Builder(CustomerGroup group) {
            this.group = group;
        }

        /**
         * Setter for group.
         * @param group CustomerGroup value for group.
         * @return Builder
         */
        public Builder group(CustomerGroup group) {
            this.group = group;
            return this;
        }

        /**
         * Builds a new {@link UpdateCustomerGroupRequest} object using the set fields.
         * @return {@link UpdateCustomerGroupRequest}
         */
        public UpdateCustomerGroupRequest build() {
            return new UpdateCustomerGroupRequest(group);
        }
    }
}
