package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogItemVariation type.
 */
public class CatalogItemVariation {

    /**
     * Initialization constructor.
     * @param itemId
     * @param name
     * @param sku
     * @param upc
     * @param ordinal
     * @param pricingType
     * @param priceMoney
     * @param locationOverrides
     * @param trackInventory
     * @param inventoryAlertType
     * @param inventoryAlertThreshold
     * @param userData
     * @param serviceDuration
     * @param itemOptionValues
     * @param measurementUnitId
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
            @JsonProperty("item_option_values") List<CatalogItemOptionValueForItemVariation> itemOptionValues,
            @JsonProperty("measurement_unit_id") String measurementUnitId) {
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
        this.itemOptionValues = itemOptionValues;
        this.measurementUnitId = measurementUnitId;
    }

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
    private final List<CatalogItemOptionValueForItemVariation> itemOptionValues;
    private final String measurementUnitId;
    /**
     * Getter for ItemId.
     * The ID of the `CatalogItem` associated with this item variation. Searchable.
     */
    @JsonGetter("item_id")
    public String getItemId() {
        return this.itemId;
    }

    /**
     * Getter for Name.
     * The item variation's name. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Sku.
     * The item variation's SKU, if any. Searchable.
     */
    @JsonGetter("sku")
    public String getSku() {
        return this.sku;
    }

    /**
     * Getter for Upc.
     * The item variation's UPC, if any. Searchable in the Connect API.
     * This field is only exposed in the Connect API. It is not exposed in Square's Dashboard,
     * Square Point of Sale app or Retail Point of Sale app.
     */
    @JsonGetter("upc")
    public String getUpc() {
        return this.upc;
    }

    /**
     * Getter for Ordinal.
     * The order in which this item variation should be displayed. This value is read-only. On writes, the ordinal
     * for each item variation within a parent `CatalogItem` is set according to the item variations's
     * position. On reads, the value is not guaranteed to be sequential or unique.
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() {
        return this.ordinal;
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
     * Getter for LocationOverrides.
     * Per-location price and inventory overrides.
     */
    @JsonGetter("location_overrides")
    public List<ItemVariationLocationOverrides> getLocationOverrides() {
        return this.locationOverrides;
    }

    /**
     * Getter for TrackInventory.
     * If `true`, inventory tracking is active for the variation.
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

    /**
     * Getter for UserData.
     * Arbitrary user metadata to associate with the item variation. Searchable. This field has max length of 255 Unicode code points.
     */
    @JsonGetter("user_data")
    public String getUserData() {
        return this.userData;
    }

    /**
     * Getter for ServiceDuration.
     * If the `CatalogItem` that owns this item variation is of type
     * `APPOINTMENTS_SERVICE`, then this is the duration of the service in milliseconds. For
     * example, a 30 minute appointment would have the value `1800000`, which is equal to
     * 30 (minutes) * 60 (seconds per minute) * 1000 (milliseconds per second).
     */
    @JsonGetter("service_duration")
    public Long getServiceDuration() {
        return this.serviceDuration;
    }

    /**
     * Getter for ItemOptionValues.
     * List of item option values associated with this item variation. Listed
     * in the same order as the item options of the parent item.
     */
    @JsonGetter("item_option_values")
    public List<CatalogItemOptionValueForItemVariation> getItemOptionValues() {
        return this.itemOptionValues;
    }

    /**
     * Getter for MeasurementUnitId.
     * ID of the ‘CatalogMeasurementUnit’ that is used to measure the quantity
     * sold of this item variation. If left unset, the item will be sold in
     * whole quantities.
     */
    @JsonGetter("measurement_unit_id")
    public String getMeasurementUnitId() {
        return this.measurementUnitId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, sku, upc, ordinal, pricingType, priceMoney,
            locationOverrides, trackInventory, inventoryAlertType, inventoryAlertThreshold, userData,
            serviceDuration, itemOptionValues, measurementUnitId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogItemVariation)) {
            return false;
        }
        CatalogItemVariation catalogItemVariation = (CatalogItemVariation) obj;
        return Objects.equals(itemId, catalogItemVariation.itemId) &&
            Objects.equals(name, catalogItemVariation.name) &&
            Objects.equals(sku, catalogItemVariation.sku) &&
            Objects.equals(upc, catalogItemVariation.upc) &&
            Objects.equals(ordinal, catalogItemVariation.ordinal) &&
            Objects.equals(pricingType, catalogItemVariation.pricingType) &&
            Objects.equals(priceMoney, catalogItemVariation.priceMoney) &&
            Objects.equals(locationOverrides, catalogItemVariation.locationOverrides) &&
            Objects.equals(trackInventory, catalogItemVariation.trackInventory) &&
            Objects.equals(inventoryAlertType, catalogItemVariation.inventoryAlertType) &&
            Objects.equals(inventoryAlertThreshold, catalogItemVariation.inventoryAlertThreshold) &&
            Objects.equals(userData, catalogItemVariation.userData) &&
            Objects.equals(serviceDuration, catalogItemVariation.serviceDuration) &&
            Objects.equals(itemOptionValues, catalogItemVariation.itemOptionValues) &&
            Objects.equals(measurementUnitId, catalogItemVariation.measurementUnitId);
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
            .itemOptionValues(getItemOptionValues())
            .measurementUnitId(getMeasurementUnitId());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogItemVariation}
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
        private List<CatalogItemOptionValueForItemVariation> itemOptionValues;
        private String measurementUnitId;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for itemId
         * @param itemId
         * @return Builder
         */
        public Builder itemId(String itemId) {
            this.itemId = itemId;
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
         * Setter for sku
         * @param sku
         * @return Builder
         */
        public Builder sku(String sku) {
            this.sku = sku;
            return this;
        }
        /**
         * Setter for upc
         * @param upc
         * @return Builder
         */
        public Builder upc(String upc) {
            this.upc = upc;
            return this;
        }
        /**
         * Setter for ordinal
         * @param ordinal
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }
        /**
         * Setter for pricingType
         * @param pricingType
         * @return Builder
         */
        public Builder pricingType(String pricingType) {
            this.pricingType = pricingType;
            return this;
        }
        /**
         * Setter for priceMoney
         * @param priceMoney
         * @return Builder
         */
        public Builder priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }
        /**
         * Setter for locationOverrides
         * @param locationOverrides
         * @return Builder
         */
        public Builder locationOverrides(List<ItemVariationLocationOverrides> locationOverrides) {
            this.locationOverrides = locationOverrides;
            return this;
        }
        /**
         * Setter for trackInventory
         * @param trackInventory
         * @return Builder
         */
        public Builder trackInventory(Boolean trackInventory) {
            this.trackInventory = trackInventory;
            return this;
        }
        /**
         * Setter for inventoryAlertType
         * @param inventoryAlertType
         * @return Builder
         */
        public Builder inventoryAlertType(String inventoryAlertType) {
            this.inventoryAlertType = inventoryAlertType;
            return this;
        }
        /**
         * Setter for inventoryAlertThreshold
         * @param inventoryAlertThreshold
         * @return Builder
         */
        public Builder inventoryAlertThreshold(Long inventoryAlertThreshold) {
            this.inventoryAlertThreshold = inventoryAlertThreshold;
            return this;
        }
        /**
         * Setter for userData
         * @param userData
         * @return Builder
         */
        public Builder userData(String userData) {
            this.userData = userData;
            return this;
        }
        /**
         * Setter for serviceDuration
         * @param serviceDuration
         * @return Builder
         */
        public Builder serviceDuration(Long serviceDuration) {
            this.serviceDuration = serviceDuration;
            return this;
        }
        /**
         * Setter for itemOptionValues
         * @param itemOptionValues
         * @return Builder
         */
        public Builder itemOptionValues(List<CatalogItemOptionValueForItemVariation> itemOptionValues) {
            this.itemOptionValues = itemOptionValues;
            return this;
        }
        /**
         * Setter for measurementUnitId
         * @param measurementUnitId
         * @return Builder
         */
        public Builder measurementUnitId(String measurementUnitId) {
            this.measurementUnitId = measurementUnitId;
            return this;
        }

        /**
         * Builds a new {@link CatalogItemVariation} object using the set fields.
         * @return {@link CatalogItemVariation}
         */
        public CatalogItemVariation build() {
            return new CatalogItemVariation(itemId,
                name,
                sku,
                upc,
                ordinal,
                pricingType,
                priceMoney,
                locationOverrides,
                trackInventory,
                inventoryAlertType,
                inventoryAlertThreshold,
                userData,
                serviceDuration,
                itemOptionValues,
                measurementUnitId);
        }
    }
}
