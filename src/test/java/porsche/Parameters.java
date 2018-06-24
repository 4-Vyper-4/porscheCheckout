package porsche;

public class Parameters {
	String winHandleBefore;
	String winHandleAfter;	
	String currentWinhandle;
	long basePrice;
	long equipmentPrice;
	long total;
	long shipCost;
	long color;
	long wheel;
	long seats;
	long interior;
	long pdk;
	long pccb;
	
	public long getBasePrice() {
		return this.basePrice;
	}
	public void setBasePrice(String basePriceS) {
		basePriceS = TextTrim.TextTrimmer(basePriceS);
		basePrice = 0;
		this.basePrice = Long.parseLong(basePriceS);
	}
	public long getEquipmentPrice() {
		return this.equipmentPrice;
	}
	public void setEquipmentPrice(String equipmentPriceS) {
		equipmentPriceS = TextTrim.TextTrimmer(equipmentPriceS);
		this.equipmentPrice = Long.parseLong(equipmentPriceS);
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(String totalS) {
		totalS = TextTrim.TextTrimmer(totalS);
		total = 0;
		total = Long.parseLong(totalS);
	}
	public long getShipCost() {
		return shipCost;
	}
	public void setShipCost(String shipCostS) {
		shipCostS = TextTrim.TextTrimmer(shipCostS);
		shipCost = 0;
		this.shipCost = Long.parseLong(shipCostS);
	}
	public long getColor() {
		return color;
	}
	public void setColor(String colorS) {
		colorS = TextTrim.TextTrimmer(colorS);
		this.color = Long.parseLong(colorS);
	}
	public long getWheel() {
		return wheel;
	}
	public void setWheel(String wheelS) {
		wheelS = TextTrim.TextTrimmer(wheelS);
		this.wheel = Long.parseLong(wheelS);
	}
	public long getSeats() {
		return seats;
	}
	public void setSeats(String seatsS) {
		seatsS = TextTrim.TextTrimmer(seatsS);
		this.seats = Long.parseLong(seatsS);
	}
	public long getInterior() {
		return this.interior;
	}
	public void setInterior(String interiorS) {
		interiorS = TextTrim.TextTrimmer(interiorS);
		this.interior = Long.parseLong(interiorS);
	}
	public long getPdk() {
		return this.pdk;
	}
	public void setPdk(String pdkS) {
		pdkS = TextTrim.TextTrimmer(pdkS);
		pdk = Long.parseLong(pdkS);
	}
	public long getPccb() {
		return this.pccb;
	}
	public void setPccb(String pccbS) {
		pccbS = TextTrim.TextTrimmer(pccbS);
		pccb = Long.parseLong(pccbS);
	}
	
}
