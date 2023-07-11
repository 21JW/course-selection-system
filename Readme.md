## Flight Booking System


## Prerequisites
* Java 8
* MySQL 8.0.15 or higher version
* Maven

## Technologies used
* Spring Boot 2.2.2
* MyBatis
* MongoDB

## How to run this project
* Clone this project in IntelliJ IDEA;
* Modify`\src\main\resources\application.properties`: replace `spring.datasource.username` and `spring.datasource.password` with your MySQL's username and password respectively;
* Make sure there is no database called `mybatis_template` in MySQL;
* Run `\src\main\java\com\example\mybatis_practice_user\MybatisPracticeUserApplication.java` (tables will be created automatically).

## Tables

Three tables are created for this project, which are **flight**, **demo_user2** and **user_flight**.

### flight

this table stores the basic information of flight

| Field | Type | Key | Nullable | Unique | Note |
| :--- | :--- | :--- | :--- | :--- | :--- |
| id | char(36) | Yes | | Yes | primary key |
| company | varchar(255) | | Yes | |company name|
| flight_name | varchar(20) | | Yes | Yes | each flight_name has a unique code |
| departure | varchar(255) | | Yes | | departure city |
| destination | varchar(255) | | Yes | | destination city|
| create_time | datetime | | | | the time that this row was inserted |
| ts | datetime | | | | the last time that created or modified this row |
| price | INT | | Yes | | flight price |
| depart_time | datetime | | | | the time that the flight departs |

### demo_user2

this table stores the basic information of user

| Field | Type | Key | Nullable | Unique | Note |
| :--- | :--- | :--- | :--- | :--- | :--- |
| id | char(36) | Yes | | Yes | primary key |
| username | varchar(20) | | Yes | Yes | username |
| password | varchar(20) | | Yes | | password |
| email | varchar(20) | | Yes | Yes | email address |
| status | varchar(255) | | | | whether this account is active or not |
| create_time | datetime | | | | the time that this row was inserted |
| ts | datetime | | | | the last time that created or modified this row |

### user_flight

this table stores the basic information of user_flight

| Field | Type | Key | Nullable | Unique | Note |
| :--- | :--- | :--- | :--- | :--- | :--- |
| id | char(36) | Yes | | Yes | primary key |
| user_id | char(36) | | Yes | | the id of user who takes this flight |
| flight_id | char(36) | | Yes | | the id of flight which is taken by a user |
| create_time | datetime | | | | the time that this row was inserted |
| ts | datetime | | | | the last time that created or modified this row |

### mongo_flight

this table stores the basic information of flight booking status

| Field | Type | Key | Nullable | Unique | Note |
| :--- | :--- | :--- | :--- | :--- | :--- |
| flightId | char(36) | Yes | | Yes | primary key |
| capacity | char(36) | | Yes | | passengers capacity of this flight |
| available | char(36) | | Yes | | the remaining capacity of this flight |

## Logic

### flight
Before **inserting** a flight in record, back-end should check:
1. whether fligth_name and its depart time exist or not; ✔
2. whether all fields except note are not null and valid. ✔

### demo_user2
Before **inserting** an user in record, back-end should check:
1. whether username and email address exist or not; ✔
2. whether all fields except note are not null and valid. ✔

### user_flight
Before **inserting** an user_fligth in record, back-end should check:
1. whether the user has booked that flight✔
2. whether all fields except note are not null and valid. ✔

### mongo_flight
Before **inserting** an user_fligth in record, back-end should check:
1. whether the flight is created✔
2. whether all fields except note are not null and valid. ✔


## APIs

### flight
1. add flight
2. get flight by id
3. update flight by id
4. Search flight by departure, destination,start time, end time and order by price.

### user
1. add user
2. get user by id or email
3. update user by id
4. get user by idlist

### user_flight & mongo_flight
1. add user_flight(connect user with a flight)
2. delete user_flight(disconnect user with a flight)
the above two APIs use MongoDB to check flights' availability  
3. get all user_flights responses
