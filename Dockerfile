##### BUILD #####
FROM maven:3.9.6-eclipse-temurin-21 as builder

COPY . .

# RUN executa durante consturção da imagem
RUN ["mvn","clean","install"]


##### RUN #####

FROM openjdk:21-jdk as runner

COPY --from=builder target/*.jar app.jar

# Expondo porta. Isso não dispensa o uso do -p externa:interna na execução
# Isso contribui para clareza e organização do Dockerfile
EXPOSE 4000

# Entrypoint executa como comando principal na execução do container
ENTRYPOINT ["java","-jar","/app.jar"]


##### UTIL #####

# -t para escolher o nome da imagem
# docker build -t . (nome_imagem)

# -it para execução interativa // -d para execução em segundo plano // -p para mapear portas
# docker run -it (nome_imagem) -p (porta_externa):(porta_interna)