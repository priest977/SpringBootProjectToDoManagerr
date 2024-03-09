package com.todo.pojomodel;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {
    private int id;
    private String titel;
    private String content;
    private String status;
    private Date currentDate;

    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date todoDate;

    public Todo(int id, String titel, String content, String status , Date currentDate , Date todoDate) {
        this.id = id;
        this.titel = titel;
        this.content = content;
        this.status = status;
        this.currentDate = currentDate;
        this.todoDate = todoDate;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", currentDate=" + currentDate +
                ", todoDate=" + todoDate +
                '}';
    }
}
