package memo;

import java.io.Serializable;

public class Memo implements Serializable{

	private int mid;
	private String title;
	private String body;


	public Memo() {}
	public Memo(int a,String b,String c) {
		this.mid = a;
		this.title = b;
		this.body = c;
	}
	public void setMid(int a) {
		this.mid= a;
	}
	public void setTitle(String a) {
		this.title= a;
	}
	public void setBody(String a) {
		this.body= a;
	}

	public int getMid() {
		return this.mid;
		}
	public String getTitle() {
		return this.title;
		}
	public String getBody() {
		return this.body;
		}

}
