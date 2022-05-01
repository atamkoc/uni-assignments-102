import java.util.ArrayList;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.PrintWriter;
public class FeatureFilm extends Films{
	private String releaseDate;
	private int budget;
	private String [] writers;
	private String [] genres;
	
	
	
	
	public FeatureFilm(String id, String title, String language, String[] directorIDs, int runTime, String country,
			String[] cast, String [] genres, String releaseDate, String [] writers, int budget) {
		super(id, title, language, directorIDs, runTime, country, cast);
		this.releaseDate = releaseDate;
		this.budget = budget;
		this.writers = writers;
		this.genres = genres;
	}
	
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	//helps print method
	public String printWriters() {
		String writers="";
		for (String a: this.writers) {
			writers=writers+a+", ";
			
		}
		return writers;
	}
	public void setWriters(String[] writers) {
		this.writers = writers;
	}
	
	//helps print method
	public void printGenres(PrintWriter pw) {
		ArrayList <String> genres= new ArrayList<String>();
		for (String a:this.genres) {
			genres.add(a);
		}
		//for (String a:this.genres) {
		//	genres=genres+a+", ";
		//}
		pw.print(genres.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
	}
	
	//helps print method
	public void printWriterNames(ArrayList <Writer> writers, PrintWriter pw) {
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

	//prints necessary information about a featureFilm
	public void print(ArrayList <Writer> writers, ArrayList <Director> directors, ArrayList <Performer> performers, PrintWriter pw) {
		String date=this.getReleaseDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		pw.println(this.getTitle()+" ("+date+")");
		printGenres(pw);
		pw.print("\n");
		printWriterNames(writers,pw);
		pw.println("");
		printDirectorNames(directors,pw);
		pw.println("");
		printCastNames(performers,pw);
		pw.println();
		this.printRatings(pw);
		
	}
	
	public int returnFilmYear() {
		String date=this.getReleaseDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		return Integer.parseInt(date);
	}
		
	

	



	
	
	
	
	

}
