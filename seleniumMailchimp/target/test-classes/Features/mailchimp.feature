Feature: Signup to Mailchimp
Signup for an mailchimp account.

Scenario Outline: Signup to mailchimp

Given I have used <browser> as browser

Given I have entered my <email> 

Given I have also entered <username>

And I choose a <password>

When I press signup

Then i should be signed in

Examples:
|browser|email|username|password|
|'chrome'|'anna@bonnit.se'|'mayswallow'|'NYTTlosenord!1'|
|'firefox'|'klingon@gmail.com'|'R2D2'|'NYTTlosenord!2'|