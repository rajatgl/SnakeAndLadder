//Player class to initialize Player attributers
class Player
{
	//initializeing player attributes
	int position=0;
	int id;
  int dieRoll=0;
  Player(int id)
	{
    this.id=id;
  }
	//Randomize options
  int option()
	{
    int fate=(int)((Math.random()*10)%3);
    return fate;
  }
  int roll()
	{
		//Player rolls the die to get number between 1 & 6
		int dieNumber=(int)((Math.random()*10)%6+1);
    dieRoll++;
		//Check for options
    switch (option())
    {
      case 0:
        System.out.println("No Play, Current Position: " + position);
        return 0;
      case 1:
				//Ensuring exact winning position
        if(position+dieNumber>100)
        {
          System.out.println("Ladder (Player exceeded 100), Current Position: " + position + ", Die Rolled: " + dieNumber);
          return dieNumber;
        }
        System.out.println("Ladder, Initial Position: " + position + ", Die Rolled: " + dieNumber + ", Final Position: " + (position + dieNumber));
        position+=dieNumber;
        return dieNumber;
      default:
				//Ensuring player position as 0 even if die roll goes below it
        if(position-dieNumber<0)
        {
          System.out.println("Snake (Player slumped below 0), Current Position: " + position + ", Die Rolled: " + dieNumber + ", Final Position: " + 0);
          position=0;
          return -dieNumber;
        }
        System.out.println("Snake, Initial Position: " + position + ", Die Rolled: " + dieNumber + ", Final Position: " + (position - dieNumber));
        position-=dieNumber;
        return -dieNumber;
    }
	}
}
public class SnakeAndLadder
{
	public static void main(String args[])
	{
    Player p=new Player(1);
    Player p2=new Player(2);
		//Repeating till player reaches winning position 100
    while(p.position!=100&&p2.position!=100)
		{
      int dieRoll = -1;
      System.out.println("\nPlayer " + p.id + ": ");
      dieRoll = p.roll();
      if(dieRoll > 0)
			{
        if(p.position == 100)
          break;
        p.roll();
    	}
      System.out.println("\nPlayer " + p2.id + ": ");
      dieRoll = p2.roll();
      if(dieRoll > 0)
			{
        if(p2.position == 100)
          break;
        p2.roll();
      }
    }
		//Reporting which player won the game
    if(p.position==100)
    System.out.println("\nPlayer "+ p.id +" wins");
    if(p2.position==100)
    System.out.println("\nPlayer "+ p2.id +" wins");
	}
}
