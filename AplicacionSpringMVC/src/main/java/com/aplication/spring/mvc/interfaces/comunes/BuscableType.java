package com.aplication.spring.mvc.interfaces.comunes;

import java.util.List;

public interface BuscableType<T, E> {
	
	/**
	 * Descripcion: Devuelve el type de la entidad 
	 * 
	 * @param entity
	 * @return
	 */
	public T toType(E entity);
	
	/**
	 * Descripcion: Devuelve el entity de la entidad 
	 * 
	 * @param type
	 * @return
	 */
	public E toEntity(T type);
	
	/**
	 * Descripcion: Devuelve la lista type de una lista de entidades 
	 * 
	 * @param entityList
	 * @return
	 */
	public List<T> toListType(List<E> entityList);
		

}
