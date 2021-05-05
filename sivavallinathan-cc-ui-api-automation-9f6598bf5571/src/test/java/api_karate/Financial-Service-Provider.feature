Feature: Financial Service Provider feature

Background: Test the background
Given configure headers = { 'x-test': 'rpaveska' }

#Settlement file
@settlementfile 
Scenario: Get Settlement File

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/settlementfile/b888879b-ccca-4dd7-be35-f7e6449bfa35/Bbone/dd397df2-0255-47bf-b4af-19e90647ff7f/info'
When method get
Then status 200

Scenario: Get Settlement File-Negative Flow
Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/settlementfile/b888879b-ccca-4dd7-be35-f7e6449bfa35/Bbone/dd397df2-0255-47bf-b4af-19e90647ff7f/inf'
When method get
Then status 404

########################################################
#StopAutoSettlement
@stopprocessing
Scenario: Stop Failing Automatic Stop Processing

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/stopProcessing/'
And request
"""
{
  "institutionId": "b888879b-ccca-4dd7-be35-f7e6449bfa35",
  "settlementTypeName": "Bbone",
  "settlementBatchUUID": "bc6951a5-c631-4062-83fb-9f617ff2e6d5"
}
"""
When method post
Then status 200

###########################################################
#Settlement type Creation
@settlementtypecreations
Scenario: Settlement type Creation-Positive Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/clientconfig/'
And request
"""
{
  "providerConfigId": "6ac3779e-586a-433d-bc14-4d6cded7ea65",
  "userName": "user01",
  "password": null,
  "privateKey": "-----BEGIN RSA PRIVATE KEY-----\nProc-Type: 4,ENCRYPTED\nDEK-Info: AES-128-CBC,55B9A1C6B4A68C0AEBA7EBF0B38BE814\n \nBwxBFM1CnoaC5gw7RWIvm3DjyFLcOuZPyDA6Ois8dHqmkVh747X3zTo8YaaXw3sW\n8NnulvxQcJkvZjx3qxV5JPG4YhffTrNRQwyACdqKkrN7lWIChLV5Q/EbjaFZr26s\nnXotN+1t+Y0aV1FCWasxPAvBIHGtKMmNjk/u4CXpNyrpPWyvdOjyGUMRVWNzjxUO\nxUoXI3YbLbDJiPPQSvStNVBboxufmp9KVnDVJfGVRMdRgYh802HdPpBpOc6sOcgx\nV1ejrR2ATc6wvf+Jii7xYlKt0sSWh4+8AZlFO5pSRANy/RUN6aEbNfuj4GB2ICbn\nvIytzMKPbfPt1In2TOL/igtaAkc8CN6lNL8ejo4v1v8NCr3BROOipmqN+cufpzWD\nJW3d4wRHNIGvVpbUadbRO7vSsPgeNAoE6m/sgi3s0XI6zdf6QOF51ojt+y2nDf7B\n8IzAGgwEJ/hdcC3Z8ds7ufJPh7RJHTBiGdJIPKOHuIbqJuiC0WxRC4wtiikm0Ky8\naYkg1ns+dJsTwq3t0g7yClDC/8pLgHQ8ysCS8mWKtfHiGP/FXeVmyfd2Rem1CfWq\nSJytu9IBsMg6NNcxe7EiqoETlHvhMxwtKBP8EWBQVVGJxSS++yGK7i2Eey/CtxJE\nbjPrjKAs+/ni+F+nOcta5VMuJW2BnjUa7OtXvvGexp/9WllzRAxGS3pLFZhqCSlL\nLKz39O3C/OdYMVmT3/Ww8Zzmj0kIPacbaXPFYBd1Aph+2xJhJGyejQUiDxJNJEyt\nhUp984Xj3zrgwbHaKoOQfAOvfsXHPT14pVlQPZEpc0Sw2ziLUilONeOb+zCZ3RS5\n1tD+2cZDJdPQs1DMIpWDM6Oz6pFGejsNqVWLHdbhuKXwxE7p96sAt8W5uVGv/0bN\nElNENIkVrjtPUOYPekStA0H7rohMkK0bYbkynEgAt58j9z37ckvRvSGyuDwhXNe6\nyAEcWkVPIReiWiAFrChkY4tXgC99GYsL8c/vf4ygi0niKhSZU4CqPp9V+dg7RKxM\nrUZ4es2ZUS+6ey20CdX86plcQg4EEu3hmMW00bmKXCEcCG/8snkzRVkRg7S/eldH\nwj5Lf4anTJfyKGrhPp3/mPpG1tRxonDMgsKJ1F1w2ZlhG//z8NGq0Tq3fIgvtHpy\nFHH20vVEm9ITjNtcE37Zi9AiLJeaVxvJ5gpffasMj39r/70AZYUDCxvSDHXWW/Ri\nU+UwEuz0T5JKPK63NJcjuFoz2RU/9pyyvKgeq3eLdFnERf/KMNnifKjyx4UB1GjS\nPDIBpvAUrcu+8hj/edE161tFESNLk/9GZqk+1F8McVqcuTKu7GJ5Y0mCjfkK2TJ2\nG1N14/It02pANOK8idgBEZIWUh5Gskx00S6LZPCnz6phICjtFkCTaQDn35yBXZJq\nApH3rSNvAF+t7wMBg0AvYAbhiHguxO1v750blMA+yrL0HTe7j3z17fedYGFNXu5T\n5Xp1VP1hla/xaCUi8QZ0zVQOrrguD6+L7Z39pEIitnwVFxw6ftUiDDX+ns5Axqpw\n2GM6zoEIuf+Rj9447Tva6TDvWbG+6LI/0CJyN8aX0K6BChNV5prKCdQPWEE1aEVq\n-----END RSA PRIVATE KEY-----",
  "passPhrase": "passphrase"
}
"""
When method post
Then status 201


Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/settlement-config/v1/institution-configurations'
And def u = response.configId
Then print 'config ID is : ', response.configId
When request 
"""
{
  "description": "01 - RP's Manual test",
  "institutionId": "016a666b-3208-4e3f-87ad-17cdcf3ed0f4",
  "settlementExecutionMinuteOfDay": 60,
  "timeZone": "America/Phoenix",
  "settlementTypes": [
      {
        "enabled": true,
        "financialProviderClientId": #(u),
        "settlementTypeName": "01"
      }
   ]
}
"""
When method post
Then status 201


Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/clientconfig/'
And path u
When method delete
Then status 204


@settlementtypecreation
Scenario: Settlement type Creation-Negative Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/clientconfig/'
And request
"""
{
  "providerConfigI": "6ac3779e-586a-433d-bc14-4d6cded7ea65",
  "userName": "user01",
  "password": null,
  "privateKey": "-----BEGIN RSA PRIVATE KEY-----\nProc-Type: 4,ENCRYPTED\nDEK-Info: AES-128-CBC,55B9A1C6B4A68C0AEBA7EBF0B38BE814\n \nBwxBFM1CnoaC5gw7RWIvm3DjyFLcOuZPyDA6Ois8dHqmkVh747X3zTo8YaaXw3sW\n8NnulvxQcJkvZjx3qxV5JPG4YhffTrNRQwyACdqKkrN7lWIChLV5Q/EbjaFZr26s\nnXotN+1t+Y0aV1FCWasxPAvBIHGtKMmNjk/u4CXpNyrpPWyvdOjyGUMRVWNzjxUO\nxUoXI3YbLbDJiPPQSvStNVBboxufmp9KVnDVJfGVRMdRgYh802HdPpBpOc6sOcgx\nV1ejrR2ATc6wvf+Jii7xYlKt0sSWh4+8AZlFO5pSRANy/RUN6aEbNfuj4GB2ICbn\nvIytzMKPbfPt1In2TOL/igtaAkc8CN6lNL8ejo4v1v8NCr3BROOipmqN+cufpzWD\nJW3d4wRHNIGvVpbUadbRO7vSsPgeNAoE6m/sgi3s0XI6zdf6QOF51ojt+y2nDf7B\n8IzAGgwEJ/hdcC3Z8ds7ufJPh7RJHTBiGdJIPKOHuIbqJuiC0WxRC4wtiikm0Ky8\naYkg1ns+dJsTwq3t0g7yClDC/8pLgHQ8ysCS8mWKtfHiGP/FXeVmyfd2Rem1CfWq\nSJytu9IBsMg6NNcxe7EiqoETlHvhMxwtKBP8EWBQVVGJxSS++yGK7i2Eey/CtxJE\nbjPrjKAs+/ni+F+nOcta5VMuJW2BnjUa7OtXvvGexp/9WllzRAxGS3pLFZhqCSlL\nLKz39O3C/OdYMVmT3/Ww8Zzmj0kIPacbaXPFYBd1Aph+2xJhJGyejQUiDxJNJEyt\nhUp984Xj3zrgwbHaKoOQfAOvfsXHPT14pVlQPZEpc0Sw2ziLUilONeOb+zCZ3RS5\n1tD+2cZDJdPQs1DMIpWDM6Oz6pFGejsNqVWLHdbhuKXwxE7p96sAt8W5uVGv/0bN\nElNENIkVrjtPUOYPekStA0H7rohMkK0bYbkynEgAt58j9z37ckvRvSGyuDwhXNe6\nyAEcWkVPIReiWiAFrChkY4tXgC99GYsL8c/vf4ygi0niKhSZU4CqPp9V+dg7RKxM\nrUZ4es2ZUS+6ey20CdX86plcQg4EEu3hmMW00bmKXCEcCG/8snkzRVkRg7S/eldH\nwj5Lf4anTJfyKGrhPp3/mPpG1tRxonDMgsKJ1F1w2ZlhG//z8NGq0Tq3fIgvtHpy\nFHH20vVEm9ITjNtcE37Zi9AiLJeaVxvJ5gpffasMj39r/70AZYUDCxvSDHXWW/Ri\nU+UwEuz0T5JKPK63NJcjuFoz2RU/9pyyvKgeq3eLdFnERf/KMNnifKjyx4UB1GjS\nPDIBpvAUrcu+8hj/edE161tFESNLk/9GZqk+1F8McVqcuTKu7GJ5Y0mCjfkK2TJ2\nG1N14/It02pANOK8idgBEZIWUh5Gskx00S6LZPCnz6phICjtFkCTaQDn35yBXZJq\nApH3rSNvAF+t7wMBg0AvYAbhiHguxO1v750blMA+yrL0HTe7j3z17fedYGFNXu5T\n5Xp1VP1hla/xaCUi8QZ0zVQOrrguD6+L7Z39pEIitnwVFxw6ftUiDDX+ns5Axqpw\n2GM6zoEIuf+Rj9447Tva6TDvWbG+6LI/0CJyN8aX0K6BChNV5prKCdQPWEE1aEVq\n-----END RSA PRIVATE KEY-----",
  "passPhrase": "passphrase"
}
"""
When method post
Then status 400



@settlementtypecreation
Scenario: Settlement type Creation-Negative Flow

Given url 'https://aks-qa-us-west-cc.campuscloud.io/api/financial-service-provider/v1/clientconfig'
And request
"""
{
  "providerConfigI": "6ac3779e-586a-433d-bc14-4d6cded7ea65",
  "userName": "user01",
  "password": null,
  "privateKey": "-----BEGIN RSA PRIVATE KEY-----\nProc-Type: 4,ENCRYPTED\nDEK-Info: AES-128-CBC,55B9A1C6B4A68C0AEBA7EBF0B38BE814\n \nBwxBFM1CnoaC5gw7RWIvm3DjyFLcOuZPyDA6Ois8dHqmkVh747X3zTo8YaaXw3sW\n8NnulvxQcJkvZjx3qxV5JPG4YhffTrNRQwyACdqKkrN7lWIChLV5Q/EbjaFZr26s\nnXotN+1t+Y0aV1FCWasxPAvBIHGtKMmNjk/u4CXpNyrpPWyvdOjyGUMRVWNzjxUO\nxUoXI3YbLbDJiPPQSvStNVBboxufmp9KVnDVJfGVRMdRgYh802HdPpBpOc6sOcgx\nV1ejrR2ATc6wvf+Jii7xYlKt0sSWh4+8AZlFO5pSRANy/RUN6aEbNfuj4GB2ICbn\nvIytzMKPbfPt1In2TOL/igtaAkc8CN6lNL8ejo4v1v8NCr3BROOipmqN+cufpzWD\nJW3d4wRHNIGvVpbUadbRO7vSsPgeNAoE6m/sgi3s0XI6zdf6QOF51ojt+y2nDf7B\n8IzAGgwEJ/hdcC3Z8ds7ufJPh7RJHTBiGdJIPKOHuIbqJuiC0WxRC4wtiikm0Ky8\naYkg1ns+dJsTwq3t0g7yClDC/8pLgHQ8ysCS8mWKtfHiGP/FXeVmyfd2Rem1CfWq\nSJytu9IBsMg6NNcxe7EiqoETlHvhMxwtKBP8EWBQVVGJxSS++yGK7i2Eey/CtxJE\nbjPrjKAs+/ni+F+nOcta5VMuJW2BnjUa7OtXvvGexp/9WllzRAxGS3pLFZhqCSlL\nLKz39O3C/OdYMVmT3/Ww8Zzmj0kIPacbaXPFYBd1Aph+2xJhJGyejQUiDxJNJEyt\nhUp984Xj3zrgwbHaKoOQfAOvfsXHPT14pVlQPZEpc0Sw2ziLUilONeOb+zCZ3RS5\n1tD+2cZDJdPQs1DMIpWDM6Oz6pFGejsNqVWLHdbhuKXwxE7p96sAt8W5uVGv/0bN\nElNENIkVrjtPUOYPekStA0H7rohMkK0bYbkynEgAt58j9z37ckvRvSGyuDwhXNe6\nyAEcWkVPIReiWiAFrChkY4tXgC99GYsL8c/vf4ygi0niKhSZU4CqPp9V+dg7RKxM\nrUZ4es2ZUS+6ey20CdX86plcQg4EEu3hmMW00bmKXCEcCG/8snkzRVkRg7S/eldH\nwj5Lf4anTJfyKGrhPp3/mPpG1tRxonDMgsKJ1F1w2ZlhG//z8NGq0Tq3fIgvtHpy\nFHH20vVEm9ITjNtcE37Zi9AiLJeaVxvJ5gpffasMj39r/70AZYUDCxvSDHXWW/Ri\nU+UwEuz0T5JKPK63NJcjuFoz2RU/9pyyvKgeq3eLdFnERf/KMNnifKjyx4UB1GjS\nPDIBpvAUrcu+8hj/edE161tFESNLk/9GZqk+1F8McVqcuTKu7GJ5Y0mCjfkK2TJ2\nG1N14/It02pANOK8idgBEZIWUh5Gskx00S6LZPCnz6phICjtFkCTaQDn35yBXZJq\nApH3rSNvAF+t7wMBg0AvYAbhiHguxO1v750blMA+yrL0HTe7j3z17fedYGFNXu5T\n5Xp1VP1hla/xaCUi8QZ0zVQOrrguD6+L7Z39pEIitnwVFxw6ftUiDDX+ns5Axqpw\n2GM6zoEIuf+Rj9447Tva6TDvWbG+6LI/0CJyN8aX0K6BChNV5prKCdQPWEE1aEVq\n-----END RSA PRIVATE KEY-----",
  "passPhrase": "passphrase"
}
"""
When method post
Then status 404
