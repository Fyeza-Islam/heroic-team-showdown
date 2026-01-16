
public class Human extends Hero {
    
    /**
     * Constructor
     * It initializes a Human hero with the specified attributes.
     * @param name The name of the hero.
     * @param description The description of the hero.
     * @param health The health value of the hero.
     * @param maxPower The maximum power value of the hero.
     * @param attackAbility The attack ability of the hero.
     * @param index The serial number of the hero.
     */
    public Human(String name, String description, int health, double maxPower, AttackAbility attackAbility, int index) 
    {
        super(name, description, health, maxPower, attackAbility, index);
    }

    /**
     * The method calculates and returns the power of the human hero.
     * @return The power of the hero.
     */
    @Override
    public double getPower() 
    {
        return attackAbility.getMaxPower() * (health / 100.0);
    }
    
    /**
     * The method returns the string representation of the Human hero.
     * It uses the toString method from the superclass Hero to provide the hero's details.
     * @return The string representation of the Human hero.
     */
    @Override
    public String toString() 
    {
        return super.toString();
    }
}
