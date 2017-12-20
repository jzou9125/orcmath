package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {
	
	public static Scanner in;
	private ArrayList<DonaldTrumpQuotes> catalog;

	public CatalogMaker() {
		//instantiate the catalog
		catalog = new ArrayList<DonaldTrumpQuotes>();
	}

	public static void main(String[] args){
		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.menu();
	}

	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}

	private void create() {
		
		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				add();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}

	private void add() {
		String[] input = new String[2];
		displayMessage("Please enter the quote");
		input[0] = getStringInput()+"~";
		displayMessage("Please enter the date");
		input[1] = getStringInput();
		
		addBook(new DonaldTrumpQuotes(input));
	}

	/*private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
		}
		return value;
	}*/

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}


	public void addBook(DonaldTrumpQuotes b){
		catalog.add(b);
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("QuoteCatalog.csv");
			for(DonaldTrumpQuotes b: catalog){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"QuoteCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}

	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these Quotes:\n");
		displayMessage(getCSVContent());
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		catalog = new ArrayList<DonaldTrumpQuotes>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split("~");
					//add a new Book for each line in the save file
					catalog.add(new DonaldTrumpQuotes(param));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}

	public String getCSVContent()
	{
		String data = "Quote, Date:\n";
		String text = "";
		for(DonaldTrumpQuotes s: catalog)
		{
			for( String r: s.getQuotes())
			{
				text += r;
			}
			String[] input = text.split("~");
			for(String t: input)
			{
				data+= t+ " ";
			}
			data += "\n";
		}
		return data;
		
	}
}
