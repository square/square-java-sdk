package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateCatalogImageResponse type.
 */
public class CreateCatalogImageResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param image
     */
    @JsonCreator
    public CreateCatalogImageResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("image") CatalogObject image) {
        this.errors = errors;
        this.image = image;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogObject image;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Image.
     */
    @JsonGetter("image")
    public CatalogObject getImage() {
        return this.image;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, image);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateCatalogImageResponse)) {
            return false;
        }
        CreateCatalogImageResponse createCatalogImageResponse = (CreateCatalogImageResponse) obj;
        return Objects.equals(errors, createCatalogImageResponse.errors) &&
            Objects.equals(image, createCatalogImageResponse.image);
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
     * Class to build instances of {@link CreateCatalogImageResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject image;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for image
         * @param image
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
            CreateCatalogImageResponse model = new CreateCatalogImageResponse(errors,
                image);
            model.httpContext = httpContext;
            return model;
        }
    }
}
