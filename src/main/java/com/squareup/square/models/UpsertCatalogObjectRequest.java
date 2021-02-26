
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpsertCatalogObjectRequest type.
 */
public class UpsertCatalogObjectRequest {
    private final String idempotencyKey;
    private final CatalogObject object;

    /**
     * Initialization constructor.
     * @param  idempotencyKey  String value for idempotencyKey.
     * @param  object  CatalogObject value for object.
     */
    @JsonCreator
    public UpsertCatalogObjectRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("object") CatalogObject object) {
        this.idempotencyKey = idempotencyKey;
        this.object = object;
    }

    /**
     * Getter for IdempotencyKey.
     * A value you specify that uniquely identifies this request among all your requests. A common
     * way to create a valid idempotency key is to use a Universally unique identifier (UUID). If
     * you're unsure whether a particular request was successful, you can reattempt it with the same
     * idempotency key without worrying about creating duplicate objects. See
     * [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more
     * information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    /**
     * Getter for Object.
     * The wrapper object for the Catalog entries of a given object type. The type of a particular
     * `CatalogObject` is determined by the value of the `type` attribute and only the corresponding
     * data attribute can be set on the `CatalogObject` instance. For example, the following list
     * shows some instances of `CatalogObject` of a given `type` and their corresponding data
     * attribute that can be set: - For a `CatalogObject` of the `ITEM` type, set the `item_data`
     * attribute to yield the `CatalogItem` object. - For a `CatalogObject` of the `ITEM_VARIATION`
     * type, set the `item_variation_data` attribute to yield the `CatalogItemVariation` object. -
     * For a `CatalogObject` of the `MODIFIER` type, set the `modifier_data` attribute to yield the
     * `CatalogModifier` object. - For a `CatalogObject` of the `MODIFIER_LIST` type, set the
     * `modifier_list_data` attribute to yield the `CatalogModifierList` object. - For a
     * `CatalogObject` of the `CATEGORY` type, set the `category_data` attribute to yield the
     * `CatalogCategory` object. - For a `CatalogObject` of the `DISCOUNT` type, set the
     * `discount_data` attribute to yield the `CatalogDiscount` object. - For a `CatalogObject` of
     * the `TAX` type, set the `tax_data` attribute to yield the `CatalogTax` object. - For a
     * `CatalogObject` of the `IMAGE` type, set the `image_data` attribute to yield the
     * `CatalogImageData` object. - For a `CatalogObject` of the `QUICK_AMOUNTS_SETTINGS` type, set
     * the `quick_amounts_settings_data` attribute to yield the `CatalogQuickAmountsSettings`
     * object. - For a `CatalogObject` of the `PRICING_RULE` type, set the `pricing_rule_data`
     * attribute to yield the `CatalogPricingRule` object. - For a `CatalogObject` of the
     * `TIME_PERIOD` type, set the `time_period_data` attribute to yield the `CatalogTimePeriod`
     * object. - For a `CatalogObject` of the `PRODUCT_SET` type, set the `product_set_data`
     * attribute to yield the `CatalogProductSet` object. - For a `CatalogObject` of the
     * `SUBSCRIPTION_PLAN` type, set the `subscription_plan_data` attribute to yield the
     * `CatalogSubscriptionPlan` object. For a more detailed discussion of the Catalog data model,
     * please see the [Design a
     * Catalog](https://developer.squareup.com/docs/catalog-api/design-a-catalog) guide.
     * @return Returns the CatalogObject
     */
    @JsonGetter("object")
    public CatalogObject getObject() {
        return object;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, object);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpsertCatalogObjectRequest)) {
            return false;
        }
        UpsertCatalogObjectRequest other = (UpsertCatalogObjectRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(object, other.object);
    }

    /**
     * Converts this UpsertCatalogObjectRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpsertCatalogObjectRequest [" + "idempotencyKey=" + idempotencyKey + ", object="
                + object + "]";
    }

    /**
     * Builds a new {@link UpsertCatalogObjectRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpsertCatalogObjectRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey, object);
        return builder;
    }

    /**
     * Class to build instances of {@link UpsertCatalogObjectRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private CatalogObject object;

        /**
         * Initialization constructor.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @param  object  CatalogObject value for object.
         */
        public Builder(String idempotencyKey, CatalogObject object) {
            this.idempotencyKey = idempotencyKey;
            this.object = object;
        }

        /**
         * Setter for idempotencyKey.
         * @param  idempotencyKey  String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for object.
         * @param  object  CatalogObject value for object.
         * @return Builder
         */
        public Builder object(CatalogObject object) {
            this.object = object;
            return this;
        }

        /**
         * Builds a new {@link UpsertCatalogObjectRequest} object using the set fields.
         * @return {@link UpsertCatalogObjectRequest}
         */
        public UpsertCatalogObjectRequest build() {
            return new UpsertCatalogObjectRequest(idempotencyKey, object);
        }
    }
}
