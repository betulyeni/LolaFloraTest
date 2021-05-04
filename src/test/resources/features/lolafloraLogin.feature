@login
Feature: Lolaflora Login

  Background:
    Given User is on login page

  Scenario: Login Happy Path
    When User enters email "btly35@gmail.com" and password "1234567890a"
    Then User see "My Account" title on the Dashboard

  Scenario: Login Invalid Password
    When User enters email "btly35@gmail.com" and password "123456789123456789123"
    Then User see message "Please enter minimum 3 and maximum 20 characters." under password input area

  Scenario: Login Wrong Password
    When User enters email "btly35@gmail.com" and password "123456789cv0a"
    Then User see message "E-mail address or password is incorrect. Please check your information and try again." in a new popup

  Scenario: Login Empty Email
    When User enters email "btly35@gmail.com" and password ""
    Then User see message "Required field." under password input area

  Scenario: Login Empty Password
    When User enters email "" and password "1234567890a"
    Then User see message "Required field." under email input area

  Scenario: Login All Empty
    When User enters email "" and password ""
    Then User see message "Required field." under password input area
    And User see message "Required field." under email input area

  Scenario: Login Invalid Email
    When User enters email "a)d@gmail.com " and password "Tes12"
    Then User see message "Please enter a valid e-mail address." under email input area







