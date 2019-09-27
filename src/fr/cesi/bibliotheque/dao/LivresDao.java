package fr.cesi.bibliotheque.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.bibliotheque.entity.Livres;
import fr.cesi.bibliotheque.exception.UnknownProductException;

public class LivresDao {
	private static List<Livres> livres = new ArrayList<Livres>();
	private static Long idSequence = 1L;
	
	private LivresDao() { }
	
	
	public static void addLivre(Livres livre) {
		livre.setId(idSequence++);
		livres.add(livre);
	}
	
	
	public static void updateLivreProduct(Livres livre) throws UnknownProductException {
		int index = getLivreIndexById(livre.getId());
		if(index > -1) {
			livres.set(index, livre);
		} else {
			throw new UnknownProductException(livre.getId());
		}
	}
	
	
	public static Livres findProductById(Long id) throws UnknownProductException {
		int index = getLivreIndexById(id);
		if(index > -1) {
			Livres livre = livres.get(index);
			return livre;
		}
		throw new UnknownProductException(id);
	}
	
	
	public static List<Livres> getAllLivre() {
		return Collections.unmodifiableList(livres);
	}
	
	
	public static void removeLivre(Livres livre) throws UnknownProductException {
		removeLivre(livre.getId());
	}
	
	
	public static void removeLivre(Long id) throws UnknownProductException {
		int index = getLivreIndexById(id);
		if(index > -1) {
			livres.remove(index);
		} else {
			throw new UnknownProductException(id);
		}
	}
	
	private static int getLivreIndexById(Long id) {
		for (int i = 0; i < livres.size(); i++) {
			Livres product = livres.get(i);
			if(product.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}
