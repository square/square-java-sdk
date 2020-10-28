
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for CreateCatalogImageRequest type.
 */
public class CreateCatalogImageRequest {
    private final String idempotencyKey;
    private final String objectId;
    private final CatalogObject image;

    /**
     * Initialization constructor.
     * @param idempotencyKey String value for idempotencyKey.
     * @param objectId String value for objectId.
     * @param image CatalogObject value for image.
     */
    @JsonCreator
    public CreateCatalogImageRequest(
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("object_id") String objectId,
            @JsonProperty("image") CatalogObject image) {
        this.idempotencyKey = idempotencyKey;
        this.objectId = objectId;
        this.image = image;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies this CreateCatalogImage request. Keys can be any valid string
     * but must be unique for every CreateCatalogImage request. See [Idempotency
     * keys](https://developer.squareup.com/docs/basics/api101/idempotency) for more information.
     * @return Returns the String
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for ObjectId.
     * Unique ID of the `CatalogObject` to attach to this `CatalogImage`. Leave this field empty to
     * create unattached images, for example if you are building an integration where these images
     * can be attached to catalog items at a later time.
     * @return Returns the String
     */
    @JsonGetter("object_id")
    public String getObjectId() {
        return this.objectId;
    }

    /**
     * Getter for Image.
     * The wrapper object for the Catalog entries of a given object type. The type of a particular
     * `CatalogObject` is determined by the value of the `type` attribute and only the corresponding
     * data attribute can be set on the `CatalogObject` instance. For example, the following list
     * shows some instances of `CatalogObject` of a given `type` and their corresponding data
     * atrribute that can be set: - For a `CatalogObject` of the `ITEM` type, set the `item_data`
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
    @JsonGetter("image")
    public CatalogObject getImage() {
        return this.image;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, objectId, image);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCatalogImageRequest)) {
            return false;
        }
        CreateCatalogImageRequest other = (CreateCatalogImageRequest) obj;
        return Objects.equals(idempotencyKey, other.idempotencyKey)
            && Objects.equals(objectId, other.objectId)
            && Objects.equals(image, other.image);
    }

    /**
     * Builds a new {@link CreateCatalogImageRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCatalogImageRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(idempotencyKey)
            .objectId(getObjectId())
            .image(getImage());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCatalogImageRequest}.
     */
    public static class Builder {
        private String idempotencyKey;
        private String objectId;
        private CatalogObject image;

        /**
         * Initialization constructor.
         * @param idempotencyKey String value for idempotencyKey.
         */
        public Builder(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
        }

        /**
         * Setter for idempotencyKey.
         * @param idempotencyKey String value for idempotencyKey.
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Setter for objectId.
         * @param objectId String value for objectId.
         * @return Builder
         */
        public Builder objectId(String objectId) {
            this.objectId = objectId;
            return this;
        }

        /**
         * Setter for image.
         * @param image CatalogObject value for image.
         * @return Builder
         */
        public Builder image(CatalogObject image) {
            this.image = image;
            return this;
        }

        /**
         * Builds a new {@link CreateCatalogImageRequest} object using the set fields.
         * @return {@link CreateCatalogImageRequest}
         */
        public CreateCatalogImageRequest build() {
            return new CreateCatalogImageRequest(idempotencyKey,
                objectId,
                image);
        }
    }
}
