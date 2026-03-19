# SpringBoot-Demo-App

Spring Boot Hello World app with Nginx reverse proxy.

## Run with Nginx

1. Build and start app + Nginx:

```bash
docker compose up --build -d
```

2. Open in browser:

http://localhost/

Expected response:

Hello World!

3. Stop all services:

```bash
docker compose down
```
