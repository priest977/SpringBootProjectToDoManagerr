package com.todo.Services;

import com.todo.Exception.ResourceNotFoundException;
import com.todo.pojomodel.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TodoService {
    Logger logger = LoggerFactory.getLogger(TodoService.class);
    // We are not using any data base to store the data
    List<Todo> todoList = new ArrayList<>();

    public Todo createToDoServices(Todo todo){
        logger.info("Creating Todo in Services");
        todoList.add(todo);
        return todo;
    }
    // Getting All todo list
    public List<Todo> getAllData(){
        return todoList;
    }

    // Getting any single id
    public Todo getSingleTodo(int todoId){
        // Without Using Java 8
//        for(var s : todoList){
//            if(s.getId()==todoId)
//                return todoList.get(s.getId());
//        }
//        return  null;
        // By Using java8
      Todo todo = todoList.stream().filter(t->todoId==t.getId()).findAny().orElseThrow(()-> new ResourceNotFoundException("Resource Not Found With Id", HttpStatus.NOT_FOUND));
      return todo;
    }

    // Updating Todo

    public Todo updateTodo(Todo todo , int todoId){
     List<Todo> updatedTodo = todoList.stream().map(t->{
            if(t.getId()==todoId){
                // Update with new Todo
                t.setTitel(t.getTitel());
                t.setContent(t.getContent());
                t.setStatus(t.getStatus());
                return t;
            }else return t;
        }).toList();
     todoList = updatedTodo;
     return todo;
    }

    // Deleted List
    public void  deletedTodo(int myId) {
      List<Todo> newTodoList =  todoList.stream().filter(t->t.getId()!=myId).toList();
      todoList = newTodoList;
    }
}
