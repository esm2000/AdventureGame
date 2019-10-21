package game;

public class MyTreasureRoom extends MyRoom implements gameinterfaces.Room {

	protected String treasure;
	
	public MyTreasureRoom(int roomIndex, String description, MyMonster monster, String treasure) throws Exception {
		
		super(roomIndex, description, monster);
		
		this.treasure = treasure;
		
	}
	
	@ Override 
	public void enter(MyPlayer player) throws Exception {
		
		super.enter(player);
		
		if(!monster.isAlive()) {
			
			System.out.printf("CONGRATULATIONS: You have found %s%n", this.treasure);
			
		}
		
	}
	
	
}
