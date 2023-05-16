
package com.squareup.square.models;

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
 * This is a model class for UpdateItemTaxesRequest type.
 */
public class UpdateItemTaxesRequest {
    private final List<String> itemIds;
    private final OptionalNullable<List<String>> taxesToEnable;
    private final OptionalNullable<List<String>> taxesToDisable;

    /**
     * Initialization constructor.
     * @param  itemIds  List of String value for itemIds.
     * @param  taxesToEnable  List of String value for taxesToEnable.
     * @param  taxesToDisable  List of String value for taxesToDisable.
     */
    @JsonCreator
    public UpdateItemTaxesRequest(
            @JsonProperty("item_ids") List<String> itemIds,
            @JsonProperty("taxes_to_enable") List<String> taxesToEnable,
            @JsonProperty("taxes_to_disable") List<String> taxesToDisable) {
        this.itemIds = itemIds;
        this.taxesToEnable = OptionalNullable.of(taxesToEnable);
        this.taxesToDisable = OptionalNullable.of(taxesToDisable);
    }

    /**
     * Internal initialization constructor.
     */
    protected UpdateItemTaxesRequest(List<String> itemIds,
            OptionalNullable<List<String>> taxesToEnable,
            OptionalNullable<List<String>> taxesToDisable) {
        this.itemIds = itemIds;
        this.taxesToEnable = taxesToEnable;
        this.taxesToDisable = taxesToDisable;
    }

    /**
     * Getter for ItemIds.
     * IDs for the CatalogItems associated with the CatalogTax objects being updated. No more than
     * 1,000 IDs may be provided.
     * @return Returns the List of String
     */
    @JsonGetter("item_ids")
    public List<String> getItemIds() {
        return itemIds;
    }

    /**
     * Internal Getter for TaxesToEnable.
     * IDs of the CatalogTax objects to enable. At least one of `taxes_to_enable` or
     * `taxes_to_disable` must be specified.
     * @return Returns the Internal List of String
     */
    @JsonGetter("taxes_to_enable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetTaxesToEnable() {
        return this.taxesToEnable;
    }

    /**
     * Getter for TaxesToEnable.
     * IDs of the CatalogTax objects to enable. At least one of `taxes_to_enable` or
     * `taxes_to_disable` must be specified.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getTaxesToEnable() {
        return OptionalNullable.getFrom(taxesToEnable);
    }

    /**
     * Internal Getter for TaxesToDisable.
     * IDs of the CatalogTax objects to disable. At least one of `taxes_to_enable` or
     * `taxes_to_disable` must be specified.
     * @return Returns the Internal List of String
     */
    @JsonGetter("taxes_to_disable")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<String>> internalGetTaxesToDisable() {
        return this.taxesToDisable;
    }

    /**
     * Getter for TaxesToDisable.
     * IDs of the CatalogTax objects to disable. At least one of `taxes_to_enable` or
     * `taxes_to_disable` must be specified.
     * @return Returns the List of String
     */
    @JsonIgnore
    public List<String> getTaxesToDisable() {
        return OptionalNullable.getFrom(taxesToDisable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIds, taxesToEnable, taxesToDisable);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateItemTaxesRequest)) {
            return false;
        }
        UpdateItemTaxesRequest other = (UpdateItemTaxesRequest) obj;
        return Objects.equals(itemIds, other.itemIds)
            && Objects.equals(taxesToEnable, other.taxesToEnable)
            && Objects.equals(taxesToDisable, other.taxesToDisable);
    }

    /**
     * Converts this UpdateItemTaxesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateItemTaxesRequest [" + "itemIds=" + itemIds + ", taxesToEnable="
                + taxesToEnable + ", taxesToDisable=" + taxesToDisable + "]";
    }

    /**
     * Builds a new {@link UpdateItemTaxesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateItemTaxesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(itemIds);
        builder.taxesToEnable = internalGetTaxesToEnable();
        builder.taxesToDisable = internalGetTaxesToDisable();
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateItemTaxesRequest}.
     */
    public static class Builder {
        private List<String> itemIds;
        private OptionalNullable<List<String>> taxesToEnable;
        private OptionalNullable<List<String>> taxesToDisable;

        /**
         * Initialization constructor.
         * @param  itemIds  List of String value for itemIds.
         */
        public Builder(List<String> itemIds) {
            this.itemIds = itemIds;
        }

        /**
         * Setter for itemIds.
         * @param  itemIds  List of String value for itemIds.
         * @return Builder
         */
        public Builder itemIds(List<String> itemIds) {
            this.itemIds = itemIds;
            return this;
        }

        /**
         * Setter for taxesToEnable.
         * @param  taxesToEnable  List of String value for taxesToEnable.
         * @return Builder
         */
        public Builder taxesToEnable(List<String> taxesToEnable) {
            this.taxesToEnable = OptionalNullable.of(taxesToEnable);
            return this;
        }

        /**
         * UnSetter for taxesToEnable.
         * @return Builder
         */
        public Builder unsetTaxesToEnable() {
            taxesToEnable = null;
            return this;
        }

        /**
         * Setter for taxesToDisable.
         * @param  taxesToDisable  List of String value for taxesToDisable.
         * @return Builder
         */
        public Builder taxesToDisable(List<String> taxesToDisable) {
            this.taxesToDisable = OptionalNullable.of(taxesToDisable);
            return this;
        }

        /**
         * UnSetter for taxesToDisable.
         * @return Builder
         */
        public Builder unsetTaxesToDisable() {
            taxesToDisable = null;
            return this;
        }

        /**
         * Builds a new {@link UpdateItemTaxesRequest} object using the set fields.
         * @return {@link UpdateItemTaxesRequest}
         */
        public UpdateItemTaxesRequest build() {
            return new UpdateItemTaxesRequest(itemIds, taxesToEnable, taxesToDisable);
        }
    }
}
