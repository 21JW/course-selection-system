## Course Selection System


## Prerequisites
* Java 8
* Oracle
* Maven

## Technologies used
* Spring Boot 2.2.2
* Hibernate

## How to run this project
* Clone this project in IntelliJ IDEA;
* Make sure there is no database called `HIBERNATE_DEMO` in Oracle;
* Run `\src\main\java\com\singfung\demo\HibernateTemplateApplication.java` (tables will be created automatically).

## Tables

Three tables are created for this project, which are **COURSE**, **DEMO_USER** and **USER_COURSE**.

### COURSE

this table stores the basic information of courses

| Field | Type | Key | Nullable | Unique | Note |
| :--- | :--- | :--- | :--- | :--- | :--- |
| id | char(36) | Yes | | Yes | primary key |
| name | varchar(255) | | Yes | |course name|
| status | varchar(255) | | Yes | | whether this course is active or not |
| create_time | datetime | | | | the time that this row was inserted |
| ts | datetime | | | | the last time that created or modified this row |

### DEMO_USER

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

### USER_COURSE

this table stores the basic information of USER_COURSE

| Field | Type | Key | Nullable | Unique | Note |
| :--- | :--- | :--- | :--- | :--- | :--- |
| id | char(36) | Yes | | Yes | primary key |
| user_id | char(36) | | Yes | | the id of user who takes this flight |
| course_id | char(36) | | Yes | | the id of flight which is taken by a user |
| create_time | datetime | | | | the time that this row was inserted |
| ts | datetime | | | | the last time that created or modified this row |


## Logic

### COURSE
Before **inserting** a course in record, back-end should check:
1. whether the coursename exist or not; ✔
2. whether all fields except note are not null and valid. ✔

### DEMO_USER
Before **inserting** an user in record, back-end should check:
1. whether username and email address exist or not; ✔
2. whether all fields except note are not null and valid. ✔

### USER_COURSE
Before **inserting** an user_fligth in record, back-end should check:
1. whether the user has choosen that flight✔
2. whether all fields except note are not null and valid. ✔


## APIs

### COURSE
1. add course
2. get course by id or coursename
3. update course by id
4. Search course

### DEMO_USER
1. add user
2. get user by id or email
3. update user by id

### USER_COURSE 
1. add user_course(connect an user with a course)
2. delete user_course(disconnect an user with a course)
3. get all user_course responses
