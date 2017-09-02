
public class Person {
	private String name; //Instance variable
	//Constructors
	public Person() //Default
	{
		this.name = "no name yet";
	}
	
	public Person(String aName)
	{
		//call mutator - avoid duplicate error checking
		this.setName(aName);
	}
	
	//Accessor
	public String getName()
	{
		return this.name;
	}
	//Mutators
	//Generally want to do error checking but can't
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	//other methods
	public boolean equals(Person aPerson)
	{
		//must first make sure aPerson exits
		//avoi null reference exceptions
		return aPerson  != null && 
				this.name.equals(aPerson.getName());
	}
	public String toString()
	{
		return this.name;
	}
}
