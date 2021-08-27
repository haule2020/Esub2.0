Feature: End to end flows in eSub2.0

  Background: 
    Given data is avaiable from "C:\\HospialDischarge\\Data\\Data_Input.xlsx"

  @Esub
  Scenario: Create_Hospital_Discharge
    When Perform creating hospital discharge documents

  @Esub
  Scenario: TC01_Launch_Esub
    When Launch esasy Claim page
    And User checks agree terms
    And User click continue button

  @Esub
  Scenario: TC02_Login
    And User select Id type
    And User type id and click out side
    And User type dob and click out side
    And User click continue button

  @Esub
  Scenario: TC02_Select_Benefits
    And User select Hospitalization
    And User select MediCash

  @Esub
  Scenario: TC04_Select_paymentType
    And User select payment method

  @Esub
  Scenario: TC05_Select_Bank_Details
    And User select Bank
    And User select Branch

  @Esub
  Scenario: TC06_Upload_Documents
    And User click continue button
    And User upload reuired documents
    And User upload optional documents
    And User upload other documents

  @Esub
  Scenario: TC07_Enter_Phone_Number
    And User input phone number

  Scenario: TC08_Submit_Case
    When User cick Submit
    Then case id is displayed
