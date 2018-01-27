package com.toDoApplication.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.toDoApplication.domain.Task;
import com.toDoApplication.service.TaskService;

@RestController
public class HomeController {
	@Autowired
	TaskService taskService;
	
	//list tasks
	 @RequestMapping(value="/listTasks",method = RequestMethod.GET)
	public List<Task> listTasks(){
		return taskService.findAll();
	}
	
	//add task
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/addTask",method = RequestMethod.POST)
		public ResponseEntity addTask(@RequestBody HashMap<String,String> mapper){
			Task task=new Task();
			task.setTitle(mapper.get("title"));
			task.setDescription(mapper.get("description"));
			task.setStatus("Pending");
			taskService.save(task);
		 return new ResponseEntity("added successfully", HttpStatus.OK);
		}
	
	//edit task
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value="/editTask",method = RequestMethod.POST)
			public ResponseEntity editTask(@RequestBody HashMap<String,String> mapper){
				Task task=taskService.findById(Long.parseLong(mapper.get("id")));
				task.setTitle(mapper.get("title"));
				task.setDescription(mapper.get("description"));
				taskService.saveandFlush(task);
			 return new ResponseEntity("edited successfully", HttpStatus.OK);
			}
		

	//delete task
	 @SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value="/deleteTask",method = RequestMethod.POST)
			public ResponseEntity deleteTask(@RequestBody String taskId){
		     Task task=taskService.findById(Long.parseLong(taskId));
			if(task!=null) {
				taskService.delete(task);
			}	
			 return new ResponseEntity("deleted successfully", HttpStatus.OK);
		}
	 
	//set completed status
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/setCompletedStatus",method = RequestMethod.POST)
			public ResponseEntity setCompletedStatus(@RequestBody String taskId){
		     Task task=taskService.findById(Long.parseLong(taskId));
			if(task!=null) {
				task.setStatus("Completed");
				taskService.saveandFlush(task);
			}	
			 return new ResponseEntity("successfully updated", HttpStatus.OK);
		}
	 
	//set pending status
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 @RequestMapping(value="/setPendingStatus",method = RequestMethod.POST)
			public ResponseEntity setPendingStatus(@RequestBody String taskId){
		     Task task=taskService.findById(Long.parseLong(taskId));
			if(task!=null) {
				task.setStatus("Pending");
				taskService.saveandFlush(task);
			}	
			 return new ResponseEntity("successfully updated", HttpStatus.OK);
		}
}
