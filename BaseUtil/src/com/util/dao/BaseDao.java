package com.util.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDao<T> {
	private Class entityClass;
	@Autowired
	private HibernateTemplate template;

	public BaseDao() {
		Type type = getClass().getGenericSuperclass();
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		entityClass = (Class) types[0];

	}

	public T get(String id) {
		return (T) template.get(entityClass, id);

	}

	public void save(T entity) {
		template.save(entity);
	}

	public void update(T entity) {
		template.update(entity);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

}
