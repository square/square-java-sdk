package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for StandardUnitDescriptionGroup type.
 */
public class StandardUnitDescriptionGroup {
    private final OptionalNullable<List<StandardUnitDescription>> standardUnitDescriptions;
    private final OptionalNullable<String> languageCode;

    /**
     * Initialization constructor.
     * @param  standardUnitDescriptions  List of StandardUnitDescription value for
     *         standardUnitDescriptions.
     * @param  languageCode  String value for languageCode.
     */
    @JsonCreator
    public StandardUnitDescriptionGroup(
            @JsonProperty("standard_unit_descriptions") List<StandardUnitDescription> standardUnitDescriptions,
            @JsonProperty("language_code") String languageCode) {
        this.standardUnitDescriptions = OptionalNullable.of(standardUnitDescriptions);
        this.languageCode = OptionalNullable.of(languageCode);
    }

    /**
     * Initialization constructor.
     * @param  standardUnitDescriptions  List of StandardUnitDescription value for
     *         standardUnitDescriptions.
     * @param  languageCode  String value for languageCode.
     */
    protected StandardUnitDescriptionGroup(
            OptionalNullable<List<StandardUnitDescription>> standardUnitDescriptions,
            OptionalNullable<String> languageCode) {
        this.standardUnitDescriptions = standardUnitDescriptions;
        this.languageCode = languageCode;
    }

    /**
     * Internal Getter for StandardUnitDescriptions.
     * List of standard (non-custom) measurement units in this description group.
     * @return Returns the Internal List of StandardUnitDescription
     */
    @JsonGetter("standard_unit_descriptions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<List<StandardUnitDescription>> internalGetStandardUnitDescriptions() {
        return this.standardUnitDescriptions;
    }

    /**
     * Getter for StandardUnitDescriptions.
     * List of standard (non-custom) measurement units in this description group.
     * @return Returns the List of StandardUnitDescription
     */
    @JsonIgnore
    public List<StandardUnitDescription> getStandardUnitDescriptions() {
        return OptionalNullable.getFrom(standardUnitDescriptions);
    }

    /**
     * Internal Getter for LanguageCode.
     * IETF language tag.
     * @return Returns the Internal String
     */
    @JsonGetter("language_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetLanguageCode() {
        return this.languageCode;
    }

    /**
     * Getter for LanguageCode.
     * IETF language tag.
     * @return Returns the String
     */
    @JsonIgnore
    public String getLanguageCode() {
        return OptionalNullable.getFrom(languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(standardUnitDescriptions, languageCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardUnitDescriptionGroup)) {
            return false;
        }
        StandardUnitDescriptionGroup other = (StandardUnitDescriptionGroup) obj;
        return Objects.equals(standardUnitDescriptions, other.standardUnitDescriptions)
                && Objects.equals(languageCode, other.languageCode);
    }

    /**
     * Converts this StandardUnitDescriptionGroup into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "StandardUnitDescriptionGroup [" + "standardUnitDescriptions=" + standardUnitDescriptions
                + ", languageCode=" + languageCode + "]";
    }

    /**
     * Builds a new {@link StandardUnitDescriptionGroup.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link StandardUnitDescriptionGroup.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.standardUnitDescriptions = internalGetStandardUnitDescriptions();
        builder.languageCode = internalGetLanguageCode();
        return builder;
    }

    /**
     * Class to build instances of {@link StandardUnitDescriptionGroup}.
     */
    public static class Builder {
        private OptionalNullable<List<StandardUnitDescription>> standardUnitDescriptions;
        private OptionalNullable<String> languageCode;

        /**
         * Setter for standardUnitDescriptions.
         * @param  standardUnitDescriptions  List of StandardUnitDescription value for
         *         standardUnitDescriptions.
         * @return Builder
         */
        public Builder standardUnitDescriptions(List<StandardUnitDescription> standardUnitDescriptions) {
            this.standardUnitDescriptions = OptionalNullable.of(standardUnitDescriptions);
            return this;
        }

        /**
         * UnSetter for standardUnitDescriptions.
         * @return Builder
         */
        public Builder unsetStandardUnitDescriptions() {
            standardUnitDescriptions = null;
            return this;
        }

        /**
         * Setter for languageCode.
         * @param  languageCode  String value for languageCode.
         * @return Builder
         */
        public Builder languageCode(String languageCode) {
            this.languageCode = OptionalNullable.of(languageCode);
            return this;
        }

        /**
         * UnSetter for languageCode.
         * @return Builder
         */
        public Builder unsetLanguageCode() {
            languageCode = null;
            return this;
        }

        /**
         * Builds a new {@link StandardUnitDescriptionGroup} object using the set fields.
         * @return {@link StandardUnitDescriptionGroup}
         */
        public StandardUnitDescriptionGroup build() {
            return new StandardUnitDescriptionGroup(standardUnitDescriptions, languageCode);
        }
    }
}
