public class Borrower
{
	String name , faculty , borrower;
	int borrowerId;
	
	// Constructors :-
	public Borrower()
	{
		
	}
	
	public Borrower(int borID , String borName)
	{
		borrowerId = borID;
		name = borName;
		
	}
	
	public Borrower(int Id , String n , String f , String borrow) 
	{
		borrowerId = Id;
		name = n;
		faculty = f;
		borrower = borrow;
	}
	

}