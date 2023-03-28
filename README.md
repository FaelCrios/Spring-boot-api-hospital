# SPRING-BOOT-API-HOSPITAL
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/FaelCrios/Spring-boot-api-hospital/blob/master/LICENSE) 

# Sobre o projeto

O projeto se baseia em um sistema de cadastro para médicos e pacientes dentro de um hospital. Sistema feito em Java com Java Spring Boot e visando as boas práticas de
produção de software.


# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- JWT
- Flyway
- Maven

## Implantação em produção
- Banco de dados: MySQL

## Como executar o projeto
 ### Necessário a criação de um banco de dados de preferência no mySQL para a alocação do conteudo gerado.
 
## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório
git clone https://github.com/FaelCrios/Spring-boot-api-hospital

#Gerar o Package do projeto
Através do Maven, basta utiliza a função de lifeCycle de package

## executar o projeto
Será necessário uma conexão com o banco de dados!
E utilizar o comando a seguir
java -Dspring.profiles.active=prod -DDATASOURCE_URL=jdbc:mysql://localhost/vollmed_api -DDATASOURCE_USERNAME=root -DDATASOURCE_PASSWORD=root -jar target/api-0.0.1-SNAPSHOT.jar
```

é possivel acompanhar o conteudo gerado através das URL's de localhost
http://localhost:8080/swagger-ui/index.html
Fornecendo uma visão simplificada dos Métodos HTTP disponíveis no projeto

# Autor

Rafael Colin

https://www.linkedin.com/in/rafael-colin-rios/
