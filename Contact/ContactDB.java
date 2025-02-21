class ContactDB{
	private List contactList;
	private static ContactDB contactDB;
	private ContactDB(){
		this.contactList=new List(100,0.5);
	}
	public List getContactList(){
		return contactList;
	}
	public static ContactDB getInstance(){
		if(contactDB==null){
			contactDB=new ContactDB();
		}
		return contactDB;
	}
}
