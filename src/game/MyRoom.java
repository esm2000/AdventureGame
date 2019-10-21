package game;

public class MyRoom implements gameinterfaces.Room{

	protected int roomIndex;
	protected String description;
	protected MyMonster monster;
	
	public MyRoom(int roomIndex, String description, MyMonster monster) throws Exception{
		
		if(roomIndex < 0) {
			throw new Exception("Error: Invalid Room Index.");
		}
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;

	}
	
	@ Override 
	public boolean isComplete() {
		
		if(!this.monster.isAlive()) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
	}
	
	@ Override
	public void enter(MyPlayer player) throws Exception{
		
		System.out.printf("\"%s\", This Room is %s and has a(n) %s%n", player.getName(), this.description, this.monster.getName());
		
		MyBattle battle = new MyBattle(player, this.monster);
		
		battle.run();
	}
	
	public String toString() {
		
		return String.format("Room index %2d, description %20s, monster name %20s%n", this.roomIndex, this.description, this.monster.getName());
		
	}
	
	
	
	
}
