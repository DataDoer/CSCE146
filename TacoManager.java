import java.util.*;
import java.io.*;

public class TacoManager {
	private Taco[] tacos;
	public static final int DEFAULT_SIZE = 100;
	//The files are assumed to be tab delimited. Think of a tab as indicating the next column of an excel document.
	//file format no header; just raw data <<name>>\t<<maker>>\t<<price>>\t<<rating>>\n
	public static final String DELIM = "\t";
	//Constructor
	public TacoManager()
	{
		tacos = new Taco[DEFAULT_SIZE];
	}
	public TacoManager(int size)
	{
		//don't want to pass in an array of tacos - they might not be constructed the way my database is; can't assume proper formatting
		if (size > 0)
		{
			tacos = new Taco[size];
		}
	}
	public Taco[] getTacos()
	{
		return tacos;
	}
	//This method is used to read a taco file. The information from the file is loaded into the local ArrayList
	public void readTacoFile(String fileName)
	{
		if (fileName == null)
			return;
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			//count the number of tacos in the file
			int arraySize = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				arraySize++;
			}
			if(arraySize<=0)
			{
				fileScanner.close();
				return;
			}
			tacos = new Taco[arraySize];
			//populate the array with tacos!
			//need to go back to the beginning of the file
			//reconstruct to reset
			fileScanner = new Scanner(new File(fileName));
			int currTacoIndex = 0;
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine(); //read the line
				String[] splitString = fileLine.split(DELIM);//split the line
				if(splitString.length == 4) //ideal to delare 4 as a constant. Check if the line is formatted correctly to have four columns
				{
					//Parse info
					String name = splitString[0];
					String maker = splitString[1];
					double price = Double.parseDouble(splitString[2]);
					int rating = Integer.parseInt(splitString[3]);
					tacos[currTacoIndex] = new Taco(name,maker,price,rating);
					currTacoIndex++;
				}
			}
			fileScanner.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void writeToTacoFile(String fileName)
	{
		if (fileName == null)
			return;
		try
		{
			//memorize this line
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName)); //no appending; wipes file if existing
			for(Taco taco : tacos) //for each loop. To use this, you cannot modify the structure that you're iterating through - adding or removing items
			{
				if(taco == null)
				{
					//didn't construct each element in the array like we normally do
					//want to gradually add each taco to the end of the initialized list
					//so the first null instance shows that the rest of the array is also empty and doesn't need to be iterated through
					//STOP there's nothing past this point in the array
					break;
				}
				fileWriter.println(taco.getName()+DELIM+taco.getMaker()+taco.getPrice()+DELIM+taco.getRating());
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
		
	}
	public void addTaco(Taco newTaco)
	{
		for(int i=0;i<tacos.length;i++)
		{
			if(tacos[i]==null)//found the first null value
			{
				tacos[i]=newTaco;//add taco to the end of this array
				break;//STOP! or else everything after will be that Taco
			}
		}
	}
	public void removeTaco(String removeTaco)
	{
		//remove taco
		for(int i=0;i<tacos.length;i++)
		{
			if(tacos[i].getName().equals(removeTaco))
			{
				for(int j = i; j< tacos.length-1; j++) //SHIFT
				{
					tacos[j]=tacos[j+1];
				}
				tacos[tacos.length-1] = null;
			}
		}
	}
}
