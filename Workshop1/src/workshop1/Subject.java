package workshop1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TienDat
 */
public class Subject {
    String subjectID,subjectName,major;

    public Subject(String subjectID, String subjectName, String major) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.major = major;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "SubjectID: " + subjectID +  "| SubjectName: " + subjectName +  "| Major: " + major + '}';
    }
}
