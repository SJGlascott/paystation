/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentType;

/**
 *
 * @author scott
 */
public class AltPayment implements PaymentCalc{
    
    public int calculate(int insertedSoFar){
        Boolean weekday = true;
        
        if(weekday)
            return (new ProgressivePayment()).calculate(insertedSoFar);
        else
            return (new LinearPayment()).calculate(insertedSoFar);
    }
    
}
