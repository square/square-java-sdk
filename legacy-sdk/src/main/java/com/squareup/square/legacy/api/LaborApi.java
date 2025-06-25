package com.squareup.square.legacy.api;

import com.squareup.square.legacy.exceptions.ApiException;
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
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface LaborApi {
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
    ListBreakTypesResponse listBreakTypes(final String locationId, final Integer limit, final String cursor)
            throws ApiException, IOException;

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
    CompletableFuture<ListBreakTypesResponse> listBreakTypesAsync(
            final String locationId, final Integer limit, final String cursor);

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
    CreateBreakTypeResponse createBreakType(final CreateBreakTypeRequest body) throws ApiException, IOException;

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
    CompletableFuture<CreateBreakTypeResponse> createBreakTypeAsync(final CreateBreakTypeRequest body);

    /**
     * Deletes an existing `BreakType`. A `BreakType` can be deleted even if it is referenced from a
     * `Shift`.
     * @param  id  Required parameter: The UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteBreakTypeResponse deleteBreakType(final String id) throws ApiException, IOException;

    /**
     * Deletes an existing `BreakType`. A `BreakType` can be deleted even if it is referenced from a
     * `Shift`.
     * @param  id  Required parameter: The UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     */
    CompletableFuture<DeleteBreakTypeResponse> deleteBreakTypeAsync(final String id);

    /**
     * Returns a single `BreakType` specified by `id`.
     * @param  id  Required parameter: The UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetBreakTypeResponse getBreakType(final String id) throws ApiException, IOException;

    /**
     * Returns a single `BreakType` specified by `id`.
     * @param  id  Required parameter: The UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     */
    CompletableFuture<GetBreakTypeResponse> getBreakTypeAsync(final String id);

    /**
     * Updates an existing `BreakType`.
     * @param  id  Required parameter: The UUID for the `BreakType` being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateBreakTypeResponse updateBreakType(final String id, final UpdateBreakTypeRequest body)
            throws ApiException, IOException;

    /**
     * Updates an existing `BreakType`.
     * @param  id  Required parameter: The UUID for the `BreakType` being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     */
    CompletableFuture<UpdateBreakTypeResponse> updateBreakTypeAsync(final String id, final UpdateBreakTypeRequest body);

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
    ListEmployeeWagesResponse listEmployeeWages(final String employeeId, final Integer limit, final String cursor)
            throws ApiException, IOException;

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
    CompletableFuture<ListEmployeeWagesResponse> listEmployeeWagesAsync(
            final String employeeId, final Integer limit, final String cursor);

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
    GetEmployeeWageResponse getEmployeeWage(final String id) throws ApiException, IOException;

    /**
     * Returns a single `EmployeeWage` specified by `id`.
     * @deprecated
     *
     * @param  id  Required parameter: The UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     */
    @Deprecated
    CompletableFuture<GetEmployeeWageResponse> getEmployeeWageAsync(final String id);

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
    CreateShiftResponse createShift(final CreateShiftRequest body) throws ApiException, IOException;

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
    CompletableFuture<CreateShiftResponse> createShiftAsync(final CreateShiftRequest body);

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
    SearchShiftsResponse searchShifts(final SearchShiftsRequest body) throws ApiException, IOException;

    /**
     * Returns a paginated list of `Shift` records for a business. The list to be returned can be
     * filtered by: - Location IDs - Team member IDs - Shift status (`OPEN` or `CLOSED`) - Shift
     * start - Shift end - Workday details The list can be sorted by: - `START_AT` - `END_AT` -
     * `CREATED_AT` - `UPDATED_AT`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call
     */
    CompletableFuture<SearchShiftsResponse> searchShiftsAsync(final SearchShiftsRequest body);

    /**
     * Deletes a `Shift`.
     * @param  id  Required parameter: The UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteShiftResponse deleteShift(final String id) throws ApiException, IOException;

    /**
     * Deletes a `Shift`.
     * @param  id  Required parameter: The UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     */
    CompletableFuture<DeleteShiftResponse> deleteShiftAsync(final String id);

    /**
     * Returns a single `Shift` specified by `id`.
     * @param  id  Required parameter: The UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetShiftResponse getShift(final String id) throws ApiException, IOException;

    /**
     * Returns a single `Shift` specified by `id`.
     * @param  id  Required parameter: The UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     */
    CompletableFuture<GetShiftResponse> getShiftAsync(final String id);

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
    UpdateShiftResponse updateShift(final String id, final UpdateShiftRequest body) throws ApiException, IOException;

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
    CompletableFuture<UpdateShiftResponse> updateShiftAsync(final String id, final UpdateShiftRequest body);

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
    ListTeamMemberWagesResponse listTeamMemberWages(final String teamMemberId, final Integer limit, final String cursor)
            throws ApiException, IOException;

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
    CompletableFuture<ListTeamMemberWagesResponse> listTeamMemberWagesAsync(
            final String teamMemberId, final Integer limit, final String cursor);

    /**
     * Returns a single `TeamMemberWage` specified by `id`.
     * @param  id  Required parameter: The UUID for the `TeamMemberWage` being retrieved.
     * @return    Returns the GetTeamMemberWageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTeamMemberWageResponse getTeamMemberWage(final String id) throws ApiException, IOException;

    /**
     * Returns a single `TeamMemberWage` specified by `id`.
     * @param  id  Required parameter: The UUID for the `TeamMemberWage` being retrieved.
     * @return    Returns the GetTeamMemberWageResponse response from the API call
     */
    CompletableFuture<GetTeamMemberWageResponse> getTeamMemberWageAsync(final String id);

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
    ListWorkweekConfigsResponse listWorkweekConfigs(final Integer limit, final String cursor)
            throws ApiException, IOException;

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param  limit  Optional parameter: The maximum number of `WorkweekConfigs` results to return
     *         per page.
     * @param  cursor  Optional parameter: A pointer to the next page of `WorkweekConfig` results to
     *         fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     */
    CompletableFuture<ListWorkweekConfigsResponse> listWorkweekConfigsAsync(final Integer limit, final String cursor);

    /**
     * Updates a `WorkweekConfig`.
     * @param  id  Required parameter: The UUID for the `WorkweekConfig` object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateWorkweekConfigResponse updateWorkweekConfig(final String id, final UpdateWorkweekConfigRequest body)
            throws ApiException, IOException;

    /**
     * Updates a `WorkweekConfig`.
     * @param  id  Required parameter: The UUID for the `WorkweekConfig` object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     */
    CompletableFuture<UpdateWorkweekConfigResponse> updateWorkweekConfigAsync(
            final String id, final UpdateWorkweekConfigRequest body);
}
