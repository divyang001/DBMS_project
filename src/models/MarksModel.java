package models;

/**
 * Created by divyang on 18/10/16.
 */
public class MarksModel {

    String CourseCode;
    int cat;
    int pbl;
    int fat;
    String grade;
    int attendance;

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getPbl() {
        return pbl;
    }

    public void setPbl(int pbl) {
        this.pbl = pbl;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
