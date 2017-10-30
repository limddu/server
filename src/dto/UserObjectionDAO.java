package dto;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserObjectionDAO {
    private UserObjectionDAO() {

    }

    private static UserObjectionDAO instance = new UserObjectionDAO();

    public static UserObjectionDAO getInstance() {
        return instance;
    }

    public List<UserObjection> selectAllUserObjection() {
        String selectSql = "SELECT * FROM userobjection";
        List<UserObjection> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                UserObjection userObjection = new UserObjection();
                userObjection.setUser_course_code(rs.getInt("user_course_code"));
                userObjection.setUser_id(rs.getInt("user_id"));
                userObjection.setSubject_code(rs.getInt("subject_code"));
                userObjection.setDetail_status(rs.getInt("detail_status"));
                userObjection.setSubject_name(rs.getString("subject_name"));
                userObjection.setField(rs.getInt("field"));
                userObjection.setSubject_major(rs.getString("subject_major"));
                userObjection.setProfessor(rs.getString("professor"));
                list.add(userObjection);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserObjection selectOneUserObjection(int user_course_code, int user_id) {
        String selectSql = "SELECT * FROM userobjection WHERE user_course_code=? AND user_id=?";
        UserObjection userObjection = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setInt(1, user_course_code);
            pstmt.setInt(2, user_id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                userObjection = new UserObjection();
                userObjection.setUser_course_code(rs.getInt("user_course_code"));
                userObjection.setUser_id(rs.getInt("user_id"));
                userObjection.setSubject_code(rs.getInt("subject_code"));
                userObjection.setDetail_status(rs.getInt("detail_status"));
                userObjection.setSubject_name(rs.getString("subject_name"));
                userObjection.setField(rs.getInt("field"));
                userObjection.setSubject_major(rs.getString("subject_major"));
                userObjection.setProfessor(rs.getString("professor"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userObjection;
    }
}
