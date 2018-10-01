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
public class LinearPayment implements PaymentCalc{
    
    public int calculate(int insertedSoFar){        
        return insertedSoFar / 5 * 2;
    }
    
}
