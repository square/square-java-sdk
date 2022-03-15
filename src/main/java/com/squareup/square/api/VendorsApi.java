
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.BulkCreateVendorsRequest;
import com.squareup.square.models.BulkCreateVendorsResponse;
import com.squareup.square.models.BulkRetrieveVendorsRequest;
import com.squareup.square.models.BulkRetrieveVendorsResponse;
import com.squareup.square.models.BulkUpdateVendorsRequest;
import com.squareup.square.models.BulkUpdateVendorsResponse;
import com.squareup.square.models.CreateVendorRequest;
import com.squareup.square.models.CreateVendorResponse;
import com.squareup.square.models.RetrieveVendorResponse;
import com.squareup.square.models.SearchVendorsRequest;
import com.squareup.square.models.SearchVendorsResponse;
import com.squareup.square.models.UpdateVendorRequest;
import com.squareup.square.models.UpdateVendorResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface VendorsApi {
    /**
     * Creates one or more [Vendor]($m/Vendor) objects to represent suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkCreateVendorsResponse bulkCreateVendors(
            final BulkCreateVendorsRequest body) throws ApiException, IOException;

    /**
     * Creates one or more [Vendor]($m/Vendor) objects to represent suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateVendorsResponse response from the API call
     */
    CompletableFuture<BulkCreateVendorsResponse> bulkCreateVendorsAsync(
            final BulkCreateVendorsRequest body);

    /**
     * Retrieves one or more vendors of specified [Vendor]($m/Vendor) IDs.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkRetrieveVendorsResponse bulkRetrieveVendors(
            final BulkRetrieveVendorsRequest body) throws ApiException, IOException;

    /**
     * Retrieves one or more vendors of specified [Vendor]($m/Vendor) IDs.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveVendorsResponse response from the API call
     */
    CompletableFuture<BulkRetrieveVendorsResponse> bulkRetrieveVendorsAsync(
            final BulkRetrieveVendorsRequest body);

    /**
     * Updates one or more of existing [Vendor]($m/Vendor) objects as suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkUpdateVendorsResponse bulkUpdateVendors(
            final BulkUpdateVendorsRequest body) throws ApiException, IOException;

    /**
     * Updates one or more of existing [Vendor]($m/Vendor) objects as suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateVendorsResponse response from the API call
     */
    CompletableFuture<BulkUpdateVendorsResponse> bulkUpdateVendorsAsync(
            final BulkUpdateVendorsRequest body);

    /**
     * Creates a single [Vendor]($m/Vendor) object to represent a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateVendorResponse createVendor(
            final CreateVendorRequest body) throws ApiException, IOException;

    /**
     * Creates a single [Vendor]($m/Vendor) object to represent a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateVendorResponse response from the API call
     */
    CompletableFuture<CreateVendorResponse> createVendorAsync(
            final CreateVendorRequest body);

    /**
     * Searches for vendors using a filter against supported [Vendor]($m/Vendor) properties and a
     * supported sorter.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchVendorsResponse searchVendors(
            final SearchVendorsRequest body) throws ApiException, IOException;

    /**
     * Searches for vendors using a filter against supported [Vendor]($m/Vendor) properties and a
     * supported sorter.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchVendorsResponse response from the API call
     */
    CompletableFuture<SearchVendorsResponse> searchVendorsAsync(
            final SearchVendorsRequest body);

    /**
     * Retrieves the vendor of a specified [Vendor]($m/Vendor) ID.
     * @param  vendorId  Required parameter: ID of the [Vendor]($m/Vendor) to retrieve.
     * @return    Returns the RetrieveVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveVendorResponse retrieveVendor(
            final String vendorId) throws ApiException, IOException;

    /**
     * Retrieves the vendor of a specified [Vendor]($m/Vendor) ID.
     * @param  vendorId  Required parameter: ID of the [Vendor]($m/Vendor) to retrieve.
     * @return    Returns the RetrieveVendorResponse response from the API call
     */
    CompletableFuture<RetrieveVendorResponse> retrieveVendorAsync(
            final String vendorId);

    /**
     * Updates an existing [Vendor]($m/Vendor) object as a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  vendorId  Required parameter: Example:
     * @return    Returns the UpdateVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateVendorResponse updateVendor(
            final UpdateVendorRequest body,
            final String vendorId) throws ApiException, IOException;

    /**
     * Updates an existing [Vendor]($m/Vendor) object as a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  vendorId  Required parameter: Example:
     * @return    Returns the UpdateVendorResponse response from the API call
     */
    CompletableFuture<UpdateVendorResponse> updateVendorAsync(
            final UpdateVendorRequest body,
            final String vendorId);

}