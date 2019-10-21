package game;


public class MyCreature implements gameinterfaces.Creature {

	protected String name;
	protected String description;
	protected int hitPoints;
	protected int damage;
	protected gameinterfaces.Room room;
	
	public MyCreature(String name, String description, int hitPoints, int damage) throws Exception {
		
		this.name = name;
		this.description = description;
		
		if(hitPoints <= 0) {
			
			throw new Exception("Error: HP needs to be greater than 0.");
			
		}
		
		this.hitPoints = hitPoints;
		
		if(damage <= 0) {
			
			throw new Exception("Error: Damage needs to be greater than 0.");
			
		}
		
		this.damage = damage;
		
	}
	
	@ Override
	public void attack(MyCreature creature) {
		
		String string = String.format("%s attacks target %s, dealing %d damage", this.name, creature.getName(), this.damage);
		
		System.out.println(string);
		
		creature.takeDamage(this.getDamage());
		
	}
	
	@ Override 
	public void takeDamage(int damage){
		
		if(damage > this.hitPoints) {
			this.hitPoints = 0;
		}
		else {
			this.hitPoints -= damage;
		}
		
	}
	
	@ Override
	public boolean isAlive() {
		 
		if(hitPoints > 0) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	@ Override
	public String toString() {
		
		String string = String.format("name %15s, description %20s, hitPoints %03d, damage %02d%n", this.name, this.description, this.hitPoints, this.damage);
		
		return string;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getDescription() {
		
		return this.description;
		
	}
	
	public int getHitPoints() {
		
		return this.hitPoints;
	}
	
	public void setHitPoints(int hitPoints) throws Exception{
		
		if(hitPoints <= 0) {
			throw new Exception("Error: HP needs to be greater than 0.");
		}
		else {
			this.hitPoints = hitPoints;
		}
		
	}
	
	public int getDamage() {
		
		return this.damage;
		
	}
	
	public void setDamage(int damage) throws Exception{
		
		if(damage <= 0) {
			throw new Exception("Error: Damage needs to be greater than 0.");
		}
		else {
			this.damage = damage;
		}
		
	}
	
	public gameinterfaces.Room getRoom() {
		
		return this.room;
	}
	
	public void setRoom(gameinterfaces.Room room) {
		
		this.room = room;
		
	}

}
