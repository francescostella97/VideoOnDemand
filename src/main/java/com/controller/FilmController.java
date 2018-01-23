package com.controller;

import com.model.FilmEntity;
import com.model.GenreEntity;
import com.services.FacadeFilmImpl;
import com.services.FacadeGenreImpl;
import com.utils.Comparators;
import com.utils.OrderingType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("item")
public class FilmController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getItemList(@RequestParam(value = "orderingType", required = false, defaultValue = "SORT_NORMAL") String orderingType,
                              Model model){
        OrderingType type = OrderingType.valueOf(orderingType);
        FacadeFilmImpl facadeFilm = new FacadeFilmImpl(FilmEntity.class);
        List<FilmEntity> allElements = facadeFilm.findAll();
        switch (type){
            case SORT_ALPHA: Collections.sort(allElements, new Comparators.FilmDTOByNameAsc()); break;
            case SORT_NUMERIC: Collections.sort(allElements, new Comparators.FilmDTOByYearAsc()); break;
        }
        model.addAttribute("films",allElements);
        return "ListProduct";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAddItemForm(Model model){
        model.addAttribute("item",new FilmEntity());
        model.addAttribute("genres", new FacadeGenreImpl(GenreEntity.class).findAll());
        return "LoadFilmForm";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(@Valid FilmEntity item, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("item",item);
            model.addAttribute("genres", new FacadeGenreImpl(GenreEntity.class).findAll());
            return "LoadFilmForm";
        }
        //todo save film
        return "home";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String getEditItemForm(@PathVariable(value = "id") long id, Model model){
        FilmEntity item = new FacadeFilmImpl(FilmEntity.class).find(id);
        model.addAttribute("item",item);
        model.addAttribute("genres", new FacadeGenreImpl(GenreEntity.class).findAll());
        return "LoadFilmForm";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable(value = "id") long id,
                           @Valid FilmEntity item,
                           BindingResult result,
                           Model model){

        if(result.hasErrors()){
            model.addAttribute("item",item);
            model.addAttribute("genres", new FacadeGenreImpl(GenreEntity.class).findAll());
            return "LoadFilmForm";
        }
        //todo update film
        return "home";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "id") long id){
        System.out.println(id);
        //todo delete film
        return "home";
    }


}
