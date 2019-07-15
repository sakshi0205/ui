package ui;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import AccountException.AccountNotFoundException;
import bean.Player;
import bean.UserMain;
import services.AccountServiceImpl;

public class AccountMain {

	static AccountServiceImpl service=new AccountServiceImpl();
	
	static void showMenu()
	  {
		 System.out.println("********************Payment Wallet*********************");
		  System.out.println("01. Create User Account: ");
		  System.out.println("02. Show Balance: ");
		  System.out.println("03. Deposite Amount: ");
		  System.out.println("04. Withdraw Amount:");
		  System.out.println("05. Fund Transfer");
		  System.out.println("06. Getting UserAccount Details");
		  System.out.println("07. Print Transaction");
		  System.out.println("08. Exit");
		  System.out.println("Enter your choice: ");
	  }
	
	   public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			while(true){
				showMenu();
				int choice;
				choice=sc.nextInt();
				UserMain user=new UserMain();
				switch(choice)
				{
				case 1:
					System.out.println("!!!!!*************Customer should sign up first**************!!!!!");
					String userPassword=null;
					System.out.println("Enter User Name: ");
					String userName=sc.next();
					 String updateName = service.nameCheck(userName);  //validation method for name.
			 		 if(updateName.equals("exit")) {   						// if service class return exit switch case will break.
			 			 break;
			 		 }
					Random r=new Random();
					Integer accountNo=r.nextInt(600000000);
					System.out.println("Enter Password: ");
					userPassword=sc.next();
					user.setUserName(userName);
					String updatePassword=service.passwordCheck(userPassword);
					if(updatePassword.equals("exit"))
					{
						break;
					}
					System.out.println("Enter EmailId: ");
					String emailId=sc.next();
					
					 String updateEmailId = service.EmailIdCheck(emailId);  //validation method for name.
			 		 if(updateEmailId.equals("exit")) {   						// if service class return exit switch case will break.
			 			 break;
			 		 }
					System.out.println("Enter PhoneNo: ");
					 String phoneNo=sc.next();
					 String updateNumber = service.PhoneNumberCheck(phoneNo);  //validation method for name.
			 		 if(updateNumber.equals("exit")) {   						// if service class return exit switch case will break.
			 			 break;
			 		 }
					Integer account=service.createUserAccount(accountNo, userPassword);
					
					System.out.println(user.getUserName()+ " your account number is : "+account);
					break;
					
				case 2:
					System.out.println("!!!!!*******Customer Account Balance Details!!!!!*******");
					System.out.println("Enter your Account number: ");
					accountNo=sc.nextInt();
					
					while(true) {
			 			 //this try-catch block throws user defined exception[AccountNotFoundException]
			 			 try {
			 				accountNo = service.validAccountNo(accountNo);
			 				 break;
			 			 }
			 			 catch(AccountNotFoundException e) {
			 				System.out.println(e);
			 				System.out.println("Enter again:[Enter exit for login]");
			 				accountNo = sc.nextInt();
							if(accountNo.equals(0)) {
								accountNo=0;
								break;
							}
			 			 }
			 		 }
			 		 if(accountNo.equals("exit")) { //if user enter exit switch case will be close.
			 			 break;
			 		 }
			 		 sc.nextLine();
					System.out.println("Enter account password: ");
					userPassword=sc.nextLine();
					String updatPassword=service.passwordCheck(userPassword);
					if(updatPassword.equals("exit"))
					{
						break;
					}
					Integer balance=service.showBalance(accountNo, userPassword);
					System.out.println(" Your account number is this "+accountNo +" and Balance is "+balance);
					break;
					
				case 3:
					System.out.println("!!!!!**************Deposite Money To Your Account!!!!!*************");
					System.out.println("Enter your Account number: ");
					accountNo=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter account password: ");
					userPassword=sc.nextLine();
					System.out.println("Enter amount you want to deposite: ");
					Integer amount=sc.nextInt();
					sc.nextLine();
					service.deposite(accountNo, userPassword,amount);
					break;

				case 4:
					System.out.println("!!!!!*************Withdraw Money From Account!!!!!*************");
					System.out.println("Enter your Account number: ");
					accountNo=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter account password: ");
					userPassword=sc.nextLine();
					System.out.println("Enter amount you want to withdraw: ");
					amount=sc.nextInt();
					sc.nextLine();
				     balance=service.withdraw(accountNo, userPassword,amount);
					System.out.println("After withdraw balance is " +balance);
					break;
					
				case 5:
					System.out.println("!!!!!*************Tranfer Money From Account!!!!!*************");
					System.out.println("Enter your Account number: ");
					accountNo=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter account password: ");
					userPassword=sc.nextLine();
				    System.out.println("Enter account number of other user: ");
					Integer accountNo2=sc.nextInt();
					System.out.println("Enter amount you want to transfer: ");
					amount=sc.nextInt();
					sc.nextLine();
					String a=service.fundTransfer(accountNo, userPassword, accountNo2,amount);
					System.out.println(a);
					break;
					
				case 6:
					System.out.println("!!!!!*************Getting Account Details Of User!!!!!*************");
					System.out.println("Enter your Account number: ");
					accountNo=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter account password: ");
					userPassword=sc.nextLine();
					service.getUserAccountDetails( accountNo, userPassword);
					break;
					
					
				case 7:
					System.out.println("!!!!!*************Print Transaction!!!!!*************");
					System.out.println("Enter your Account number: ");
					accountNo=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter account password: ");
					userPassword=sc.nextLine();
					String Transaction=service.printTransaction(accountNo, userPassword);
					System.out.println(Transaction);
					break;
					
				case 8:
					sc.close();
					System.out.println("Exit");
				}		
				
				
					
					
				
				
			}}		
					
}
