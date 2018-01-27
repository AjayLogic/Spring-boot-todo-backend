package com.toDoApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.toDoApplication.domain.Task;

public interface TaskService {

	void save(Task task);

	Task findById(Long taskId);

	void delete(Task task);

	void saveandFlush(Task task);

	List<Task> findAll();

}
