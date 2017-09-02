public class Ugrad extends Student {
	private int level;
	public Ugrad()
	{
		super();
		this.level=1;
	}
	public Ugrad(String aName,int anID, int aLevel)
	{
		super(aName, anID);
	
	}
	public int getLevel()
	{
		return this.level;
	}
}
