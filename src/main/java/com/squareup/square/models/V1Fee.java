package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Fee type.
 */
public class V1Fee {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     * @param rate
     * @param calculationPhase
     * @param adjustmentType
     * @param appliesToCustomAmounts
     * @param enabled
     * @param inclusionType
     * @param type
     * @param v2Id
     */
    @JsonCreator
    public V1Fee(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("rate") String rate,
            @JsonProperty("calculation_phase") String calculationPhase,
            @JsonProperty("adjustment_type") String adjustmentType,
            @JsonProperty("applies_to_custom_amounts") Boolean appliesToCustomAmounts,
            @JsonProperty("enabled") Boolean enabled,
            @JsonProperty("inclusion_type") String inclusionType,
            @JsonProperty("type") String type,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.calculationPhase = calculationPhase;
        this.adjustmentType = adjustmentType;
        this.appliesToCustomAmounts = appliesToCustomAmounts;
        this.enabled = enabled;
        this.inclusionType = inclusionType;
        this.type = type;
        this.v2Id = v2Id;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String rate;
    private final String calculationPhase;
    private final String adjustmentType;
    private final Boolean appliesToCustomAmounts;
    private final Boolean enabled;
    private final String inclusionType;
    private final String type;
    private final String v2Id;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The fee's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The fee's name.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Rate.
     * The rate of the fee, as a string representation of a decimal number. A value of 0.07 corresponds to a rate of 7%.
     */
    @JsonGetter("rate")
    public String getRate() {
        return this.rate;
    }

    /**
     * Getter for CalculationPhase.
     */
    @JsonGetter("calculation_phase")
    public String getCalculationPhase() {
        return this.calculationPhase;
    }

    /**
     * Getter for AdjustmentType.
     */
    @JsonGetter("adjustment_type")
    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    /**
     * Getter for AppliesToCustomAmounts.
     * If true, the fee applies to custom amounts entered into Square Point of Sale that are not associated with a particular item.
     */
    @JsonGetter("applies_to_custom_amounts")
    public Boolean getAppliesToCustomAmounts() {
        return this.appliesToCustomAmounts;
    }

    /**
     * Getter for Enabled.
     * If true, the fee is applied to all appropriate items. If false, the fee is not applied at all.
     */
    @JsonGetter("enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Getter for InclusionType.
     */
    @JsonGetter("inclusion_type")
    public String getInclusionType() {
        return this.inclusionType;
    }

    /**
     * Getter for Type.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID.
     */
    @JsonGetter("v2_id")
    public String getV2Id() {
        return this.v2Id;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate, calculationPhase, adjustmentType, appliesToCustomAmounts,
            enabled, inclusionType, type, v2Id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Fee)) {
            return false;
        }
        V1Fee v1Fee = (V1Fee) obj;
        return Objects.equals(id, v1Fee.id) &&
            Objects.equals(name, v1Fee.name) &&
            Objects.equals(rate, v1Fee.rate) &&
            Objects.equals(calculationPhase, v1Fee.calculationPhase) &&
            Objects.equals(adjustmentType, v1Fee.adjustmentType) &&
            Objects.equals(appliesToCustomAmounts, v1Fee.appliesToCustomAmounts) &&
            Objects.equals(enabled, v1Fee.enabled) &&
            Objects.equals(inclusionType, v1Fee.inclusionType) &&
            Objects.equals(type, v1Fee.type) &&
            Objects.equals(v2Id, v1Fee.v2Id);
    }

    /**
     * Builds a new {@link V1Fee.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Fee.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .rate(getRate())
            .calculationPhase(getCalculationPhase())
            .adjustmentType(getAdjustmentType())
            .appliesToCustomAmounts(getAppliesToCustomAmounts())
            .enabled(getEnabled())
            .inclusionType(getInclusionType())
            .type(getType())
            .v2Id(getV2Id());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Fee}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String rate;
        private String calculationPhase;
        private String adjustmentType;
        private Boolean appliesToCustomAmounts;
        private Boolean enabled;
        private String inclusionType;
        private String type;
        private String v2Id;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        /**
         * Setter for rate
         * @param rate
         * @return Builder
         */
        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }
        /**
         * Setter for calculationPhase
         * @param calculationPhase
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
            return this;
        }
        /**
         * Setter for adjustmentType
         * @param adjustmentType
         * @return Builder
         */
        public Builder adjustmentType(String adjustmentType) {
            this.adjustmentType = adjustmentType;
            return this;
        }
        /**
         * Setter for appliesToCustomAmounts
         * @param appliesToCustomAmounts
         * @return Builder
         */
        public Builder appliesToCustomAmounts(Boolean appliesToCustomAmounts) {
            this.appliesToCustomAmounts = appliesToCustomAmounts;
            return this;
        }
        /**
         * Setter for enabled
         * @param enabled
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }
        /**
         * Setter for inclusionType
         * @param inclusionType
         * @return Builder
         */
        public Builder inclusionType(String inclusionType) {
            this.inclusionType = inclusionType;
            return this;
        }
        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for v2Id
         * @param v2Id
         * @return Builder
         */
        public Builder v2Id(String v2Id) {
            this.v2Id = v2Id;
            return this;
        }

        /**
         * Builds a new {@link V1Fee} object using the set fields.
         * @return {@link V1Fee}
         */
        public V1Fee build() {
            V1Fee model = new V1Fee(id,
                name,
                rate,
                calculationPhase,
                adjustmentType,
                appliesToCustomAmounts,
                enabled,
                inclusionType,
                type,
                v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
