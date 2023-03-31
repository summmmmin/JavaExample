package com.yedam.inheri;

public class DmbCellPhone extends CellPhone {
	//자식 클래스
	//필드
	int channel;
	
	//생성자
	public DmbCellPhone(int channel, String color, String model) {
		//부모 클래스에 있는 생성자를 사용하는 키워드 : super()
		super(model, color);
		this.channel = channel;
	}
	//메소드
	public void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신");
	}
	
	public void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
