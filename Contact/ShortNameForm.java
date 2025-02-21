import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.io.*;

 class ShortNameForm extends JFrame{
	private JButton btnReload;
	private JButton btnBack;
	
	private JTable tblContact;
	private DefaultTableModel dtm;
	
	ShortNameForm(){
		setSize(800,600);
		setTitle("List By Name");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel("LIST BY NAME");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnReload = new JButton("Reload");
		btnReload.setFont(new Font("",1,16));	
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
			sortByName();
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
		String[] columnName = {"Contact ID","Contact Name","Phone Number","Company  Name","Salary","Birth Day"};
		dtm=new DefaultTableModel(columnName,0);
		tblContact=new JTable(dtm);
		JScrollPane tablePanel=new JScrollPane(tblContact);
		add("Center",tablePanel);
		
		}
		
		public  void sortByName(){
			List contactList = getAllContact();
			for(int i = contactList.size();i>0;i--){
				String maxName = contactList.get(0).getName();
				int index = 0;
				int result = 0;
				for(int j = 0;j<i;j++){
				    result = maxName.compareTo(contactList.get(j).getName());
					if(result<0){
						maxName=contactList.get(j).getName();
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
