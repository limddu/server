package controller.action;

import dto.UserCourse;
import dto.UserCourseDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserSubjectListAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uId = Integer.parseInt(request.getParameter("uId"));

        UserCourseDAO userCourseDAO = UserCourseDAO.getInstance();
        List<UserCourse> course_list = userCourseDAO.selectUserSubjectAll(uId);
        request.setAttribute("course_list", course_list);
        request.getRequestDispatcher("/user/student_course.jsp").forward(request, response);
    }
}
