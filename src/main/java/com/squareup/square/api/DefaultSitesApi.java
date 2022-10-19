
package com.squareup.square.api;

import com.squareup.square.ApiHelper;
import com.squareup.square.Server;
import com.squareup.square.exceptions.ApiException;
import com.squareup.square.http.client.HttpContext;
import com.squareup.square.http.request.HttpMethod;
import com.squareup.square.models.ListSitesResponse;
import io.apimatic.core.ApiCall;
import io.apimatic.core.GlobalConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * This class lists all the endpoints of the groups.
 */
public final class DefaultSitesApi extends BaseApi implements SitesApi {

    /**
     * Initializes the controller.
     * @param globalConfig    Configurations added in client.
     */
    public DefaultSitesApi(GlobalConfiguration globalConfig) {
        super(globalConfig);
    }

    /**
     * Lists the Square Online sites that belong to a seller. Sites are listed in descending order
     * by the `created_at` date. __Note:__ Square Online APIs are publicly available as part of an
     * early access program. For more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @return    Returns the ListSitesResponse response from the API call
     * @throws    ApiException    Represents error response from the server.
     * @throws    IOException    Signals that an I/O exception of some sort has occurred.
     */
    public ListSitesResponse listSites() throws ApiException, IOException {
        return prepareListSitesRequest().execute();
    }

    /**
     * Lists the Square Online sites that belong to a seller. Sites are listed in descending order
     * by the `created_at` date. __Note:__ Square Online APIs are publicly available as part of an
     * early access program. For more information, see [Early access program for Square Online
     * APIs](https://developer.squareup.com/docs/online-api#early-access-program-for-square-online-apis).
     * @return    Returns the ListSitesResponse response from the API call
     */
    public CompletableFuture<ListSitesResponse> listSitesAsync() {
        try { 
            return prepareListSitesRequest().executeAsync(); 
        } catch (Exception e) {  
            throw new CompletionException(e); 
        }
    }

    /**
     * Builds the ApiCall object for listSites.
     */
    private ApiCall<ListSitesResponse, ApiException> prepareListSitesRequest() throws IOException {
        return new ApiCall.Builder<ListSitesResponse, ApiException>()
                .globalConfig(getGlobalConfiguration())
                .requestBuilder(requestBuilder -> requestBuilder
                        .server(Server.ENUM_DEFAULT.value())
                        .path("/v2/sites")
                        .headerParam(param -> param.key("accept").value("application/json"))
                        .authenticationKey(BaseApi.AUTHENTICATION_KEY)
                        .httpMethod(HttpMethod.GET))
                .responseHandler(responseHandler -> responseHandler
                        .deserializer(
                                response -> ApiHelper.deserialize(response, ListSitesResponse.class))
                        .nullify404(false)
                        .contextInitializer((context, result) ->
                                result.toBuilder().httpContext((HttpContext)context).build())
                        .globalErrorCase(GLOBAL_ERROR_CASES))
                .build();
    }
}