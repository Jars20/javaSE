package club.banyuan.company;
import club.banyuan.stuff.Stuff;


public class Company{
	public int num = 0;
	public Stuff[] arr = new Stuff[100];

	public void add(Stuff newstuff){
		arr[num] = newstuff;
		num++;
	}

	public void delete(String name1){
		int flag = 0;
		for(int i =0;i<num;i++){
			if (arr[i].name.equals(name1)) {
				for(int k=i;k<num-1;k++){
					arr[k]=arr[k+1];
				}
				num--;
				flag = 1;

			}

		}
		if (flag==0){
			System.out.printf("该员工不在公司内\n");
		}

	}
	public int display(String name1){
		for(int i =0;i<num;i++){
			if (arr[i].name.equals(name1)) {
			System.out.println(name1+"员工工资为"+arr[i].countSalary());
			return 1;			
			}
		}
		System.out.printf("该员工不在公司内\n");
		return 0;
	}
	public void sum(){
		int m = 0;
		for(int i = 0; i < num; i++){
			m += arr[i].countSalary();
		}
		System.out.printf("总共有%d位员工，工资和为%d\n",num,m);
		return;
	}

}
