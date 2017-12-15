package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<DonaldTrumpQuotes> List;
	
	public CatalogMaker() {
		String[][] input = {{"text", "11/12/17"}, {"text1", "11/02/17"}};
		List = new ArrayList<DonaldTrumpQuotes>();
		List.add(new DonaldTrumpQuotes(input));
		
//		List.add();
//		System.out.println(" Item Added Successfully");
	}

	public static void main(String[] args) {
		CatalogMaker test = new CatalogMaker();
		System.out.print(test.getCSVContent());
		Scanner in = new Scanner(System.in);
		boolean running = true;
		while( running)
		{
			DonaldTrumpQuotes input;
			String text= in.nextLine();
			String date = in.nextLine();
			
			test.List.add(input);
		}
	}

	public String getCSVContent()
	{
		String data = "Quote, Date\n";
		for(DonaldTrumpQuotes s: List)
		{
			for( String[] t: s.getQuotes())
			{
				for( String r: t)
				{
					data += r+"\n";
				}
			}
		}
		return data;
		
	}
}
