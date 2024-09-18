
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.ListCustomerSegmentsResponse;
import com.squareup.square.models.RetrieveCustomerSegmentResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultCustomerSegmentsApi extends BaseApi implements CustomerSegmentsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultCustomerSegmentsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Retrieves the list of customer segments of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by previous calls to
     *         `ListCustomerSegments`. This cursor is used to retrieve the next set of query
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. If the
     *         specified limit is less than 1 or greater than 50, Square returns a `400
     *         VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 50. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListCustomerSegmentsResponse listCustomerSegments(
            final String cursor,
            final Integer limit) throws ApiException, IOException {
        return prepareListCustomerSegmentsRequest(cursor, limit).execute();
    }

    /**
     * Retrieves the list of customer segments of a business.
     * @param  cursor  Optional parameter: A pagination cursor returned by previous calls to
     *         `ListCustomerSegments`. This cursor is used to retrieve the next set of query
     *         results. For more information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @param  limit  Optional parameter: The maximum number of results to return in a single page.
     *         This limit is advisory. The response might contain more or fewer results. If the
     *         specified limit is less than 1 or greater than 50, Square returns a `400
     *         VALUE_TOO_LOW` or `400 VALUE_TOO_HIGH` error. The default value is 50. For more
     *         information, see
     *         [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return    Returns the ListCustomerSegmentsResponse response from the API call
     */
    public CompletableFuture<ListCustomerSegmentsResponse> listCustomerSegmentsAsync(
            final String cursor,
            final Integer limit) {
        try { 
            return prepareListCustomerSegmentsRequest(cursor, limit).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listCustomerSegments.
     */
    private ApiCall<ListCustomerSegmentsResponse, ApiException> prepareListCustomerSegmentsRequest(
            final String cursor,
            final Integer limit) throws IOException {
        return new ApiCall.Builder<ListCustomerSegmentsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/segments")
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListCustomerSegmentsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param  segmentId  Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveCustomerSegmentResponse retrieveCustomerSegment(
            final String segmentId) throws ApiException, IOException {
        return prepareRetrieveCustomerSegmentRequest(segmentId).execute();
    }

    /**
     * Retrieves a specific customer segment as identified by the `segment_id` value.
     * @param  segmentId  Required parameter: The Square-issued ID of the customer segment.
     * @return    Returns the RetrieveCustomerSegmentResponse response from the API call
     */
    public CompletableFuture<RetrieveCustomerSegmentResponse> retrieveCustomerSegmentAsync(
            final String segmentId) {
        try { 
            return prepareRetrieveCustomerSegmentRequest(segmentId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveCustomerSegment.
     */
    private ApiCall<RetrieveCustomerSegmentResponse, ApiException> prepareRetrieveCustomerSegmentRequest(
            final String segmentId) throws IOException {
        return new ApiCall.Builder<RetrieveCustomerSegmentResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/customers/segments/{segment_id}")
                        .templateParam(param -> param.key("segment_id").value(segmentId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveCustomerSegmentResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}