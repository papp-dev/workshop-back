FROM eclipse-temurin:21-noble

WORKDIR /app

COPY . /app

EXPOSE 8080

# Fetch project dependencies
RUN chmod +x start.sh && ./gradlew getDependencies

# script which watches source file changes in background and executes bootRun
CMD ["sh", "start.sh"]