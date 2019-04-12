# 개발환경 가이드

프로파일일 local이면 가급적 임베디드 사용

## RDB: H2/MariaDB

profile: `local`인 경우 H2 임베디드 데이터베이스 사용, `dev`인 경우 mariadb 사용

```bash
docker run --name mariadb -d -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=admin \
-e MYSQL_DATABASE=polar \
-e MYSQL_USER=dbuser \
-e MYSQL_PASSWOR=q1w2e3r4 \
mariadb
```

## Redis: Embeded/standalone
