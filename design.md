#   Project Design Documentation


##  Author
 - [Zeljka Matovic](https://github.com/ZeljkaMatovic)


##  Overview

The Virtual Power Plant application is system for aggregating distributed power sources into a single cloud based energy provider. It allows users adding batteries, retrieving battery information within specified postcode ranges, and obtaining statistics on the total watt capacity and average watt capacity of batteries in a given range.


##  Architecture

### Components

1. **Model:**
    - `Battery`: Represents a power plant battery with attributes like name, postcode, and watt capacity.
    - `BatteryStatistic`: Represents a the statistics of battery watt capacity, including total and average watt capacity.
    - `BatteryTotalInfo`: Serves as a container class that combines battery names and associated statistics. It includes:
        - `batteryNames` - A list of strings representing the names of batteries.
        - `batteryStatistic` - An instance of the `BatteryStatistic` class providing statistical information about the batteries.

2. **Repository Layer:**
    - `BatteryRepository`: Interacts with the database for battery data retrieval and storage.

3. **Service Layer:**
    - `IBatteryService`: Defines the contract for services related to battery operations in the Virtual Power Plant application. This interface includes methods for adding batteries, retrieving battery names within a specified postcode range, and obtaining statistics on battery watt capacity. Implementations of this interface encapsulate the business logic and functionality required for managing batteries in the system.
    - `BatteryService`:  Implementation of the `IBatteryService` interface. This class manages business logic for battery-related operations.

4. **Controller Layer:**
    - `BatteryController`: Responsible for handling HTTP requests related to batteries.

5. **Configuration:**
    - `application.properties`: Contains application-specific properties.


##  Technologies Used

- **Spring Boot:** Framework for building Java-based web applications.
- **Spring Data JPA:** Simplifies data access with JPA.
- **Mockito:** Mocking framework for unit testing.


##  Edge Cases Considered

   1. **Database Configuration:**
   
      - **Objective:** Configured the application to use an appropriate database.
      - **Implementation:**
         - Utilized Spring Data JPA for seamless database interaction.
         - Configured data source and database properties in `application.properties` for easy management.
         - Ensured compatibility with the chosen database, considering factors like scalability, performance, and maintenance.

   2. **Empty Input:**

      - **Objective:** Ensured the application handles cases where input data is empty.
      - **Implementation:**
         - Implemented input validation in the service layer.
         - Throws `IllegalArgumentException` if the input is empty or null, preventing invalid data from being processed.

   3. **Sorting Order:**

      - **Objective:** Implemented sorting functionality based on the configured order.
      - **Implementation:**
         - Used a configuration property with a default value for sorting order (ascending).
         - Allowed users to override the default order by supplying command line parameters during application startup.
         - Enhanced flexibility in sorting battery names based on user preferences.

   4. **Testing app:** 

      - **Objective:** Verified the correctness and robustness of the application through testing.
      - **Implementation:**
         - Employed JUnit and Mockito for unit testing the service layer.
         - Covered scenarios like adding batteries and ensuring proper sorting order.
         - Utilized tools like Postman for API testing, ensuring end-to-end functionality.


##  Additional Feature

 - **Command Line Parameter:** Allowed overriding configuration properties by supplying command line parameters during application startup.


##  Testing

### Unit Tests

 - `BatteryServiceTest`: Tests for BatteryService methods.
 - `BatteryControllerTest`: Tests for BatteryController methods.


## Build and Deployment

1. **Building the Application:**
   - Execute `mvnw.cmd clean install`.

2. **Running the Application Locally:**
   - Execute `java -jar VirtualPowerPlant-0.0.1-SNAPSHOT.jar` in `target` folder.

3. **Configuration Overrides:**
   - The application allows command-line parameters for configuration overrides.


