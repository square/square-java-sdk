
package com.squareup.square.api;

import com.squareup.square.exceptions.ApiException;
import com.squareup.square.models.BulkCreateTeamMembersRequest;
import com.squareup.square.models.BulkCreateTeamMembersResponse;
import com.squareup.square.models.BulkUpdateTeamMembersRequest;
import com.squareup.square.models.BulkUpdateTeamMembersResponse;
import com.squareup.square.models.CreateTeamMemberRequest;
import com.squareup.square.models.CreateTeamMemberResponse;
import com.squareup.square.models.RetrieveTeamMemberResponse;
import com.squareup.square.models.RetrieveWageSettingResponse;
import com.squareup.square.models.SearchTeamMembersRequest;
import com.squareup.square.models.SearchTeamMembersResponse;
import com.squareup.square.models.UpdateTeamMemberRequest;
import com.squareup.square.models.UpdateTeamMemberResponse;
import com.squareup.square.models.UpdateWageSettingRequest;
import com.squareup.square.models.UpdateWageSettingResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * This interface lists all the endpoints of the group.
 * This can be overridden for the mock calls.
 */
public interface TeamApi {
    /**
     * Creates a single `TeamMember` object. The `TeamMember` will be returned on successful
     * creates. You must provide the following values in your request to this endpoint: -
     * `given_name` - `family_name` Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#createteammember).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTeamMemberResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    CreateTeamMemberResponse createTeamMember(
            final CreateTeamMemberRequest body) throws ApiException, IOException;

    /**
     * Creates a single `TeamMember` object. The `TeamMember` will be returned on successful
     * creates. You must provide the following values in your request to this endpoint: -
     * `given_name` - `family_name` Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#createteammember).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTeamMemberResponse response from the API call
     */
    CompletableFuture<CreateTeamMemberResponse> createTeamMemberAsync(
            final CreateTeamMemberRequest body);

    /**
     * Creates multiple `TeamMember` objects. The created `TeamMember` objects will be returned on
     * successful creates. This process is non-transactional and will process as much of the request
     * as is possible. If one of the creates in the request cannot be successfully processed, the
     * request will NOT be marked as failed, but the body of the response will contain explicit
     * error information for this particular create. Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-create-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateTeamMembersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkCreateTeamMembersResponse bulkCreateTeamMembers(
            final BulkCreateTeamMembersRequest body) throws ApiException, IOException;

    /**
     * Creates multiple `TeamMember` objects. The created `TeamMember` objects will be returned on
     * successful creates. This process is non-transactional and will process as much of the request
     * as is possible. If one of the creates in the request cannot be successfully processed, the
     * request will NOT be marked as failed, but the body of the response will contain explicit
     * error information for this particular create. Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-create-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateTeamMembersResponse response from the API call
     */
    CompletableFuture<BulkCreateTeamMembersResponse> bulkCreateTeamMembersAsync(
            final BulkCreateTeamMembersRequest body);

    /**
     * Updates multiple `TeamMember` objects. The updated `TeamMember` objects will be returned on
     * successful updates. This process is non-transactional and will process as much of the request
     * as is possible. If one of the updates in the request cannot be successfully processed, the
     * request will NOT be marked as failed, but the body of the response will contain explicit
     * error information for this particular update. Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-update-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateTeamMembersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    BulkUpdateTeamMembersResponse bulkUpdateTeamMembers(
            final BulkUpdateTeamMembersRequest body) throws ApiException, IOException;

    /**
     * Updates multiple `TeamMember` objects. The updated `TeamMember` objects will be returned on
     * successful updates. This process is non-transactional and will process as much of the request
     * as is possible. If one of the updates in the request cannot be successfully processed, the
     * request will NOT be marked as failed, but the body of the response will contain explicit
     * error information for this particular update. Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-update-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateTeamMembersResponse response from the API call
     */
    CompletableFuture<BulkUpdateTeamMembersResponse> bulkUpdateTeamMembersAsync(
            final BulkUpdateTeamMembersRequest body);

    /**
     * Returns a paginated list of `TeamMember` objects for a business. The list to be returned can
     * be filtered by: - location IDs **and** - `status`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTeamMembersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    SearchTeamMembersResponse searchTeamMembers(
            final SearchTeamMembersRequest body) throws ApiException, IOException;

    /**
     * Returns a paginated list of `TeamMember` objects for a business. The list to be returned can
     * be filtered by: - location IDs **and** - `status`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTeamMembersResponse response from the API call
     */
    CompletableFuture<SearchTeamMembersResponse> searchTeamMembersAsync(
            final SearchTeamMembersRequest body);

    /**
     * Retrieve a `TeamMember` object for the given `TeamMember.id`. Learn about [Troubleshooting
     * the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrieve-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveTeamMemberResponse retrieveTeamMember(
            final String teamMemberId) throws ApiException, IOException;

    /**
     * Retrieve a `TeamMember` object for the given `TeamMember.id`. Learn about [Troubleshooting
     * the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrieve-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberResponse response from the API call
     */
    CompletableFuture<RetrieveTeamMemberResponse> retrieveTeamMemberAsync(
            final String teamMemberId);

    /**
     * Updates a single `TeamMember` object. The `TeamMember` will be returned on successful
     * updates. Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#update-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateTeamMemberResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateTeamMemberResponse updateTeamMember(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) throws ApiException, IOException;

    /**
     * Updates a single `TeamMember` object. The `TeamMember` will be returned on successful
     * updates. Learn about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#update-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateTeamMemberResponse response from the API call
     */
    CompletableFuture<UpdateTeamMemberResponse> updateTeamMemberAsync(
            final String teamMemberId,
            final UpdateTeamMemberRequest body);

    /**
     * Retrieve a `WageSetting` object for a team member specified by `TeamMember.id`. Learn about
     * [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting).
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve wage setting
     *         for
     * @return    Returns the RetrieveWageSettingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    RetrieveWageSettingResponse retrieveWageSetting(
            final String teamMemberId) throws ApiException, IOException;

    /**
     * Retrieve a `WageSetting` object for a team member specified by `TeamMember.id`. Learn about
     * [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting).
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve wage setting
     *         for
     * @return    Returns the RetrieveWageSettingResponse response from the API call
     */
    CompletableFuture<RetrieveWageSettingResponse> retrieveWageSettingAsync(
            final String teamMemberId);

    /**
     * Creates or updates a `WageSetting` object. The object is created if a `WageSetting` with the
     * specified `team_member_id` does not exist. Otherwise, it fully replaces the `WageSetting`
     * object for the team member. The `WageSetting` will be returned upon successful update. Learn
     * about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting).
     * @param  teamMemberId  Required parameter: The ID of the team member to update the
     *         `WageSetting` object for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWageSettingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    UpdateWageSettingResponse updateWageSetting(
            final String teamMemberId,
            final UpdateWageSettingRequest body) throws ApiException, IOException;

    /**
     * Creates or updates a `WageSetting` object. The object is created if a `WageSetting` with the
     * specified `team_member_id` does not exist. Otherwise, it fully replaces the `WageSetting`
     * object for the team member. The `WageSetting` will be returned upon successful update. Learn
     * about [Troubleshooting the Teams
     * API](https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting).
     * @param  teamMemberId  Required parameter: The ID of the team member to update the
     *         `WageSetting` object for.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWageSettingResponse response from the API call
     */
    CompletableFuture<UpdateWageSettingResponse> updateWageSettingAsync(
            final String teamMemberId,
            final UpdateWageSettingRequest body);

}