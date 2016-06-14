package cleanCode;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBill {
	private List<ShoppingItem> shoppingItems = new ArrayList<ShoppingItem>(0);
	private double totalSalesTax;
	private double totalBillAmount;

	public List<ShoppingItem> getShoppingItems() {
		return shoppingItems;
	}

	public void setShoppingItems(List<ShoppingItem> shoppingItems) {
		this.shoppingItems = shoppingItems;
	}

	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	public void setTotalSalesTax(double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

}
