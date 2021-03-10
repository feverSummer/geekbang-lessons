package org.geektimes.projects.user.web.controller;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
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
public class UserSaveController implements PageController {


    @Resource(name = "bean/UserService")
    private UserService userService =ComponentContext.getInstance().getComponent("bean/UserService");;

    @GET
    @POST
    @Path("/save") //
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        Map<String, String[]>  param = request.getParameterMap();
        String passs = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        User user = new User();
        user.setId(1l);
        user.setName("Think");
        user.setPhoneNumber(phone);
        user.setEmail(email);
        user.setPassword(passs);

        boolean flag = userService.register(user);
//        if(flag){
//          return "froword";
//        }
        return "login-form.jsp";
    }

}
