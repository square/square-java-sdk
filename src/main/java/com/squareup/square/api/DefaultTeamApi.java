
package com.squareup.square.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
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
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultTeamApi extends BaseApi implements TeamApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultTeamApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Creates a single `TeamMember` object. The `TeamMember` object is returned on successful
     * creates. You must provide the following values in your request to this endpoint: -
     * `given_name` - `family_name` Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#createteammember).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTeamMemberResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public CreateTeamMemberResponse createTeamMember(
            final CreateTeamMemberRequest body) throws ApiException, IOException {
        return prepareCreateTeamMemberRequest(body).execute();
    }

    /**
     * Creates a single `TeamMember` object. The `TeamMember` object is returned on successful
     * creates. You must provide the following values in your request to this endpoint: -
     * `given_name` - `family_name` Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#createteammember).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the CreateTeamMemberResponse response from the API call
     */
    public CompletableFuture<CreateTeamMemberResponse> createTeamMemberAsync(
            final CreateTeamMemberRequest body) {
        try { 
            return prepareCreateTeamMemberRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for createTeamMember.
     */
    private ApiCall<CreateTeamMemberResponse, ApiException> prepareCreateTeamMemberRequest(
            final CreateTeamMemberRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<CreateTeamMemberResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, CreateTeamMemberResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates multiple `TeamMember` objects. The created `TeamMember` objects are returned on
     * successful creates. This process is non-transactional and processes as much of the request as
     * possible. If one of the creates in the request cannot be successfully processed, the request
     * is not marked as failed, but the body of the response contains explicit error information for
     * the failed create. Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-create-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateTeamMembersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkCreateTeamMembersResponse bulkCreateTeamMembers(
            final BulkCreateTeamMembersRequest body) throws ApiException, IOException {
        return prepareBulkCreateTeamMembersRequest(body).execute();
    }

    /**
     * Creates multiple `TeamMember` objects. The created `TeamMember` objects are returned on
     * successful creates. This process is non-transactional and processes as much of the request as
     * possible. If one of the creates in the request cannot be successfully processed, the request
     * is not marked as failed, but the body of the response contains explicit error information for
     * the failed create. Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-create-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkCreateTeamMembersResponse response from the API call
     */
    public CompletableFuture<BulkCreateTeamMembersResponse> bulkCreateTeamMembersAsync(
            final BulkCreateTeamMembersRequest body) {
        try { 
            return prepareBulkCreateTeamMembersRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkCreateTeamMembers.
     */
    private ApiCall<BulkCreateTeamMembersResponse, ApiException> prepareBulkCreateTeamMembersRequest(
            final BulkCreateTeamMembersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkCreateTeamMembersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/bulk-create")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkCreateTeamMembersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates multiple `TeamMember` objects. The updated `TeamMember` objects are returned on
     * successful updates. This process is non-transactional and processes as much of the request as
     * possible. If one of the updates in the request cannot be successfully processed, the request
     * is not marked as failed, but the body of the response contains explicit error information for
     * the failed update. Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-update-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateTeamMembersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public BulkUpdateTeamMembersResponse bulkUpdateTeamMembers(
            final BulkUpdateTeamMembersRequest body) throws ApiException, IOException {
        return prepareBulkUpdateTeamMembersRequest(body).execute();
    }

    /**
     * Updates multiple `TeamMember` objects. The updated `TeamMember` objects are returned on
     * successful updates. This process is non-transactional and processes as much of the request as
     * possible. If one of the updates in the request cannot be successfully processed, the request
     * is not marked as failed, but the body of the response contains explicit error information for
     * the failed update. Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#bulk-update-team-members).
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the BulkUpdateTeamMembersResponse response from the API call
     */
    public CompletableFuture<BulkUpdateTeamMembersResponse> bulkUpdateTeamMembersAsync(
            final BulkUpdateTeamMembersRequest body) {
        try { 
            return prepareBulkUpdateTeamMembersRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for bulkUpdateTeamMembers.
     */
    private ApiCall<BulkUpdateTeamMembersResponse, ApiException> prepareBulkUpdateTeamMembersRequest(
            final BulkUpdateTeamMembersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<BulkUpdateTeamMembersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/bulk-update")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, BulkUpdateTeamMembersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Returns a paginated list of `TeamMember` objects for a business. The list can be filtered by
     * the following: - location IDs - `status`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTeamMembersResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public SearchTeamMembersResponse searchTeamMembers(
            final SearchTeamMembersRequest body) throws ApiException, IOException {
        return prepareSearchTeamMembersRequest(body).execute();
    }

    /**
     * Returns a paginated list of `TeamMember` objects for a business. The list can be filtered by
     * the following: - location IDs - `status`.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the SearchTeamMembersResponse response from the API call
     */
    public CompletableFuture<SearchTeamMembersResponse> searchTeamMembersAsync(
            final SearchTeamMembersRequest body) {
        try { 
            return prepareSearchTeamMembersRequest(body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for searchTeamMembers.
     */
    private ApiCall<SearchTeamMembersResponse, ApiException> prepareSearchTeamMembersRequest(
            final SearchTeamMembersRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<SearchTeamMembersResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/search")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.POST))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, SearchTeamMembersResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a `TeamMember` object for the given `TeamMember.id`. Learn about [Troubleshooting
     * the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrieve-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveTeamMemberResponse retrieveTeamMember(
            final String teamMemberId) throws ApiException, IOException {
        return prepareRetrieveTeamMemberRequest(teamMemberId).execute();
    }

    /**
     * Retrieves a `TeamMember` object for the given `TeamMember.id`. Learn about [Troubleshooting
     * the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrieve-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to retrieve.
     * @return    Returns the RetrieveTeamMemberResponse response from the API call
     */
    public CompletableFuture<RetrieveTeamMemberResponse> retrieveTeamMemberAsync(
            final String teamMemberId) {
        try { 
            return prepareRetrieveTeamMemberRequest(teamMemberId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveTeamMember.
     */
    private ApiCall<RetrieveTeamMemberResponse, ApiException> prepareRetrieveTeamMemberRequest(
            final String teamMemberId) throws IOException {
        return new ApiCall.Builder<RetrieveTeamMemberResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/{team_member_id}")
                        .templateParam(param -> param.key("team_member_id").value(teamMemberId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveTeamMemberResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Updates a single `TeamMember` object. The `TeamMember` object is returned on successful
     * updates. Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#update-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateTeamMemberResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateTeamMemberResponse updateTeamMember(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) throws ApiException, IOException {
        return prepareUpdateTeamMemberRequest(teamMemberId, body).execute();
    }

    /**
     * Updates a single `TeamMember` object. The `TeamMember` object is returned on successful
     * updates. Learn about [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#update-a-team-member).
     * @param  teamMemberId  Required parameter: The ID of the team member to update.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateTeamMemberResponse response from the API call
     */
    public CompletableFuture<UpdateTeamMemberResponse> updateTeamMemberAsync(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) {
        try { 
            return prepareUpdateTeamMemberRequest(teamMemberId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateTeamMember.
     */
    private ApiCall<UpdateTeamMemberResponse, ApiException> prepareUpdateTeamMemberRequest(
            final String teamMemberId,
            final UpdateTeamMemberRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateTeamMemberResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/{team_member_id}")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("team_member_id").value(teamMemberId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateTeamMemberResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Retrieves a `WageSetting` object for a team member specified by `TeamMember.id`. Learn about
     * [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting).
     * @param  teamMemberId  Required parameter: The ID of the team member for which to retrieve the
     *         wage setting.
     * @return    Returns the RetrieveWageSettingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public RetrieveWageSettingResponse retrieveWageSetting(
            final String teamMemberId) throws ApiException, IOException {
        return prepareRetrieveWageSettingRequest(teamMemberId).execute();
    }

    /**
     * Retrieves a `WageSetting` object for a team member specified by `TeamMember.id`. Learn about
     * [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#retrievewagesetting).
     * @param  teamMemberId  Required parameter: The ID of the team member for which to retrieve the
     *         wage setting.
     * @return    Returns the RetrieveWageSettingResponse response from the API call
     */
    public CompletableFuture<RetrieveWageSettingResponse> retrieveWageSettingAsync(
            final String teamMemberId) {
        try { 
            return prepareRetrieveWageSettingRequest(teamMemberId).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for retrieveWageSetting.
     */
    private ApiCall<RetrieveWageSettingResponse, ApiException> prepareRetrieveWageSettingRequest(
            final String teamMemberId) throws IOException {
        return new ApiCall.Builder<RetrieveWageSettingResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/{team_member_id}/wage-setting")
                        .templateParam(param -> param.key("team_member_id").value(teamMemberId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, RetrieveWageSettingResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }

    /**
     * Creates or updates a `WageSetting` object. The object is created if a `WageSetting` with the
     * specified `team_member_id` does not exist. Otherwise, it fully replaces the `WageSetting`
     * object for the team member. The `WageSetting` is returned on a successful update. Learn about
     * [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting).
     * @param  teamMemberId  Required parameter: The ID of the team member for which to update the
     *         `WageSetting` object.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWageSettingResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public UpdateWageSettingResponse updateWageSetting(
            final String teamMemberId,
            final UpdateWageSettingRequest body) throws ApiException, IOException {
        return prepareUpdateWageSettingRequest(teamMemberId, body).execute();
    }

    /**
     * Creates or updates a `WageSetting` object. The object is created if a `WageSetting` with the
     * specified `team_member_id` does not exist. Otherwise, it fully replaces the `WageSetting`
     * object for the team member. The `WageSetting` is returned on a successful update. Learn about
     * [Troubleshooting the Team
     * API](https://developer.squareup.com/docs/team/troubleshooting#create-or-update-a-wage-setting).
     * @param  teamMemberId  Required parameter: The ID of the team member for which to update the
     *         `WageSetting` object.
     * @param  body  Required parameter: An object containing the fields to POST for the request.
     *         See the corresponding object definition for field details.
     * @return    Returns the UpdateWageSettingResponse response from the API call
     */
    public CompletableFuture<UpdateWageSettingResponse> updateWageSettingAsync(
            final String teamMemberId,
            final UpdateWageSettingRequest body) {
        try { 
            return prepareUpdateWageSettingRequest(teamMemberId, body).executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for updateWageSetting.
     */
    private ApiCall<UpdateWageSettingResponse, ApiException> prepareUpdateWageSettingRequest(
            final String teamMemberId,
            final UpdateWageSettingRequest body) throws JsonProcessingException, IOException {
        return new ApiCall.Builder<UpdateWageSettingResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/team-members/{team_member_id}/wage-setting")
                        .bodyParam(param -> param.value(body))
                        .bodySerializer(() ->  ApiHelper.serialize(body))
                        .templateParam(param -> param.key("team_member_id").value(teamMemberId)
                                .shouldEncode(true))
                        .headerParam(param -> param.key("Content-Type")
                                .value("application/json").isRequired(false))
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .withAuth(auth -> auth
                                .add("global"))
                        .httpMethod(HttpMethod.PUT))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, UpdateWageSettingResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext) context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}