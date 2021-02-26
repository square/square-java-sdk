
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for StandardUnitDescriptionGroup type.
 */
public class StandardUnitDescriptionGroup {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<StandardUnitDescription> standardUnitDescriptions;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String languageCode;

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
        this.standardUnitDescriptions = standardUnitDescriptions;
        this.languageCode = languageCode;
    }

    /**
     * Getter for StandardUnitDescriptions.
     * List of standard (non-custom) measurement units in this description group.
     * @return Returns the List of StandardUnitDescription
     */
    @JsonGetter("standard_unit_descriptions")
    public List<StandardUnitDescription> getStandardUnitDescriptions() {
        return standardUnitDescriptions;
    }

    /**
     * Getter for LanguageCode.
     * IETF language tag.
     * @return Returns the String
     */
    @JsonGetter("language_code")
    public String getLanguageCode() {
        return languageCode;
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
        return "StandardUnitDescriptionGroup [" + "standardUnitDescriptions="
                + standardUnitDescriptions + ", languageCode=" + languageCode + "]";
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
     * Class to build instances of {@link StandardUnitDescriptionGroup}.
     */
    public static class Builder {
        private List<StandardUnitDescription> standardUnitDescriptions;
        private String languageCode;



        /**
         * Setter for standardUnitDescriptions.
         * @param  standardUnitDescriptions  List of StandardUnitDescription value for
         *         standardUnitDescriptions.
         * @return Builder
         */
        public Builder standardUnitDescriptions(
                List<StandardUnitDescription> standardUnitDescriptions) {
            this.standardUnitDescriptions = standardUnitDescriptions;
            return this;
        }

        /**
         * Setter for languageCode.
         * @param  languageCode  String value for languageCode.
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
            return new StandardUnitDescriptionGroup(standardUnitDescriptions, languageCode);
        }
    }
}
