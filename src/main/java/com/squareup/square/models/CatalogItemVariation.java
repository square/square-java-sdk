
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CatalogItemVariation type.
 */
public class CatalogItemVariation {
    private final String itemId;
    private final String name;
    private final String sku;
    private final String upc;
    private final Integer ordinal;
    private final String pricingType;
    private final Money priceMoney;
    private final List<ItemVariationLocationOverrides> locationOverrides;
    private final Boolean trackInventory;
    private final String inventoryAlertType;
    private final Long inventoryAlertThreshold;
    private final String userData;
    private final Long serviceDuration;
    private final Boolean availableForBooking;
    private final List<CatalogItemOptionValueForItemVariation> itemOptionValues;
    private final String measurementUnitId;
    private final List<String> teamMemberIds;

    /**
     * Initialization constructor.
     * @param itemId String value for itemId.
     * @param name String value for name.
     * @param sku String value for sku.
     * @param upc String value for upc.
     * @param ordinal Integer value for ordinal.
     * @param pricingType String value for pricingType.
     * @param priceMoney Money value for priceMoney.
     * @param locationOverrides List of ItemVariationLocationOverrides value for locationOverrides.
     * @param trackInventory Boolean value for trackInventory.
     * @param inventoryAlertType String value for inventoryAlertType.
     * @param inventoryAlertThreshold Long value for inventoryAlertThreshold.
     * @param userData String value for userData.
     * @param serviceDuration Long value for serviceDuration.
     * @param availableForBooking Boolean value for availableForBooking.
     * @param itemOptionValues List of CatalogItemOptionValueForItemVariation value for itemOptionValues.
     * @param measurementUnitId String value for measurementUnitId.
     * @param teamMemberIds List of String value for teamMemberIds.
     */
    @JsonCreator
    public CatalogItemVariation(
            @JsonProperty("item_id") String itemId,
            @JsonProperty("name") String name,
            @JsonProperty("sku") String sku,
            @JsonProperty("upc") String upc,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("pricing_type") String pricingType,
            @JsonProperty("price_money") Money priceMoney,
            @JsonProperty("location_overrides") List<ItemVariationLocationOverrides> locationOverrides,
            @JsonProperty("track_inventory") Boolean trackInventory,
            @JsonProperty("inventory_alert_type") String inventoryAlertType,
            @JsonProperty("inventory_alert_threshold") Long inventoryAlertThreshold,
            @JsonProperty("user_data") String userData,
            @JsonProperty("service_duration") Long serviceDuration,
            @JsonProperty("available_for_booking") Boolean availableForBooking,
            @JsonProperty("item_option_values") List<CatalogItemOptionValueForItemVariation> itemOptionValues,
            @JsonProperty("measurement_unit_id") String measurementUnitId,
            @JsonProperty("team_member_ids") List<String> teamMemberIds) {
        this.itemId = itemId;
        this.name = name;
        this.sku = sku;
        this.upc = upc;
        this.ordinal = ordinal;
        this.pricingType = pricingType;
        this.priceMoney = priceMoney;
        this.locationOverrides = locationOverrides;
        this.trackInventory = trackInventory;
        this.inventoryAlertType = inventoryAlertType;
        this.inventoryAlertThreshold = inventoryAlertThreshold;
        this.userData = userData;
        this.serviceDuration = serviceDuration;
        this.availableForBooking = availableForBooking;
        this.itemOptionValues = itemOptionValues;
        this.measurementUnitId = measurementUnitId;
        this.teamMemberIds = teamMemberIds;
    }

    /**
     * Getter for ItemId.
     * The ID of the `CatalogItem` associated with this item variation.
     * @return Returns the String
     */
    @JsonGetter("item_id")
    public String getItemId() {
        return this.itemId;
    }

    /**
     * Getter for Name.
     * The item variation's name. This is a searchable attribute for use in applicable query
     * filters, and its value length is of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Sku.
     * The item variation's SKU, if any. This is a searchable attribute for use in applicable query
     * filters.
     * @return Returns the String
     */
    @JsonGetter("sku")
    public String getSku() {
        return this.sku;
    }

    /**
     * Getter for Upc.
     * The universal product code (UPC) of the item variation, if any. This is a searchable
     * attribute for use in applicable query filters. The value of this attribute should be a number
     * of 12-14 digits long. This restriction is enforced on the Square Seller Dashboard, Square
     * Point of Sale or Retail Point of Sale apps, where this attribute shows in the GTIN field. If
     * a non-compliant UPC value is assigned to this attribute using the API, the value is not
     * editable on the Seller Dashboard, Square Point of Sale or Retail Point of Sale apps unless it
     * is updated to fit the expected format.
     * @return Returns the String
     */
    @JsonGetter("upc")
    public String getUpc() {
        return this.upc;
    }

    /**
     * Getter for Ordinal.
     * The order in which this item variation should be displayed. This value is read-only. On
     * writes, the ordinal for each item variation within a parent `CatalogItem` is set according to
     * the item variations's position. On reads, the value is not guaranteed to be sequential or
     * unique.
     * @return Returns the Integer
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for PricingType.
     * Indicates whether the price of a CatalogItemVariation should be entered manually at the time
     * of sale.
     * @return Returns the String
     */
    @JsonGetter("pricing_type")
    public String getPricingType() {
        return this.pricingType;
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
        return this.priceMoney;
    }

    /**
     * Getter for LocationOverrides.
     * Per-location price and inventory overrides.
     * @return Returns the List of ItemVariationLocationOverrides
     */
    @JsonGetter("location_overrides")
    public List<ItemVariationLocationOverrides> getLocationOverrides() {
        return this.locationOverrides;
    }

    /**
     * Getter for TrackInventory.
     * If `true`, inventory tracking is active for the variation.
     * @return Returns the Boolean
     */
    @JsonGetter("track_inventory")
    public Boolean getTrackInventory() {
        return this.trackInventory;
    }

    /**
     * Getter for InventoryAlertType.
     * Indicates whether Square should alert the merchant when the inventory quantity of a
     * CatalogItemVariation is low.
     * @return Returns the String
     */
    @JsonGetter("inventory_alert_type")
    public String getInventoryAlertType() {
        return this.inventoryAlertType;
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
        return this.inventoryAlertThreshold;
    }

    /**
     * Getter for UserData.
     * Arbitrary user metadata to associate with the item variation. This attribute value length is
     * of Unicode code points.
     * @return Returns the String
     */
    @JsonGetter("user_data")
    public String getUserData() {
        return this.userData;
    }

    /**
     * Getter for ServiceDuration.
     * If the `CatalogItem` that owns this item variation is of type `APPOINTMENTS_SERVICE`, then
     * this is the duration of the service in milliseconds. For example, a 30 minute appointment
     * would have the value `1800000`, which is equal to 30 (minutes) * 60 (seconds per minute) *
     * 1000 (milliseconds per second).
     * @return Returns the Long
     */
    @JsonGetter("service_duration")
    public Long getServiceDuration() {
        return this.serviceDuration;
    }

    /**
     * Getter for AvailableForBooking.
     * If the `CatalogItem` that owns this item variation is of type `APPOINTMENTS_SERVICE`, a bool
     * representing whether this service is available for booking.
     * @return Returns the Boolean
     */
    @JsonGetter("available_for_booking")
    public Boolean getAvailableForBooking() {
        return this.availableForBooking;
    }

    /**
     * Getter for ItemOptionValues.
     * List of item option values associated with this item variation. Listed in the same order as
     * the item options of the parent item.
     * @return Returns the List of CatalogItemOptionValueForItemVariation
     */
    @JsonGetter("item_option_values")
    public List<CatalogItemOptionValueForItemVariation> getItemOptionValues() {
        return this.itemOptionValues;
    }

    /**
     * Getter for MeasurementUnitId.
     * ID of the ‘CatalogMeasurementUnit’ that is used to measure the quantity sold of this item
     * variation. If left unset, the item will be sold in whole quantities.
     * @return Returns the String
     */
    @JsonGetter("measurement_unit_id")
    public String getMeasurementUnitId() {
        return this.measurementUnitId;
    }

    /**
     * Getter for TeamMemberIds.
     * Tokens of employees that can perform the service represented by this variation. Only valid
     * for variations of type `APPOINTMENTS_SERVICE`.
     * @return Returns the List of String
     */
    @JsonGetter("team_member_ids")
    public List<String> getTeamMemberIds() {
        return this.teamMemberIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, sku, upc, ordinal, pricingType, priceMoney,
                locationOverrides, trackInventory, inventoryAlertType, inventoryAlertThreshold,
                userData, serviceDuration, availableForBooking, itemOptionValues, measurementUnitId,
                teamMemberIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogItemVariation)) {
            return false;
        }
        CatalogItemVariation other = (CatalogItemVariation) obj;
        return Objects.equals(itemId, other.itemId)
            && Objects.equals(name, other.name)
            && Objects.equals(sku, other.sku)
            && Objects.equals(upc, other.upc)
            && Objects.equals(ordinal, other.ordinal)
            && Objects.equals(pricingType, other.pricingType)
            && Objects.equals(priceMoney, other.priceMoney)
            && Objects.equals(locationOverrides, other.locationOverrides)
            && Objects.equals(trackInventory, other.trackInventory)
            && Objects.equals(inventoryAlertType, other.inventoryAlertType)
            && Objects.equals(inventoryAlertThreshold, other.inventoryAlertThreshold)
            && Objects.equals(userData, other.userData)
            && Objects.equals(serviceDuration, other.serviceDuration)
            && Objects.equals(availableForBooking, other.availableForBooking)
            && Objects.equals(itemOptionValues, other.itemOptionValues)
            && Objects.equals(measurementUnitId, other.measurementUnitId)
            && Objects.equals(teamMemberIds, other.teamMemberIds);
    }

    /**
     * Converts this CatalogItemVariation into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CatalogItemVariation [" + "itemId=" + itemId + ", name=" + name + ", sku=" + sku
                + ", upc=" + upc + ", ordinal=" + ordinal + ", pricingType=" + pricingType
                + ", priceMoney=" + priceMoney + ", locationOverrides=" + locationOverrides
                + ", trackInventory=" + trackInventory + ", inventoryAlertType="
                + inventoryAlertType + ", inventoryAlertThreshold=" + inventoryAlertThreshold
                + ", userData=" + userData + ", serviceDuration=" + serviceDuration
                + ", availableForBooking=" + availableForBooking + ", itemOptionValues="
                + itemOptionValues + ", measurementUnitId=" + measurementUnitId + ", teamMemberIds="
                + teamMemberIds + "]";
    }

    /**
     * Builds a new {@link CatalogItemVariation.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogItemVariation.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .itemId(getItemId())
                .name(getName())
                .sku(getSku())
                .upc(getUpc())
                .ordinal(getOrdinal())
                .pricingType(getPricingType())
                .priceMoney(getPriceMoney())
                .locationOverrides(getLocationOverrides())
                .trackInventory(getTrackInventory())
                .inventoryAlertType(getInventoryAlertType())
                .inventoryAlertThreshold(getInventoryAlertThreshold())
                .userData(getUserData())
                .serviceDuration(getServiceDuration())
                .availableForBooking(getAvailableForBooking())
                .itemOptionValues(getItemOptionValues())
                .measurementUnitId(getMeasurementUnitId())
                .teamMemberIds(getTeamMemberIds());
        return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemVariation}.
     */
    public static class Builder {
        private String itemId;
        private String name;
        private String sku;
        private String upc;
        private Integer ordinal;
        private String pricingType;
        private Money priceMoney;
        private List<ItemVariationLocationOverrides> locationOverrides;
        private Boolean trackInventory;
        private String inventoryAlertType;
        private Long inventoryAlertThreshold;
        private String userData;
        private Long serviceDuration;
        private Boolean availableForBooking;
        private List<CatalogItemOptionValueForItemVariation> itemOptionValues;
        private String measurementUnitId;
        private List<String> teamMemberIds;



        /**
         * Setter for itemId.
         * @param itemId String value for itemId.
         * @return Builder
         */
        public Builder itemId(String itemId) {
            this.itemId = itemId;
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
         * Setter for sku.
         * @param sku String value for sku.
         * @return Builder
         */
        public Builder sku(String sku) {
            this.sku = sku;
            return this;
        }

        /**
         * Setter for upc.
         * @param upc String value for upc.
         * @return Builder
         */
        public Builder upc(String upc) {
            this.upc = upc;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param ordinal Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Setter for pricingType.
         * @param pricingType String value for pricingType.
         * @return Builder
         */
        public Builder pricingType(String pricingType) {
            this.pricingType = pricingType;
            return this;
        }

        /**
         * Setter for priceMoney.
         * @param priceMoney Money value for priceMoney.
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Setter for locationOverrides.
         * @param locationOverrides List of ItemVariationLocationOverrides value for locationOverrides.
         * @return Builder
         */
        public Builder locationOverrides(List<ItemVariationLocationOverrides> locationOverrides) {
            this.locationOverrides = locationOverrides;
            return this;
        }

        /**
         * Setter for trackInventory.
         * @param trackInventory Boolean value for trackInventory.
         * @return Builder
         */
        public Builder trackInventory(Boolean trackInventory) {
            this.trackInventory = trackInventory;
            return this;
        }

        /**
         * Setter for inventoryAlertType.
         * @param inventoryAlertType String value for inventoryAlertType.
         * @return Builder
         */
        public Builder inventoryAlertType(String inventoryAlertType) {
            this.inventoryAlertType = inventoryAlertType;
            return this;
        }

        /**
         * Setter for inventoryAlertThreshold.
         * @param inventoryAlertThreshold Long value for inventoryAlertThreshold.
         * @return Builder
         */
        public Builder inventoryAlertThreshold(Long inventoryAlertThreshold) {
            this.inventoryAlertThreshold = inventoryAlertThreshold;
            return this;
        }

        /**
         * Setter for userData.
         * @param userData String value for userData.
         * @return Builder
         */
        public Builder userData(String userData) {
            this.userData = userData;
            return this;
        }

        /**
         * Setter for serviceDuration.
         * @param serviceDuration Long value for serviceDuration.
         * @return Builder
         */
        public Builder serviceDuration(Long serviceDuration) {
            this.serviceDuration = serviceDuration;
            return this;
        }

        /**
         * Setter for availableForBooking.
         * @param availableForBooking Boolean value for availableForBooking.
         * @return Builder
         */
        public Builder availableForBooking(Boolean availableForBooking) {
            this.availableForBooking = availableForBooking;
            return this;
        }

        /**
         * Setter for itemOptionValues.
         * @param itemOptionValues List of CatalogItemOptionValueForItemVariation value for itemOptionValues.
         * @return Builder
         */
        public Builder itemOptionValues(List<CatalogItemOptionValueForItemVariation> itemOptionValues) {
            this.itemOptionValues = itemOptionValues;
            return this;
        }

        /**
         * Setter for measurementUnitId.
         * @param measurementUnitId String value for measurementUnitId.
         * @return Builder
         */
        public Builder measurementUnitId(String measurementUnitId) {
            this.measurementUnitId = measurementUnitId;
            return this;
        }

        /**
         * Setter for teamMemberIds.
         * @param teamMemberIds List of String value for teamMemberIds.
         * @return Builder
         */
        public Builder teamMemberIds(List<String> teamMemberIds) {
            this.teamMemberIds = teamMemberIds;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemVariation} object using the set fields.
         * @return {@link CatalogItemVariation}
         */
        public CatalogItemVariation build() {
            return new CatalogItemVariation(itemId, name, sku, upc, ordinal, pricingType,
                    priceMoney, locationOverrides, trackInventory, inventoryAlertType,
                    inventoryAlertThreshold, userData, serviceDuration, availableForBooking,
                    itemOptionValues, measurementUnitId, teamMemberIds);
        }
    }
}
