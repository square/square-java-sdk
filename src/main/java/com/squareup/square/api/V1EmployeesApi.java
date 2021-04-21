
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.V1Employee;
import com.squareup.square.models.V1EmployeeRole;
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
     * [V1UpdateEmployee]($e/V1Employees/UpdateEmployeeRole) endpoint. An employee can have only one
     * role at a time. If an employee has no role, they have none of the permissions associated with
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
     * [V1UpdateEmployee]($e/V1Employees/UpdateEmployeeRole) endpoint. An employee can have only one
     * role at a time. If an employee has no role, they have none of the permissions associated with
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

}