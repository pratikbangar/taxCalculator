package cleanCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Converter {
	private static final String QUANTITY = "quantity";
	private static final String ITEM_NAME = "itemName";
	private static final String PRICE_WITHOUT_TAX = "priceWithoutTax";
	private static final String IS_TAX_EXEMPT = "isTaxExempt";
	private static final String IS_IMPORTED = "isImported";
	private static final String IMPORTED = "imported";
	private static final String AT = " at ";
	private static final String COLON_SEPARATOR = ": ";
	private static final String SALES_TAX = "Sales Taxes: ";
	private static final String TOTAL = "Total: ";

	public static ShoppingBill convertInputToShoppingBill(List<String> shoppingList, ShoppingBill shoppingBill) {
		for (String shoppingItemString : shoppingList) {
			ShoppingItem item = ShoppingItem.from(shoppingItemValues(shoppingItemString));
			shoppingBill.getShoppingItems().add(item);
		}
		return shoppingBill;
	}

	public static List<String> convertShoppingBillToOutput(List<String> shoppingList, ShoppingBill shoppingBill) {
		int i = 0;
		for (String shoppingItemString : shoppingList) {
			shoppingItemString = shoppingItemString.replace(AT, COLON_SEPARATOR);
			String priceWithoutTax = shoppingItemString.substring(shoppingItemString.indexOf(COLON_SEPARATOR) + 2,
					shoppingItemString.length());
			ShoppingItem item = shoppingBill.getShoppingItems().get(i);
			shoppingItemString = shoppingItemString.replace(priceWithoutTax,
					String.valueOf(item.getPriceIncludingTax()));
			shoppingList.set(i, shoppingItemString);
			i++;
		}
		shoppingList.add(SALES_TAX + shoppingBill.getTotalSalesTax());
		shoppingList.add(TOTAL + shoppingBill.getTotalBillAmount());
		return shoppingList;
	}

	private static Map<String, Object> shoppingItemValues(String shoppingItemString) {
		Map<String, Object> shoppingItemValues = new HashMap<String, Object>();
		shoppingItemValues.put(QUANTITY, Character.getNumericValue(shoppingItemString.charAt(0)));
		shoppingItemValues.put(ITEM_NAME, getItemNameFromInputString(shoppingItemString));
		shoppingItemValues.put(PRICE_WITHOUT_TAX, getItemPrice(shoppingItemString));
		shoppingItemValues.put(IS_TAX_EXEMPT, isObjectTaxExempt(shoppingItemString));
		shoppingItemValues.put(IS_IMPORTED, shoppingItemString.contains(IMPORTED));
		return shoppingItemValues;
	}

	private static String getItemNameFromInputString(String purchase) {
		String name = purchase.substring(2, purchase.indexOf(AT));
		return name.replace(IMPORTED, StringUtils.EMPTY);
	}

	private static double getItemPrice(String purchase) {
		String price = purchase.substring(purchase.indexOf(AT) + 4, purchase.length());
		return Double.parseDouble(price);
	}

	private static boolean isObjectTaxExempt(String purchase) {
		for (TaxExempt taxExempt : TaxExempt.values()) {
			if (purchase.contains(taxExempt.getDisplayString())) {
				return true;
			}
		}
		return false;
	}
}