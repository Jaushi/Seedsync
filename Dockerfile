FROM maven:3.9.6 AS build

WORKDIR /app

# Copy the mvnw wrapper with executable permissions.
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
COPY pom.xml pom.xml
COPY src/ src/

# Download dependencies and build the application.
RUN mvn package -DskipTests && ls -lh /app/target/

FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copy the built application from the build stage.
COPY --from=build /app/target/myapp-1.0.0.jar app.jar

# Install X11, Xvfb, and other necessary packages for JavaFX.
RUN apt-get update && apt-get install -y \
    openjfx \
    libgl1-mesa-glx \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    xvfb \
    && rm -rf /var/lib/apt/lists/*
    
# Set the display environment variable.
ENV DISPLAY=:99

# Expose the port if needed (not typically needed for JavaFX GUI apps).
EXPOSE 8080

# Start Xvfb and run the application with the headless flag
CMD ["sh", "-c", "Xvfb :99 -screen 0 1024x768x16 & java -Dprism.order=sw -Dprism.verbose=true -Djavafx.headless=true --module-path /usr/share/openjfx/lib --add-modules javafx.controls -jar app.jar"]
