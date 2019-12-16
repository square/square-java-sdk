package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ItemVariationLocationOverrides {

    @JsonCreator
    public ItemVariationLocationOverrides(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("price_money") Money priceMoney,
            @JsonProperty("pricing_type") String pricingType,
            @JsonProperty("track_inventory") Boolean trackInventory,
            @JsonProperty("inventory_alert_type") String inventoryAlertType,
            @JsonProperty("inventory_alert_threshold") Long inventoryAlertThreshold) {
        this.locationId = locationId;
        this.priceMoney = priceMoney;
        this.pricingType = pricingType;
        this.trackInventory = trackInventory;
        this.inventoryAlertType = inventoryAlertType;
        this.inventoryAlertThreshold = inventoryAlertThreshold;
    }

    private final String locationId;
    private final Money priceMoney;
    private final String pricingType;
    private final Boolean trackInventory;
    private final String inventoryAlertType;
    private final Long inventoryAlertThreshold;

    @Override
    public int hashCode() {
        return Objects.hash(locationId, priceMoney, pricingType, trackInventory, inventoryAlertType, inventoryAlertThreshold);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemVariationLocationOverrides)) {
            return false;
        }
        ItemVariationLocationOverrides itemVariationLocationOverrides = (ItemVariationLocationOverrides) o;
        return Objects.equals(locationId, itemVariationLocationOverrides.locationId) &&
            Objects.equals(priceMoney, itemVariationLocationOverrides.priceMoney) &&
            Objects.equals(pricingType, itemVariationLocationOverrides.pricingType) &&
            Objects.equals(trackInventory, itemVariationLocationOverrides.trackInventory) &&
            Objects.equals(inventoryAlertType, itemVariationLocationOverrides.inventoryAlertType) &&
            Objects.equals(inventoryAlertThreshold, itemVariationLocationOverrides.inventoryAlertThreshold);
    }

    /**
     * Getter for LocationId.
     * The ID of the `Location`.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for PriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("price_money")
    public Money getPriceMoney() { 
        return this.priceMoney;
    }

    /**
     * Getter for PricingType.
     * Indicates whether the price of a CatalogItemVariation should be entered manually at the time of sale.
     */
    @JsonGetter("pricing_type")
    public String getPricingType() { 
        return this.pricingType;
    }

    /**
     * Getter for TrackInventory.
     * If `true`, inventory tracking is active for the `CatalogItemVariation` at this `Location`.
     */
    @JsonGetter("track_inventory")
    public Boolean getTrackInventory() { 
        return this.trackInventory;
    }

    /**
     * Getter for InventoryAlertType.
     * Indicates whether Square should alert the merchant when the inventory quantity of a CatalogItemVariation is low.
     */
    @JsonGetter("inventory_alert_type")
    public String getInventoryAlertType() { 
        return this.inventoryAlertType;
    }

    /**
     * Getter for InventoryAlertThreshold.
     * If the inventory quantity for the variation is less than or equal to this value and `inventory_alert_type`
     * is `LOW_QUANTITY`, the variation displays an alert in the merchant dashboard.
     * This value is always an integer.
     */
    @JsonGetter("inventory_alert_threshold")
    public Long getInventoryAlertThreshold() { 
        return this.inventoryAlertThreshold;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .locationId(getLocationId())
            .priceMoney(getPriceMoney())
            .pricingType(getPricingType())
            .trackInventory(getTrackInventory())
            .inventoryAlertType(getInventoryAlertType())
            .inventoryAlertThreshold(getInventoryAlertThreshold());
            return builder;
    }

    public static class Builder {
        private String locationId;
        private Money priceMoney;
        private String pricingType;
        private Boolean trackInventory;
        private String inventoryAlertType;
        private Long inventoryAlertThreshold;

        public Builder() { }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder priceMoney(Money value) {
            priceMoney = value;
            return this;
        }
        public Builder pricingType(String value) {
            pricingType = value;
            return this;
        }
        public Builder trackInventory(Boolean value) {
            trackInventory = value;
            return this;
        }
        public Builder inventoryAlertType(String value) {
            inventoryAlertType = value;
            return this;
        }
        public Builder inventoryAlertThreshold(Long value) {
            inventoryAlertThreshold = value;
            return this;
        }

        public ItemVariationLocationOverrides build() {
            return new ItemVariationLocationOverrides(locationId,
                priceMoney,
                pricingType,
                trackInventory,
                inventoryAlertType,
                inventoryAlertThreshold);
        }
    }
}
