# Directory Tree 📂

## 📄 Description
This Java project lists the content of a directory tree starting from a given directory. It provides a detailed recursive exploration of all subdirectories and files, showing their type and last modified date.

### **Functionality**
Core Features:
- Creates the `test path` directory at the specified location if it doesn't exist.
- Creates the `sample.txt` file and `subfolder` inside the `test path` directory.
- Lists the directory tree recursively and saves the output to a file.
- Displays directory structure, indicating:
    - **[D]** for directories.
    - **[F]** for files.
- Shows the last modified date for each item.
- Saves the directory listing in the specified output directory as `directory_list.txt`.

Modular Design:
- `Utils.java`: Handles validations, file handling, and path creation.
- `DirectoryLister.java`: Manages the directory listing process.
- Handles both directory paths and TXT file inputs.

---

## 💻 Technologies Used
- Java 17
- IntelliJ IDEA or any compatible Java IDE

---

## 📋 Requirements
- Java Development Kit (JDK): Version 17 or higher.
- IDE: IntelliJ IDEA or any Java-compatible IDE.

---

## 🚀 Execution
1. Compile the project:
   ```bash
   javac -d out -cp src src/*.java

2. Run the program, providing the path to a directory as an argument:
   ```bash
java -cp out Main


## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/eze-ms/Java-Utils-N2-E1