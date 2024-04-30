package dao;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Task;
import dto.User;

public class Dao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root","root");
		return con;
	}
	public static int saveUser(User user) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4, user.getUsercontact());
		pst.setString(6, user.getUserpassword());
		
		Blob imageBlob = new SerialBlob(user.getUserimage()) ;
		pst.setBlob(5, imageBlob);
		int res = pst.executeUpdate();
		return res;
		
	}
	
	public User findByEmail(String email) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user where useremail = ?");
		pst.setNString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			
			//convert blob image to byte[]
			Blob imageBlob = rs.getBlob(5);
			byte[] image = imageBlob.getBytes(1, (int)imageBlob.length());
			
			User u = new User(rs.getInt(1),rs.getNString(2),rs.getNString(3),rs.getLong(4),rs.getNString(6), image);
			
			return u;
			
		}
		else {
			return null;
		}
	}
	public int createtask(Task task) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into task values(?,?,?,?,?,?,?)");
		pst.setInt(1, task.getTaskid());
		pst.setString(2, task.getTasktitle());
		pst.setString(3, task.getTaskdescription());
		pst.setString(4, task.getTaskpriority());
		pst.setString(5, task.getTaskduedate());
		pst.setString(6, task.getTaskstatus());
		pst.setInt(7, task.getUserid());
		
		int res = pst.executeUpdate();
		return res;		
	}
	public List<Task> getalltasksByUserId(int userid) throws ClassNotFoundException, SQLException{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from task where userid = ?");
		pst.setInt(1, userid);
		ResultSet rs = pst.executeQuery();
		List<Task> tasks = new ArrayList<Task>();
		while(rs.next()) {
			Task task = new Task (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getInt(7));
			tasks.add(task);
		}
		return tasks;
	}
	public int deleteTaskById(int taskid) throws ClassNotFoundException, SQLException 
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("delete from task where taskid = ?");
		pst.setInt(1, taskid);
		int res = pst.executeUpdate();
		return res;	
	}
}

//    public int getTaskId() throws ClassNotFoundException,SQLException{
//    	Connection con = getConnection();
//    	PreparedStatement pst = con.prepareStatement("select max(taskid) from task");
//    	ResultSet rs = pst.executeQuery();
//    	if(rs.next()) {
//    		int id = rs.getInt(1);
//    		return id+1;
//    	}
//    	else {
//    		return 1;
//    	}
//    }
//    public int getUserId() throws ClassNotFoundException,SQLException{
//    	Connection con = getConnection();
//    	PreparedStatement pst = con.prepareStatement("select max(user id) from user");
//    	ResultSet rs =pst.execteQuery()
//    }
