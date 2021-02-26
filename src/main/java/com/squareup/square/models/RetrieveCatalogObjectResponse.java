
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveCatalogObjectResponse type.
 */
public class RetrieveCatalogObjectResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogObject object;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<CatalogObject> relatedObjects;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  object  CatalogObject value for object.
     * @param  relatedObjects  List of CatalogObject value for relatedObjects.
     */
    @JsonCreator
    public RetrieveCatalogObjectResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("object") CatalogObject object,
            @JsonProperty("related_objects") List<CatalogObject> relatedObjects) {
        this.errors = errors;
        this.object = object;
        this.relatedObjects = relatedObjects;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
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

    /**
     * Getter for RelatedObjects.
     * A list of `CatalogObject`s referenced by the object in the `object` field.
     * @return Returns the List of CatalogObject
     */
    @JsonGetter("related_objects")
    public List<CatalogObject> getRelatedObjects() {
        return relatedObjects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, object, relatedObjects);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCatalogObjectResponse)) {
            return false;
        }
        RetrieveCatalogObjectResponse other = (RetrieveCatalogObjectResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(object, other.object)
            && Objects.equals(relatedObjects, other.relatedObjects);
    }

    /**
     * Converts this RetrieveCatalogObjectResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCatalogObjectResponse [" + "errors=" + errors + ", object=" + object
                + ", relatedObjects=" + relatedObjects + "]";
    }

    /**
     * Builds a new {@link RetrieveCatalogObjectResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCatalogObjectResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .object(getObject())
                .relatedObjects(getRelatedObjects());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCatalogObjectResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject object;
        private List<CatalogObject> relatedObjects;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
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
         * Setter for relatedObjects.
         * @param  relatedObjects  List of CatalogObject value for relatedObjects.
         * @return Builder
         */
        public Builder relatedObjects(List<CatalogObject> relatedObjects) {
            this.relatedObjects = relatedObjects;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCatalogObjectResponse} object using the set fields.
         * @return {@link RetrieveCatalogObjectResponse}
         */
        public RetrieveCatalogObjectResponse build() {
            RetrieveCatalogObjectResponse model =
                    new RetrieveCatalogObjectResponse(errors, object, relatedObjects);
            model.httpContext = httpContext;
            return model;
        }
    }
}
