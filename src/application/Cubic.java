package application;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Cubic extends Function implements Calculations, Drawable  {
	protected double a;
	protected double b;
	protected double c;
	protected double d;
	protected double x1;
	
	public Cubic(double x1, double x2, double a, double b, double c, double d, double xshift) {
		super(x1, x2);
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.x1 = xshift;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public double val(double x) {
		// TODO Auto-generated method stub
		double y = Math.pow(this.a*(x-x1), 3) + Math.pow(this.b*(x-x1),2) + this.c*(x-x1) + d;
		return y;
	}

	@Override
	public boolean undefined(double x) {
		// TODO Auto-generated method stub
		return (val(x) ==  Double.POSITIVE_INFINITY || val(x) == Double.NEGATIVE_INFINITY || val(x) == Double.NaN);
	}

	@Override
	public double getArea(double x_start, double x_end) {
		// TODO Auto-generated method stub
		
		double area = 0;			
		double deltaX = 0.01;
		for (double i = x_start; i< x_end; i+= deltaX ) {
			area = area + this.val(i)*deltaX;
		}
		return area;
	}

	@Override
	public double getSlope(double x) {
		// TODO Auto-generated method stub
		double deltaX = 0.01;
		double slope = (this.val(x +  deltaX) - this.val(x - deltaX) ) / (2* deltaX);
		return slope;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(GraphicsContext gc, Function f) {
		// TODO Auto-generated method stub
		ArrayList<double[]> list = new ArrayList<double[]>();
		for (double i = f.getStartDomain(); i < f.getEndDomain(); i++) {
			double [] point = new double[2];
			point [0] = i+300;
			point [1] = -(val(i))+300;
			list.add(point);
		}
		
		for (int i = 0; i < list.size() - 1; i++) {
			gc.setStroke(Paint.valueOf(f.getColour()));
			gc.strokeLine(list.get(i)[0], list.get(i)[1], list.get(i+1)[0], list.get(i+1)[1]);
		}
		
		
	
	

		
	}
}