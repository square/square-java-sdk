package com.squareup.square.legacy.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.legacy.ApiHelper;
import com.squareup.square.legacy.Server;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.http.client.HttpContext;
import com.squareup.square.legacy.http.request.HttpMethod;
import com.squareup.square.legacy.models.CreateBreakTypeRequest;
import com.squareup.square.legacy.models.CreateBreakTypeResponse;
import com.squareup.square.legacy.models.CreateShiftRequest;
import com.squareup.square.legacy.models.CreateShiftResponse;
import com.squareup.square.legacy.models.DeleteBreakTypeResponse;
import com.squareup.square.legacy.models.DeleteShiftResponse;
import com.squareup.square.legacy.models.GetBreakTypeResponse;
import com.squareup.square.legacy.models.GetEmployeeWageResponse;
import com.squareup.square.legacy.models.GetShiftResponse;
import com.squareup.square.legacy.models.GetTeamMemberWageResponse;
import com.squareup.square.legacy.models.ListBreakTypesResponse;
import com.squareup.square.legacy.models.ListEmployeeWagesResponse;
import com.squareup.square.legacy.models.ListTeamMemberWagesResponse;
import com.squareup.square.legacy.models.ListWorkweekConfigsResponse;
import com.squareup.square.legacy.models.SearchShiftsRequest;
import com.squareup.square.legacy.models.SearchShiftsResponse;
import com.squareup.square.legacy.models.UpdateBreakTypeRequest;
import com.squareup.square.legacy.models.UpdateBreakTypeResponse;
import com.squareup.square.legacy.models.UpdateShiftRequest;
import com.squareup.square.legacy.models.UpdateShiftResponse;
import com.squareup.square.legacy.models.UpdateWorkweekConfigRequest;
import com.squareup.square.legacy.models.UpdateWorkweekConfigResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultLaborApi extends BaseApi implements LaborApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultLaborApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Returns a paginated list of `BreakType` instances for a business.
     * @param  locationId  Optional parameter: Filter the returned `BreakType` results to only those
     *         that are associated with the specified location.
     * @param  limit  Optional parameter: The maximum number of `BreakType` results to return per
     *         page. The number can range between 1 and 200. The default is 200.
     * @param  cursor  Optional parameter: A pointer to the next page of `BreakType` results to
     *         fetch.
     * @return    Returns the ListBreakTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListBreakTypesResponse listBreakTypes(final String locationId, final Integer limit, final String cursor)
            throws ApiException, IOException {
        return prepareListBreakTypesRequest(locationId, limit, cursor).execute();
    }

    /**
     * Returns a paginated list of `BreakType` instances for a business.
     * @param  locationId  Optional parameter: Filter the returned `BreakType` results to only those
     *         that are associated with the specified location.
     * @param  limit  Optional parameter: The maximum number of `BreakType` results to return per
     *         page. The number can range between 1 and 200. The default is 200.
     * @param  cursor  Optional parameter: A pointer to the next page of `BreakType` results to
     *         fetch.
     * @return    Returns the ListBreakTypesResponse response from the API call
     */
    public CompletableFuture<ListBreakTypesResponse> listBreakTypesAsync(
            final String locationId, final Integer limit, final String cursor) {
        try {
            return prepareListBreakTypesRequest(locationId, limit, cursor).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listBreakTypes.
     */
    private ApiCall<ListBreakTypesResponse, ApiException> prepareListBreakTypesRequest(
            final String locationId, final Integer limit, final String cursor) throws IOException {
        return new ApiCall.Builder<ListBreakTypesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/break-types")
                        .queryParam(param ->
                                param.key("location_id").value(locationId).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListBreakTypesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a new `BreakType`. A `BreakType` is a template for creating `Break` objects. You must
     * provide the following values in your request to this endpoint: - `location_id` - `break_name`
     * - `expected_duration` - `is_paid` You can only have three `BreakType` instances per location.
     * If you attempt to add a fourth `BreakType` for a location, an `INVALID_REQUEST_ERROR`
     * "Exceeded limit of 3 breaks per location." is returned.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateBreakTypeResponse createBreakType(final CreateBreakTypeRequest body) throws ApiException, IOException {
        return prepareCreateBreakTypeRequest(body).execute();
    }

    /**
     * Creates a new `BreakType`. A `BreakType` is a template for creating `Break` objects. You must
     * provide the following values in your request to this endpoint: - `location_id` - `break_name`
     * - `expected_duration` - `is_paid` You can only have three `BreakType` instances per location.
     * If you attempt to add a fourth `BreakType` for a location, an `INVALID_REQUEST_ERROR`
     * "Exceeded limit of 3 breaks per location." is returned.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBreakTypeResponse response from the API call
     */
    public CompletableFuture<CreateBreakTypeResponse> createBreakTypeAsync(final CreateBreakTypeRequest body) {
        try {
            return prepareCreateBreakTypeRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for createBreakType.
     */
    private ApiCall<CreateBreakTypeResponse, ApiException> prepareCreateBreakTypeRequest(
            final CreateBreakTypeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateBreakTypeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/break-types")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, CreateBreakTypeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes an existing `BreakType`. A `BreakType` can be deleted even if it is referenced from a
     * `Shift`.
     * @param  id  Required parameter: The UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteBreakTypeResponse deleteBreakType(final String id) throws ApiException, IOException {
        return prepareDeleteBreakTypeRequest(id).execute();
    }

    /**
     * Deletes an existing `BreakType`. A `BreakType` can be deleted even if it is referenced from a
     * `Shift`.
     * @param  id  Required parameter: The UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     */
    public CompletableFuture<DeleteBreakTypeResponse> deleteBreakTypeAsync(final String id) {
        try {
            return prepareDeleteBreakTypeRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for deleteBreakType.
     */
    private ApiCall<DeleteBreakTypeResponse, ApiException> prepareDeleteBreakTypeRequest(final String id)
            throws IOException {
        return new ApiCall.Builder<DeleteBreakTypeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/break-types/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, DeleteBreakTypeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a single `BreakType` specified by `id`.
     * @param  id  Required parameter: The UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetBreakTypeResponse getBreakType(final String id) throws ApiException, IOException {
        return prepareGetBreakTypeRequest(id).execute();
    }

    /**
     * Returns a single `BreakType` specified by `id`.
     * @param  id  Required parameter: The UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     */
    public CompletableFuture<GetBreakTypeResponse> getBreakTypeAsync(final String id) {
        try {
            return prepareGetBreakTypeRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for getBreakType.
     */
    private ApiCall<GetBreakTypeResponse, ApiException> prepareGetBreakTypeRequest(final String id) throws IOException {
        return new ApiCall.Builder<GetBreakTypeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/break-types/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, GetBreakTypeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates an existing `BreakType`.
     * @param  id  Required parameter: The UUID for the `BreakType` being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateBreakTypeResponse updateBreakType(final String id, final UpdateBreakTypeRequest body)
            throws ApiException, IOException {
        return prepareUpdateBreakTypeRequest(id, body).execute();
    }

    /**
     * Updates an existing `BreakType`.
     * @param  id  Required parameter: The UUID for the `BreakType` being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     */
    public CompletableFuture<UpdateBreakTypeResponse> updateBreakTypeAsync(
            final String id, final UpdateBreakTypeRequest body) {
        try {
            return prepareUpdateBreakTypeRequest(id, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for updateBreakType.
     */
    private ApiCall<UpdateBreakTypeResponse, ApiException> prepareUpdateBreakTypeRequest(
            final String id, final UpdateBreakTypeRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateBreakTypeResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/break-types/{id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, UpdateBreakTypeResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a paginated list of `EmployeeWage` instances for a business.
     * @deprecated
     *
     * @param  employeeId  Optional parameter: Filter the returned wages to only those that are
     *         associated with the specified employee.
     * @param  limit  Optional parameter: The maximum number of `EmployeeWage` results to return per
     *         page. The number can range between 1 and 200. The default is 200.
     * @param  cursor  Optional parameter: A pointer to the next page of `EmployeeWage` results to
     *         fetch.
     * @return    Returns the ListEmployeeWagesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public ListEmployeeWagesResponse listEmployeeWages(
            final String employeeId, final Integer limit, final String cursor) throws ApiException, IOException {
        return prepareListEmployeeWagesRequest(employeeId, limit, cursor).execute();
    }

    /**
     * Returns a paginated list of `EmployeeWage` instances for a business.
     * @deprecated
     *
     * @param  employeeId  Optional parameter: Filter the returned wages to only those that are
     *         associated with the specified employee.
     * @param  limit  Optional parameter: The maximum number of `EmployeeWage` results to return per
     *         page. The number can range between 1 and 200. The default is 200.
     * @param  cursor  Optional parameter: A pointer to the next page of `EmployeeWage` results to
     *         fetch.
     * @return    Returns the ListEmployeeWagesResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<ListEmployeeWagesResponse> listEmployeeWagesAsync(
            final String employeeId, final Integer limit, final String cursor) {
        try {
            return prepareListEmployeeWagesRequest(employeeId, limit, cursor).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listEmployeeWages.
     */
    private ApiCall<ListEmployeeWagesResponse, ApiException> prepareListEmployeeWagesRequest(
            final String employeeId, final Integer limit, final String cursor) throws IOException {
        return new ApiCall.Builder<ListEmployeeWagesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/employee-wages")
                        .queryParam(param ->
                                param.key("employee_id").value(employeeId).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListEmployeeWagesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a single `EmployeeWage` specified by `id`.
     * @deprecated
     *
     * @param  id  Required parameter: The UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated
    public GetEmployeeWageResponse getEmployeeWage(final String id) throws ApiException, IOException {
        return prepareGetEmployeeWageRequest(id).execute();
    }

    /**
     * Returns a single `EmployeeWage` specified by `id`.
     * @deprecated
     *
     * @param  id  Required parameter: The UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     */
    @Deprecated
    public CompletableFuture<GetEmployeeWageResponse> getEmployeeWageAsync(final String id) {
        try {
            return prepareGetEmployeeWageRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for getEmployeeWage.
     */
    private ApiCall<GetEmployeeWageResponse, ApiException> prepareGetEmployeeWageRequest(final String id)
            throws IOException {
        return new ApiCall.Builder<GetEmployeeWageResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/employee-wages/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, GetEmployeeWageResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates a new `Shift`. A `Shift` represents a complete workday for a single team member. You
     * must provide the following values in your request to this endpoint: - `location_id` -
     * `team_member_id` - `start_at` An attempt to create a new `Shift` can result in a
     * `BAD_REQUEST` error when: - The `status` of the new `Shift` is `OPEN` and the team member has
     * another shift with an `OPEN` status. - The `start_at` date is in the future. - The `start_at`
     * or `end_at` date overlaps another shift for the same team member. - The `Break` instances are
     * set in the request and a break `start_at` is before the `Shift.start_at`, a break `end_at` is
     * after the `Shift.end_at`, or both.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateShiftResponse createShift(final CreateShiftRequest body) throws ApiException, IOException {
        return prepareCreateShiftRequest(body).execute();
    }

    /**
     * Creates a new `Shift`. A `Shift` represents a complete workday for a single team member. You
     * must provide the following values in your request to this endpoint: - `location_id` -
     * `team_member_id` - `start_at` An attempt to create a new `Shift` can result in a
     * `BAD_REQUEST` error when: - The `status` of the new `Shift` is `OPEN` and the team member has
     * another shift with an `OPEN` status. - The `start_at` date is in the future. - The `start_at`
     * or `end_at` date overlaps another shift for the same team member. - The `Break` instances are
     * set in the request and a break `start_at` is before the `Shift.start_at`, a break `end_at` is
     * after the `Shift.end_at`, or both.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateShiftResponse response from the API call
     */
    public CompletableFuture<CreateShiftResponse> createShiftAsync(final CreateShiftRequest body) {
        try {
            return prepareCreateShiftRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for createShift.
     */
    private ApiCall<CreateShiftResponse, ApiException> prepareCreateShiftRequest(final CreateShiftRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateShiftResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/shifts")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, CreateShiftResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a paginated list of `Shift` records for a business. The list to be returned can be
     * filtered by: - Location IDs - Team member IDs - Shift status (`OPEN` or `CLOSED`) - Shift
     * start - Shift end - Workday details The list can be sorted by: - `START_AT` - `END_AT` -
     * `CREATED_AT` - `UPDATED_AT`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchShiftsResponse searchShifts(final SearchShiftsRequest body) throws ApiException, IOException {
        return prepareSearchShiftsRequest(body).execute();
    }

    /**
     * Returns a paginated list of `Shift` records for a business. The list to be returned can be
     * filtered by: - Location IDs - Team member IDs - Shift status (`OPEN` or `CLOSED`) - Shift
     * start - Shift end - Workday details The list can be sorted by: - `START_AT` - `END_AT` -
     * `CREATED_AT` - `UPDATED_AT`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call
     */
    public CompletableFuture<SearchShiftsResponse> searchShiftsAsync(final SearchShiftsRequest body) {
        try {
            return prepareSearchShiftsRequest(body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for searchShifts.
     */
    private ApiCall<SearchShiftsResponse, ApiException> prepareSearchShiftsRequest(final SearchShiftsRequest body)
            throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchShiftsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/shifts/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, SearchShiftsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Deletes a `Shift`.
     * @param  id  Required parameter: The UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public DeleteShiftResponse deleteShift(final String id) throws ApiException, IOException {
        return prepareDeleteShiftRequest(id).execute();
    }

    /**
     * Deletes a `Shift`.
     * @param  id  Required parameter: The UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     */
    public CompletableFuture<DeleteShiftResponse> deleteShiftAsync(final String id) {
        try {
            return prepareDeleteShiftRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for deleteShift.
     */
    private ApiCall<DeleteShiftResponse, ApiException> prepareDeleteShiftRequest(final String id) throws IOException {
        return new ApiCall.Builder<DeleteShiftResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/shifts/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.DELETE))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, DeleteShiftResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a single `Shift` specified by `id`.
     * @param  id  Required parameter: The UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetShiftResponse getShift(final String id) throws ApiException, IOException {
        return prepareGetShiftRequest(id).execute();
    }

    /**
     * Returns a single `Shift` specified by `id`.
     * @param  id  Required parameter: The UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     */
    public CompletableFuture<GetShiftResponse> getShiftAsync(final String id) {
        try {
            return prepareGetShiftRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for getShift.
     */
    private ApiCall<GetShiftResponse, ApiException> prepareGetShiftRequest(final String id) throws IOException {
        return new ApiCall.Builder<GetShiftResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/shifts/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, GetShiftResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates an existing `Shift`. When adding a `Break` to a `Shift`, any earlier `Break`
     * instances in the `Shift` have the `end_at` property set to a valid RFC-3339 datetime string.
     * When closing a `Shift`, all `Break` instances in the `Shift` must be complete with `end_at`
     * set on each `Break`.
     * @param  id  Required parameter: The ID of the object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateShiftResponse updateShift(final String id, final UpdateShiftRequest body)
            throws ApiException, IOException {
        return prepareUpdateShiftRequest(id, body).execute();
    }

    /**
     * Updates an existing `Shift`. When adding a `Break` to a `Shift`, any earlier `Break`
     * instances in the `Shift` have the `end_at` property set to a valid RFC-3339 datetime string.
     * When closing a `Shift`, all `Break` instances in the `Shift` must be complete with `end_at`
     * set on each `Break`.
     * @param  id  Required parameter: The ID of the object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateShiftResponse response from the API call
     */
    public CompletableFuture<UpdateShiftResponse> updateShiftAsync(final String id, final UpdateShiftRequest body) {
        try {
            return prepareUpdateShiftRequest(id, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for updateShift.
     */
    private ApiCall<UpdateShiftResponse, ApiException> prepareUpdateShiftRequest(
            final String id, final UpdateShiftRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateShiftResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/shifts/{id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, UpdateShiftResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a paginated list of `TeamMemberWage` instances for a business.
     * @param  teamMemberId  Optional parameter: Filter the returned wages to only those that are
     *         associated with the specified team member.
     * @param  limit  Optional parameter: The maximum number of `TeamMemberWage` results to return
     *         per page. The number can range between 1 and 200. The default is 200.
     * @param  cursor  Optional parameter: A pointer to the next page of `EmployeeWage` results to
     *         fetch.
     * @return    Returns the ListTeamMemberWagesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListTeamMemberWagesResponse listTeamMemberWages(
            final String teamMemberId, final Integer limit, final String cursor) throws ApiException, IOException {
        return prepareListTeamMemberWagesRequest(teamMemberId, limit, cursor).execute();
    }

    /**
     * Returns a paginated list of `TeamMemberWage` instances for a business.
     * @param  teamMemberId  Optional parameter: Filter the returned wages to only those that are
     *         associated with the specified team member.
     * @param  limit  Optional parameter: The maximum number of `TeamMemberWage` results to return
     *         per page. The number can range between 1 and 200. The default is 200.
     * @param  cursor  Optional parameter: A pointer to the next page of `EmployeeWage` results to
     *         fetch.
     * @return    Returns the ListTeamMemberWagesResponse response from the API call
     */
    public CompletableFuture<ListTeamMemberWagesResponse> listTeamMemberWagesAsync(
            final String teamMemberId, final Integer limit, final String cursor) {
        try {
            return prepareListTeamMemberWagesRequest(teamMemberId, limit, cursor)
                    .executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listTeamMemberWages.
     */
    private ApiCall<ListTeamMemberWagesResponse, ApiException> prepareListTeamMemberWagesRequest(
            final String teamMemberId, final Integer limit, final String cursor) throws IOException {
        return new ApiCall.Builder<ListTeamMemberWagesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/team-member-wages")
                        .queryParam(param ->
                                param.key("team_member_id").value(teamMemberId).isRequired(false))
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListTeamMemberWagesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a single `TeamMemberWage` specified by `id`.
     * @param  id  Required parameter: The UUID for the `TeamMemberWage` being retrieved.
     * @return    Returns the GetTeamMemberWageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public GetTeamMemberWageResponse getTeamMemberWage(final String id) throws ApiException, IOException {
        return prepareGetTeamMemberWageRequest(id).execute();
    }

    /**
     * Returns a single `TeamMemberWage` specified by `id`.
     * @param  id  Required parameter: The UUID for the `TeamMemberWage` being retrieved.
     * @return    Returns the GetTeamMemberWageResponse response from the API call
     */
    public CompletableFuture<GetTeamMemberWageResponse> getTeamMemberWageAsync(final String id) {
        try {
            return prepareGetTeamMemberWageRequest(id).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for getTeamMemberWage.
     */
    private ApiCall<GetTeamMemberWageResponse, ApiException> prepareGetTeamMemberWageRequest(final String id)
            throws IOException {
        return new ApiCall.Builder<GetTeamMemberWageResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/team-member-wages/{id}")
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, GetTeamMemberWageResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param  limit  Optional parameter: The maximum number of `WorkweekConfigs` results to return
     *         per page.
     * @param  cursor  Optional parameter: A pointer to the next page of `WorkweekConfig` results to
     *         fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListWorkweekConfigsResponse listWorkweekConfigs(final Integer limit, final String cursor)
            throws ApiException, IOException {
        return prepareListWorkweekConfigsRequest(limit, cursor).execute();
    }

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param  limit  Optional parameter: The maximum number of `WorkweekConfigs` results to return
     *         per page.
     * @param  cursor  Optional parameter: A pointer to the next page of `WorkweekConfig` results to
     *         fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     */
    public CompletableFuture<ListWorkweekConfigsResponse> listWorkweekConfigsAsync(
            final Integer limit, final String cursor) {
        try {
            return prepareListWorkweekConfigsRequest(limit, cursor).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for listWorkweekConfigs.
     */
    private ApiCall<ListWorkweekConfigsResponse, ApiException> prepareListWorkweekConfigsRequest(
            final Integer limit, final String cursor) throws IOException {
        return new ApiCall.Builder<ListWorkweekConfigsResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/workweek-configs")
                        .queryParam(param -> param.key("limit").value(limit).isRequired(false))
                        .queryParam(param -> param.key("cursor").value(cursor).isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, ListWorkweekConfigsResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a `WorkweekConfig`.
     * @param  id  Required parameter: The UUID for the `WorkweekConfig` object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateWorkweekConfigResponse updateWorkweekConfig(final String id, final UpdateWorkweekConfigRequest body)
            throws ApiException, IOException {
        return prepareUpdateWorkweekConfigRequest(id, body).execute();
    }

    /**
     * Updates a `WorkweekConfig`.
     * @param  id  Required parameter: The UUID for the `WorkweekConfig` object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     */
    public CompletableFuture<UpdateWorkweekConfigResponse> updateWorkweekConfigAsync(
            final String id, final UpdateWorkweekConfigRequest body) {
        try {
            return prepareUpdateWorkweekConfigRequest(id, body).executeAsync();
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }

    /**
     * Builds the ApiCall object for updateWorkweekConfig.
     */
    private ApiCall<UpdateWorkweekConfigResponse, ApiException> prepareUpdateWorkweekConfigRequest(
            final String id, final UpdateWorkweekConfigRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateWorkweekConfigResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/labor/workweek-configs/{id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() -> ApiHelper.serialize(body))
                        .templateParam(param -> param.key("id").value(id).shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json")
                                .isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth.add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(response -> ApiHelper.deserialize(response, UpdateWorkweekConfigResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) -> result.toBuilder()
                                .httpContext((HttpContext) context)
                                .build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}
