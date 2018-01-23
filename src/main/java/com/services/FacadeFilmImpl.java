package com.services;

import com.model.FilmEntity;

public class FacadeFilmImpl extends AbstractFacade<FilmEntity>{

    public FacadeFilmImpl(Class<FilmEntity> entity) {
        super(entity);
    }
}
