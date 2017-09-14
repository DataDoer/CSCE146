import java.util.*;
import java.io.*;

public class TacoManager {
	
	private GenLinkedList<Taco> tacos;

	//The files are assumed to be tab delimited. Think of a tab as indicating the next column of an excel document.
	//file format no header; just raw data <<name>>\t<<maker>>\t<<price>>\t<<rating>>\n
	public static final String DELIM = "\t";

	//Constructor
	public TacoManager()
	{
		tacos = new GenLinkedList<Taco>();
	}
	

	public Taco[] getTacos()
	{
		//TODO
	}
	
	public void addTaco(Taco newTaco)
	{
		tacos.insert(newTaco);
	}
	public void removeTaco(Taco aTaco)
	{
		tacos.resetCurrent();
		while(!tacos.getCurrent().equals(aTaco) && tacos.hasMore())
		{
			tacos.goToNext();
		}
		if(tacos.getCurrent() != null)
		{
			tacos.delete();
		}
	}

	
	//This method is used to read a taco file. The information from the file is loaded into the local ArrayList
	public void readTacoFile(String fileName) //not done yet
	{
		//we assume a new list is created from the file
		tacos = new GenLinkedList<Taco>();
		if (fileName == null)
			return;
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine(); //read the line
				String[] splitString = fileLine.split(DELIM);//split the line
				if(splitString.length == 4) //ideal to declare 4 as a constant. Check if the line is formatted correctly to have four columns
				{
					//Parse info
					String name = splitString[0];
					String maker = splitString[1];
					double price = Double.parseDouble(splitString[2]);
					int rating = Integer.parseInt(splitString[3]);
					Taco aTaco = new Taco(name,maker,price,rating);
					tacos.insert(aTaco);
				}
			}
			fileScanner.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void writeToTacoFile(String fileName, boolean append)
	{
		if (tacos == null || fileName == null)
			return;
		try
		{
			//memorize this line
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append)); //no appending; wipes file if existing
			tacos.resetCurrent();
			while(tacos.hasMore())
			{	
				Taco aTaco = tacos.getCurrent();
				fileWriter.println(aTaco.getName()+DELIM+aTaco.getMaker()+aTaco.getPrice()+DELIM+aTaco.getRating());
				tacos.goToNext();
			}
			fileWriter.close(); //don't forget this
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	//This method prints everything in the array list
	public void printTacoList()
	{
		writeToTacoFile("taco.txt",false);
	}
	
}
