Feature: Login cliente

Scenario: Ingresar datos correctos
	Given un cliente con usuario "admin" y pass "admin"
	When realiza el login
	Then Se autentica "LOGIN OK"
	
Scenario: Ingresar datos incorrectos
	Given un cliente con usuario "admin" y pass "teapod"
	When realiza el login
	Then Se autentica "LOGIN NOK"
	
Scenario: Ingresar datos vacios
	Given un cliente con usuario "" y pass ""
	When realiza el login
	Then Se autentica "LOGIN NOK"		