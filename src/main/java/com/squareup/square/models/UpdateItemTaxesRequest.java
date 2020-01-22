package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateItemTaxesRequest type.
 */
public class UpdateItemTaxesRequest {

    /**
     * Initialization constructor.
     * @param itemIds
     * @param taxesToEnable
     * @param taxesToDisable
     */
    @JsonCreator
    public UpdateItemTaxesRequest(
            @JsonProperty("item_ids") List<String> itemIds,
            @JsonProperty("taxes_to_enable") List<String> taxesToEnable,
            @JsonProperty("taxes_to_disable") List<String> taxesToDisable) {
        this.itemIds = itemIds;
        this.taxesToEnable = taxesToEnable;
        this.taxesToDisable = taxesToDisable;
    }

    private final List<String> itemIds;
    private final List<String> taxesToEnable;
    private final List<String> taxesToDisable;
    /**
     * Getter for ItemIds.
     * IDs for the CatalogItems associated with the CatalogTax objects being updated.
     */
    @JsonGetter("item_ids")
    public List<String> getItemIds() {
        return this.itemIds;
    }

    /**
     * Getter for TaxesToEnable.
     * IDs of the CatalogTax objects to enable.
     */
    @JsonGetter("taxes_to_enable")
    public List<String> getTaxesToEnable() {
        return this.taxesToEnable;
    }

    /**
     * Getter for TaxesToDisable.
     * IDs of the CatalogTax objects to disable.
     */
    @JsonGetter("taxes_to_disable")
    public List<String> getTaxesToDisable() {
        return this.taxesToDisable;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(itemIds, taxesToEnable, taxesToDisable);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateItemTaxesRequest)) {
            return false;
        }
        UpdateItemTaxesRequest updateItemTaxesRequest = (UpdateItemTaxesRequest) obj;
        return Objects.equals(itemIds, updateItemTaxesRequest.itemIds) &&
            Objects.equals(taxesToEnable, updateItemTaxesRequest.taxesToEnable) &&
            Objects.equals(taxesToDisable, updateItemTaxesRequest.taxesToDisable);
    }

    /**
     * Builds a new {@link UpdateItemTaxesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateItemTaxesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(itemIds)
            .taxesToEnable(getTaxesToEnable())
            .taxesToDisable(getTaxesToDisable());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateItemTaxesRequest}
     */
    public static class Builder {
        private List<String> itemIds;
        private List<String> taxesToEnable;
        private List<String> taxesToDisable;

        /**
         * Initialization constructor
         */
        public Builder(List<String> itemIds) {
            this.itemIds = itemIds;
        }

        /**
         * Setter for itemIds
         * @param itemIds
         * @return Builder
         */
        public Builder itemIds(List<String> itemIds) {
            this.itemIds = itemIds;
            return this;
        }
        /**
         * Setter for taxesToEnable
         * @param taxesToEnable
         * @return Builder
         */
        public Builder taxesToEnable(List<String> taxesToEnable) {
            this.taxesToEnable = taxesToEnable;
            return this;
        }
        /**
         * Setter for taxesToDisable
         * @param taxesToDisable
         * @return Builder
         */
        public Builder taxesToDisable(List<String> taxesToDisable) {
            this.taxesToDisable = taxesToDisable;
            return this;
        }

        /**
         * Builds a new {@link UpdateItemTaxesRequest} object using the set fields.
         * @return {@link UpdateItemTaxesRequest}
         */
        public UpdateItemTaxesRequest build() {
            return new UpdateItemTaxesRequest(itemIds,
                taxesToEnable,
                taxesToDisable);
        }
    }
}
