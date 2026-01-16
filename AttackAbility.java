
public class AttackAbility {

    private double maxPower;  			// The maximum power of the hero
    private AttackType attackType; 		// The type of attack 

    /**
     * Constructor
     * It initializes the attack ability with the specified maximum power and attack type.
     * @param maxPower The maximum power of the attack.
     * @param attackType The type of the attack (as a string).
     */
    public AttackAbility(double maxPower, String attackType) 
    {
        this.maxPower = maxPower;
        this.attackType = AttackType.valueOf(attackType);  // Converts the string to an AttackType enum
    }

    /**
     * The method returns the maximum power of the attack.
     * @return The maximum power of the attack.
     */
    public double getMaxPower() 
    {
        return maxPower;
    }
    
    /**
     * The method returns a string representation of the attack type.
     * It will convert the attack type to a String.
     * @return The string representation of the attack type.
     */
    public String toString()
    {
        // Return the appropriate string for the attack type
        if (attackType == AttackType.ElectroShock) 
        {
            return "ElectroShock";
        } 
        else if (attackType == AttackType.HydroForce) 
        {
            return "HydroForce";
        } 
        else if (attackType == AttackType.MagneticPulse) 
        {
            return "MagneticPulse";
        } 
        else if (attackType == AttackType.PyroControl) 
        {
            return "PyroControl";
        }
        else 
        {
            return "Unknown";  // In case the attack type is not recognized
        }
    }
}
