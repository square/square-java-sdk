
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for ItemVariationLocationOverrides type.
 */
public class ItemVariationLocationOverrides {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String locationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money priceMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String pricingType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Boolean trackInventory;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String inventoryAlertType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long inventoryAlertThreshold;

    /**
     * Initialization constructor.
     * @param  locationId  String value for locationId.
     * @param  priceMoney  Money value for priceMoney.
     * @param  pricingType  String value for pricingType.
     * @param  trackInventory  Boolean value for trackInventory.
     * @param  inventoryAlertType  String value for inventoryAlertType.
     * @param  inventoryAlertThreshold  Long value for inventoryAlertThreshold.
     */
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

    /**
     * Getter for LocationId.
     * The ID of the `Location`. This can include locations that are deactivated.
     * @return Returns the String
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return locationId;
    }

    /**
     * Getter for PriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("price_money")
    public Money getPriceMoney() {
        return priceMoney;
    }

    /**
     * Getter for PricingType.
     * Indicates whether the price of a CatalogItemVariation should be entered manually at the time
     * of sale.
     * @return Returns the String
     */
    @JsonGetter("pricing_type")
    public String getPricingType() {
        return pricingType;
    }

    /**
     * Getter for TrackInventory.
     * If `true`, inventory tracking is active for the `CatalogItemVariation` at this `Location`.
     * @return Returns the Boolean
     */
    @JsonGetter("track_inventory")
    public Boolean getTrackInventory() {
        return trackInventory;
    }

    /**
     * Getter for InventoryAlertType.
     * Indicates whether Square should alert the merchant when the inventory quantity of a
     * CatalogItemVariation is low.
     * @return Returns the String
     */
    @JsonGetter("inventory_alert_type")
    public String getInventoryAlertType() {
        return inventoryAlertType;
    }

    /**
     * Getter for InventoryAlertThreshold.
     * If the inventory quantity for the variation is less than or equal to this value and
     * `inventory_alert_type` is `LOW_QUANTITY`, the variation displays an alert in the merchant
     * dashboard. This value is always an integer.
     * @return Returns the Long
     */
    @JsonGetter("inventory_alert_threshold")
    public Long getInventoryAlertThreshold() {
        return inventoryAlertThreshold;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, priceMoney, pricingType, trackInventory, inventoryAlertType,
                inventoryAlertThreshold);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemVariationLocationOverrides)) {
            return false;
        }
        ItemVariationLocationOverrides other = (ItemVariationLocationOverrides) obj;
        return Objects.equals(locationId, other.locationId)
            && Objects.equals(priceMoney, other.priceMoney)
            && Objects.equals(pricingType, other.pricingType)
            && Objects.equals(trackInventory, other.trackInventory)
            && Objects.equals(inventoryAlertType, other.inventoryAlertType)
            && Objects.equals(inventoryAlertThreshold, other.inventoryAlertThreshold);
    }

    /**
     * Converts this ItemVariationLocationOverrides into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ItemVariationLocationOverrides [" + "locationId=" + locationId + ", priceMoney="
                + priceMoney + ", pricingType=" + pricingType + ", trackInventory=" + trackInventory
                + ", inventoryAlertType=" + inventoryAlertType + ", inventoryAlertThreshold="
                + inventoryAlertThreshold + "]";
    }

    /**
     * Builds a new {@link ItemVariationLocationOverrides.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ItemVariationLocationOverrides.Builder} object
     */
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

    /**
     * Class to build instances of {@link ItemVariationLocationOverrides}.
     */
    public static class Builder {
        private String locationId;
        private Money priceMoney;
        private String pricingType;
        private Boolean trackInventory;
        private String inventoryAlertType;
        private Long inventoryAlertThreshold;



        /**
         * Setter for locationId.
         * @param  locationId  String value for locationId.
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * Setter for priceMoney.
         * @param  priceMoney  Money value for priceMoney.
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Setter for pricingType.
         * @param  pricingType  String value for pricingType.
         * @return Builder
         */
        public Builder pricingType(String pricingType) {
            this.pricingType = pricingType;
            return this;
        }

        /**
         * Setter for trackInventory.
         * @param  trackInventory  Boolean value for trackInventory.
         * @return Builder
         */
        public Builder trackInventory(Boolean trackInventory) {
            this.trackInventory = trackInventory;
            return this;
        }

        /**
         * Setter for inventoryAlertType.
         * @param  inventoryAlertType  String value for inventoryAlertType.
         * @return Builder
         */
        public Builder inventoryAlertType(String inventoryAlertType) {
            this.inventoryAlertType = inventoryAlertType;
            return this;
        }

        /**
         * Setter for inventoryAlertThreshold.
         * @param  inventoryAlertThreshold  Long value for inventoryAlertThreshold.
         * @return Builder
         */
        public Builder inventoryAlertThreshold(Long inventoryAlertThreshold) {
            this.inventoryAlertThreshold = inventoryAlertThreshold;
            return this;
        }

        /**
         * Builds a new {@link ItemVariationLocationOverrides} object using the set fields.
         * @return {@link ItemVariationLocationOverrides}
         */
        public ItemVariationLocationOverrides build() {
            return new ItemVariationLocationOverrides(locationId, priceMoney, pricingType,
                    trackInventory, inventoryAlertType, inventoryAlertThreshold);
        }
    }
}
