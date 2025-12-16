# S3 File Upload & Download API

A simple REST API built with **Spring Boot** that allows uploading and downloading files to/from **Amazon S3**.

This project demonstrates how to integrate AWS S3 with a Java backend application using the AWS SDK.

---

## Features

- Upload files to Amazon S3
- Download files from Amazon S3
- Configurable S3 bucket and region
- Supports large files (stream-based upload/download) (Work in progress)
- Clean REST endpoints

---

## Tech Stack

- Java 17+
- Spring Boot
- AWS SDK for Java (S3)
- Maven
- Amazon S3

---

## Prerequisites

Before running the application, ensure you have:

- Java 17 or higher
- Maven 3.x
- AWS Account
- An existing S3 bucket
- AWS credentials with S3 access

---

## AWS Configuration

### 1. Create an S3 Bucket
Create an S3 bucket in your AWS account (via AWS Console or CLI).

### 2. Configure AWS Credentials

You can configure AWS credentials either using environment variables or application.properties :
