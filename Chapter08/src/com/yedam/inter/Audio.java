package com.yedam.inter;

public class Audio implements RemoteControl{
	
	//Audio volume 측정하기 위한 변수
	private int volume;
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("오디오를 켭니다");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("오디오를 끕니다");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			// 0<= volume <=10
			this.volume = volume;
		}
		
		System.out.println("현재 오디오 볼륨 : "+this.volume);
	}

	
}
