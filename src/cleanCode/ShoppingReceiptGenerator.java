package cleanCode;

import java.util.List;

public class ShoppingReceiptGenerator {

	public static List<String> generateReceipt(List<String> shoppingList) {
		ShoppingBill shoppingBill = new ShoppingBill();
		shoppingBill = Converter.convertInputToShoppingBill(shoppingList, shoppingBill);
		shoppingBill = TaxCalculator.updateShoppingBillWithTax(shoppingBill);
		shoppingBill = BillAmountCalculator.updateShoppingBillWithBillAmount(shoppingBill);
		List<String> outputReceipt = Converter.convertShoppingBillToOutput(shoppingList, shoppingBill);
		return outputReceipt;
	}

}
