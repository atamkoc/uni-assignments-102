import java.io.FileWriter;
import java.io.PrintWriter;
public class StuntPerformer extends Performer {
	private int height;
	private String [] realActors;
	

	public StuntPerformer(String id, String name, String surname , String country,int height,String actors) {
		super(name, surname, country, id);
		this.height=height;
		this.realActors=actors.split(",");
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		
		return "Printing Stunt Performer \n "+"id: "+this.getId()+" name: "+this.getName()+" surname: "+this.getSurname()+" country: "+this.getCountry()+" height "+this.getHeight();
	}

	public String[] getRealActors() {
		return realActors;
	}

	public void setRealActors(String[] realActors) {
		this.realActors = realActors;
	}
	
	public void printRealActors(PrintWriter pw) {
		for (String actor: this.realActors) {
			pw.println(actor);
		}
	}
	
	
	
	

}
