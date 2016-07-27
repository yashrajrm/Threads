package training;

public class ListExecute {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MyList myList = new MyList();
		Thread adderThread = new Thread(myList);
		adderThread.setName("adder");
		Thread removerThread = new Thread(myList);
		removerThread.setName("remover");
		adderThread.start();
		removerThread.start();
	}

}
