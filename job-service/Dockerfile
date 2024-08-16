# Use a Windows Server Core base image
FROM mcr.microsoft.com/windows/servercore:ltsc2022

# Install Java (this example uses an OpenJDK binary; adjust if needed)
RUN powershell -Command ` \
    Invoke-WebRequest -Uri https://download.java.net/java/early_access/jdk21/20/GPL/openjdk-21-ea+20-windows-x64_bin.zip -OutFile openjdk.zip; ` \
    Expand-Archive openjdk.zip -DestinationPath C:\; ` \
    Remove-Item -Force openjdk.zip

# Set JAVA_HOME environment variable
ENV JAVA_HOME C:\jdk-21

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port on which your application will run
EXPOSE 8100

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
