/*
 * Recuperer des donnees depuis differentes sources
 * Mettre a jour ces donnees
 * Les trier
 * Les afficher ou les dessiner
 * suivre les operations avec un journaliseur (logger)
 * Tester unitairement les differentes operations
 * */
package org.adeniuobesu.generics;

/**
 * @author MOUKHAFI Anass
 * 
 * Oct 24, 2022
 */
public class DataManager {
	private List<Double> data;
	
	public DataManager() {
	}
	
	public void add(double item) {
		data.add(item);
	}
	
	public void sort() {
		
	}
	
	public void save(String target) {
		
	}
	
	public void load(String source) {
		
	}
}
