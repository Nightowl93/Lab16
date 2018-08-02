/*Shontinique Uqdah
 * July 31, 2018
 */
package co.grandcircus.lab16;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		
		//Declares variables
		final String FILE_NAME = "countries.txt";
		String keepGoing;
		boolean resume = true;
				
		Scanner scnr = new Scanner(System.in);
		int userChoice;
		
		ArrayList<Country> allCountries = new ArrayList<>();
		
		//Creates a filepath to write the initial countries to
		CountriesTextFile.createFilePath(FILE_NAME);
				
		//Adds countries to list and writes them to file
		insertCountries(allCountries, FILE_NAME);
		
		//Welcomes user
		System.out.println("Welcome! Let's explore some countries!\n");
		
		while (resume) {
		//Shows menu and gets users menu selection
		userChoice = printMenu(scnr);
		
		switch(userChoice) {
		//If the user chooses to view country list, calls the method
		case 1:
			System.out.println("Great! Let's view our list of countries!");
			System.out.println();
			viewCountries(allCountries);
			break;
		//If the user chooses to add a country, it calls the method
		case 2:
			System.out.println("Awesome! Let's add a country!");
			addCountry(scnr, allCountries, FILE_NAME);
			allCountries = CountriesTextFile.readFromFile_newWay(FILE_NAME);
			break;
		//If a user wishes to exit the program, it exits	
		case 3: 
			System.out.println("Thanks for stopping by! Goodbye :)");
			resume = false;
			break;			
		}
		
		if (userChoice == 1 || userChoice == 2) {
			keepGoing = Validator.getStringMatchingRegex(scnr, "Would you like to continue?(y/n)", "y|yes|no|n", false);
			
			if (keepGoing.toLowerCase().startsWith("y")) {
				resume = true;
			}
			else {
				resume = false; 
				System.out.println("Thanks for stopping by! Goodbye :)");
			}
		}
		}
		
		
		
	}

	private static void insertCountries(ArrayList<Country> allCountries, String filePath) {
		allCountries.add(new Country("United States", "North America", true));
		allCountries.add(new Country("Ireland", "Europe", false));
		allCountries.add(new Country("Spain", "Europe", true));
		allCountries.add(new Country("Peru", "South America", true));
		allCountries.add(new Country("Botswana", "Africa", false));
		allCountries.add(new Country("South Korea", "Asia", true));
		allCountries.add(new Country("Nigeria", "Africa", false));
		allCountries.add(new Country("Australia", "Australia", false));
		allCountries.add(new Country("Dominican Republic", "North America", true));
		
		CountriesTextFile.writeToFile(allCountries, filePath);
		
	}

	private static void viewCountries(ArrayList<Country> allCountries) {
		String format = "%-30s %-30s %-30s";
		System.out.printf(format, "Country", "Continent", "I Have Visited");
		System.out.println();
		System.out.printf(format, "=======", "=========", "==============");
		System.out.println();
		
		for (Country country : allCountries) {
			System.out.printf(format, country.getName(),country.getContinent(), country.isVisited());
			System.out.println();
		}
		
		
	}

	private static void addCountry(Scanner scnr, ArrayList<Country> allCountries, String filePath) {
		String countryName = Validator.getString(scnr, "What country would you like to add?");
		String continent = Validator.getString(scnr, "What continent is this country on?");
		boolean visited = Validator.getBoolean(scnr, "Have you visited this country?");
		
		CountriesTextFile.appendToFile(new Country(countryName,continent,visited), filePath);
	}

	public static int printMenu(Scanner scnr) {
		System.out.printf("%-30s", "1. View list of countries");
		System.out.println();
		System.out.printf("%-30s", "2. Add new country");
		System.out.println();
		System.out.printf("%-30s", "3. Exit program");
		System.out.println();
		
		String prompt = "What would you like to do?";
		int userChoice = Validator.getInt(scnr, prompt, 1, 3);
		return userChoice;
	}
}
