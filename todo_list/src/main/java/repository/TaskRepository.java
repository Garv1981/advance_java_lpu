package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}