package DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import Job.Job;
import ConnectDB.DbCon;

public class JobDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public boolean searchJob_ID(String id) throws Exception{
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if(con!= null) {
				String sql = "select * from jobdb_de160271 where Job_ID like ?";
				stm = con.prepareStatement(sql);
				stm.setString(1, "%"+id+"%");
				
				rs = stm.executeQuery();
				String check_Job_ID = null;
				while(rs.next()) {
					check_Job_ID = rs.getString("Job_ID");
				}
				if(id.equalsIgnoreCase(check_Job_ID)) {
					return true;
				}else {
					return false;
				}
				}
		}finally {
		}
		return false;
	}
	
	public List<Job> listAllJob() throws ClassNotFoundException, SQLException{
		List<Job> listAccounts;
		listAccounts = new ArrayList<>();
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if(con!= null) {
				String sql = "SELECT * FROM jobdb_de160271";
				stm = con.prepareStatement(sql);				
				
				rs = stm.executeQuery();
				while (rs.next()) {
					String newJob_ID = rs.getString("Job_ID");
					String newJob_Name = rs.getString("Job_Name");
					String newJob_Company = rs.getString("Job_Company");
					int newYear_of_Experience = rs.getInt("Year_of_Experience");
					Job dto = new Job(newJob_ID, newJob_Name, newJob_Company, newYear_of_Experience);
					listAccounts.add(dto);
				}
				return listAccounts;
			}
		}finally {
			
		}
		return null;
	}
	
	public boolean deleteRecord(String id) throws SQLException, NamingException, Exception{
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = DbCon.getConnection();
			if(con!= null) {
				String sql = "Delete from jobdb_de160271 where Job_ID=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, id);
				int row = stm.executeUpdate();
				if(row>0) {
					return true;
				}
			}
		}finally {
			
		}
		return false;
	}
	
	public Job getJobById(String id)throws Exception{
		Job jb = new Job();
		
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			con = DbCon.getConnection();
			if(con!= null) {
				String sql = "select * from jobdb_de160271 where Job_ID=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, id);
				
				rs = stm.executeQuery();
				if (rs.next()) {
					jb.setJob_ID(rs.getString("job_ID"));
					jb.setJob_Name(rs.getString("job_Name"));
					jb.setJob_Company(rs.getString("job_Company"));
					jb.setYear_of_Experience(rs.getInt("year_of_Experience"));
				}
			}
		}finally {
		}
		return jb;
		
	}
	
	public boolean updateRecord( String jobid, String jobname, String jobcompany,int year) throws SQLException, NamingException, Exception{
		
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = DbCon.getConnection();
			if(con!= null) {
				String sql = "Update jobdb_de160271 set Job_Name=?, Job_Company=?,Year_of_Experience=? where Job_ID=?";
				stm = con.prepareStatement(sql);
				stm.setString(1, jobname);
				stm.setString(2, jobcompany);
				stm.setInt(3, year);
				stm.setString(4, jobid);
				
				int row = stm.executeUpdate();
				if(row>0) {
					return true;
				}
			}
		}finally {
			
		}
		return false;
	}
	
	public boolean insertJob(String jobid, String jobname, String jobcompany,int year) throws SQLException, NamingException, Exception{
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = DbCon.getConnection();
			if(con!= null) {
				String sql = "insert into jobdb_de160271(Job_ID, Job_Name, Job_Company, Year_of_Experience)" + "values(?,?,?,?)";
				stm = con.prepareStatement(sql);
				stm.setString(1, jobid);
				stm.setString(2, jobname);
				stm.setString(3, jobcompany);
				stm.setInt(4, year);
				
				int row = stm.executeUpdate();
				if(row>0) {
					return true;
				}
			}
		}finally {
			
		}
		return false;
	}
}
