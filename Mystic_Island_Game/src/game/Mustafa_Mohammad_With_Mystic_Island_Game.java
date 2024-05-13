package game;

import java.util.Scanner;

public class  Mustafa_Mohammad_With_Mystic_Island_Game{
	
	
	

/*
												 -----------------------------------------------------
												 | Mini project (1) 				     |				 
												 | Question: (1/1) 				     |			         
												 | Written by: Mustafa Banikhalaf                    |
												 | Written by: Mohammad Majdalawy                    |
												 -----------------------------------------------------
*/

	
	

	
	/*  Explain in general about this game :
	 
		On Mystic Island, there are two players who will compete to obtain 
		the treasure in the Guardian Temple under certain conditions,
		but they must face many dangerous and frightening challenges in their adventure.
		
	 */


	
	// Here is the Matrix 
	
    public static final char[][] MAP = {
            {'S', 'F', '-', 'R', '-', 'G'},
            {'-', '-', 'D', '-', '-', '-'},
            {'-', 'X', '-', '-', '-', '-'},
            {'-', '-', 'W', '-', '-', '-'},
            {'-', '-', '-', 'L', '-', '-'}
    };
    
    
    
    
    
    
    
    
    
    // Method to print the MAP with format 
    
    public static void printMap(char[][] map) {
        System.out.print("  ");
        for (int j = 0; j < map[0].length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < map.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
	
    
    
    
    
    
    
    
	
    // A variable containing the word to skip the river
    
    public static final String RIVER_ACCESS_WORD = "A river";

    
    
    
    
    
    // The class player is contain : 
    
    // 1- the attributes for players 
    // 2- the constructor for player
    // 3- Method Move() to management the movements by Switch cases 
    // 4- Checks if the player has exceeded the permissible limit
    // 5- IT checks the codes entered by the players, to manage their movement
    // 6- Method for clearPath()
    // 7- Method for Forest()
    // 8- Method for crossRiver()
    // 9- Method for Desert()
    // 10- Method for Mountain()
    // 11- Method for Lake()
    // 12- Method for ForbiddenForest()
    // 13- Method for GuardianTemple()
    // 14- Method for hasWon() --> to check If current location is applay to conditions 
    // 15- Method for getCurrentLocation() --> where is it on the MAP
    // 16- Method for getPosition() --> print the location with specific format
 
    	public static class Player {
    		
    		
    	// 1	
    		
	        int row;
	        int col;
	        int health;
	        int artifacts;

        
        // 2
        
        public Player(int row, int col) {
            this.row = row;
            this.col = col;
            this.health = 100;
            this.artifacts = 0;
        }
        
        
        // 3
   
        public void move(char direction) {
            switch (direction) {
                case 'R':
                    col++;
                    break;
                case 'L':
                    col--;
                    break;
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                default:
                    System.out.println("Invalid Direction");
                    return;
            }

            
   
            // 4
            
            if (row < 0 || row >= MAP.length || col < 0 || col >= MAP[0].length) {
            	System.out.println();
                System.out.println("Invalid move, You've gone too far");
                System.out.println("Ohhhh Noooo !!!!!! You will Kill You ( Be careful )");
                System.out.println();
                return;
            }

            
            
            
            // 5
            
            if (MAP[row][col] == '-') {
                clearPath();
            } else if (MAP[row][col] == 'F') {
                Forest();
            } else if (MAP[row][col] == 'R') {
                if (crossRiver()) {
                	System.out.println();
                    System.out.println("You have successfully crossed the river ( Excellent, adventurer )");
                    System.out.println();
                    col++; // Move one step to the right when crossed the river
                } else {
                	System.out.println();
                    System.out.println("You could not cross the river");
                    System.out.println();
                    return;
                }
            } else if (MAP[row][col] == 'D') {
                Desert();
            } else if (MAP[row][col] == 'W') {
                Mountain();
            } else if (MAP[row][col] == 'L') {
                Lake();
            } else if (MAP[row][col] == 'X') {
                forbiddenForest();
            } else if (MAP[row][col] == 'G') {
                guardiansTemple();
            }
            
            
        }
        
        
        
        
        
        // 6 

        private void clearPath() {
        	System.out.println();
        	System.out.println("----------------------");
            System.out.println("------Clear-Path------");
            System.out.println("----------------------");
            System.out.println();
        }
        
        
        
        
        
        // 7

        private void Forest() {
            health -= 20;
            System.out.println();
            System.out.println("---------------------------------");
        	System.out.println("------Welcome-To-The-Forest------");
            System.out.printf("---------Your-Health:%d----------%n", health);
            System.out.println();

        }
        
        
        
        
        
        // 8
        private boolean crossRiver() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the access word to cross the river, Guess what : ");
            String answer;
            while (true) {
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase(RIVER_ACCESS_WORD)) {
                    return true ;
                } else {
                    System.out.println();
                    System.out.println("Incorrect answer ,  Try again , adventurer? ");
                    System.out.println();
                    continue ;
                }
            }
        }
        
        
        
        
        // 9

        private void Desert() {
            artifacts++;
        	System.out.println();
        	System.out.println("----------------------");
            System.out.printf("---Your-Artifacts:%d---%n",artifacts);
            System.out.println("----------------------");
            System.out.println();

        }

        
        // 10 
        
        private void Mountain() {
        	System.out.println();
        	System.out.println("----------------------");
            System.out.println("------Mountain--------");
            System.out.println("----------------------");
            System.out.println();
        }

        // 11
        
        private void Lake() {
            health += 30;
        	System.out.println();
        	System.out.println("------Welcome-To-The-Lake----");
            System.out.printf("--------Your-Health:%d------%n",health);
            System.out.println("-----------------------------");
            System.out.println();
        }

        // 12
        
        private void forbiddenForest() {
            health -= 10;
        	System.out.println();
        	System.out.println("---ForbiddenForest----");
            System.out.printf("----Your-Health:%d----%n",health);
            System.out.println("----------------------");
            System.out.println();
        }

        
        // 13
        private void guardiansTemple() {
        	System.out.println();
        	System.out.println("---------------------------");
            System.out.println("------GuardiansTemple------");
            System.out.println("---------------------------");
            System.out.println();            
        }
        
        
        // 14
        public boolean hasWon() {
            return getCurrentLocation() == 'G' && health >= 50 && artifacts > 0;
        }

        
        // 15
        public char getCurrentLocation() {
            return MAP[row][col];
        }
        

        // 16
        public String getPosition() {
            return "(" + row + ", " + col + ")";
        }
        
        
    }
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    
    // Here !!!!!!!!!!!!!!!!!
    	// Here !!!!!!!!!!!!!!
    	
    		// The important part is MAIN class 
    	
    	// Here !!!!!!!!!!!!!!
    // Here !!!!!!!!!!!!!!!!!
    
    
    public static void main(String[] args) {
    	
        Scanner scanner4 = new Scanner(System.in);
        
        // to enter some of information about the players 
        
        System.out.print("Please enter your name: ");
        String name = scanner4.nextLine();
        System.out.print("Your age: ");
        int age = scanner4.nextInt();
        
        
        System.out.println();
        System.out.println("Hello, " + name + "! You are " + age + " years old.");
        System.out.println();
    	
    	// define two object of class player 
    	
        Player player1 = new Player(0, 0);
        Player player2 = new Player(0, 0);

        
        
        Scanner scanner = new Scanner(System.in);

        
        
        
        
        
        while (true) {
        	

        	// Here !!!!!!! Every thing about Mustafa
        	
        	printMap(Mustafa_Mohammad_With_Mystic_Island_Game.MAP); // to called class printMap to print the MAP with specific format
        	
        	System.out.println();
            System.out.println("------Mustafa------");
            System.out.println();   
            
            System.out.println("Current Position: " + player1.getPosition());  // Called Method getPosition to print the location for Mustafa
            System.out.print("Decision: Enter a direction (R, L, U, D):"); // Decsioin : Right / Left / Up / Down
            
            String directionInput = scanner.next();
            char direction = directionInput.charAt(0); // To take the direction from User
            
            // The comparison is done if direction from the user is not available
            
            if(direction != 'R' && direction != 'L' && direction != 'U' && direction != 'D') {
            	System.out.println();
                System.out.println("Invalid direction. Focus !!!!!! Focus !!!!!! Focus !!!!!!!! ");
                System.out.println();
                continue;
            }
            
            
            System.out.println();
            player1.move(direction); // To manage the movement of Mustafa
            System.out.println();

            
            // If the direction to the player 1 is ( River ) , It will to enter the access word ("A river")
            // If enterd correct , Success ( cross the river )
            // If enterd not correct , Faild ( not cross the river )
            
            if (player1.getCurrentLocation() == 'R') {
                if (player1.crossRiver()) {
                	System.out.println();
                    System.out.println("You have successfully crossed the river ( Excellent, Mustafa )");
                    System.out.println();
                    player1.move('R');
                    System.out.println("Current Position: " + player1.getPosition());

                } else {
                	System.out.println();
                    System.out.println("You could not cross the river , Mustafa");
                    System.out.println();
                    player1.move('L');
                    System.out.println("Current Position: " + player1.getPosition());
                    continue;
                }
            }
            
            
            
            
            

            
        	// Here !!!!!!! Every thing about Mohammad

            
            
        	printMap(Mustafa_Mohammad_With_Mystic_Island_Game.MAP); // To called class printMap to print the MAP with specific format
        	
        	System.out.println();
            System.out.println("------Mohammad------");
            System.out.println();
            
            System.out.println("Current Position: " + player2.getPosition()); // Called Method getPosition to print the location for Mohammad
            System.out.print("Decision: Enter a direction (R, L, U, D):");
            
            
            directionInput = scanner.next();
            direction = directionInput.charAt(0); // To take the direction from User
            
            
            
            // The comparison is done if direction from the user is not available
            
            if (direction != 'R' && direction != 'L' && direction != 'U' && direction != 'D') {
            	System.out.println();
                System.out.println("Invalid direction , Focus !!!!!! Focus !!!!!! Focus !!!!!!!! ");
                System.out.println();
                continue;
            }
            
            
            
            System.out.println();
            player2.move(direction); // To manage the movement of Mohammad
            System.out.println();

            
            
            // If the direction to the player 1 is ( River ) , It will to enter the access word ("A river")
            // If enterd correct , Success ( cross the river )
            // If enterd not correct , Faild ( not cross the river )
            
            if (player2.getCurrentLocation() == 'R') {
                if (player2.crossRiver()) {
                	System.out.println();
                    System.out.println("You have successfully crossed the river ( Excellent, Mohammad )");
                    System.out.println();                    
                    player2.move('R');
                    System.out.println("Current Position: " + player2.getPosition());
                } else {
                	System.out.println();
                    System.out.println("You could not cross the river , Mohammad");
                    System.out.println();
                    player2.move('L');
                    System.out.println("Current Position: " + player2.getPosition());
                    continue;
                }
            }
            
            
            // Here !!!!!!!!!! The moment Mustafa wins
            // By called hasWon() method in class player

            if (player1.hasWon()) {
            	System.out.println();
                System.out.println("Mustafa wins the game, Excellent!");
                System.out.println();
                System.out.println("Thank you for playing this game, I hope you have a great time.");
                System.out.println();
                System.out.println();
                System.out.println();
                System.exit(0);
                break;
            }

            
            // Here !!!!!!!!!! The moment Mohammad wins
            // By called hasWon() method in class player
            if (player2.hasWon()) {
            	System.out.println();
                System.out.println("Mohammad wins the game, Excellent!");
                System.out.println();
                System.out.println("Thank you for playing this game, I hope you have a great time.");
                System.out.println();
                System.out.println();
                System.out.println();
                System.exit(0);
                break;
            }
            
            
            
            
            
            
        }
    }
}
