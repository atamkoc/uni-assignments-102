import java.io.FileWriter;
import java.io.PrintWriter;
public class Actor extends Performer {
	private int height;

 Actor(String id, String name, String surname, String country, int height) {
		super(name, surname, country, id);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	
	public String toString() {
		return "Printing Actor: \n"+ "id "+this.getId()+" name: "+this.getName()+" surname: "+this.getSurname()+" country: "+this.getCountry()+" height "+this.getHeight();
	}
	
	
	
}
