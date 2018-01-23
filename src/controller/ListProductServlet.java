package controller;

import model.FilmEntity;
import services.FacadeFilmImpl;
import utils.Comparators;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/listProductServlet")
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String SORT_NUMERIC = "sort_numeric";
        final String SORT_ALPHA = "sort_alpha";
        final String SORT_NORMAL = "sort_normal";

        String orderingType = request.getParameter("orderingType");
        if(orderingType == null)
            orderingType = SORT_NORMAL;


        List<FilmEntity> allElements;

        FacadeFilmImpl facadeFilm = new FacadeFilmImpl(FilmEntity.class);
        allElements = facadeFilm.findAll();

        switch (orderingType){
            case SORT_ALPHA: Collections.sort(allElements, new Comparators.FilmDTOByNameAsc()); break;
            case SORT_NUMERIC: Collections.sort(allElements, new Comparators.FilmDTOByYearAsc()); break;
        }
        request.setAttribute("elements",allElements);
        request.getRequestDispatcher(response.encodeURL("ListProduct.jsp")).forward(request,response);
    }
}
