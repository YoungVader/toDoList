package ru.chausov.to_do_list.data_base.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.chausov.to_do_list.data_base.entities.Task;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksRepositoryTests {
    @Autowired
    private TasksRepository tasksRepository;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(tasksRepository);
    }

    @Test
    public void saveTest() {
        Task taskToSave = new Task();

        Task savedTask = tasksRepository.save(taskToSave);

        Assert.assertEquals(savedTask, taskToSave);
    }

    @Test
    public void findTest() {
        Task taskToFind = new Task();

        tasksRepository.save(taskToFind);

        Task foundTask = tasksRepository.findById(taskToFind.getId()).get();

        Assert.assertEquals(taskToFind, foundTask);
    }


    @Test
    public void deleteTest() {
        Task task = new Task();

        tasksRepository.save(task);

        long countBefore = tasksRepository.count();

        tasksRepository.delete(task);

        long countAfter = tasksRepository.count();

        Assert.assertEquals(countBefore - 1, countAfter);
    }
}