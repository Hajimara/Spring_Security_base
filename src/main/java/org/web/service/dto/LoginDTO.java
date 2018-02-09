package org.web.service.dto;


	/*	VO(value Object)와 DTO(Data Transfer Object)
	 * 
	 * 일반적으로 컨트롤러에 전달되는 데이터를 수집하는 용도로 VO를 사용하는 경우도 잇고, DTO를 사용하는 경우가 있다. 용어의 구분
	 * 공통점 - 데이터의 수집과 전달에사용할 수 있다는 것. 파라미터나 리턴 타입으로 사용하는 것이 가능
	 * VO는 DB와의 거리가 가깝다. 테이블 구조를 이용해서 작성되는 경우가 많다
	 * DTO는 화면과 가까워 화면에서 전달되는 데이터를 수집하는 용도로 사용
	 * 
	 * */
public class LoginDTO {

	private String uid;
	private String pw;
	private boolean useCookie;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "["+"uid : "+uid
				+" / pw : "+pw
				+" / useCookie : "+useCookie + "]";
	}
}
