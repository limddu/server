package dto;

public class UserCourse {
    private int code;
    private int user_id;
    private int subject_code;
    private int retake_status;
    private int detail_status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getRetake_status() {
        return retake_status;
    }

    public void setRetake_status(int retake_status) {
        this.retake_status = retake_status;
    }

    public int getDetail_status() {
        return detail_status;
    }

    public void setDetail_status(int detail_status) {
        this.detail_status = detail_status;
    }
}
