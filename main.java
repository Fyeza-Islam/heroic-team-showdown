import java.util.Scanner;		// Import Scanner Class to get inputs from the user
import java.io.*;			// Import the java.io package for input and output operations
import java.util.ArrayList;		// Import ArrayList to create an arrayList to store data	
import java.util.Random;		// Import Random Class to randomize health value

public class main {

	public static void main(String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);		// Scanner object for user input
		
		String fileName = "heroes.txt";					// Name of the input file			
		File dataFile = new File(fileName); 			// File object to access the data file
		Scanner inputFile = new Scanner(dataFile);		// Scanner to read from the file
		
		final int MAX_HEROES = 100;						// Maximum number of heroes
		ArrayList<Hero> heroList = new ArrayList<>();	// ArrayList to store Hero objects
		
		// Read heroes from file and create hero objects based on their type
		while(inputFile.hasNext() && Hero.totalNumber < MAX_HEROES)
		{
			String line = inputFile.nextLine();			// Read the next line from the file	
            String[] fields = line.split(", ");
			
            // Parse data from the line
            int index = Integer.parseInt(fields[0]);
            String type = fields[1];
            String name = fields[2];
            String description = fields[3];
            int health = Integer.parseInt(fields[4]);
            double maxPower = Double.parseDouble(fields[5]);
            String attackType = fields[6];
           
            double minPower = 0.00;
            // Check if minPower exists in the file
            if (fields.length >= 8)
            {
            	minPower = Double.parseDouble(fields[7]);
            }
            
            AttackAbility attackAbility = new AttackAbility(maxPower, attackType);
            
            // Create hero based on type
            Hero hero = null;
            
            if(type.equalsIgnoreCase("Human"))
            {
            	hero = new Human(name, description, health, maxPower, attackAbility, index);
            }
            else if(type.equalsIgnoreCase("Monster"))
            {
            	hero = new Monster(name, description, health, maxPower, attackAbility, index, minPower);
            }
            else if(type.equalsIgnoreCase("NonLiving"))
            {
            	hero = new NonLiving(name, description, health, maxPower, attackAbility, index);
            }
            else
            {
            	System.out.println("Invalid Type!");
            }
            
            //Add the created hero to the list
            heroList.add(hero);
		}
		
		inputFile.close();				// Close the file after reading
		
		// Initialize players and teams
		Player player1 = null;
		Player player2 = null;

        Team team1 = null;
        Team team2 = null;
		
		boolean playersInitialized = false; 
        boolean teamsBuilt = false;
        
        int gamesPlayed = 0;			// Counter for the number of games played
        
        int choice = 0;

        // Display the menu options
    	showMenu();
        
    	// Main menu loop for user interaction
    	do 
        {
        	System.out.print("Your choice(1-6): ");
        	

            choice = keyboard.nextInt(); // Get user choice
            System.out.println();

            switch (choice) 
            {
                case 1:
                    showAllCharacters(heroList);
                    break;
                case 2:
                    System.out.println("The total number of non-living objects "
                    		+ "in this game is " + NonLiving.nonLivingNumber);
                    System.out.println();
                    showMenu();
                    break;
                case 3:
                	Player[] players = addPlayers();	// Add two players
                	player1 = players[0]; 
                    player2 = players[1]; 
                    playersInitialized = true;			// Players are now initialized
                    break;
                case 4:
                	// Check if players are initialized before building teams
                	if (!playersInitialized) 
                	{
                		System.out.println("We need more players!");
                        showMenu();
                        break;
                    }
                     
                    team1 = new Team(player1); 
                    team2 = new Team(player2);
                    buildTeams(heroList, player1, player2, team1, team2);
                    teamsBuilt = true;  
                    break;
                case 5:
                	// Check if teams are built before starting the game
                	if (!teamsBuilt) 
                	{
                        System.out.println("We need teams to start the game!");
                        showMenu();
                        break;
                    }
                	else if (!playersInitialized) 
                	{
                        System.out.println("We need more players!");
                        showMenu();
                        break;
                    }
                    startGame(team1, team2, player1, player2);  // Start the game
                    gamesPlayed++;								// Increment the game counter
                    saveGameResult(team1,team2, gamesPlayed);	// Save the game result
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;   
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
        } while (choice != 6);		// Loop until the user chooses to quit
        
	}
	
	/**
	 * This method displays the main menu with options for the game.
	 */
	public static void showMenu()
	{
		System.out.println("----------------------------------------");
        System.out.println("1. Show all characters");
        System.out.println("2. How many non-living?");
        System.out.println("3. Add players to the game");
        System.out.println("4. Build the teams");
        System.out.println("5. Start the game");
        System.out.println("6. Quit");
        System.out.println("----------------------------------------");
	}
	
	/**
	 * This method displays the list of all heroes, including their details. 
	 * @param heroList The list of heroes to display
	 */
	public static void showAllCharacters(ArrayList<Hero> heroList)
	{
		// Display the header
		System.out.println("-------------+---------------+---------+-----------+--------------------------------------");
		System.out.println("     Name       Description	Health	   Power          Attack Ability");
		System.out.println("-------------+---------------+---------+-----------+--------------------------------------");
		
		// Display each hero's details
		for (Hero hero : heroList) 
		{
		    System.out.println(hero.toString());
		}
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println();
		showMenu();
	}
	
	/**
	 * This method prompts the user to enter nicknames for two players and creates player objects.
	 * @return an array of two Player objects
	 */
	public static Player[] addPlayers()
	{
		Scanner keyboard = new Scanner(System.in);
    	String nick1, nick2;
    	
    	// Get valid nicknames for both players
    	do
    	{
        	System.out.println("The first player, please enter your nickname starting with a letter:");
        	nick1 = keyboard.nextLine();
        	
    	} while(nick1.length() == 0 || !Character.isLetter(nick1.charAt(0)));
    	
    	do
    	{
        	System.out.println("The second player, please enter your nickname starting with a letter:");
        	nick2 = keyboard.nextLine();
        	
    	} while(nick2.length() == 0 || !Character.isLetter(nick2.charAt(0)));
        
    	// Create player objects
    	Player player1 = new Player(nick1);
    	Player player2 = new Player(nick2);
    	
    	System.out.println();
    	showMenu();
    	
    	return new Player[] {player1, player2};
	}
	
	/**
	 * This method allows players to take turns and build their teams by selecting heroes. 
	 * @param heroList the list of available heroes
	 * @param player1 the first player
	 * @param player2 the second player
	 * @param team1 the first team
	 * @param team2 the second team
	 */
	public static void buildTeams(ArrayList<Hero> heroList, Player player1, Player player2, Team team1, Team team2)
	{ 
	    Scanner keyboard = new Scanner(System.in);
	    
	    ArrayList<Hero> availableHeroes = new ArrayList<>(heroList);
	    
	    final int TEAM_SIZE = heroList.size() / 2; 		// Calculate team size
	    
	    int choice;
	    int selectionCount = 0;
	    
	    // Loop for selecting heroes until both teams are built
	    while (selectionCount < TEAM_SIZE * 2) 
	    { 
	        if (selectionCount % 2 == 0) 		// Player 1's turn
	        {
	            System.out.println("Hey " + player1.getNickname() + ", it's your turn to add a member to your team...");
	            System.out.println();
	            showAvailableHeroes(availableHeroes);
	            System.out.println();

	            do 
	            {
	                System.out.print("Choose a hero by the number above: ");
	                choice = keyboard.nextInt();
	                System.out.println();

	                // Validate if the chosen hero index is within a valid range
	                if (choice < 1 || choice > getLastIndex(availableHeroes, choice)) 
	                {
	                	// If choice is out of bounds, check if the hero is still available
	                	if(getLastIndex(availableHeroes, choice) != heroList.size())
	                    {
	                    	Hero selectedHero = findHeroByIndex(availableHeroes, choice);
		                    
	                    	// If hero is not available, notify the player
	                    	if (selectedHero == null) 
		                    {
		                        System.out.println("***The hero is not available!***");
		                    } 
		                    else 
		                    {
		                    	// If hero is available, add it to player 1's team and remove it from available heroes
		                    	team1.addMember(selectedHero);
		                        availableHeroes.remove(selectedHero);
		                        break;
		                    }
	                    }
	                    else
	                    {
	                    	// If the choice is invalid, prompt the user to make a valid selection
	                    	System.out.println("Invalid choice. Please choose a valid hero number.");
	                    }
	                } 
	                else 
	                {
	                	// If the choice is within a valid range, attempt to find the selected hero
	                	Hero selectedHero = findHeroByIndex(availableHeroes, choice);
	                    
	                    if (selectedHero == null) 
	                    {
	                        System.out.println("***The hero is not available!***");
	                    } 
	                    else 
	                    {
	                        team1.addMember(selectedHero);
	                        availableHeroes.remove(selectedHero);
	                        break;
	                    }
	                }
	            } while (true);
	        } 
	        else 		// Player 2's turn
	        {
	            System.out.println("Hey " + player2.getNickname() + ", it's your turn to add a member to your team...");
	            System.out.println();
	            showAvailableHeroes(availableHeroes);
	            System.out.println();

	            do 
	            {
	                System.out.print("Choose a hero by the number above: ");
	                choice = keyboard.nextInt();
	                System.out.println();

	                // Validate if the chosen hero index is within a valid range
	                if (choice < 1 || choice > getLastIndex(availableHeroes, choice)) 
	                {
	                	// If choice is out of bounds, check if the hero is still available
	                	if(getLastIndex(availableHeroes, choice) != heroList.size())
	                    {
	                    	Hero selectedHero = findHeroByIndex(availableHeroes, choice);
		                    
		                    if (selectedHero == null) 
		                    {
		                        System.out.println("***The hero is not available!***");
		                    } 
		                    else 
		                    {
		                    	// If hero is available, add it to player 2's team and remove it from available heroes
		                    	team2.addMember(selectedHero);
		                        availableHeroes.remove(selectedHero);
		                        break;
		                    }
	                    }
	                    else
	                    {
	                    	// If the choice is invalid, prompt the user to make a valid selection
	                    	System.out.println("Invalid choice. Please choose a valid hero number.");
	                    }
	                } 
	                else 
	                {
	                	// If the choice is within a valid range, attempt to find the selected hero
	                	Hero selectedHero = findHeroByIndex(availableHeroes, choice);
	                    
	                    if (selectedHero == null) 
	                    {
	                        System.out.println("***The hero is not available!***");
	                    } 
	                    else 
	                    {
	                        team2.addMember(selectedHero);
	                        availableHeroes.remove(selectedHero);
	                        break;
	                    }
	                }
	            } while (true);		// Continue prompting for hero selection until valid hero is chosen
	        }

	        selectionCount++;		// Increment number of selections made
	    }
	    
	    showMenu();	    
	}
	
	/**
	 * This method displays the available heroes that can be added to the teams.
	 * @param availableHeroes the list of available heroes
	 */
	public static void showAvailableHeroes(ArrayList<Hero> availableHeroes) 
	{
		// Display the header
		System.out.println("-------------+---------------+---------+-----------+--------------------------------------");
		System.out.println("     Name       Description	Health	   Power          Attack Ability");
		System.out.println("-------------+---------------+---------+-----------+--------------------------------------");
		
		// Show available heroes
		for (int i = 0; i < availableHeroes.size(); i++) 
        {
            Hero hero = availableHeroes.get(i);
            System.out.println(hero.toString()); 
        }
		
		System.out.println("------------------------------------------------------------------------------------------");
    }
	
	/**
	 * This method returns the last index of the hero in the available heroes list.
	 * @param availableHeroes the list of available heroes
	 * @param index the current index being checked
	 * @return the last index in the list
	 */
	public static int getLastIndex(ArrayList<Hero> availableHeroes, int index)
	{
		int lastIndex = 0;
		
		// Loop through all heroes to find the last index with the matching hero index
		for (Hero hero : availableHeroes) 
		{
	        if (hero.getIndex() == index) 
	        {
	            return hero.getIndex();
	        }
	        
	        lastIndex = hero.getIndex();
	    }
		
		return lastIndex;
	}
	
	/**
	 * This method finds a hero in the available heroes list by index.
	 * @param availableHeroes the list of available heroes
	 * @param index the index of the hero to find
	 * @return the Hero object if found, null otherwise
	 */
	public static Hero findHeroByIndex(ArrayList<Hero> availableHeroes, int index) 
	{
		// Loop through all heroes 
		for (Hero hero : availableHeroes) 
	    {
	        if (hero.getIndex() == index) 
	        {
	            return hero;
	        }
	    }
	    return null;
	}
	
	/**
	 * This method starts the game by setting random health values for heroes and determining the winner.
	 * @param team1 the first team
	 * @param team2 the second team
	 * @param player1 the first player
	 * @param player2 the second player
	 */
	public static void startGame(Team team1, Team team2, Player player1, Player player2)
	{
		Random rand = new Random();		// Random object to randomize health value
		
		// Set random health for each hero in team1
		for (Hero hero : team1.getMembers()) 
		{
	        int randomHealth = rand.nextInt(101); 	// Random health between 0 and 100
	        hero.setHealth(randomHealth);			// Set the hero's health
	    }
	    
		// Set random health for each hero in team2
		for (Hero hero : team2.getMembers()) 
	    {
	        int randomHealth = rand.nextInt(101); 	// Random health between 0 and 100
	        hero.setHealth(randomHealth);			// Set the hero's health
	    }
	    
		// Inform the players that the game has started
		System.out.println("The game started... Heroes may lose their health");
	    System.out.println();
	    System.out.println("After a hard fight, the remaining power of each team is ...");
	    System.out.println();
	    
	    // Display the details of player 1's team
	    System.out.println("This is " + player1.getNickname() + "'s team!");
	    team1.showTeam();
	    System.out.println();
	    System.out.println("The total power of the team is " + String.format("%.2f", team1.getTotalPower()));
	    System.out.println();
	    
	    // Display the details of player 2's team
	    System.out.println("This is " + player2.getNickname() + "'s team!");
	    team2.showTeam();
	    System.out.println();
	    System.out.println("The total power of the team is " + String.format("%.2f", team2.getTotalPower()));
	    System.out.println();
	    System.out.println();
	    
	    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    System.out.println();
	    
	    // Determine the winner based on the total power of the teams
	    if(team1.getTotalPower() > team2.getTotalPower())
	    {
	    	System.out.println("The winner is the player: " + player1.getNickname());
	    	System.out.println("Congratulations " + player1.getNickname() + "!");
	    }
	    else if (team2.getTotalPower() > team1.getTotalPower())
	    {
	    	System.out.println("The winner is the player: " + player2.getNickname());
	    	System.out.println("Congratulations " + player2.getNickname() + "!");
	    }
	    else
	    {
	    	System.out.println("It's a tie!");
	    }
	    
	    System.out.println();
	    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    
	    System.out.println();
	    showMenu();
	}
	
	/**
	 * This method saves the result of a game between two teams to a file.
	 * The game results include team information, the winner, and the game number.
	 * @param team1 The first team
	 * @param team2 The second team
	 * @param gamesPlayed The number of games played
	 * @throws IOException If an I/O error occurs while writing to the file
	 */
	public static void saveGameResult(Team team1,Team team2, int gamesPlayed) throws IOException
	{
		StringBuilder result = new StringBuilder();
		
		// Appending game number to the result
		result.append("Game: " + gamesPlayed + "\n");
		result.append("\n");
		
		// Appending team 1 information
        result.append("Team 1: " + "\n" + team1.getTeamInfo() + "\n");
        
        // Appending team 2 information
        result.append("Team 2: " + "\n" + team2.getTeamInfo() + "\n");
        
        // Determine the winner or if it's a tie
        if((team1.getTotalPower() > team2.getTotalPower()))
		{
        	result.append("Winner: Team 1");
        }
        else if((team2.getTotalPower() > team1.getTotalPower()))
		{
        	result.append("Winner: Team 2");
        }
        else
        {
        	result.append("Tie");
        }
        result.append("\n\n");
        
        // Define the file to save the results to
        String filename = "saved.txt";
        
        // Create FileWriter and PrintWriter for writing the result to the file
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter pw = new PrintWriter(fw);
        
        // Write the result string to the file
        pw.println(result.toString());
       
        // Close the PrintWriter
        pw.close();
	}
}
