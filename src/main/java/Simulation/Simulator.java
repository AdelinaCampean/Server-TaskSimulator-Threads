package Simulation;

import java.util.ArrayList;

import Actions.Scheduler;
import Actions.Task;
import GUI.ViewI;

public class Simulator implements Runnable {

	private ViewI myV;
	private ArrayList<Task> generatedTsks;
	private int sim;
	private Scheduler sch;
	
	public Simulator(ViewI v, ArrayList<Task> generatedTsks, int sim, Scheduler sch )
	{
		this.generatedTsks=generatedTsks;
		this.myV=v;
		this.sim=sim;
		this.sch=sch;
	}
	

	public void run()
	{
		
		int crrTime=0;
	
		while(crrTime < sim)
		{
			for(Task t:generatedTsks)
			{
				if(t.getArrTime() == crrTime)
				{
					String a=sch.dispatchT(t,myV);
					
					myV.setTextArea(myV.getTextArea()+"\n"+t.listTask()+a);
					float b=sch.averageTime();
					//System.out.println(b/generatedTsks.size());
					float x=b/generatedTsks.size();
																							 																					//	if(x<0) x=-b/generatedTsks.size();
					myV.setAvg(x);
					
				}
			}
			crrTime++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
