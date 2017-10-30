package dto;

public class UserObjection {
    private int user_course_code;
    private int user_id;
    private int subject_code;
    private String subject_major;
    private String subject_name;
    private int field;
    private String professor;
    private int detail_status;

    public int getUser_course_code() {
        return user_course_code;
    }

    public void setUser_course_code(int user_course_code) {
        this.user_course_code = user_course_code;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(int subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_major() {
        return subject_major;
    }

    public void setSubject_major(String subject_major) {
        this.subject_major = subject_major;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getDetail_status() {
        return detail_status;
    }

    public void setDetail_status(int detail_status) {
        this.detail_status = detail_status;
    }
}
