Feature: Signup to Mailchimp
Signup for an mailchimp account.
Skapa anv�ndare � allt g�r som f�rv�ntat
Skapa anv�ndare � l�ngt anv�ndarnamn
Skapa anv�ndare � anv�ndare redan upptagen
Skapa anv�ndare � e-mail saknas

Scenario Outline: Signup to mailchimp

Given I have used <browser> as browser

* I have entered my <email> 

* I have also entered <username>

And I choose a <password>

When I press signup

Then <username> should be signed in

Examples:
|browser|email|username|password|username|
|'chrome'|'email'|'username'|'Losenord-NYTT1'|'username'|
|'chrome'|'email'|'longUsername'|'Losenord-NYTT1'|'username'|
|'chrome'|'email'|'mayswallow'|'Losenord-NYTT1'|'username'|


