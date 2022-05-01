import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeMap;
public class ShortFilm extends Films{
	private String releaseDate;
	private String [] writers;
	private String [] genres;
	//RUNTIME MUST BE LESS THAN 40 MINS

	public String getReleaseDate() {
		return releaseDate;
	}
	public ShortFilm(String id, String title, String language, String[] directorIDs, int runTime, String country,
			String[] cast, String [] genres, String releaseDate,String [] writers) {
		super(id, title, language, directorIDs, runTime, country, cast);
		this.releaseDate = releaseDate;
		this.writers = writers;
		this.genres = genres;
	}
	
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String[] getWriters() {
		return writers;
	}
	public void setWriters(String[] writers) {
		this.writers = writers;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	//helps print method
	public String printWriters() {
		String writers="";
		for (String a:this.writers) {
			writers=writers+a+", "; 
		}
		
		return writers;
	}
	//helps print method
	public void printGenres(PrintWriter pw) {
		ArrayList <String> genres=new ArrayList<String>();
		for (String a:this.genres) {
			genres.add(a);
		}
		
		pw.print(genres.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
	}
	
	//helps print method
	public void printWriterNames(ArrayList <Writer> writers,PrintWriter pw) {
		ArrayList <String> writerNames=new ArrayList<String>();
		String firstName;
		String secondName;
		for (String writerID:this.writers) {
			for (Writer writer:writers) {
				if (writerID.equals(writer.getId())) {
					firstName=writer.getName();
					secondName=writer.getSurname();
					writerNames.add(firstName+" "+secondName);
				}
			}
		}
		
		pw.print("Writers: ");
		pw.print(writerNames.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
		//for (String name:writerNames) {
		//	pw.print(name+" ,");
		//}
		
		
	}
	


	//prints information of a shortfilm
	public void print(ArrayList <Writer> writers, ArrayList <Director> directors, ArrayList <Performer> performers,PrintWriter pw) {
		String date=this.getReleaseDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		pw.println(this.getTitle()+" ("+date+")");
		printGenres(pw);
		pw.println("");
		printWriterNames(writers,pw);
		pw.println("");
		printDirectorNames(directors,pw);
		pw.println("");
		printCastNames(performers,pw);
		pw.println("");
		printRatings(pw);
		
	}
	public int returnFilmYear() {
		String date=this.getReleaseDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		return Integer.parseInt(date);
	}
	
//	@Override
//	public String toString() {
//		return "Printing short film:\nID:"+this.getId()
//		+" Title :"+this.getTitle()
//		+" Language: "+this.getLanguage()
//		+" Directors:"+this.printDirectorIDs()
//		+" Length:"+this.getRunTime()
//		+" Country:"+this.getCountry()
//		+" Performers: "+this.printCast()
//		+" Genres: "+this.printGenres()
//		+" Release Date: "+this.getReleaseDate()
//		+" Writers: "+this.printWriters();
//	}
	
	
	
	

	
	
	
	

}
