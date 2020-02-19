package com.example.tour_guide_app;

import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable {

    private String SubjectName;
    private String SubjectDescription;
    private String SubjectDetails;
    private int SubjectNumber;
    private int ImageValue;

    public Subject(String subjectName, String subjectDescription, String subjectDetails, int subjectNumber, int imageValue) {
        SubjectName = subjectName;
        SubjectDescription = subjectDescription;
        SubjectDetails = subjectDetails;
        SubjectNumber = subjectNumber;
        ImageValue = imageValue;
    }

    protected Subject(Parcel in) {
        SubjectName = in.readString();
        SubjectDescription = in.readString();
        SubjectDetails = in.readString();
        SubjectNumber = in.readInt();
        ImageValue = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SubjectName);
        dest.writeString(SubjectDescription);
        dest.writeString(SubjectDetails);
        dest.writeInt(SubjectNumber);
        dest.writeInt(ImageValue);
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel in) {
            return new Subject(in);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };

    public int getImageValue() {
        return ImageValue;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getSubjectDescription() {
        return SubjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        SubjectDescription = subjectDescription;
    }

    public String getSubjectDetails() {
        return SubjectDetails;
    }

    public void setSubjectDetails(String subjectDetails) {
        SubjectDetails = subjectDetails;
    }

    public int getSubjectNumber() {
        return SubjectNumber;
    }

    public void setSubjectNumber(int subjectNumber) {
        SubjectNumber = subjectNumber;
    }

    public void setImageValue(int imageValue) {
        ImageValue = imageValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
