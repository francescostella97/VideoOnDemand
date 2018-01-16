package services;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class AbstractFacadeTest {

    @Test
    public void getEntityManager() {
        EntityManager lab = Persistence.createEntityManagerFactory("lab").createEntityManager();

    }

    @Test
    public void find() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void create() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }

    @Test
    public void remove1() {
    }
}