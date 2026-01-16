
public class Player {

    private String nickname;	// The nickname of the player 
    
    /**
     * Constructor
     * It initializes a new Player with a specified nickname.
     * @param nickname The nickname of the player
     */
    public Player(String nickname)
    {
        this.nickname = nickname;
    }
    
    /**
     * This method returns the nickname of the player.
     * @return The player's nickname
     */
    public String getNickname()
    {
        return nickname;
    }
}
