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
public class ProgressivePayment implements PaymentCalc{
    
    public double calculate(int insertedSoFar){
        double timeBought = 0;
        if(insertedSoFar<=150)
            timeBought= insertedSoFar / 5 * 2;
        else if(insertedSoFar<=350)
            timeBought= 60 + (insertedSoFar-150) / 5 * 1.5;
        else
            timeBought=120 + (insertedSoFar-350) / 5 * 1;
        
        return timeBought;
    }
}
