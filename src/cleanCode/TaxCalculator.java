package cleanCode;

import java.text.DecimalFormat;

public class TaxCalculator {
	private static final String IS_TAX_EXEMPT = "isTaxExempt";
	private static final String IS_IMPORTED = "isImported";

	public static ShoppingBill updateShoppingBillWithTax(ShoppingBill shoppingBill) {
		double totalShoppingTax = 0;
		for (ShoppingItem item : shoppingBill.getShoppingItems()) {
			item = updateShoppingItemWithTax(item);
			totalShoppingTax += item.getItemTax();
		}
		totalShoppingTax = Math.round(totalShoppingTax * 20.0) / 20.0;
		shoppingBill.setTotalSalesTax(totalShoppingTax);
		return shoppingBill;
	}

	private static ShoppingItem updateShoppingItemWithTax(ShoppingItem shoppingItem) {
		double taxAmount = 0, taxPercent = 0, itemPrice, roundedtax, priceIncludingTax;
		taxPercent += (boolean) shoppingItem.getItemTaxAttributes().get(IS_TAX_EXEMPT) ? 0 : 10;
		taxPercent += (boolean) shoppingItem.getItemTaxAttributes().get(IS_IMPORTED) ? 5 : 0;
		itemPrice = shoppingItem.getPriceWithoutTax();
		taxAmount = (taxPercent / 100.00) * itemPrice;
		roundedtax = Math.round(taxAmount * 20.0) / 20.0;
		shoppingItem.setItemTax(roundedtax);
		priceIncludingTax = Double.parseDouble(new DecimalFormat("#.##").format(itemPrice + roundedtax));
		shoppingItem.setPriceIncludingTax(priceIncludingTax);
		return shoppingItem;
	}
}
