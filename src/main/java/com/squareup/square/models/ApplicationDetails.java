
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.BaseModel;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ApplicationDetails type.
 */
public class ApplicationDetails {
    private final String squareProduct;
    private final OptionalNullable<String> applicationId;

    /**
     * Initialization constructor.
     * @param  squareProduct  String value for squareProduct.
     * @param  applicationId  String value for applicationId.
     */
    @JsonCreator
    public ApplicationDetails(
            @JsonProperty("square_product") String squareProduct,
            @JsonProperty("application_id") String applicationId) {
        this.squareProduct = squareProduct;
        this.applicationId = OptionalNullable.of(applicationId);
    }

    /**
     * Internal initialization constructor.
     */
    protected ApplicationDetails(String squareProduct, OptionalNullable<String> applicationId) {
        this.squareProduct = squareProduct;
        this.applicationId = applicationId;
    }

    /**
     * Getter for SquareProduct.
     * A list of products to return to external callers.
     * @return Returns the String
     */
    @JsonGetter("square_product")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSquareProduct() {
        return squareProduct;
    }

    /**
     * Internal Getter for ApplicationId.
     * The Square ID assigned to the application used to take the payment. Application developers
     * can use this information to identify payments that their application processed. For example,
     * if a developer uses a custom application to process payments, this field contains the
     * application ID from the Developer Dashboard. If a seller uses a [Square App
     * Marketplace](https://developer.squareup.com/docs/app-marketplace) application to process
     * payments, the field contains the corresponding application ID.
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
     * The Square ID assigned to the application used to take the payment. Application developers
     * can use this information to identify payments that their application processed. For example,
     * if a developer uses a custom application to process payments, this field contains the
     * application ID from the Developer Dashboard. If a seller uses a [Square App
     * Marketplace](https://developer.squareup.com/docs/app-marketplace) application to process
     * payments, the field contains the corresponding application ID.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApplicationId() {
        return OptionalNullable.getFrom(applicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squareProduct, applicationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationDetails)) {
            return false;
        }
        ApplicationDetails other = (ApplicationDetails) obj;
        return Objects.equals(squareProduct, other.squareProduct)
            && Objects.equals(applicationId, other.applicationId);
    }

    /**
     * Converts this ApplicationDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ApplicationDetails [" + "squareProduct=" + squareProduct + ", applicationId="
                + applicationId + "]";
    }

    /**
     * Builds a new {@link ApplicationDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ApplicationDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .squareProduct(getSquareProduct());
        builder.applicationId = internalGetApplicationId();
        return builder;
    }

    /**
     * Class to build instances of {@link ApplicationDetails}.
     */
    public static class Builder {
        private String squareProduct;
        private OptionalNullable<String> applicationId;



        /**
         * Setter for squareProduct.
         * @param  squareProduct  String value for squareProduct.
         * @return Builder
         */
        public Builder squareProduct(String squareProduct) {
            this.squareProduct = squareProduct;
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
         * Builds a new {@link ApplicationDetails} object using the set fields.
         * @return {@link ApplicationDetails}
         */
        public ApplicationDetails build() {
            return new ApplicationDetails(squareProduct, applicationId);
        }
    }
}
