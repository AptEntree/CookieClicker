package cookie.objects;

public class Supporter extends Upgrade{
	
	private int valuePs;
	private int qtd;
	
	public int getValuePs() {
		return valuePs;
	}
	public void setValuePs(int valuePs) {
		this.valuePs = valuePs;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public Supporter(int id, int price, int level, String desc, String name, int valuePs) {
		super(id, price, level, desc, name);
		this.valuePs = valuePs;
		this.qtd = 0;
	}
	
	

}
