package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class StandardUnitDescriptionGroup {

    @JsonCreator
    public StandardUnitDescriptionGroup(
            @JsonProperty("standard_unit_descriptions") List<StandardUnitDescription> standardUnitDescriptions,
            @JsonProperty("language_code") String languageCode) {
        this.standardUnitDescriptions = standardUnitDescriptions;
        this.languageCode = languageCode;
    }

    private final List<StandardUnitDescription> standardUnitDescriptions;
    private final String languageCode;

    @Override
    public int hashCode() {
        return Objects.hash(standardUnitDescriptions, languageCode);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StandardUnitDescriptionGroup)) {
            return false;
        }
        StandardUnitDescriptionGroup standardUnitDescriptionGroup = (StandardUnitDescriptionGroup) o;
        return Objects.equals(standardUnitDescriptions, standardUnitDescriptionGroup.standardUnitDescriptions) &&
            Objects.equals(languageCode, standardUnitDescriptionGroup.languageCode);
    }

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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .standardUnitDescriptions(getStandardUnitDescriptions())
            .languageCode(getLanguageCode());
            return builder;
    }

    public static class Builder {
        private List<StandardUnitDescription> standardUnitDescriptions;
        private String languageCode;

        public Builder() { }

        public Builder standardUnitDescriptions(List<StandardUnitDescription> value) {
            standardUnitDescriptions = value;
            return this;
        }
        public Builder languageCode(String value) {
            languageCode = value;
            return this;
        }

        public StandardUnitDescriptionGroup build() {
            return new StandardUnitDescriptionGroup(standardUnitDescriptions,
                languageCode);
        }
    }
}
