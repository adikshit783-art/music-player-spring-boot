# 🎵 Music Player - Spring Boot

A full-stack web-based music player application built using Java Spring Boot, Spring Data JPA, MySQL, HTML, CSS, and JavaScript.

## 🚀 Live Demo

👉 [Open Music Player](https://music-player-spring-boot-production.up.railway.app)

## 📌 About the Project

Music Player is a full-stack web application that allows users to browse songs, search for songs, and play music through a simple and responsive web interface.

The backend is developed using Spring Boot and provides REST APIs for managing and retrieving songs. Spring Data JPA and Hibernate are used for database operations, while MySQL is used to store song information.

The frontend uses HTML, CSS, and JavaScript to communicate with the backend APIs and provide the music player interface.

## ✨ Features

- 🎵 Browse available songs
- ▶️ Play and pause songs
- ⏮️ Previous song
- ⏭️ Next song
- 🔊 Volume control
- 🔍 Search songs
- 🖼️ Song cover images
- 🎶 Audio playback
- 💾 MySQL database integration
- 🌐 REST API based backend
- ☁️ Deployed on Railway

## 🛠️ Technologies Used

### Backend

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- REST API
- Maven

### Frontend

- HTML
- CSS
- JavaScript

### Database

- MySQL

### Deployment

- Railway
- GitHub

## 🏗️ Project Architecture

```text
src
├── main
│   ├── java
│   │   └── com.musicplayer
│   │       ├── config
│   │       ├── controller
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       └── service
│   │           └── impl
│   │
│   └── resources
│       ├── static
│       │   ├── images
│       │   ├── songs
│       │   ├── app.js
│       │   └── style.css
│       │
│       ├── templates
│       │   └── index.html
│       │
│       ├── application.properties
│       └── application-local.properties
│
└── pom.xml
