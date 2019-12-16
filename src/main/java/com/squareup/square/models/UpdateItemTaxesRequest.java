package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class UpdateItemTaxesRequest {

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

    @Override
    public int hashCode() {
        return Objects.hash(itemIds, taxesToEnable, taxesToDisable);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateItemTaxesRequest)) {
            return false;
        }
        UpdateItemTaxesRequest updateItemTaxesRequest = (UpdateItemTaxesRequest) o;
        return Objects.equals(itemIds, updateItemTaxesRequest.itemIds) &&
            Objects.equals(taxesToEnable, updateItemTaxesRequest.taxesToEnable) &&
            Objects.equals(taxesToDisable, updateItemTaxesRequest.taxesToDisable);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder(itemIds)
            .taxesToEnable(getTaxesToEnable())
            .taxesToDisable(getTaxesToDisable());
            return builder;
    }

    public static class Builder {
        private List<String> itemIds;
        private List<String> taxesToEnable;
        private List<String> taxesToDisable;

        public Builder(List<String> itemIds) {
            this.itemIds = itemIds;
        }

        public Builder itemIds(List<String> value) {
            itemIds = value;
            return this;
        }
        public Builder taxesToEnable(List<String> value) {
            taxesToEnable = value;
            return this;
        }
        public Builder taxesToDisable(List<String> value) {
            taxesToDisable = value;
            return this;
        }

        public UpdateItemTaxesRequest build() {
            return new UpdateItemTaxesRequest(itemIds,
                taxesToEnable,
                taxesToDisable);
        }
    }
}
