
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for TaxIds type.
 */
public class TaxIds {
    private final String euVat;
    private final String frSiret;
    private final String frNaf;

    /**
     * Initialization constructor.
     * @param  euVat  String value for euVat.
     * @param  frSiret  String value for frSiret.
     * @param  frNaf  String value for frNaf.
     */
    @JsonCreator
    public TaxIds(
            @JsonProperty("eu_vat") String euVat,
            @JsonProperty("fr_siret") String frSiret,
            @JsonProperty("fr_naf") String frNaf) {
        this.euVat = euVat;
        this.frSiret = frSiret;
        this.frNaf = frNaf;
    }

    /**
     * Getter for EuVat.
     * The EU VAT number for this location. For example, `IE3426675K`. If the EU VAT number is
     * present, it is well-formed and has been validated with VIES, the VAT Information Exchange
     * System.
     * @return Returns the String
     */
    @JsonGetter("eu_vat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEuVat() {
        return euVat;
    }

    /**
     * Getter for FrSiret.
     * The SIRET (Système d'Identification du Répertoire des Entreprises et de leurs Etablissements)
     * number is a 14 digit code issued by the French INSEE. For example, `39922799000021`.
     * @return Returns the String
     */
    @JsonGetter("fr_siret")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFrSiret() {
        return frSiret;
    }

    /**
     * Getter for FrNaf.
     * The French government uses the NAF (Nomenclature des Activités Françaises) to display and
     * track economic statistical data. This is also called the APE (Activite Principale de
     * l’Entreprise) code. For example, `6910Z`.
     * @return Returns the String
     */
    @JsonGetter("fr_naf")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getFrNaf() {
        return frNaf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(euVat, frSiret, frNaf);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxIds)) {
            return false;
        }
        TaxIds other = (TaxIds) obj;
        return Objects.equals(euVat, other.euVat)
            && Objects.equals(frSiret, other.frSiret)
            && Objects.equals(frNaf, other.frNaf);
    }

    /**
     * Converts this TaxIds into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TaxIds [" + "euVat=" + euVat + ", frSiret=" + frSiret + ", frNaf=" + frNaf + "]";
    }

    /**
     * Builds a new {@link TaxIds.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TaxIds.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .euVat(getEuVat())
                .frSiret(getFrSiret())
                .frNaf(getFrNaf());
        return builder;
    }

    /**
     * Class to build instances of {@link TaxIds}.
     */
    public static class Builder {
        private String euVat;
        private String frSiret;
        private String frNaf;



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
         * Setter for frSiret.
         * @param  frSiret  String value for frSiret.
         * @return Builder
         */
        public Builder frSiret(String frSiret) {
            this.frSiret = frSiret;
            return this;
        }

        /**
         * Setter for frNaf.
         * @param  frNaf  String value for frNaf.
         * @return Builder
         */
        public Builder frNaf(String frNaf) {
            this.frNaf = frNaf;
            return this;
        }

        /**
         * Builds a new {@link TaxIds} object using the set fields.
         * @return {@link TaxIds}
         */
        public TaxIds build() {
            return new TaxIds(euVat, frSiret, frNaf);
        }
    }
}
