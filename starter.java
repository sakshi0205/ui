package ui;

import java.util.List;
import java.util.Scanner;

import bean.Employee;
import services.EmployeeServiceImpl;


public class starter {
  static EmployeeServiceImpl service=new EmployeeServiceImpl();
  
   static void showMenu()
  {
	  System.out.println("01. Add an Employee");
	  System.out.println("02. Retrieve Employees");
	  System.out.println("03. update an Employee");
	  System.out.println("04. Delete an Employee");
	  System.out.println("05. Exit");
	  System.out.println("Enter your choice: ");
  }

public static void main(String []args)
{
	Scanner sc=new Scanner(System.in);

	while(true){
		showMenu();
		int choice;
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter Employee Details: ");
			System.out.println("Enter employee id: ");
			int eid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter employee name: ");
			String name=sc.nextLine();
			System.out.println("Enter employee city: ");
			String city=sc.nextLine();
			Employee emp=new Employee();
			emp.setEmpId(eid);
			emp.setEmpName(name);
			emp.setCity(city);
			service.addEmployee(emp);
			System.out.println("Employee added succesfully");
			break;
			
		case 2:
			System.out.println("Enter Employee Details Are: ");
			List<Employee>list=service.getEmployees();
			for(Employee employee:list)
			{
				System.out.println(employee.getEmpId()+ "--"+ employee.getEmpName()+"--"+employee.getCity());
			}
			break;
			
		case 3:
			System.out.println("Update Employee city for an employee:");
			System.out.println("Enter employee id: ");
			int empid=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter new city: ");
			String newCity=sc.nextLine();
			service.updateEmployee(empid, newCity);
			System.out.println("Updated Successfully");
			break;
			
		case 4:
			
			System.out.println("Enter employee id to be deleted: ");
			Integer empId=sc.nextInt();
			service.deleteEmployee(empId);
			//System.out.println("Deleted successfully");
			break;
			
		case 5:
			sc.close();
			System.exit(0);
			
			
		default:
			System.out.println("wrong entry");
			}
	}
}	
}