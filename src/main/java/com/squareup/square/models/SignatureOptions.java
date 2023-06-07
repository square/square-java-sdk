
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SignatureOptions type.
 */
public class SignatureOptions {
    private final String title;
    private final String body;
    private final List<SignatureImage> signature;

    /**
     * Initialization constructor.
     * @param  title  String value for title.
     * @param  body  String value for body.
     * @param  signature  List of SignatureImage value for signature.
     */
    @JsonCreator
    public SignatureOptions(
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("signature") List<SignatureImage> signature) {
        this.title = title;
        this.body = body;
        this.signature = signature;
    }

    /**
     * Getter for Title.
     * The title text to display in the signature capture flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("title")
    public String getTitle() {
        return title;
    }

    /**
     * Getter for Body.
     * The body text to display in the signature capture flow on the Terminal.
     * @return Returns the String
     */
    @JsonGetter("body")
    public String getBody() {
        return body;
    }

    /**
     * Getter for Signature.
     * An image representation of the collected signature.
     * @return Returns the List of SignatureImage
     */
    @JsonGetter("signature")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<SignatureImage> getSignature() {
        return signature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, signature);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignatureOptions)) {
            return false;
        }
        SignatureOptions other = (SignatureOptions) obj;
        return Objects.equals(title, other.title)
            && Objects.equals(body, other.body)
            && Objects.equals(signature, other.signature);
    }

    /**
     * Converts this SignatureOptions into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SignatureOptions [" + "title=" + title + ", body=" + body + ", signature="
                + signature + "]";
    }

    /**
     * Builds a new {@link SignatureOptions.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SignatureOptions.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(title, body)
                .signature(getSignature());
        return builder;
    }

    /**
     * Class to build instances of {@link SignatureOptions}.
     */
    public static class Builder {
        private String title;
        private String body;
        private List<SignatureImage> signature;

        /**
         * Initialization constructor.
         * @param  title  String value for title.
         * @param  body  String value for body.
         */
        public Builder(String title, String body) {
            this.title = title;
            this.body = body;
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
         * Setter for signature.
         * @param  signature  List of SignatureImage value for signature.
         * @return Builder
         */
        public Builder signature(List<SignatureImage> signature) {
            this.signature = signature;
            return this;
        }

        /**
         * Builds a new {@link SignatureOptions} object using the set fields.
         * @return {@link SignatureOptions}
         */
        public SignatureOptions build() {
            return new SignatureOptions(title, body, signature);
        }
    }
}
