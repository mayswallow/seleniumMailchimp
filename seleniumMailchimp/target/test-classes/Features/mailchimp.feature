Feature: Signup to Mailchimp

Scenario Outline: Signup to mailchimp

Given I have used "<browser>" as browser

* I have entered my "<email>" 

* I have also entered "<username>"

And I choose a password

When I press signup

Then "<username>" will be verified

Examples:
|browser|email|username|
|chrome|email|username|
|chrome|email|longUsername|
|chrome|email|mayswallow|
|chrome||username1|
