import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Book 
{
	String title , sub , author , edition , publisher;
	private int quantity;
	int bookCode , bookISBN , newQuantity = quantity , deadLine;

	private Date d = new Date();
	
	// Constructors :-
	public Book ()
	{
	
	}
	
	public Book(int bCode ,int quant , int bISBN , String t , String s , String au , String edi, String publi)
	{
		title = t;
		sub = s;
		author  = au;
		edition = edi;
		publisher = publi;
		bookCode = bCode;
		bookISBN = bISBN;
		quantity = quant;
	}

	// Collection of Borrowed Books :-
	private HashMap<Integer , Borrower> issueBookTo = new HashMap<Integer , Borrower>(); 
	
	// Methods :-
	public void issueBookTo( int bookCode, int borrowerID , String borName)
	{
			Borrower b = new Borrower(borrowerID, borName);
			issueBookTo.put(bookCode, b);

			if(issueBookTo.containsKey(bookCode))
				newQuantity --;	
	}
	
	public void retIssueBookTo(int bookCode)
	{
		try
		{
			Borrower b = issueBookTo.get(bookCode);
			System.out.println("Book Code : "+bookCode
				+"\nIssue to ID : "+b.borrowerId
				+"\nName : "+b.name);

			
			System.out.println("Issued on : " +d);
		
			GregorianCalendar dueDate = new GregorianCalendar();
		      dueDate.add(Calendar.DAY_OF_MONTH , 7);
		      Date d = dueDate.getTime();
		      System.out.println("Due date is : "+d);
		}
		
		catch(NullPointerException e)
		{
			System.out.println("Book isn't available or isn't found");
		}
		
	}
	
	public Boolean removeBookFrom(int bookIsbn)
	{
		issueBookTo.remove(bookIsbn);
		if(issueBookTo.containsKey(bookIsbn))
			System.out.println();
		else
		{
			System.out.println("book removed");
			newQuantity ++;
			return true;
		}
		return true;
	}
}