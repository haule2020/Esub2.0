package pageObjects;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import managers.PageObjectManager;

public class CrmPage {

	private WebDriver driver;
	private PageObjectManager wd;

	// Constructor
	public CrmPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wd = new PageObjectManager(driver);
	}

	By agreeCheckbox = By.id("agreement");
	By Okbtn = By.id("ok");
	By continueButton = By.xpath("//button[@id and @type = 'submit']");
	By CMND = By.xpath("//*[(text()='CMND') or (text()='National ID')]");
	By CCCD = By.xpath("//*[(text()='CCCD') or (text()='Citizenship Card')]");
	By CMQD = By.xpath("//*[(text()='CMQĐ') or (text()='Military ID')]");
	By passport = By.xpath("//*[(text()='Hộ chiếu') or (text()='Passport')]");
	By id = By.xpath("//input[@placeholder='Xxxxxxxxxxxxxxxx']");
	By dob = By.xpath("//input[@placeholder='DD/MM/YYYY']");
	By clickOutsize = By.xpath("//div[@id='title-page']");
	By Outpatient = By.xpath("//*[text()='Điều trị Ngoại trú (Bệnh, Nha khoa, và Thai sản)'  or text()='Outpatient']");
	By Hospitalization = By.xpath("//*[text()='Điều trị Nội trú/ Nằm viện'  or text()='Hospitalization']");
	By Major = By.xpath("//*[text()= 'Bệnh lý nghiêm trọng' or text() = 'Major']");
	By Disability = By.xpath("//*[text()= 'Thương tật, Tử vong tai nạn, Miễn nộp phí' or text() = 'Disability']");
	By Death = By.xpath("//*[text()= 'Tử vong' or text() = 'Death']");
	By MediCash = By.xpath("//*[text()= 'Trợ cấp y tế' or text() = 'MediCash']");
	By PaymentOrder = By.xpath("//*[text()= 'Lệnh chuyển tiền' or text() = 'PaymentOrder']");
	By BankTransfer = By.xpath("//*[text()= 'Chuyển khoản' or text() = 'BankTransfer']");
	By PolicPremium = By.xpath("//*[text()= 'Đóng phí bảo hiểm' or text() = 'PolicPremium']");
	By bank = By.xpath("//input[@type= 'text' and (@placeholder ='Select bank' or @placeholder ='Chọn ngân hàng')]");
	By branch = By.xpath(
			"//input[@type= 'text' and (@placeholder ='Select branch' or @placeholder ='Chọn chi nhánh ngân hàng')]");
	By uploadForm = By.xpath("//div[@id='hosp_req_1']");
	By uploadForm1 = By.xpath("//div[@id='hosp_opt_1']");
	By uploadForm2 = By.xpath("//div[@id='hosp_opt_2']");
	By upload = By.xpath("//div[@id='hosp_req_1']//app-upload//div//div//label//input[@type='file']");
	By uploaded = By.xpath("//div[@id='hosp_req_1_0']");

	By upload1 = By.xpath("//div[@id='hosp_opt_1']//app-upload//div//div//label//input");
	By uploaded1 = By.xpath("//div[@id='hosp_opt_1_0']");

	By upload2 = By.xpath("//div[@id='hosp_opt_2']//app-upload//div//div//label//input");
	By uploaded2 = By.xpath("//div[@id='hosp_opt_2_0']");
	By phone = By.xpath(
			"//div[contains (text(), 'Vui lòng nhập số Điện thoại')or contains (text(), 'Mobile number without prefix') ]//following-sibling::input[1]");
	By clickOutPhone = By.xpath("//*[text()='Viet Nam (+84)']");
	By caseId = By.xpath(
			"//*[text()='Số tham chiếu của Quý khách là' or text()='Your Reference number is']//following-sibling::span");

	public void launchPage(String pageURL) throws Exception {

		driver.get(pageURL);
		
		Thread.sleep(2000);
		
		driver.quit();
	}

	public void CheckAgreeCheckbox() throws Exception {
		// driverMethod base = new driverMethod(driver);
		wd.getdriverMethod().click(agreeCheckbox);
		Thread.sleep(1000);
		wd.getdriverMethod().click(Okbtn);
		Thread.sleep(2000);
	}

	public void Click_continueBtn() throws Exception {
		// driverMethod base = new driverMethod(driver);

		wd.getdriverMethod().click(continueButton);
		Thread.sleep(1000);
	}

	public void SelectIdType(String payment) throws Exception {

		switch (payment) {
		case "CMND":
			wd.getdriverMethod().click(CMND);

			break;
		case "CCCD":
			wd.getdriverMethod().click(CCCD);

			break;
		case "CMQD":
			wd.getdriverMethod().click(CMQD);

			break;
		case "Passport":
			wd.getdriverMethod().click(passport);

			break;

		default:
			wd.getdriverMethod().click(CMND);
			break;
		}
	}

	

	public void input_ID(String idValue) throws Exception {
		wd.getdriverMethod().writeText(id, idValue);
		Thread.sleep(1000);
		wd.getdriverMethod().click(clickOutsize);
		Thread.sleep(1000);
	}

	public void input_dob(String DOB) throws Exception {
		wd.getdriverMethod().writeText(dob, DOB);
		Thread.sleep(1000);
		wd.getdriverMethod().click(clickOutsize);
		Thread.sleep(1000);
	}

	public void select_Hospitalization() throws Exception {

		wd.getdriverMethod().click(Hospitalization);
		Thread.sleep(1000);
	}

	public void select_MediCash() throws Exception {
		wd.getdriverMethod().Jsclick(MediCash);
		Thread.sleep(1000);
	}

	public void select_PaymentType(String paymentType) throws Exception {
		if (paymentType.equals("2")) {
			wd.getdriverMethod().Jsclick(PaymentOrder);
			Thread.sleep(1000);
		} else if (paymentType.equals("1")) {
			wd.getdriverMethod().Jsclick(BankTransfer);
			Thread.sleep(1000);
		} else if (paymentType.equals("3")) {
			wd.getdriverMethod().Jsclick(PolicPremium);
			Thread.sleep(1000);
		}
	}

	public void select_Bank(String Bank, String paymentType) throws Exception {

		if (paymentType.equals("2")) {
			wd.getdriverMethod().writeText(bank, Bank);
			By BankSeleted = By.xpath("//*[b='" + Bank + "']");
			wd.getdriverMethod().Jsclick(BankSeleted);
			Thread.sleep(2000);
		}
		else {
		}
	}

	public void select_Branch(String Bank, String Branch, String paymentType) throws Exception {
		if (paymentType.equals("2")) {
			wd.getdriverMethod().writeText(branch, Branch);
			By BranchSeleted = By.xpath("//*[b='" + Bank.toUpperCase() + "']");
			wd.getdriverMethod().Jsclick(BranchSeleted);
			Thread.sleep(4000);
		}
	}

	public void upload_image(String Upload) throws Exception {
		wd.getdriverMethod().waitVisibility(uploadForm);
		Thread.sleep(1000);
		String set = "document.getElementsByName('file')[0].setAttribute('class','');";
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(set);
		Thread.sleep(3000);
		wd.getdriverMethod().writeText(upload, Upload);
		wd.getdriverMethod().waitVisibility(uploaded);
		System.out.println("Hospital Discharge Documents are Uploaded!");
	}

	public void upload_image1(String Upload1) throws Exception {
		if (!Upload1.isEmpty()) {
			wd.getdriverMethod().waitVisibility(uploadForm1);
			Thread.sleep(1000);
			String set = "document.getElementsByName('file')[1].setAttribute('class','');";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(set);
			Thread.sleep(4000);
			wd.getdriverMethod().writeText(upload1, Upload1);
			wd.getdriverMethod().waitVisibility(uploaded1);
			System.out.println("Medical Documents are Uploaded!");
		}
	}

	public void upload_image2(String Upload2) throws Exception {
		if (!Upload2.isEmpty()) {
			wd.getdriverMethod().waitVisibility(uploadForm2);
			Thread.sleep(1000);
			String set = "document.getElementsByName('file')[2].setAttribute('class','');";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(set);
			Thread.sleep(4000);
			wd.getdriverMethod().writeText(upload2, Upload2);
			wd.getdriverMethod().waitVisibility(uploaded2);
			System.out.println("Other Documents are Uploaded!");
		}
	}

	public void input_phone(String Phone) throws Exception {
		wd.getdriverMethod().writeText(phone, Phone);
		Thread.sleep(500);
		wd.getdriverMethod().click(clickOutPhone);
		Thread.sleep(500);
	}

	public void click_finishBtn() throws Exception {
		boolean dis = driver.findElement(continueButton).isDisplayed();
		if (dis == true) {
			wd.getdriverMethod().click(continueButton);
			Thread.sleep(1000);
		}

		else {
			Thread.sleep(5000);
			wd.getdriverMethod().click(continueButton);
			Thread.sleep(1000);
		}
	}

	public String get_caseID() throws Exception {
		String caseNumber = wd.getdriverMethod().readText(caseId);
		Thread.sleep(1000);
		return caseNumber;

	}

}
