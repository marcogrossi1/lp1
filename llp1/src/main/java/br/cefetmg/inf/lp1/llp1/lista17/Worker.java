package br.cefetmg.inf.lp1.llp1.lista17;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Worker {
    private int id;
    private String name;
    private double workedHours = 0, extraWorkedHours = 0;
    private double salary = 0;
    private final LinkedHashMap<String, Double> workHistory = new LinkedHashMap<>();

    Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void updateTotalSalary(double dailyWorkedHours, double dailyExtraWorkedHours) {
        this.salary += 100 * dailyWorkedHours + 150 * dailyExtraWorkedHours;
    }

    // Taxes
    private double afterINSSSalary() {
        return this.salary - getTotalINSS();
    }
    public double afterTaxesSalary() {
        return afterINSSSalary() - getTotalIRPF();
    }

    public double getINSSAliquot() { return INSS.getAliquot(salary); }
    public double getIRPFAliquot() { return IRPF.getAliquot(salary - getTotalINSS()); }

    public double getTotalINSS() {
        try {
            return INSS.calculateTax(salary);
        }

        catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
            return -1.0;
        }
    }
    public double getTotalIRPF() {
        try {
            return IRPF.calculateTax(salary - getTotalINSS());
        }

        catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
            return -1.0;
        }
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getWorkedHours() { return workedHours; }
    public double getExtraWorkedHours() { return extraWorkedHours; }
    public double getSalary() { return salary; }
    public void printWorkHistory () {
        for(HashMap.Entry<String, Double> entry : workHistory.entrySet()) {
            String dateAux = entry.getKey();
            Double hoursAux = entry.getValue();

            System.out.printf("%s : %.1f\n", dateAux, hoursAux);
        }
    }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setWorkedHours(double workedHours) { this.workedHours += workedHours; }
    public void setExtraWorkedHours(double extraWorkedHours) { this.extraWorkedHours += extraWorkedHours; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setWorkHistory(String date, Double dailyWorkedHours) throws InvalidDateException {
        if(!date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}")) {
            throw new InvalidDateException();
        }

        workHistory.put(date, dailyWorkedHours);
    }
}
