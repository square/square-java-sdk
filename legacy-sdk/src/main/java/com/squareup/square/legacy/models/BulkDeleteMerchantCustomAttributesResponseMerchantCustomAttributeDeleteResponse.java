package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse type.
 */
public class BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse {
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse(
            @JsonProperty("errors") List<Error> errors) {
        this.errors = errors;
    }

    /**
     * Getter for Errors.
     * Errors that occurred while processing the individual MerchantCustomAttributeDeleteRequest
     * request
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse)) {
            return false;
        }
        BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse other =
                (BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse) obj;
        return Objects.equals(errors, other.errors);
    }

    /**
     * Converts this BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse [" + "errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse}.
     */
    public static class Builder {
        private List<Error> errors;

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
         * Builds a new {@link
         * BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse} object
         * using the set fields.
         * @return {@link BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse}
         */
        public BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse build() {
            return new BulkDeleteMerchantCustomAttributesResponseMerchantCustomAttributeDeleteResponse(errors);
        }
    }
}
