Feature: Payment

  Scenario: Payment happy path
    Given user is on home page
    When user navigates to payment page
    And user choose quantity "2"
    And click "Buy Now"
    And "$40.00" text is shown
    And enter card details
    And click "Pay $40.00"
    Then "Payment successfull!" message is shown

