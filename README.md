# flamingo-flight-services
A full stack Flight Booking Portal with Spring-boot, Java as backend , MongoDB as Database and Angular as an Frontend .
Provides basic flight services.
This project is built for learning purpose.

Flamingo Flight Services
------------------
STAGE - 01
------------------

This is the initial stage of project with minimal and essensials features of a flight booking system

Basic Features :
1. Flight Search based on origin, destination and date.
2. Flight Reservation functionality
3. Flight Checkin functionality

******************************************************************************************************************
******************************************************************************************************************

# Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy JAR app to Azure Web App - Flamingo-App-Service

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: windows-latest

    steps:
      - uses: actions/checkout@v4

      - name: Set up Java version
        uses: actions/setup-java@v1
        with:
          java-version: '17'

      - name: Build with Maven
        run: mvn clean install

      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v3
        with:
          name: java-app
          path: '${{ github.workspace }}/target/*.jar'

  deploy:
    runs-on: windows-latest
    needs: build
    environment:
      name: 'production'
      url: ${{ steps.deploy-to-webapp.outputs.webapp-url }}
    
    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v3
        with:
          name: java-app
      
      - name: Deploy to Azure Web App
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v2
        with:
          app-name: 'Flamingo-App-Service'
          slot-name: 'production'
          package: '*.jar'
          publish-profile: ${{ secrets.AzureAppService_PublishProfile_0c3754a81d29407a9299ad33b798563c }}
