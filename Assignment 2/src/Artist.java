import java.io.FileWriter;
import java.io.PrintWriter;
public class Artist extends Person{

	public Artist(String name, String surname, String country, String id) {
		super(name, surname, country, id);
	}
	
	@Override
	
	public String toString() {
		return "Printing Artist \n"+" name:"+this.getName()+" surname: "+this.getSurname()+" country: "+this.getCountry()+" id: "+this.getId();
	}
	
	

}
