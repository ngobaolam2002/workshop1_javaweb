package Job;

public class JobInsertErr {
	private String jobIDErr;
	private String jobNameErr;
	private String jobCompanyErr;
	private int yearErr;
	private String jobIDIsExit;
	public JobInsertErr() {
	}
	public JobInsertErr(String jobIDErr, String jobNameErr, String jobCompanyErr, int yearErr, String jobIDIsExit) {
		super();
		this.jobIDErr = jobIDErr;
		this.jobNameErr = jobNameErr;
		this.jobCompanyErr = jobCompanyErr;
		this.yearErr = yearErr;
		this.jobIDIsExit = jobIDIsExit;
	}
	public String getJobIDErr() {
		return jobIDErr;
	}
	public void setJobIDErr(String jobIDErr) {
		this.jobIDErr = jobIDErr;
	}
	public String getJobNameErr() {
		return jobNameErr;
	}
	public void setJobNameErr(String jobNameErr) {
		this.jobNameErr = jobNameErr;
	}
	public String getJobCompanyErr() {
		return jobCompanyErr;
	}
	public void setJobCompanyErr(String jobCompanyErr) {
		this.jobCompanyErr = jobCompanyErr;
	}
	public int getYearErr() {
		return yearErr;
	}
	public void setYearErr(int yearErr) {
		this.yearErr = yearErr;
	}
	public String getJobIDIsExit() {
		return jobIDIsExit;
	}
	public void setJobIDIsExit(String jobIDIsExit) {
		this.jobIDIsExit = jobIDIsExit;
	}
	
	
}
