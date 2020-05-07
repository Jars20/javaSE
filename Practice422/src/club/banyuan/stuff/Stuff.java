package club.banyuan.stuff;

public class Stuff{
	public String name;
	private int worktime ;
	public int salary = 8000;
	public void setTime(int time){
		worktime = time;
	}
	public int countSalary(){
		if(worktime > 196){
			salary = salary + (worktime - 196) *200;
			return salary;
		}
		else
			return salary;

	}

}
