/*1. Написать POJO класс Employee с 4 полями name, department, age, salary


        Написать класс Generator который содержит только один метод который возвращает Лист с этими Employee.
        3.Написать класс DataBase который содержит Map dataBase = new TreeMap<>();
        и метод который будет добавлять в dataBase Employee,  а в качестве параметра принимать лист  Employee.

        Напишите класс с методом main

        В методе main создайте лист и сгенерируйте туда наших Employee через Generator далее передайте лист в dataBase.

        !!!  метод который будет добавлять в dataBase Employee должен автоматически генерировать ключ. Те Integer ну и передавать туда по очереди наших Employee
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Employee {
    private String name;
    private String department;
    private int age;
    private double salary;

    // Конструктор класса
    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    // Геттеры и сеттеры для полей

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Generator {
    // Метод для генерации листа с Employee
    public static List<Employee> generateEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Doe", "IT", 30, 50000.0));
        employeeList.add(new Employee("Jane Smith", "HR", 28, 45000.0));
        // Добавьте другие сотрудники по необходимости
        return employeeList;
    }
}

class DataBase {
    private Map<Integer, Employee> dataBase = new TreeMap<>();
    private int nextKey = 1;

    // Метод для добавления Employee в dataBase с автоматически генерируемым ключом
    public void addEmployee(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            dataBase.put(nextKey++, employee);
        }
    }

    // Геттер для получения dataBase
    public Map<Integer, Employee> getDataBase() {
        return dataBase;
    }
}

class Main {
    public static void main(String[] args) {
        // Создание листа и добавление Employee через Generator
        List<Employee> employees = Generator.generateEmployees();

        // Создание объекта DataBase и передача листа в dataBase
        DataBase dataBase = new DataBase();
        dataBase.addEmployee(employees);

        // Получение и вывод содержимого dataBase
        Map<Integer, Employee> employeeDataBase = dataBase.getDataBase();
        for (Map.Entry<Integer, Employee> entry : employeeDataBase.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().getName());
        }
    }
}
