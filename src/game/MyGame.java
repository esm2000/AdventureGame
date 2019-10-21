package game;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class MyGame implements gameinterfaces.Game {

	protected MyPlayer player;
	protected MyRoom[] dungeon;

	public MyGame() throws IOException, Exception {

		FileInputStream fi = null;
		Scanner fis = null;
		FileInputStream fi2 = null;
		Scanner fis2 = null;

		
		String name = "";
		String description = "";
		int hitPoints = 0;
		int damage = 0;
		int healAmount = 0;
		
		/*
		String name = "Kratos";
		String description = "A powerful warrior";
		int hitPoints = 100;
		int damage = 15;
		int healAmount = 30;
		*/ 
		
		try {
			//System.out.println(1);
			fi = new FileInputStream("PlayerInfo.txt");
			//System.out.println(2);
			fis = new Scanner(fi);

			//System.out.println(3);
			name = fis.nextLine();
			//System.out.println(4);
			description = fis.nextLine();
			//System.out.println(5);
			hitPoints = fis.nextInt();
			//System.out.println(6);
			damage = fis.nextInt();
			//System.out.println(7);
			healAmount = fis.nextInt();

		} catch (FileNotFoundException except) {
			System.out.println("Error: File not Found.");
		} catch (Exception except) {
			System.out.println("Error: " + except.getMessage());
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fi != null) {
				fi.close();
			}
		}

		this.player = new MyPlayer(name, description, hitPoints, damage, healAmount);

		
		String name1 = "";
		String description1 = "";
		int hitPoints1 = 0;
		int damage1 = 0;
		int enrageThreshold1 = 0;

		int roomIndex1 = 0;
		String roomDescription1 = "";

		String name2 = "";
		String description2 = "";
		int hitPoints2 = 0;
		int damage2 = 0;
		int enrageThreshold2 = 0;

		int roomIndex2 = 1;
		String roomDescription2 = "";

		String name3 = "";
		String description3 = "";
		int hitPoints3 = 0;
		int damage3 = 0;
		int enrageThreshold3 = 0;

		int roomIndex3 = 2;
		String roomDescription3 = "";
		String treasure = "";
		
		/*
		String name1 = "orc";
		String description1 = "covered with green blood";
		int hitPoints1 = 20;
		int damage1 = 5;
		int enrageThreshold1 = 0;

		int roomIndex1 = 0;
		String roomDescription1 = "a room with an unbearable smell";

		String name2 = "Skeleton";
		String description2 = "Funny how it moves";
		int hitPoints2 = 40;
		int damage2 = 10;
		int enrageThreshold2 = 10;

		int roomIndex2 = 1;
		String roomDescription2 = "Dark and cold";

		String name3 = "Fire Dragon";
		String description3 = "Spout fire with each breath";
		int hitPoints3 = 100;
		int damage3 = 20;
		int enrageThreshold3 = 40;

		int roomIndex3 = 2;
		String roomDescription3 = "a giant hall with something shiny on the other end";
		String treasure = "a large pile of gold";
		*/
		
		fi2 = null;
		fis2 = null;

		try {
			fi2 = new FileInputStream("DungeonDetails.txt");
			fis2 = new Scanner(fi2);

			name1 = fis2.nextLine();
			description1 = fis2.nextLine();
			hitPoints1 = fis2.nextInt();
			damage1 = fis2.nextInt();
			enrageThreshold1 = fis2.nextInt();
			fis2.nextLine();
			
			roomDescription1 = fis2.nextLine();

			name2 = fis2.nextLine();
			description2 = fis2.nextLine();
			hitPoints2 = fis2.nextInt();
			damage2 = fis2.nextInt();
			enrageThreshold2 = fis2.nextInt();
			fis2.nextLine();

			roomDescription2 = fis2.nextLine();

			name3 = fis2.nextLine();
			description3 = fis2.nextLine();
			hitPoints3 = fis2.nextInt();
			damage3 = fis2.nextInt();
			enrageThreshold3 = fis2.nextInt();
			fis2.nextLine();

			roomDescription3 = fis2.nextLine();
			treasure = fis2.nextLine();

		} catch (FileNotFoundException except) {
			System.out.println("Error: File not Found.");
		} catch (Exception except) {
			System.out.println("Error: " + except.getMessage());
		} finally {
			if (fi2 != null) {
				fi2.close();
			}
		}

		MyMonster monster1 = new MyMonster(name1, description1, hitPoints1, damage1, enrageThreshold1);
		MyMonster monster2 = new MyMonster(name2, description2, hitPoints2, damage2, enrageThreshold2);
		MyMonster monster3 = new MyMonster(name3, description3, hitPoints3, damage3, enrageThreshold3);

		MyRoom room1 = new MyRoom(roomIndex1, roomDescription1, monster1);
		MyRoom room2 = new MyRoom(roomIndex2, roomDescription2, monster2);
		MyTreasureRoom room3 = new MyTreasureRoom(roomIndex3, roomDescription3, monster3, treasure);

		this.dungeon = new MyRoom[3];

		dungeon[0] = room1;
		dungeon[1] = room2;
		dungeon[2] = room3;

	}

	// String name, String description, int hitPoints, int damage, int
	// enrageThreshold
	// int roomIndex, String description, gameinterfaces.Monster monster

	@Override
	public void play() throws IOException, Exception {

		FileOutputStream fo = null;
		PrintWriter pw = null;

		try {

			fo = new FileOutputStream("GameLog.txt");
			pw = new PrintWriter(fo);

			for (int i = 0; i < this.dungeon.length; ++i) {

				dungeon[i].enter(this.player);

				if (!dungeon[i].monster.isAlive()) {
					pw.println(this.player.getName() + " has defeated " + dungeon[i].monster.getName() + ".");
				}

				if (!this.player.isAlive()) {
					pw.println(this.player.getName() + " has died.");
					pw.println("END.");
					break;
				}
				
				if (i == 2 && !dungeon[i].monster.isAlive()) {
					pw.println(this.player.getName() + " has completed his/her quest.");
					pw.println("END.");
				}
				

			}
		} catch (IOException except) {
			except.printStackTrace();
		} catch(Exception except) {
			System.out.println(except.getMessage());
		} finally {
			pw.flush();
			fo.close();
		}

	}
	
	public static void main(String[] args) throws IOException, Exception{
		
		try {
		MyGame game = new MyGame();
		game.play();
		} catch(FileNotFoundException except) {
			except.printStackTrace();
		} catch(IOException except){
			except.printStackTrace();
		} catch(Exception except) {
			System.out.println(except.getMessage());
		}
		
	}

}
