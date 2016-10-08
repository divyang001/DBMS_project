package models;

/**
 * Created by divyang on 7/9/16.
 */
public class FacultyModel {

    public int getFaculty_id() {
        return Faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        Faculty_id = faculty_id;
    }

    public String getFaculty_name() {
        return Faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        Faculty_name = faculty_name;
    }

    public String getFaculty_mobile() {
        return Faculty_mobile;
    }

    public void setFaculty_mobile(String faculty_mobile) {
        Faculty_mobile = faculty_mobile;
    }

    public String getFaculty_special() {
        return Faculty_special;
    }

    public void setFaculty_special(String faculty_special) {
        Faculty_special = faculty_special;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    int Faculty_id;
    String Faculty_name;
    String Faculty_mobile;
    String Faculty_special;
    String project;
    String school;
}
