
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintTxt {
	
	public void print(User user){
		//User user = new User();
		try{
			
			File file = new File("C:/Users/�����/Desktop/resume.txt");
			PrintWriter print =  new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			
			print.println("���������|������ �� ��������|���|�/�|����� ������|������ ������|�����������|���� ������|���|�������|���� �����������");
			
			print.println(user.getPosition()+"|"+user.getUrlUser()+"|"+user.getName()+"|"+user.getMoney()+"|"+user.getPlaceOfWork()+"|"+user.getSchedule()+"|"+user.getEducation()+"|"+user.getExperience()+"|"+user.getSex()+"|"+user.getAge()+"|"+user.getDateReg());
			print.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}