package org.example;

public class LemonadeStand {
    public static int defaultStartingSugar = 10;
    public static int defaultStartingIce = 10;
    public static int defaultStartingLemons = 10;

    public static double pricePerLemon = 0.50;
    public static double pricePerSugar = 0.50;
    public static double pricePerIce = 0.20;

    private int sugar;
    private int ice;
    private int lemons;

    private double money = 0.0;

    public LemonadeStand() {
        this.sugar = defaultStartingSugar;
        this.ice = defaultStartingIce;
        this.lemons = defaultStartingLemons;
    }

    public LemonadeStand(int lemons, int sugar, int ice) {
        this.lemons = lemons;
        this.sugar = sugar;
        this.ice = ice;
    }

    public int getSugar() {
        return sugar;
    }

    public int getIce() {
        return ice;
    }

    public int getLemons() {
        return lemons;
    }

    public double getMoney() {
        return money;
    }

    public void buySupplies(int lemons, int sugar, int ice) {
        if (lemons < 0){
            throw new RuntimeException("Lemons cannot be negative");
        }
        this.lemons += lemons;
        this.sugar += sugar;
        this.ice += ice;

        double cost = (lemons * pricePerLemon) + (sugar * pricePerSugar) + (ice * pricePerIce);
        money -= cost;
    }

    public boolean sellLemonade() {
        Lemonade lemonade = new Lemonade();

        if (tryMakingLemonade(lemonade) != null) {
            money += calculateSale(lemonade);
            return true;
        } else {
            return false;
        }
    }


    public boolean sellLemonade(int lemons,int sugar, int ice){
        //Creating a new lemonade object with given amounts
        Lemonade lemonade = new Lemonade(lemons, sugar, ice);
        //Making lemonade
        if (tryMakingLemonade(lemonade) != null){
            money += calculateSale(lemonade);
            return true;
        } else {
            return false;
        }
    }
    // Create an overloaded method for sellLemonade that takes three arguments: lemons, sugar, and ice.
    // This method should create a new Lemonade object with the given arguments and then attempt to make the lemonade.
    // If the lemonade is successfully made, the method should add the sale amount to the money field and return true.
    //
    // HINT: You can copy and paste the body of the sellLemonade method and should only need to modify the first line.

    private Lemonade tryMakingLemonade(Lemonade lemonade) {
        if (sugar >= lemonade.getSugar() && ice >= lemonade.getIce() && lemons >= lemonade.getLemons()) {
            sugar -= lemonade.getSugar();
            ice -= lemonade.getIce();
            lemons -= lemonade.getLemons();
            return lemonade;
        } else {
            return null;
        }
    }

    private double calculateSale(Lemonade lemonade) {
        return (lemonade.getSugar() * pricePerSugar) + (lemonade.getIce() * pricePerIce) + (lemonade.getLemons() * pricePerLemon);
    }
}
