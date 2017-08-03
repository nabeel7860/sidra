import java.util.HashMap;

public class LibraryCard {
	
	LibrarySystem libSys = new LibrarySystem();
	
	// Collection of Borrowers :-
	private	 HashMap<Integer , Borrower> borrowers = new HashMap<Integer , Borrower>();
	
	// Register Borrower
	 public void registerBorrower(int cardID , int borID , String name , String faculty , String borrower)
	 {
		 
		 Borrower br = new Borrower(borID, name , faculty , borrower);
			borrowers.put(cardID, br);
	 }
	 
	 // Retrieve Borrower
	 public void retrieveBorrower(int cardID)
	 {
        Borrower r = borrowers.get(cardID);
        
        try
        {
        	System.out.println("Name = " + r.name + "\nid " + r.borrowerId + "\nFaculty "+ r.faculty + "\nBorrower " + r.borrower);
        }
        catch(NullPointerException e)
        {
        	System.out.println("Invalid ID or Data is empty on ID:  " + cardID);
        }
        
       
	 }

}