FROM eclipse-temurin:17-noble

# Install wget and unzip
RUN apt-get update && apt-get install -y wget unzip

# Install Skeema
RUN wget https://github.com/skeema/skeema/releases/download/v1.10.1/skeema_1.10.1_linux_amd64.tar.gz && \
    tar -xzf skeema_1.10.1_linux_amd64.tar.gz && \
    mv skeema /usr/local/bin/ && \
    rm skeema_1.10.1_linux_amd64.tar.gz

WORKDIR /app

COPY . /app

EXPOSE 8080

# Fetch project dependencies
RUN chmod +x start.sh && ./gradlew getDependencies

# script which watches source file changes in background and executes bootRun
CMD ["sh", "start.sh"]