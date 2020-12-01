package za.co.virginactive.android.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClubLists {

    @SerializedName("clubId")
    @Expose
    private Integer clubId;
    @SerializedName("clubName")
    @Expose
    private String clubName;
    @SerializedName("costCenterCode")
    @Expose
    private String costCenterCode;
    @SerializedName("gpsCoordinatesLatitude")
    @Expose
    private String gpsCoordinatesLatitude;
    @SerializedName("gpsCoordinatesLongitude")
    @Expose
    private String gpsCoordinatesLongitude;

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getGpsCoordinatesLatitude() {
        return gpsCoordinatesLatitude;
    }

    public void setGpsCoordinatesLatitude(String gpsCoordinatesLatitude) {
        this.gpsCoordinatesLatitude = gpsCoordinatesLatitude;
    }

    public String getGpsCoordinatesLongitude() {
        return gpsCoordinatesLongitude;
    }

    public void setGpsCoordinatesLongitude(String gpsCoordinatesLongitude) {
        this.gpsCoordinatesLongitude = gpsCoordinatesLongitude;
    }

    /*@SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("branch_name")
    @Expose
    private String branchName;
    @SerializedName("cost_centre_code")
    @Expose
    private String costCentreCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("gps_coordinates_latitude")
    @Expose
    private String gpsCoordinatesLatitude;
    @SerializedName("gps_coordinates_longitude")
    @Expose
    private String gpsCoordinatesLongitude;
    @SerializedName("open_to_public")
    @Expose
    private Boolean openToPublic;
    @SerializedName("telephone_number")
    @Expose
    private String telephoneNumber;
    @SerializedName("geographic_region")
    @Expose
    private String geographicRegion;
    @SerializedName("region")
    @Expose
    private String region;

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCostCentreCode() {
        return costCentreCode;
    }

    public void setCostCentreCode(String costCentreCode) {
        this.costCentreCode = costCentreCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGpsCoordinatesLatitude() {
        return gpsCoordinatesLatitude;
    }

    public void setGpsCoordinatesLatitude(String gpsCoordinatesLatitude) {
        this.gpsCoordinatesLatitude = gpsCoordinatesLatitude;
    }

    public String getGpsCoordinatesLongitude() {
        return gpsCoordinatesLongitude;
    }

    public void setGpsCoordinatesLongitude(String gpsCoordinatesLongitude) {
        this.gpsCoordinatesLongitude = gpsCoordinatesLongitude;
    }

    public Boolean getOpenToPublic() {
        return openToPublic;
    }

    public void setOpenToPublic(Boolean openToPublic) {
        this.openToPublic = openToPublic;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getGeographicRegion() {
        return geographicRegion;
    }

    public void setGeographicRegion(String geographicRegion) {
        this.geographicRegion = geographicRegion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

*/
}
