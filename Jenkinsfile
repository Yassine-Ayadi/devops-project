#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    environment {
        DEPLOYMENT_SERVER_IP = "20.23.253.136"
        DEPLOYMENT_SERVER_USER= "jenkins"
        SONARQUBE_SERVER_IP ="137.117.179.6"
        SONARQUBE_SERVER_USER="sonarqube"
        JENKINS_SERVER_IP ="20.23.253.136"
        JENKINS_SERVER_USER="jenkins"
    }
    tools {
        maven 'Maven'
    } 
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("SonarQube Testing and Scan") {
            environment {
                CI = 'true'
                scannerHome = tool 'sonarqube'
            }
            agent{ docker { image 'maven'}  }
              steps {
                script {
                   // sh 'mvn clean install -Dmaven.test.skip=true'
                    gv.sonarScan()
                }
              }
        } 
        stage("Push JAR to Nexus"){
            steps {
                script {
                    gv.pushToNexus()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }

    }


    
}
