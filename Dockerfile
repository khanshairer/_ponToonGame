# Base image with OpenJDK (Debian-based so apt-get works)
FROM openjdk:17-slim

# Install required libraries for Swing, X11 rendering, and fonts
RUN apt-get update && apt-get install -y \
    libfreetype6 \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    libxrandr2 \
    libxcursor1 \
    libxinerama1 \
    fonts-dejavu \
    fontconfig \
    libgl1-mesa-glx \
    && rm -rf /var/lib/apt/lists/*

# Set working directory inside the container
WORKDIR /app

# Copy all files from the current folder (Windows host) to the container
COPY . /app/src/

# Compile all Java source files
RUN javac /app/src/*.java -d /app/out

# Set display environment variable for Swing
ENV DISPLAY=:0

# Run the Swing application
CMD ["java", "-cp", "out", "Main"]
