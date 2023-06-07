
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CollectedData type.
 */
public class CollectedData {
    private final String inputText;

    /**
     * Initialization constructor.
     * @param  inputText  String value for inputText.
     */
    @JsonCreator
    public CollectedData(
            @JsonProperty("input_text") String inputText) {
        this.inputText = inputText;
    }

    /**
     * Getter for InputText.
     * The buyer's input text.
     * @return Returns the String
     */
    @JsonGetter("input_text")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInputText() {
        return inputText;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputText);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectedData)) {
            return false;
        }
        CollectedData other = (CollectedData) obj;
        return Objects.equals(inputText, other.inputText);
    }

    /**
     * Converts this CollectedData into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CollectedData [" + "inputText=" + inputText + "]";
    }

    /**
     * Builds a new {@link CollectedData.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CollectedData.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .inputText(getInputText());
        return builder;
    }

    /**
     * Class to build instances of {@link CollectedData}.
     */
    public static class Builder {
        private String inputText;



        /**
         * Setter for inputText.
         * @param  inputText  String value for inputText.
         * @return Builder
         */
        public Builder inputText(String inputText) {
            this.inputText = inputText;
            return this;
        }

        /**
         * Builds a new {@link CollectedData} object using the set fields.
         * @return {@link CollectedData}
         */
        public CollectedData build() {
            return new CollectedData(inputText);
        }
    }
}
