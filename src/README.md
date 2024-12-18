# Directory Tree 📂

## 📄 Description
This Java project lists the content of a directory tree starting from a given directory. It provides a detailed recursive exploration of all subdirectories and files, showing their type and last modified date.

### **Functionality**
Core Features:
- Displays a directory tree starting from a specified path.
- Lists:
    - **[D]** for directories.
    - **[F]** for files.
- Shows the last modified date for each item.
- Recursively lists content in alphabetical order within each level.

Robust Design:
- Modular structure:
    - `Utils.java` handles validations and formatting.
    - `DirectoryLister.java` handles the directory listing logic.
- Works seamlessly with or without command-line arguments.

---

## 💻 Technologies Used
- Java 17
- IntelliJ IDEA as the development environment

---

## 📋 Requirements
- Java Development Kit (JDK): Version 17 or higher.
- IDE: IntelliJ IDEA or any Java-compatible IDE.

---

## 🚀 Execution
1. Compile the project:
   ```bash
   javac -d out Main.java DirectoryLister.java auxiliar/Utils.java

2. Run the program, providing the directory path as an argument:
   ```bash
    java -cp out Main /path/to/directory

3. The output will be saved in a `directory_list.txt` file inside the current working directory.


### Without Arguments:
1. Run the program without arguments, and it will prompt you for a directory path:
   ```bash
   java -cp out Main

2. The program will save the directory listing in a file called `directory_list.txt` in the current working directory.


### Example Output:
#### Output in macOS (as tested):
The program generates a file named `directory_list.txt` with the following structure:
- [D] SubFolder (Last Modified: 16-12-2024 11:04:51)
    - [F] file1.txt (Last Modified: 12-12-2024 21:00:10)
    - [F] file2.txt (Last Modified: 12-12-2024 21:00:10)

#### Equivalent output in Windows:
- [D] C:\Temp\SubFolder (Last Modified: 12-12-2024 10:30:45)
    - [F] C:\Temp\SubFolder\File1.txt (Last Modified: 12-12-2024 10:30:45)
    - [F] C:\Temp\File2.txt (Last Modified: 12-12-2024 10:30:45)

---

## 🛠️ Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository-link.git
