package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class LemonadeTests {
    @Test
    public void testCreateLemonade() {
        Lemonade lemonade = new Lemonade();
        assertEquals(4, lemonade.getLemons());
        assertEquals(2, lemonade.getSugar());
        assertEquals(3, lemonade.getIce());
    }

    @Test
    public void testCreateLemonadeWithArgs() {
        Lemonade lemonade = new Lemonade(5, 3, 4);
        assertEquals(5, lemonade.getLemons());
        assertEquals(3, lemonade.getSugar());
        assertEquals(4, lemonade.getIce());
    }

    @Test
    public void testGettersAndSetters() {
        Lemonade lemonade = new Lemonade();
        lemonade.setLemons(5);
        lemonade.setSugar(3);
        lemonade.setIce(4);
        assertEquals(5, lemonade.getLemons());
        assertEquals(3, lemonade.getSugar());
        assertEquals(4, lemonade.getIce());
    }

    @Test
    public void testMix() {
        Lemonade lemonade1 = new Lemonade(5, 3, 4);
        Lemonade lemonade2 = new Lemonade(3, 2, 1);
        Lemonade lemonade3 = Lemonade.mix(lemonade1, lemonade2);
        assertEquals(8, lemonade3.getLemons());
        assertEquals(5, lemonade3.getSugar());
        assertEquals(5, lemonade3.getIce());
    }
// Negative Test case of getting negative count of lemons

@Test
    public void testNegativeLemonsThrowsException(){
        try{
            new Lemonade(-1, 2,3);

            fail("Expected RuntimeException was not thrown");

        } catch (RuntimeException e) {

            assertEquals("Lemons cannot be negative", e.getMessage());
        }
}

    // Edge Cases with all ingredients are set to zero

    @Test
    public void testZeroIngredients() {
        Lemonade lemonade = new Lemonade(0, 0, 0);
        assertEquals(0, lemonade.getLemons());
        assertEquals(0, lemonade.getSugar());
        assertEquals(0, lemonade.getIce());
    }
}
