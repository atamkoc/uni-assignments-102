import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Documentary extends Films{
	private String releaseDate;

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Documentary(String id, String title, String language, String[] directorIDs, int runTime, String country,
			String[] cast, String releaseDate) {
		super(id, title, language, directorIDs, runTime, country, cast);
		this.releaseDate = releaseDate;
	}
	
	

	
	@Override
	public String toString() {
		return "Printing documentary: \nID:"+this.getId()
		+" Title: "+this.getTitle()
		+" Language: "+this.getLanguage()
		+" Directors: "+this.printDirectorIDs()
		+" Length: "+this.getRunTime()
		+" Country: "+this.getCountry()
		+" Performers: "+this.printCast()
		+" Releasde Date: "+this.getReleaseDate();
	
	}
	
	//prints info about documentaries
	public void print(ArrayList <Director>directors, ArrayList <Performer> performers,PrintWriter pw) {
		String date=this.getReleaseDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		pw.println(this.getTitle()+" ("+date+")");
		pw.println("");
		this.printDirectorNames(directors,pw);
		pw.println("");
		this.printCastNames(performers,pw);
		pw.println("");
		this.printRatings(pw);
	}
	
	//returns the year for viewfilm command 
	public int returnYear() {
		String date=this.getReleaseDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		return Integer.parseInt(date);
	}
	
	
	
	
	
	
	

}
