package game;

import java.util.Scanner;

public class MyBattle implements gameinterfaces.Battle {

	protected MyPlayer player;
	protected MyMonster monster;
	protected Scanner keyboard = new Scanner(System.in);
	
	public MyBattle(MyPlayer player, MyMonster monster) {
		
		this.player = player;
		this.monster = monster;
		
	}
	
	@ Override 
	public void run() throws Exception{
		
		
		char command = 0;
		
		while(this.player.isAlive() || this.monster.isAlive()) {
			
			System.out.printf("%n%s's HP: %d%n%s's HP: %d%n%n", player.getName(), player.getHitPoints(), monster.getName(), monster.getHitPoints());
			
			System.out.println("ATTACK(a) | HEAL(h)");
			
			while(command != 'a' && command != 'h') {
				command = keyboard.next().charAt(0);
				
				if(command != 'a' && command != 'h') {
					throw new Exception("Error: Enter (a) or (h).");
				}
			}
			
			if(command == 'a') {
				this.player.attack(this.monster);
			}
			else if(command == 'h') {
				this.player.heal();
			}
			
			command = 0;
			
			if(this.monster.isAlive() == false) {
				System.out.printf("VICTORY: You have slain the %s%n%n", this.monster.getName());
				break;
			}
			
			if(this.monster.canEnrage()) {
				
				this.monster.enrage();
				
			}
			
			this.monster.attack(this.player);
			
			if(this.player.isAlive() == false) {
				
				System.out.println("\nDEFEAT: You were slain. Better luck next time.");
				break;
				
			}
			
		}
		
	}
}
