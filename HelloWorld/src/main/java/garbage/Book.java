package garbage;

public class Book 
{
	String name;
	int pages;
	
	public Book(String name, int pages)
	{
		//the this keyword denotes that the variable belongs to the a single instance of the class
		this.name = name;
		this.pages = pages;
	}
	
	public String toString()
	{
		return this.name;
	}
	
	@Override
	//this method is a method that is called when an object is garbage collected (marked for deletion). Its memory can be used for another purpose
	public void finalize()
	{
		System.out.println("The book was destroyed" + this.name);
	}
}
