
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
 * This is a model class for RetrieveInventoryTransferResponse type.
 */
public class RetrieveInventoryTransferResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final InventoryTransfer transfer;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  transfer  InventoryTransfer value for transfer.
     */
    @JsonCreator
    public RetrieveInventoryTransferResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("transfer") InventoryTransfer transfer) {
        this.errors = errors;
        this.transfer = transfer;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Transfer.
     * Represents the transfer of a quantity of product inventory at a particular time from one
     * location to another.
     * @return Returns the InventoryTransfer
     */
    @JsonGetter("transfer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public InventoryTransfer getTransfer() {
        return transfer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, transfer);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveInventoryTransferResponse)) {
            return false;
        }
        RetrieveInventoryTransferResponse other = (RetrieveInventoryTransferResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(transfer, other.transfer);
    }

    /**
     * Converts this RetrieveInventoryTransferResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveInventoryTransferResponse [" + "errors=" + errors + ", transfer=" + transfer
                + "]";
    }

    /**
     * Builds a new {@link RetrieveInventoryTransferResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveInventoryTransferResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .transfer(getTransfer());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveInventoryTransferResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private InventoryTransfer transfer;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for transfer.
         * @param  transfer  InventoryTransfer value for transfer.
         * @return Builder
         */
        public Builder transfer(InventoryTransfer transfer) {
            this.transfer = transfer;
            return this;
        }

        /**
         * Builds a new {@link RetrieveInventoryTransferResponse} object using the set fields.
         * @return {@link RetrieveInventoryTransferResponse}
         */
        public RetrieveInventoryTransferResponse build() {
            RetrieveInventoryTransferResponse model =
                    new RetrieveInventoryTransferResponse(errors, transfer);
            model.httpContext = httpContext;
            return model;
        }
    }
}
