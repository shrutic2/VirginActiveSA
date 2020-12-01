package za.co.virginactive.android.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClubDetails {

    @SerializedName("clubId")
    @Expose
    private Integer clubId;
    @SerializedName("clubName")
    @Expose
    private String clubName;
    @SerializedName("club_Name_Alternate")
    @Expose
    private String clubNameAlternate;
    @SerializedName("costCenterCode")
    @Expose
    private String costCenterCode;
    @SerializedName("short_Code")
    @Expose
    private String shortCode;
    @SerializedName("branch_Type")
    @Expose
    private BranchType branchType;
    @SerializedName("sales_Region")
    @Expose
    private String salesRegion;
    @SerializedName("geographic_Region")
    @Expose
    private GeographicRegion geographicRegion;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("fax")
    @Expose
    private Object fax;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("open_To_Public")
    @Expose
    private Boolean openToPublic;
    @SerializedName("presales_OpeningDate")
    @Expose
    private String presalesOpeningDate;
    @SerializedName("opening_Date")
    @Expose
    private String openingDate;
    @SerializedName("legal_Entity")
    @Expose
    private LegalEntity legalEntity;
    @SerializedName("cache_Server_IP")
    @Expose
    private String cacheServerIP;
    @SerializedName("legacy_ClubNo")
    @Expose
    private Integer legacyClubNo;
    @SerializedName("gpS_Coordinates_latitude")
    @Expose
    private String gpSCoordinatesLatitude;
    @SerializedName("gpS_Coordinates_longitude")
    @Expose
    private String gpSCoordinatesLongitude;
    @SerializedName("indicative_price")
    @Expose
    private Integer indicativePrice;
    @SerializedName("operatingTimes")
    @Expose
    private List<OperatingTimes> operatingTimes;

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

    public String getClubNameAlternate() {
        return clubNameAlternate;
    }

    public void setClubNameAlternate(String clubNameAlternate) {
        this.clubNameAlternate = clubNameAlternate;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public void setBranchType(BranchType branchType) {
        this.branchType = branchType;
    }

    public String getSalesRegion() {
        return salesRegion;
    }

    public void setSalesRegion(String salesRegion) {
        this.salesRegion = salesRegion;
    }

    public GeographicRegion getGeographicRegion() {
        return geographicRegion;
    }

    public void setGeographicRegion(GeographicRegion geographicRegion) {
        this.geographicRegion = geographicRegion;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getFax() {
        return fax;
    }

    public void setFax(Object fax) {
        this.fax = fax;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getOpenToPublic() {
        return openToPublic;
    }

    public void setOpenToPublic(Boolean openToPublic) {
        this.openToPublic = openToPublic;
    }

    public String getPresalesOpeningDate() {
        return presalesOpeningDate;
    }

    public void setPresalesOpeningDate(String presalesOpeningDate) {
        this.presalesOpeningDate = presalesOpeningDate;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getCacheServerIP() {
        return cacheServerIP;
    }

    public void setCacheServerIP(String cacheServerIP) {
        this.cacheServerIP = cacheServerIP;
    }

    public Integer getLegacyClubNo() {
        return legacyClubNo;
    }

    public void setLegacyClubNo(Integer legacyClubNo) {
        this.legacyClubNo = legacyClubNo;
    }

    public String getGpSCoordinatesLatitude() {
        return gpSCoordinatesLatitude;
    }

    public void setGpSCoordinatesLatitude(String gpSCoordinatesLatitude) {
        this.gpSCoordinatesLatitude = gpSCoordinatesLatitude;
    }

    public String getGpSCoordinatesLongitude() {
        return gpSCoordinatesLongitude;
    }

    public void setGpSCoordinatesLongitude(String gpSCoordinatesLongitude) {
        this.gpSCoordinatesLongitude = gpSCoordinatesLongitude;
    }

    public Integer getIndicativePrice() {
        return indicativePrice;
    }

    public void setIndicativePrice(Integer indicativePrice) {
        this.indicativePrice = indicativePrice;
    }

    /*public OperatingTimes getOperatingTimes() {
        return operatingTimes;
    }

    public void setOperatingTimes(OperatingTimes operatingTimes) {
        this.operatingTimes = operatingTimes;
    }*/

    public List<OperatingTimes> getOperatingTimes() {
        return operatingTimes;
    }

    public void setOperatingTimes(List<OperatingTimes> operatingTimes) {
        this.operatingTimes = operatingTimes;
    }

    public class GeographicRegion {

        @SerializedName("region_Id")
        @Expose
        private String regionId;
        @SerializedName("region_Name")
        @Expose
        private String regionName;

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }

    }

    public class LegalEntity {

        @SerializedName("legal_Entity_Id")
        @Expose
        private Integer legalEntityId;
        @SerializedName("legal_Entity_Name")
        @Expose
        private String legalEntityName;
        @SerializedName("legal_Entity_Vat_Reg_No")
        @Expose
        private String legalEntityVatRegNo;
        @SerializedName("legal_Entity_Company_Reg_No")
        @Expose
        private String legalEntityCompanyRegNo;
        @SerializedName("legal_Entity_Company_Reg_Type")
        @Expose
        private String legalEntityCompanyRegType;
        @SerializedName("legal_Entity_Company_Acronym")
        @Expose
        private String legalEntityCompanyAcronym;

        public Integer getLegalEntityId() {
            return legalEntityId;
        }

        public void setLegalEntityId(Integer legalEntityId) {
            this.legalEntityId = legalEntityId;
        }

        public String getLegalEntityName() {
            return legalEntityName;
        }

        public void setLegalEntityName(String legalEntityName) {
            this.legalEntityName = legalEntityName;
        }

        public String getLegalEntityVatRegNo() {
            return legalEntityVatRegNo;
        }

        public void setLegalEntityVatRegNo(String legalEntityVatRegNo) {
            this.legalEntityVatRegNo = legalEntityVatRegNo;
        }

        public String getLegalEntityCompanyRegNo() {
            return legalEntityCompanyRegNo;
        }

        public void setLegalEntityCompanyRegNo(String legalEntityCompanyRegNo) {
            this.legalEntityCompanyRegNo = legalEntityCompanyRegNo;
        }

        public String getLegalEntityCompanyRegType() {
            return legalEntityCompanyRegType;
        }

        public void setLegalEntityCompanyRegType(String legalEntityCompanyRegType) {
            this.legalEntityCompanyRegType = legalEntityCompanyRegType;
        }

        public String getLegalEntityCompanyAcronym() {
            return legalEntityCompanyAcronym;
        }

        public void setLegalEntityCompanyAcronym(String legalEntityCompanyAcronym) {
            this.legalEntityCompanyAcronym = legalEntityCompanyAcronym;
        }

    }

    public class OperatingTimes {

        @SerializedName("day")
        @Expose
        private String day;
        @SerializedName("openingTime")
        @Expose
        private String openingTime;
        @SerializedName("closingTime")
        @Expose
        private String closingTime;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(String openingTime) {
            this.openingTime = openingTime;
        }

        public String getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(String closingTime) {
            this.closingTime = closingTime;
        }

        /*@SerializedName("tuesday_Closing_Time")
        @Expose
        private String tuesdayClosingTime;
        @SerializedName("wednesday_Opening_Time")
        @Expose
        private String wednesdayOpeningTime;
        @SerializedName("wednesday_Closing_Time")
        @Expose
        private String wednesdayClosingTime;
        @SerializedName("thursday_Opening_Time")
        @Expose
        private String thursdayOpeningTime;
        @SerializedName("thursday_Closing_Time")
        @Expose
        private String thursdayClosingTime;
        @SerializedName("friday_Opening_Time")
        @Expose
        private String fridayOpeningTime;
        @SerializedName("friday_Closing_Time")
        @Expose
        private String fridayClosingTime;
        @SerializedName("saturday_Opening_Time")
        @Expose
        private String saturdayOpeningTime;
        @SerializedName("saturday_Closing_Time")
        @Expose
        private String saturdayClosingTime;
        @SerializedName("sunday_Opening_Time")
        @Expose
        private String sundayOpeningTime;
        @SerializedName("sunday_Closing_Time")
        @Expose
        private String sundayClosingTime;
        @SerializedName("public_Holiday_Opening_Time")
        @Expose
        private String publicHolidayOpeningTime;
        @SerializedName("public_Holiday_Closing_Time")
        @Expose
        private String publicHolidayClosingTime;

        public String getMondayOpeningTime() {
            return mondayOpeningTime;
        }

        public void setMondayOpeningTime(String mondayOpeningTime) {
            this.mondayOpeningTime = mondayOpeningTime;
        }

        public String getMondayClosingTime() {
            return mondayClosingTime;
        }

        public void setMondayClosingTime(String mondayClosingTime) {
            this.mondayClosingTime = mondayClosingTime;
        }

        public String getTuesdayOpeningTime() {
            return tuesdayOpeningTime;
        }

        public void setTuesdayOpeningTime(String tuesdayOpeningTime) {
            this.tuesdayOpeningTime = tuesdayOpeningTime;
        }

        public String getTuesdayClosingTime() {
            return tuesdayClosingTime;
        }

        public void setTuesdayClosingTime(String tuesdayClosingTime) {
            this.tuesdayClosingTime = tuesdayClosingTime;
        }

        public String getWednesdayOpeningTime() {
            return wednesdayOpeningTime;
        }

        public void setWednesdayOpeningTime(String wednesdayOpeningTime) {
            this.wednesdayOpeningTime = wednesdayOpeningTime;
        }

        public String getWednesdayClosingTime() {
            return wednesdayClosingTime;
        }

        public void setWednesdayClosingTime(String wednesdayClosingTime) {
            this.wednesdayClosingTime = wednesdayClosingTime;
        }

        public String getThursdayOpeningTime() {
            return thursdayOpeningTime;
        }

        public void setThursdayOpeningTime(String thursdayOpeningTime) {
            this.thursdayOpeningTime = thursdayOpeningTime;
        }

        public String getThursdayClosingTime() {
            return thursdayClosingTime;
        }

        public void setThursdayClosingTime(String thursdayClosingTime) {
            this.thursdayClosingTime = thursdayClosingTime;
        }

        public String getFridayOpeningTime() {
            return fridayOpeningTime;
        }

        public void setFridayOpeningTime(String fridayOpeningTime) {
            this.fridayOpeningTime = fridayOpeningTime;
        }

        public String getFridayClosingTime() {
            return fridayClosingTime;
        }

        public void setFridayClosingTime(String fridayClosingTime) {
            this.fridayClosingTime = fridayClosingTime;
        }

        public String getSaturdayOpeningTime() {
            return saturdayOpeningTime;
        }

        public void setSaturdayOpeningTime(String saturdayOpeningTime) {
            this.saturdayOpeningTime = saturdayOpeningTime;
        }

        public String getSaturdayClosingTime() {
            return saturdayClosingTime;
        }

        public void setSaturdayClosingTime(String saturdayClosingTime) {
            this.saturdayClosingTime = saturdayClosingTime;
        }

        public String getSundayOpeningTime() {
            return sundayOpeningTime;
        }

        public void setSundayOpeningTime(String sundayOpeningTime) {
            this.sundayOpeningTime = sundayOpeningTime;
        }

        public String getSundayClosingTime() {
            return sundayClosingTime;
        }

        public void setSundayClosingTime(String sundayClosingTime) {
            this.sundayClosingTime = sundayClosingTime;
        }

        public String getPublicHolidayOpeningTime() {
            return publicHolidayOpeningTime;
        }

        public void setPublicHolidayOpeningTime(String publicHolidayOpeningTime) {
            this.publicHolidayOpeningTime = publicHolidayOpeningTime;
        }

        public String getPublicHolidayClosingTime() {
            return publicHolidayClosingTime;
        }

        public void setPublicHolidayClosingTime(String publicHolidayClosingTime) {
            this.publicHolidayClosingTime = publicHolidayClosingTime;
        }*/

    }

    public class Address {

        @SerializedName("address_type")
        @Expose
        private String addressType;
        @SerializedName("address_Line_1")
        @Expose
        private String addressLine1;
        @SerializedName("address_Line_2")
        @Expose
        private String addressLine2;
        @SerializedName("address_Line_3")
        @Expose
        private String addressLine3;
        @SerializedName("postcode")
        @Expose
        private String postcode;
        @SerializedName("country_Id")
        @Expose
        private Integer countryId;

        public String getAddressType() {
            return addressType;
        }

        public void setAddressType(String addressType) {
            this.addressType = addressType;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getAddressLine3() {
            return addressLine3;
        }

        public void setAddressLine3(String addressLine3) {
            this.addressLine3 = addressLine3;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

    }

    public class BranchType {

        @SerializedName("branch_Type_Id")
        @Expose
        private Integer branchTypeId;
        @SerializedName("branch_Type_Name")
        @Expose
        private String branchTypeName;

        public Integer getBranchTypeId() {
            return branchTypeId;
        }

        public void setBranchTypeId(Integer branchTypeId) {
            this.branchTypeId = branchTypeId;
        }

        public String getBranchTypeName() {
            return branchTypeName;
        }

        public void setBranchTypeName(String branchTypeName) {
            this.branchTypeName = branchTypeName;
        }

    }

    public class Country {

        @SerializedName("country_Id")
        @Expose
        private Object countryId;
        @SerializedName("country_Name")
        @Expose
        private String countryName;
        @SerializedName("country_Code")
        @Expose
        private String countryCode;
        @SerializedName("age_Of_Majority")
        @Expose
        private Object ageOfMajority;

        public Object getCountryId() {
            return countryId;
        }

        public void setCountryId(Object countryId) {
            this.countryId = countryId;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Object getAgeOfMajority() {
            return ageOfMajority;
        }

        public void setAgeOfMajority(Object ageOfMajority) {
            this.ageOfMajority = ageOfMajority;
        }

    }

}
