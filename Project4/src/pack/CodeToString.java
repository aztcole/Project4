// Class: CodeToString.java
// Lead Contributor: Tyler Cole
// Description: Used for parsing the code from the question pool into a class that can be accessed later.

package pack;

public class CodeToString {
	
	private String type;
	private String name;
	private CodeToString aggregates;
	private CodeToString inherits;
	private CodeToString associates;
	
	// constructor
	public CodeToString(String t, String s)
	{
		setType(t);
		setName(s);
	}
	
	
	// SETTERS
	public void setType(String t)
	{
		type = t;
	}
	
	public void setName(String s)
	{
		name = s;
	}
	
	public void setAggregate(CodeToString a)
	{
		aggregates = a;
	}
	
	public void setInherit(CodeToString i)
	{
		inherits = i;
	}
	
	public void setAssociate(CodeToString a)
	{
		associates = a;
	}
	
	
	// GETTERS
	public String getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public CodeToString getAggregate()
	{
		return aggregates;
	}
	
	public CodeToString getInherit()
	{
		return inherits;
	}
	
	public CodeToString getAssociate()
	{
		return associates;
	}
	
	
	// To string
	public String ToString()
	{
		String temp;
		String aggr = "";
		String inher = "";
		String assoc = "";
		
		if(inherits != null)
		{
			inher = " extends " + inherits.getName();
		}
		
		if(aggregates != null)
		{
			// create the lower case name
			String s1 = aggregates.getName().substring(0, 1).toLowerCase();
		    String aggrLowered = s1 + aggregates.getName().substring(1);
		    
			aggr = "\n    public " + aggregates.getName() + " " + aggrLowered + ";";
		}
		
		if(associates != null)
		{
			// create the lower case name
			String s1 = associates.getName().substring(0, 1).toLowerCase();
			String assocLowered = s1 + associates.getName().substring(1);
					    
			assoc = "\n    public " + name + "(){\n        " + associates.getName() + " " + assocLowered + ";\n    }";
		}
		
		// puts them all together
		temp = "public " + type + " " + name + inher + " {" + aggr + assoc + "\n}";
		
		return temp;
	}
}
