package homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LocalDateTime now = LocalDateTime.now();
		 String convertedDate1 = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		 System.out.println(now);
		 System.out.println("convertedDate1 : " + convertedDate1);
		 
	}

}
