package ru.chausov.to_do_list.data_base.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.chausov.to_do_list.data_base.entities.Task;


public interface TasksRepository extends CrudRepository<Task, Long> {
}
