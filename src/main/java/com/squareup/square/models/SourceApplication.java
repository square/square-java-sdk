package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class SourceApplication {

    @JsonCreator
    public SourceApplication(
            @JsonProperty("product") String product,
            @JsonProperty("application_id") String applicationId,
            @JsonProperty("name") String name) {
        this.product = product;
        this.applicationId = applicationId;
        this.name = name;
    }

    private final String product;
    private final String applicationId;
    private final String name;

    @Override
    public int hashCode() {
        return Objects.hash(product, applicationId, name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SourceApplication)) {
            return false;
        }
        SourceApplication sourceApplication = (SourceApplication) o;
        return Objects.equals(product, sourceApplication.product) &&
            Objects.equals(applicationId, sourceApplication.applicationId) &&
            Objects.equals(name, sourceApplication.name);
    }

    /**
     * Getter for Product.
     * Indicates the Square product used to generate an inventory change.
     */
    @JsonGetter("product")
    public String getProduct() { 
        return this.product;
    }

    /**
     * Getter for ApplicationId.
     * Read-only Square ID assigned to the application. Only used for
     * [Product](#type-product) type `EXTERNAL_API`.
     */
    @JsonGetter("application_id")
    public String getApplicationId() { 
        return this.applicationId;
    }

    /**
     * Getter for Name.
     * Read-only display name assigned to the application
     * (e.g. `"Custom Application"`, `"Square POS 4.74 for Android"`).
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .product(getProduct())
            .applicationId(getApplicationId())
            .name(getName());
            return builder;
    }

    public static class Builder {
        private String product;
        private String applicationId;
        private String name;

        public Builder() { }

        public Builder product(String value) {
            product = value;
            return this;
        }
        public Builder applicationId(String value) {
            applicationId = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }

        public SourceApplication build() {
            return new SourceApplication(product,
                applicationId,
                name);
        }
    }
}
