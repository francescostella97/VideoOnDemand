package services;

import model.GenreEntity;

public class FacadeGenreImpl extends AbstractFacade<GenreEntity> {

    public FacadeGenreImpl(Class<GenreEntity> entity) {
        super(entity);
    }
}
