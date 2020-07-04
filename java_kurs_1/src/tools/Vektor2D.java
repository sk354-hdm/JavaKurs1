package tools;

import java.awt.geom.Point2D;

public class Vektor2D extends Point2D.Double {
	
	public static void main(String[] args) {
	
	}

	public Vektor2D() {
		
	}
	
	public Vektor2D(double x, double y) {
		super(x,y);
	}
	
	public String toString() {
		return "("+x+"/"+y+")";
	}
	
	public Vektor2D addiere (Vektor2D v) {
		this.x = this.x + v.x;
		this.y = this.y + v.y;
		return this;
	}
	
	public Vektor2D subtrahiere (Vektor2D v) {
		this.x = this.x - v.x;
		this.y = this.y - v.y;
		return this;
	}
	
	public Vektor2D subtrahiere (double x, double y) {
		this.x = this.x -x;
		this.y = this.y -y;
		return this;
	}
	
	public Vektor2D skalarMult(double f) {
		this.x = this.x * f;
		this.y = this.y * f;
		return this;
	}
	
	public double skalarProdukt(Vektor2D v) {
		double skalarProd = this.x * v.x + this.y * v.y;
		return skalarProd;
	}
	
	public Vektor2D normiere () {
		double länge = this.distance(0,0);
		if(länge != 0) {
			x = x/länge;
			y = y/länge;
		}
		return this;
		}
}

