package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public void start(){
        List<Employee>employeeList = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setAge(25);
        employee1.setDepartment("Разработка");
        employee1.setFullName("Максим");
        employee1.setSalary(200000.0);

        Employee employee2 = new Employee();
        employee2.setAge(24);
        employee2.setDepartment("Разработка");
        employee2.setFullName("Иван");
        employee2.setSalary(10000.0);

        Employee employee3 = new Employee();
        employee3.setAge(18);
        employee3.setDepartment("Маркетинг");
        employee3.setFullName("Роман");
        employee3.setSalary(70000.0);

        Employee employee4 = new Employee();
        employee4.setAge(28);
        employee4.setDepartment("Разработка");
        employee4.setFullName("Кристина");
        employee4.setSalary(90000.0);

        Employee employee5 = new Employee();
        employee5.setAge(40);
        employee5.setDepartment("Маркетинг");
        employee5.setFullName("Татьяна");
        employee5.setSalary(60000.0);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        boolean workerWithSalaryMore100000IsPresent = employeeList.stream()
                .anyMatch(employee -> employee.getSalary()>100000.00);
        if(workerWithSalaryMore100000IsPresent){
            System.out.println("Сотрудник с зп больше 100_000.00 присутствует");
        }else {
            System.out.println("Сотрудник с зп больше 100_000.00 отсутствует");
        }
    }
}
