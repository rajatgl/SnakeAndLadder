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
	int option()
	{
		int fate=(int)((Math.random()*10)%3);
		return fate;
	}
	int roll()
	{
		//Player rolls the die to get number between 1 & 6
		int dieNumber=(int)((Math.random()*10)%6+1);
		switch (option())
		{
			case 0:
				System.out.println("No Play");
				break;
			case 1:
				System.out.println("Ladder");
				break;
			default:
				System.out.println("Snake")
		}
	}
}
public class SnakeAndLadder
{
	public static void main(String args[])
	{
    Player p=new Player(1);
		System.out.println("Player position is : "+p.position);
		p.roll();
	}
}
