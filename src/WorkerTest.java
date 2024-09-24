import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker w1,w2,w3;

    @BeforeEach
    void setUp() {
        w1 = new Worker("001","Daniel","Enzo","Mr.",2001,45);
        w2 = new Worker("002","Diego","Henry","Mr.",2002,40);
        w3 = new Worker("003","Ramsey","Steve","Mr.",2003,35);
    }

    @Test
    void calculateWeeklyPay() {
         assertEquals(1800, w1.calculateWeeklyPay(40));
    }

    @Test
    void displayWeeklyPay() {
        assertEquals("""
                The total pay is: 1800.0
                The full-time pay is: 1800.0
                The over-time pay is: 0.0""", w1.displayWeeklyPay(40));
    }

    @Test
    void toJSON() {
        String result = w1.toJSON();

        // Assert: Verify the JSON string is as expected
        String expectedJSON = "{\"ID\":\"001\",\"firstName\":\"Daniel\",\"lastName\":\"Enzo\",\"Title\":\"Mr.\",\"YOB\":\"2001\",\"hourlyPayRate\":\"45.0\"}";
        assertEquals(expectedJSON, result);
    }

    @Test
    void toXML() {
        String result = w1.toXML();

        // Assert: Verify the XML string is as expected
        String expectedXML = "<person><worker><ID>001</ID><firstName>Daniel</firstName><lastName>Enzo</lastName><title>Mr.</title><YOB>2001</YOB><hourlyPayRate>45.00</hourlyPayRate></worker></person>";
        assertEquals(expectedXML, result);
    }

    @Test
    void toCSV() {
        String result = w1.toCSV();

        // Assert: Verify the XML string is as expected
        String expectedCSV = "001,Daniel,Enzo,Mr.,2001,45.00";
        assertEquals(expectedCSV, result);
    }

    @Test
    void setHourlyPayRate() {
        int expected = 40;
        w1.setHourlyPayRate(40);
        assertEquals(40,w1.getHourlyPayRate());
    }
}