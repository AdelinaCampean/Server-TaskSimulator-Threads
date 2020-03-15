package Actions;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


import GUI.ViewI;
import Simulation.SimulationManager;

public class Server implements Runnable{
	
	private int numberOfServer;
	private ArrayBlockingQueue<Task> tasks = new ArrayBlockingQueue<Task>(40);
	private AtomicInteger waitingPeriod = new AtomicInteger();
	private ViewI myV;

	public Server(int nr)
	{	numberOfServer=nr;		
		waitingPeriod.set(0);
	}	
	
	public int getNumberOfServer() {
		return numberOfServer;
	}

	public void setNumberOfServer(int numberOfServer) {
		this.numberOfServer = numberOfServer;
	}
	
	public BlockingQueue<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayBlockingQueue<Task> tasks) {
		this.tasks = tasks;
	}

	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(int waitingPeriod) {
		this.waitingPeriod.set(waitingPeriod);
	}

	public  void addTask(Task newTask,ViewI myV)
	{	
		this.myV=myV;

		tasks.add(newTask);

		if(this.numberOfServer==1)
		{
			myV.setServer1(myV.getServer1()+newTask.list());
		}
		else if(this.numberOfServer==2)
		{
			myV.setServer2(myV.getServer2()+newTask.list());
		}
		else if(this.numberOfServer==3)
		{
			myV.setServer3(myV.getServer3()+newTask.list());
		}
		else if(this.numberOfServer==4)
		{
			myV.setServer4(myV.getServer4()+newTask.list());
		}
		this.waitingPeriod.addAndGet(newTask.getProccTime());

		

	}
	
	public  void delete(Task tsk)
	{
		
		if(this.numberOfServer==1)
		{	String aux=myV.getServer1().replace("Task "+tsk.getNr()+"->","");
			myV.setServer1(aux);
		}
		else if(this.numberOfServer==2)
		{
			String aux=myV.getServer2().replace("Task "+tsk.getNr()+"->","");
			myV.setServer2(aux);
		}
		else if(this.numberOfServer==3)
		{
			String aux=myV.getServer3().replace("Task "+tsk.getNr()+"->","");
			myV.setServer3(aux);		}
		else if(this.numberOfServer==4)
		{
			String aux=myV.getServer4().replace("Task "+tsk.getNr()+"->","");
			myV.setServer4(aux);		}
		
		
	}
	
	public  void run() {

		while(true)
		{
			try {
				Task tsk = tasks.take();
			
				this.waitingPeriod.set(this.waitingPeriod.intValue()-tsk.getProccTime());

				Thread.sleep(tsk.getProccTime()*1000);
				
				delete(tsk);
					
			
				//System.out.println("aaa"+tsk.getFinalTime());
				myV.setTextArea(myV.getTextArea()+"\n"+tsk.lsDel()+toString()+" avand timpul de finalizare "+tsk.getFinalTime());
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public String toString() {
		return "Server " + this.numberOfServer;
	}
	public String listS() {
		return " si a fost introdus in server-ul "+this.numberOfServer;
	}
}
