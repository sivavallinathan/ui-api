@Testing
Feature: Campus Cash Core Regresssion 


Scenario Outline: Special characters in Institutional ID
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add institution with special characters
 Then The Institutional peek doesnt accept special characters
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1492|Special characters in Institutional ID|Regression|Siva|chrome|



Scenario Outline: Add Institution with no settlement type
  Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Navigate to Settlement configuration and Add a new institution
 Then New institution is added successfully
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1497|Add Institution with no settlement type|Regression|Siva|chrome|


Scenario Outline: Add Institution with 20 settlement types
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add institution with 20 settlement types
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1499|Add Institution with 20 settlement types|Regression|Siva|chrome|


Scenario Outline: Validate institutions merchant listing
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Navigate to the institution and validate the merchant listing section
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1496|Validate institutions merchant listing|Regression|Siva|chrome|



Scenario Outline: Add Institution with special characters in Description
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Add institution with special characters in the description
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1500|Add Institution with special characters in Description|Regression|Siva|chrome|


Scenario Outline: Add Institution with 1 settlement typesa
Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 And Navigate to Settlement configuration and to the newly added institution	
 Then Add a working settlement type for the institution 
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1500|Special characters in Institutional ID|Regression|Siva|chrome|


