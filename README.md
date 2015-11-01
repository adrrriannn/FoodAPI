# FoodAPI

Example creating an API using Spring Boot and Spring Security. This API returns a list of locations for pizza restaurants near by the postal code provided.

##Authentication

This application provides a simple authentication using Spring Security WebSecurityConfigurerAdapter class. There are two hardcoded users with differents roles each one. At the moment, both roles have the same privileges.

    ROLE USER:
    username: user
    password: user
    
    ROLE ADMIN:
    username: admin
    password: admin
    
##Using example

This API can be consumed in different ways and by different tools. For this example cUrl has been used.

  Url request example:
  http://localhost:8080/pizza?postcode={postcode}

  Using cURL:
  curl -u username:password http://localhost:8080/pizza?postcode={postcode}
  
  Valid request example:
  curl -u user:user http://localhost:8080/pizza?postcode=W127BW
  
  Response for the above request:
  
  {"success":true,"pizzaJson":{"results":[{"name":"Omid Superb Pizza","vicinity":"342 Uxbridge Road, London"},{"name":"Domino's","vicinity":"244 Uxbridge Road, London"},{"name":"Fire & Stone","vicinity":"Ariel Way, London"},{"name":"Pizza Express","vicinity":"Unit 3126, Westfield London Shopping Centre, Ariel Way, London"},{"name":"Pizza Express","vicinity":"7 Rockley Road, Shepherds Bush, London"},{"name":"The Bird In Hand","vicinity":"88 Masbro Road, Masbro Road, London, Brook Green, Kensington"},{"name":"Zizinia","vicinity":"95 Bloemfontein Road, London"},{"name":"Dolce Olivia","vicinity":"106 Goldhawk Road, London"},{"name":"Olivia Pizza","vicinity":"147 Askew Road, London"},{"name":"Pizza Corner","vicinity":"276 Uxbridge Road, London"},{"name":"Florence Pizza","vicinity":"186 Du Cane Road, London"},{"name":"Notting Dale Pizza","vicinity":"92-94 Bramley Road, London"},{"name":"Pizza Royal","vicinity":"68 Richmond Way, London"}]}}
  






