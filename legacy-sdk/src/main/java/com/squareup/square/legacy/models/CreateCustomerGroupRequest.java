package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CreateCustomerGroupRequest type.
 */
public class CreateCustomerGroupRequest {
    private final String idempotencyKey;
    private final CustomerGroup group;

    /**
     * Initialization constructor.
     * @param  group  CustomerGroup value for group.
     * @param  idempotencyKey  String value for idempotencyKey.
     */
    @JsonCreator
    public CreateCustomerGroupRequest(
            @JsonProperty("group") CustomerGroup group, @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.group = group;
    }

    /**
     * Getter for IdempotencyKey.
     * The idempotency key for the request. For more information, see
     * [Idempotency](https://developer.squareup.com/docs/build-basics/common-api-patterns/idempotency).
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Group.
     * Represents a group of customer profiles. Customer groups can be created, be modified, and
     * have their membership defined using the Customers API or within the Customer Directory in the
     * Square Seller Dashboard or Point of Sale.
     * @return Returns the CustomerGroup
     */
    @JsonGetter("group")
    public CustomerGroup getGroup() {
        return group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, group);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCustomerGroupRequest)) {
            return false;
        }
        CreateCustomerGroupRequest other = (CreateCustomerGroupRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey) && Objects.equals(group, other.group);
    }

    /**
     * Converts this CreateCustomerGroupRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCustomerGroupRequest [" + "group=" + group + ", idempotencyKey=" + idempotencyKey + "]";
    }

    /**
     * Builds a new {@link CreateCustomerGroupRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCustomerGroupRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(group).idempotencyKey(getIdempotencyKey());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCustomerGroupRequest}.
     */
    public static class Builder {
        private CustomerGroup group;
        private String idempotencyKey;

        /**
         * Initialization constructor.
         * @param  group  CustomerGroup value for group.
         */
        public Builder(CustomerGroup group) {
            this.group = group;
        }

        /**
         * Setter for group.
         * @param  group  CustomerGroup value for group.
         * @return Builder
         */
        public Builder group(CustomerGroup group) {
            this.group = group;
            return this;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateCustomerGroupRequest} object using the set fields.
         * @return {@link CreateCustomerGroupRequest}
         */
        public CreateCustomerGroupRequest build() {
            return new CreateCustomerGroupRequest(group, idempotencyKey);
        }
    }
}
