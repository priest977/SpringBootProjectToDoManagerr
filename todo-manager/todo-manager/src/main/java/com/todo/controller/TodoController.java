package com.todo.controller;

import com.todo.Services.TodoService;
import com.todo.pojomodel.Todo;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.xml.transform.OutputKeys;
//import java.util.ArrayList;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {
    Logger logger = LoggerFactory.getLogger(TodoController.class);

    // To Generate random Value
    Random random = new Random();
    @Autowired
    private TodoService todoService;
    // Handle todo
    @PostMapping("/postHandler")
    public ResponseEntity<?> createToHandler(@RequestBody Todo todo){
        int id = random.nextInt(6453); // It will generate the random value between 0 to 6453
        todo.setId(id);
        // Creating Current  Date With System default
        Date date = new Date();
        logger.info("Current Date {}",date);
        todo.setCurrentDate(date);
        logger.info("Creting Todo");
       Todo todo1 =  todoService.createToDoServices(todo);
       return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    // For Getting all the data
    @GetMapping("/getAllHandler")
    public ResponseEntity<?> getAllData(){
       List<Todo> gettingList= todoService.getAllData();
       return new ResponseEntity<>(gettingList,HttpStatus.OK);
    }

    // Getting data with some specific Id
    @GetMapping("/id/{todoId}")
    public ResponseEntity<?> getDataSingle(@PathVariable int todoId){
        Todo todo =  todoService.getSingleTodo(todoId);
        return new ResponseEntity<>(todo,HttpStatus.NOT_FOUND);
    }

    // Updating Todo
    @PutMapping("/updatedTodo/{myid}")
    public ResponseEntity<?> updateWithNewTodohandler(@RequestBody Todo todo , @PathVariable int myid){
       Todo updatedTodo1 =  todoService.updateTodo(todo,myid);
       return new ResponseEntity<>(updatedTodo1,HttpStatus.OK);
    }

    @DeleteMapping("/deleteTodo/{myId}")
    public ResponseEntity<?> deletedhandler(@PathVariable int myId){
      todoService.deletedTodo(myId);
      return new ResponseEntity<>(HttpStatus.OK);
    }
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<?> handleSingleException(NullPointerException ex){
//        System.out.println(ex.getMessage());
//        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<?> handleSingleException(NumberFormatException ex){
//        System.out.println(ex.getMessage());
//        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
//    }

    // For Handle Multiple Exception
    @ExceptionHandler(value = {NullPointerException.class, NumberFormatException.class})
    public ResponseEntity<?> handleSingleException(Exception ex){
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
    }

}
