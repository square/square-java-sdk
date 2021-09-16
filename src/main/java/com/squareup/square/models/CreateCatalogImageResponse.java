
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
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
     * The wrapper object for the catalog entries of a given object type. Depending on the `type`
     * attribute value, a `CatalogObject` instance assumes a type-specific data to yield the
     * corresponding type of catalog object. For example, if `type=ITEM`, the `CatalogObject`
     * instance must have the ITEM-specific data set on the `item_data` attribute. The resulting
     * `CatalogObject` instance is also a `CatalogItem` instance. In general, if
     * `type=<OBJECT_TYPE>`, the `CatalogObject` instance must have the `<OBJECT_TYPE>`-specific
     * data set on the `<object_type>_data` attribute. The resulting `CatalogObject` instance is
     * also a `Catalog<ObjectType>` instance. For a more detailed discussion of the Catalog data
     * model, please see the [Design a
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
