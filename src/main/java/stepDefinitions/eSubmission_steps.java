package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.Hospital;
import managers.Xls_Reader;
import managers.driverUtilities;
import pageObjects.eClaimSubmission;

import java.io.File;

import org.junit.Assert;
import cucumber.TestContext;

public class eSubmission_steps {

	TestContext testContest;
	eClaimSubmission eSubmitssion;
	driverUtilities baseMethod;
	Scenario scenario;
	Xls_Reader reader;

	public eSubmission_steps(TestContext context) throws Exception {
		testContest = context;
		eSubmitssion = testContest.getPageObjectManager().geteClaimSubmissionPage();
		baseMethod = testContest.getPageObjectManager().getdriverMethod();
	}

	@Before
	private void before(Scenario scenario) {
		this.scenario = scenario;

	}

	@After
	public void embedScreenshot(Scenario scenario) throws Exception {

		String sname = scenario.getName();
		String scr = reader.getCellData("config", "SCREENSHOTS", 2);
		String id = reader.getCellData("data", "idNum", 2);
		String pmTyp = reader.getCellData("data", "paymentMethod", 2);
		String idType = reader.getCellData("data", "idType", 2);
		String outputPath = id + "_" + idType + "_" + pmTyp;

		//eSubmitssion.mkdir(outputPath);

		String filename = scr + "\\" + outputPath + "\\" + sname + ".jpg";

		try {
			baseMethod.screenShot(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^data is avaiable from \"([^\"]*)\"$")
	public void dataIsAvaiableFrom(String data) throws Throwable {
		reader = new Xls_Reader(data);

	}

	@When("^Perform creating hospital discharge documents$")
	public void performCreatingHospitalDischargeDocuments() throws Throwable {
		Hospital hos = new Hospital();
		hos.CreateHospital(reader);
	}

	@When("^Launch esasy Claim page$")
	public void launchEsasyClaimPage() throws Throwable {
		String url = reader.getCellData("data", "url", 2);
		eSubmitssion.launchPage(url);
	}

	@When("^User checks agree terms$")
	public void userChecksAgreeTerms() throws Throwable {
		eSubmitssion.CheckAgreeCheckbox();
	}

	@When("^User click continue button$")
	public void userClickContinueButton() throws Throwable {
		eSubmitssion.Click_continueBtn();
	}

	@When("^User select Id type$")
	public void userSelectIdType() throws Throwable {
		String id = reader.getCellData("data", "idType", 2);
		eSubmitssion.SelectIdType(id);
	}

	@When("^User type id and click out side$")
	public void userTypeIdAndClickOutSide() throws Throwable {
		String idNum = reader.getCellData("data", "idNum", 2);
		eSubmitssion.input_ID(idNum);

	}

	@When("^User type dob and click out side$")
	public void userTypeDobAndClickOutSide() throws Throwable {
		String dob = reader.getCellData("data", "dob", 2);
		eSubmitssion.input_dob(dob);

	}

	@When("^User select Hospitalization$")
	public void userSelectHospitalization() throws Throwable {
		eSubmitssion.select_Hospitalization();

	}

	@When("^User select MediCash$")
	public void userSelectMediCash() throws Throwable {
		eSubmitssion.select_MediCash();

	}

	@When("^User select payment method$")
	public void userSelectPaymentMethod() throws Throwable {
		String paymentMethod = reader.getCellData("data", "paymentMethod", 2);
		eSubmitssion.select_PaymentType(paymentMethod);

	}

	@When("^User select Bank$")
	public void userSelectBank() throws Throwable {
		String paymentMethod = reader.getCellData("data", "paymentMethod", 2);
		String Bank = reader.getCellData("data", "bank", 2);
		eSubmitssion.select_Bank(Bank, paymentMethod);

	}

	@When("^User select Branch$")
	public void userSelectBranch() throws Throwable {
		String paymentMethod = reader.getCellData("data", "paymentMethod", 2);
		String Bank = reader.getCellData("data", "bank", 2);
		String Branch = reader.getCellData("data", "branch", 2);
		eSubmitssion.select_Branch(Bank, Branch, paymentMethod);

	}

	@When("^User upload reuired documents$")
	public void userUploadReuiredDocuments() throws Throwable {

		String uploadPath = reader.getCellData("config", "OUTPUT_PDF", 2);
		String idNum = reader.getCellData("data", "idNum", 2);
		String[] files;
		File f = new File(uploadPath);
		files = f.list();

		for (String file : files) {
			if (file.contains(idNum)) {
				eSubmitssion.upload_image(uploadPath + "\\" + file);
				break;
			}
		}
	}

	@When("^User upload optional documents$")
	public void userUploadOptionalDocuments() throws Throwable {
		String Upload1 = reader.getCellData("config", "UPLOAD1", 2);
		eSubmitssion.upload_image1(Upload1);
	}

	@When("^User upload other documents$")
	public void userUploadOtherDocuments() throws Throwable {
		String Upload2 = reader.getCellData("config", "UPLOAD2", 2);
		eSubmitssion.upload_image2(Upload2);
	}

	@When("^User input phone number$")
	public void userInputPhoneNumber() throws Throwable {
		String phone = reader.getCellData("data", "phone", 2);
		eSubmitssion.input_phone(phone);
	}

	@When("^User cick Submit$")
	public void userCickSubmit() throws Throwable {
		eSubmitssion.click_finishBtn();
	}

	@Then("^case id is displayed$")
	public void caseIdIsDisplayed() throws Throwable {
		String caseNum = eSubmitssion.get_caseID();
		String evidence = reader.getCellData("config", "SCREENSHOTS", 2);
		try {
			reader.setCellData("data", "caseId", 2, caseNum);
		} catch (Exception e) {
		}
		Assert.assertFalse(caseNum.isEmpty());
		System.out.println("Case number: " + caseNum);
		System.out.println("Test Completed!!! Verify test evidence at: " + evidence);

	}

}
