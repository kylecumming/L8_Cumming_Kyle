import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WebScrapper {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://weather.gc.ca/canada_e.html");

        WebElement calgaryTemperature = chromeDriver.findElement(By.xpath("//*[@id=\"wxo-section\"]/div/table/tbody/tr[1]/td[3]"));
        WebElement halifaxTemperature = chromeDriver.findElement(By.xpath("//*[@id=\"wxo-section\"]/div/table/tbody/tr[5]/td[3]"));
        WebElement montrealTemperature = chromeDriver.findElement(By.xpath("//*[@id=\"wxo-section\"]/div/table/tbody/tr[7]/td[3]"));
        WebElement torontoTemperature = chromeDriver.findElement(By.xpath("//*[@id=\"wxo-section\"]/div/table/tbody/tr[15]/td[3]"));
        WebElement vancouverTemperature = chromeDriver.findElement(By.xpath("//*[@id=\"wxo-section\"]/div/table/tbody/tr[16]/td[3]"));

        String CalgaryTemp = calgaryTemperature.getText();
        String HalifaxTemp = halifaxTemperature.getText();
        String MontrealTemp = montrealTemperature.getText();
        String TorontoTemp = torontoTemperature.getText();
        String VancouverTemp = vancouverTemperature.getText();

        FileWriter fileWriter = new FileWriter("Weather.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("City: Calgary     Temperature: \t"+CalgaryTemp+"\n");
        bufferedWriter.write("City: Halifax     Temperature: \t"+HalifaxTemp+"\n");
        bufferedWriter.write("City: Montreal    Temperature: \t"+MontrealTemp+"\n");
        bufferedWriter.write("City: Toronto     Temperature: \t"+TorontoTemp+"\n");
        bufferedWriter.write("City: Vancouver   Temperature: \t"+VancouverTemp+"\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();

        chromeDriver.quit();

    }
}
