package Actions;

import java.util.ArrayList;

public class Task {
	
	private int arrTime;
	private int proccTime;
	private int nr;
	private int finalTime;
	
	public Task(int arr, int pro, int nr)
	{
		this.arrTime=arr;
		this.proccTime=pro;
		this.nr=nr;
		this.finalTime=0;
	}
	

	public int getFinalTime() {
		return finalTime;
	}


	public void setFinalTime(int waitPer)
	{
		this.finalTime = arrTime+proccTime+waitPer;
	}
	
	
	public int getArrTime() {
		return arrTime;
	}

	public void setArrTime(int arrTime) {
		this.arrTime = arrTime;
	}

	public int getProccTime() {
		return proccTime;
	}

	public void setProccTime(int proccTime) {
		this.proccTime = proccTime;
	}

	public String listTask()
	{
		return "Task-ul "+nr+" are timpul de sosire "+arrTime+", timpul de procesare "+proccTime;
	}
	public String lsDel()
	{
		return "Task-ul "+nr+" a fost eliminat din ";
	}
	
	public String list()
	{
		return "Task "+nr+"->";
	}


	public int getNr() {
		return nr;
	}


	public void setNr(int nr) {
		this.nr = nr;
	}
	
}
