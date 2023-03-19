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
public class Class {
    String classID,className,course;

    public Class(String classID, String className, String course) {
        this.classID = classID;
        this.className = className;
        this.course = course;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Class ID: " + classID + "| Class Name: " + className + "| Course: " + course;
    }
    
}
