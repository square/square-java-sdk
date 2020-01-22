package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for V1Variation type.
 */
public class V1Variation {

    /**
     * Initialization constructor.
     * @param id
     * @param name
     * @param itemId
     * @param ordinal
     * @param pricingType
     * @param priceMoney
     * @param sku
     * @param trackInventory
     * @param inventoryAlertType
     * @param inventoryAlertThreshold
     * @param userData
     * @param v2Id
     */
    @JsonCreator
    public V1Variation(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("item_id") String itemId,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("pricing_type") String pricingType,
            @JsonProperty("price_money") V1Money priceMoney,
            @JsonProperty("sku") String sku,
            @JsonProperty("track_inventory") Boolean trackInventory,
            @JsonProperty("inventory_alert_type") String inventoryAlertType,
            @JsonProperty("inventory_alert_threshold") Integer inventoryAlertThreshold,
            @JsonProperty("user_data") String userData,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.itemId = itemId;
        this.ordinal = ordinal;
        this.pricingType = pricingType;
        this.priceMoney = priceMoney;
        this.sku = sku;
        this.trackInventory = trackInventory;
        this.inventoryAlertType = inventoryAlertType;
        this.inventoryAlertThreshold = inventoryAlertThreshold;
        this.userData = userData;
        this.v2Id = v2Id;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String itemId;
    private final Integer ordinal;
    private final String pricingType;
    private final V1Money priceMoney;
    private final String sku;
    private final Boolean trackInventory;
    private final String inventoryAlertType;
    private final Integer inventoryAlertThreshold;
    private final String userData;
    private final String v2Id;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The item variation's unique ID.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The item variation's name.
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for ItemId.
     * The ID of the variation's associated item.
     */
    @JsonGetter("item_id")
    public String getItemId() {
        return this.itemId;
    }

    /**
     * Getter for Ordinal.
     * Indicates the variation's list position when displayed in Square Point of Sale and the merchant dashboard. If more than one variation for the same item has the same ordinal value, those variations are displayed in alphabetical order
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for PricingType.
     */
    @JsonGetter("pricing_type")
    public String getPricingType() {
        return this.pricingType;
    }

    /**
     * Getter for PriceMoney.
     */
    @JsonGetter("price_money")
    public V1Money getPriceMoney() {
        return this.priceMoney;
    }

    /**
     * Getter for Sku.
     * The item variation's SKU, if any.
     */
    @JsonGetter("sku")
    public String getSku() {
        return this.sku;
    }

    /**
     * Getter for TrackInventory.
     * If true, inventory tracking is active for the variation.
     */
    @JsonGetter("track_inventory")
    public Boolean getTrackInventory() {
        return this.trackInventory;
    }

    /**
     * Getter for InventoryAlertType.
     */
    @JsonGetter("inventory_alert_type")
    public String getInventoryAlertType() {
        return this.inventoryAlertType;
    }

    /**
     * Getter for InventoryAlertThreshold.
     * If the inventory quantity for the variation is less than or equal to this value and inventory_alert_type is LOW_QUANTITY, the variation displays an alert in the merchant dashboard.
     */
    @JsonGetter("inventory_alert_threshold")
    public Integer getInventoryAlertThreshold() {
        return this.inventoryAlertThreshold;
    }

    /**
     * Getter for UserData.
     * Arbitrary metadata associated with the variation. Cannot exceed 255 characters.
     */
    @JsonGetter("user_data")
    public String getUserData() {
        return this.userData;
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
        return Objects.hash(id, name, itemId, ordinal, pricingType, priceMoney, sku, trackInventory,
            inventoryAlertType, inventoryAlertThreshold, userData, v2Id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1Variation)) {
            return false;
        }
        V1Variation v1Variation = (V1Variation) obj;
        return Objects.equals(id, v1Variation.id) &&
            Objects.equals(name, v1Variation.name) &&
            Objects.equals(itemId, v1Variation.itemId) &&
            Objects.equals(ordinal, v1Variation.ordinal) &&
            Objects.equals(pricingType, v1Variation.pricingType) &&
            Objects.equals(priceMoney, v1Variation.priceMoney) &&
            Objects.equals(sku, v1Variation.sku) &&
            Objects.equals(trackInventory, v1Variation.trackInventory) &&
            Objects.equals(inventoryAlertType, v1Variation.inventoryAlertType) &&
            Objects.equals(inventoryAlertThreshold, v1Variation.inventoryAlertThreshold) &&
            Objects.equals(userData, v1Variation.userData) &&
            Objects.equals(v2Id, v1Variation.v2Id);
    }

    /**
     * Builds a new {@link V1Variation.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1Variation.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .itemId(getItemId())
            .ordinal(getOrdinal())
            .pricingType(getPricingType())
            .priceMoney(getPriceMoney())
            .sku(getSku())
            .trackInventory(getTrackInventory())
            .inventoryAlertType(getInventoryAlertType())
            .inventoryAlertThreshold(getInventoryAlertThreshold())
            .userData(getUserData())
            .v2Id(getV2Id());
            return builder;
    }

    /**
     * Class to build instances of {@link V1Variation}
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String itemId;
        private Integer ordinal;
        private String pricingType;
        private V1Money priceMoney;
        private String sku;
        private Boolean trackInventory;
        private String inventoryAlertType;
        private Integer inventoryAlertThreshold;
        private String userData;
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
         * Setter for itemId
         * @param itemId
         * @return Builder
         */
        public Builder itemId(String itemId) {
            this.itemId = itemId;
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
        public Builder priceMoney(V1Money priceMoney) {
            this.priceMoney = priceMoney;
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
        public Builder inventoryAlertThreshold(Integer inventoryAlertThreshold) {
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
         * Setter for v2Id
         * @param v2Id
         * @return Builder
         */
        public Builder v2Id(String v2Id) {
            this.v2Id = v2Id;
            return this;
        }

        /**
         * Builds a new {@link V1Variation} object using the set fields.
         * @return {@link V1Variation}
         */
        public V1Variation build() {
            V1Variation model = new V1Variation(id,
                name,
                itemId,
                ordinal,
                pricingType,
                priceMoney,
                sku,
                trackInventory,
                inventoryAlertType,
                inventoryAlertThreshold,
                userData,
                v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
