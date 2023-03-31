package homework;

import java.util.Scanner;

public class hw0330 {
	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		//	출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		Scanner sc = new Scanner(System.in);
		int pdtNum = 0;
		Product[] pdtAry = null;
		boolean run = true;
		
		while(run) {
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.print("메뉴입력>");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch (selectNo) {
			case 1:
				System.out.print("상품수>");
				pdtNum = Integer.parseInt(sc.nextLine());
				break;
			case 2:
				pdtAry = new Product[pdtNum];
				for(int i=0; i<pdtNum; i++) {
					pdtAry[i] = new Product();
					System.out.print("상품 : ");
					String name = sc.nextLine();
					pdtAry[i].name = name;
					
					System.out.print("가격 : ");
					int price = Integer.parseInt(sc.nextLine());
					pdtAry[i].price = price;
				}
				break;
			case 3:
				for(int i=0; i<pdtNum; i++) {
					System.out.println(pdtAry[i].name+" : "+pdtAry[i].price);
				}
				break;
			case 4:
				int sum =0;
				int max = pdtAry[0].price;
				int maxidx = 0;
				for(int i=0; i<pdtNum; i++) {
					if(max< pdtAry[i].price) {
						max = pdtAry[i].price;
						maxidx = i;
					}
					sum += pdtAry[i].price;
				}
				System.out.println("최고 가격을 가지는 제품 : "+ pdtAry[maxidx].name);
				System.out.println("최고 가격 제외한 제품들의 총합 : " +(sum-max));
				break;
			case 5:
				System.out.println("프로그램 종료");
				run = false;
			}
		}

	}
}
