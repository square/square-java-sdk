
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
 * This is a model class for TaxIds type.
 */
public class TaxIds {
    private final OptionalNullable<String> euVat;
    private final OptionalNullable<String> frSiret;
    private final OptionalNullable<String> frNaf;
    private final OptionalNullable<String> esNif;

    /**
     * Initialization constructor.
     * @param  euVat  String value for euVat.
     * @param  frSiret  String value for frSiret.
     * @param  frNaf  String value for frNaf.
     * @param  esNif  String value for esNif.
     */
    @JsonCreator
    public TaxIds(
            @JsonProperty("eu_vat") String euVat,
            @JsonProperty("fr_siret") String frSiret,
            @JsonProperty("fr_naf") String frNaf,
            @JsonProperty("es_nif") String esNif) {
        this.euVat = OptionalNullable.of(euVat);
        this.frSiret = OptionalNullable.of(frSiret);
        this.frNaf = OptionalNullable.of(frNaf);
        this.esNif = OptionalNullable.of(esNif);
    }

    /**
     * Internal initialization constructor.
     */
    protected TaxIds(OptionalNullable<String> euVat, OptionalNullable<String> frSiret,
            OptionalNullable<String> frNaf, OptionalNullable<String> esNif) {
        this.euVat = euVat;
        this.frSiret = frSiret;
        this.frNaf = frNaf;
        this.esNif = esNif;
    }

    /**
     * Internal Getter for EuVat.
     * The EU VAT number for this location. For example, `IE3426675K`. If the EU VAT number is
     * present, it is well-formed and has been validated with VIES, the VAT Information Exchange
     * System.
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
     * The EU VAT number for this location. For example, `IE3426675K`. If the EU VAT number is
     * present, it is well-formed and has been validated with VIES, the VAT Information Exchange
     * System.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEuVat() {
        return OptionalNullable.getFrom(euVat);
    }

    /**
     * Internal Getter for FrSiret.
     * The SIRET (Système d'Identification du Répertoire des Entreprises et de leurs Etablissements)
     * number is a 14-digit code issued by the French INSEE. For example, `39922799000021`.
     * @return Returns the Internal String
     */
    @JsonGetter("fr_siret")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFrSiret() {
        return this.frSiret;
    }

    /**
     * Getter for FrSiret.
     * The SIRET (Système d'Identification du Répertoire des Entreprises et de leurs Etablissements)
     * number is a 14-digit code issued by the French INSEE. For example, `39922799000021`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFrSiret() {
        return OptionalNullable.getFrom(frSiret);
    }

    /**
     * Internal Getter for FrNaf.
     * The French government uses the NAF (Nomenclature des Activités Françaises) to display and
     * track economic statistical data. This is also called the APE (Activite Principale de
     * l’Entreprise) code. For example, `6910Z`.
     * @return Returns the Internal String
     */
    @JsonGetter("fr_naf")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetFrNaf() {
        return this.frNaf;
    }

    /**
     * Getter for FrNaf.
     * The French government uses the NAF (Nomenclature des Activités Françaises) to display and
     * track economic statistical data. This is also called the APE (Activite Principale de
     * l’Entreprise) code. For example, `6910Z`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getFrNaf() {
        return OptionalNullable.getFrom(frNaf);
    }

    /**
     * Internal Getter for EsNif.
     * The NIF (Numero de Identificacion Fiscal) number is a nine-character tax identifier used in
     * Spain. If it is present, it has been validated. For example, `73628495A`.
     * @return Returns the Internal String
     */
    @JsonGetter("es_nif")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetEsNif() {
        return this.esNif;
    }

    /**
     * Getter for EsNif.
     * The NIF (Numero de Identificacion Fiscal) number is a nine-character tax identifier used in
     * Spain. If it is present, it has been validated. For example, `73628495A`.
     * @return Returns the String
     */
    @JsonIgnore
    public String getEsNif() {
        return OptionalNullable.getFrom(esNif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(euVat, frSiret, frNaf, esNif);
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
            && Objects.equals(frNaf, other.frNaf)
            && Objects.equals(esNif, other.esNif);
    }

    /**
     * Converts this TaxIds into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "TaxIds [" + "euVat=" + euVat + ", frSiret=" + frSiret + ", frNaf=" + frNaf
                + ", esNif=" + esNif + "]";
    }

    /**
     * Builds a new {@link TaxIds.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link TaxIds.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.euVat = internalGetEuVat();
        builder.frSiret = internalGetFrSiret();
        builder.frNaf = internalGetFrNaf();
        builder.esNif = internalGetEsNif();
        return builder;
    }

    /**
     * Class to build instances of {@link TaxIds}.
     */
    public static class Builder {
        private OptionalNullable<String> euVat;
        private OptionalNullable<String> frSiret;
        private OptionalNullable<String> frNaf;
        private OptionalNullable<String> esNif;



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
         * Setter for frSiret.
         * @param  frSiret  String value for frSiret.
         * @return Builder
         */
        public Builder frSiret(String frSiret) {
            this.frSiret = OptionalNullable.of(frSiret);
            return this;
        }

        /**
         * UnSetter for frSiret.
         * @return Builder
         */
        public Builder unsetFrSiret() {
            frSiret = null;
            return this;
        }

        /**
         * Setter for frNaf.
         * @param  frNaf  String value for frNaf.
         * @return Builder
         */
        public Builder frNaf(String frNaf) {
            this.frNaf = OptionalNullable.of(frNaf);
            return this;
        }

        /**
         * UnSetter for frNaf.
         * @return Builder
         */
        public Builder unsetFrNaf() {
            frNaf = null;
            return this;
        }

        /**
         * Setter for esNif.
         * @param  esNif  String value for esNif.
         * @return Builder
         */
        public Builder esNif(String esNif) {
            this.esNif = OptionalNullable.of(esNif);
            return this;
        }

        /**
         * UnSetter for esNif.
         * @return Builder
         */
        public Builder unsetEsNif() {
            esNif = null;
            return this;
        }

        /**
         * Builds a new {@link TaxIds} object using the set fields.
         * @return {@link TaxIds}
         */
        public TaxIds build() {
            return new TaxIds(euVat, frSiret, frNaf, esNif);
        }
    }
}
