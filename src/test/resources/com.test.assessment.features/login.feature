
Feature: Login
  As a user
  I want to login
  So that i can see 'Home Page'

  #Uncomment all tests before beginning

  #Scenario: Valid Login
  #  Given I visit login
  #  When I enter 'investingintesting@gmail.com' in the email field
  #  And I enter 'p4ssw0rd' in the password field
  #  And I press the login button
  #  Then I should see the My Account page


  #Scenario: Invalid Password
  #  Given I visit login
  #  When I enter 'investingintesting@gmail.com' in the email field
  #  And I enter the wrong password 'p4ssword' in the password field
  #  Then I should see an error

  #Scenario: Invalid Username
  #  Given I visit login
  #  When I enter 'investingintesting2@gmail.com' in the email field
  #  And I enter 'p4ssw0rd' in the password field
  #  And I press the login button
  #  Then I should see an error

  #Scenario: Not logged when first visiting the website
  #  Given I visit the homepage
  #  Then I am not logged in

 # Scenario: Once logged in logout button appears
 #   When I have logged in
 #   Then the logout button should be visible

 # Scenario: I am able to logout
 #   Given I am logged in
 #   When I press the logout button
 #   Then I should be logged out


 # Scenario: Email field does not accept invalid emails
  #  Given I visit login
  #  When I enter the following emails in the email field
  # | investingintesting          |
  # | investingintesting@@gmail.com          |
  # | investingintesting@gmail |
  # | investingintesting+spam@gmail.com |
  # | invalidemail@app.gmail.com              |
  # | other.example@gmail.com              |
  # | other*example@gmail.com              |
  # | other#example@gmail.com              |
  # | other@example@gmail.com              |
  #  And I enter 'p4ssw0rd' in the password field
  #  And I press the login button
  #  Then I should see the My Account page

    # Scenario: I am able to login using the api
  #  When I login as a valid user using the api
  #  Then I should be logged in