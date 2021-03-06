
public class Taco {
	//separated front end
	//separated taco manager
	//always want to keep front eend & back end separated
	private String name;
	private String maker;
	private double price;
	private int rating; //0-5
	
	public Taco() {
		this.name=this.maker="No name yet";
		this.price=0.0;
		this.rating=0;
	}
	public Taco(String aName, String aMaker, double aPrice, int aRating)
	{
		//TODO call mutators
	}
	//auto-generated by right-clicking, source, generate getters & setters
	//add error-checking
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//can have parameters & attributes with the same name in Java
		//differentiate by using this. for the attribute
		//this is the old style; Java hasn't been updated; new convention is aName for the parameter
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price >= 0.0)
		{
			this.price = price;
		}
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		if (rating <= 5 && rating >= 0)
		{	
			this.rating = rating;
		}	
	}
	@Override
	//auto generated
	public String toString() {
		return "Taco [name=" + name + ", maker=" + maker + ", price=" + price + ", rating=" + rating + "]";
	}
	//auto generated equals is messy
	public boolean equals(Taco aTaco)
	{
		return aTaco != null && 
				this.name.equals(aTaco.getName()) &&
				this.maker.equals(aTaco.getMaker()) &&
				this.price == aTaco.getPrice() &&
				this.rating == aTaco.getRating();
	}
	
	
}
