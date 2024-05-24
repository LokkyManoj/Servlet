package todo.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import todo.model.ToDoItem1;

public interface ToDoListManager1 {
	boolean signUp (String managerUsername, String managerPassword) throws SQLException;

	boolean login(String managerUsername, String managerPassword) throws SQLException;

	void addTask(ToDoItem1 todo) throws SQLException;

	void addTask1(String managerUsername, String managerPassword, int taskId, String task, Date dueDate,
			String employeeName,int empID,int prior) throws SQLException;

	void deleteTask(int taskId) throws SQLException;

	void updateTask(int taskId, String newTask, Date newDueDate, String newEmployeeName,int empID,int prior) throws SQLException;

	List<ToDoItem1> getTasksForEmployee(String employeeName,int empID) throws SQLException;

	List<ToDoItem1> getAllTasks() throws SQLException;

	void getEmployeeDetails(String managerUsername, String employeeUsername,int empID) throws SQLException;

	void isActive(String managerUsername, String taskId) throws SQLException;
}