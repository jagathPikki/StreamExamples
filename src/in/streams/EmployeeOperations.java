 package in.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EmployeeOperations {
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
		System.out.println("**************************************************************************************");

		m2();
		System.out.println("**************************************************************************************");
		m3();
		System.out.println("**************************************************************************************");
		m4();
		System.out.println("***********************************************");
		m5();
		System.out.println("***********************************************");
		m6();
		System.out.println("***********************************************");
		
		m8();
		System.out.println("***********************************************");
		m9();
		System.out.println("***********************************************");
		m10();
		System.out.println("***********************************************");
		m11();
		System.out.println("***********************************************");
		m13();
		System.out.println("***********************************************");
		m14();
	}
	// Query 1 : How many male and female employees are there in the organization?
	public static void m1() {
		
		Map<String, Long> empMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("the count of the male and female is ::"+empMaleAndFemale);
	}
	
	// Query 2 : Print the name of all departments in the organization?.
	public static void m2() {
		List<String> DepartmentData = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		DepartmentData.forEach(System.out::println);
	}
	// Query 3 : What is the average age of male and female employees?
	public static void m3()
	{
		Map<String, Double> gendersAverageCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
	System.out.println(gendersAverageCount);
		
	}
	// Get the names of all employees who have joined after 2015?"
	public static void m4()
	{
		List<String> EmployeesNamesAfterJoin2015 = employeeList.stream().filter(e->e.getYearOfJoining()>2015).map(Employee::getName).collect(Collectors.toList());
		System.out.println(EmployeesNamesAfterJoin2015);
	}
	//"Query 6 : Count the number of employees in each department?"
	public static void m5() {
	Map<String, Long> DepartmentCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	System.out.println(DepartmentCount);
	
	}
	// Query 4 : Get the details of highest paid employee in the organization?
	public static void m6() {
		Optional<Employee> highestSalary = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(highestSalary);
	}
	
	/*"Query 7 : What is the average salary of each department?"
	public static void m7() {
		Double collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
	}
	*/
	//"Query 8 : Get the details of youngest male employee in the product development department?"
	
	public static void m8() {
		Optional<Employee> min = employeeList.stream().filter(e->e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparing(Employee::getAge));
	
		System.out.println(min.get());
	}
	
	//"Query 9 : Who has the most working experience in the organization?
	
	public static void m9() {
		   Optional<Employee> highExp= employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findAny();
		System.out.println(highExp.get());
	}
	// many male and female employees are there in the sales and marketing team?
	public static void m10() {
		Map<String, Long> empData = employeeList.stream().filter(e->e.getDepartment()=="Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(empData);
	}
	public static void m11() {

		System.out.println("Query 11 : What is the average salary of male and female employees?");
		Map<String, Double> gendersAvSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(gendersAvSalary);
	}
	public static void m12() {

		System.out.println("Query 12 : List down the names of all employees in each department?");
		Map<String, List<Employee>> dataOfNames = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}
	public static void m13()
	{
		System.out.println("sort the employee data in asceding oreder based on salary if salary same compare with name");
 List<Employee> sortedEmployee = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).collect(Collectors.toList());
		System.out.println(sortedEmployee);
	}
	public static void m14() {
		System.out.println("encrese employee salary, whover has lesstan 20k");
		List<Double> HikedSalries = employeeList.stream().map(e->e.getSalary()+e.getSalary()%20).collect(Collectors.toList());
		System.out.println(HikedSalries);
	}
}