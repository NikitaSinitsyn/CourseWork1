import java.util.Objects;

public class Employee {
    private final int minDepartment = 1;
    private final int maxDepartment = 5;
    private final double minSalary = 1000;
    private final double maxSalary = 25000;
    private String firstName;
    private String middleName;
    private String lastName;
    private int department;
    private double salary;
    private static int counter = 1;
    private final int id;

    public Employee(String firstName, String middleName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        id = counter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        boolean isParameterValid = Validator.isNumberIsInInterval(department, minDepartment, maxDepartment);
        if(!isParameterValid){
            throw new IndexOutOfBoundsException("Отдел не существует");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        boolean isParameterValid = Validator.isNumberIsInInterval(salary, minSalary, maxSalary);
        if(!isParameterValid){
            throw new IndexOutOfBoundsException("Заданная зарплата не соответствует критериям!");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id: " + id + " " + firstName + " " + middleName + " " + lastName + " " + department + " " + String.format("%.2f", salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && firstName.equals(employee.firstName) && middleName.equals(employee.middleName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, department, salary, id);
    }
    public String getFullName(){
        String output = this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
        return  output;
    }
    public static void getFullInformation(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + " ID: " + employee.getId() + ", Department: " + employee.getDepartment() + ", Salary: " + employee.getSalary());
        }
    }

    public static double getSalaryExpenses(Employee[] employees) {
        double sum = 0d;
        for (Employee employee : employees) {
            sum += employee.salary;
        }
        return sum;
    }

    public static void getEmployeeWithMinSalary(Employee[] employees) {
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeWithMinSalary.getFirstName() + " " + employeeWithMinSalary.getMiddleName() + " " + employeeWithMinSalary.getLastName());
    }

    public static void getEmployeeWithMaxSalary(Employee[] employees) {
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeWithMaxSalary.getFirstName() + " " + employeeWithMaxSalary.getMiddleName() + " " + employeeWithMaxSalary.getLastName());
    }

    public static void getAverageSalary(Employee[] employees) {
        double averageSalary = getSalaryExpenses(employees) / employees.length;
        System.out.println("Среднее значение зарплат равно " + averageSalary);
    }

    public static void getFullNameOfAllEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.print(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + "; ");
            System.out.println();
        }
    }

    public static void getSalaryAfterIndexation(Employee[] employees) {
        final double index = 0.05;
        double salaryAfterIndexation = 0;
        for (Employee employee : employees) {
            salaryAfterIndexation = employee.getSalary() + (employee.getSalary() * index);
            System.out.println("Зарплата сотрудника " + employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName() + " после индексации равна " + salaryAfterIndexation);
        }
    }

    public static void getEmployeeWithMinSalaryInDepartment(int department, Employee[] employees) {
        double minSalary = Double.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        if (department >= 1 && department <= 5) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department && employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                    employeeWithMinSalary = employee;
                }
            }
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + " " + employeeWithMinSalary.getFullName());
        } else {
            throw new IndexOutOfBoundsException("Несуществующий департамент");
        }
    }
    public static void getEmployeeWithMaxSalaryInDepartment(int department, Employee[] employees){
        double maxSalary = Double.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        if (department >= 1 && department <= 5) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                    maxSalary = employee.getSalary();
                    employeeWithMaxSalary = employee;
                }
            }
            System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + " " + employeeWithMaxSalary.getFullName());
        } else {
            throw new IndexOutOfBoundsException("Несуществующий департамент");
        }
    }
    public static int getSalaryExpensesInDepartment(int department, Employee[] employees ){
        int sum = 0;
        if (department >= 1 && department <= 5) {
            for (Employee employee : employees) {
                if(employee.getDepartment() == department) {
                    sum += employee.salary;
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Несуществующий департамент");
        }
        return sum;
    }
    public static void getSalaryAfterIndexationInDepartment(int department, Employee[] employees){
        final double index = 0.05;
        double salaryAfterIndexation = 0;
        if (department >= 1 && department <= 5) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    salaryAfterIndexation = employee.getSalary() + (employee.getSalary() * index);
                    System.out.println("Зарплата сотрудника " + employee.getFullName() + " после индексации равна " + salaryAfterIndexation);
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Несуществующий департамент");
        }
    }
    public static void getFullInformationOfEmployeesInDepartment( int department, Employee[] employees ){
        if (department >= 1 && department <= 5) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    System.out.print(employee.getFullName() + " " + employee.getSalary() + "; ");
                }
            }
            System.out.println();
        } else {
            throw new IndexOutOfBoundsException("Несуществующий департамент");
        }
    }
    public static void getEmployeesWithSalaryLessThan(int number, Employee[] employees){
        for (Employee employee : employees) {
            if(employee.getSalary() < number){
                System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }
    public static void getEmployeesWithSalaryBiggerThan( int number, Employee[] employees){
        for (Employee employee : employees) {
            if(employee.getSalary() >= number){
                System.out.println(employee.getId() + " " + employee.getFullName() + " " + employee.getSalary());
            }
        }
    }
}


