import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeMap;
public class TvSeries extends Films {
	private String startDate;
	private String endDate;
	private int numberOfSeasons;
	private int numberOfEpisodes;
	private String [] genres;
	private String [] writers;
	
	
	
	public TvSeries(String id, String title, String language, String[] directorIDs, int runTime, String country,
			String[] cast, String []genres, String [] writers, String startDate, String endDate, int numberOfSeasons, int numberOfEpisodes) {
		super(id, title, language, directorIDs, runTime, country, cast);
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfSeasons = numberOfSeasons;
		this.numberOfEpisodes = numberOfEpisodes;
		this.genres = genres;
		this.writers = writers;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public int getNumberOfSeasons() {
		return numberOfSeasons;
	}



	public void setNumberOfSeasons(int numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}



	public int getNumberOfEpisodes() {
		return numberOfEpisodes;
	}



	public void setNumberOfEpisodes(int numberOfEpisodes) {
		this.numberOfEpisodes = numberOfEpisodes;
	}



	public String[] getGenres() {
		return genres;
	}



	public void setGenres(String[] genres) {
		this.genres = genres;
	}



	public String[] getWriters() {
		return writers;
	}



	public void setWriters(String[] writers) {
		this.writers = writers;
	}
	
	//helps print command
	public String printWriters(){
		String writers="";
		for (String a:this.writers) {
			writers=writers+a+", ";
		}
		return writers;
	}
	

	//helps print command
	public void printGenres(PrintWriter pw) {
		ArrayList <String> genres=new ArrayList<String>();
		
		for (String a:this.genres) {
			genres.add(a);
		}
		pw.print(genres.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
		
	}
	
	//helps print command
	public void printWriterNames(ArrayList <Writer> writers,PrintWriter pw) {
		ArrayList <String> writerNames=new ArrayList<String>();
		String firstName;
		String secondName;
		String all="";
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
		
		//for (String name:writerNames) {
		//	all=all+(name+" ,");
		//}
		//all=all.substring(0,all.length()-1);
		//pw.print(all);
		
		pw.print(writerNames.toString().replace(", ", ", ").replaceAll("[\\[.\\]]", ""));
		
	}
	
	

	
	public void print(ArrayList <Director> directors,ArrayList <Performer> performers,ArrayList <Writer> writers,PrintWriter pw) {
		String date=this.getStartDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		String date2=this.getEndDate();
		date2=date2.substring(date2.indexOf(".")+1);
		date2=date2.substring(date2.indexOf(".")+1);
		
		pw.println(this.getTitle()+" ("+date+"-"+date2+")");
		pw.println(this.getNumberOfSeasons()+" seasons, "+this.getNumberOfEpisodes()+" episodes");
		pw.print("");
		printGenres(pw);
		pw.println("");
		this.printWriterNames(writers,pw);
		pw.println("");
		this.printDirectorNames(directors,pw);
		pw.println("");
		this.printCastNames(performers,pw);
		pw.println("");
		this.printRatings(pw);
		
	}
	
	//prints all the tv series
	public void printAllTvSeries(ArrayList <Director> directors, ArrayList <Performer> performers, ArrayList <Writer> writers,PrintWriter pw) {
		pw.println(this.getTitle()+" ("+this.getStartDate()+"-"+this.getEndDate()+")");
		pw.println(this.getNumberOfSeasons()+" seasons, "+this.getNumberOfEpisodes()+" episodes");
		this.printWriterNames(writers,pw);
		pw.println("");
		this.printDirectorNames(directors,pw);
		pw.println("");
		this.printCastNames(performers,pw);
		pw.println("");
		this.printRatings(pw);
	}
	
	
	public void listTVSeries(PrintWriter pw) {
		String date=this.getStartDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		String date2=this.getEndDate();
		date2=date2.substring(date2.indexOf(".")+1);
		date2=date2.substring(date2.indexOf(".")+1);
		
		pw.println(this.getTitle()+" ("+date+"-"+date2+")");
		pw.println(this.numberOfSeasons+" seasons and "+this.numberOfEpisodes+" episodes");
	}
	
	
	public int returnStartYear() {
		String date=this.getStartDate();
		date=date.substring(date.indexOf(".")+1);
		date=date.substring(date.indexOf(".")+1);
		return Integer.parseInt(date);
	}
	
	public int returnEndYear() {
		String date2=this.getEndDate();
		date2=date2.substring(date2.indexOf(".")+1);
		date2=date2.substring(date2.indexOf(".")+1);
		return Integer.parseInt(date2);
	}
	
}
