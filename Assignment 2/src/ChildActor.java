import java.io.FileWriter;
import java.io.PrintWriter;
public class ChildActor extends Performer{
	private int age;

	public ChildActor(String id, String name, String surname,String country, int age) {
		super(name, surname, country, id);
		// TODO Auto-generated constructor stub
		this.age=age;
	}
	
	
	
	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Printing child actor: \n"+"id :"+this.getId()+" name :"+this.getName()+" surname : "+this.getSurname()+" country: "+this.getCountry()+" age: "+this.getAge();
	}
	
}
