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
		System.out.println("Player position is : "+p.position);
		while(p.position<=100)
		p.roll();
	}
}
