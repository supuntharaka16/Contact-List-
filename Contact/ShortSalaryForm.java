import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;
import javax.swing.border.EmptyBorder;


 class SortSalaryForm extends JFrame {
	 
	 private JButton btnReload;
	 private JButton btnBack;
	 
	 private JTable tblContact;
	 private DefaultTableModel dtm;
	 
	  SortSalaryForm(){
		 
		setTitle("List By Salary");
		setSize(700, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
		
		
		JLabel titleLabel=new JLabel("List By Salary");
		titleLabel.setFont(new Font("",1,28));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(new Color(173, 216, 230));
		add("North",titleLabel);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("",1,16));	
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			sortBySalary();
			dtm.setRowCount(0);
			List contactList = getAllContact();
				for (int i = 0; i < contactList.size(); i++){
					Contact c1=contactList.get(i);
					Object[] rowData={c1.getID(),c1.getName(),c1.getPhoneNumber(),c1.getCompanyName(),c1.getSalary(),c1.getBday()};
					dtm.addRow(rowData);		
				}
			}
		});
		btnPanel.add(btnReload);
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		btnPanel.add(btnBack);
		
		add("South",btnPanel);
		
		String[] columnName = {"Contact ID", "Name", "Contact Number", "Company", "Salary", "Birthday"};
		dtm = new DefaultTableModel(columnName,0);
		tblContact = new JTable(dtm);
		JScrollPane tablePanel = new JScrollPane(tblContact);
		add("Center",tablePanel);
		

	}
	public void sortBySalary(){
		List contactList = getAllContact();
		for(int i=contactList.size(); i>0; i--){
			double max = contactList.get(0).getSalary();
			int index = 0;
			for(int j = 0; j<i; j++){
				if(max<contactList.get(j).getSalary()){
					max = contactList.get(j).getSalary();
					index = j;
				}
			}
			Contact tempmax = contactList.get(index);
			contactList.set((index),contactList.get(i-1));
			contactList.set((i-1),tempmax);
			}
	}
	private List getAllContact(){
		List contactList=new List(100,0.5);
		try{
			FileReader fr=new FileReader("Contact.txt");
			BufferedReader br=new BufferedReader(fr);
			
			String line=br.readLine();
			while(line!=null){
				String[] rowData=line.split(","); 
				String id=rowData[0];
				String name=rowData[1];
				String phoneNumber = rowData[2];
				String company = rowData[3];
				double Salary = Double.parseDouble(rowData[4]);
				String bday = rowData[5];
			
				Contact s1=new Contact(id,name,phoneNumber,company,Salary,bday);
				contactList.add(s1);
				line=br.readLine();
			}
			
		}catch(IOException ex){
			System.out.println(ex);
		}
		return contactList;
	}
        
		
}
 
