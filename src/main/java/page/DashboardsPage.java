package page;

import static element.Element.xpath;

import element.Element;

public class DashboardsPage {

  private static final String DASHBOARD_PATTERN = "//*[contains(@class, 'dashboardTable') and text() = '%s']";
  private static final String WIDGET_TYPE_PATTERN = "//*[contains(@class, 'widgetType') and text() = '%s']";
  private static final String WIDGET_PATTERN = "//*[contains(@class, 'widgetHeader') and text() = '%s']/ancestor::div[contains(@class, 'widget-container')]";
  private static final String WIDGET_DELETE_BUTTON = "//*[name()='svg']/*[name()='path' and contains(@d, 'M7')]";

  private final Element signedInSuccessfullyNotification = xpath("//*[contains(@class, 'notification')]");
  private final Element addNewWidgetButton = xpath("//*[contains(@class, 'ghostButton') and contains(text(), 'widget')]");
  private final Element nextStepButton = xpath("//*[contains(@class, 'ghostButton') and contains(text(), 'Next')]");
  private final Element firstFilterRadiobutton = xpath("//*[contains(@class, 'filtersItem')]/label");
  private final Element widgetNameField = xpath("//input[contains(@class, 'input')]");
  private final Element addButton = xpath("//*[@type = 'button' and text() = 'Add']");
  private final Element confirmDeleteButton = xpath("//*[@type = 'button' and text() = 'Delete']");

  public void openDashboard(String dashboardName) {
    xpath(String.format(DASHBOARD_PATTERN, dashboardName)).click();
  }

  public DashboardsPage waitUntilSignedInSuccessfullyNotificationDisappears() {
    signedInSuccessfullyNotification.waitForInvisibility();
    return this;
  }

  public DashboardsPage clickAddNewWidgetButton() {
    addNewWidgetButton.click();
    return this;
  }

  public DashboardsPage chooseWidgetType(String widgetType) {
    xpath(String.format(WIDGET_TYPE_PATTERN, widgetType)).click();
    return this;
  }

  public DashboardsPage clickNextStep() {
    nextStepButton.click();
    return this;
  }

  public DashboardsPage chooseFirstFilter() {
    firstFilterRadiobutton.click();
    return this;
  }

  public DashboardsPage enterWidgetName(String widgetName) {
    widgetNameField.clear()
        .sendKeys(widgetName);
    return this;
  }

  public void clickAddButton() {
    addButton.click();
  }

  public boolean isWidgetDisplayed(String widgetName) {
    return xpath(String.format(WIDGET_PATTERN, widgetName)).isDisplayed();
  }

  public DashboardsPage deleteWidget(String widgetName) {
    xpath(String.format(WIDGET_PATTERN, widgetName)).hoverOver();
    xpath(String.format(WIDGET_PATTERN, widgetName) + WIDGET_DELETE_BUTTON).click();
    return this;
  }

  public void confirmDelete() {
    confirmDeleteButton.click();
  }
}
