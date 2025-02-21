import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.table.*;
import java.time.*;
import java.io.*;


class SortBirthdayForm extends JFrame {
	
	 private JButton btnReload;
	 private JButton btnBack;
	 
	 private JTable tblContact;
	 private DefaultTableModel dtm;
	 
	 public SortBirthdayForm(){
		 
		setTitle("List By Birthday");
		setSize(700, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
		
		
		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel titleLabel = new JLabel("List By Birthday");
		titleLabel.setFont(new Font("",1,28));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		titlePanel.setBackground(new Color(173,216,230));
		
		add("North",titlePanel);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("",1,16));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				sortByBday();
				dtm.setRowCount(0);
				List contactList = getAllContact();
				for(int i = 0; i<contactList.size(); i++){
					Contact c1 =contactList.get(i);
					Object[] rowData ={c1.getID(),c1.getName(),c1.getPhoneNumber(),c1.getCompanyName(),c1.getSalary(),c1.getBday()};
					dtm.addRow(rowData);
				}
			}
		});
		btnPanel.add(btnReload);
		
		add("South",btnPanel);
		 
		String[] columnName = {"Contact ID", "Name", "Contact Number", "Company", "Salary", "Birthday"};
		dtm = new DefaultTableModel(columnName,0);
		tblContact = new JTable(dtm);
		JScrollPane tablePanel = new JScrollPane(tblContact);
		add("Center",tablePanel);
	}
		public void sortByBday(){
			List contactList = getAllContact();
			for(int i = contactList.size(); i>0; i--){
				String maxBday = contactList.get(0).getBday();
				int index = 0;
				int result = 0;
				for(int j=0; j<i; j++){
					result = maxBday.compareTo(contactList.get(j).getBday());
					if(result<0){
						maxBday=contactList.get(j).getBday();
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
        
		

		
		
		
	 
 
