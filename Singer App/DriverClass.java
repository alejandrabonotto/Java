package exercise01;

import java.time.LocalDate; 

public class DriverClass {

	public static void main(String[] args) {
		
		//Creating object 1 singer using no argument constructor                                                 
		Singer singer1 = new Singer();                                                                           
		                                                                                                         
		//Displaying default arguments                                                                           
		System.out.println("DEFAULT ARGUMENTS");                                                                 
		System.out.println(singer1.toString());                                                                  
					                                                                                                 
		//Setting values one by one to 1 singer using setters and displaying one by one                          
		System.out.println("CHANGES USING SETTERS - ONE BY ONE");                                                
		
		singer1.singerId = 230001;                                                                               
		System.out.println(singer1.toString());                                                                  
		
		singer1.singerName = "Billie Eilish";                                                                    
		System.out.println(singer1.toString());                                                                  
		
		singer1.singerAddress = "Los Angeles, CA, United States of America";                                     
		System.out.println(singer1.toString());                                                                  
		
		singer1.singerBirth = LocalDate.of(2001, 12, 18);                                                        
		System.out.println(singer1.toString());                                                                  
		
		singer1.singerNumberOfAlbums = 2;                                                                        
		System.out.println(singer1.toString());                                                                  
				                                                                                                         
		//Creating object 2 singer using 5 arguments constructor                                                 
		Singer singer2 = new Singer(230001, "Ed Sheeran", "Halifax, YSW, England", LocalDate.of(1991, 2, 17), 7);
			                                                                                                         
		//Displaying 2 singer using method override to String:                                                   
		System.out.println("5 ARGUMENTS CONSTRUCTOR");                                                           
		System.out.println(singer2.toString());  
		
		//using the setAllValues method:
		Singer singer3 = new Singer();
		singer3.setAllValues(singer2);
		System.out.println(singer3);
		

	}

}
