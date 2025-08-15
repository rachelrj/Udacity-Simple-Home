# Udacity-Simple-Home

A tiny Spring Boot + Thymeleaf app that demonstrates per-session state:

First visit (new session): shows “Hello, homepage!”

Subsequent visits (same session): shows “Welcome back!”

The original exercise may not have required sessions; this solution uses HttpSession for explicit, per-user correctness.

## Stack

Java 17+

Spring Boot 3.3.x

Thymeleaf

Maven

## Quick Start
### from the project root (where pom.xml lives)
`./mvnw spring-boot:run`       # or: `mvn spring-boot:run`
### then visit:
http://localhost:8080/home