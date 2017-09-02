
public class Student extends Person { //inheritance
	private int id;
	public Student() {
		super();
		this.id = 0;
	}
	public Student(String aName, int anID)
	{
		super(aName);
		this.setID(anID);
	}
	public int getID() 
	{
		return this.id;
	}
	public void setID(int anID)
	{
		if(anID >= 0)
		{
			this.id=anID;
		}
	}
	
	public boolean equals(Student aStudent){
		return aStudent != null
				&& super.equals(aStudent)
				&& this.id == aStudent.getID();
	}
	public String toString()
	{
		return super.toString() + " " + this.id;
	}
}
