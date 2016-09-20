package com.leapfrog.nikil.attendanceleap.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikil on 9/18/2016.
 */
public class Course {
      @SerializedName("course_id")
    private int courseId;
    @SerializedName("course_name")
    private String CourseName;

    public Course() {
    }

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.CourseName = courseName;
    }

    public int getCourseId() {

        return courseId;
    }

    public void setCourseId(int courseId) {

        this.courseId = courseId;
    }

    public String getCourseName() {

        return CourseName;
    }

    public void setCourseName(String courseName) {

        CourseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", CourseName='" + CourseName + '\'' +
                '}';
    }
}
