package Actions;

import java.util.ArrayList;

import GUI.ViewI;

public class Strategy {

	public Strategy ()
	{
		
	}
	
	public Server find_min_time (ArrayList <Server> servers)
	{	
		int min=99999;
		int index=0;
		for (Server s: servers)
			{
			
				if(s.getWaitingPeriod().intValue()<min)
				{
					min = s.getWaitingPeriod().intValue();
					index = servers.indexOf(s);
					
				}
			}
		return servers.get(index);
	}
	
	
	
	public String add_Task(ArrayList <Server> servers, Task ts,ViewI vi)
	{	
		String a;
		Server serv = find_min_time(servers);
		ts.setFinalTime(serv.getWaitingPeriod().intValue());

		serv.addTask(ts,vi);

		//servers.set(servers.indexOf(serv), serv);
		 a=serv.listS();
		 return a;
	}
	
}
