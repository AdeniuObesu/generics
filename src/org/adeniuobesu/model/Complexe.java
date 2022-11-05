/**
 * 
 */
package org.adeniuobesu.model;

/**
 * @author MOUKHAFI Anass
 *
 * Oct 30, 2022
 */
public class Complexe {
	
	private int x;
	private int y;
	/**
	 * 
	 */
	public Complexe(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Complexe() {
		this(1, 2);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if( o instanceof Complexe ) {
			Complexe obj = (Complexe) o;
			return (x == obj.x && y == obj.y);
		}
		return true;
	}
	
	@Override
	public String toString() {
		return (
				"Complexe " +
				"( x : " + x + " , y : " + y + ")"
			);
	}
	
	@Override
	public Object clone() {
		return new Complexe(this.x, this.y);
	}
}
