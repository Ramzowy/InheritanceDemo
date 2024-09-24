import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

     SalaryWorker s1,s2,s3;
    @BeforeEach
    void setUp() {
        s1 = new SalaryWorker("001","Henry","David","Mr.",2001,25,52000);
        s2 = new SalaryWorker("002","Luca","Jacob","Mr.",2002,35,72800);
        s3 = new SalaryWorker("003","Richard","David","Mr.",2002,45,93600);
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(1000, s1.calculateWeeklyPay(40));
    }

    @Test
    void displayWeeklyPay() {

        assertEquals("The weekly pay 1800.00 is 1/52 of the annual salary" , s3.displayWeeklyPay(40));
    }

    @Test
    void toJSON() {
        String result = s3.toJSON();

        // Assert: Verify the JSON string is as expected
        String expectedJSON = "{\"ID\":\"003\",\"firstName\":\"Richard\",\"lastName\":\"David\",\"Title\":\"Mr.\",\"YOB\":\"2002\",\"hourlyPayRate\":\"45.0\",\"annualSalary\":\"93600.0\"}";
        assertEquals(expectedJSON, result);
    }

    @Test
    void toXML() {
        String result = s1.toXML();

        // Assert: Verify the XML string is as expected
        String expectedXML = "<person><worker><salaryWorker><ID>001</ID><firstName>Henry</firstName><lastName>David</lastName><title>Mr.</title><YOB>2001</YOB><hourlyPayRate>25.00</hourlyPayRate><annualSalary>52000.00</annualSalary></salaryWorker></worker></person>";
        assertEquals(expectedXML, result);

    }

    @Test
    void toCSV() {
        String result = s1.toCSV();

        // Assert: Verify the XML string is as expected
        String expectedCSV = "001,Henry,David,Mr.,2001,25.00,52000.00";
        assertEquals(expectedCSV, result);
    }

    @Test
    void setAnnualSalary() {
        int expected = 40;
        s1.setHourlyPayRate(40);
        assertEquals(40,s1.getHourlyPayRate());
    }
}