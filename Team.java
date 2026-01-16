import java.util.ArrayList;		// Import ArrayList to create an arrayList to the team

public class Team {

    private ArrayList<Hero> team;	    // The list of heroes that make up the team 
    private Player player;				// The player in the team

    /**
     * Constructor
     * It initializes a new team for a given player. 
     * @param player The player in the team
     */
    public Team(Player player)
    {
        this.team = new ArrayList<>();
        this.player = player;
    }

    /**
     * This method adds a hero to the team.
     * @param hero The hero to be added to the team
     */
    public void addMember(Hero hero) 
    {
        team.add(hero);
    }

    /**
     * This method returns the members of the team.
     * @return The list of heroes in the team
     */
    public ArrayList<Hero> getMembers() 
    {
        return team;
    }

    /**
     * This method calculates and returns the total power of all heroes in the team.
     * @return The total power of the team as a double
     */
    public double getTotalPower()
    {
        double totalPower = 0;

        // Calculate total power by summing the power of each hero
        for (Hero hero : team) 
        {
            totalPower += hero.getPower();
        }
        return totalPower;
    }

    /**
     * This method displays the team's information, including each hero's name, description, health, 
     * power, and attack ability.
     */
    public void showTeam()
    {
        // Display the header
    	System.out.println("-------------+---------------+---------+-----------+--------------------------------------");
		System.out.println("     Name       Description	Health	   Power          Attack Ability");
		System.out.println("-------------+---------------+---------+-----------+--------------------------------------");

        // Display each hero's information
        for (Hero hero : team) 
        { 
            if (hero.isMonster()) 
            {
                System.out.println("   " + hero.getName() + "\t  " 
                                   + hero.getDescription() + "\t "
                                   + hero.getHealth() + "\t   "
                                   + String.format("%.2f", hero.getPower()) + "         "
                                   + hero.getAttackAbility()
                                   + "  (Min Power: " + String.format("%.2f", hero.getMinPower()) + ")");
            } 
            else 
            {
                System.out.println("   " + hero.getName() + "\t  " 
                                   + hero.getDescription() + "\t "
                                   + hero.getHealth() + "\t   "
                                   + String.format("%.2f", hero.getPower()) + "         "
                                   + hero.getAttackAbility());
            } 
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    /**
     * This method returns the team's information as a formatted string, including each hero's details
     * and the total power of the team. 
     * @return A string representation of the team, including each hero's details and the total power
     */
    public String getTeamInfo()
    {
        StringBuilder teamInfo = new StringBuilder();

        // Append the header
        teamInfo.append("-----------+-----------------+---------+-----------+--------------------------------------\n");
        teamInfo.append("    Name       Description      Health     Power   Attack Ability\n");
        teamInfo.append("-----------+-----------------+---------+-----------+--------------------------------------\n");

        // Append information of each hero to the string
        for (Hero hero : team) 
        {
            if (hero.isMonster())
            {
                teamInfo.append("   ").append(hero.getName()).append("\t\t")
                         .append(hero.getDescription()).append("           ")
                         .append(hero.getHealth()).append("\t   ")
                         .append(String.format("%.2f", hero.getPower())).append("\t\t")
                         .append(hero.getAttackAbility())
                         .append("  (Min Power: ").append(String.format("%.2f", hero.getMinPower())).append(")").append("\n");
            }
            else 
            {
                teamInfo.append("   ").append(hero.getName()).append("\t\t")
                         .append(hero.getDescription()).append("           ")
                         .append(hero.getHealth()).append("\t   ")
                         .append(String.format("%.2f", hero.getPower())).append("\t\t")
                         .append(hero.getAttackAbility()).append("\n");
            }
        }
        teamInfo.append("------------------------------------------------------------------------------------------\n");
        teamInfo.append("\n");

        // Append total power of the team
        teamInfo.append("Total Power: ").append(String.format("%.2f", getTotalPower())).append("\n");

        return teamInfo.toString();
    }
}