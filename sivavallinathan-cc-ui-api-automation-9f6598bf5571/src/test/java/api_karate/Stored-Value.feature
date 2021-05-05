Feature: sample karate test script

Background: Test the background
Given configure headers = { 'x-test': 'rpaveska' }

#transaction Availability
@transactionavailablity
Scenario: Transaction Availablity- Positive flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/stored-value/v1/transactionAvailability/b888879b-ccca-4dd7-be35-f7e6449bfa35?timeZoneId=America/Phoenix'
When method get
Then status 200


Scenario: Transaction Availablity- Negative flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/stored-value/v1/transactionAvailability/AAA?timeZoneId=America/Phoenix'
When method get
Then status 400


Scenario: Transaction Availablity- Negative flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/stored-value/v1/transactionAvailability/AAA?timeZoneId=America/Phoenix'
And request
"""
{
	
}
"""
When method put
Then status 405


Scenario: Transaction Availablity- Negative flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/stored-value/v1/transactionAvailability/AAA?timeZoneId=America/Phoenix'
And request
"""
{
	
}
"""
When method patch
Then status 404

Scenario: Transaction Availablity- Negative flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/stored-value/v1/transactionAvailability/AAA?timeZoneId=America/Phoenix'
When method delete
Then status 405