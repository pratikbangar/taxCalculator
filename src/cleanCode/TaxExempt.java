package cleanCode;

public enum TaxExempt {

	CHOCOLATE("chocolate"),
	BOOK("book"),
	PILL("pill");
	
	private final String displayString;
	
	TaxExempt(String displayString)
	{
		this.displayString = displayString;
	}
	
	public String getDisplayString()
	{
		return displayString;
	}
	
}
