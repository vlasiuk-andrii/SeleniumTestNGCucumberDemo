Feature: Payment

  Scenario: Payment happy path
    Given user is on home page
    When user navigates to payment page
    And user choose quantity "2"
    And click "Buy now"
    And enter card details
    And click on "Pay"
    Then "Payment successfull!" message is shown

