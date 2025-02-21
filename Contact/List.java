public class List{
	private int intSize;
	private double loadFact;
	private Contact[] contactArray;
	private int nextIndex;
	
	public List(int intSize, double loadFact){
		this.intSize=intSize;
		this.loadFact=loadFact;
		contactArray=new Contact[intSize];
		nextIndex=0;
	}
	public boolean add(Contact contact){
		if(isEmpty()){
			extendsArray();
		}
		contactArray[nextIndex++]=contact;
		return true;
	}
	private void extendsArray(){
		Contact[] tempContactArray=new Contact[(int)(contactArray.length*(1+loadFact))];
		for (int i = 0; i < contactArray.length; i++){
			tempContactArray[i]=contactArray[i];
		}
		contactArray=tempContactArray;

	}
	public boolean isEmpty(){
		return nextIndex<=0;
	}
	public boolean add(int index, Contact contact){
		if(isEmpty()){
			extendsArray();
		}
		if(index>=0 && index<=nextIndex){
			for(int i=nextIndex-1; i>=index; i--){
				contactArray[i+1]=contactArray[i];
			}
			contactArray[index]=contact;
			return true;
		}
		return false;
	}
	public boolean remove(int index){
	  if(index>=0 && index<nextIndex){
		  for(int i = index;i<nextIndex-1;i++){
			  contactArray[i]=contactArray[i+1];
			  return true;
		  }
		  return false;
	}
	return false;
}
	public Contact get(int index){
		if(index>=0 && index<nextIndex){
			return contactArray[index];
		}
		return null;
	}
	public void printList(){
		System.out.print("[");
		for(int i=0; i<nextIndex; i++){
			System.out.print(contactArray[i]+", ");
		}
		System.out.println(isEmpty()? "empty]":"\b\b]");

	}
	
	public int indexOf(Contact[] contact){
		for(int i =0;i<nextIndex;i++){
			if(contactArray[i].equals(contact)){
				return i;
			}
			return -1;
		}
		return -1;
	}
	public boolean search(Contact[] contact){
		for(int i = 0;i<nextIndex;i++){
			if(contactArray[i].equals(contact)){
				return true;
			}
		}
		return false;
	}
	public int size(){
		return nextIndex;
	}
	public void set(int a,Contact c){
		contactArray[a]=c;
	}
	
}
