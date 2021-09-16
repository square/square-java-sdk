
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.ListCustomerSegmentsResponse;
import com.squareup.square.models.RetrieveCustomerSegmentResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface CustomerSegmentsApi {
    /**
     * Retrieves the list of customer segments of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by previous calls to
     *         `ListCustomerSegments`. This cursor is used to retrieve the next set of query
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. The limit
     *         is ignored if it is less than 1 or greater than 50. The default value is 50. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListCustomerSegmentsResponse listCustomerSegments(
            final String cursor,
            final Integer limit) throws ApiException, IOException;

    /**
     * Retrieves the list of customer segments of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by previous calls to
     *         `ListCustomerSegments`. This cursor is used to retrieve the next set of query
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. The limit
     *         is ignored if it is less than 1 or greater than 50. The default value is 50. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/working-with-apis/pagination).
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     */
    CompletableFuture<ListCustomerSegmentsResponse> listCustomerSegmentsAsync(
            final String cursor,
            final Integer limit);

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param  segmentId  Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveCustomerSegmentResponse retrieveCustomerSegment(
            final String segmentId) throws ApiException, IOException;

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param  segmentId  Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     */
    CompletableFuture<RetrieveCustomerSegmentResponse> retrieveCustomerSegmentAsync(
            final String segmentId);

}