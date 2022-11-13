package org.tasktracker.tasks.models;

public interface Assignable {

    void assignEmployee(Employee employee);

    boolean removeEmployee(Employee employee);
}
