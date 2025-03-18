/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.Nullable;
import com.squareup.square.core.NullableNonemptyFilter;
import com.squareup.square.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = OrderLineItemAppliedDiscount.Builder.class)
public final class OrderLineItemAppliedDiscount {
    private final Optional<String> uid;

    private final String discountUid;

    private final Optional<Money> appliedMoney;

    private final Map<String, Object> additionalProperties;

    private OrderLineItemAppliedDiscount(
            Optional<String> uid,
            String discountUid,
            Optional<Money> appliedMoney,
            Map<String, Object> additionalProperties) {
        this.uid = uid;
        this.discountUid = discountUid;
        this.appliedMoney = appliedMoney;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A unique ID that identifies the applied discount only within this order.
     */
    @JsonIgnore
    public Optional<String> getUid() {
        if (uid == null) {
            return Optional.empty();
        }
        return uid;
    }

    /**
     * @return The <code>uid</code> of the discount that the applied discount represents. It must
     * reference a discount present in the <code>order.discounts</code> field.
     * <p>This field is immutable. To change which discounts apply to a line item,
     * you must delete the discount and re-add it as a new <code>OrderLineItemAppliedDiscount</code>.</p>
     */
    @JsonProperty("discount_uid")
    public String getDiscountUid() {
        return discountUid;
    }

    /**
     * @return The amount of money applied by the discount to the line item.
     */
    @JsonProperty("applied_money")
    public Optional<Money> getAppliedMoney() {
        return appliedMoney;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("uid")
    private Optional<String> _getUid() {
        return uid;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OrderLineItemAppliedDiscount && equalTo((OrderLineItemAppliedDiscount) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(OrderLineItemAppliedDiscount other) {
        return uid.equals(other.uid)
                && discountUid.equals(other.discountUid)
                && appliedMoney.equals(other.appliedMoney);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.uid, this.discountUid, this.appliedMoney);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DiscountUidStage builder() {
        return new Builder();
    }

    public interface DiscountUidStage {
        _FinalStage discountUid(@NotNull String discountUid);

        Builder from(OrderLineItemAppliedDiscount other);
    }

    public interface _FinalStage {
        OrderLineItemAppliedDiscount build();

        _FinalStage uid(Optional<String> uid);

        _FinalStage uid(String uid);

        _FinalStage uid(Nullable<String> uid);

        _FinalStage appliedMoney(Optional<Money> appliedMoney);

        _FinalStage appliedMoney(Money appliedMoney);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DiscountUidStage, _FinalStage {
        private String discountUid;

        private Optional<Money> appliedMoney = Optional.empty();

        private Optional<String> uid = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(OrderLineItemAppliedDiscount other) {
            uid(other.getUid());
            discountUid(other.getDiscountUid());
            appliedMoney(other.getAppliedMoney());
            return this;
        }

        /**
         * <p>The <code>uid</code> of the discount that the applied discount represents. It must
         * reference a discount present in the <code>order.discounts</code> field.</p>
         * <p>This field is immutable. To change which discounts apply to a line item,
         * you must delete the discount and re-add it as a new <code>OrderLineItemAppliedDiscount</code>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("discount_uid")
        public _FinalStage discountUid(@NotNull String discountUid) {
            this.discountUid = Objects.requireNonNull(discountUid, "discountUid must not be null");
            return this;
        }

        /**
         * <p>The amount of money applied by the discount to the line item.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage appliedMoney(Money appliedMoney) {
            this.appliedMoney = Optional.ofNullable(appliedMoney);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "applied_money", nulls = Nulls.SKIP)
        public _FinalStage appliedMoney(Optional<Money> appliedMoney) {
            this.appliedMoney = appliedMoney;
            return this;
        }

        /**
         * <p>A unique ID that identifies the applied discount only within this order.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage uid(Nullable<String> uid) {
            if (uid.isNull()) {
                this.uid = null;
            } else if (uid.isEmpty()) {
                this.uid = Optional.empty();
            } else {
                this.uid = Optional.of(uid.get());
            }
            return this;
        }

        /**
         * <p>A unique ID that identifies the applied discount only within this order.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        public _FinalStage uid(String uid) {
            this.uid = Optional.ofNullable(uid);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "uid", nulls = Nulls.SKIP)
        public _FinalStage uid(Optional<String> uid) {
            this.uid = uid;
            return this;
        }

        @java.lang.Override
        public OrderLineItemAppliedDiscount build() {
            return new OrderLineItemAppliedDiscount(uid, discountUid, appliedMoney, additionalProperties);
        }
    }
}
