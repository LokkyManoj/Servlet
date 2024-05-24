package todo.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import todo.dao.ToDoListManager1;
import todo.dao.Validation;
import todo.model.ToDoItem1;
import todo.util.SimpleToDoListManager1;

public class ToDoListMain1 {
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		try {
			ToDoListManager1 manager = new SimpleToDoListManager1();

			ToDoItem1 todo = new ToDoItem1();

			System.out.println("Welcome to ToDoList!");
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Manager Registration");
				System.out.println("2. Manager Login");
				System.out.println("3. Employee Login");
				System.out.println("4. Exit");
				System.out.print("Enter your choice: ");
				while(scanner.hasNext()) {
				try {
				 choice = scanner.nextInt();
				  scanner.nextLine();
				  if(choice!=1 && choice!=2 && choice!=3 && choice!=4 ) {
					  System.out.println("Enter valid choice");
					  
				  }

				
				}catch(Exception e) {
					  System.out.println(e);
					  System.out.println("Enter numbers only");
					  scanner.nextLine();
					  
				  }
				

				switch (choice) {
				case 1:
					managerRegistration(scanner, manager, todo);
					break;
				case 2:
					if (managerLogin(scanner, manager, todo)) {
						managerTasks(scanner, manager, todo);
					}
					break;
				case 3:
					employeeLogin(scanner, manager);
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		} 
		}catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	static void managerRegistration(Scanner scanner, ToDoListManager1 manager, ToDoItem1 task1) throws SQLException {
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

		Validation validate = new Validation();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Manager Registration:");
		System.out.print("Enter Manager Username: ");
		String managerUsername = scanner.nextLine();
		while (!validate.numberchecker(task1.getManagerUsername())) {
			task1.setManagerUsername(scanner.next());
		}

		System.out.print("Enter Manager Password: ");
		String managerPassword = scanner.nextLine();
		while(!validate.passWordChecker(managerPassword)) {
			managerPassword=scanner.nextLine();
		}
		

		System.out.print("Enter Employee Name: ");
		task1.setEmployeeName(scanner.nextLine());
		while (!validate.numberchecker(task1.getEmployeeName())) {
			task1.setEmployeeName(scanner.next());
		}
		
		System.out.print("Enter a Employee ID: ");
		task1.setEmpID(scanner.nextInt());

		System.out.print("Enter Task Id:");
		task1.setTaskId(scanner.nextInt());
		scanner.nextLine();
		while (!validate.inputchecker(task1.getTaskId())) {
			task1.setTaskId(scanner.nextInt());
		}
		
		

		System.out.print("Enter Task for Employee: ");
		task1.setTask(scanner.nextLine());
		while (!validate.numberchecker(task1.getTask())) {
			task1.setTask(scanner.next());
		}
		
		System.out.print("Enter a Priority of Task:");
		task1.setPriority(scanner.nextInt());
		scanner.nextLine();
//		System.out.print("Enter due date (YYYY-MM-DD): ");
//		String dueDateStr = scanner.nextLine();
//		try {
//			Date dueDate = dateFormat2.parse(dueDateStr);
//			task1.setDueDate(dueDate);
//		} catch (ParseException e) {
//		System.err.println("Error parsing due date: " + e.getMessage());
//	}
		System.out.print("Enter  Due Date (YYYY-MM-DD): ");
		Date dueDateStr = null;
		try {
			 dueDateStr = dateFormat2.parse(scanner.next());
			 System.out.println(dueDateStr);
			

			while (!validate.dateInputChecker(dueDateStr)) {
				System.out.print("Please enter a valid due date (YYYY-MM-DD): ");
				dueDateStr = dateFormat2.parse(scanner.next());
			}
			task1.setDueDate(dueDateStr);
			
		} catch (ParseException e) {
			System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
		}

		

		if (manager.signUp(managerUsername, managerPassword)) {
			manager.addTask1(managerUsername, managerPassword, task1.getTaskId(), task1.getTask(), task1.getDueDate(),
					task1.getEmployeeName(),task1.getEmpID(),task1.getPriority());

		}
	}

	static boolean managerLogin(Scanner scanner, ToDoListManager1 manager, ToDoItem1 todo) throws SQLException {
		Validation validate = new Validation();

		System.out.println("Manager Login:");
		System.out.print("Enter Manager Username: ");
		String managerUsername = scanner.nextLine();
		while (!validate.numberchecker(managerUsername)) {
			managerUsername = scanner.next();
		}

		System.out.print("Enter Manager Password: ");
		String managerPassword = scanner.nextLine();

		
		
		todo.setManagerUsername(managerUsername);
		todo.setManagerPassword(managerPassword);
		return manager.login(managerUsername, managerPassword);
	}

	static void managerTasks(Scanner scanner, ToDoListManager1 manager, ToDoItem1 todo)
			throws SQLException, ParseException, ClassNotFoundException {
		SimpleToDoListManager1 s = new SimpleToDoListManager1();
		Validation validate = new Validation();

		System.out.println("Manager Tasks:");
		System.out.println("1. Add Task");
		System.out.println("2. Delete Task");
		System.out.println("3. Update Task");
		System.out.println("4. Back to Main Menu");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		while (!validate.inputchecker(choice)) {
			choice = scanner.nextInt();
		}

		switch (choice) {
		case 1:
			
			addTask(scanner, manager, todo);
			break;
		case 2:
			s.displayAllTasks();
			deleteTask(scanner, manager);
			break;
		case 3:
			s.displayAllTasks();
			updateTask(scanner, manager);
			break;
		case 4:
			return;
		default:
			System.out.println("Invalid choice. Please try again.");
			break;
		}
	}

	static void addTask(Scanner scanner, ToDoListManager1 manager, ToDoItem1 todo) throws SQLException {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

		Validation validate = new Validation();

		System.out.print("Enter task id: ");
		int taskId = scanner.nextInt();
		todo.setTaskId(taskId);
		scanner.nextLine();
		while (!validate.inputchecker(todo.getTaskId())) {
			todo.setTaskId(scanner.nextInt());
		}

		System.out.print("Enter task: ");
		String task = scanner.nextLine();
		todo.setTask(task);
		while (!validate.numberchecker(todo.getTask())) {
			todo.setTask(scanner.nextLine());
		}
		
		System.out.print("Enter a Priority of Task:");
		int prior=scanner.nextInt();
		todo.setPriority(prior);
		scanner.nextLine();

//        System.out.print("Enter due date (YYYY-MM-DD): ");
//        String dueDateStr = scanner.nextLine();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date dueDate = dateFormat.parse(dueDateStr);
//            todo.setDueDate(dueDate);
//        } catch (ParseException e) {
//            System.err.println("Error parsing due date: " + e.getMessage());
//        }
		System.out.print("Enter  due date (YYYY-MM-DD): ");
		Date dueDateStr = null;
		try {
			dueDateStr = dateFormat1.parse(scanner.nextLine());
			while (!validate.dateInputChecker(dueDateStr)) {
				System.out.print("Please enter a valid due date (YYYY-MM-DD): ");
				dueDateStr = dateFormat1.parse(scanner.nextLine());
			}
		    todo.setDueDate(dueDateStr); 

		} catch (ParseException e) {
			System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
		}

		System.out.print("Enter employee name: ");
		String employeeName = scanner.nextLine();
		while (!validate.numberchecker(employeeName)) {
			employeeName = scanner.nextLine();
		}

		todo.setEmployeeName(employeeName);
		System.out.print("Enter a Employee ID: ");
		int empID=scanner.nextInt();
		todo.setEmpID(empID);
		
		
		manager.addTask(todo);
		
		System.out.println("Want to Add a Tasks? (Yes/No)");
		
		
	}

	static void deleteTask(Scanner scanner, ToDoListManager1 manager) throws SQLException {
		Validation validate = new Validation();

		System.out.print("Enter task id to delete: ");
		int taskId = scanner.nextInt();
		scanner.nextLine();
		while (!validate.inputchecker(taskId)) {
			taskId = scanner.nextInt();
		}

		manager.deleteTask(taskId);
	}

	static void updateTask(Scanner scanner, ToDoListManager1 manager) throws SQLException, ParseException {
		Validation validate = new Validation();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		System.out.print("Enter task id to update: ");
		int taskId = scanner.nextInt();
		scanner.nextLine();
		while (!validate.inputchecker(taskId)) {
			taskId = scanner.nextInt();
		}

		System.out.print("Enter new task: ");
		String newTask = scanner.nextLine();
		while (!validate.numberchecker(newTask)) {
			newTask = scanner.nextLine();
		}
		
		System.out.println("Enter a priority of task: ");
		int newPrior=scanner.nextInt();
		scanner.nextLine();

//        System.out.print("Enter new due date (YYYY-MM-DD): ");
//        Date newDueDate = dateFormat.parse(scanner.nextLine());
//        Date dueDate = null;
//        while(!validate.dateInputChecker(newDueDate)) {
//        	newDueDate=dateFormat.parse(scanner.nextLine());
//        }
		System.out.print("Enter new due date (YYYY-MM-DD): ");
		Date newDueDate = null;
		try {
			newDueDate = dateFormat.parse(scanner.nextLine());
			while (!validate.dateInputChecker(newDueDate)) {
				System.out.print("Please enter a valid due date (YYYY-MM-DD): ");
				newDueDate = dateFormat.parse(scanner.nextLine());
			}
		} catch (ParseException e) {
			System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
		}

		System.out.print("Enter new employee name: ");
		String newEmployeeName = scanner.nextLine();
		while (!validate.numberchecker(newEmployeeName)) {
			newEmployeeName = scanner.nextLine();
		}
		
		System.out.println("Enter new employee id: ");
		int newEmpID=scanner.nextInt();

		manager.updateTask(taskId, newTask, newDueDate, newEmployeeName,newEmpID,newPrior);
	}

	static void employeeLogin(Scanner scanner, ToDoListManager1 manager) throws SQLException {
		Validation validate = new Validation();

		System.out.println("Employee Login:");
		System.out.print("Enter employee username: ");
		String employeeUsername = scanner.nextLine();
		while  (!validate.numberchecker(employeeUsername)) {
			employeeUsername = scanner.nextLine();
		}
		
		System.out.println("Enter employee id: ");
		int empID=scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter your Manager Name:");
		String managerUsername = scanner.nextLine();
		while (!validate.numberchecker(managerUsername)) {
			managerUsername = scanner.nextLine();
		}

		manager.getEmployeeDetails(managerUsername, employeeUsername,empID);
		
		
		System.out.print("Enter that the taskid is Completed or not: ");
		String taskId = scanner.nextLine();

		manager.isActive(managerUsername, taskId);
	}
}