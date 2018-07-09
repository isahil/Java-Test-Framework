package appHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideKick {


    public static void goToStudentsPage(WebDriver driver)
    {
        WebElement StudentsTab = driver.findElement(By.xpath("//a[@class='sk--main-menu-item-container sk-tooltip-container' and contains(@href, 'v4qaoh.estarseries.com/v4/organization/tabs/studentTabs') ]"));
        SharedActions.click(driver, StudentsTab);
    }


    public static void goToOrganizationHomeSubTab(WebDriver driver)
    {
        WebElement OrganizationHomeSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, OrganizationHomeSubTab);
    }

    public static void goToStaffHomeSubTab(WebDriver driver)
    {
        WebElement StaffHomeSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, StaffHomeSubTab);
    }

    public static void goToProgressTab(WebDriver driver)
    {
        WebElement ProgressTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, ProgressTab);
    }

    public static void goToManageUserRolesSubTab(WebDriver driver)
    {
        WebElement ManageUserRolesSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, ManageUserRolesSubTab);
    }

    public static void goToReportWriterSubTab(WebDriver driver)
    {
        WebElement ReportWriterSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, ReportWriterSubTab);
    }

    public static void goToEmisSubTab(WebDriver driver)
    {
        WebElement EmisSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, EmisSubTab);
    }

    public static void goToMyLibrariesTab(WebDriver driver)
    {
        WebElement MyLibrariesSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, MyLibrariesSubTab);
    }

    public static void goToOrganizationLibrariesSubTab(WebDriver driver)
    {
        WebElement OrganizationLibrariesSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, OrganizationLibrariesSubTab);
    }

    public static void goToLettersTab(WebDriver driver)
    {
        WebElement LettersTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, LettersTab);
    }

    public static void goToAlertPortalTab(WebDriver driver)
    {
        WebElement PortalTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, PortalTab);
    }

    public static void goToOrganizationInformationSubTab(WebDriver driver)
    {
        WebElement OrganizationInformationSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, OrganizationInformationSubTab);
    }

    public static void goToPrintingTemplatesSubTab(WebDriver driver)
    {
        WebElement PrintingTemplatesSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, PrintingTemplatesSubTab);
    }

    public static void goToOrganizationFilesSubTab(WebDriver driver)
    {
        WebElement OrganizationFilesSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, OrganizationFilesSubTab);
    }

    public static void goToDocumentOptionsSubTab(WebDriver driver)
    {
        WebElement DocumentOptionsSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, DocumentOptionsSubTab);
    }

    public static void goToContentCustomizationSubTab(WebDriver driver)
    {
        WebElement ContentCustomizationSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, ContentCustomizationSubTab);
    }

    public static void goToAuditHistorySubTab(WebDriver driver)
    {
        WebElement AuditHistorySubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, AuditHistorySubTab);
    }

    public static void goToSystemPreferencesSubTab(WebDriver driver)
    {
        WebElement SystemPreferencesSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, SystemPreferencesSubTab);
    }

    public static void goToSISIntegrationSubTab(WebDriver driver)
    {
        WebElement SISIntegrationSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, SISIntegrationSubTab);
    }

    public static void goToDashboardSubTab(WebDriver driver)
    {
        WebElement DashboardSubTab = driver.findElement(By.xpath(""));
        SharedActions.click(driver, DashboardSubTab);
    }


}
