package training;

import java.util.ArrayList;
import java.util.List;

public class MyList implements Runnable {

	private List<Integer> list = new ArrayList<>();

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		if (Thread.currentThread().getName().toString().equals("adder"))
		{
			System.out.println("addder running");
			for (int count = 0; count < 500; count++)
			{
				myListAdder(count);
			}
		}
		else if (Thread.currentThread().getName().toString().equals("remover"))
		{
			System.out.println("remover running");
			for (int count = 0; count < 500; count++)
			{
				myListRemover();
			}
		}
	}

	public void myListAdder(int num)
	{
		synchronized (this)
		{
			if (list.isEmpty())
			{
				list.add(num);
				notify();
			}
			else
			{
				list.add(num);
			}
			System.out.println(num + " added to the list");
		}
	}

	public void myListRemover()
	{
		synchronized (this)
		{
			if (list.isEmpty() == true)
			{
				try
				{
					wait();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			System.out.println(list.get(0)+" is removed");
			list.remove(0);
		}
	}
}