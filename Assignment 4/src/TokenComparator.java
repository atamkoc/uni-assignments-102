import java.util.Comparator;

public class TokenComparator implements Comparator <Token> {
	//method that helps us sorting tokens first with their priority and then with their name
	public int compare(Token a,Token b) {
		Integer x1=a.getAmount();
		Integer x2=b.getAmount();
		
		int sComp=x2.compareTo(x1);
		
		if (sComp !=0) {
			return sComp;
		}
		
		String name1=a.getName();
		String name2=b.getName();
		
		return name1.compareTo(name2);
	}
	

}
