package model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();
    FilmEntity f1 = (FilmEntity) new FilmEntity().setTitle("f1").setId(1L);
    FilmEntity f2 = (FilmEntity) new FilmEntity().setTitle("f1").setId(2L);
    FilmEntity f3 = (FilmEntity) new FilmEntity().setTitle("f1").setId(2L);

    @Test
    public void addItem() {
        Assert.assertTrue(cart.addItem(f1));
        Assert.assertTrue(cart.addItem(f2));
        Assert.assertFalse(cart.addItem(f3));

        cart.removeAllItems();

        Assert.assertTrue(cart.getItemCount() == 0);
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void getItemCount() {
    }

    @Test
    public void getItemTotalAmount() {
        cart = new Cart();
        Assert.assertTrue(cart.getItemTotalAmount() == 0);
    }
}