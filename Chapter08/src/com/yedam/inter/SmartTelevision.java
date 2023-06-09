package com.yedam.inter;

public class SmartTelevision implements RemoteControl, Searchable {
	
	private int volume;
	
	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다");

	}

	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다");

	}

	@Override
	public void turnOff() {
		System.out.println("tv를 끕니다");

	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			// 0<= volume <=10
			this.volume = volume;
		}
		System.out.println("현재 smart tv 볼륨 : " + this.volume);
	}

}
