package com.hw.hw0403;

public class PortableNotebook implements Notebook, Tablet {
	
	private int mode = 1;
	public String program;
	public String browser;
	public String video;
	public String app;
	
	public PortableNotebook(String program, String browser, String video, String app) {
		this.program = program;
		this.browser = browser;
		this.app = app;
		this.video = video;
		System.out.println("normal_mode");
	}
	@Override
	public void watchVideo() {
		System.out.println(this.video + " 를 시청");

	}

	@Override
	public void useApp() {
		if(mode == Notebook.NOTEBOOK_MODE) {
			mode = Tablet.TABLET_MODE;
			System.out.println(this.app + " 실행");			
		}else if(mode == Tablet.TABLET_MODE) {
			System.out.println(this.app + " 실행");
		}

	}

	@Override
	public void writeDocumentation() {
		// TODO Auto-generated method stub
		System.out.println(this.program + " 을 통해 문서 작성");
	}

	@Override
	public void searchInternet() {
		// TODO Auto-generated method stub
		System.out.println(this.browser+" 를 통해 인터넷 검색");
	}
	
	public void changeMode() {
		if(mode == Notebook.NOTEBOOK_MODE) {
			mode = Tablet.TABLET_MODE;
			System.out.println("TABLET_MODE");			
		}else if(mode == Tablet.TABLET_MODE) {
			mode = Notebook.NOTEBOOK_MODE;
			System.out.println("NOTEBOOK_MODE");
		}
	}

}
