package QA_Test;

import Reusable_Library.Reusable_Actions_Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Optimax_test {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver;
        //driver = Reusable_Actions_Loggers.setDriver();//Commented out chrome driver
        driver = Reusable_Actions_Loggers.setGeckoDriver();




        //navigating to optimax browser
        driver.navigate().to("https://portal-staging.optimatax.com/login");
        //driver.manage().window().maximize(); <-- I could also this to maximize as well.

        //putting some wait statement below
        Thread.sleep(3000);

        //script below for logins
        // entering users credential below in username and password inputs using try&catch exception

        try{
            driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sprasad+32854@optimataxrelief.com");
        }catch(Exception error){
            System.out.println("not being able to write in username input field " + error);
        }// end of trycatch exception for username

        try{
            driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
        }catch(Exception error){
            System.out.println("not being able to write in password input field " + error);
        }//end of try catch exception for password

        //putting some sleep statement below
        Thread.sleep(2000);

        //click on log in button
        try{
            driver.findElement(By.xpath("//*[@id='login-btn']")).click();
        }catch(Exception error){
            System.out.println("Log in button is not clicking " + error);
        }//end of try catch exception for clicking on log in buttons

        //wait statement
        Thread.sleep(1000);


        //clicking on "forms" using relative xpath
        try {
            driver.findElement(By.xpath("//*[@class='request-section-header']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on forms " + error);
        }//end of try catch exception

        //wait statement
        Thread.sleep(1000);

        //clicking on worksheet below
        try {
            driver.findElement(By.xpath("//*[@class='col-md-8']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on the worksheet inside the forms " + error);
        }//end of try catch exception

        //wait statement
        Thread.sleep(2000);

        //clicking on radio button

        try {
            driver.findElement(By.xpath("//*[@value='single']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on the worksheet inside the forms " + error);
        }//end of try catch exception

        //wait statement
        Thread.sleep(2000);

        //calling mouse actions
        Actions actions = new Actions(driver);



        //entering data in a household number field

       try {
            WebElement numberPpl = driver.findElement(By.xpath("//*[@name='people_in_household']"));
            actions.moveToElement(numberPpl).doubleClick().sendKeys(Keys.BACK_SPACE).perform();
            numberPpl.sendKeys("3");
       }catch (Exception error){
           System.out.println("House hold member field is not taking any data " + error);
        }//end of try catch exception



        //entering on depends field
        Thread.sleep(2000);

        try {
            WebElement dependents = driver.findElement(By.xpath("//*[@name='dependencies']"));
            actions.moveToElement(dependents).doubleClick().sendKeys(Keys.BACK_SPACE).perform();
            dependents.sendKeys("2");
        }catch (Exception error){
            System.out.println("Dependents field is not taking any data " + error);
        }//end of try catch exception


        Thread.sleep(2000);
        //clicking on next
        try {
            driver.findElement(By.xpath("//*[@value='Next']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on next button " + error);
        }//end of try catch exception



        //Started to filling up the income and expenses form only as requested



        //entering data in W2 field
        Thread.sleep(5000);
        try {
            WebElement w2Client = driver.findElement(By.xpath("//*[@name='w2[client]']"));
            //actions.moveToElement(w2Client).doubleClick().sendKeys(Keys.BACK_SPACE).perform();
            w2Client.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            w2Client.sendKeys("200000",Keys.TAB);



        }catch (Exception error){
            System.out.println("W2 field is not taking any data " + error);
        }// end of try catch exception



        //clicking on dropdown menu
        Thread.sleep(5000);
        WebElement months = driver.findElement(By.xpath("//*[@id='employer-length-client']"));
        Select list = new Select(months);
        list.selectByVisibleText("10 Months");


        //entering data 1099k field
        Thread.sleep(5000);
        try {
            WebElement selfEmployed = driver.findElement(By.xpath("//*[@name='business_income[client]']"));
          //actions.moveToElement(selfEmployed).doubleClick().sendKeys(Keys.BACK_SPACE).perform();
            selfEmployed.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            selfEmployed.sendKeys("50000");
        }catch (Exception error){
            System.out.println("1099k field is not taking any data " + error);
        }//end of try catch exception


        //entering data in pensions field
        Thread.sleep(5000);
        try {
            WebElement pension = driver.findElement(By.xpath("//*[@name='pension[client]']"));
           // actions.moveToElement(pension).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            pension.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            pension.sendKeys("400");
        }catch (Exception error){
            System.out.println("Pension field is not taking any data " + error);
        }//end of try catch exception


        //entering data in Social Security field
        Thread.sleep(5000);
        try{
            WebElement sSecurity = driver.findElement(By.xpath("//*[@name='social_security[client]']"));
            //actions.moveToElement(sSecurity).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            sSecurity.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            sSecurity.sendKeys("400");

        }catch (Exception error){
            System.out.println("SS input field is not taking any data " + error);
        }//end of try catch exception



        //entering data in other Income field
        Thread.sleep(5000);
        try{
            WebElement otherIncome = driver.findElement(By.xpath("//*[@name='other_income[client]']"));
           // actions.moveToElement(otherIncome).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            otherIncome.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            otherIncome.sendKeys("400");
        }catch(Exception error){
            System.out.println("other Income field is not taking any data " + error);
        }//end of try catch exception


        //entering data in the other income table
        Thread.sleep(5000);

        try{
            WebElement tableIncome = driver.findElement(By.xpath("//*[@name='other_income[client_specify]']"));
            tableIncome.clear();
            tableIncome.sendKeys("$300-Unemployment");
        }catch (Exception error){
            System.out.println("Unable to enter data in other income table " + error);
        }//end of try catch exception



        //Click on next button
        Thread.sleep(5000);
        try{
            driver.findElement(By.xpath("//*[text()='Next']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on Next button " + error);
        }//end of try catch exception


        //clicking on radio button
        Thread.sleep(5000);
        try {
            driver.findElement(By.xpath("(//*[@value='no'])[1]")).click();
        }catch (Exception error){
            System.out.println("Unable to click on the radio button " + error);
        }//end of try catch exception


        //Entering on rent field
        Thread.sleep(5000);

        try{
            WebElement rent = driver.findElement(By.xpath("//*[@name='rent']"));
           // actions.moveToElement(rent).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            rent.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            rent.sendKeys("500");

        }catch (Exception error){
            System.out.println("Rent field is not taking any data " + error);
        }//end of try catch exception



        //Entering on services field

        Thread.sleep(5000);

        try{
            WebElement utilities = driver.findElement(By.xpath("//*[@name='utilities[utilities]']"));
           // actions.moveToElement(utilities).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            utilities.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            utilities.sendKeys("100");
        }catch(Exception error){
            System.out.println("Utilities field is not taking any data " + error);
        }//end of try catch exception


        //Entering on services field
        Thread.sleep(5000);
        try{
            WebElement services = driver.findElement(By.xpath("//*[@name='utilities[services]']"));
            //actions.moveToElement(services).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            services.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            services.sendKeys("100");
        }catch(Exception error){
            System.out.println("Services field is not taking any data " + error);
        }//end of try catch exception



        //clicking on radio button
        Thread.sleep(5000);
        try {
            driver.findElement(By.xpath("(//*[@value='no'])[2]")).click();
        }catch (Exception error){
            System.out.println("Unable to click on the worksheet inside the forms " + error);
        }//end of try catch exception


        //entering on total estimated values
        Thread.sleep(5000);

        try{
            WebElement cashValue = driver.findElement(By.xpath("//*[@name='total_assets[cash]']"));
           // actions.moveToElement(cashValue).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            cashValue.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
           cashValue.sendKeys("2000");
        }catch(Exception error){
            System.out.println("cash value field is not taking any data " + error);
        }//end of try catch exception


        //total other assets
        Thread.sleep(5000);

        try{
            WebElement otherValue = driver.findElement(By.xpath("//*[@name='total_assets[other]']"));
            //actions.moveToElement(otherValue).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            otherValue.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            otherValue.sendKeys("1500");
        }catch(Exception error){
            System.out.println("other value field is not taking any data " + error);
        }//end of try catch exception


        //Click on next button
        Thread.sleep(5000);
        try{
            driver.findElement(By.xpath("//*[text()='Next']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on Next button " + error);
        }//end of try catch exception


        //student loans
        Thread.sleep(7000);
        try{
            WebElement studentMonth = driver.findElement(By.xpath("//*[@name='student_loan[client][monthly]']"));
            //actions.moveToElement(studentMonth).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            studentMonth.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            studentMonth.sendKeys("1000");
        }catch(Exception error){
            System.out.println("Student monthly field is not taking any data " + error);
        }//end of try catch exception

        //total balance
        Thread.sleep(7000);
        try{
            WebElement studentTotal = driver.findElement(By.xpath("//*[@name='student_loan[client][balance]']"));
            //actions.moveToElement(studentTotal).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            studentTotal.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            studentTotal.sendKeys("10000");
        }catch(Exception error){
            System.out.println("Student total balance field is not taking any data " + error);
        }//end of try catch exception


        //total tax installment

        Thread.sleep(5000);
        try{
            WebElement taxMonth = driver.findElement(By.xpath("//*[@name='tax_installment[monthly]']"));
          //  actions.moveToElement(taxMonth).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            taxMonth.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            taxMonth.sendKeys("100");
        }catch(Exception error){
            System.out.println("Tax monthly field is not taking any data " + error);
        }//end of try catch exception


        //tax total balance
        Thread.sleep(5000);
        try{
            WebElement taxTotal = driver.findElement(By.xpath("//*[@name='tax_installment[balance]']"));
           // actions.moveToElement(taxTotal).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            taxTotal.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            taxTotal.sendKeys("10000");
        }catch(Exception error){
            System.out.println("Tax balance field is not taking any data " + error);
        }//end of try catch exception

        //Health insurance premium
        Thread.sleep(5000);
        try{
            WebElement hInsurance = driver.findElement(By.xpath("//*[@name='health_insurance']"));
            //actions.moveToElement(hInsurance).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            hInsurance.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            hInsurance.sendKeys("10000");
        }catch(Exception error){
            System.out.println("Health insurance field is not taking any data " + error);
        }//end of try catch exception

        //out of pocket health expenses
        Thread.sleep(7000);

        try{
            WebElement pocketExpense = driver.findElement(By.xpath("//*[@name='health_out_of_pocket']"));
          // actions.moveToElement(pocketExpense).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            pocketExpense.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            pocketExpense.sendKeys("10000");
        }catch(Exception error){
            System.out.println("Pocket field is not taking any data " + error);
        }//end of try catch exception

        //dependent care
        Thread.sleep(7000);
        try{
            WebElement depCare = driver.findElement(By.xpath("//*[@name='dependent_care[monthly]']"));
           // actions.moveToElement(depCare).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            depCare.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            depCare.sendKeys("1000");
        }catch(Exception error){
            System.out.println("Dependents care field is not taking any data " + error);
        }//end of try catch exception


        //dependent care specified
        Thread.sleep(7000);
        try{
            WebElement depCareSpecify = driver.findElement(By.xpath("//*[@name='dependent_care[specify]']"));
           // actions.moveToElement(depCareSpecify).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            depCareSpecify.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            Thread.sleep(2000);
            depCareSpecify.sendKeys("Dependent Care");
        }catch(Exception error){
            System.out.println("Dependents care specify field is not taking any data " + error);
        }//end of try catch exception

        //Life Insurance
        Thread.sleep(5000);
        try{
            WebElement depCareSpecify = driver.findElement(By.xpath("//*[@name='life_insurances[monthly]']"));
           // actions.moveToElement(depCareSpecify).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            depCareSpecify.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
           // Thread.sleep(2000);
            depCareSpecify.sendKeys("1000");
        }catch(Exception error){
            System.out.println("Dependents care specify field is not taking any data " + error);
        }//end of try catch exception

        //clicking on check box

        Thread.sleep(5000);


        try {
            driver.findElement(By.xpath("//*[@name='life_insurances[type][whole]']")).click();

        }catch (Exception error){
            System.out.println("Unable to click on the check Box " + error);
        }//end of try catch exception




        //court order monthly
        Thread.sleep(5000);
        try{
            WebElement courtPayment = driver.findElement(By.xpath("//*[@name='court_ordered_payments[monthly]']"));
           // actions.moveToElement(courtPayment).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            courtPayment.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            courtPayment.sendKeys("100");
        }catch(Exception error){
            System.out.println("Court monthly field is not taking any data " + error);
        }//end of try catch exception


        //court order balance
        Thread.sleep(5000);
        try{
            WebElement courtTotal = driver.findElement(By.xpath("//*[@name='court_ordered_payments[balance]']"));
           // actions.moveToElement(courtTotal).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            courtTotal.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            courtTotal.sendKeys("1000");
        }catch(Exception error){
            System.out.println("Court Total field is not taking any data " + error);
        }//end of try catch exception


        //court order specify
        Thread.sleep(5000);
        try{
            WebElement courtSpecify = driver.findElement(By.xpath("//*[@id='court_ordered_payments_specify']"));
           // actions.moveToElement(courtSpecify).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            courtSpecify.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            courtSpecify.sendKeys("Court Ordered");
        }catch(Exception error){
            System.out.println("Court specify field is not taking any data " + error);
        }//end of try catch exception


        //credit card section
        Thread.sleep(5000);
        try{
            WebElement cCard = driver.findElement(By.xpath("//*[@name='credit_card_debt[monthly]']"));
            //actions.moveToElement(cCard).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            cCard.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            cCard.sendKeys("100");
        }catch(Exception error){
            System.out.println("Ccard field is not taking any data " + error);
        }//end of try catch exception


        //credit card balance
        Thread.sleep(5000);
        try{
            WebElement cCardTotal = driver.findElement(By.xpath("//*[@name='credit_card_debt[balance]']"));
           // actions.moveToElement(cCardTotal).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            cCardTotal.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            cCardTotal.sendKeys("1000");
        }catch(Exception error){
            System.out.println("Ccard total field is not taking any data " + error);
        }//end of try catch exception


        //credit card balance available
        Thread.sleep(5000);
        try{
            WebElement cCardBalance = driver.findElement(By.xpath("//*[@name='credit_card_debt[available]']"));
            //actions.moveToElement(cCardBalance).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            cCardBalance.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            cCardBalance.sendKeys("1500");
        }catch(Exception error){
            System.out.println("Ccard available field is not taking any data " + error);
        }//end of try catch exception


        //Other expenses

        Thread.sleep(5000);
        try{
            WebElement othExpense = driver.findElement(By.xpath("//*[@name='others[monthly]']"));
            //actions.moveToElement(othExpense).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            othExpense.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            othExpense.sendKeys("20");
        }catch(Exception error){
            System.out.println("Other expenses field is not taking any data " + error);
        }//end of try catch exception


        //other expenses specified
        Thread.sleep(5000);
        try{
            WebElement othExpense = driver.findElement(By.xpath("//*[@id='others_specify']"));
           // actions.moveToElement(othExpense).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            othExpense.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            othExpense.sendKeys("Netflix & Hulu");
        }catch(Exception error){
            System.out.println("Other expenses field is not taking any data " + error);
        }//end of try catch exception




        //Click on next button
        Thread.sleep(5000);
        try{
            driver.findElement(By.xpath("//*[text()='Next']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on Next button " + error);
        }//end of try catch exception


        //Additional questions from the forms

        Thread.sleep(5000);
        try{
            WebElement affordPLan = driver.findElement(By.xpath("//*[@name='monthly_allowance']"));
            //actions.moveToElement(affordPLan).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            affordPLan.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
            affordPLan.sendKeys("500");
        }catch(Exception error){
            System.out.println("Affordable plan field is not taking any data " + error);
        }//end of try catch exception

        Thread.sleep(5000);
        //clicking on dropdown menu
        WebElement resolutionPayment = driver.findElement(By.xpath("//*[@name='preferred_payment_date']"));
        Select resolution = new Select(resolutionPayment);
        resolution.selectByVisibleText("3rd");

        //click on review button
        Thread.sleep(5000);
        try{
            driver.findElement(By.xpath("//*[text()='Review']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on Review button " + error);
        }//end of try catch exception

        //click on complete button
        Thread.sleep(5000);
        try{
            driver.findElement(By.xpath("//*[text()='Complete']")).click();
        }catch (Exception error){
            System.out.println("Unable to click on Complete button " + error);
        }//end of try catch exception








    }//end of main method



}//end of Java class
