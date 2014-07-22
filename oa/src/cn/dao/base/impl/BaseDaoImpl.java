package cn.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.dao.base.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private Class classt;
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		this.classt = (Class)type.getActualTypeArguments()[0];//<T>
		System.out.println(type.getRawType());
	}
	
	public void deleteEntry(Serializable id) {
		T t = this.getEntryById(id);
		this.hibernateTemplate.delete(t);
	}

	public Collection<T> getAllEntry() {
		return this.hibernateTemplate.find("from " + this.classt.getName());
	}

	public T getEntryById(Serializable id) {
		return (T) this.hibernateTemplate.get(this.classt, id);
	}

	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

}
