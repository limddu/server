package dto;

public class Subject {
    private int subect_code;
    private String subject_name;
    private int field;
    private String subject_major;
    private int credit;
    private String professor;
    private String subject_time;
    private String subject_room;
    private int subject_capacity;
    private String notice;

    public int getSubect_code() {
        return subect_code;
    }

    public void setSubect_code(int subect_code) {
        this.subect_code = subect_code;
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

    public String getSubject_major() {
        return subject_major;
    }

    public void setSubject_major(String subject_major) {
        this.subject_major = subject_major;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSubject_time() {
        return subject_time;
    }

    public void setSubject_time(String subject_time) {
        this.subject_time = subject_time;
    }

    public String getSubject_room() {
        return subject_room;
    }

    public void setSubject_room(String subject_room) {
        this.subject_room = subject_room;
    }

    public int getSubject_capacity() {
        return subject_capacity;
    }

    public void setSubject_capacity(int subject_capacity) {
        this.subject_capacity = subject_capacity;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
