Feature: Calculator
In order to avoid silly mistakes As a math idiot I want to be told the sum of two numbers

Scenario Outline: Add two numbers

Given I use <browser>

Given I have entered <no1> into the calculator

And I have also entered <no2> into the calculator

When I press <action>

Then the result should be <result> on the screen

Examples:
|browser|no1|no2|result|action|
|'chrome'|51|70|121|add|
|'firefox'|11|13|24|add|