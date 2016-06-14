package cleanCode;

public class BillAmountCalculator {

	public static ShoppingBill updateShoppingBillWithBillAmount(ShoppingBill shoppingBill) {
		double totalBillAmount = 0;
		for (ShoppingItem item : shoppingBill.getShoppingItems()) {
			totalBillAmount += item.getPriceIncludingTax();
		}
		totalBillAmount = Math.round(totalBillAmount * 100.0) / 100.0;
		shoppingBill.setTotalBillAmount(totalBillAmount);
		return shoppingBill;
	}
}
