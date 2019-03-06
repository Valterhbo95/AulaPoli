package entitie;

public class ImportedProduct extends Product {
	private Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomFee() {
		return customsFee;
	}

	public void setCustomFee(Double customsFee) {
		this.customsFee = customsFee;

	}

	@Override
	public String princeTag() {
		return getName() +" $ "+String.format("%.2f", totalPrice())+" (Customs fee $: "+ String.format("%.2f", getCustomFee())+")";

	}

	public Double totalPrice() {
		return super.getPrice() + this.getCustomFee();
	}

}
