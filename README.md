### Pré-Requisitos

Docker CLI.

### UTIL

- `docker ps` - Lista somente containers ativos
- `docker ps -a` - Lista todos os containers. Aqui é possivel obter o id de um container
- `docker rm (ID_CONTAINER)` - Deleta um container
- `docker rm $(docker ps -aq)` - Deleta todos os containers. Parametro `-aq` lista todos os ids de containers, ativos ou não
- `docker run -it (NOME_IMAGEM)` - Cria um container a partir de uma imagem. Parametro `-it` para iniciar de maneira interativa e `-d` para iniciar em segundo plano
- `docker stop (ID_CONTAINER)` - Interrompe execução de um container
- `docker start (ID_CONTAINER)` - Inicia um container
