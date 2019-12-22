package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Parabola extends Linear implements Calculations, Drawable {

	protected double h;
	protected double k;
	protected double xa;
 
	
	public Parabola(double x1, double x2, double m, double b, double xshift) {
		super(x1, x2, m,b,  xshift);
		
		this.h = xshift;
		this.k = b;
		this.xa = m;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double val(double x) {
		// TODO Auto-generated method stub
		double y = (xa*((x-h) *(x-h)) + k);
		return y;
	}

	@Override
	public boolean undefined(double x) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getArea(double x_start, double x_end) {
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

	public String toString() {
		return null;
		
	}

	public void draw(GraphicsContext gc, Function f)
	{
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