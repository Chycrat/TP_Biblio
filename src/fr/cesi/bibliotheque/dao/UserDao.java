package fr.cesi.bibliotheque.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.bibliotheque.entity.User;
import fr.cesi.bibliotheque.exception.UnknownProductException;

public class UserDao {
	private static List<User> Users = new ArrayList<User>();
	private static Long idSequence = 1L;
	
	private UserDao() { }
	
	
	public static void addUser(User monUser) {
		monUser.setId(idSequence++);
		Users.add(monUser);
	}
	
	
	public static void updateUser(User monUser) throws UnknownProductException {
		int index = getUserIndexById(monUser.getId());
		if(index > -1) {
			Users.set(index, monUser);
		} else {
			throw new UnknownProductException(monUser.getId());
		}
	}
	
	
	public static User findUserById(Long id) throws UnknownProductException {
		int index = getUserIndexById(id);
		if(index > -1) {
			User monUser = Users.get(index);
			return monUser;
		}
		throw new UnknownProductException(id);
	}
	
	
	public static List<User> getAllUser() {
		return Collections.unmodifiableList(Users);
	}
	
	
	public static void removeUser(User monUser) throws UnknownProductException {
		removeUser(monUser.getId());
	}
	
	
	public static void removeUser(Long id) throws UnknownProductException {
		int index = getUserIndexById(id);
		if(index > -1) {
			Users.remove(index);
		} else {
			throw new UnknownProductException(id);
		}
	}
	
	private static int getUserIndexById(Long id) {
		for (int i = 0; i < Users.size(); i++) {
			User product = Users.get(i);
			if(product.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}
