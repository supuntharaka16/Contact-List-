import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Contact{
	private String ID;
	private String Name;
	private String phoneNumber;
	private String companyName;
	private double salary;
	private String bday;
	
	
	
	public Contact(String ID, String Name, String phoneNumber, String companyName, double salary, String bday){
		this.ID = ID;
		this.Name = Name;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
		this.salary = salary;
		this.bday = bday;
		
		}
		public  void setID(String ID){
			this.ID = ID;
		}
		public  void setName(String Name){
			this.Name = Name;
		}
		public  void setPhoneNumber(String phoneNumber){
			this.phoneNumber = phoneNumber;
		}
		public  void setCompanyName(String companyName){
			this.companyName = companyName;
		}
			
		public  void setSalary(double salary){
			this.salary = salary;
		}
		public  void setBday(String bday){
			this.bday = bday;
		}
		
		public String getID(){
			return ID;
		}
		
		public String getName(){
			return Name;
		}
		
		public String getPhoneNumber(){
			return phoneNumber;
		}
		
		public String getCompanyName(){
			return companyName;
		}
		
		public double getSalary(){
			return salary;
		}
		
		public String getBday(){
			return bday;
		}
				
		
}
