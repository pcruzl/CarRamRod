package application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

public class Statistics {
	private int NumberOfStays;
	private int NumberOfHits;
	private int NumberOfGames;
	private int NumberOfBusts;
	private Statistics oldStats;
	
	public Statistics() {
		NumberOfStays = 0;
		NumberOfHits = 0;
		NumberOfGames = 0;
		NumberOfBusts = 0;
	}
	
	public Statistics(int a, int b, int c, int d) {
		NumberOfStays = a;
		NumberOfHits = b;
		NumberOfGames = c;
		NumberOfBusts = d;
	}
	
	public String toString() {
		String Output = NumberOfStays + ";" + NumberOfHits + ";" + NumberOfGames + ";" + NumberOfBusts;
		return Output;
	}
	
	/*
	 * Loads stats from hidden statistics file. 
	 * If hidden stats file does not exist, this does nothing
	 * 
	 */
	public void loadStats() {
		File readFile = new File("Statistics.txt");
		if(readFile.exists()) {
			try {
				Path path = Paths.get("Statistics.txt");
				Files.setAttribute(path, "dos:hidden", false);
				Scanner scan = new Scanner(readFile);
				String Line = scan.nextLine();
				String[] Loaded = Line.split(";");
				oldStats = new Statistics(Integer.parseInt(Loaded[0]), Integer.parseInt(Loaded[1]), Integer.parseInt(Loaded[2]), Integer.parseInt(Loaded[3]));
				scan.close();
			}
			catch(FileNotFoundException e){	//This should never occur
				System.out.println("Congrats, you broke the impossible");
			}
			catch(IOException e) {
				System.out.println("Error unhiding file");
			}
		}
	}
		
	
	/*
	 * Saves current statistics to hidden Statistics file. 
	 * If hidden Statistics file does not exist, creates hidden file.
	 * 
	 */
	public void saveStats() {
		File writeFile = new File("Statistics.txt");
		if(writeFile.exists()) {
			loadStats();
			Statistics temp = new Statistics();
			temp.NumberOfBusts = this.NumberOfBusts + oldStats.NumberOfBusts;
			temp.NumberOfHits = this.NumberOfHits + oldStats.NumberOfHits;
			temp.NumberOfGames = this.NumberOfGames + oldStats.NumberOfGames;
			temp.NumberOfStays = this.NumberOfStays + oldStats.NumberOfStays;
			try {
				FileWriter printer = new FileWriter("Statistics.txt");
				printer.write(temp.toString());
				printer.close();
				Path path = Paths.get("Statistics.txt");
				Files.setAttribute(path, "dos:hidden", true);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error writing to file");
			}
		}
		else {
			try {
				BufferedWriter printer = new BufferedWriter(new FileWriter("Statistics.txt"));
				printer.write(this.toString());
				printer.close();
				Path path = Paths.get("Statistics.txt");
				Files.setAttribute(path, "dos:hidden", true);
			}
			catch(IOException e){
				System.out.println("Error writing to file");
			}
		}
	}
	
	
	public int getNumberOfStays() {
		return NumberOfStays;
	}
	public void setNumberOfStays(int numberOfStays) {
		NumberOfStays = numberOfStays;
	}
	public int getNumberOfHits() {
		return NumberOfHits;
	}
	public void setNumberOfHits(int numberOfHits) {
		NumberOfHits = numberOfHits;
	}
	public int getNumberOfGames() {
		return NumberOfGames;
	}
	public void setNumberOfGames(int numberOfGames) {
		NumberOfGames = numberOfGames;
	}
	public int getNumberOfBusts() {
		return NumberOfBusts;
	}
	public void setNumberOfBusts(int numberOfBusts) {
		NumberOfBusts = numberOfBusts;
	}
}
