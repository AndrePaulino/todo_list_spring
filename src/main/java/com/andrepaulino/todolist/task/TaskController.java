package com.andrepaulino.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        UUID userId = (UUID) request.getAttribute("userId");
        taskModel.setUserId(userId);

        LocalDateTime curentDate = LocalDateTime.now();
        if (curentDate.isAfter(taskModel.getStartAt()) || curentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Data de início/término deve ser depois da atual");
        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Data de término deve ser após a de início");
        }

        TaskModel task = this.taskRepository.save(taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

}
