package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DataCollectionOptions type.
 */
public class DataCollectionOptions {
    private final String title;
    private final String body;
    private final String inputType;
    private final CollectedData collectedData;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  body  String value for body.
     * @param  inputType  String value for inputType.
     * @param  collectedData  CollectedData value for collectedData.
     */
    @JsonCreator
    public DataCollectionOptions(
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("input_type") String inputType,
            @JsonProperty("collected_data") CollectedData collectedData) {
        this.title = title;
        this.body = body;
        this.inputType = inputType;
        this.collectedData = collectedData;
    }

    /**
     * Getter for Title.
     * The title text to display in the data collection flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Body.
     * The body text to display under the title in the data collection screen flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("body")
    public String getBody() {
        return body;
    }

    /**
     * Getter for InputType.
     * Describes the input type of the data.
     * @return Returns the String
     */
    @JsonGetter("input_type")
    public String getInputType() {
        return inputType;
    }

    /**
     * Getter for CollectedData.
     * @return Returns the CollectedData
     */
    @JsonGetter("collected_data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CollectedData getCollectedData() {
        return collectedData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, inputType, collectedData);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataCollectionOptions)) {
            return false;
        }
        DataCollectionOptions other = (DataCollectionOptions) obj;
        return Objects.equals(title, other.title)
                && Objects.equals(body, other.body)
                && Objects.equals(inputType, other.inputType)
                && Objects.equals(collectedData, other.collectedData);
    }

    /**
     * Converts this DataCollectionOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DataCollectionOptions [" + "title=" + title + ", body=" + body + ", inputType=" + inputType
                + ", collectedData=" + collectedData + "]";
    }

    /**
     * Builds a new {@link DataCollectionOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DataCollectionOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(title, body, inputType).collectedData(getCollectedData());
        return builder;
    }

    /**
     * Class to build instances of {@link DataCollectionOptions}.
     */
    public static class Builder {
        private String title;
        private String body;
        private String inputType;
        private CollectedData collectedData;

        /**
         * Initialization constructor.
         * @param  title  String value for title.
         * @param  body  String value for body.
         * @param  inputType  String value for inputType.
         */
        public Builder(String title, String body, String inputType) {
            this.title = title;
            this.body = body;
            this.inputType = inputType;
        }

        /**
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Setter for body.
         * @param  body  String value for body.
         * @return Builder
         */
        public Builder body(String body) {
            this.body = body;
            return this;
        }

        /**
         * Setter for inputType.
         * @param  inputType  String value for inputType.
         * @return Builder
         */
        public Builder inputType(String inputType) {
            this.inputType = inputType;
            return this;
        }

        /**
         * Setter for collectedData.
         * @param  collectedData  CollectedData value for collectedData.
         * @return Builder
         */
        public Builder collectedData(CollectedData collectedData) {
            this.collectedData = collectedData;
            return this;
        }

        /**
         * Builds a new {@link DataCollectionOptions} object using the set fields.
         * @return {@link DataCollectionOptions}
         */
        public DataCollectionOptions build() {
            return new DataCollectionOptions(title, body, inputType, collectedData);
        }
    }
}
