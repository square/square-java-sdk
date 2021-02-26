
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateCatalogImageResponse type.
 */
public class CreateCatalogImageResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogObject image;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  image  CatalogObject value for image.
     */
    @JsonCreator
    public CreateCatalogImageResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("image") CatalogObject image) {
        this.errors = errors;
        this.image = image;
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
     * Getter for Image.
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
    @JsonGetter("image")
    public CatalogObject getImage() {
        return image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, image);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateCatalogImageResponse)) {
            return false;
        }
        CreateCatalogImageResponse other = (CreateCatalogImageResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(image, other.image);
    }

    /**
     * Converts this CreateCatalogImageResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateCatalogImageResponse [" + "errors=" + errors + ", image=" + image + "]";
    }

    /**
     * Builds a new {@link CreateCatalogImageResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCatalogImageResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .image(getImage());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateCatalogImageResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject image;



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
         * Setter for image.
         * @param  image  CatalogObject value for image.
         * @return Builder
         */
        public Builder image(CatalogObject image) {
            this.image = image;
            return this;
        }

        /**
         * Builds a new {@link CreateCatalogImageResponse} object using the set fields.
         * @return {@link CreateCatalogImageResponse}
         */
        public CreateCatalogImageResponse build() {
            CreateCatalogImageResponse model =
                    new CreateCatalogImageResponse(errors, image);
            model.httpContext = httpContext;
            return model;
        }
    }
}
