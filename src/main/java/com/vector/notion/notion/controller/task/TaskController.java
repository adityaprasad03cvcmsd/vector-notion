package com.vector.notion.notion.controller.task;

import com.vector.notion.notion.dto.task.TaskRequest;
import com.vector.notion.notion.entity.Task;
import com.vector.notion.notion.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest){
        try{
            Task task = taskService.createTask(taskRequest);
            return ResponseEntity.ok(task);
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> editTask(@PathVariable("taskId") Long taskId, @RequestBody TaskRequest taskRequest){
        try{
            Task task = taskService.editTask(taskId, taskRequest);
            return ResponseEntity.ok(task);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getTasks(@RequestHeader("userId") Long userId){
        try{
            List<Task> tasks = taskService.getTaskByAccountId(userId);
            return ResponseEntity.ok(tasks);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/title")
    public ResponseEntity<?> getTasksTitle(@PathVariable("search") String searchText){
        try{
            List<String> taskTitles = taskService.searchTasksByNamePrefix(searchText);
            return ResponseEntity.ok(taskTitles);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }


}
