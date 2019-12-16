package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class V1Category {

    @JsonCreator
    public V1Category(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.v2Id = v2Id;
    }

    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final String v2Id;

    @Override
    public int hashCode() {
        return Objects.hash(id, name, v2Id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1Category)) {
            return false;
        }
        V1Category v1Category = (V1Category) o;
        return Objects.equals(id, v1Category.id) &&
            Objects.equals(name, v1Category.name) &&
            Objects.equals(v2Id, v1Category.v2Id);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The category's unique ID.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The category's name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple locations share the same v2 ID.
     */
    @JsonGetter("v2_id")
    public String getV2Id() { 
        return this.v2Id;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .v2Id(getV2Id());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private String v2Id;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder v2Id(String value) {
            v2Id = value;
            return this;
        }

        public V1Category build() {
            V1Category model = new V1Category(id,
                name,
                v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
