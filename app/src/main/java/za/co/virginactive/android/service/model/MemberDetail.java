package za.co.virginactive.android.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberDetail {

    @SerializedName("clientNo")
    @Expose
    private Integer clientNo;
    @SerializedName("idNo")
    @Expose
    private String idNo;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("birthdate")
    @Expose
    private String birthdate;
    @SerializedName("reciprocityType")
    @Expose
    private String reciprocityType;
    @SerializedName("homeClubCostCentreCode")
    @Expose
    private Integer homeClubCostCentreCode;
    @SerializedName("latestContractNumber")
    @Expose
    private String latestContractNumber;
    @SerializedName("latestContractEndDate")
    @Expose
    private String latestContractEndDate;

    public Integer getClientNo() {
        return clientNo;
    }

    public void setClientNo(Integer clientNo) {
        this.clientNo = clientNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getReciprocityType() {
        return reciprocityType;
    }

    public void setReciprocityType(String reciprocityType) {
        this.reciprocityType = reciprocityType;
    }

    public Integer getHomeClubCostCentreCode() {
        return homeClubCostCentreCode;
    }

    public void setHomeClubCostCentreCode(Integer homeClubCostCentreCode) {
        this.homeClubCostCentreCode = homeClubCostCentreCode;
    }

    public String getLatestContractNumber() {
        return latestContractNumber;
    }

    public void setLatestContractNumber(String latestContractNumber) {
        this.latestContractNumber = latestContractNumber;
    }

    public String getLatestContractEndDate() {
        return latestContractEndDate;
    }

    public void setLatestContractEndDate(String latestContractEndDate) {
        this.latestContractEndDate = latestContractEndDate;
    }
}
