package todo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validation {
	public boolean  inputchecker(int n) {
		while (true) {

			if (n < 0) {
				System.out.println("Error!Negative number detected.Please Enter a Valid input:");
				return false;
			}
			return true;
		}
	}

	public boolean numberchecker(String s) {
		while (true) {
			try {
				Integer.parseInt(s);
				System.out.print("Don't use numbers, please enter a valid input:");
				return false;
			} catch (NumberFormatException e) {
				return true;
			}
		}
	}

	public boolean inputchecker1(double n) {
		while (true) {
			if (n < 0) {
				System.out.print("Error! Negative number detected. Cannot proceed. Please enter a valid amount:");
				return false;
			} else {
				return true;
			}
		}
	}

	public static boolean validateString(String input) {
		while (true) {
			String regex = "^[a-zA-Z ]+$";
			Pattern pattern = Pattern.compile(regex);
			if (!pattern.matcher(input).matches()) {
				System.out.print("Error: Input should contain only letters:");
				return false;
			} else {
				return true;
			}
		}

	}

	public static boolean validateString1(String input) {
		while (true) {
			String regex = "^[a-zA-Z0-9]+$";
			Pattern pattern = Pattern.compile(regex);
			if (!pattern.matcher(input).matches()) {
				System.out.print("Error: Input should contain only letters and numbers:");
				return false;
			} else {
				return true;
			}
		}
	}

//	public boolean dateInputChecker(String word) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            Date inputDate = sdf.parse(word);
//            Date currentDate = new Date(); 
//            if (inputDate.before(sdf.parse(sdf.format(currentDate)))) {
//                System.out.println("Enter a current date or upcoming dates...");
//                return false;
//            }
//
//            return true; 
//        } catch (ParseException e) {
//            return false; 
//        }
//    }
	public boolean dateInputChecker(Date inputDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		if (inputDate.before(sdf.parse(sdf.format(currentDate)))) {
			System.out.println("Enter a current date or upcoming dates...");
			return false;
		}

		return true;
	}
	
	public boolean passWordChecker(String password) {
        try {
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*\\d).{8,}$";
            if (password.matches(regex)) {
                return true;
            } else {
                throw new IllegalArgumentException("Please enter a correct Password.(Atleast one caps,Atleast one number,Atleast one Special Character):");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    } 

}