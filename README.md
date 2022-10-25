## Requirements
- Java>=17
- Maven>=3.3

## Local installation steps
1. Clone the repository
2. Navigate to `./weather-checker-backend/src/main/resources` directory
3. Copy the content of `application.properties.example` to a new file named `application.properties`
4. Navigate to `./weather-checker-backend` directory
5. Run `mvn install && mvn spring-boot:run`
6. The development web can be accessed at `http://localhost:8080`
7. Fill the `WEATHER_API_KEY` variable at `application.properties` that has just been created by key you get after signing in on the [website]( https://openweathermap.org/)[^1]

[^1]: (you might have to wait for a couple of hours before new the new API key can be used)

## Available endpoints
Name | Method | Parameter | Response
--- | --- | --- | ---
/cities | GET | None | get all cities in Australia
/cities/capitals | GET | None | get all capitals of Australia's State
/weather | GET | lat(String), lon(String) | get the weather info on the provided location
/weather/city/{id} | GET | id(Long) | get weather info by city Id

## Third party API Usage
Here I am using [open weather map API](https://openweathermap.org/current). To use it you have to get API key that you can get by signing up on their website. 
The API key then must be presented on every request to it in the form of request parameter with `appid` key.

Usage example:

<img width="526" alt="image" src="https://user-images.githubusercontent.com/32842793/197106355-316bfeff-06d5-450f-bc23-e8aa907ba7cc.png">

