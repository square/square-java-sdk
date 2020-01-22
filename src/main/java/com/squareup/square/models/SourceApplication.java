package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SourceApplication type.
 */
public class SourceApplication {

    /**
     * Initialization constructor.
     * @param product
     * @param applicationId
     * @param name
     */
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

 
    @Override
    public int hashCode() {
        return Objects.hash(product, applicationId, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SourceApplication)) {
            return false;
        }
        SourceApplication sourceApplication = (SourceApplication) obj;
        return Objects.equals(product, sourceApplication.product) &&
            Objects.equals(applicationId, sourceApplication.applicationId) &&
            Objects.equals(name, sourceApplication.name);
    }

    /**
     * Builds a new {@link SourceApplication.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SourceApplication.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .product(getProduct())
            .applicationId(getApplicationId())
            .name(getName());
            return builder;
    }

    /**
     * Class to build instances of {@link SourceApplication}
     */
    public static class Builder {
        private String product;
        private String applicationId;
        private String name;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for product
         * @param product
         * @return Builder
         */
        public Builder product(String product) {
            this.product = product;
            return this;
        }
        /**
         * Setter for applicationId
         * @param applicationId
         * @return Builder
         */
        public Builder applicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }
        /**
         * Setter for name
         * @param name
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Builds a new {@link SourceApplication} object using the set fields.
         * @return {@link SourceApplication}
         */
        public SourceApplication build() {
            return new SourceApplication(product,
                applicationId,
                name);
        }
    }
}
