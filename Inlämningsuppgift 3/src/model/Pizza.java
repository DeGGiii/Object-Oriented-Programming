/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package model;

import java.util.Arrays;

public abstract class Pizza implements IPizza {
    private int costFactor;
    private String[] toppings;
    private int id;

    public Pizza(int id, int costFactor, String[] toppings) {
        this.id = id;
        this.toppings = toppings;
        this.costFactor = costFactor;
    }

    //<editor-fold desc="Getters and Setters">

    public String[] getToppings() {
        return toppings;
    }


    public int getId() {
        return id;
    }

    //</editor-fold

    @Override
    public String toString() {
        return String.format("ID: %s Cost: %s SEK %s", id, costFactor, Arrays.toString(toppings));
    }

}


