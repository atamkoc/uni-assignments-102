import java.util.ArrayList;

public class Author {
	private String id;
	private String name;
	private String university;
	private String department;
	private String email;
	private String article1;
	private String article2;
	private String article3;
	private String article4;
	private String article5;
	
	public Author (String id,String name, String university, String department, String email, String article1,String article2, String article3,String article4,String article5) {
		this.id=id;
		this.university=university;
		this.department=department;
		this.email=email;
		this.article1=article1;
		this.article2=article2;
		this.article3=article3;
		this.article4=article4;
		this.article5=article5;		
		this.name=name;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getArticle1() {
		return article1;
	}
	public void setArticle1(String article1) {
		this.article1 = article1;
	}
	public String getArticle2() {
		return article2;
	}
	public void setArticle2(String article2) {
		this.article2 = article2;
	}
	public String getArticle3() {
		return article3;
	}
	public void setArticle3(String article3) {
		this.article3 = article3;
	}
	public String getArticle4() {
		return article4;
	}
	public void setArticle4(String article4) {
		this.article4 = article4;
	}
	public String getArticle5() {
		return article5;
	}
	public void setArticle5(String article5) {
		this.article5 = article5;
	}
	
	
	@Override
	public String toString() {
		return (
				"ID: "+this.id+
				" name:"+this.name+
				" university:"+this.university+
				" deparment: "+this.department+
				" email: "+this.email+
				" article1: "+this.article1+
				" article2: "+this.article2+
				" article3: "+this.article3+
				" article4:" +this.article4+
				"article5:"+this.article5);
	}
	
	public int getNumberOfArticles() {
		int articleNumber=0;
		if (this.article1!="") {
			articleNumber++;
		}
		if (this.article2!="") {
			articleNumber++;
		}
		if (this.article3!="") {
			articleNumber++;
		}
		if (this.article4!="") {
			articleNumber++;
		}
		if (this.article5!="") {
			articleNumber++;
		}
		
		return articleNumber;
		
	}
	
	public ArrayList<String> getAllArticles() {
		ArrayList <String> allArticles=new ArrayList <String> ();
		if (!this.getArticle1().equals("")) {
			allArticles.add(this.getArticle1());
		}
		if (!this.getArticle2().equals("")) {
			allArticles.add(this.getArticle2());
		}
		if (!this.getArticle3().equals("")) {
			allArticles.add(this.getArticle3());
		}
		if (!this.getArticle4().equals("")) {
			allArticles.add(this.getArticle4());
		}
		if (!this.getArticle5().equals("")) {
			allArticles.add(this.getArticle5());
		}
		
		return allArticles;
	}
	
}
