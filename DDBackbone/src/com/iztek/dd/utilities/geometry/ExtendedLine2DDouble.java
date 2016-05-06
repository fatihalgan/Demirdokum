/*
 * Created on 26.Ara.2004
 *
 */
package com.iztek.dd.utilities.geometry;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * @author Selim HENDRICKSON
 *  
 */
public class ExtendedLine2DDouble extends Line2D.Double {
	/**
	 * 
	 */
	public ExtendedLine2DDouble() {
		super();

	}
	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ExtendedLine2DDouble(double arg0, double arg1, double arg2,
			double arg3) {
		super(arg0, arg1, arg2, arg3);

	}
	/**
	 * @param arg0
	 * @param arg1
	 */
	public ExtendedLine2DDouble(Point2D arg0, Point2D arg1) {
		super(arg0, arg1);

	}
	Point intersects(final ExtendedLine2DDouble line1) {
		Point localPoint = new Point(0, 0);

		double num =  (getY2() - getY1()) * (getX1() - line1.getX1())
					- (getX2() - getX1()) * (getY1() - line1.getY1());

		double denom = (getY2() - getY1()) * (line1.getX2() - line1.getX1())
					 - (getX2() - getX1()) * (line1.getY2() - line1.getY1());

		localPoint.x = line1.getX1() + (line1.getX2() - line1.getX1()) * num / denom;
		localPoint.y = line1.getY1() + (line1.getY2() - line1.getY1()) * num / denom;

		return localPoint;
	}
}