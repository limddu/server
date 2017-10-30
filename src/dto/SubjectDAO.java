package dto;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
    private SubjectDAO() {

    }

    private static SubjectDAO instance = new SubjectDAO();

    public static SubjectDAO getInstance() {
        return instance;
    }

    public void insertSubject(Subject subject) {
        String insertSql = "INSERT INTO subject VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, subject.getSubject_name());
            pstmt.setInt(2, subject.getField());
            pstmt.setString(3, subject.getSubject_major());
            pstmt.setInt(4, subject.getCredit());
            pstmt.setString(5, subject.getProfessor());
            pstmt.setString(6, subject.getSubject_time());
            pstmt.setString(7, subject.getSubject_room());
            pstmt.setInt(8, subject.getSubject_capacity());
            pstmt.setString(9, subject.getNotice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubject(Subject subject) {
        String updateSql = "UPDATE subject SET sName=?, field=?, sMajor=?, credit=?, prof=?, time=?, sRoom=?, sCap=?, notice=? WHERE sCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, subject.getSubject_name());
            pstmt.setInt(2, subject.getField());
            pstmt.setString(3, subject.getSubject_major());
            pstmt.setInt(4, subject.getCredit());
            pstmt.setString(5, subject.getProfessor());
            pstmt.setString(6, subject.getSubject_time());
            pstmt.setString(7, subject.getSubject_room());
            pstmt.setInt(8, subject.getSubject_capacity());
            pstmt.setString(9, subject.getNotice());
            pstmt.setInt(10, subject.getSubect_code());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Subject> selectAllSubject() {
        String selectSql = "SELECT * FROM subject";
        List<Subject> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubect_code(rs.getInt("sCode"));
                subject.setSubject_name(rs.getString("sName"));
                subject.setField(rs.getInt("field"));
                subject.setSubject_major(rs.getString("sMajor"));
                subject.setCredit(rs.getInt("credit"));
                subject.setProfessor(rs.getString("prof"));
                subject.setSubject_time(rs.getString("time"));
                subject.setSubject_room(rs.getString("sRoom"));
                subject.setSubject_capacity(rs.getInt("sCap"));
                subject.setNotice(rs.getString("notice"));
                list.add(subject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Subject selectOneSubject(int sCode) {
        String selectSql = "SELECT * FROM subject WHERE sCode=?";
        Subject subject = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setInt(1, sCode);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                subject = new Subject();
                subject.setSubect_code(rs.getInt("sCode"));
                subject.setSubject_name(rs.getString("sName"));
                subject.setField(rs.getInt("field"));
                subject.setSubject_major(rs.getString("sMajor"));
                subject.setCredit(rs.getInt("credit"));
                subject.setProfessor(rs.getString("prof"));
                subject.setSubject_time(rs.getString("time"));
                subject.setSubject_room(rs.getString("sRoom"));
                subject.setSubject_capacity(rs.getInt("sCap"));
                subject.setNotice(rs.getString("notice"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public void deleteSubject(int sCode) {
        String deleteSql = "DELETE FROM subject WHERE sCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setInt(1, sCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
