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
}
public class SnakeAndLadder
{
	public static void main(String args[])
	{
    Player p=new Player(1);
		System.out.println("Player position is : "+p.position);
	}
}
