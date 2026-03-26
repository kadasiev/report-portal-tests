package ui;

import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import step.DashboardsSteps;
import step.LoginSteps;
import step.NavigationSteps;

public class BaseTest {

  protected LoginSteps loginSteps = new LoginSteps();
  protected DashboardsSteps dashboardsSteps = new DashboardsSteps();
  protected NavigationSteps navigationSteps = new NavigationSteps();

  @BeforeMethod(groups = {"run"})
  public void openBrowser() {
    DriverFactory.openBrowser();
  }

  @AfterMethod(groups = {"run"})
  public void closeBrowser() {
    DriverFactory.closeBrowser();
  }
}
