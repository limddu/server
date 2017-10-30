package dto;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCourseDAO {
    private UserCourseDAO() {

    }

    private static UserCourseDAO instance = new UserCourseDAO();

    public static UserCourseDAO getInstance() {
        return instance;
    }

    public void insertUserSubject(UserCourse userCourse) {
        String insertSql = "INSERT INTO usersubject VALUES (NULL,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setInt(1, userCourse.getUser_id());
            pstmt.setInt(2, userCourse.getSubject_code());
            pstmt.setInt(3, userCourse.getRetake_status());
            pstmt.setInt(4, userCourse.getDetail_status());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubjectRetake(UserCourse userCourse) {
        String updateSql = "UPDATE usersubject SET retStatus=? WHERE uId=? AND sCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, userCourse.getRetake_status());
            pstmt.setInt(2, userCourse.getUser_id());
            pstmt.setInt(3, userCourse.getSubject_code());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubjectDetails(UserCourse userCourse) {
        String updateSql = "UPDATE usersubject SET detStatus=? WHERE uId=? AND sCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, userCourse.getDetail_status());
            pstmt.setInt(2, userCourse.getUser_id());
            pstmt.setInt(3, userCourse.getSubject_code());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserCourse> selectAllUserSubject() {
        String selectSql = "SELECT * FROM usersubject";
        List<UserCourse> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserCourse userCourse = new UserCourse();
                userCourse.setCode(rs.getInt("usCode"));
                userCourse.setUser_id(rs.getInt("uId"));
                userCourse.setSubject_code(rs.getInt("sCode"));
                userCourse.setRetake_status(rs.getInt("retStatus"));
                userCourse.setDetail_status(rs.getInt("detStatus"));
                list.add(userCourse);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<UserCourse> selectUserSubjectAll(int uId) {
        String selectSql = "SELECT * FROM usersubject WHERE uId=?";
        List<UserCourse> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setInt(1, uId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserCourse userCourse = new UserCourse();
                userCourse.setCode(rs.getInt("usCode"));
                userCourse.setUser_id(rs.getInt("uId"));
                userCourse.setSubject_code(rs.getInt("sCode"));
                userCourse.setRetake_status(rs.getInt("retStatus"));
                userCourse.setDetail_status(rs.getInt("detStatus"));
                list.add(userCourse);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserCourse selectOneUserSubject(int uId, int sCode) {
        String selectSql = "SELECT * FROM usersubject WHERE uId=? AND sCode=?";
        UserCourse userCourse = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setInt(1, sCode);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userCourse = new UserCourse();
                userCourse.setCode(rs.getInt("usCode"));
                userCourse.setUser_id(rs.getInt("uId"));
                userCourse.setSubject_code(rs.getInt("sCode"));
                userCourse.setRetake_status(rs.getInt("retStatus"));
                userCourse.setDetail_status(rs.getInt("detStatus"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCourse;
    }

    public void deleteUserSubject(int uId, int sCode) {
        String deleteSql = "DELETE FROM usersubject WHERE uId=? AND sCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setInt(1, uId);
            pstmt.setInt(2, sCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
