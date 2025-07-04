/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.squareup.square.core.ObjectMappers;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateInvoiceAttachmentRequest.Builder.class)
public final class CreateInvoiceAttachmentRequest {
    private final Optional<File> imageFile;

    private final String invoiceId;

    private final Optional<CreateInvoiceAttachmentRequestData> request;

    private final Map<String, Object> additionalProperties;

    private CreateInvoiceAttachmentRequest(
            Optional<File> imageFile,
            String invoiceId,
            Optional<CreateInvoiceAttachmentRequestData> request,
            Map<String, Object> additionalProperties) {
        this.imageFile = imageFile;
        this.invoiceId = invoiceId;
        this.request = request;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("image_file")
    public Optional<File> getImageFile() {
        return imageFile;
    }

    /**
     * @return The ID of the <a href="entity:Invoice">invoice</a> to attach the file to.
     */
    @JsonProperty("invoice_id")
    public String getInvoiceId() {
        return invoiceId;
    }

    @JsonProperty("request")
    public Optional<CreateInvoiceAttachmentRequestData> getRequest() {
        return request;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateInvoiceAttachmentRequest && equalTo((CreateInvoiceAttachmentRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateInvoiceAttachmentRequest other) {
        return imageFile.equals(other.imageFile) && invoiceId.equals(other.invoiceId) && request.equals(other.request);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.imageFile, this.invoiceId, this.request);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static InvoiceIdStage builder() {
        return new Builder();
    }

    public interface InvoiceIdStage {
        /**
         * <p>The ID of the <a href="entity:Invoice">invoice</a> to attach the file to.</p>
         */
        _FinalStage invoiceId(@NotNull String invoiceId);

        Builder from(CreateInvoiceAttachmentRequest other);
    }

    public interface _FinalStage {
        CreateInvoiceAttachmentRequest build();

        _FinalStage imageFile(Optional<File> imageFile);

        _FinalStage imageFile(File imageFile);

        _FinalStage request(Optional<CreateInvoiceAttachmentRequestData> request);

        _FinalStage request(CreateInvoiceAttachmentRequestData request);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements InvoiceIdStage, _FinalStage {
        private String invoiceId;

        private Optional<CreateInvoiceAttachmentRequestData> request = Optional.empty();

        private Optional<File> imageFile = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateInvoiceAttachmentRequest other) {
            imageFile(other.getImageFile());
            invoiceId(other.getInvoiceId());
            request(other.getRequest());
            return this;
        }

        /**
         * <p>The ID of the <a href="entity:Invoice">invoice</a> to attach the file to.</p>
         * <p>The ID of the <a href="entity:Invoice">invoice</a> to attach the file to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("invoice_id")
        public _FinalStage invoiceId(@NotNull String invoiceId) {
            this.invoiceId = Objects.requireNonNull(invoiceId, "invoiceId must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage request(CreateInvoiceAttachmentRequestData request) {
            this.request = Optional.ofNullable(request);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "request", nulls = Nulls.SKIP)
        public _FinalStage request(Optional<CreateInvoiceAttachmentRequestData> request) {
            this.request = request;
            return this;
        }

        @java.lang.Override
        public _FinalStage imageFile(File imageFile) {
            this.imageFile = Optional.ofNullable(imageFile);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "image_file", nulls = Nulls.SKIP)
        public _FinalStage imageFile(Optional<File> imageFile) {
            this.imageFile = imageFile;
            return this;
        }

        @java.lang.Override
        public CreateInvoiceAttachmentRequest build() {
            return new CreateInvoiceAttachmentRequest(imageFile, invoiceId, request, additionalProperties);
        }
    }
}
