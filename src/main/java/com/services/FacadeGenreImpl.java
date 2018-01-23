package com.services;

import com.model.GenreEntity;

public class FacadeGenreImpl extends AbstractFacade<GenreEntity> {

    public FacadeGenreImpl(Class<GenreEntity> entity) {
        super(entity);
    }
}
