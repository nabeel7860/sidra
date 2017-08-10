import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class LibrarySystem 
{
	
	// Add Library Cards into System :-
	private  Set<Integer> libCard = new HashSet<Integer>();
	public void addLibraryCard(Integer cardID)
	{
		libCard.add(cardID);
	}

	// Add Books into System :-
	private HashMap<Integer , Book> books = new HashMap<Integer , Book>();
	
	public void addBook (int bookCode ,int quantity , int bISB , String t , String s , String au , String edi, String publi)
	{
		
		Book b = new Book(bookCode , quantity ,bISB , t, s, au, edi, publi);
		books.put(bookCode, b);
		
	}
	
	
	// Retrieve Book :-
	public void retrieveBook(int bookCode)
	{
		Book bo = books.get(bookCode);
		
		try
		{
			System.out.println("Book Code : "+bo.bookCode
					+"\nBook ISBN : "+bo.bookISBN
					+"\nTitle : "+ bo.title 
					+ "\nAuthour : "+ bo.author
					+ "\nSubject : "+ bo.sub 
					+ "\nPublisher : "+ bo.publisher 
					+ "Edition : "+ bo.edition
					+"\nAvailable Quantity : "+bo.newQuantity);
			}
		catch (NullPointerException e)
		{
			System.out.println("Book isn't found");
		}
	}

	// Retrieve Library Cards :-
	public void retreiveLibCard (int cardID)
	{
		if(libCard.contains(cardID))
			System.out.println("Card " + cardID +" is available");
		
		else
			System.out.println("Card " + cardID +" isn't available");
	}
	
	// Penalty Generator :-
	public double penaltyGenerator(LocalDate dueDate, LocalDate returnDate)
	{
		System.out.println("Days : "+ (int) (ChronoUnit.DAYS.between(dueDate, returnDate)));
	    return (double) (ChronoUnit.DAYS.between(dueDate, returnDate) * 5);
	}
	
	// Card availability checker :-
	public Boolean checkCard(int cardID)
	{
		if (libCard.contains(cardID))
			return true;
		else 
			return false;
	}

	// Book availability checker :-
	public Boolean checkBook(int cardID)
	{
		if (books.containsKey(cardID))
			return true;
		else 
			return false;
	}

}
