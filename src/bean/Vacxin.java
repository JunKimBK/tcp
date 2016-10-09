package bean;

public class Vacxin {
	private String tenvacxin;
	private int somui;
	public String getTenvacxin() {
		return tenvacxin;
	}
	public void setTenvacxin(String tenvacxin) {
		this.tenvacxin = tenvacxin;
	}
	public int getSomui() {
		return somui;
	}
	public void setSomui(int somui) {
		this.somui = somui;
	}
	public Vacxin(String tenvacxin, int somui) {
		super();
		this.tenvacxin = tenvacxin;
		this.somui = somui;
	}
	public Vacxin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
