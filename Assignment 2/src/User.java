import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.io.FileWriter;
import java.io.PrintWriter;
public class User extends Person{
	
	LinkedHashMap <String,Integer> ratedFilms= new LinkedHashMap<String, Integer>();
	//HashMap <String,Integer> ratedFilms= new HashMap<String, Integer>();

	public User(String id, String name, String surname, String country) {
		super(name, surname, country, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Printing User \n"+ "id: "+this.getId()+" name:"+this.getName()+" surname:"+this.getSurname()+" country:"+this.getCountry(); 
	}
	
	public void rateFilm(String title,int point, ArrayList<Films> films) {
		Films filmToRate=null;
		for (Films film:films) {
			if (film.getTitle().equals(title)) {
				filmToRate=film;
			}
		}
		
		filmToRate.rateFilm(point);
		this.ratedFilms.put(title, point);
	}
	
	public void rate(String title, int point) {
		this.ratedFilms.put(title,point);
	}
	
	//finds user with specified id
	public User findUser(ArrayList <User> users, String id) {
		for (User user:users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
		
	}
	
	//prints all the films that the user rated
	public void printFilmsAndRate(PrintWriter pw) {
		for (Map.Entry<String, Integer> entry:this.ratedFilms.entrySet()) {
			pw.println("Film: "+entry.getKey());
			pw.println("Rating: "+entry.getValue());
			
		}
	}
	
	//validation for already rated
	public boolean chechIfAlreadyRated(String filmTitle) {
		for (Map.Entry<String, Integer> entry: this.ratedFilms.entrySet()) {
			if(entry.getKey().equals(filmTitle)) {
				return true;
			}
		}
		return false;
	}
	
	public int returnSizeOfRatedFilms() {
		return ratedFilms.size();
	}
	
	public void printRatedFilms(PrintWriter pw) {
		if (returnSizeOfRatedFilms()==0) {
			pw.println("There is not any ratings so far");
		}
		else {
			
			for (Map.Entry <String,Integer> entry: this.ratedFilms.entrySet()) {
				pw.println(entry.getKey()+": "+entry.getValue());
			}
		}
	}
	
	//returns current while updating the rating to substract from film rating
	public int returnCurrentRate(String filmTitle) {
		int currentRate=-1;
		for (Map.Entry<String, Integer> entry: this.ratedFilms.entrySet()) {
			if (entry.getKey().equals(filmTitle)) {
				currentRate=entry.getValue();
			}
		}
		return currentRate;
	}
	
	public void editRate(int newRating, String filmTitle) {
		this.ratedFilms.replace(filmTitle, newRating);
	}
	
	public void removeRating(String filmTitle) {
		this.ratedFilms.remove(filmTitle);
	}
	

	
	
	

}
