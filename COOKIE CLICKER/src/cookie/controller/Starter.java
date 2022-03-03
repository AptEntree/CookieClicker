package cookie.controller;

import java.util.ArrayList;

import cookie.objects.PowerUp;
import cookie.objects.Supporter;

public class Starter {
	public ArrayList<Supporter> sup;
	public ArrayList<PowerUp> pow;
	public Starter(ArrayList<Supporter> supporter, ArrayList<PowerUp> powerUp) {
		this.sup = supporter;
		this.pow = powerUp;
		
	}
	public ArrayList<Supporter>  startSup() {
		sup.add(new Supporter(0, 10, 1, "Primeiro Suport", "Supp 1", 1));
		sup.add(new Supporter(1, 15, 1, "Segundo Suport", "Supp 2", 2));
		sup.add(new Supporter(2, 20, 1, "Terceiro Suport", "Supp 3", 3));
		
		return sup;
	}
	public ArrayList<PowerUp> startPow() {
		pow.add(new PowerUp(0, 10, 1, "Primeiro PowerUp", "PowerUp 1", 0, 2));
		pow.add(new PowerUp(1, 15, 1, "Segundo PowerUp", "PowerUp 2", 1.5, 0));
		pow.add(new PowerUp(2, 20, 1, "Terceiro PowerUp", "PowerUp 3", 2.0, 1));
		return pow;
	}

}
