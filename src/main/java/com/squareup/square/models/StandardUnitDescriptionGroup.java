package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for StandardUnitDescriptionGroup type.
 */
public class StandardUnitDescriptionGroup {

    /**
     * Initialization constructor.
     * @param standardUnitDescriptions
     * @param languageCode
     */
    @JsonCreator
    public StandardUnitDescriptionGroup(
            @JsonProperty("standard_unit_descriptions") List<StandardUnitDescription> standardUnitDescriptions,
            @JsonProperty("language_code") String languageCode) {
        this.standardUnitDescriptions = standardUnitDescriptions;
        this.languageCode = languageCode;
    }

    private final List<StandardUnitDescription> standardUnitDescriptions;
    private final String languageCode;
    /**
     * Getter for StandardUnitDescriptions.
     * List of standard (non-custom) measurement units in this description group.
     */
    @JsonGetter("standard_unit_descriptions")
    public List<StandardUnitDescription> getStandardUnitDescriptions() {
        return this.standardUnitDescriptions;
    }

    /**
     * Getter for LanguageCode.
     * IETF language tag.
     */
    @JsonGetter("language_code")
    public String getLanguageCode() {
        return this.languageCode;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(standardUnitDescriptions, languageCode);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof StandardUnitDescriptionGroup)) {
            return false;
        }
        StandardUnitDescriptionGroup standardUnitDescriptionGroup = (StandardUnitDescriptionGroup) obj;
        return Objects.equals(standardUnitDescriptions, standardUnitDescriptionGroup.standardUnitDescriptions) &&
            Objects.equals(languageCode, standardUnitDescriptionGroup.languageCode);
    }

    /**
     * Builds a new {@link StandardUnitDescriptionGroup.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link StandardUnitDescriptionGroup.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .standardUnitDescriptions(getStandardUnitDescriptions())
            .languageCode(getLanguageCode());
            return builder;
    }

    /**
     * Class to build instances of {@link StandardUnitDescriptionGroup}
     */
    public static class Builder {
        private List<StandardUnitDescription> standardUnitDescriptions;
        private String languageCode;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for standardUnitDescriptions
         * @param standardUnitDescriptions
         * @return Builder
         */
        public Builder standardUnitDescriptions(List<StandardUnitDescription> standardUnitDescriptions) {
            this.standardUnitDescriptions = standardUnitDescriptions;
            return this;
        }
        /**
         * Setter for languageCode
         * @param languageCode
         * @return Builder
         */
        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        /**
         * Builds a new {@link StandardUnitDescriptionGroup} object using the set fields.
         * @return {@link StandardUnitDescriptionGroup}
         */
        public StandardUnitDescriptionGroup build() {
            return new StandardUnitDescriptionGroup(standardUnitDescriptions,
                languageCode);
        }
    }
}
