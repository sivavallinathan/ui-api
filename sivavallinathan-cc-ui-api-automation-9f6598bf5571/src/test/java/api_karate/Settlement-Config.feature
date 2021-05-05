@settlementconfig
Feature: Settlement Config 


Background: Test the background
Given configure headers = { 'x-test': 'rpaveska' }

@settlementHistory
Scenario: Settlement History for Single institution-Positive Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-settlement-history/b888879b-ccca-4dd7-be35-f7e6449bfa35'
When method get
Then status 200

Scenario: Settlement History for Single institution-Negative Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-settlement-history/b888879b-ccca-4dd7-be35-f7e6449bfa35?verbose=aaa'
When method get
Then status 200

Scenario: Settlement History for all institution-Positive flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-settlement-history?limit=200'
When method get
Then status 200


@settledrange
Scenario: Settled Ranges-positive Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-configurations/b888879b-ccca-4dd7-be35-f7e6449bfa35/settledDateRanges?timeZoneId=America%2FPhoenix'
When method get
Then status 200


Scenario: Settled Ranges-positive Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-configurations/b888879b-ccca-4dd7-be35-f7e6449bfa35/settledDateRanges?timeZoneId=America%2FPhoeni'
When method get
Then status 400


@stopprocessing
Scenario: Stop Failing Automatic Settlement Reset Processing

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-configurations/b888879b-ccca-4dd7-be35-f7e6449bfa35/settlement-type/Campus%20Life/resetprocessing'
And request
"""
{
	
}
"""
When method post
Then status 200

Scenario: Stop Failing Automatic Settlement 

Given url 'https://aks-qa-us-west-cc-app.campuscloud.io/api/settlement-config/v1/institution-configurations/b888879b-ccca-4dd7-be35-f7e6449bfa35/settlement-type/Campus%20Life/resetprocessing'
When method post
Then status 200



@AutomaticFailures
Scenario: Get Automatic failures -positive Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/automatic-failures'
When method get
Then status 200

@AutomaticFailures
Scenario: Get Automatic failures -Negative Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/automatic-failure'
When method get
Then status 404

@AutomaticFailures
Scenario: Get Automatic failures -Limit Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/automatic-failures?limit=10'
When method get
Then status 200


