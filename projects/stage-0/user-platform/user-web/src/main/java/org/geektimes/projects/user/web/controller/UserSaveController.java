package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 用户注册
 */
@Path("/user")
public class UserSaveController implements PageController {

    private UserService userService;

    @GET
    @POST
    @Path("/register") //
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        return "login-form.jsp";
    }

}
