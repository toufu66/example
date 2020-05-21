package sankaku;
import java.io.Serializable;
public class Sankaku implements Serializable{
	private int teihen;
	private int takasa;
	private double menseki;

	public Sankaku() {}
	public Sankaku(int a,int b) {
		this.teihen = a;
		this.takasa = b;
		this.menseki = a * b *0.5;

	}
	public void setTeiten(int a) {
		this.teihen = a;
	}
	public void setTakasa(int a) {
		this.takasa = a;
	}
	public void setMenseki() {
		this.menseki = this.teihen * this.takasa *0.5;
	}

	public int getTeihen() {
		return this.teihen;
	}
	public int getTakasa() {
		return this.takasa;
	}
	public double getMenseki() {
		return this.menseki;
	}

}
