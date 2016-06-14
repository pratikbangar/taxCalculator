package cleanCode;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ShoppingItem {
	private int quantity;
	private String itemName;
	private double priceWithoutTax;
	private double priceIncludingTax;
	private double itemTax;
	private Map<String, Object> itemTaxAttributes = new HashMap<String, Object>();

	private static final String QUANTITY = "quantity";
	private static final String ITEM_NAME = "itemName";
	private static final String PRICE_WITHOUT_TAX = "priceWithoutTax";
	private static final String IS_TAX_EXEMPT = "isTaxExempt";
	private static final String IS_IMPORTED = "isImported";

	public static ShoppingItem from(Map<String, Object> shoppingItemValues) {
		ShoppingItem shoppingItem = new ShoppingItem();
		shoppingItem.setQuantity((int) shoppingItemValues.get(QUANTITY));
		shoppingItem.setItemName((String) shoppingItemValues.get(ITEM_NAME));
		shoppingItem.setPriceWithoutTax((double) shoppingItemValues.get(PRICE_WITHOUT_TAX));
		shoppingItem.getItemTaxAttributes().put(IS_TAX_EXEMPT, (boolean) shoppingItemValues.get(IS_TAX_EXEMPT));
		shoppingItem.getItemTaxAttributes().put(IS_IMPORTED, (boolean) shoppingItemValues.get(IS_IMPORTED));
		return shoppingItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPriceWithoutTax() {
		return priceWithoutTax;
	}

	public void setPriceWithoutTax(double priceWithoutTax) {
		this.priceWithoutTax = priceWithoutTax;
	}

	public double getPriceIncludingTax() {
		return priceIncludingTax;
	}

	public void setPriceIncludingTax(double priceIncludingTax) {
		this.priceIncludingTax = priceIncludingTax;
	}

	public double getItemTax() {
		return itemTax;
	}

	public void setItemTax(double itemTax) {
		this.itemTax = itemTax;
	}

	public Map<String, Object> getItemTaxAttributes() {
		return itemTaxAttributes;
	}

	public void setItemTaxAttributes(Map<String, Object> itemTaxAttributes) {
		this.itemTaxAttributes = itemTaxAttributes;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
