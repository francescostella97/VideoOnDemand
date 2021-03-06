package com.controller;

import com.model.Cart;
import com.model.UserEntity;
import com.services.FacadeUserImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            FacadeUserImpl facadeUser = new FacadeUserImpl(UserEntity.class);
            UserEntity user = facadeUser.findUser(username, password);

            if(user != null){
                HttpSession session = request.getSession();
                // set user to the session
                session.setAttribute("user",user);
                // set cart object to the session
                session.setAttribute("cart", new Cart());
                response.sendRedirect(response.encodeURL("home.jsp"));
            }
            else {
                //todo
                //utente inesistente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
