
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.Objects;

/**
 * This is a model class for V1Fee type.
 */
public class V1Fee {
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

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param name String value for name.
     * @param rate String value for rate.
     * @param calculationPhase String value for calculationPhase.
     * @param adjustmentType String value for adjustmentType.
     * @param appliesToCustomAmounts Boolean value for appliesToCustomAmounts.
     * @param enabled Boolean value for enabled.
     * @param inclusionType String value for inclusionType.
     * @param type String value for type.
     * @param v2Id String value for v2Id.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The fee's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The fee's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Rate.
     * The rate of the fee, as a string representation of a decimal number. A value of 0.07
     * corresponds to a rate of 7%.
     * @return Returns the String
     */
    @JsonGetter("rate")
    public String getRate() {
        return this.rate;
    }

    /**
     * Getter for CalculationPhase.
     * @return Returns the String
     */
    @JsonGetter("calculation_phase")
    public String getCalculationPhase() {
        return this.calculationPhase;
    }

    /**
     * Getter for AdjustmentType.
     * @return Returns the String
     */
    @JsonGetter("adjustment_type")
    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    /**
     * Getter for AppliesToCustomAmounts.
     * If true, the fee applies to custom amounts entered into Square Point of Sale that are not
     * associated with a particular item.
     * @return Returns the Boolean
     */
    @JsonGetter("applies_to_custom_amounts")
    public Boolean getAppliesToCustomAmounts() {
        return this.appliesToCustomAmounts;
    }

    /**
     * Getter for Enabled.
     * If true, the fee is applied to all appropriate items. If false, the fee is not applied at
     * all.
     * @return Returns the Boolean
     */
    @JsonGetter("enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Getter for InclusionType.
     * @return Returns the String
     */
    @JsonGetter("inclusion_type")
    public String getInclusionType() {
        return this.inclusionType;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple
     * locations share the same v2 ID.
     * @return Returns the String
     */
    @JsonGetter("v2_id")
    public String getV2Id() {
        return this.v2Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rate, calculationPhase, adjustmentType,
                appliesToCustomAmounts, enabled, inclusionType, type, v2Id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Fee)) {
            return false;
        }
        V1Fee other = (V1Fee) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(rate, other.rate)
            && Objects.equals(calculationPhase, other.calculationPhase)
            && Objects.equals(adjustmentType, other.adjustmentType)
            && Objects.equals(appliesToCustomAmounts, other.appliesToCustomAmounts)
            && Objects.equals(enabled, other.enabled)
            && Objects.equals(inclusionType, other.inclusionType)
            && Objects.equals(type, other.type)
            && Objects.equals(v2Id, other.v2Id);
    }

    /**
     * Converts this V1Fee into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "V1Fee [" + "id=" + id + ", name=" + name + ", rate=" + rate + ", calculationPhase="
                + calculationPhase + ", adjustmentType=" + adjustmentType
                + ", appliesToCustomAmounts=" + appliesToCustomAmounts + ", enabled=" + enabled
                + ", inclusionType=" + inclusionType + ", type=" + type + ", v2Id=" + v2Id + "]";
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
     * Class to build instances of {@link V1Fee}.
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
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for rate.
         * @param rate String value for rate.
         * @return Builder
         */
        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }

        /**
         * Setter for calculationPhase.
         * @param calculationPhase String value for calculationPhase.
         * @return Builder
         */
        public Builder calculationPhase(String calculationPhase) {
            this.calculationPhase = calculationPhase;
            return this;
        }

        /**
         * Setter for adjustmentType.
         * @param adjustmentType String value for adjustmentType.
         * @return Builder
         */
        public Builder adjustmentType(String adjustmentType) {
            this.adjustmentType = adjustmentType;
            return this;
        }

        /**
         * Setter for appliesToCustomAmounts.
         * @param appliesToCustomAmounts Boolean value for appliesToCustomAmounts.
         * @return Builder
         */
        public Builder appliesToCustomAmounts(Boolean appliesToCustomAmounts) {
            this.appliesToCustomAmounts = appliesToCustomAmounts;
            return this;
        }

        /**
         * Setter for enabled.
         * @param enabled Boolean value for enabled.
         * @return Builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Setter for inclusionType.
         * @param inclusionType String value for inclusionType.
         * @return Builder
         */
        public Builder inclusionType(String inclusionType) {
            this.inclusionType = inclusionType;
            return this;
        }

        /**
         * Setter for type.
         * @param type String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for v2Id.
         * @param v2Id String value for v2Id.
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
            V1Fee model =
                    new V1Fee(id, name, rate, calculationPhase, adjustmentType,
                            appliesToCustomAmounts, enabled, inclusionType, type, v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
