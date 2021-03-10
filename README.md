# VaccNow

As a cautious action after Covid-19, VaccNow is an healthcare organization managing the process of Covid-19 vaccine to public, so that the VaccNow is planning to build multi their digital channels for consuming a modern API for basic features.This is planned to be API first approach, of well-tested functions and enabling agility of later modifications.

* ##### Note - Project is built with H2 Memory database and data will be seeded using [data.sql](https://github.com/pisharma2505/vaccine-now/blob/60ba1506b3aa968484f3eb683a82b40ab034bdbf/src/main/resources/data.sql)  on app start.
* ##### Email will be triggerred to the correponding user post confirmation of slot at to his mail-aadress. Need to add mail address in config file of NotificationserviceImpl.

## Table of contents
* [Technologies](#technologies)
* [Setup](#setup)
* [APIs](#apis)
* [ER Diagram](#erd)


## Technologies

Project is created with:
* Java: 8
* Springboot: 2.4.3
* H2 Database
* JUnit5

## Setup
* Import the project as maven project
* Go to project root folder and use **DemoApplication**  with right click to run as SpringBoot App
* Application will run on port number 7070 
* H2 console link -http://localhost:7070/h2  with username : sa and password : password

## APIs

* [API Documentation](https://documenter.getpostman.com/view/12462719/Tz5nceJa)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.getpostman.com/collections/620c1e711bd096b44568)

## ER Diagram

![alt text](https://github.com/pisharma2505/vaccine-now/blob/60ba1506b3aa968484f3eb683a82b40ab034bdbf/src/main/resources/ERDiagram/ERDiagram.pdf)
