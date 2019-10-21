package game;

public class MyPlayer extends MyCreature implements gameinterfaces.Player{

	protected int healAmount;
	
	public MyPlayer(String name, String description, int hitPoints, int damage, int healAmount) throws Exception {
		
		super(name, description, hitPoints, damage);
		
		if(healAmount <= 0) {
			throw new Exception("Error: Heal needs to be greater than 0.");
		}
		this.healAmount = healAmount;
		
	}
	
	@ Override
	public void heal() {
		
		this.hitPoints += this.healAmount;
		
		System.out.printf("%s is healed by %d%n", this.name, this.healAmount);
		
	}
}
