@Testing
Feature: Campus Cash Core Regression

@e2e
Scenario Outline: End to End Flow from TSE to OLS
Given Testcase Details "<TestCaseName>" "<TestCaseDesc>" "<Category>" "<Author>" are recored in the report
Given Post Transaction "<Value>" from TSE
Given User navigates and enter into Campucash UI chrome
And Read the excel file and validate the transaction "<Value>"

Examples:
|TestCaseName|TestCaseDesc|Category|Author|Browser|Value|
|E2E Flow|Validate the TSE to OLS flow|Regression|Siva|chrome|3|