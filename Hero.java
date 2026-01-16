
public abstract class Hero {
    
    protected static int totalNumber = 0;		// Static variable to keep track of the total number of heroes created

    protected String name;						// Name of the hero
    protected String description; 				// Description of the hero
    protected int health;						// Health value of the hero
    protected AttackAbility attackAbility;		// Attack ability of the hero
    protected int index;						// Serial number of the hero in the list

    /**
     * Constructor
     * It initializes a new Hero object with the provided attributes. 
     * It also increments the total number of heroes created. 
     * @param name The name of the hero
     * @param description The description of the hero
     * @param health The health of the hero
     * @param maxPower The maximum power the hero can have, based on attack ability
     * @param attackAbility The attack ability of the hero
     * @param index The index assigned to the hero for identification
     */
    public Hero(String name, String description, int health, double maxPower, AttackAbility attackAbility, int index) 
    {
        this.name = name;
        this.description = description;
        this.health = health;
        this.attackAbility = attackAbility;
        this.index = index;
        totalNumber++;  	// Increment the total hero count
    }
    
    /**
     * This method calculates the hero's power, but it must be implemented by subclasses.
     * Each subclass will define how power is calculated.
     * @return The calculated power of the hero
     */
    public abstract double getPower();
    
    /**
     * This method returns the name of the hero.
     * @return The name of the hero
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * This method returns the description of the hero.
     * @return The description of the hero
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * This method returns the health of the hero.
     * @return The health of the hero
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * This method returns the maximum power of the hero, getting from the AttackAbility object.
     * @return The maximum power of the hero
     */
    public double getMaxPower()
    {
        return attackAbility.getMaxPower();
    }
    
    /**
     * This method returns the attack ability of the hero. 
     * @return The attack ability of the hero
     */
    public AttackAbility getAttackAbility()
    {
        return attackAbility;
    }
    
    /**
     * This method returns the index of the hero.
     * @return The index of the hero
     */
    public int getIndex()
    {
        return index;
    }
    
    /**
     * This method sets the health of the hero to the specified value.
     * @param health The new health value for the hero
     */
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    /**
     * This method checks if the hero is a Monster. In the Superclass, it returns false.
     * Subclasses can override this method to return true if the hero is a Monster. 
     * @return False in the Hero class, true for Monster subclass
     */
    public boolean isMonster()
    {
        return false;
    }
    
    /**
     * This method returns the minimum power value for the hero, which is 0.0 in the Hero class.
     * Subclasses may override this if they require a different minimum power.
     * @return The minimum power value, 0.0 in the Hero class
     */
    public double getMinPower()
    {
        return 0.0;
    }
     
    /**
     * This method returns a string representation of the hero, including details such as name, description, health, 
     * maximum power, and attack ability. 
     * @return A string containing the hero's details in a formatted manner
     */
    public String toString() 
    {
        String str = index + ".  " 
                   + name + "\t  " 
                   + description + "\t " 
                   + health + "\t   "
                   + String.format("%.2f", getMaxPower()) + "\t"
                   + attackAbility;
        
        return str;
    }
}
