package xyz.code2828.chemc;

public class ChemistryProperties
{

	public ChemistryProperties()
	{
		// TODO Auto-generated constructor stub
	}

	private String elemental_formula;
	private String usual_formula;
	private String display_formula;
	private String subscripts = "₀₁₂₃₄₅₆₇₈₉";

	public String getElementalFormula()
	{ return elemental_formula; }

	public String getUsualFormula()
	{ return usual_formula; }

	private String calculateDisplayFormulaFromElementalFormula()
	{
		return "This method is not yet implemented.";
	}

	public String getDisplayElementalFormula()
	{
		calculateDisplayFormulaFromElementalFormula();
		return display_formula;
	}

	private String calculateDisplayFormulaFromUsualFormula()
	{
		return "This method is not yet implemented.";
	}

	public String getDisplayUsualFormula()
	{
		calculateDisplayFormulaFromUsualFormula();
		return display_formula;
	}

}
