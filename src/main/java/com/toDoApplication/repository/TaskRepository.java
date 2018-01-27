package com.toDoApplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.toDoApplication.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Task findById(Long taskId);

}
