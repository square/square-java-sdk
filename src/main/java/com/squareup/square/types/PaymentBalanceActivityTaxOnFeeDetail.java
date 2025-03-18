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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaymentBalanceActivityTaxOnFeeDetail.Builder.class)
public final class PaymentBalanceActivityTaxOnFeeDetail {
    private final Optional<String> paymentId;

    private final Optional<String> taxRateDescription;

    private final Map<String, Object> additionalProperties;

    private PaymentBalanceActivityTaxOnFeeDetail(
            Optional<String> paymentId, Optional<String> taxRateDescription, Map<String, Object> additionalProperties) {
        this.paymentId = paymentId;
        this.taxRateDescription = taxRateDescription;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The ID of the payment associated with this activity.
     */
    @JsonIgnore
    public Optional<String> getPaymentId() {
        if (paymentId == null) {
            return Optional.empty();
        }
        return paymentId;
    }

    /**
     * @return The description of the tax rate being applied. For example: &quot;GST&quot;, &quot;HST&quot;.
     */
    @JsonIgnore
    public Optional<String> getTaxRateDescription() {
        if (taxRateDescription == null) {
            return Optional.empty();
        }
        return taxRateDescription;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("payment_id")
    private Optional<String> _getPaymentId() {
        return paymentId;
    }

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NullableNonemptyFilter.class)
    @JsonProperty("tax_rate_description")
    private Optional<String> _getTaxRateDescription() {
        return taxRateDescription;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaymentBalanceActivityTaxOnFeeDetail
                && equalTo((PaymentBalanceActivityTaxOnFeeDetail) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaymentBalanceActivityTaxOnFeeDetail other) {
        return paymentId.equals(other.paymentId) && taxRateDescription.equals(other.taxRateDescription);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.paymentId, this.taxRateDescription);
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
        private Optional<String> paymentId = Optional.empty();

        private Optional<String> taxRateDescription = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(PaymentBalanceActivityTaxOnFeeDetail other) {
            paymentId(other.getPaymentId());
            taxRateDescription(other.getTaxRateDescription());
            return this;
        }

        @JsonSetter(value = "payment_id", nulls = Nulls.SKIP)
        public Builder paymentId(Optional<String> paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder paymentId(String paymentId) {
            this.paymentId = Optional.ofNullable(paymentId);
            return this;
        }

        public Builder paymentId(Nullable<String> paymentId) {
            if (paymentId.isNull()) {
                this.paymentId = null;
            } else if (paymentId.isEmpty()) {
                this.paymentId = Optional.empty();
            } else {
                this.paymentId = Optional.of(paymentId.get());
            }
            return this;
        }

        @JsonSetter(value = "tax_rate_description", nulls = Nulls.SKIP)
        public Builder taxRateDescription(Optional<String> taxRateDescription) {
            this.taxRateDescription = taxRateDescription;
            return this;
        }

        public Builder taxRateDescription(String taxRateDescription) {
            this.taxRateDescription = Optional.ofNullable(taxRateDescription);
            return this;
        }

        public Builder taxRateDescription(Nullable<String> taxRateDescription) {
            if (taxRateDescription.isNull()) {
                this.taxRateDescription = null;
            } else if (taxRateDescription.isEmpty()) {
                this.taxRateDescription = Optional.empty();
            } else {
                this.taxRateDescription = Optional.of(taxRateDescription.get());
            }
            return this;
        }

        public PaymentBalanceActivityTaxOnFeeDetail build() {
            return new PaymentBalanceActivityTaxOnFeeDetail(paymentId, taxRateDescription, additionalProperties);
        }
    }
}
