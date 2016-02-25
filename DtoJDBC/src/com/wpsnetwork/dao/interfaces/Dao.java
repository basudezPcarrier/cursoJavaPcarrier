package com.wpsnetwork.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
	T get(int clave) throws SQLException;
	void update(T elemento) throws SQLException;
	void remove(T elemento) throws SQLException;
	void insert(T elemento) throws SQLException;
	List<T> getAll() throws SQLException;
}
