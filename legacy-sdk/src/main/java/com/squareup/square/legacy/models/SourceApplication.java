package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for SourceApplication type.
 */
public class SourceApplication {
    private final String product;
    private final OptionalNullable<String> applicationId;
    private final OptionalNullable<String> name;

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
        this.applicationId = OptionalNullable.of(applicationId);
        this.name = OptionalNullable.of(name);
    }

    /**
     * Initialization constructor.
     * @param  product  String value for product.
     * @param  applicationId  String value for applicationId.
     * @param  name  String value for name.
     */
    protected SourceApplication(String product, OptionalNullable<String> applicationId, OptionalNullable<String> name) {
        this.product = product;
        this.applicationId = applicationId;
        this.name = name;
    }

    /**
     * Getter for Product.
     * Indicates the Square product used to generate a change.
     * @return Returns the String
     */
    @JsonGetter("product")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getProduct() {
        return product;
    }

    /**
     * Internal Getter for ApplicationId.
     * __Read only__ The Square-assigned ID of the application. This field is used only if the
     * [product](entity:Product) type is `EXTERNAL_API`.
     * @return Returns the Internal String
     */
    @JsonGetter("application_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApplicationId() {
        return this.applicationId;
    }

    /**
     * Getter for ApplicationId.
     * __Read only__ The Square-assigned ID of the application. This field is used only if the
     * [product](entity:Product) type is `EXTERNAL_API`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApplicationId() {
        return OptionalNullable.getFrom(applicationId);
    }

    /**
     * Internal Getter for Name.
     * __Read only__ The display name of the application (for example, `"Custom Application"` or
     * `"Square POS 4.74 for Android"`).
     * @return Returns the Internal String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetName() {
        return this.name;
    }

    /**
     * Getter for Name.
     * __Read only__ The display name of the application (for example, `"Custom Application"` or
     * `"Square POS 4.74 for Android"`).
     * @return Returns the String
     */
    @JsonIgnore
    public String getName() {
        return OptionalNullable.getFrom(name);
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
        return "SourceApplication [" + "product=" + product + ", applicationId=" + applicationId + ", name=" + name
                + "]";
    }

    /**
     * Builds a new {@link SourceApplication.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SourceApplication.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().product(getProduct());
        builder.applicationId = internalGetApplicationId();
        builder.name = internalGetName();
        return builder;
    }

    /**
     * Class to build instances of {@link SourceApplication}.
     */
    public static class Builder {
        private String product;
        private OptionalNullable<String> applicationId;
        private OptionalNullable<String> name;

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
            this.applicationId = OptionalNullable.of(applicationId);
            return this;
        }

        /**
         * UnSetter for applicationId.
         * @return Builder
         */
        public Builder unsetApplicationId() {
            applicationId = null;
            return this;
        }

        /**
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = OptionalNullable.of(name);
            return this;
        }

        /**
         * UnSetter for name.
         * @return Builder
         */
        public Builder unsetName() {
            name = null;
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
