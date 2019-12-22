package application;

import javafx.scene.paint.Color;

/**
 * Complete the following base Function class.
 *
 */


public abstract class Function 
{
	protected double x1;
	protected double x2;
	protected Color col;
	protected String name;
	private String getName;
	
	// Constructor method for the Function class.  The parameters represent the domain of the function.
	public Function(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
		this.col = Color.BLACK;
	}
	
	// Returns a String containing the actual function.  For example, if the function was an object of the Parabola class, 
	// this method might return 2.0*(x - 4.0)^2 + 5.0.  There are spaces before and after the +, - operators only.
	public abstract String toString();
	
	// Sets the domain of this function to be between [x1, x2] where x2 > x1.
	public void setDomain(double firstX, double secondX)
	{
		this.x1 = firstX;
		this.x2 = secondX;
	}
	
	// Returns the starting value of the domain.
	public double getStartDomain()
	{
		return x1;
	}
	
	// Returns the ending value of the domain.
	public double getEndDomain()
	{
		return x2;
	}
	
	// Sets the drawing colour for this function.  The Color class is from JavaFX.
	public void setColour(Color colour)
	{
		this.col = colour;
	}
	
	// Returns the colour of this function.
	public String getColour()
	{
		return this.col.toString();	
	}
	
	// Sets the name of this function type.
	public void setName(String name)
	{
		this.name = name;
	}
	
	// Returns the name of this function type as a String.
	public String getName()
	{
		return name;
	}
}