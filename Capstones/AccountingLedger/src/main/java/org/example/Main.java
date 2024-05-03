package org.example;

public class Main {
    public static void main(String[] args) {
        //Screen.Init();
        //Screen.reports();
        Logger logger = new Logger();
        Report r = new Report(logger.returnPayments());
        //for (String item : r.init()) {
         //   System.out.println(item);
        //}
        r.customReport(r.init());

    }
}
