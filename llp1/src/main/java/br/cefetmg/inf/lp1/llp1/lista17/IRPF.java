package br.cefetmg.inf.lp1.llp1.lista17;

public class IRPF implements Taxes {
    public static Double calculateTax(Double sal) throws InvalidSalaryException {
        if (sal < 0) {
            throw new InvalidSalaryException();
        }

        double tax;

        if(sal <= 1903.98) tax = 0;
        else if(sal <= 2826.65) tax = (sal * 0.075) - 142.80;
        else if(sal <= 3751.05) tax = (sal * 0.15) - 354.80;
        else if(sal <= 4664.68) tax = (sal * 0.225) - 636.13;
        else tax =  (sal * 0.275) - 869.36;

        return tax;
    }

    public static double getAliquot(Double sal) {
        double aliquot;

        if(sal <= 1903.98) aliquot = 0;
        else if(sal <= 2826.65) aliquot = 0.075;
        else if(sal <= 3751.05) aliquot = 0.15;
        else if(sal <= 4664.68) aliquot = 0.225;
        else aliquot =  0.275;

        return aliquot;
    }
}
