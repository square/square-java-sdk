
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for InventoryCount type.
 */
public class InventoryCount {
    private final OptionalNullable<String> catalogObjectId;
    private final OptionalNullable<String> catalogObjectType;
    private final String state;
    private final OptionalNullable<String> locationId;
    private final OptionalNullable<String> quantity;
    private final String calculatedAt;
    private final Boolean isEstimated;

    /**
     * Initialization constructor.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  state  String value for state.
     * @param  locationId  String value for locationId.
     * @param  quantity  String value for quantity.
     * @param  calculatedAt  String value for calculatedAt.
     * @param  isEstimated  Boolean value for isEstimated.
     */
    @JsonCreator
    public InventoryCount(
            @JsonProperty("catalog_object_id") String catalogObjectId,
            @JsonProperty("catalog_object_type") String catalogObjectType,
            @JsonProperty("state") String state,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("quantity") String quantity,
            @JsonProperty("calculated_at") String calculatedAt,
            @JsonProperty("is_estimated") Boolean isEstimated) {
        this.catalogObjectId = OptionalNullable.of(catalogObjectId);
        this.catalogObjectType = OptionalNullable.of(catalogObjectType);
        this.state = state;
        this.locationId = OptionalNullable.of(locationId);
        this.quantity = OptionalNullable.of(quantity);
        this.calculatedAt = calculatedAt;
        this.isEstimated = isEstimated;
    }

    /**
     * Initialization constructor.
     * @param  catalogObjectId  String value for catalogObjectId.
     * @param  catalogObjectType  String value for catalogObjectType.
     * @param  state  String value for state.
     * @param  locationId  String value for locationId.
     * @param  quantity  String value for quantity.
     * @param  calculatedAt  String value for calculatedAt.
     * @param  isEstimated  Boolean value for isEstimated.
     */

    protected InventoryCount(OptionalNullable<String> catalogObjectId,
            OptionalNullable<String> catalogObjectType, String state,
            OptionalNullable<String> locationId, OptionalNullable<String> quantity,
            String calculatedAt, Boolean isEstimated) {
        this.catalogObjectId = catalogObjectId;
        this.catalogObjectType = catalogObjectType;
        this.state = state;
        this.locationId = locationId;
        this.quantity = quantity;
        this.calculatedAt = calculatedAt;
        this.isEstimated = isEstimated;
    }

    /**
     * Internal Getter for CatalogObjectId.
     * The Square-generated ID of the [CatalogObject](entity:CatalogObject) being tracked.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectId() {
        return this.catalogObjectId;
    }

    /**
     * Getter for CatalogObjectId.
     * The Square-generated ID of the [CatalogObject](entity:CatalogObject) being tracked.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectId() {
        return OptionalNullable.getFrom(catalogObjectId);
    }

    /**
     * Internal Getter for CatalogObjectType.
     * The [type](entity:CatalogObjectType) of the [CatalogObject](entity:CatalogObject) being
     * tracked. The Inventory API supports setting and reading the `"catalog_object_type":
     * "ITEM_VARIATION"` field value. In addition, it can also read the `"catalog_object_type":
     * "ITEM"` field value that is set by the Square Restaurants app.
     * @return Returns the Internal String
     */
    @JsonGetter("catalog_object_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetCatalogObjectType() {
        return this.catalogObjectType;
    }

    /**
     * Getter for CatalogObjectType.
     * The [type](entity:CatalogObjectType) of the [CatalogObject](entity:CatalogObject) being
     * tracked. The Inventory API supports setting and reading the `"catalog_object_type":
     * "ITEM_VARIATION"` field value. In addition, it can also read the `"catalog_object_type":
     * "ITEM"` field value that is set by the Square Restaurants app.
     * @return Returns the String
     */
    @JsonIgnore
    public String getCatalogObjectType() {
        return OptionalNullable.getFrom(catalogObjectType);
    }

    /**
     * Getter for State.
     * Indicates the state of a tracked item quantity in the lifecycle of goods.
     * @return Returns the String
     */
    @JsonGetter("state")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getState() {
        return state;
    }

    /**
     * Internal Getter for LocationId.
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items is being tracked.
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
     * The Square-generated ID of the [Location](entity:Location) where the related quantity of
     * items is being tracked.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLocationId() {
        return OptionalNullable.getFrom(locationId);
    }

    /**
     * Internal Getter for Quantity.
     * The number of items affected by the estimated count as a decimal string. Can support up to 5
     * digits after the decimal point.
     * @return Returns the Internal String
     */
    @JsonGetter("quantity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetQuantity() {
        return this.quantity;
    }

    /**
     * Getter for Quantity.
     * The number of items affected by the estimated count as a decimal string. Can support up to 5
     * digits after the decimal point.
     * @return Returns the String
     */
    @JsonIgnore
    public String getQuantity() {
        return OptionalNullable.getFrom(quantity);
    }

    /**
     * Getter for CalculatedAt.
     * An RFC 3339-formatted timestamp that indicates when the most recent physical count or
     * adjustment affecting the estimated count is received.
     * @return Returns the String
     */
    @JsonGetter("calculated_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCalculatedAt() {
        return calculatedAt;
    }

    /**
     * Getter for IsEstimated.
     * Whether the inventory count is for composed variation (TRUE) or not (FALSE). If true, the
     * inventory count will not be present in the response of any of these endpoints:
     * [BatchChangeInventory]($e/Inventory/BatchChangeInventory),
     * [BatchRetrieveInventoryChanges]($e/Inventory/BatchRetrieveInventoryChanges),
     * [BatchRetrieveInventoryCounts]($e/Inventory/BatchRetrieveInventoryCounts), and
     * [RetrieveInventoryChanges]($e/Inventory/RetrieveInventoryChanges).
     * @return Returns the Boolean
     */
    @JsonGetter("is_estimated")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getIsEstimated() {
        return isEstimated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogObjectId, catalogObjectType, state, locationId, quantity,
                calculatedAt, isEstimated);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InventoryCount)) {
            return false;
        }
        InventoryCount other = (InventoryCount) obj;
        return Objects.equals(catalogObjectId, other.catalogObjectId)
            && Objects.equals(catalogObjectType, other.catalogObjectType)
            && Objects.equals(state, other.state)
            && Objects.equals(locationId, other.locationId)
            && Objects.equals(quantity, other.quantity)
            && Objects.equals(calculatedAt, other.calculatedAt)
            && Objects.equals(isEstimated, other.isEstimated);
    }

    /**
     * Converts this InventoryCount into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InventoryCount [" + "catalogObjectId=" + catalogObjectId + ", catalogObjectType="
                + catalogObjectType + ", state=" + state + ", locationId=" + locationId
                + ", quantity=" + quantity + ", calculatedAt=" + calculatedAt + ", isEstimated="
                + isEstimated + "]";
    }

    /**
     * Builds a new {@link InventoryCount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InventoryCount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .state(getState())
                .calculatedAt(getCalculatedAt())
                .isEstimated(getIsEstimated());
        builder.catalogObjectId = internalGetCatalogObjectId();
        builder.catalogObjectType = internalGetCatalogObjectType();
        builder.locationId = internalGetLocationId();
        builder.quantity = internalGetQuantity();
        return builder;
    }

    /**
     * Class to build instances of {@link InventoryCount}.
     */
    public static class Builder {
        private OptionalNullable<String> catalogObjectId;
        private OptionalNullable<String> catalogObjectType;
        private String state;
        private OptionalNullable<String> locationId;
        private OptionalNullable<String> quantity;
        private String calculatedAt;
        private Boolean isEstimated;



        /**
         * Setter for catalogObjectId.
         * @param  catalogObjectId  String value for catalogObjectId.
         * @return Builder
         */
        public Builder catalogObjectId(String catalogObjectId) {
            this.catalogObjectId = OptionalNullable.of(catalogObjectId);
            return this;
        }

        /**
         * UnSetter for catalogObjectId.
         * @return Builder
         */
        public Builder unsetCatalogObjectId() {
            catalogObjectId = null;
            return this;
        }

        /**
         * Setter for catalogObjectType.
         * @param  catalogObjectType  String value for catalogObjectType.
         * @return Builder
         */
        public Builder catalogObjectType(String catalogObjectType) {
            this.catalogObjectType = OptionalNullable.of(catalogObjectType);
            return this;
        }

        /**
         * UnSetter for catalogObjectType.
         * @return Builder
         */
        public Builder unsetCatalogObjectType() {
            catalogObjectType = null;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

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
         * Setter for quantity.
         * @param  quantity  String value for quantity.
         * @return Builder
         */
        public Builder quantity(String quantity) {
            this.quantity = OptionalNullable.of(quantity);
            return this;
        }

        /**
         * UnSetter for quantity.
         * @return Builder
         */
        public Builder unsetQuantity() {
            quantity = null;
            return this;
        }

        /**
         * Setter for calculatedAt.
         * @param  calculatedAt  String value for calculatedAt.
         * @return Builder
         */
        public Builder calculatedAt(String calculatedAt) {
            this.calculatedAt = calculatedAt;
            return this;
        }

        /**
         * Setter for isEstimated.
         * @param  isEstimated  Boolean value for isEstimated.
         * @return Builder
         */
        public Builder isEstimated(Boolean isEstimated) {
            this.isEstimated = isEstimated;
            return this;
        }

        /**
         * Builds a new {@link InventoryCount} object using the set fields.
         * @return {@link InventoryCount}
         */
        public InventoryCount build() {
            return new InventoryCount(catalogObjectId, catalogObjectType, state, locationId,
                    quantity, calculatedAt, isEstimated);
        }
    }
}
