package org.tasktracker.tasks.models;

import java.util.List;

public class Task implements Assignable {

    private int taskId;
    private String taskTitle;
    private String description;
    private String notes;
    private Employee createdBy;
    private Employee completedBy;
    private String taskStatus;
    private String taskType;
    private Client client;
    private List<Employee> employees;

    public int getTaskId() {
        return taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Employee getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(Employee completedBy) {
        this.completedBy = completedBy;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void assignEmployee(Employee employee) {
        List<Employee> employees = getEmployees();
        employees.add(employee);
        setEmployees(employees);
    }

    @Override
    public boolean removeEmployee(Employee employee) {
        List<Employee> employees = getEmployees();
        return employees.remove(employee);
    }
}
