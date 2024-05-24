package todo.model;

import java.util.Date;

public class ToDoItem1 {
	public String managerUsername;
	public String managerPassword;
	public String employeeName;
	public int taskId;
	public String task;
	public Date dueDate;
	public int empID;
	public int priority;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String  getManagerUsername() {
		return managerUsername;
	}

	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "ToDoItem1 [managerUsername=" + managerUsername + ", managerPassword=" + managerPassword
				+ ", employeeName=" + employeeName + ", taskId=" + taskId + ", task=" + task + ", dueDate=" + dueDate
				+ ", empID=" + empID + ", priority=" + priority + "]";
	}
}