
public class Monster extends Hero {

    private double minPower;

    /**
     * Constructor
     * It initializes a Monster hero with the specified attributes.
     * @param name The name of the hero.
     * @param description The description of the hero.
     * @param health The health value of the hero.
     * @param maxPower The maximum power value of the hero.
     * @param attackAbility The attack ability of the hero.
     * @param index The serial number of the hero.
     * @param minPower The minimum power value of the hero.
     */
    public Monster(String name, String description, int health, double maxPower, AttackAbility attackAbility, int index, double minPower) 
    {
        super(name, description, health, maxPower, attackAbility, index);
        this.minPower = minPower;
    }

    /**
     * The method returns whether the hero is a Monster.
     * This method is specific to the Monster class.
     * @return true if the hero is a Monster, false otherwise.
     */
    @Override
    public boolean isMonster()
    {
        return true;
    }
    
    /**
     * The method returns the minimum power of the Monster hero.
     * @return The minimum power value of the hero.
     */
    @Override
    public double getMinPower()
    {
        return minPower;
    }

    /**
     * The method calculates and returns the power of the monster hero.
     * The power is dependent on the hero's health. If health is high, the power is at max;
     * as health decreases, the power decreases proportionally until reaching the minimum power.
     * @return The power of the hero based on health.
     */
    @Override
    public double getPower() 
    {
        if (health >= 75) 
        {
            return attackAbility.getMaxPower();
        } 
        else if (health >= 50) 
        {
            return attackAbility.getMaxPower() / 2;
        } 
        else if (health >= 25) 
        {
            return attackAbility.getMaxPower() / 4;
        } 
        else if (health > 0) 
        {
            return minPower;
        } 
        else 
        {
            return 0;
        }
    }

    /**
     * The method returns the string representation of the Monster hero.
     * It uses the toString method from the superclass Hero to provide the hero's details.
     * It includes all the details of the hero, along with the minimum power value.
     * @return The string representation of the Monster hero.
     */
    @Override
    public String toString() 
    {
        return super.toString() + "  (Min Power: " + String.format("%.2f", minPower) + ")";
    }
}
