
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SourceApplication type.
 */
public class SourceApplication {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String product;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String applicationId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String name;

    /**
     * Initialization constructor.
     * @param  product  String value for product.
     * @param  applicationId  String value for applicationId.
     * @param  name  String value for name.
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

    /**
     * Getter for Product.
     * Indicates the Square product used to generate an inventory change.
     * @return Returns the String
     */
    @JsonGetter("product")
    public String getProduct() {
        return product;
    }

    /**
     * Getter for ApplicationId.
     * Read-only Square ID assigned to the application. Only used for [Product]($m/Product) type
     * `EXTERNAL_API`.
     * @return Returns the String
     */
    @JsonGetter("application_id")
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Getter for Name.
     * Read-only display name assigned to the application (e.g. `"Custom Application"`, `"Square POS
     * 4.74 for Android"`).
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, applicationId, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SourceApplication)) {
            return false;
        }
        SourceApplication other = (SourceApplication) obj;
        return Objects.equals(product, other.product)
            && Objects.equals(applicationId, other.applicationId)
            && Objects.equals(name, other.name);
    }

    /**
     * Converts this SourceApplication into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SourceApplication [" + "product=" + product + ", applicationId=" + applicationId
                + ", name=" + name + "]";
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
     * Class to build instances of {@link SourceApplication}.
     */
    public static class Builder {
        private String product;
        private String applicationId;
        private String name;



        /**
         * Setter for product.
         * @param  product  String value for product.
         * @return Builder
         */
        public Builder product(String product) {
            this.product = product;
            return this;
        }

        /**
         * Setter for applicationId.
         * @param  applicationId  String value for applicationId.
         * @return Builder
         */
        public Builder applicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
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
            return new SourceApplication(product, applicationId, name);
        }
    }
}
