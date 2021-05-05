@Testing
Feature: Campus Cash Core Regression

@Testing1799
Scenario Outline: Stop manual settlement
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate Stoping manual settlement

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1583|Stop manual settlement|Regression|Siva|chrome|


Scenario Outline: Download sent csv file - download is successful
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"	
 Then Validate if the settlement is completed and file is downloded 
 
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1561|Download sent csv file - download is successful|Regression|Siva|chrome|

Scenario Outline: FTP connection healthcheck
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate FTP connection healthcheck

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1559|FTP connection healthcheck|Regression|Siva|chrome|



Scenario Outline: manual settlement-startDate>endDate
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate manual settlement-startDate>endDate

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1535|manual settlement-startDate>endDate|Regression|Siva|chrome|

@deb
Scenario Outline: Edit Private/Public key and Passphrase
 Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
 And User navigates and enter into Campucash UI"<Browser>"
 Then Validate editing Private/Public key and Passphrase
Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|
|TC_1532|Edit Private/Public key and Passphrase|Regression|Siva|chrome|


