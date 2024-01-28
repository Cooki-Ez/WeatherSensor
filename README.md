# WeatherSensor
RestAPI for weather sensor

API following urls:
(GET) /sensors/registration - registers sensor by its name (two sensors with same name can not be registered).
(POST) /measurements/add - adds a measurement. It contains value (from -100 to 100), raining (true or false) and sensor which had registered this measurement (if sensor is not registered in database measurement is not saved).
(GET) /measurements - receives all measurements.
(GET) /measurements/rainyDaysCount - receives number of rainy days.
Custom errors implemented.