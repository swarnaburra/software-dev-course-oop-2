package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class LemonadeStandTests {
    @Test
    public void testCreateLemonadeStand() {
        LemonadeStand lemonadeStand = new LemonadeStand();
        assertEquals(LemonadeStand.defaultStartingLemons, lemonadeStand.getLemons());
        assertEquals(LemonadeStand.defaultStartingSugar, lemonadeStand.getSugar());
        assertEquals(LemonadeStand.defaultStartingIce, lemonadeStand.getIce());
    }

    @Test
    public void testCreateLemonadeStandWithArgs() {
        LemonadeStand lemonadeStand = new LemonadeStand(5, 3, 4);
        assertEquals(5, lemonadeStand.getLemons());
        assertEquals(3, lemonadeStand.getSugar());
        assertEquals(4, lemonadeStand.getIce());
    }

    @Test
    public void testBuySupplies() {
        LemonadeStand lemonadeStand = new LemonadeStand();
        lemonadeStand.buySupplies(5, 3, 4);
        assertEquals(LemonadeStand.defaultStartingLemons + 5, lemonadeStand.getLemons());
        assertEquals(LemonadeStand.defaultStartingSugar + 3, lemonadeStand.getSugar());
        assertEquals(LemonadeStand.defaultStartingIce + 4, lemonadeStand.getIce());
    }

    @Test
    public void testSellLemonade() {
        LemonadeStand lemonadeStand = new LemonadeStand();
        boolean result = lemonadeStand.sellLemonade();
        assertTrue(result);
        assertEquals(LemonadeStand.defaultStartingLemons - Lemonade.defaultLemons, lemonadeStand.getLemons());
        assertEquals(LemonadeStand.defaultStartingSugar - Lemonade.defaultSugar, lemonadeStand.getSugar());
        assertEquals(LemonadeStand.defaultStartingIce - Lemonade.defaultIce, lemonadeStand.getIce());

        assertEquals((Lemonade.defaultLemons * LemonadeStand.pricePerLemon) + (Lemonade.defaultSugar * LemonadeStand.pricePerSugar) + (Lemonade.defaultIce * LemonadeStand.pricePerIce), lemonadeStand.getMoney(), 0.01);
    }

    @Test
    public void testSellLemonadeNotEnoughSupplies() {
        LemonadeStand lemonadeStand = new LemonadeStand(1, 1, 1);
        boolean result = lemonadeStand.sellLemonade();
        assertFalse(result);
        assertEquals(1, lemonadeStand.getLemons());
        assertEquals(1, lemonadeStand.getSugar());
        assertEquals(1, lemonadeStand.getIce());
        assertEquals(0, lemonadeStand.getMoney(), 0.01);
    }

    @Test
    public void testSellLemonadeCustom() {
        LemonadeStand lemonadeStand = new LemonadeStand();
        boolean result = lemonadeStand.sellLemonade(5, 3, 4);
        assertTrue(result);
        assertEquals(LemonadeStand.defaultStartingLemons - 5, lemonadeStand.getLemons());
        assertEquals(LemonadeStand.defaultStartingSugar - 3, lemonadeStand.getSugar());
        assertEquals(LemonadeStand.defaultStartingIce - 4, lemonadeStand.getIce());
        assertEquals((5 * LemonadeStand.pricePerLemon) + (3 * LemonadeStand.pricePerSugar) + (4 * LemonadeStand.pricePerIce), lemonadeStand.getMoney(), 0.01);
    }

    @Test
    public void testSellLemonadeCustomNotEnoughSupplies() {
        LemonadeStand lemonadeStand = new LemonadeStand(1, 1, 1);
        boolean result = lemonadeStand.sellLemonade(5, 3, 4);
        assertFalse(result);
        assertEquals(1, lemonadeStand.getLemons());
        assertEquals(1, lemonadeStand.getSugar());
        assertEquals(1, lemonadeStand.getIce());
        assertEquals(0, lemonadeStand.getMoney(), 0.01);
    }

    //Negative test case with lemons set to negative count

    @Test
    public void testBuySuppliesNegativeThrowsException() {
        LemonadeStand lemonadeStand = new LemonadeStand();
        try {
            lemonadeStand.buySupplies(-1, 10, 10);
            fail("Expected RuntimeException for negative lemons");
        } catch (RuntimeException e) {
            assertEquals("Lemons cannot be negative", e.getMessage());
        }

    }
    // Edge case with all ingredients set to zero

        @Test
        public void testSellLemonadeCustomEdgeZero () {
            LemonadeStand lemonadeStand = new LemonadeStand(0, 0, 0);
            boolean result = lemonadeStand.sellLemonade(0, 0, 0);
            assertTrue(result); // should succeed because zero ingredients
            assertEquals(0, lemonadeStand.getLemons());
            assertEquals(0, lemonadeStand.getSugar());
            assertEquals(0, lemonadeStand.getIce());
        }
    }

