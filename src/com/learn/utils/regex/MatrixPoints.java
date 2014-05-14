package com.learn.utils.regex;


public class MatrixPoints {

	Point[][] matrix;
	int matrix_row,matrix_column;
	double  ax,ay,bx,by,cx,cy,dx,dy;
	double px,py;
	double length = 0;
	double width = 0;
	double a1,a2,a3,a4;

	public MatrixPoints(Point[][] matrix, int matrix_row, int matrix_column,
			double ax, double ay, double bx, double by, double cx, double cy,
			double dx, double dy) {
		super();
		this.matrix = matrix;
		this.matrix_row = matrix_row;
		this.matrix_column = matrix_column;
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.cx = cx;
		this.cy = cy;
		this.dx = dx;
		this.dy = dy;
	}
	
	private class Point{
		double x;
		double y;
		
	}

	public double getTriangleArea(double  u,double x, double y,double z){
		double area = Math.sqrt((u *(u-x)*(u-y)*(u-z)));
		return area;
	}
	
	public double getRectangleArea(double length,double width){
		return length*width;
	}
	
	public double getHeight(double x, double y,double z){
		double s = 3;
		return ((x+y+z)/s) ;
	}
	
	public double getlength(double x1,double y1,double x2,double y2){
		double result = Math.sqrt((Math.pow((x1-x2),2)+ Math.pow((y1-y2),2)));
		return result;
	}
	
	
	public double getRectangleArea(){
		a1 = getlength(ax,ay,bx,by);
		a2 = getlength(bx,by,cx,cy);
		a3 = getlength(cx,cy,dx,dy);
		a4 = getlength(dx,dy,ax,ay);
		if (a1 == a2) {
			this.length = a1;
			this.width = a3;
		}else if(a1 == a3){
			this.length = a1;
			this.width = a2;
		}
		else if (a1 == a4){
			this.length = a1;
			this.width = a2;
		}
		return this.length*this.width;
	}
	
	
	public double getAreaUsingRefPoint(){
		double l1 = getlength(px,py,ax,ay);
		double l2 = getlength(px,py,bx,by);
		double l3 = getlength(px,py,cx,cy);
		double l4 = getlength(px,py,dx,dy);
		double h1 = getHeight(l1,ax,ay);
		double h2 = getHeight(l2,bx,by);
		double h3 = getHeight(l3,cx,cy);
		double h4 = getHeight(l4,dx,dy);
		double A1 = getTriangleArea(h1,l1,a1,a2);
		double A2 = getTriangleArea(h2,l2,a2,a3);
		double A3 = getTriangleArea(h3,l3,a3,a4);
		double A4 = getTriangleArea(h4,l4,a4,a1);
		return A1+A2+A3+A4;
	}
	
	public double sumOfMatrixPoints(){
		double sum = 0;
		for(int i=0;i<matrix_row;i++){
			for(int j=0;j<matrix_column;j++){
				Point point = matrix[i][j];
				this.px = point.x;
				this.py = point.y;
				if (getAreaUsingRefPoint() != getRectangleArea()){
					sum = sum + this.px + this.py;
				}
			}
		}
		
		return sum;
	}
}

