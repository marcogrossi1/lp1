package br.cefetmg.inf.lp1.llp1.lista17;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberWorkers = Integer.parseInt(in.nextLine());
        LinkedHashMap<Integer, Worker> workersList = new LinkedHashMap<>();

        for (int i = 0; i < numberWorkers; i++) {
            String[] line = in.nextLine().split(" ");

            int id = Integer.parseInt(line[0]);

            StringBuilder name = new StringBuilder(line[1]);
            for(int j = 2; j < line.length; ++j) {
                String word = " " + line[j];
                name.append(word);
            }

            workersList.put(id, new Worker(id, name.toString()));
        }

        int numberRegisters = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numberRegisters; i++) {
            String[] line = in.nextLine().split(" ");

            String day = line[0];

            int id = Integer.parseInt(line[1]);
            double workedHours = Double.parseDouble(line[2]);

            double extraHours = workedHours > 8 ? workedHours - 8 : 0;

            workedHours -= extraHours;

            Worker workerAux = workersList.get(id);

            try {
                workerAux.setWorkHistory(day, workedHours + extraHours);
            }
            catch (InvalidDateException e) {
                System.out.println("Error! Invalid date exception. Need to include other date formats.");
            }

            workerAux.setWorkedHours(workedHours);
            workerAux.setExtraWorkedHours(extraHours);
            workerAux.updateTotalSalary(workedHours, extraHours);

            workersList.put(workerAux.getId(), workerAux);
        }

        for(HashMap.Entry<Integer, Worker> entry : workersList.entrySet()) {
            Worker workerAux = entry.getValue();

            try {
                double salaryINSS = workerAux.getSalary() - workerAux.getTotalINSS();
                System.out.printf("%d %s %.1f hrs %.1f hrs R$%.2f R$%.2f %.1f%% R$%.2f R$%.2f %.1f%% R$%.2f R$%.2f R$%.2f\n",
                        workerAux.getId(),
                        workerAux.getName(),
                        workerAux.getWorkedHours() + workerAux.getExtraWorkedHours(),
                        workerAux.getExtraWorkedHours(),
                        workerAux.getExtraWorkedHours() * 150,
                        workerAux.getSalary(),
                        workerAux.getINSSAliquot() * 100,
                        workerAux.getTotalINSS(),
                        salaryINSS,
                        workerAux.getIRPFAliquot() * 100,
                        workerAux.getTotalIRPF(),
                        (workerAux.getTotalIRPF() + workerAux.getTotalINSS()),
                        workerAux.afterTaxesSalary());
            }

            catch (Exception e) {
                System.out.println("Error! " + e.getMessage());
            }

            workerAux.printWorkHistory();
        }

        in.close();
    }
}