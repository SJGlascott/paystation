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
public class PaymentCalcFactory {
    public PaymentCalc PaymentCalcFactory(int type)
    {
        switch (type) {
            case 0:
                return new LinearPayment();
            case 1:
                return new ProgressivePayment();
            default:
                return new AltPayment();
        }
    }
}
