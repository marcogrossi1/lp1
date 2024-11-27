package br.cefetmg.inf.lp1.llp1.lista17;

public class INSS {
    public static Double calculateTax (Double sal) throws InvalidSalaryException {
        if (sal < 0) {
            throw new InvalidSalaryException();
        }

        double tax;

        if(sal <= 1212) tax = (sal * 0.075);
        else if(sal <= 2427.35) tax = (sal * 0.09);
        else if(sal <= 3641.03) tax = (sal * 0.12);
        else if(sal <= 7087.22) tax = (sal * 0.14);
        else tax = 0;

        return tax;
    }

    public static double getAliquot(Double sal) {
        double aliquot;

        if(sal <= 1212) aliquot = 0.075;
        else if(sal <= 2427.35) aliquot = 0.09;
        else if(sal <= 3641.03) aliquot = 0.12;
        else if(sal <= 7087.22) aliquot = 0.14;
        else aliquot = 0;

        return aliquot;
    }
}
