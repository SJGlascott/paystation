/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentType;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author scott
 */
public class AltPayment implements PaymentCalc{
    
    public double calculate(int insertedSoFar){
        Date now = new Date();
        
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
        System.out.println(simpleDateformat.format(now));
        
        if (simpleDateformat.format(now) == "Sat" || simpleDateformat.format(now) == "Sun") 
            return (new LinearPayment()).calculate(insertedSoFar);
        else
            return (new ProgressivePayment()).calculate(insertedSoFar);
            
    }
    
}
