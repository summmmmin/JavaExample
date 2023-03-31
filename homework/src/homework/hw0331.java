package homework;

public class hw0331 {
//	Question 1]
//			1) Employee 클래스를 정의한다.
//				- 이름과 연봉을 필드로 가지며 생성자를 이용하여 값을 초기화한다.
//				- 각 필드의 getter만 존재한다.
//				- 메소드는 다음과 같이 정의한다.
//				(1) public void getInformation() : 이름과 연봉을 출력하는 기능
//				(2) public void print() : "수퍼클래스"란 문구를 출력하는 기능
//				
//			2) EmpDept 클래스를 정의한다.
//				- Employee 클래스를 상속한다.
//				- 추가로 부서이름을 필드로 가지며 생성자를 이용하여 값을 초기화한다.
//				- 추가된 필드의 getter를 정의한다.
//				- Employee 클래스의 메소드를 오버라이딩한다.
//				(1) public void getInformation() : 이름과 연봉, 부서를 출력하는 기능
//				(2) public void print() : "수퍼클래스\n서브클래스"란 문구를 출력하는 기능
//				
//			3) 아래와 같은 출력결과가 나오도록 실행코드를 구현한다.
//			- 출력결과
//				이름:이지나  연봉:3000  부서:교육부
//				수퍼클래스
//				서브클래스
//
//		 
//		Question 2]
//			1) Human 클래스를 정의한다.
//				- 이름과 키, 몸무게를 필드로 가지며 생성자를 이용하여 값을 초기화한다.
//				- 메소드는 다음과 같이 정의한다.
//				(1) public void getInformation() : 이름, 키와 몸무게를 출력하는 기능
//				
//			2) StandardWeightInfo 클래스를 정의한다.
//				- Human 클래스를 상속한다.
//				- 메소드는 다음과 같이 정의한다.
//				(1) public void getInformation() : 이름, 키, 몸무게와 표준체중을 출력하는 기능
//				(2) public double getStandardWeight() : 표준체중을 구하는 기능
//				( * 표준 체중 : (Height - 100) * 0.9 )
//			
//			3) ObesityInfo 클래스를 정의한다.
//				- StandardWeightInfo 클래스를 상속한다.
//				- 메소드는 다음과 같이 정의한다.
//				(1) public void getInformation() : 이름, 키, 몸무게와 비만도를 출력하는 기능
//				(2) public double getObesity() : 비만도를 구하는 기능
//				( * 비만도 : (Weight - 표준 체중)/표준체중 * 100 )
//				BMI가 18.5 이하면 저체중 ／ 18.5 ~ 22.9 사이면 정상 ／ 23.0 ~ 24.9 사이면 과체중 ／ 25.0 이상부터는 비만
//				
//			4) 아래와 같은 출력결과가 나오도록 실행코드를 구현하다.
//			- 출력결과
//				홍길동님의 신장 168, 몸무게 45, 표준체중 61.2 입니다.
//				박둘이님의 신장 168, 몸무게 90, 비만입니다.
//			- 조건
//				변수는 Human 클래스 타입으로 선언하여 하나만 사용한다.
//				

}
