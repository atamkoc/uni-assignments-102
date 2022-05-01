import java.io.FileWriter;
import java.io.PrintWriter;
public class Person {
	private String name;
	private String surname;
	private String country;
	private String id;
	
	//no constructor defined yet
	public Person(String name, String surname, String country, String id) {
		this.name=name;
		this.surname=surname;
		this.country=country;
		this.id=id;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
