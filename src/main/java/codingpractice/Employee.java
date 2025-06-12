package codingpractice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee {
    int salary;
    String employeeName;
    String cityName;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Employee(int salary, String employeeName, String cityName) {
        this.salary = salary;
        this.employeeName = employeeName;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", employeeName='" + employeeName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}

class EmployeeTest{
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10000, "Ramesh", "Indore"));
        employeeList.add(new Employee(1100, "Suresh", "Jabalpur"));
        employeeList.add(new Employee(13200, "Ramesh", "Jhasi"));
        employeeList.add(new Employee(1200, "Ram", "Delhi"));
        employeeList.add(new Employee(5000, "Savita", "Indore"));
        employeeList.add(new Employee(20200, "Kavita", "Merut"));

       Map<String, Optional<Employee>> maxSalary = employeeList.stream().collect(Collectors.groupingBy(e-> e.cityName, Collectors.maxBy(Comparator.comparingInt(e-> e.salary))));
//       maxSalary.forEach((city, employee)-> System.out.println("cityname is "+ city + " "+ "name "+ employee.get().employeeName));

        Map<String, List<Employee>> mapCityList = employeeList.stream().collect(Collectors.groupingBy(e -> e.cityName));
        mapCityList.forEach((city, empList) -> {
//                    System.out.println("city "+city);
//                    empList.forEach(e-> System.out.println(e.getEmployeeName()));
                }
                );

        //print salary greater than 2000
        List<Employee> listOfEmployeeSalaryGreaterThan2000 = employeeList.stream().filter(e -> e.salary > 2000).collect(Collectors.toList());
        listOfEmployeeSalaryGreaterThan2000.forEach(e-> System.out.println(e.getEmployeeName()));
        long count = listOfEmployeeSalaryGreaterThan2000.stream().count();
       // System.out.println(count);

        //highest paid employee in each city
        employeeList.stream().collect(Collectors.groupingBy(e -> e.getCityName(), Collectors.maxBy(Comparator.comparingInt(emp -> emp.getSalary()))));


    }
}
