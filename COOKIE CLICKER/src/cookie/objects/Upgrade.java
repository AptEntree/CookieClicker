package cookie.objects;

public class Upgrade {
	private int id;
	private int price;
	private int level;
	private String desc;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Upgrade(int id, int price, int level, String desc, String name) {
		super();
		this.id = id;
		this.price = price;
		this.level = level;
		this.desc = desc;
		this.name = name;
	}
	public Upgrade() {}
	
}
