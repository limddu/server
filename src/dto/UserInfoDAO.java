package dto;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO {
    private UserInfoDAO() {

    }

    private static UserInfoDAO instance = new UserInfoDAO();

    public static UserInfoDAO getInstance() {
        return instance;
    }

    public int userCheck(int id, String pwd) {
        int result = -1;
        String selectSql = "select pwd from userinfo where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            System.out.println(conn);
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else {
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }

    public Member getMember(String userid) {
        Member member = null;
        String selectSql = "select * from member_info where userid=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                member = new Member(rs.getString("userid"), rs.getString("pwd"),
                        rs.getInt("auth"), rs.getString("ref_url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt,rs);
        }
        return member;
    }

    public int confirmId(String userid) {
        int result = -1;
        String selectSql = "select userid from member_info where userid=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                if(rs.getString("userid")!=null && rs.getString("userid").equals(userid)) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else {
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }

    public int insertUserInfo(UserInfo userInfo) {
        int result = -1;
        String insertSql = "insert into member_info values(null,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, member.getUserid());
            pstmt.setString(2, member.getPwd());
            pstmt.setInt(3, member.getAuth());
            pstmt.setString(4, member.getRef_url());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
        return result;
    }

    public int updateUserInfo(UserInfo userInfo) {
        int result = -1;
        String updateSql = "update userinfo set pwd=?, phone=?, email=? where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, userInfo.getPwd());
            pstmt.setString(2, userInfo.getPhone());
            pstmt.setString(3, userInfo.getEmail());
            pstmt.setInt(4, userInfo.getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
        return result;
    }

    public List<UserInfo> selectAllUserInfo() {
        List<UserInfo> users = new ArrayList<>();
        String selectSql = "select * from userinfo";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(selectSql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt("id"));
                userInfo.setPwd(rs.getString("pwd"));
                userInfo.setMajor(rs.getString("major"));
                userInfo.setPhone(rs.getString("phone"));
                userInfo.setEmail(rs.getString("email"));
                userInfo.setAuth(rs.getInt("auth"));
                users.add(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return users;
    }
}
