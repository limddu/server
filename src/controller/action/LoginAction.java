package controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/member/login.jsp";
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");

        UserInfoD
        int result = memberDAO.userCheck(userid, pwd);
        if(result==1) {
            Member member = memberDAO.getMember(userid);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", member);
            request.setAttribute("msg", "로그인 성공");
            if(member.getUserid().equals("admin")) {
                request.setAttribute("user", member.getUserid());
                url = "/admin.do";
            } else {
                url = "/elec/elec_input.jsp";
            }
        } else if(result==0) {
            request.setAttribute("msg", "비밀번호가 맞지않습니다.");
        } else {
            request.setAttribute("msg", "존재하지 않는 회원입니다.");
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
