package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Account;

public class AccountDAOImpl implements AccountDAO{
private Connection con;

@Override
public boolean insertAccount(Account ob) {
 // TODO Auto-generated method stub
 try {
  Class.forName("oracle.jdbc.driver.OracleDriver");
 } catch (ClassNotFoundException e1) {
  // TODO Auto-generated catch block
  e1.printStackTrace();
 } //.db vendor will supply driver name
 boolean inserted=false;
 String url="jdbc:oracle:thin:@localhost:1521:xe"; //path or location given by url
 
 String username="hr";
 String password="hr";
 try {
 con=DriverManager.getConnection(url,username,password);
 System.out.println("connected");
 
 //parameterized query
 PreparedStatement ps1=con.prepareStatement("insert into account  values(?,?,?,?)");
 ps1.setInt(1,ob.getAid());
 ps1.setString(2, ob.getAname());
 ZoneId defaultZoneId=ZoneId.systemDefault();
 LocalDate Id=ob.getDob();
 //Date d=new Date(Id.getYear(),Id.getMonthValue()-1,Id.getDayOfMonth());
 Date d=Date.valueOf(Id);

 ps1.setDate(3,d);
 ps1.setDouble(4,ob.getBalance());
  int i=ps1.executeUpdate(); //returns no of records inserted
  System.out.println("Records inserted is"+i);
  
 inserted=true;
 }
 catch(SQLException e)
 {
  System.out.println(e.getMessage());
  inserted=false;
 }
 finally {
 try {
  con.close();
 } catch (SQLException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
 }
 }
 return inserted;
}

@Override
public boolean updateAccount(Account ob) {
 // TODO Auto-generated method stub
	//update account set aname=?,dob=?,balance=? where aid=?
	try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		 } catch (ClassNotFoundException e1) {
		  // TODO Auto-generated catch block
		  e1.printStackTrace();
		 } //.db vendor will supply driver name
		 boolean inserted=false;
		 String url="jdbc:oracle:thin:@localhost:1521:xe"; //path or location given by url
		 
		 String username="hr";
		 String password="hr";
		 try {
		 con=DriverManager.getConnection(url,username,password);
		 System.out.println("connected");
		 
		 //parameterized query
		 PreparedStatement ps1=con.prepareStatement("update account set aname=?,dob=?,balance=? where aid=?");
		
		 ps1.setString(1, ob.getAname());
		 ZoneId defaultZoneId=ZoneId.systemDefault();
		 LocalDate Id=ob.getDob();
		 //Date d=new Date(Id.getYear(),Id.getMonthValue()-1,Id.getDayOfMonth());
		 Date d=Date.valueOf(Id);
		 ps1.setDate(2,d);
		 ps1.setDouble(3,ob.getBalance());
		 ps1.setInt(4,ob.getAid());
		  int i=ps1.executeUpdate(); //returns no of records inserted
		  System.out.println("Records Updated is"+i);
		  
		 inserted=true;
		 
		 if(inserted)
		 {
			 System.out.println("Statement updated");
		 }
		 }
		 catch(SQLException e)
		 {
		  System.out.println(e.getMessage());
		  inserted=false;
		 }
		 finally {
		 try {
		  con.close();
		 } catch (SQLException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
		 }
		 return inserted;
 
}

@Override
public boolean deleteAccount(Account ob) {
 // TODO Auto-generated method stub
	// delete from account where aid=?
 return false;
}

@Override
public Account getAccountById(int aid) {
 // TODO Auto-generated method stub
	//select * from account where aid=?
 return null;
 }

@Override
public List<Account> getAllAccount() {
 // TODO Auto-generated method stub
        List<Account> acclist=new ArrayList<Account>();
 String url="jdbc:oracle:thin:@localhost:1521:xe"; //path or location given by url
 
 String username="hr";
 String password="hr";
 try {
 con=DriverManager.getConnection(url,username,password);
 System.out.println("connected");
 
 //parameterized query
 PreparedStatement ps1=con.prepareStatement("Select aid,aname,dob,balance from Account");
 ResultSet rs= ps1.executeQuery();
 while(rs.next())
 {
 Account ob=new Account();
 //for every record seperate acc
 int id=rs.getInt(1);
 ob.setAid(id);
 ob.setAname(rs.getString(2));
 ob.setDob(rs.getDate(3).toLocalDate());
 ob.setBalance(rs.getDouble(4));
 acclist.add(ob);
 }
  

 }
 catch(SQLException e)
 {
  System.out.println(e.getMessage());
 
 }
 finally {
	 		try {
	 				con.close();
	 		} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 		}
 }


 return acclist;
}



}