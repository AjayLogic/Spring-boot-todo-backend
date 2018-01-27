package com.toDoApplication.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toDoApplication.domain.Task;
import com.toDoApplication.repository.TaskRepository;
import com.toDoApplication.service.TaskService;
@Service
public class TaskServiceImplementation implements TaskService {
	@Autowired
	TaskRepository taskRepository;
	@Transactional
	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		taskRepository.save(task);
	}
	@Override
	public Task findById(Long taskId) {
		// TODO Auto-generated method stub
		return taskRepository.findById(taskId);
	}
	@Transactional
	@Override
	public void delete(Task task) {
		// TODO Auto-generated method stub
		taskRepository.delete(task);
	}
	@Transactional
	@Override
	public void saveandFlush(Task task) {
		// TODO Auto-generated method stub
		taskRepository.saveAndFlush(task);
	}
	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}
}
