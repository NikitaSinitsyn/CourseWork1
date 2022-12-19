public class Main {
    public static void main(String[] args) {
        Employee[] Employees = new Employee[4];
        Employees[0] = new Employee("Nikita", "Dmitrievich", "Sintsyn", 5, 2500);
        Employees[1] = new Employee("Vladislava", "Vladimirovna", "Novikova", 4, 3000);
        Employees[2] = new Employee("Polina", "Urievna", "Kostina", 2, 2300);
        Employees[3] = new Employee("Yurii", "Dimitrov", "Nikov", 5, 2100);



        Employee.getFullInformation(Employees);
        int sumSalaries = Employee.getSalaryExpenses(Employees);
        System.out.println("Сумма затраченная на зарплаты равна " + sumSalaries);
        Employee.getEmployeeWithMinSalary(Employees);
        Employee.getEmployeeWithMaxSalary(Employees);
        Employee.getAverageSalary(Employees);
        Employee.getFullNameOfAllEmployees(Employees);
        Employee.getSalaryAfterIndexation(Employees);
        Employee.getEmployeeWithMinSalaryInDepartment(5, Employees);
        Employee.getEmployeeWithMaxSalaryInDepartment(5, Employees);
        int sumSalariesInDepartment = Employee.getSalaryExpensesInDepartment(5, Employees);
        System.out.println("Сумма затраченная на зарплаты в отделе равна " + sumSalariesInDepartment);
        Employee.getSalaryAfterIndexationInDepartment(5, Employees);
        Employee.getFullInformationOfEmployeesInDepartment(5, Employees);
        Employee.getEmployeesWithSalaryLessThan(2400, Employees);
        Employee.getEmployeesWithSalaryBiggerThan(2400, Employees);

    }

}