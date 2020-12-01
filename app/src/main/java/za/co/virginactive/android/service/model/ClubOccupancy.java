package za.co.virginactive.android.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClubOccupancy {
    @SerializedName("clubId")
    @Expose
    private Integer clubId;
    @SerializedName("clubName")
    @Expose
    private String clubName;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("maxLimit")
    @Expose
    private Integer maxLimit;
    @SerializedName("occupancy")
    @Expose
    private Integer occupancy;
    @SerializedName("costCenterCode")
    @Expose
    private String costCentreCode;
    @SerializedName("occupancyHistory")
    @Expose
    private OccupancyHistory occupancyHistory;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Integer maxLimit) {
        this.maxLimit = maxLimit;
    }

    public Integer getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Integer occupancy) {
        this.occupancy = occupancy;
    }

    public String getCostCentreCode() {
        return costCentreCode;
    }

    public void setCostCentreCode(String costCentreCode) {
        this.costCentreCode = costCentreCode;
    }

    public OccupancyHistory getOccupancyHistory() {
        return occupancyHistory;
    }

    public void setOccupancyHistory(OccupancyHistory occupancyHistory) {
        this.occupancyHistory = occupancyHistory;
    }

    public class Fri {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }

    public class Mon {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }

    public class OccupancyHistory {

        @SerializedName("sun")
        @Expose
        private List<Sun> sun = null;
        @SerializedName("mon")
        @Expose
        private List<Mon> mon = null;
        @SerializedName("tue")
        @Expose
        private List<Tue> tue = null;
        @SerializedName("wed")
        @Expose
        private List<Wed> wed = null;
        @SerializedName("thu")
        @Expose
        private List<Thu> thu = null;
        @SerializedName("fri")
        @Expose
        private List<Fri> fri = null;
        @SerializedName("sat")
        @Expose
        private List<Sat> sat = null;

        public List<Sun> getSun() {
            return sun;
        }

        public void setSun(List<Sun> sun) {
            this.sun = sun;
        }

        public List<Mon> getMon() {
            return mon;
        }

        public void setMon(List<Mon> mon) {
            this.mon = mon;
        }

        public List<Tue> getTue() {
            return tue;
        }

        public void setTue(List<Tue> tue) {
            this.tue = tue;
        }

        public List<Wed> getWed() {
            return wed;
        }

        public void setWed(List<Wed> wed) {
            this.wed = wed;
        }

        public List<Thu> getThu() {
            return thu;
        }

        public void setThu(List<Thu> thu) {
            this.thu = thu;
        }

        public List<Fri> getFri() {
            return fri;
        }

        public void setFri(List<Fri> fri) {
            this.fri = fri;
        }

        public List<Sat> getSat() {
            return sat;
        }

        public void setSat(List<Sat> sat) {
            this.sat = sat;
        }

    }

    public class Sat {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }

    public class Sun {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }

    public class Thu {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }

    public class Tue {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }

    public class Wed {

        @SerializedName("periodSlot")
        @Expose
        private Integer periodSlot;
        @SerializedName("capacity")
        @Expose
        private Integer capacity;

        public Integer getPeriodSlot() {
            return periodSlot;
        }

        public void setPeriodSlot(Integer periodSlot) {
            this.periodSlot = periodSlot;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }

    }


}
