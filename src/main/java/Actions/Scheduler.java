package Actions;

import java.util.ArrayList;

import GUI.ViewI;

public class Scheduler {
	
	private ArrayList<Server> servers;
	private int MaxServers;

	private int MaxTasks;
	private Strategy strategy ;
	
	
	public Scheduler( int MaxServers, int MaxTasks)
	{	
		this.MaxServers=MaxServers;
		this.MaxTasks=MaxTasks;
		this.servers=new ArrayList<Server>(MaxServers);
		int m = MaxServers;		
		int i=0;
		while(i<MaxServers)
		{
			Server s = new Server(i+1);
			servers.add(s);
			//s.setWaitingPeriod(0);
			i++;
			Thread tr = new Thread(s);			
			tr.start();
			
		}
		strategy = new Strategy();

	}
	
	public float averageTime()
	{
		
		float med=0;
		
		for (Server sp: servers)
		{
			med+=sp.getWaitingPeriod().intValue();
			//nr_task+=sp.getTasks().size();
		}
		
		return med;
	}
	
	
	
	public String dispatchT(Task ts,ViewI v)
	{	
		String a=strategy.add_Task(servers,ts,v);
		return a;
	}
	
	public ArrayList<Server> getServers() {
		return servers;
	}

	public void setServers(ArrayList<Server> servers) {
		this.servers = servers;
	}


}
