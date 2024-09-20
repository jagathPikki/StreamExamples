package in.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOnEmployee {
	static List<Employee> employeeList = new ArrayList<Employee>();
	public static void main(String[] args) {

		

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		m1();
		m2();
		m3();
		m4();
		m5();
		m6();
		m7();
		m8();
		m9();
		m10();
		m11();
		m12();
		m13();
		m14();
		m15();
		m16();
		
	}
	
	//14"encrese employee salary, whover has lesstan 20k"
	
	public static void m1() {
		System.out.println("query -1-sort the employee based on age if age is same then sort by name ");
	 List<Employee> sortedEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).collect(Collectors.toList());
		System.out.println(sortedEmp);
		
	}
	
	public static void m2() {
		System.out.println("//sort the employee based on age if age is same then sort by name descending order\r\n"
				+ "	");
		List<Employee> reverseSortedEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed().thenComparing(Employee::getName)).collect(Collectors.toList());
		System.out.println("descending sorted order of emp list :"+reverseSortedEmp);
			}
	public static void m3() {
		System.out.println("// Query 3 : How many male and female employees are there in the organization?");
		
		Map<String, Long> empTotalGenders = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(empTotalGenders);
	}
	
	public static void m4() {
		System.out.println("// Query 4 : Print the name of all departments in the organization?.");
	 List<String> allDepartsNames = employeeList.stream().map(e->e.getDepartment()).distinct().collect(Collectors.toList());
	 System.out.println("alldepartments names :"+allDepartsNames);
	}
	public static void m5() {
		System.out.println(" Query 5 : What is the average age of male and female employees?");
		Map<String, Double> averageAge = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		System.out.println("average of alll male and female employees :"+averageAge);
	}
	public static void m6() {
		System.out.println(" Query 6 : Get the details of highest paid employee in the organization?");
		Optional<Employee> maxSalEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println("highest salried Empoyee :"+maxSalEmp.get());
	}
	public static void m7() {
		System.out.println("query 7 Get the names of all employees who have joined after 2015?\"");
		List<String> empNames = employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());
		System.out.println("employees joined after 2015"+empNames);
	}
	public static void m8() {
		System.out.println("Query 8 : Count the number of employees in each department?");
		Map<String, Long> empCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("AllEmps in all depaerment"+empCount);
	}
	public static void m9() {
		System.out.println("Query 9 : What is the average salary of each department?\"");
		Map<String, Double> averageSal = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getAge)));
		System.out.println("average salary in all deps "+averageSal);
	}
	public static void m10() {
		System.out.println("//\"Query 10 : Get the details of youngest male employee in the product development department?\"");
		Optional<Employee> youngEmployee = employeeList.stream().filter(e->e.getDepartment().equalsIgnoreCase("product development")).min(Comparator.comparing(Employee::getAge));
		
		System.out.println("youngest employee in product dep :"+youngEmployee.get());
	}
	public static void m11() {
		System.out.println("//\"Query 11 : Who has the most working experience in the organization?");
		
		Optional<Employee> highExpEmp = employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining));
		System.out.println("highest exp emp "+highExpEmp);
	}
	public static void m12() {
		System.out.println("/12 how many male and female employees are there in the sales and marketing team?");
		Map<String, Long> genderCount = employeeList.stream().filter(e->e.getDepartment().equalsIgnoreCase("Sales and Marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("all male and female emps :"+genderCount);
	}
	public static  void m13() {
		System.out.println("Query 11 : What is the average salary of male and female employees?\"");
		Map<String, Double> gendersSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("genders salary :"+gendersSalary);
	}
	public static void m14() {
		 
		Map<String, List<Employee>> empNames = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("employee names"+empNames);
	}
	
	public static void m16() {
		System.out.println("/14\"encrese employee salary, whover has lesstan 20k by 24%");
		List<Double> newSalary = employeeList.stream().filter(e->e.getSalary()<20000).map(e->e.getSalary()*1.20).collect(Collectors.toList());
		System.out.println("encresed saries :"+newSalary);
	}

}
