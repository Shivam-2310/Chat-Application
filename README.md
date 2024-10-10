# Chat Application with AI

## Overview

This project is a real-time chat application with an integrated AI bot. It allows users to communicate with each other in real-time and interact with an AI assistant for information or help.

## Features

- Real-time messaging using WebSocket
- User registration with unique usernames
- Public chat room for all users
- Integration with Vishwaguru AI bot
- Distinct message styling for AI responses
- Responsive web design for desktop and mobile use

## Technologies Used

- Frontend: HTML, CSS, JavaScript
- Backend: Java with Spring Boot
- WebSocket: SockJS and STOMP
- AI Integration: Ollama

## Prerequisites

- Java JDK 11 or higher
- Maven
- Ollama setup for AI integration

## Setup and Installation

1. Clone the repository:
   ```
   git clone https://github.com/Shivam-2310/ai-powered-chat-app
   cd chat-application
   ```

2. Install backend dependencies:
   ```
   mvn install
   ```

3. Install frontend dependencies:
   ```
   cd src/main/resources/static
   npm install
   ```

4. Configure Ollama:
   - Ensure Ollama is installed and running on your system
   - Update the `application.properties` file with your Ollama configuration

5. Build the project:
   ```
   mvn clean package
   ```

6. Run the application:
   ```
   java -jar target/chat-application-0.0.1-SNAPSHOT.jar
   ```

## Usage

1. Open a web browser and navigate to `http://localhost:8080`
2. Enter a username to join the chat
3. Start chatting with other users in the public chat room
4. To interact with Vishwaguru AI, start your message with `@vishwaguru`, for example:
   ```
   @Vishwaguru Write about features of Java ?
   ```

## Project Structure

- `src/main/java/com/shivam/chat/`: Java source files
  - `config/`: WebSocket configuration
  - `controller/`: WebSocket event handlers
  - `model/`: Data models
  - `service/`: Business logic and AI integration
- `src/main/resources/static/`: Frontend resources
  - `js/`: JavaScript files for WebSocket handling and UI
  - `css/`: Stylesheets
  - `index.html`: Main HTML file

## Contributing

Contributions to improve the chat application are welcome. Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Make your changes
4. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
5. Push to the branch (`git push origin feature/AmazingFeature`)
6. Open a Pull Request

## Acknowledgments

- Spring Boot for the robust backend framework
- SockJS and STOMP for WebSocket implementation
- Ollama for AI integration capabilities
