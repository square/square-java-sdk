
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1CashDrawerShift;
import com.squareup.square.models.V1Employee;
import com.squareup.square.models.V1EmployeeRole;
import com.squareup.square.models.V1Timecard;
import com.squareup.square.models.V1TimecardEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface V1EmployeesApi {
    /**
     * Provides summary information for all of a business's employees.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field. Default value: ASC
     * @param  beginUpdatedAt  Optional parameter: If filtering results by their updated_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format
     * @param  endUpdatedAt  Optional parameter: If filtering results by there updated_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  beginCreatedAt  Optional parameter: If filtering results by their created_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endCreatedAt  Optional parameter: If filtering results by their created_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  status  Optional parameter: If provided, the endpoint returns only employee entities
     *         with the specified status (ACTIVE or INACTIVE).
     * @param  externalId  Optional parameter: If provided, the endpoint returns only employee
     *         entities with the specified external_id.
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    List<V1Employee> listEmployees(
            final String order,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final String beginCreatedAt,
            final String endCreatedAt,
            final String status,
            final String externalId,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information for all of a business's employees.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field. Default value: ASC
     * @param  beginUpdatedAt  Optional parameter: If filtering results by their updated_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format
     * @param  endUpdatedAt  Optional parameter: If filtering results by there updated_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  beginCreatedAt  Optional parameter: If filtering results by their created_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endCreatedAt  Optional parameter: If filtering results by their created_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  status  Optional parameter: If provided, the endpoint returns only employee entities
     *         with the specified status (ACTIVE or INACTIVE).
     * @param  externalId  Optional parameter: If provided, the endpoint returns only employee
     *         entities with the specified external_id.
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Employee response from the API call
     */
    CompletableFuture<List<V1Employee>> listEmployeesAsync(
            final String order,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final String beginCreatedAt,
            final String endCreatedAt,
            final String status,
            final String externalId,
            final Integer limit,
            final String batchToken);

    /**
     * Use the CreateEmployee endpoint to add an employee to a Square account. Employees created
     * with the Connect API have an initial status of `INACTIVE`. Inactive employees cannot sign in
     * to Square Point of Sale until they are activated from the Square Dashboard. Employee status
     * cannot be changed with the Connect API. Employee entities cannot be deleted. To disable
     * employee profiles, set the employee's status to <code>INACTIVE</code>.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    V1Employee createEmployee(
            final V1Employee body) throws ApiException, IOException;

    /**
     * Use the CreateEmployee endpoint to add an employee to a Square account. Employees created
     * with the Connect API have an initial status of `INACTIVE`. Inactive employees cannot sign in
     * to Square Point of Sale until they are activated from the Square Dashboard. Employee status
     * cannot be changed with the Connect API. Employee entities cannot be deleted. To disable
     * employee profiles, set the employee's status to <code>INACTIVE</code>.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    CompletableFuture<V1Employee> createEmployeeAsync(
            final V1Employee body);

    /**
     * Provides the details for a single employee.
     * @param  employeeId  Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    V1Employee retrieveEmployee(
            final String employeeId) throws ApiException, IOException;

    /**
     * Provides the details for a single employee.
     * @param  employeeId  Required parameter: The employee's ID.
     * @return    Returns the V1Employee response from the API call
     */
    CompletableFuture<V1Employee> retrieveEmployeeAsync(
            final String employeeId);

    /**
     * UpdateEmployee.
     * @param  employeeId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    V1Employee updateEmployee(
            final String employeeId,
            final V1Employee body) throws ApiException, IOException;

    /**
     * UpdateEmployee.
     * @param  employeeId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Employee response from the API call
     */
    CompletableFuture<V1Employee> updateEmployeeAsync(
            final String employeeId,
            final V1Employee body);

    /**
     * Provides summary information for all of a business's employee roles.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field.Default value: ASC
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    List<V1EmployeeRole> listEmployeeRoles(
            final String order,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information for all of a business's employee roles.
     * @param  order  Optional parameter: The order in which employees are listed in the response,
     *         based on their created_at field.Default value: ASC
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1EmployeeRole response from the API call
     */
    CompletableFuture<List<V1EmployeeRole>> listEmployeeRolesAsync(
            final String order,
            final Integer limit,
            final String batchToken);

    /**
     * Creates an employee role you can then assign to employees. Square accounts can include any
     * number of roles that can be assigned to employees. These roles define the actions and
     * permissions granted to an employee with that role. For example, an employee with a "Shift
     * Manager" role might be able to issue refunds in Square Point of Sale, whereas an employee
     * with a "Clerk" role might not. Roles are assigned with the
     * [V1UpdateEmployee](#endpoint-v1updateemployee) endpoint. An employee can have only one role
     * at a time. If an employee has no role, they have none of the permissions associated with
     * roles. All employees can accept payments with Square Point of Sale.
     * @param  body  Required parameter: An EmployeeRole object with a name and permissions, and an
     *         optional owner flag.
     * @return    Returns the V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    V1EmployeeRole createEmployeeRole(
            final V1EmployeeRole body) throws ApiException, IOException;

    /**
     * Creates an employee role you can then assign to employees. Square accounts can include any
     * number of roles that can be assigned to employees. These roles define the actions and
     * permissions granted to an employee with that role. For example, an employee with a "Shift
     * Manager" role might be able to issue refunds in Square Point of Sale, whereas an employee
     * with a "Clerk" role might not. Roles are assigned with the
     * [V1UpdateEmployee](#endpoint-v1updateemployee) endpoint. An employee can have only one role
     * at a time. If an employee has no role, they have none of the permissions associated with
     * roles. All employees can accept payments with Square Point of Sale.
     * @param  body  Required parameter: An EmployeeRole object with a name and permissions, and an
     *         optional owner flag.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    CompletableFuture<V1EmployeeRole> createEmployeeRoleAsync(
            final V1EmployeeRole body);

    /**
     * Provides the details for a single employee role.
     * @param  roleId  Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    V1EmployeeRole retrieveEmployeeRole(
            final String roleId) throws ApiException, IOException;

    /**
     * Provides the details for a single employee role.
     * @param  roleId  Required parameter: The role's ID.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    CompletableFuture<V1EmployeeRole> retrieveEmployeeRoleAsync(
            final String roleId);

    /**
     * Modifies the details of an employee role.
     * @param  roleId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    V1EmployeeRole updateEmployeeRole(
            final String roleId,
            final V1EmployeeRole body) throws ApiException, IOException;

    /**
     * Modifies the details of an employee role.
     * @param  roleId  Required parameter: The ID of the role to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1EmployeeRole response from the API call
     */
    CompletableFuture<V1EmployeeRole> updateEmployeeRoleAsync(
            final String roleId,
            final V1EmployeeRole body);

    /**
     * Provides summary information for all of a business's employee timecards.
     * @deprecated
     * 
     * @param  order  Optional parameter: The order in which timecards are listed in the response,
     *         based on their created_at field.
     * @param  employeeId  Optional parameter: If provided, the endpoint returns only timecards for
     *         the employee with the specified ID.
     * @param  beginClockinTime  Optional parameter: If filtering results by their clockin_time
     *         field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endClockinTime  Optional parameter: If filtering results by their clockin_time field,
     *         the end of the requested reporting period, in ISO 8601 format.
     * @param  beginClockoutTime  Optional parameter: If filtering results by their clockout_time
     *         field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endClockoutTime  Optional parameter: If filtering results by their clockout_time
     *         field, the end of the requested reporting period, in ISO 8601 format.
     * @param  beginUpdatedAt  Optional parameter: If filtering results by their updated_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endUpdatedAt  Optional parameter: If filtering results by their updated_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  deleted  Optional parameter: If true, only deleted timecards are returned. If false,
     *         only valid timecards are returned.If you don't provide this parameter, both valid and
     *         deleted timecards are returned.
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Timecard response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    List<V1Timecard> listTimecards(
            final String order,
            final String employeeId,
            final String beginClockinTime,
            final String endClockinTime,
            final String beginClockoutTime,
            final String endClockoutTime,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final Boolean deleted,
            final Integer limit,
            final String batchToken) throws ApiException, IOException;

    /**
     * Provides summary information for all of a business's employee timecards.
     * @deprecated
     * 
     * @param  order  Optional parameter: The order in which timecards are listed in the response,
     *         based on their created_at field.
     * @param  employeeId  Optional parameter: If provided, the endpoint returns only timecards for
     *         the employee with the specified ID.
     * @param  beginClockinTime  Optional parameter: If filtering results by their clockin_time
     *         field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endClockinTime  Optional parameter: If filtering results by their clockin_time field,
     *         the end of the requested reporting period, in ISO 8601 format.
     * @param  beginClockoutTime  Optional parameter: If filtering results by their clockout_time
     *         field, the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endClockoutTime  Optional parameter: If filtering results by their clockout_time
     *         field, the end of the requested reporting period, in ISO 8601 format.
     * @param  beginUpdatedAt  Optional parameter: If filtering results by their updated_at field,
     *         the beginning of the requested reporting period, in ISO 8601 format.
     * @param  endUpdatedAt  Optional parameter: If filtering results by their updated_at field, the
     *         end of the requested reporting period, in ISO 8601 format.
     * @param  deleted  Optional parameter: If true, only deleted timecards are returned. If false,
     *         only valid timecards are returned.If you don't provide this parameter, both valid and
     *         deleted timecards are returned.
     * @param  limit  Optional parameter: The maximum integer number of employee entities to return
     *         in a single response. Default 100, maximum 200.
     * @param  batchToken  Optional parameter: A pagination cursor to retrieve the next set of
     *         results for your original query to the endpoint.
     * @return    Returns the List of V1Timecard response from the API call
     */
    @Deprecated
    CompletableFuture<List<V1Timecard>> listTimecardsAsync(
            final String order,
            final String employeeId,
            final String beginClockinTime,
            final String endClockinTime,
            final String beginClockoutTime,
            final String endClockoutTime,
            final String beginUpdatedAt,
            final String endUpdatedAt,
            final Boolean deleted,
            final Integer limit,
            final String batchToken);

    /**
     * Creates a timecard for an employee and clocks them in with an `API_CREATE` event and a
     * `clockin_time` set to the current time unless the request provides a different value. To
     * import timecards from another system (rather than clocking someone in). Specify the
     * `clockin_time` and* `clockout_time` in the request. Timecards correspond to exactly one shift
     * for a given employee, bounded by the `clockin_time` and `clockout_time` fields. An employee
     * is considered clocked in if they have a timecard that doesn't have a `clockout_time` set. An
     * employee that is currently clocked in cannot be clocked in a second time.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1Timecard createTimecard(
            final V1Timecard body) throws ApiException, IOException;

    /**
     * Creates a timecard for an employee and clocks them in with an `API_CREATE` event and a
     * `clockin_time` set to the current time unless the request provides a different value. To
     * import timecards from another system (rather than clocking someone in). Specify the
     * `clockin_time` and* `clockout_time` in the request. Timecards correspond to exactly one shift
     * for a given employee, bounded by the `clockin_time` and `clockout_time` fields. An employee
     * is considered clocked in if they have a timecard that doesn't have a `clockout_time` set. An
     * employee that is currently clocked in cannot be clocked in a second time.
     * @deprecated
     * 
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     */
    @Deprecated
    CompletableFuture<V1Timecard> createTimecardAsync(
            final V1Timecard body);

    /**
     * Deletes a timecard. Timecards can also be deleted through the Square Dashboard. Deleted
     * timecards are still accessible through Connect API endpoints, but cannot be modified. The
     * `deleted` field of the `Timecard` object indicates whether the timecard has been deleted.
     * __Note__: By default, deleted timecards appear alongside valid timecards in results returned
     * by the [ListTimecards](#endpoint-v1employees-listtimecards) endpoint. To filter deleted
     * timecards, include the `deleted` query parameter in the list request. Only approved accounts
     * can manage their employees with Square. Unapproved accounts cannot use employee management
     * features with the API.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: The ID of the timecard to delete.
     * @return    Returns the Object response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    Object deleteTimecard(
            final String timecardId) throws ApiException, IOException;

    /**
     * Deletes a timecard. Timecards can also be deleted through the Square Dashboard. Deleted
     * timecards are still accessible through Connect API endpoints, but cannot be modified. The
     * `deleted` field of the `Timecard` object indicates whether the timecard has been deleted.
     * __Note__: By default, deleted timecards appear alongside valid timecards in results returned
     * by the [ListTimecards](#endpoint-v1employees-listtimecards) endpoint. To filter deleted
     * timecards, include the `deleted` query parameter in the list request. Only approved accounts
     * can manage their employees with Square. Unapproved accounts cannot use employee management
     * features with the API.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: The ID of the timecard to delete.
     * @return    Returns the Object response from the API call
     */
    @Deprecated
    CompletableFuture<Object> deleteTimecardAsync(
            final String timecardId);

    /**
     * Provides the details for a single timecard. Only approved accounts can manage their employees
     * with Square. Unapproved accounts cannot use employee management features with the API.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: The timecard's ID.
     * @return    Returns the V1Timecard response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1Timecard retrieveTimecard(
            final String timecardId) throws ApiException, IOException;

    /**
     * Provides the details for a single timecard. Only approved accounts can manage their employees
     * with Square. Unapproved accounts cannot use employee management features with the API.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: The timecard's ID.
     * @return    Returns the V1Timecard response from the API call
     */
    @Deprecated
    CompletableFuture<V1Timecard> retrieveTimecardAsync(
            final String timecardId);

    /**
     * Modifies the details of a timecard with an `API_EDIT` event for the timecard. Updating an
     * active timecard with a `clockout_time` clocks the employee out.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: TThe ID of the timecard to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1Timecard updateTimecard(
            final String timecardId,
            final V1Timecard body) throws ApiException, IOException;

    /**
     * Modifies the details of a timecard with an `API_EDIT` event for the timecard. Updating an
     * active timecard with a `clockout_time` clocks the employee out.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: TThe ID of the timecard to modify.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the V1Timecard response from the API call
     */
    @Deprecated
    CompletableFuture<V1Timecard> updateTimecardAsync(
            final String timecardId,
            final V1Timecard body);

    /**
     * Provides summary information for all events associated with a particular timecard. Only
     * approved accounts can manage their employees with Square. Unapproved accounts cannot use
     * employee management features with the API.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: The ID of the timecard to list events for.
     * @return    Returns the List of V1TimecardEvent response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    List<V1TimecardEvent> listTimecardEvents(
            final String timecardId) throws ApiException, IOException;

    /**
     * Provides summary information for all events associated with a particular timecard. Only
     * approved accounts can manage their employees with Square. Unapproved accounts cannot use
     * employee management features with the API.
     * @deprecated
     * 
     * @param  timecardId  Required parameter: The ID of the timecard to list events for.
     * @return    Returns the List of V1TimecardEvent response from the API call
     */
    @Deprecated
    CompletableFuture<List<V1TimecardEvent>> listTimecardEventsAsync(
            final String timecardId);

    /**
     * Provides the details for all of a location's cash drawer shifts during a date range. The date
     * range you specify cannot exceed 90 days.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list cash drawer shifts
     *         for.
     * @param  order  Optional parameter: The order in which cash drawer shifts are listed in the
     *         response, based on their created_at field. Default value: ASC
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. Default value: The current time minus 90 days.
     * @param  endTime  Optional parameter: The beginning of the requested reporting period, in ISO
     *         8601 format. Default value: The current time.
     * @return    Returns the List of V1CashDrawerShift response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    List<V1CashDrawerShift> listCashDrawerShifts(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime) throws ApiException, IOException;

    /**
     * Provides the details for all of a location's cash drawer shifts during a date range. The date
     * range you specify cannot exceed 90 days.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list cash drawer shifts
     *         for.
     * @param  order  Optional parameter: The order in which cash drawer shifts are listed in the
     *         response, based on their created_at field. Default value: ASC
     * @param  beginTime  Optional parameter: The beginning of the requested reporting period, in
     *         ISO 8601 format. Default value: The current time minus 90 days.
     * @param  endTime  Optional parameter: The beginning of the requested reporting period, in ISO
     *         8601 format. Default value: The current time.
     * @return    Returns the List of V1CashDrawerShift response from the API call
     */
    @Deprecated
    CompletableFuture<List<V1CashDrawerShift>> listCashDrawerShiftsAsync(
            final String locationId,
            final String order,
            final String beginTime,
            final String endTime);

    /**
     * Provides the details for a single cash drawer shift, including all events that occurred
     * during the shift.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list cash drawer shifts
     *         for.
     * @param  shiftId  Required parameter: The shift's ID.
     * @return    Returns the V1CashDrawerShift response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    @Deprecated    V1CashDrawerShift retrieveCashDrawerShift(
            final String locationId,
            final String shiftId) throws ApiException, IOException;

    /**
     * Provides the details for a single cash drawer shift, including all events that occurred
     * during the shift.
     * @deprecated
     * 
     * @param  locationId  Required parameter: The ID of the location to list cash drawer shifts
     *         for.
     * @param  shiftId  Required parameter: The shift's ID.
     * @return    Returns the V1CashDrawerShift response from the API call
     */
    @Deprecated
    CompletableFuture<V1CashDrawerShift> retrieveCashDrawerShiftAsync(
            final String locationId,
            final String shiftId);

}