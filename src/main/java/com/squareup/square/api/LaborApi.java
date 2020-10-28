
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.CreateBreakTypeRequest;
import com.squareup.square.models.CreateBreakTypeResponse;
import com.squareup.square.models.CreateShiftRequest;
import com.squareup.square.models.CreateShiftResponse;
import com.squareup.square.models.DeleteBreakTypeResponse;
import com.squareup.square.models.DeleteShiftResponse;
import com.squareup.square.models.GetBreakTypeResponse;
import com.squareup.square.models.GetEmployeeWageResponse;
import com.squareup.square.models.GetShiftResponse;
import com.squareup.square.models.GetTeamMemberWageResponse;
import com.squareup.square.models.ListBreakTypesResponse;
import com.squareup.square.models.ListEmployeeWagesResponse;
import com.squareup.square.models.ListTeamMemberWagesResponse;
import com.squareup.square.models.ListWorkweekConfigsResponse;
import com.squareup.square.models.SearchShiftsRequest;
import com.squareup.square.models.SearchShiftsResponse;
import com.squareup.square.models.UpdateBreakTypeRequest;
import com.squareup.square.models.UpdateBreakTypeResponse;
import com.squareup.square.models.UpdateShiftRequest;
import com.squareup.square.models.UpdateShiftResponse;
import com.squareup.square.models.UpdateWorkweekConfigRequest;
import com.squareup.square.models.UpdateWorkweekConfigResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface LaborApi {
    /**
     * Returns a paginated list of `BreakType` instances for a business.
     * @param  locationId  Optional parameter: Filter Break Types returned to only those that are
     *         associated with the specified location.
     * @param  limit  Optional parameter: Maximum number of Break Types to return per page. Can
     *         range between 1 and 200. The default is the maximum at 200.
     * @param  cursor  Optional parameter: Pointer to the next page of Break Type results to fetch.
     * @return    Returns the ListBreakTypesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListBreakTypesResponse listBreakTypes(
            final String locationId,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a paginated list of `BreakType` instances for a business.
     * @param  locationId  Optional parameter: Filter Break Types returned to only those that are
     *         associated with the specified location.
     * @param  limit  Optional parameter: Maximum number of Break Types to return per page. Can
     *         range between 1 and 200. The default is the maximum at 200.
     * @param  cursor  Optional parameter: Pointer to the next page of Break Type results to fetch.
     * @return    Returns the ListBreakTypesResponse response from the API call
     */
    CompletableFuture<ListBreakTypesResponse> listBreakTypesAsync(
            final String locationId,
            final Integer limit,
            final String cursor);

    /**
     * Creates a new `BreakType`. A `BreakType` is a template for creating `Break` objects. You must
     * provide the following values in your request to this endpoint: - `location_id` - `break_name`
     * - `expected_duration` - `is_paid` You can only have 3 `BreakType` instances per location. If
     * you attempt to add a 4th `BreakType` for a location, an `INVALID_REQUEST_ERROR` "Exceeded
     * limit of 3 breaks per location." is returned.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateBreakTypeResponse createBreakType(
            final CreateBreakTypeRequest body) throws ApiException, IOException;

    /**
     * Creates a new `BreakType`. A `BreakType` is a template for creating `Break` objects. You must
     * provide the following values in your request to this endpoint: - `location_id` - `break_name`
     * - `expected_duration` - `is_paid` You can only have 3 `BreakType` instances per location. If
     * you attempt to add a 4th `BreakType` for a location, an `INVALID_REQUEST_ERROR` "Exceeded
     * limit of 3 breaks per location." is returned.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateBreakTypeResponse response from the API call
     */
    CompletableFuture<CreateBreakTypeResponse> createBreakTypeAsync(
            final CreateBreakTypeRequest body);

    /**
     * Deletes an existing `BreakType`. A `BreakType` can be deleted even if it is referenced from a
     * `Shift`.
     * @param  id  Required parameter: UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteBreakTypeResponse deleteBreakType(
            final String id) throws ApiException, IOException;

    /**
     * Deletes an existing `BreakType`. A `BreakType` can be deleted even if it is referenced from a
     * `Shift`.
     * @param  id  Required parameter: UUID for the `BreakType` being deleted.
     * @return    Returns the DeleteBreakTypeResponse response from the API call
     */
    CompletableFuture<DeleteBreakTypeResponse> deleteBreakTypeAsync(
            final String id);

    /**
     * Returns a single `BreakType` specified by id.
     * @param  id  Required parameter: UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetBreakTypeResponse getBreakType(
            final String id) throws ApiException, IOException;

    /**
     * Returns a single `BreakType` specified by id.
     * @param  id  Required parameter: UUID for the `BreakType` being retrieved.
     * @return    Returns the GetBreakTypeResponse response from the API call
     */
    CompletableFuture<GetBreakTypeResponse> getBreakTypeAsync(
            final String id);

    /**
     * Updates an existing `BreakType`.
     * @param  id  Required parameter: UUID for the `BreakType` being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateBreakTypeResponse updateBreakType(
            final String id,
            final UpdateBreakTypeRequest body) throws ApiException, IOException;

    /**
     * Updates an existing `BreakType`.
     * @param  id  Required parameter: UUID for the `BreakType` being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateBreakTypeResponse response from the API call
     */
    CompletableFuture<UpdateBreakTypeResponse> updateBreakTypeAsync(
            final String id,
            final UpdateBreakTypeRequest body);

    /**
     * Returns a paginated list of `EmployeeWage` instances for a business.
     * @deprecated
     * 
     * @param  employeeId  Optional parameter: Filter wages returned to only those that are
     *         associated with the specified employee.
     * @param  limit  Optional parameter: Maximum number of Employee Wages to return per page. Can
     *         range between 1 and 200. The default is the maximum at 200.
     * @param  cursor  Optional parameter: Pointer to the next page of Employee Wage results to
     *         fetch.
     * @return    Returns the ListEmployeeWagesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    ListEmployeeWagesResponse listEmployeeWages(
            final String employeeId,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a paginated list of `EmployeeWage` instances for a business.
     * @deprecated
     * 
     * @param  employeeId  Optional parameter: Filter wages returned to only those that are
     *         associated with the specified employee.
     * @param  limit  Optional parameter: Maximum number of Employee Wages to return per page. Can
     *         range between 1 and 200. The default is the maximum at 200.
     * @param  cursor  Optional parameter: Pointer to the next page of Employee Wage results to
     *         fetch.
     * @return    Returns the ListEmployeeWagesResponse response from the API call
     */
    @Deprecated
    CompletableFuture<ListEmployeeWagesResponse> listEmployeeWagesAsync(
            final String employeeId,
            final Integer limit,
            final String cursor);

    /**
     * Returns a single `EmployeeWage` specified by id.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    GetEmployeeWageResponse getEmployeeWage(
            final String id) throws ApiException, IOException;

    /**
     * Returns a single `EmployeeWage` specified by id.
     * @deprecated
     * 
     * @param  id  Required parameter: UUID for the `EmployeeWage` being retrieved.
     * @return    Returns the GetEmployeeWageResponse response from the API call
     */
    @Deprecated
    CompletableFuture<GetEmployeeWageResponse> getEmployeeWageAsync(
            final String id);

    /**
     * Creates a new `Shift`. A `Shift` represents a complete work day for a single employee. You
     * must provide the following values in your request to this endpoint: - `location_id` -
     * `employee_id` - `start_at` An attempt to create a new `Shift` can result in a `BAD_REQUEST`
     * error when: - The `status` of the new `Shift` is `OPEN` and the employee has another shift
     * with an `OPEN` status. - The `start_at` date is in the future - the `start_at` or `end_at`
     * overlaps another shift for the same employee - If `Break`s are set in the request, a break
     * `start_at` must not be before the `Shift.start_at`. A break `end_at` must not be after the
     * `Shift.end_at`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateShiftResponse createShift(
            final CreateShiftRequest body) throws ApiException, IOException;

    /**
     * Creates a new `Shift`. A `Shift` represents a complete work day for a single employee. You
     * must provide the following values in your request to this endpoint: - `location_id` -
     * `employee_id` - `start_at` An attempt to create a new `Shift` can result in a `BAD_REQUEST`
     * error when: - The `status` of the new `Shift` is `OPEN` and the employee has another shift
     * with an `OPEN` status. - The `start_at` date is in the future - the `start_at` or `end_at`
     * overlaps another shift for the same employee - If `Break`s are set in the request, a break
     * `start_at` must not be before the `Shift.start_at`. A break `end_at` must not be after the
     * `Shift.end_at`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateShiftResponse response from the API call
     */
    CompletableFuture<CreateShiftResponse> createShiftAsync(
            final CreateShiftRequest body);

    /**
     * Returns a paginated list of `Shift` records for a business. The list to be returned can be
     * filtered by: - Location IDs **and** - employee IDs **and** - shift status (`OPEN`, `CLOSED`)
     * **and** - shift start **and** - shift end **and** - work day details The list can be sorted
     * by: - `start_at` - `end_at` - `created_at` - `updated_at`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchShiftsResponse searchShifts(
            final SearchShiftsRequest body) throws ApiException, IOException;

    /**
     * Returns a paginated list of `Shift` records for a business. The list to be returned can be
     * filtered by: - Location IDs **and** - employee IDs **and** - shift status (`OPEN`, `CLOSED`)
     * **and** - shift start **and** - shift end **and** - work day details The list can be sorted
     * by: - `start_at` - `end_at` - `created_at` - `updated_at`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchShiftsResponse response from the API call
     */
    CompletableFuture<SearchShiftsResponse> searchShiftsAsync(
            final SearchShiftsRequest body);

    /**
     * Deletes a `Shift`.
     * @param  id  Required parameter: UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    DeleteShiftResponse deleteShift(
            final String id) throws ApiException, IOException;

    /**
     * Deletes a `Shift`.
     * @param  id  Required parameter: UUID for the `Shift` being deleted.
     * @return    Returns the DeleteShiftResponse response from the API call
     */
    CompletableFuture<DeleteShiftResponse> deleteShiftAsync(
            final String id);

    /**
     * Returns a single `Shift` specified by id.
     * @param  id  Required parameter: UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetShiftResponse getShift(
            final String id) throws ApiException, IOException;

    /**
     * Returns a single `Shift` specified by id.
     * @param  id  Required parameter: UUID for the `Shift` being retrieved.
     * @return    Returns the GetShiftResponse response from the API call
     */
    CompletableFuture<GetShiftResponse> getShiftAsync(
            final String id);

    /**
     * Updates an existing `Shift`. When adding a `Break` to a `Shift`, any earlier `Breaks` in the
     * `Shift` have the `end_at` property set to a valid RFC-3339 datetime string. When closing a
     * `Shift`, all `Break` instances in the shift must be complete with `end_at` set on each
     * `Break`.
     * @param  id  Required parameter: ID of the object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateShiftResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateShiftResponse updateShift(
            final String id,
            final UpdateShiftRequest body) throws ApiException, IOException;

    /**
     * Updates an existing `Shift`. When adding a `Break` to a `Shift`, any earlier `Breaks` in the
     * `Shift` have the `end_at` property set to a valid RFC-3339 datetime string. When closing a
     * `Shift`, all `Break` instances in the shift must be complete with `end_at` set on each
     * `Break`.
     * @param  id  Required parameter: ID of the object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateShiftResponse response from the API call
     */
    CompletableFuture<UpdateShiftResponse> updateShiftAsync(
            final String id,
            final UpdateShiftRequest body);

    /**
     * Returns a paginated list of `TeamMemberWage` instances for a business.
     * @param  teamMemberId  Optional parameter: Filter wages returned to only those that are
     *         associated with the specified team member.
     * @param  limit  Optional parameter: Maximum number of Team Member Wages to return per page.
     *         Can range between 1 and 200. The default is the maximum at 200.
     * @param  cursor  Optional parameter: Pointer to the next page of Employee Wage results to
     *         fetch.
     * @return    Returns the ListTeamMemberWagesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListTeamMemberWagesResponse listTeamMemberWages(
            final String teamMemberId,
            final Integer limit,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a paginated list of `TeamMemberWage` instances for a business.
     * @param  teamMemberId  Optional parameter: Filter wages returned to only those that are
     *         associated with the specified team member.
     * @param  limit  Optional parameter: Maximum number of Team Member Wages to return per page.
     *         Can range between 1 and 200. The default is the maximum at 200.
     * @param  cursor  Optional parameter: Pointer to the next page of Employee Wage results to
     *         fetch.
     * @return    Returns the ListTeamMemberWagesResponse response from the API call
     */
    CompletableFuture<ListTeamMemberWagesResponse> listTeamMemberWagesAsync(
            final String teamMemberId,
            final Integer limit,
            final String cursor);

    /**
     * Returns a single `TeamMemberWage` specified by id.
     * @param  id  Required parameter: UUID for the `TeamMemberWage` being retrieved.
     * @return    Returns the GetTeamMemberWageResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    GetTeamMemberWageResponse getTeamMemberWage(
            final String id) throws ApiException, IOException;

    /**
     * Returns a single `TeamMemberWage` specified by id.
     * @param  id  Required parameter: UUID for the `TeamMemberWage` being retrieved.
     * @return    Returns the GetTeamMemberWageResponse response from the API call
     */
    CompletableFuture<GetTeamMemberWageResponse> getTeamMemberWageAsync(
            final String id);

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param  limit  Optional parameter: Maximum number of Workweek Configs to return per page.
     * @param  cursor  Optional parameter: Pointer to the next page of Workweek Config results to
     *         fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    ListWorkweekConfigsResponse listWorkweekConfigs(
            final Integer limit,
            final String cursor) throws ApiException, IOException;

    /**
     * Returns a list of `WorkweekConfig` instances for a business.
     * @param  limit  Optional parameter: Maximum number of Workweek Configs to return per page.
     * @param  cursor  Optional parameter: Pointer to the next page of Workweek Config results to
     *         fetch.
     * @return    Returns the ListWorkweekConfigsResponse response from the API call
     */
    CompletableFuture<ListWorkweekConfigsResponse> listWorkweekConfigsAsync(
            final Integer limit,
            final String cursor);

    /**
     * Updates a `WorkweekConfig`.
     * @param  id  Required parameter: UUID for the `WorkweekConfig` object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateWorkweekConfigResponse updateWorkweekConfig(
            final String id,
            final UpdateWorkweekConfigRequest body) throws ApiException, IOException;

    /**
     * Updates a `WorkweekConfig`.
     * @param  id  Required parameter: UUID for the `WorkweekConfig` object being updated.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWorkweekConfigResponse response from the API call
     */
    CompletableFuture<UpdateWorkweekConfigResponse> updateWorkweekConfigAsync(
            final String id,
            final UpdateWorkweekConfigRequest body);

}