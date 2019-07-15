package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import bean.Employee;
import bean.Player;
import services.PlayerServiceImpl;

public class PlayerStarter {
      static PlayerServiceImpl service=new PlayerServiceImpl();
      public static void showMenu()
      {
    	  System.out.println("01. Add an player");
    	  System.out.println("02. Retrieve player");
    	  System.out.println("03. update an player");
    	  System.out.println("04. Delete an player");
    	  System.out.println("05. Exit");
    	  System.out.println("Enter your choice: ");
      }
      public static void main(String[] args)
      {
		Scanner sc=new Scanner(System.in);
		while(true){
			showMenu();
			int choice;
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Player Details: ");
				System.out.println("Enter player name: ");
				String pname=sc.next();
				sc.nextLine();
				System.out.println("Enter country name: ");
				String c=sc.nextLine();
				System.out.println("Enter specialized in: ");
				String sp=sc.nextLine();
				Player p=new Player();
				p.setPlayerName(pname);
				p.setCountryName(c);
				p.setSpecializedIn(sp);
				service.putPlayer(c,p);
				System.out.println("Player added succesfully");
				break;
				
			case 2:
				System.out.println(" Player Details Are: ");
				HashMap<String,Player>map=service.getPlayer();
				for(Player p1 :map.values())
				{
					System.out.println(p1.getPlayerName()+ "--"+ p1.getCountryName());
					System.out.println("Retrived data successfully");
				}
				break;
				
				
			case 3:
				System.out.println("Update player for country:");
				System.out.println("Enter country name: ");
				String con=sc.next();
				sc.nextLine();
				System.out.println("Enter new player: ");
				String newPlayer=sc.nextLine();
				service.updatePlayer(con, newPlayer);
				System.out.println("Updated Successfully");
				break;
				
			case 4:
				
				System.out.println("Deleting a player: ");
				System.out.println("Entry player country nameto be deleted: ");
				String con1=sc.next();
				service.deletePlayer(con1);
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

