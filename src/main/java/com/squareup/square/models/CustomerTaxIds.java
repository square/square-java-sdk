
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CustomerTaxIds type.
 */
public class CustomerTaxIds {
    private final OptionalNullable<String> euVat;

    /**
     * Initialization constructor.
     * @param  euVat  String value for euVat.
     */
    @JsonCreator
    public CustomerTaxIds(
            @JsonProperty("eu_vat") String euVat) {
        this.euVat = OptionalNullable.of(euVat);
    }

    /**
     * Internal initialization constructor.
     */
    protected CustomerTaxIds(OptionalNullable<String> euVat) {
        this.euVat = euVat;
    }

    /**
     * Internal Getter for EuVat.
     * The EU VAT identification number for the customer. For example, `IE3426675K`. The ID can
     * contain alphanumeric characters only.
     * @return Returns the Internal String
     */
    @JsonGetter("eu_vat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEuVat() {
        return this.euVat;
    }

    /**
     * Getter for EuVat.
     * The EU VAT identification number for the customer. For example, `IE3426675K`. The ID can
     * contain alphanumeric characters only.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEuVat() {
        return OptionalNullable.getFrom(euVat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(euVat);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomerTaxIds)) {
            return false;
        }
        CustomerTaxIds other = (CustomerTaxIds) obj;
        return Objects.equals(euVat, other.euVat);
    }

    /**
     * Converts this CustomerTaxIds into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CustomerTaxIds [" + "euVat=" + euVat + "]";
    }

    /**
     * Builds a new {@link CustomerTaxIds.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerTaxIds.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.euVat = internalGetEuVat();
        return builder;
    }

    /**
     * Class to build instances of {@link CustomerTaxIds}.
     */
    public static class Builder {
        private OptionalNullable<String> euVat;



        /**
         * Setter for euVat.
         * @param  euVat  String value for euVat.
         * @return Builder
         */
        public Builder euVat(String euVat) {
            this.euVat = OptionalNullable.of(euVat);
            return this;
        }

        /**
         * UnSetter for euVat.
         * @return Builder
         */
        public Builder unsetEuVat() {
            euVat = null;
            return this;
        }

        /**
         * Builds a new {@link CustomerTaxIds} object using the set fields.
         * @return {@link CustomerTaxIds}
         */
        public CustomerTaxIds build() {
            return new CustomerTaxIds(euVat);
        }
    }
}
