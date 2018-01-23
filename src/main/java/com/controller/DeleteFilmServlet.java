package com.controller;

import com.model.FilmEntity;
import com.services.FacadeFilmImpl;
import com.utils.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFilmServlet")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.valueOf(Validate.checkParam(request,"id"));
        System.out.println("deleting film --> " + id);

        FacadeFilmImpl facadeFilm = new FacadeFilmImpl(FilmEntity.class);
        facadeFilm.remove(id);
    }
}
