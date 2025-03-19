package com.squareup.square.legacy.models;

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
 * This is a model class for CheckoutLocationSettings type.
 */
public class CheckoutLocationSettings {
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<Boolean> customerNotesEnabled;
    private final OptionalNullable<List<CheckoutLocationSettingsPolicy>> policies;
    private final CheckoutLocationSettingsBranding branding;
    private final CheckoutLocationSettingsTipping tipping;
    private final CheckoutLocationSettingsCoupons coupons;
    private final String updatedAt;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  customerNotesEnabled  Boolean value for customerNotesEnabled.
     * @param  policies  List of CheckoutLocationSettingsPolicy value for policies.
     * @param  branding  CheckoutLocationSettingsBranding value for branding.
     * @param  tipping  CheckoutLocationSettingsTipping value for tipping.
     * @param  coupons  CheckoutLocationSettingsCoupons value for coupons.
     * @param  updatedAt  String value for updatedAt.
     */
    @JsonCreator
    public CheckoutLocationSettings(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("customer_notes_enabled") Boolean customerNotesEnabled,
            @JsonProperty("policies") List<CheckoutLocationSettingsPolicy> policies,
            @JsonProperty("branding") CheckoutLocationSettingsBranding branding,
            @JsonProperty("tipping") CheckoutLocationSettingsTipping tipping,
            @JsonProperty("coupons") CheckoutLocationSettingsCoupons coupons,
            @JsonProperty("updated_at") String updatedAt) {
        this.locationId = OptionalNullable.of(locationId);
        this.customerNotesEnabled = OptionalNullable.of(customerNotesEnabled);
        this.policies = OptionalNullable.of(policies);
        this.branding = branding;
        this.tipping = tipping;
        this.coupons = coupons;
        this.updatedAt = updatedAt;
    }

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  customerNotesEnabled  Boolean value for customerNotesEnabled.
     * @param  policies  List of CheckoutLocationSettingsPolicy value for policies.
     * @param  branding  CheckoutLocationSettingsBranding value for branding.
     * @param  tipping  CheckoutLocationSettingsTipping value for tipping.
     * @param  coupons  CheckoutLocationSettingsCoupons value for coupons.
     * @param  updatedAt  String value for updatedAt.
     */
    protected CheckoutLocationSettings(
            OptionalNullable<String> locationId,
            OptionalNullable<Boolean> customerNotesEnabled,
            OptionalNullable<List<CheckoutLocationSettingsPolicy>> policies,
            CheckoutLocationSettingsBranding branding,
            CheckoutLocationSettingsTipping tipping,
            CheckoutLocationSettingsCoupons coupons,
            String updatedAt) {
        this.locationId = locationId;
        this.customerNotesEnabled = customerNotesEnabled;
        this.policies = policies;
        this.branding = branding;
        this.tipping = tipping;
        this.coupons = coupons;
        this.updatedAt = updatedAt;
    }

    /**
     * Internal Getter for LocationId.
     * The ID of the location that these settings apply to.
     * @return Returns the Internal String
     */
    @JsonGetter("location_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLocationId() {
        return this.locationId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location that these settings apply to.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for CustomerNotesEnabled.
     * Indicates whether customers are allowed to leave notes at checkout.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("customer_notes_enabled")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetCustomerNotesEnabled() {
        return this.customerNotesEnabled;
    }

    /**
     * Getter for CustomerNotesEnabled.
     * Indicates whether customers are allowed to leave notes at checkout.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getCustomerNotesEnabled() {
        return OptionalNullable.getFrom(customerNotesEnabled);
    }

    /**
     * Internal Getter for Policies.
     * Policy information is displayed at the bottom of the checkout pages. You can set a maximum of
     * two policies.
     * @return Returns the Internal List of CheckoutLocationSettingsPolicy
     */
    @JsonGetter("policies")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<CheckoutLocationSettingsPolicy>> internalGetPolicies() {
        return this.policies;
    }

    /**
     * Getter for Policies.
     * Policy information is displayed at the bottom of the checkout pages. You can set a maximum of
     * two policies.
     * @return Returns the List of CheckoutLocationSettingsPolicy
     */
    @JsonIgnore
    public List<CheckoutLocationSettingsPolicy> getPolicies() {
        return OptionalNullable.getFrom(policies);
    }

    /**
     * Getter for Branding.
     * @return Returns the CheckoutLocationSettingsBranding
     */
    @JsonGetter("branding")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutLocationSettingsBranding getBranding() {
        return branding;
    }

    /**
     * Getter for Tipping.
     * @return Returns the CheckoutLocationSettingsTipping
     */
    @JsonGetter("tipping")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutLocationSettingsTipping getTipping() {
        return tipping;
    }

    /**
     * Getter for Coupons.
     * @return Returns the CheckoutLocationSettingsCoupons
     */
    @JsonGetter("coupons")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CheckoutLocationSettingsCoupons getCoupons() {
        return coupons;
    }

    /**
     * Getter for UpdatedAt.
     * The timestamp when the settings were last updated, in RFC 3339 format. Examples for January
     * 25th, 2020 6:25:34pm Pacific Standard Time: UTC: 2020-01-26T02:25:34Z Pacific Standard Time
     * with UTC offset: 2020-01-25T18:25:34-08:00
     * @return Returns the String
     */
    @JsonGetter("updated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, customerNotesEnabled, policies, branding, tipping, coupons, updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutLocationSettings)) {
            return false;
        }
        CheckoutLocationSettings other = (CheckoutLocationSettings) obj;
        return Objects.equals(locationId, other.locationId)
                && Objects.equals(customerNotesEnabled, other.customerNotesEnabled)
                && Objects.equals(policies, other.policies)
                && Objects.equals(branding, other.branding)
                && Objects.equals(tipping, other.tipping)
                && Objects.equals(coupons, other.coupons)
                && Objects.equals(updatedAt, other.updatedAt);
    }

    /**
     * Converts this CheckoutLocationSettings into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutLocationSettings [" + "locationId=" + locationId + ", customerNotesEnabled="
                + customerNotesEnabled + ", policies=" + policies + ", branding=" + branding
                + ", tipping=" + tipping + ", coupons=" + coupons + ", updatedAt=" + updatedAt
                + "]";
    }

    /**
     * Builds a new {@link CheckoutLocationSettings.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutLocationSettings.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .branding(getBranding())
                .tipping(getTipping())
                .coupons(getCoupons())
                .updatedAt(getUpdatedAt());
        builder.locationId = internalGetLocationId();
        builder.customerNotesEnabled = internalGetCustomerNotesEnabled();
        builder.policies = internalGetPolicies();
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutLocationSettings}.
     */
    public static class Builder {
        private OptionalNullable<String> locationId;
        private OptionalNullable<Boolean> customerNotesEnabled;
        private OptionalNullable<List<CheckoutLocationSettingsPolicy>> policies;
        private CheckoutLocationSettingsBranding branding;
        private CheckoutLocationSettingsTipping tipping;
        private CheckoutLocationSettingsCoupons coupons;
        private String updatedAt;

        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = OptionalNullable.of(locationId);
            return this;
        }

        /**
         * UnSetter for locationId.
         * @return Builder
         */
        public Builder unsetLocationId() {
            locationId = null;
            return this;
        }

        /**
         * Setter for customerNotesEnabled.
         * @param  customerNotesEnabled  Boolean value for customerNotesEnabled.
         * @return Builder
         */
        public Builder customerNotesEnabled(Boolean customerNotesEnabled) {
            this.customerNotesEnabled = OptionalNullable.of(customerNotesEnabled);
            return this;
        }

        /**
         * UnSetter for customerNotesEnabled.
         * @return Builder
         */
        public Builder unsetCustomerNotesEnabled() {
            customerNotesEnabled = null;
            return this;
        }

        /**
         * Setter for policies.
         * @param  policies  List of CheckoutLocationSettingsPolicy value for policies.
         * @return Builder
         */
        public Builder policies(List<CheckoutLocationSettingsPolicy> policies) {
            this.policies = OptionalNullable.of(policies);
            return this;
        }

        /**
         * UnSetter for policies.
         * @return Builder
         */
        public Builder unsetPolicies() {
            policies = null;
            return this;
        }

        /**
         * Setter for branding.
         * @param  branding  CheckoutLocationSettingsBranding value for branding.
         * @return Builder
         */
        public Builder branding(CheckoutLocationSettingsBranding branding) {
            this.branding = branding;
            return this;
        }

        /**
         * Setter for tipping.
         * @param  tipping  CheckoutLocationSettingsTipping value for tipping.
         * @return Builder
         */
        public Builder tipping(CheckoutLocationSettingsTipping tipping) {
            this.tipping = tipping;
            return this;
        }

        /**
         * Setter for coupons.
         * @param  coupons  CheckoutLocationSettingsCoupons value for coupons.
         * @return Builder
         */
        public Builder coupons(CheckoutLocationSettingsCoupons coupons) {
            this.coupons = coupons;
            return this;
        }

        /**
         * Setter for updatedAt.
         * @param  updatedAt  String value for updatedAt.
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Builds a new {@link CheckoutLocationSettings} object using the set fields.
         * @return {@link CheckoutLocationSettings}
         */
        public CheckoutLocationSettings build() {
            return new CheckoutLocationSettings(
                    locationId, customerNotesEnabled, policies, branding, tipping, coupons, updatedAt);
        }
    }
}
