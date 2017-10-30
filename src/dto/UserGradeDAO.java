package dto;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGradeDAO {
    private UserGradeDAO() {

    }

    private static UserGradeDAO instance = new UserGradeDAO();

    public static UserGradeDAO getInstance() {
        return instance;
    }

    public void insertGrade(UserGrade userGrade) {
        String insertSql = "INSERT INTO usergrade VALUES (NULL,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setInt(1, userGrade.getUser_id());
            pstmt.setInt(2, userGrade.getSubject_code());
            pstmt.setInt(3, userGrade.getScore());
            pstmt.setInt(4, userGrade.getScore_type());
            pstmt.setInt(5, userGrade.getPeriod());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGrade(UserGrade userGrade) {
        String updateSql = "UPDATE usergrade SET score=?, scoreType=? WHERE ugCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, userGrade.getScore());
            pstmt.setInt(2, userGrade.getScore_type());
            pstmt.setInt(3, userGrade.getCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserGrade> selectAllGrade() {
        String selectSql = "SELECT * FROM usergrade";
        List<UserGrade> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserGrade userGrade = new UserGrade();
                userGrade.setCode(rs.getInt("code"));
                userGrade.setUser_id(rs.getInt("user_id"));
                userGrade.setSubject_code(rs.getInt("subject_code"));
                userGrade.setScore(rs.getInt("score"));
                userGrade.setScore_type(rs.getInt("score_type"));
                userGrade.setPeriod(rs.getInt("period"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserGrade selectOneGrade(int ugCode) {
        String selectSql = "SELECT * FROM usergrade WHERE ugCode=?";
        UserGrade userGrade = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setInt(1, ugCode);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userGrade = new UserGrade();
                userGrade.setCode(rs.getInt("code"));
                userGrade.setUser_id(rs.getInt("user_id"));
                userGrade.setSubject_code(rs.getInt("subject_code"));
                userGrade.setScore(rs.getInt("score"));
                userGrade.setScore_type(rs.getInt("score_type"));
                userGrade.setPeriod(rs.getInt("period"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userGrade;
    }

    public void deleteGrade(int ugCode) {
        String deleteSql = "DELETE FROM usergrade WHERE ugCode=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setInt(1, ugCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int updatePeriod(UserGrade userGrade) {
        String updateSql = "UPDATE usergrade SET period=? WHERE ugCode=?";
        int result = -1;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, userGrade.getPeriod());
            pstmt.setInt(2, userGrade.getCode());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
