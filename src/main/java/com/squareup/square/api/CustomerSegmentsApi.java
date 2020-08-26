package com.squareup.square.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListCustomerSegmentsResponse;
import com.squareup.square.models.RetrieveCustomerSegmentResponse;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomerSegmentsApi {
    /**
     * Retrieves the list of customer segments of a business.
     * @param    cursor    Optional parameter: A pagination cursor returned by previous calls to __ListCustomerSegments__. Used to retrieve the next set of query results.  See the [Pagination guide](https://developer.squareup.com/docs/docs/working-with-apis/pagination) for more information.
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     */
    ListCustomerSegmentsResponse listCustomerSegments(
            final String cursor) throws ApiException, IOException;

    /**
     * Retrieves the list of customer segments of a business.
     * @param    cursor    Optional parameter: A pagination cursor returned by previous calls to __ListCustomerSegments__. Used to retrieve the next set of query results.  See the [Pagination guide](https://developer.squareup.com/docs/docs/working-with-apis/pagination) for more information.
     * @return    Returns the ListCustomerSegmentsResponse response from the API call 
     */
    CompletableFuture<ListCustomerSegmentsResponse> listCustomerSegmentsAsync(
            final String cursor);

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param    segmentId    Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     */
    RetrieveCustomerSegmentResponse retrieveCustomerSegment(
            final String segmentId) throws ApiException, IOException;

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param    segmentId    Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call 
     */
    CompletableFuture<RetrieveCustomerSegmentResponse> retrieveCustomerSegmentAsync(
            final String segmentId);

}