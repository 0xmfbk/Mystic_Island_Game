package firstTest;

import java.util.ArrayList;
import java.util.Scanner;


/*
											 -----------------------------------------------------
											 | Mini project (2) 								 |
											 | Question: (2/2) 							         |
											 | Written by: Mustafa Banikhalaf - 2021904052       |
											 | Written by: Mohammad Majdalawy - 2021904045       |
											 -----------------------------------------------------
*/





/*  
	This Java program simulates a basic file management system. 
	It defines classes for files and directories, each with attributes and methods to represent and interact with them. 
	Files have extensions, while directories contain a list of files and subdirectories. 
	The program demonstrates object-oriented 
	principles like : inheritance, polymorphism, and encapsulation, allowing for the creation, addition, and display of file system elements.
	
	
 */










// Here !!!!!!!!!!!! 

// Here is the base class 

// Here !!!!!!!!!!!! 


class Mustafa_Mohammad_FileSystemElement {
	
	
	
    // Attributes for Mustafa_Mohammad_FileSystemElement
	
    private String Fname;
    private int Fsize;
    private String createdDate;

    
    
    // Default Constructor for Mustafa_Mohammad_FileSystemElement class
    
    public Mustafa_Mohammad_FileSystemElement(String name, int size, String createdDate) {
        this.Fname = name;
        this.Fsize = size;
        this.createdDate = createdDate;
    }
		
    
    
    // Getter and setter methods for size
    
    
	public int getSize() {
    	return Fsize;
 }

    public void setSize(int size) {
    	this.Fsize = size;
 }
    
    
 
    
    // Method to display details of the element
    
    
    public void displayDetails() {
        System.out.println("- Name : " + Fname);
        System.out.println("- Size : " + Fsize +" KB");
        System.out.println("- Created Date : " + createdDate);
    }
}












//    Derived class representing a file
//      --------File-class-------


class File extends Mustafa_Mohammad_FileSystemElement {
	
	
         // Attributes for files
	
         private String Fextension;

    
    // default Constructor for File class
    
    public File(String name, int size, String createdDate, String extension) {
    	
    	
        // Call to superclass constructor
    	
        super(name, size, createdDate);
        
        
        
        // Initialize extension attribute
        
        this.Fextension = extension;
        
        
    }

    
    // Method to display details of the file
    
    public void displayDetails() {
    	
        // Call to superclass method
    	
        super.displayDetails();
        
        
        System.out.println("- Type: File");
        // Additional detail for files
        
        System.out.println("- Extension : " + Fextension);
        System.out.println();
        
    }
    
}








//    Derived class representing a Directory

//     --------Directory-class-------


class Directory extends Mustafa_Mohammad_FileSystemElement {
	
	
	
        // Attribute for directories
	
        private ArrayList<Mustafa_Mohammad_FileSystemElement> contents;


    
    
    // default Constructor for Directory class
    
    public Directory(String name, int size, String createdDate) {
    	
        // Call to superclass constructor
    	
        super(name, size, createdDate);
        
        // Initialize contents as an empty list
        
        contents = new ArrayList<>();
    }

    
    

    // Method to display details of the directory
    
    public void displayDetails() {
    	
    	// call displayDetails of base class 
    	
       super.displayDetails();
       
       
       System.out.println("- Type: Directory\n");
       if (!contents.isEmpty()) {
            System.out.println("\n---> Contents of Directory: \n");
        for (Mustafa_Mohammad_FileSystemElement element : contents) {
            element.displayDetails();
            System.out.println();
        }  
    } else {
        System.out.println("\n---> Contents of Directory: Empty\n");
    }
       
       
}

    
    
    //  Method to add a file to the directory
    
    public void addFile(Mustafa_Mohammad_FileSystemElement file) {
    	
        contents.add(file);
           
        // Update directory size by adding the size of the added file
        
        setSize(getSize() + file.getSize());
  }
    
    
}











// Here !!!!!!!!!!!!!

// Here is The Main Function 

// Here !!!!!!!!!!!!!



public class File_Management_System {
	
	
    public static void main(String[] args) {
    	
    	
    	
        Scanner scanner = new Scanner(System.in);
        
        // User information input
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your major: ");
        String major = scanner.nextLine();
        System.out.print("Enter your favorite programming language: ");
        String favoriteLanguage = scanner.nextLine();
        System.out.println("\n----------------------------------------------------------");
        System.out.println("| Welcome, Mr. " + name);
        System.out.println("| You are studying " + major + " at Yarmouk University");
        System.out.println("| Your favorite programming language is " + favoriteLanguage);
        System.out.println("----------------------------------------------------------");
        
        
        // Create instances of File and Directory classes
        
        File file1_Mustafa = new File("Mustafa_Banikhalaf.txt", 2048, "2024-05-12", "txt");
        File file2_Mohammad = new File("Mohammad_Majdalawy.pdf", 1024, "2024-05-12", "pdf");
        File file3_Yarmouk = new File("Yarmouk_University.doc", 4096, "2024-05-12", "doc");
        Directory directory = new Directory("My_Folder", 0, "2024-05-12");

        
        
        // Add files to the directory
        
        directory.addFile(file1_Mustafa);
        directory.addFile(file2_Mohammad);
        directory.addFile(file3_Yarmouk);
        
        
        // Display details of the directory
        
        System.out.println("\n\n---> Directory Details:\n");
        directory.displayDetails();
        
        
        
    }
    
    
}































