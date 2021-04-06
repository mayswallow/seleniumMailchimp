Feature: Signup to Mailchimp
Examples for regular username, too long username, existing username and empty e-mail input.

Scenario Outline: Signup to mailchimp

Given I have used "<browser>" as browser

* I have entered my "<email>" 

* I have also entered "<username>"

And I choose a password

When I press signup

Then "<username>" will be controlled

Examples:
|browser|email|username|
|edge|email|username|
|firefox|email|longUsername|
|chrome|email|mayswallow|
|chrome||somethingelse|
