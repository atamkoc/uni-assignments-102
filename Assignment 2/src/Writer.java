import java.io.FileWriter;
import java.io.PrintWriter;
public class Writer extends Artist{
	private String writingStyle;

	public Writer(String id, String name, String surname, String country, String writingStyle) {
		super(name, surname, country, id);
		this.writingStyle = writingStyle;
	}
	
	@Override
	public String toString() {
		return "Priting writer "+"id: "+this.getId()+" name: "+this.getName()+" surname: "+this.getSurname()+" country: "+this.getCountry()+" writingStyle "+this.writingStyle; 
	}

	public String getWritingStyle() {
		return writingStyle;
	}

	public void setWritingStyle(String writingStyle) {
		this.writingStyle = writingStyle;
	}
	
	
	
	
	
	
}
