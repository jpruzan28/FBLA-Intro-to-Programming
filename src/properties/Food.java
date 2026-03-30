package properties;

import pets.Pet;

/**
 * Creates a food object with a name, version, price, and type
 *
 * @author Jasmine Pruzan, Ishaan Bhalerao, Ellie Lo
 * @version 3/20/2026
 */
public class Food {
    private int version;
    private String foodName;
    private String foodType;
    private double price;

    /**
     * Constructor that initializes food name, type, price, and version
     */
    public Food(String name, String type, double price, int version) {
        foodName = name;
        foodType = type;
        this.price = price;
        this.version = version;
    }

    /**
     * Checks if the correct food was chosen for the pet
     * Uses equalsIgnoreCase so "cat" and "Cat" are treated the same
     */
    public boolean checkType(Pet p) {
        if (p.getType().equalsIgnoreCase(foodType)) {  // ← only change
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increases pet hunger based on which food they chose
     * If wrong food type, hunger goes up half and health goes down
     */
    public void feedPet(Pet p) {
        int currentHunger = p.getHunger();
        int currentHealth = p.getHealth();

        if (checkType(p)) {
            // Correct food type - full hunger boost
            if (version == 4) {
                p.setHunger(currentHunger + 8);
            } else if (version == 3) {
                p.setHunger(currentHunger + 6);
            } else if (version == 2) {
                p.setHunger(currentHunger + 4);
            } else {
                p.setHunger(currentHunger + 2);
            }
        } else {
            // Wrong food type - half hunger boost and health penalty
            if (version == 4) {
                p.setHunger(currentHunger + 4);
                p.setHealth(currentHealth - 4);
            } else if (version == 3) {
                p.setHunger(currentHunger + 3);
                p.setHealth(currentHealth - 3);
            } else if (version == 2) {
                p.setHunger(currentHunger + 2);
                p.setHealth(currentHealth - 2);
            } else {
                p.setHunger(currentHunger + 1);
                p.setHealth(currentHealth - 1);
            }
        }
    }

    // Getters
    public String getName()    { return foodName; }
    public String getType()    { return foodType; }
    public double getPrice()   { return price; }
    public int getVersion()    { return version; }
}