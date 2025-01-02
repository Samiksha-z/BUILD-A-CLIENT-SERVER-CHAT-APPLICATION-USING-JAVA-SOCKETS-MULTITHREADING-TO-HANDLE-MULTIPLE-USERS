# BUILD-A-CLIENT-SERVER-CHAT-APPLICATION-USING-JAVA-SOCKETS-MULTITHREADING-TO-HANDLE-MULTIPLE-USERS



**college**: GSMCOE

**Name**: Samiksha Krishna Kadam

**INTERN ID**: CT12GSC

**DOMAIN**: Java programming

**BATCH DURATION**: December 25th, 2024 to February 25th, 2025.

**MENTOR NAME**: Neela Santhosh Kumar

**ETER DESCRIPTION OF TASK IN 500 WORDS**: Server:

The server acts as a central hub where all clients connect.
It listens for incoming client connections on a specific port.
Upon a successful connection, it assigns a thread to handle the communication with each client.
It broadcasts messages received from one client to all connected clients.
Client:

Each client connects to the server using its IP address and port.
Clients can send messages to the server.
Clients also listen for broadcast messages from the server.
Multithreading:

The server uses a separate thread for each connected client to ensure that all clients can communicate without delays or blocking other clients.
Threads allow simultaneous message handling, enabling real-time interaction.

# OUTPUT OF TASK:  

![chatclient](https://github.com/user-attachments/assets/617f13a7-618b-4107-bfb3-2809540dd51f)
![chatserver](https://github.com/user-attachments/assets/472a930f-874a-4b69-8454-7cd7a793556f)

