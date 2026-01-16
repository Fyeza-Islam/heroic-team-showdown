
public class NonLiving extends Hero {

    protected static int nonLivingNumber = 0;  // Static variable to track the number of non-living heroes

    /**
     * Constructor
     * It initializes a NonLiving hero with the specified attributes.
     * @param name The name of the hero.
     * @param description The description of the hero.
     * @param health The health value of the hero.
     * @param maxPower The maximum power value of the hero.
     * @param attackAbility The attack ability of the hero.
     * @param index The serial number of the hero.
     */
    public NonLiving(String name, String description, int health, double maxPower, AttackAbility attackAbility, int index) 
    {
        super(name, description, health, maxPower, attackAbility, index);
        nonLivingNumber++; 		// Increment the count of non-living heroes
    }

    /**
     * The method calculates and returns the power of the non-living hero.
     * The power is based solely on the max power, and it is 0 if the health is 0.
     * @return The power of the hero (max power if health is greater than 0, otherwise 0).
     */
    @Override
    public double getPower() 
    {
        if (health > 0) 
        {
            return attackAbility.getMaxPower();
        } 
        else 
        {
            return 0;
        }        
    }

    /**
     * The method returns the string representation of the NonLiving hero.
     * It uses the toString method from the superclass Hero to provide the hero's details.
     * @return The string representation of the NonLiving hero.
     */
    @Override
    public String toString() 
    {
        return super.toString();  
    }
}
