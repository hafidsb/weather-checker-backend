## Requirements
- Java>=17
- Maven>=3.3

## Local installation steps
1. Clone the repository
2. Navigate to `./weather-checker-backend` directory
3. Run `mvn install && mvn spring-boot:run`
4. The development web can be accessed at `http://localhost:8080`

## Available endpoints
Name | Method | Parameter | Response
--- | --- | --- | ---
/cities | GET | None | get all city in Australia
/cities/capitals | GET | None | get all capitals of Australia's State
/weather | GET | lat(String), lon(String) | get the weather info on the provided location
/weather/city/{id} | GET | id(Long) | get weather info by city Id

## Third party API Usage
Here I am using [open weather map API](https://openweathermap.org/current). To use it you have to get API key that you can get by signing up their website. 
The API key then must be presented on every request to it in the form of request parameter with `appid` key.

Usage example:

<img width="526" alt="image" src="https://user-images.githubusercontent.com/32842793/197106355-316bfeff-06d5-450f-bc23-e8aa907ba7cc.png">

