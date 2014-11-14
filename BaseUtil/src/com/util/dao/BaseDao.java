package com.util.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDao<T> {
	private Class entityClass;

	// private HibernateTemplate template;

	public BaseDao() {
		Type type = getClass().getGenericSuperclass();
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class) types[0];

	}

}
