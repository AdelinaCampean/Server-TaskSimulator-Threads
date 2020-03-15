package Simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import Actions.Scheduler;
import Actions.Server;
import Actions.Strategy;
import Actions.Task;
import GUI.ViewI;
import Actions.Task;


public class SimulationManager  
{
	
	private ViewI myV;
	private ArrayList<Task> generatedTsks = new ArrayList<Task>();
	private int min;
	private int max;
	private int min2;
	private int max2;
	private int sim;
	
	public int getSim() {
		return sim;
	}


	public void setSim(int sim) {
		this.sim = sim;
	}


	private int nrTask;
	private int combo;
	private Scheduler sch;
	
	
	
	public SimulationManager(ViewI v)
	{
		myV=v;
		myV.addListenerButon(new start());
		
	}
	
	
	class start implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			myV.frame2();
			max=myV.getMaxim();
			min=myV.getMinim();
			max2=myV.getMaxim2();
			min2=myV.getMinim2();
			sim=myV.getSim();
			nrTask=myV.getTask();
			combo=myV.getComboBox();
			sch = new Scheduler(combo,nrTask);

			
			
			int nr2 = nrTask;
			int i=1;
			while(nr2>0)
			{
				Task k = randomtask(min,max,min2,max2,i);
				generatedTsks.add(k);
				i++;
				nr2--;
			}
			
			for (Task k: generatedTsks)
				
				System.out.println(k.listTask());
			
			
			
			Simulator simulate = new Simulator(myV, generatedTsks,sim, sch);
			
			Thread th = new Thread(simulate);
			th.start();
				
		}
		
		public Task randomtask (int minarr, int maxarr, int minproc, int maxproc, int i)
		{ 
			
			int arr = minarr + (int)(Math.random() * (maxarr - minarr));
			int proc = minproc + (int)(Math.random() * (maxproc - minproc));
		
			Task task1 = new Task(arr, proc,i);
			
			return task1;
		}
	}

	
	
}
