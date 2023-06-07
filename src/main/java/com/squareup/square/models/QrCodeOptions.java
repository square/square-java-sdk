
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for QrCodeOptions type.
 */
public class QrCodeOptions {
    private final String title;
    private final String body;
    private final String barcodeContents;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  body  String value for body.
     * @param  barcodeContents  String value for barcodeContents.
     */
    @JsonCreator
    public QrCodeOptions(
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("barcode_contents") String barcodeContents) {
        this.title = title;
        this.body = body;
        this.barcodeContents = barcodeContents;
    }

    /**
     * Getter for Title.
     * The title text to display in the QR code flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Body.
     * The body text to display in the QR code flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("body")
    public String getBody() {
        return body;
    }

    /**
     * Getter for BarcodeContents.
     * The text representation of the data to show in the QR code as UTF8-encoded data.
     * @return Returns the String
     */
    @JsonGetter("barcode_contents")
    public String getBarcodeContents() {
        return barcodeContents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, barcodeContents);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QrCodeOptions)) {
            return false;
        }
        QrCodeOptions other = (QrCodeOptions) obj;
        return Objects.equals(title, other.title)
            && Objects.equals(body, other.body)
            && Objects.equals(barcodeContents, other.barcodeContents);
    }

    /**
     * Converts this QrCodeOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "QrCodeOptions [" + "title=" + title + ", body=" + body + ", barcodeContents="
                + barcodeContents + "]";
    }

    /**
     * Builds a new {@link QrCodeOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link QrCodeOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(title, body, barcodeContents);
        return builder;
    }

    /**
     * Class to build instances of {@link QrCodeOptions}.
     */
    public static class Builder {
        private String title;
        private String body;
        private String barcodeContents;

        /**
         * Initialization constructor.
         * @param  title  String value for title.
         * @param  body  String value for body.
         * @param  barcodeContents  String value for barcodeContents.
         */
        public Builder(String title, String body, String barcodeContents) {
            this.title = title;
            this.body = body;
            this.barcodeContents = barcodeContents;
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
         * Setter for barcodeContents.
         * @param  barcodeContents  String value for barcodeContents.
         * @return Builder
         */
        public Builder barcodeContents(String barcodeContents) {
            this.barcodeContents = barcodeContents;
            return this;
        }

        /**
         * Builds a new {@link QrCodeOptions} object using the set fields.
         * @return {@link QrCodeOptions}
         */
        public QrCodeOptions build() {
            return new QrCodeOptions(title, body, barcodeContents);
        }
    }
}
