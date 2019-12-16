package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Variation {

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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, itemId, ordinal, pricingType, priceMoney, sku, trackInventory, inventoryAlertType, inventoryAlertThreshold, userData, v2Id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Variation)) {
            return false;
        }
        V1Variation v1Variation = (V1Variation) o;
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

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder itemId(String value) {
            itemId = value;
            return this;
        }
        public Builder ordinal(Integer value) {
            ordinal = value;
            return this;
        }
        public Builder pricingType(String value) {
            pricingType = value;
            return this;
        }
        public Builder priceMoney(V1Money value) {
            priceMoney = value;
            return this;
        }
        public Builder sku(String value) {
            sku = value;
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
        public Builder inventoryAlertThreshold(Integer value) {
            inventoryAlertThreshold = value;
            return this;
        }
        public Builder userData(String value) {
            userData = value;
            return this;
        }
        public Builder v2Id(String value) {
            v2Id = value;
            return this;
        }

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
