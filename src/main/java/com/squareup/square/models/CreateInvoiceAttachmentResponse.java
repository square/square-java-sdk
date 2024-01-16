
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateInvoiceAttachmentResponse type.
 */
public class CreateInvoiceAttachmentResponse {
    private HttpContext httpContext;
    private final InvoiceAttachment attachment;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  attachment  InvoiceAttachment value for attachment.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public CreateInvoiceAttachmentResponse(
            @JsonProperty("attachment") InvoiceAttachment attachment,
            @JsonProperty("errors") List<Error> errors) {
        this.attachment = attachment;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Attachment.
     * Represents a file attached to an [invoice]($m/Invoice).
     * @return Returns the InvoiceAttachment
     */
    @JsonGetter("attachment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InvoiceAttachment getAttachment() {
        return attachment;
    }

    /**
     * Getter for Errors.
     * Information about errors encountered during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachment, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateInvoiceAttachmentResponse)) {
            return false;
        }
        CreateInvoiceAttachmentResponse other = (CreateInvoiceAttachmentResponse) obj;
        return Objects.equals(attachment, other.attachment)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this CreateInvoiceAttachmentResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateInvoiceAttachmentResponse [" + "attachment=" + attachment + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link CreateInvoiceAttachmentResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateInvoiceAttachmentResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .attachment(getAttachment())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateInvoiceAttachmentResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private InvoiceAttachment attachment;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for attachment.
         * @param  attachment  InvoiceAttachment value for attachment.
         * @return Builder
         */
        public Builder attachment(InvoiceAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link CreateInvoiceAttachmentResponse} object using the set fields.
         * @return {@link CreateInvoiceAttachmentResponse}
         */
        public CreateInvoiceAttachmentResponse build() {
            CreateInvoiceAttachmentResponse model =
                    new CreateInvoiceAttachmentResponse(attachment, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
