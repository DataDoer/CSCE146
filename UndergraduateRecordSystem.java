import java.io.*;
import java.util.Scanner;

public class UndergraduateRecordSystem {
	public static final String DELIM = "\t"; //Delimeter
	public static void recordToFile(Ugrad[] uGrads, String fileName, boolean append)
	{
		if (uGrads == null || fileName == null)
		{
			return;
		}
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName,append));
			//Print header data
			fileWriter.println("Number of students"+DELIM+uGrads.length);
			//print body data
			for(int i = 0; i < uGrads.length; i++)
			{
				fileWriter.println(uGrads[i].getName()+DELIM+uGrads[i].getID()+DELIM+uGrads[i].getLevel());
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static Ugrad[] readFromFile(String fileName)
	{
		if(fileName == null)
			return null;
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			//Read header info
			String fileLine = fileScanner.nextLine();
			String[] splitLines = fileLine.split(DELIM);
			Ugrad[] ugrads;
			if(splitLines.length == 2) //check if the file is correct
			{
				ugrads = new Ugrad[Integer.parseInt(splitLines[1])];
			}
			else
			{
				System.out.println("Bad file format");
				return null;
			}
			int uGradCount = 0;
			while(fileScanner.hasNextLine() && uGradCount < ugrads.length) /// could have more lines than expected/more students than reported
			{
				fileLine = fileScanner.nextLine(); //read line
				splitLines = fileLine.split(DELIM); //split line
				if (splitLines.length == 3) 		//check line formatting - if wrong ignore it
				{
					//Parse it
					String name = splitLines[0];
					int ID = Integer.parseInt(splitLines[1]);
					int level = Integer.parseInt(splitLines[2]);
					ugrads[uGradCount] = new Ugrad(name,ID,level);
					uGradCount++;
				}
				
			}			
			fileScanner.close();
			return ugrads;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Welcome to the undergraduate record system");
		while(quit == false)
		{
			System.out.println("Enter 1 to create a new record\nEnter 2 to ");
		}
	}

}
