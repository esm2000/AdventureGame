package game;

public class MyMonster extends MyCreature implements gameinterfaces.Monster{
	
	protected int enrageThreshold;
	protected boolean isEnraged;
	
	public MyMonster(String name, String description, int hitPoints, int damage, int enrageThreshold) throws Exception {
		
		super(name, description, hitPoints, damage);
		
		if(enrageThreshold > hitPoints) {
			
			throw new Exception("Error: The Enrage Threshold cannot be greater than the monster's HP.");
			
		}
		
		if(enrageThreshold < 0) {
			
			throw new Exception("Error: The Enrage Threshold cannot be negative.");
			
		}
		
		this.enrageThreshold = enrageThreshold;
		this.isEnraged = false;
		
	}
	
	@ Override
	public boolean canEnrage() {
		
		if(this.hitPoints < this.enrageThreshold) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	
	@Override
	public void enrage() {
		
		if(this.isEnraged == false) {
			
			this.damage *= 2;
			this.isEnraged = true;
			
			System.out.println();
			System.out.println("--------------------------------------");
			System.out.println(this.getName() + " is now ENRAGED! Careful...");
			System.out.println("--------------------------------------");
			System.out.println();
		}
		
	}

}
