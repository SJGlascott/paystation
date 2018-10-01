/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentType;
import java.util.Scanner;

/**
 *
 * @author scott
 */
public class AltPayment implements PaymentCalc{
    
    Scanner kb = new Scanner(System.in);
    
    public int calculate(int insertedSoFar){
        Boolean weekday = true;
        
        // Calculating based of the day of the week.
        // Linear for weekends
        // Progressive for weekdays
        
        System.out.println("Please '1' for weekday and '2' for weekend:");
        int choice = kb.nextInt();
        
        if(choice == 1)
            {
                weekday = true;
            }
        else
            {
                weekday = false;
            }
            
        
        if(weekday)
            {
                return (new ProgressivePayment()).calculate(insertedSoFar);
            }
        else
            {
                return (new LinearPayment()).calculate(insertedSoFar);
            }
    }
    
}
