/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;
import java.util.Scanner;
import PaymentType.*;
/**
 *
 * @author William Bui
 */
public class MainSim {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalCoinException {
        Scanner kb = new Scanner(System.in);
        PayStationImpl ps = new PayStationImpl();
                int input=0;
        while(input !=0){
        System.out.println("Enter an option:\n"
                         + "1: Deposit Coins\n"
                         + "2: Display\n"
                         + "3: Buy Ticket\n"
                         + "4: Cancel\n"
                         + "5: Change Rate Strategy\n"
                         + "0: Exit\n");
            input = kb.nextInt();
            switch(input){
                case 1:
                    System.out.println("Deposit Coins 1 at a time, 0 when finished");
                    while(input != 0){
                        input = kb.nextInt();
                        ps.addPayment(input);
                        System.out.println("Inserted so far: " + ps.getInsertedSoFar());
                    }
                    break;
                case 2:
                    System.out.println(ps.readDisplay());
                    break;
                case 3:
                    System.out.println("Thank you for your purchase!");
                    ps.buy();
                    break;
                case 4:
                    System.out.println("Remember to grab your change.");
                    ps.cancel();
                case 5:
                    System.out.println("0: Linear\n"
                            + "1: Progressive\n"
                            + "2: Alternate\n");
                    input=kb.nextInt();
                    ps.setPaytype(input);
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
        }
        }
    }
    
    
}
