/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author William Bui
 */

/*
A main() program should be developed to simulate the PayStation operation.
It puts up a menu to allow a customer to select a choice:
Deposit Coins
    accept coins for payment 
        5, 10, 25 cents
Display
    show time bought on display
Buy Ticket
    when buying a parting ticket, print parking time receipts
Cancel
    when cancel option is selected, print total returned coin values and number of each coin type
Change Rate Strategy
    implement three rate strategies for three clients: Linear rate for Alphatown, 
    progressive rate for Betatown and alternating rate for Gammatown. 
    Rate strategy selection and change can be done on the fly, i.e. in run-time. 
    The default rate strategy is linear rate.
 */
public class MainSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalCoinException {
        Scanner kb = new Scanner(System.in);
        PayStationImpl ps = new PayStationImpl();
        Map<Integer, Integer> change = new HashMap<>();
        int input = 0;
        int input2 = 1;
        while (input != 6) {
            System.out.println("Enter an option:\n"
                    + "1: Deposit Coins\n"
                    + "2: Display\n"
                    + "3: Buy Ticket\n"
                    + "4: Cancel\n"
                    + "5: Change Rate Strategy\n"
                    + "6: Exit\n");
            input = kb.nextInt();
            switch (input) {
                case 1:
                    while (true) {
                        System.out.println("Deposit Coins 1 at a time, 0 when finished");
                        input2 = kb.nextInt();
                        if (input2 == 5 || input2 == 10 || input2 == 25) {
                            ps.addPayment(input2);
                        } else if (input2 == 0) {
                            break;
                        } else {
                            System.out.println("Invalid Coin Value");
                        }
                        System.out.println("Inserted so far: " + ps.getInsertedSoFar() + "\n");
                    }
                    break;
                case 2:
                    System.out.println("Inserted so far: " + ps.getInsertedSoFar());
                    System.out.println("Which is worth: " + ps.readDisplay() + "\n");
                    break;
                case 3:
                    System.out.println("Thank you for your purchase!");
                    Receipt receipt = ps.buy();
                    System.out.println("Time Bought: " + receipt.value() + " minutes" + "\n");
                    break;
                case 4:
                    System.out.println("Remember to grab your change.");
                    int returned = ps.getInsertedSoFar();
                    change = ps.cancel();
                    Set set = change.entrySet();
                    Iterator i = set.iterator();
                    System.out.println("Change: " + returned);
                    Map.Entry entry = null;
                    while (i.hasNext()) {
                        entry = (Map.Entry) i.next();
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.println("");
                    break;
                case 5:
                    while (true) {
                        System.out.println("0: Linear\n"
                                + "1: Progressive\n"
                                + "2: Alternate\n");
                        input = kb.nextInt();
                        if (input < 0 || input > 2) {
                            System.out.println("Invalid Input.");
                        } else {
                            ps.setPaytype(input);
                            break;
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid input"+"\n");
            }
        }
    }

}
