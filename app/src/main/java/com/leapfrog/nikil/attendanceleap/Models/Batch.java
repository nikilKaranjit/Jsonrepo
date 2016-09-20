package com.leapfrog.nikil.attendanceleap.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Nikil on 9/20/2016.
 */
public class Batch {
    @SerializedName("batch_id")
    private String batchId;
    @SerializedName("batch_code")
    private String batchCode;
    @SerializedName("course_id")
    private int courseId;
    @SerializedName("facilitator_id")
    private int facilitatorId;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("end_date")
    private String endDate;
    @SerializedName("timing_id")
    private int timingId;
    @SerializedName("added_date")
    private String addedDate;
    @SerializedName("modified_date")
    private String modifiedDate;

    public Batch() {

    }

    public Batch(String batchId, String batchCode, int courseId, int facilitatorId, String startDate, String endDate, int timingId, String addedDate, String modifiedDate) {
        this.batchId = batchId;
        this.batchCode = batchCode;
        this.courseId = courseId;
        this.facilitatorId = facilitatorId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timingId = timingId;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
    }

    public String getBatchId() {

        return batchId;
    }

    public void setBatchId(String batchId) {

        this.batchId = batchId;
    }

    public String getBatchCode() {

        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getFacilitatorId() {
        return facilitatorId;
    }

    public void setFacilitatorId(int facilitatorId) {
        this.facilitatorId = facilitatorId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTimingId() {
        return timingId;
    }

    public void setTimingId(int timingId) {
        this.timingId = timingId;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId='" + batchId + '\'' +
                ", batchCode='" + batchCode + '\'' +
                ", courseId=" + courseId +
                ", facilitatorId=" + facilitatorId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", timingId=" + timingId +
                ", addedDate='" + addedDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
