package club.banyuan.companyMain;
import club.banyuan.company.Company;
import club.banyuan.stuff.Stuff;


public class CompanyMain{

	public static void main(String[] args) {
		Company sell = new Company();
		Stuff s1 = new Stuff();
		s1.setTime(205);
		s1.name = "s1";
		
		Stuff s2 = new Stuff();
		s2.setTime(220);
		s2.name = "s2";

		Stuff s3 = new Stuff();
		s3.setTime(180);
		s1.name = "s3";

		Stuff s4 = new Stuff();
		s4.setTime(196);
		s1.name = "s4";

		sell.add(s1);
		sell.add(s2);
		sell.add(s3);
		sell.add(s4);


		sell.sum();


		sell.delete("s3");



	}

}