/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = OrderUpdatedObject.Builder.class)
public final class OrderUpdatedObject {
    private final Optional<OrderUpdated> orderUpdated;

    private final Map<String, Object> additionalProperties;

    private OrderUpdatedObject(Optional<OrderUpdated> orderUpdated, Map<String, Object> additionalProperties) {
        this.orderUpdated = orderUpdated;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Information about the updated order.
     */
    @JsonProperty("order_updated")
    public Optional<OrderUpdated> getOrderUpdated() {
        return orderUpdated;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OrderUpdatedObject && equalTo((OrderUpdatedObject) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OrderUpdatedObject other) {
        return orderUpdated.equals(other.orderUpdated);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.orderUpdated);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<OrderUpdated> orderUpdated = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(OrderUpdatedObject other) {
            orderUpdated(other.getOrderUpdated());
            return this;
        }

        /**
         * <p>Information about the updated order.</p>
         */
        @JsonSetter(value = "order_updated", nulls = Nulls.SKIP)
        public Builder orderUpdated(Optional<OrderUpdated> orderUpdated) {
            this.orderUpdated = orderUpdated;
            return this;
        }

        public Builder orderUpdated(OrderUpdated orderUpdated) {
            this.orderUpdated = Optional.ofNullable(orderUpdated);
            return this;
        }

        public OrderUpdatedObject build() {
            return new OrderUpdatedObject(orderUpdated, additionalProperties);
        }
    }
}
