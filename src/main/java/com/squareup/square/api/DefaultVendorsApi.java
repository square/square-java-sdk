
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultVendorsApi extends BaseApi implements VendorsApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultVendorsApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Creates one or more [Vendor]($m/Vendor) objects to represent suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkCreateVendorsResponse bulkCreateVendors(
            final BulkCreateVendorsRequest body) throws ApiException, IOException {
        return prepareBulkCreateVendorsRequest(body).execute();
    }

    /**
     * Creates one or more [Vendor]($m/Vendor) objects to represent suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateVendorsResponse response from the API call
     */
    public CompletableFuture<BulkCreateVendorsResponse> bulkCreateVendorsAsync(
            final BulkCreateVendorsRequest body) {
        try { 
            return prepareBulkCreateVendorsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkCreateVendors.
     */
    private ApiCall<BulkCreateVendorsResponse, ApiException> prepareBulkCreateVendorsRequest(
            final BulkCreateVendorsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkCreateVendorsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/bulk-create")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkCreateVendorsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves one or more vendors of specified [Vendor]($m/Vendor) IDs.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkRetrieveVendorsResponse bulkRetrieveVendors(
            final BulkRetrieveVendorsRequest body) throws ApiException, IOException {
        return prepareBulkRetrieveVendorsRequest(body).execute();
    }

    /**
     * Retrieves one or more vendors of specified [Vendor]($m/Vendor) IDs.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkRetrieveVendorsResponse response from the API call
     */
    public CompletableFuture<BulkRetrieveVendorsResponse> bulkRetrieveVendorsAsync(
            final BulkRetrieveVendorsRequest body) {
        try { 
            return prepareBulkRetrieveVendorsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkRetrieveVendors.
     */
    private ApiCall<BulkRetrieveVendorsResponse, ApiException> prepareBulkRetrieveVendorsRequest(
            final BulkRetrieveVendorsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkRetrieveVendorsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/bulk-retrieve")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkRetrieveVendorsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates one or more of existing [Vendor]($m/Vendor) objects as suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpdateVendorsResponse bulkUpdateVendors(
            final BulkUpdateVendorsRequest body) throws ApiException, IOException {
        return prepareBulkUpdateVendorsRequest(body).execute();
    }

    /**
     * Updates one or more of existing [Vendor]($m/Vendor) objects as suppliers to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateVendorsResponse response from the API call
     */
    public CompletableFuture<BulkUpdateVendorsResponse> bulkUpdateVendorsAsync(
            final BulkUpdateVendorsRequest body) {
        try { 
            return prepareBulkUpdateVendorsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkUpdateVendors.
     */
    private ApiCall<BulkUpdateVendorsResponse, ApiException> prepareBulkUpdateVendorsRequest(
            final BulkUpdateVendorsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpdateVendorsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/bulk-update")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkUpdateVendorsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a single [Vendor]($m/Vendor) object to represent a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateVendorResponse createVendor(
            final CreateVendorRequest body) throws ApiException, IOException {
        return prepareCreateVendorRequest(body).execute();
    }

    /**
     * Creates a single [Vendor]($m/Vendor) object to represent a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateVendorResponse response from the API call
     */
    public CompletableFuture<CreateVendorResponse> createVendorAsync(
            final CreateVendorRequest body) {
        try { 
            return prepareCreateVendorRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createVendor.
     */
    private ApiCall<CreateVendorResponse, ApiException> prepareCreateVendorRequest(
            final CreateVendorRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateVendorResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/create")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateVendorResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Searches for vendors using a filter against supported [Vendor]($m/Vendor) properties and a
     * supported sorter.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchVendorsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchVendorsResponse searchVendors(
            final SearchVendorsRequest body) throws ApiException, IOException {
        return prepareSearchVendorsRequest(body).execute();
    }

    /**
     * Searches for vendors using a filter against supported [Vendor]($m/Vendor) properties and a
     * supported sorter.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchVendorsResponse response from the API call
     */
    public CompletableFuture<SearchVendorsResponse> searchVendorsAsync(
            final SearchVendorsRequest body) {
        try { 
            return prepareSearchVendorsRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchVendors.
     */
    private ApiCall<SearchVendorsResponse, ApiException> prepareSearchVendorsRequest(
            final SearchVendorsRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchVendorsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchVendorsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves the vendor of a specified [Vendor]($m/Vendor) ID.
     * @param  vendorId  Required parameter: ID of the [Vendor]($m/Vendor) to retrieve.
     * @return    Returns the RetrieveVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveVendorResponse retrieveVendor(
            final String vendorId) throws ApiException, IOException {
        return prepareRetrieveVendorRequest(vendorId).execute();
    }

    /**
     * Retrieves the vendor of a specified [Vendor]($m/Vendor) ID.
     * @param  vendorId  Required parameter: ID of the [Vendor]($m/Vendor) to retrieve.
     * @return    Returns the RetrieveVendorResponse response from the API call
     */
    public CompletableFuture<RetrieveVendorResponse> retrieveVendorAsync(
            final String vendorId) {
        try { 
            return prepareRetrieveVendorRequest(vendorId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveVendor.
     */
    private ApiCall<RetrieveVendorResponse, ApiException> prepareRetrieveVendorRequest(
            final String vendorId) throws IOException {
        return new ApiCall.Builder<RetrieveVendorResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/{vendor_id}")
                        .templateParam(param -> param.key("vendor_id").value(vendorId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveVendorResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates an existing [Vendor]($m/Vendor) object as a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  vendorId  Required parameter: Example:
     * @return    Returns the UpdateVendorResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateVendorResponse updateVendor(
            final UpdateVendorRequest body,
            final String vendorId) throws ApiException, IOException {
        return prepareUpdateVendorRequest(body, vendorId).execute();
    }

    /**
     * Updates an existing [Vendor]($m/Vendor) object as a supplier to a seller.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @param  vendorId  Required parameter: Example:
     * @return    Returns the UpdateVendorResponse response from the API call
     */
    public CompletableFuture<UpdateVendorResponse> updateVendorAsync(
            final UpdateVendorRequest body,
            final String vendorId) {
        try { 
            return prepareUpdateVendorRequest(body, vendorId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateVendor.
     */
    private ApiCall<UpdateVendorResponse, ApiException> prepareUpdateVendorRequest(
            final UpdateVendorRequest body,
            final String vendorId) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateVendorResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/vendors/{vendor_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("vendor_id").value(vendorId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateVendorResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}