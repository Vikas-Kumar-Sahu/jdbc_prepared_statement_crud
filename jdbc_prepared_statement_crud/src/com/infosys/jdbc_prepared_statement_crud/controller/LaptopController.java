package com.infosys.jdbc_prepared_statement_crud.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.infosys.jdbc_prepared_statement_crud.dao.LaptopDao;
import com.infosys.jdbc_prepared_statement_crud.entity.Laptop;
import com.infosys.jdbc_prepared_statement_crud.service.LaptopService;

public class LaptopController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LaptopDao dao = new LaptopDao();
		
		LaptopService service = new LaptopService();
		
		System.out.println("1.INSERT\n2.DELETE\n3.UPDATE\n4.DISPLAYALL");
		System.out.println("please enter your choice");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: {
			System.out.println("enter laptop id");
			int id = sc.nextInt();
			System.out.println("enter laptop name");
			String name = sc.next();
			System.out.println("enter laptop color");
			String color = sc.next();
			System.out.println("enter laptop price");
			double price = sc.nextDouble();
			
			//pass mfd (yyyy-mm-dd) ("2019-09-11")
			System.out.println("enter laptop manufacturing date");
			String mfd = sc.next();
			
			//LocalDate date = LocalDate.parse(mfd);
			
			//Laptop laptop = new Laptop(id, name, color, price, LocalDate.parse(mfd));
			
			Laptop laptop = service.saveLaptopService(new Laptop(id, name, color, price, LocalDate.parse(mfd)));
			
			String msg = laptop!=null?"success":"data not stored";
			
			System.out.println(msg);
			
		}	break;		
		case 2: {
			System.out.println("enter laptop id");
			int id = sc.nextInt();
			
			int a = dao.deleteLaptopByIdDao(id);
			
			String msg = a!=0?"deleted":"given id is not present or check your code";
			
			System.out.println(msg);
			
		}	break;
		case 3: {
			System.out.println("enter laptop id");
			int id = sc.nextInt();
			System.out.println("1.Name\n2.color\n3.price\n4.mfd");
			System.out.println("please enter your choice");
			int opt = sc.nextInt();
			switch(opt) {
			case 1 : {
				System.out.println("update laptop name");
				String name = sc.next();
				Laptop laptop = new dao.updateLatopByIdDao(name, id);
			}	break;
			case 2 : {
				System.out.println("update laptop color");
				String color = sc.next();
			}	break;
			case 3 : {
				System.out.println("update laptop price");
				double price = sc.nextDouble();
			}	break;
			case 4 : {
				System.out.println("update laptop manufacturing date");
				String mfd = sc.next();
			}
			}

		}	break;
		case 4: {
			List<Laptop> laptops = dao.getAllLaptopDao();
			for(Laptop laptop : laptops)
					System.out.println(laptop);
		}	break;
		}
		sc.close();
	}
}
