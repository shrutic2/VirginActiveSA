package za.co.virginactive.android.service.repository;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import za.co.virginactive.android.service.ServiceConstants;
import za.co.virginactive.android.service.model.ClubDetails;
import za.co.virginactive.android.service.model.ClubLists;
import za.co.virginactive.android.service.model.ClubOccupancy;
import za.co.virginactive.android.service.model.LoginToken;
import za.co.virginactive.android.service.model.MemberDetail;

public interface ApiInterface {

    String HTTPS_API_BASE_URL = "https://vasa-hip-dev.azurewebsites.net";
    //String HTTPS_OCCUPANCY_API_BASE_URL = "vasa-app-accessqr-dev.azurewebsites.net";
    String HTTPS_AUTH_BASE_URL = "http://vasa-app-vareopening-prod-staging.azurewebsites.net";

    //https://vasa-hip-dev.azurewebsites.net/api/branchminimal
    //https://vasa-hip-dev.azurewebsites.net/api/clubs/301
    //https://vasa-app-accessqr-dev.azurewebsites.net/Api/occupancy/club/MilPark
    //https://vasa-app-accessqr-dev.azurewebsites.net/api/occupancyhistory/281

    /***
     * Get All clubs api call
     */
    @GET("/api/clubs")
    Call<List<ClubLists>> getAllClubs(@Header(ServiceConstants.tokenKey) String key);

    /***
     * Get club information by Id api call
     */
    @GET("api/clubs/" + "{clubId}")
    Call<ClubDetails> getClubById(@Header(ServiceConstants.tokenKey) String key,
                                  @Path("clubId") String clubId);

    /***
     * Get club occupancy information by Name api call
     */
    @GET("/Api/Clubs/" + "{costCenter}" + "/occupancy")
    Call<ClubOccupancy> getClubOccupancyById(@Header(ServiceConstants.tokenKey) String key,
                                               @Path("costCenter") String clubName);

    /***
     * Get club occupancy information by Name api call
     */
    @GET("/Api/occupancyhistory/" + "{clubId}")
    Call<List<ClubLists>> getClubOccupancyHistoryById(@Header(ServiceConstants.tokenKey) String key,
                                      @Path("clubName") String clubName);

    @POST("/api/token.php")
    Call<LoginToken> getLoginToken(@Body String body);

    @GET("api/membership/client/basic/{memberId}")
    Call<MemberDetail> getMemberDetail(@Header(ServiceConstants.tokenKey) String key,
                                       @Path("memberId") String memberId);

}
