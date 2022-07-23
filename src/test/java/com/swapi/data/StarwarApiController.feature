Feature: StarWar Api Controller
 
Scenario: Verify that a star war api generating response
 
Given header Authorization = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwYXZhbiIsImV4cCI6MTY1ODU1Mjk0NSwiaWF0IjoxNjU4NTM0OTQ1fQ.Ik86vLyca8vAx6uKcTqGb7QWLrl828A4yqupdCo3p29h-qslBRknvFfoQKLAizGzFPRVkhsGTPxihfW0uP3LVA'
When url 'http://localhost:8200/swapi/filmdetails?type=planets&name=Tatooine'
When method get
Then status 200
And print 'Response is: ', response