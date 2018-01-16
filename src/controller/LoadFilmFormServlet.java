package controller;

import model.FilmEntity;
import model.GenreEntity;
import services.FacadeFilmImpl;
import services.FacadeGenreImpl;
import utils.Validate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/loadListFormServlet")
@MultipartConfig
public class LoadFilmFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo --> se no log no param
        request = setGenresList(request);

        List<String> errors = new ArrayList<>();
        String title = "", genre= "", year= ""; Long id = 0l;
        if(!Validate.checkParam(request,"id").isEmpty()){
            id = Long.valueOf(Validate.checkParam(request,"id"));

            FacadeFilmImpl facadeFilm = new FacadeFilmImpl(FilmEntity.class);
            FilmEntity film = facadeFilm.find(id);

            request.setAttribute("mode","edit");
            request.setAttribute("FilmEntity",film);

            request.getRequestDispatcher(response.encodeURL("LoadFilmForm.jsp")).forward(request,response);
        }
        else if(Validate.checkParam(request,"status").equals("full")){
            errors = new ArrayList<>();
            id = Validate.checkParam(request,"filmId").equals("")? 0 : Long.valueOf(Validate.checkParam(request,"filmId"));
            title = Validate.checkParam(request,"title");
            genre = Validate.checkParam(request,"genre");
            year = Validate.checkParam(request,"year");

            //-------- file upload ---------------------

            final String path = "C:\\\\Users\\\\Utente\\\\Desktop\\\\folders\\\\fileUploadFromWebApplication";
            final Part filePart = request.getPart("cover");
            final String fileName = getFileName(filePart);
            writeFile(path,fileName,filePart);

            //------------------------------------------

            if(!Validate.validateYearFormat(year))
                errors.add("L'anno deve essere un numero valido!");
            if(!Validate.validateYearRange(year))
                errors.add("L'anno deve essere compreso tra il 1990 e il 2017");
            if(!Validate.validateTitle(title))
                errors.add("Il titolo deve essere lungo due caratteri!");
            if(!errors.isEmpty()){
                request.setAttribute("errors",errors);
                request.getRequestDispatcher(response.encodeURL("LoadFilmForm.jsp")).forward(request,response);
            }
            else {
                System.out.println("id dal form -->" + request.getParameter("filmId"));
                FilmEntity dtoFilm = new FilmEntity();

                //todo
                dtoFilm.setId(id);
                dtoFilm.setTitle(title);
                GenreEntity genere = (GenreEntity) new GenreEntity().setId(Integer.parseInt(genre));

                dtoFilm.setGenre(genere);
                dtoFilm.setYear(Integer.parseInt(year));
                dtoFilm.setCover(path + File.separator + File.separator + fileName);

                if(Validate.checkParam(request,"filmId").equals("")){
                    //insert film
                    FacadeFilmImpl facadeFilm = new FacadeFilmImpl(FilmEntity.class);
                    facadeFilm.create(dtoFilm);
                } else{
                    //update film
                    FacadeFilmImpl facadeFilm = new FacadeFilmImpl(FilmEntity.class);
                    facadeFilm.update(dtoFilm);
                }
                response.sendRedirect("listProductServlet");
            }
        } else if(Validate.checkParam(request,"status").equals("empty")){
            //first attempt
            request.getRequestDispatcher(response.encodeURL("LoadFilmForm.jsp")).forward(request,response);

        }
    }
    private String getFileName(final Part part){
        for(String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")){
                return content.substring(content.indexOf("=") + 1).trim().replace("\"","");
            }
        }
        return null;
    }
    private void writeFile(String path, String filename, Part filePart){
        try(OutputStream out = new FileOutputStream(new File(path + File.separator + filename));
            InputStream filecontent = filePart.getInputStream()){

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1 ){
                out.write(bytes,0,read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HttpServletRequest setGenresList(HttpServletRequest request){
        FacadeGenreImpl facadeGenre = new FacadeGenreImpl(GenreEntity.class);
        List<GenreEntity> genres = facadeGenre.findAll();
        request.setAttribute("genres",genres);
        return request;
    }

}
