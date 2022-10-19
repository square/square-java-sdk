
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.ListEmployeesResponse;
import com.squareup.square.models.RetrieveEmployeeResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultEmployeesApi extends BaseApi implements EmployeesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultEmployeesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * ListEmployees.
     * @deprecated
     * 
     * @param  locationId  Optional parameter: Example:
     * @param  status  Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param  limit  Optional parameter: The number of employees to be returned on each page.
     * @param  cursor  Optional parameter: The token required to retrieve the specified page of
     *         results.
     * @return    Returns the ListEmployeesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListEmployeesResponse listEmployees(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) throws ApiException, IOException {
        return prepareListEmployeesRequest(locationId, status, limit, cursor).execute();
    }

    /**
     * ListEmployees.
     * @deprecated
     * 
     * @param  locationId  Optional parameter: Example:
     * @param  status  Optional parameter: Specifies the EmployeeStatus to filter the employee by.
     * @param  limit  Optional parameter: The number of employees to be returned on each page.
     * @param  cursor  Optional parameter: The token required to retrieve the specified page of
     *         results.
     * @return    Returns the ListEmployeesResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListEmployeesResponse> listEmployeesAsync(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) {
        try { 
            return prepareListEmployeesRequest(locationId, status, limit, cursor).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listEmployees.
     */
    private ApiCall<ListEmployeesResponse, ApiException> prepareListEmployeesRequest(
            final String locationId,
            final String status,
            final Integer limit,
            final String cursor) throws IOException {
        return new ApiCall.Builder<ListEmployeesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/employees")
                        .queryParam(param -> param.key("location_id")
                                .value(locationId).isRequired(false))
                        .queryParam(param -> param.key("status")
                                .value(status).isRequired(false))
                        .queryParam(param -> param.key("limit")
                                .value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor")
                                .value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListEmployeesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * RetrieveEmployee.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public RetrieveEmployeeResponse retrieveEmployee(
            final String id) throws ApiException, IOException {
        return prepareRetrieveEmployeeRequest(id).execute();
    }

    /**
     * RetrieveEmployee.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the employee that was requested.
     * @return    Returns the RetrieveEmployeeResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<RetrieveEmployeeResponse> retrieveEmployeeAsync(
            final String id) {
        try { 
            return prepareRetrieveEmployeeRequest(id).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveEmployee.
     */
    private ApiCall<RetrieveEmployeeResponse, ApiException> prepareRetrieveEmployeeRequest(
            final String id) throws IOException {
        return new ApiCall.Builder<RetrieveEmployeeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/employees/{id}")
                        .templateParam(param -> param.key("id").value(id)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveEmployeeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}