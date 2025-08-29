# Desafio Técnico – Modelo 2

✅ Java 11

✅ Spring 2.7.0

### Rodando

1. Clone o projeto: `https://github.com/MurilloMarquesSantos/practical-test2`
1. Entre na pasta `practical-test2` e execute: `mvn spring-boot:run`
1. Acesse: `http://localhost:8080/swagger-ui/index.html`

### Features

✅ Listar todos os comics

✅ Listar todos os super-heróis

✅ Procurar filmes por nomes (Ordem alfabética + páginados)

✅ Todas as chamadas páginadas

✅ Documentação com Swagger (`http://localhost:8080/swagger-ui/index.html`)

✅ Endpoints:
- GET api/books/comics → lista de comics páginados
- GET api/books/superheroes → lista de super heróis páginados
- GET api/books/movies?name= → lista filmes filtrados por nome