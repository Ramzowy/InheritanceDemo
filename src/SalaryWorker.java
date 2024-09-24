

public class SalaryWorker extends Worker{


    double annualSalary = 0;
    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {

        super(ID, firstName, lastName, title, YOB, hourlyPayRate);

        this.annualSalary = annualSalary;
    }

    public double calculateWeeklyPay(double hoursWorked) {

        double payTotal = 0;
        double overTime = 0;
        double fullTime = 40;

        if (hoursWorked < 40) {
            payTotal = this.hourlyPayRate * hoursWorked;
        } else {
            overTime = hoursWorked - fullTime;
            payTotal = (this.hourlyPayRate * fullTime) + (this.hourlyPayRate * 1.5 * overTime);
        }

        return (hoursWorked < 40)? annualSalary/52 : payTotal;
    }

    public String displayWeeklyPay(double hoursWorked){

        double overTime = 0;
        double fullTime = 40;
        double payTotal = 0;
        double pay = 0;
        double overTimePay = 0;

        payTotal =  calculateWeeklyPay(hoursWorked);

        if (hoursWorked < 40) {
            pay = hoursWorked * this.hourlyPayRate;
        } else {
            overTime = hoursWorked - fullTime;
            overTimePay = this.hourlyPayRate * overTime * 1.5;
            pay = fullTime * this.hourlyPayRate;
        }

        System.out.printf("\t%.2f\t\t%.2f\t\t%.2f",payTotal,pay,overTimePay);

        return String.format("The weekly pay %.2f is 1/52 of the annual salary", payTotal);
    }

    public String toJSON(){

        String DQ = "\"";

        return "{"+ DQ + "ID" + DQ + ":" + DQ + this.getID() + DQ + "," + DQ + "firstName" + DQ + ":" + DQ + this.getFirstName() + DQ + "," + DQ + "lastName" + DQ + ":" + DQ + this.getLastName() + DQ + "," + DQ + "Title" + DQ + ":" + DQ + this.getTitle() + DQ + "," + DQ + "YOB" + DQ + ":" + DQ + this.getYOB() + DQ + "," + DQ + "hourlyPayRate" + DQ + ":" + DQ + this.hourlyPayRate + DQ + "," + DQ + "annualSalary" +DQ + ":" + DQ + this.annualSalary + DQ + "}";
    }

    public String toXML(){
        return String.format("<person><worker><salaryWorker><ID>%S</ID><firstName>%s</firstName><lastName>%s</lastName><title>%s</title><YOB>%d</YOB><hourlyPayRate>%.2f</hourlyPayRate><annualSalary>%.2f</annualSalary></salaryWorker></worker></person>", this.getID(), this.getFirstName(),this.getLastName(),this.getTitle(),this.getYOB(), this.hourlyPayRate, this.annualSalary);
    }

    public String toCSV(){
        return String.format("%s,%s,%s,%s,%d,%.2f,%.2f", this.getID(), this.getFirstName(), this.getLastName(), this.getTitle(), this.getYOB(), this.hourlyPayRate, this.annualSalary);
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
}
