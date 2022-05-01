import java.util.TreeMap;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Director extends Artist{
	private String agent;

	public Director(String id, String name, String surname, String country,String agent) {
		super(name, surname, country, id);
		this.agent=agent;
		// TODO Auto-generated constructor stub
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	@Override
	public String toString() {
		return "Printing director: \n id:"+this.getId()+" name: "+this.getName()+" surname: "+this.getSurname()+" country: "+this.getCountry()+" agent:"+this.getAgent();
	}
	

	
	
	
	

}
