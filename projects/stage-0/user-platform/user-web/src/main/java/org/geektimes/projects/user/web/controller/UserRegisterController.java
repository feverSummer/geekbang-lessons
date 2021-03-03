package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Map;

/**
 * 用户注册
 */
@Path("/user")
public class UserRegisterController implements PageController {



    @GET
    @POST
    @Path("/save") //
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        Map<String, String[]>  param = request.getParameterMap();
        String passs = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setEmail(email);
        user.setPassword(passs);
        UserServiceImpl userService = new UserServiceImpl();
        boolean flag = userService.register(user);
        if(flag){
          return "froword";
        }
        return "login-form.jsp";
    }

}
