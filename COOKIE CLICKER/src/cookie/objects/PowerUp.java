package cookie.objects;

public class PowerUp extends Upgrade{

	private double modfier;
	private int status;
	private int basePower;
	public double getModfier() {
		return modfier;
	}
	public void setModfier(double modfier) {
		this.modfier = modfier;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBasePower() {
		return basePower;
	}
	public void setBasePower(int basePower) {
		this.basePower = basePower;
	}
	
	public PowerUp(int id, int price, int level, String desc, String name, double modfier, int basePower) {
		super(id, price, level, desc, name);
		this.modfier = modfier;
		this.status = 1;
		this.basePower = basePower;
	}
	
	
	

}
