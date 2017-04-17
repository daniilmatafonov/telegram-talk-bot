package com.messagebot.main.service;


import java.util.List;

public interface CrudService<E> {
	E findMessageById(Long id);
	List<E> findAll();
}
