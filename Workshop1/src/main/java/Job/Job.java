package Job;

import java.io.Serializable;

public class Job implements Serializable {
	private String job_ID;
	private String job_Name;
	private String job_Company;
	private int year_of_Experience;
	
	public Job() {
		// TODO Auto-generated constructor stub
	}

	public Job(String job_ID, String job_Name, String job_Company, int year_of_Experience) {
		this.job_ID = job_ID;
		this.job_Name = job_Name;
		this.job_Company = job_Company;
		this.year_of_Experience = year_of_Experience;
	}

	public String getJob_ID() {
		return job_ID;
	}

	public void setJob_ID(String job_ID) {
		this.job_ID = job_ID;
	}

	public String getJob_Name() {
		return job_Name;
	}

	public void setJob_Name(String job_Name) {
		this.job_Name = job_Name;
	}

	public String getJob_Company() {
		return job_Company;
	}

	public void setJob_Company(String job_Company) {
		this.job_Company = job_Company;
	}

	public int getYear_of_Experience() {
		return year_of_Experience;
	}

	public void setYear_of_Experience(int year_of_Experience) {
		this.year_of_Experience = year_of_Experience;
	}
	
	
	
}
