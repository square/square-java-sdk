package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreateCatalogImageResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, image);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateCatalogImageResponse)) {
            return false;
        }
        CreateCatalogImageResponse createCatalogImageResponse = (CreateCatalogImageResponse) o;
        return Objects.equals(errors, createCatalogImageResponse.errors) &&
            Objects.equals(image, createCatalogImageResponse.image);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .image(getImage());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogObject image;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder image(CatalogObject value) {
            image = value;
            return this;
        }

        public CreateCatalogImageResponse build() {
            CreateCatalogImageResponse model = new CreateCatalogImageResponse(errors,
                image);
            model.httpContext = httpContext;
            return model;
        }
    }
}
