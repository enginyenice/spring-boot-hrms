# HRMS
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)



---
## Run

1. Start Docker and new open terminal.
2. Go to the home directory where the project is located.
3. Run Command
```bash
$ cd integration
$ docker compose up -d
```

---

## Applications Info

Applications Info

**Project** 
   1. Swagger Url: `http://localhost:80/swagger-ui.html`

**PostgreSQL**
   1. Port: `5432`
   2. Username: `postgres`
   3. Password: `Password12*`
   4. Database Name: `hrms`

**PgAdmin**:
   1. Url: `http://localhost:8081/`
   2. Email: `admin@enginyenice.com`
   3. Password: `Password12*`
---

### Project Envrimoments:


docker-compose.yml
```
DATABASE_URL: "DATABASE URL"
DATABASE_USERNAME: "DATABASE USERNAME"
DATABASE_PASSWORD: 'DATABASE PASSWORD'
MAIL_HOST: "MAIL SERVER"
MAIL_USER: "MAIL USER"
MAIL_PASSWORD: "MAIL PASSWORD"
MAIL_PORT: "MAIL PORT"
CLOUDINARY_CLOUD_NAME: "CLOUDINARY CLOUD NAME"
CLOUDINARY_API: "CLOUDINARY API KEY"
CLOUDINARY_API_SECRET: "CLOUDINARY API SECRET"
```
