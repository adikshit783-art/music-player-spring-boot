# 🎵 Music Player - Spring Boot

A full-stack web-based music player application built using **Java, Spring Boot, Spring Data JPA, MySQL, HTML, CSS, and JavaScript**.

The application provides a simple music-player interface where users can browse songs, search for songs, play/pause music, control volume, and navigate between songs.

## 🚀 Live Demo

👉 **[Open Music Player](https://music-player-spring-boot-production.up.railway.app)**

---

## 📌 About the Project

This project is a full-stack music player application developed using **Spring Boot** for the backend and **HTML, CSS, and JavaScript** for the frontend.

The backend provides REST APIs for retrieving and searching songs. **Spring Data JPA and Hibernate** are used for database operations, while **MySQL** stores the song information.

The application is deployed on **Railway**, making it accessible through a public URL.

---

## ✨ Features

- 🎵 Browse available songs
- ▶️ Play and pause music
- ⏮️ Previous song
- ⏭️ Next song
- 🔊 Volume control
- 🔍 Search songs
- 🖼️ Song cover image
- 🎶 Audio playback
- 💾 MySQL database integration
- 🔗 REST API integration
- ⚠️ Custom exception handling
- 🌐 Responsive web interface
- ☁️ Railway deployment

---

## 🛠️ Technologies Used

### Backend

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **REST API**
- **Maven**

### Frontend

- **HTML5**
- **CSS3**
- **JavaScript**

### Database

- **MySQL**

### Deployment & Version Control

- **Git**
- **GitHub**
- **Railway**

---

## 🏗️ Application Architecture

```text
                    ┌─────────────────────┐
                    │      Frontend       │
                    │ HTML / CSS / JS     │
                    └──────────┬──────────┘
                               │
                               │ HTTP Requests
                               ▼
                    ┌─────────────────────┐
                    │    Spring Boot      │
                    │    REST Controller  │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Service Layer    │
                    │ Business Logic      │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │  Repository Layer   │
                    │   Spring Data JPA   │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    MySQL Database   │
                    └─────────────────────┘
