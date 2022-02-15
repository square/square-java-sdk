
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for InvoiceRecipientTaxIds type.
 */
public class InvoiceRecipientTaxIds {
    private final String euVat;

    /**
     * Initialization constructor.
     * @param  euVat  String value for euVat.
     */
    @JsonCreator
    public InvoiceRecipientTaxIds(
            @JsonProperty("eu_vat") String euVat) {
        this.euVat = euVat;
    }

    /**
     * Getter for EuVat.
     * The EU VAT identification number for the invoice recipient. For example, `IE3426675K`.
     * @return Returns the String
     */
    @JsonGetter("eu_vat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEuVat() {
        return euVat;
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
        if (!(obj instanceof InvoiceRecipientTaxIds)) {
            return false;
        }
        InvoiceRecipientTaxIds other = (InvoiceRecipientTaxIds) obj;
        return Objects.equals(euVat, other.euVat);
    }

    /**
     * Converts this InvoiceRecipientTaxIds into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "InvoiceRecipientTaxIds [" + "euVat=" + euVat + "]";
    }

    /**
     * Builds a new {@link InvoiceRecipientTaxIds.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoiceRecipientTaxIds.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .euVat(getEuVat());
        return builder;
    }

    /**
     * Class to build instances of {@link InvoiceRecipientTaxIds}.
     */
    public static class Builder {
        private String euVat;



        /**
         * Setter for euVat.
         * @param  euVat  String value for euVat.
         * @return Builder
         */
        public Builder euVat(String euVat) {
            this.euVat = euVat;
            return this;
        }

        /**
         * Builds a new {@link InvoiceRecipientTaxIds} object using the set fields.
         * @return {@link InvoiceRecipientTaxIds}
         */
        public InvoiceRecipientTaxIds build() {
            return new InvoiceRecipientTaxIds(euVat);
        }
    }
}
