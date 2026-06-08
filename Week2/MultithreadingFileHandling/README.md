# Multithreading File Handling Application

## Description

This project demonstrates Multithreading and File Handling in Java.

The application processes multiple text files simultaneously using separate threads. Each thread reads data from an input file, converts the text to uppercase, writes the processed data to an output file, and logs the processing details.

---

## Features

* Multithreading using Thread and Runnable
* File reading using BufferedReader
* File writing using BufferedWriter
* Processing multiple files simultaneously
* Logging processing results

---

## Project Structure

```text
Assignment1-MultithreadingFileHandling/
│
├── FileProcessor.java
├── FileProcessingTask.java
├── Main.java
├── input1.txt
├── input2.txt
└── README.md
```

---

## How to Run

Compile:

```bash
javac *.java
```

Run:

```bash
java Main
```

---

## Sample Input

input1.txt

```text
hello world
java programming
```

input2.txt

```text
advanced java
buffered reader
```

---

## Output Generated

* output_input1.txt
* output_input2.txt
* processing.log

---



