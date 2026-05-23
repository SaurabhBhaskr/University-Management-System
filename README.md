# University Management System

A Java Swing desktop application for managing basic university operations such as student records, faculty records, leave applications, examination marks, and fee details.

This project was customized for:

- **Developer:** Saurabh Bhaskar
- **Roll Number:** 23CSE77
- **Email:** iamsaurabhbhaskr@gmail.com

## Features

- Login screen with default demo login
- Animated splash screen
- Main dashboard with menu navigation
- Add new student details
- Add new faculty/teacher details
- View student records
- View faculty records
- Update student information
- Update faculty information
- Apply student leave
- Apply faculty leave
- View leave details
- Enter student marks
- View examination results
- View fee structure
- Submit student fee details
- About page with developer information

## Tech Stack

- **Language:** Java
- **UI Framework:** Java Swing
- **Database:** MySQL with local H2 fallback
- **IDE Support:** VS Code and NetBeans
- **Build Tool:** Java compiler / NetBeans Ant project

## Required Libraries

The required JAR files are included in the `lib` folder:

- `mysql-connector-j-8.0.33.jar`
- `jcalendar-1.4.jar`
- `h2-2.2.224.jar`

The original project required `rs2xml.jar`. This repository includes a compatible replacement class:

```text
src/net/proteanit/sql/DbUtils.java
```

## Default Login

Use this login to open the application:

```text
Username: admin
Password: admin
```

## Database Notes

The original project connects to MySQL using:

```text
Database: universitymanagementsystem
Username: root
Password: codeforinterview
```

If MySQL is not available or the password is incorrect, the app automatically falls back to a local H2 database stored in:

```text
data/
```

The local database is created automatically when the app runs.

A MySQL setup script is also included:

```text
database_setup.sql
```

You can import this file into MySQL if you want to use MySQL instead of the local H2 fallback.

## How to Run in VS Code

1. Open the project folder in VS Code.

```text
C:\Users\iamsa\Desktop\University Management System
```

2. Open the terminal in VS Code.

3. Run:

```powershell
java -cp "build\classes;lib\*" university.management.system.Splash
```

You can also use the VS Code **Run and Debug** panel and select:

```text
Run University Management System
```

## How to Compile

Run this command from the project root:

```powershell
$sources = Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName }; javac -cp "lib/*" -d "build/classes" $sources
```

Then copy image resources:

```powershell
Copy-Item -Recurse -Force "src\icons" "build\classes\icons"
```

## Project Structure

```text
University Management System/
├── src/
│   ├── university/management/system/
│   │   ├── Splash.java
│   │   ├── Login.java
│   │   ├── Project.java
│   │   ├── Conn.java
│   │   ├── AddStudent.java
│   │   ├── StudentDetails.java
│   │   ├── UpdateStudent.java
│   │   ├── AddTeacher.java
│   │   ├── TeacherDetails.java
│   │   ├── UpdateTeacher.java
│   │   ├── StudentLeave.java
│   │   ├── TeacherLeave.java
│   │   ├── EnterMarks.java
│   │   ├── ExaminationDetails.java
│   │   ├── FeeStructure.java
│   │   ├── StudentFeeForm.java
│   │   └── About.java
│   ├── net/proteanit/sql/
│   │   └── DbUtils.java
│   └── icons/
├── lib/
├── nbproject/
├── .vscode/
├── database_setup.sql
├── build.xml
└── manifest.mf
```

## Main Screens

- `Splash.java` - animated startup screen
- `Login.java` - login form
- `Project.java` - main dashboard
- `About.java` - developer/project information
- `AddStudent.java` - add student form
- `StudentDetails.java` - view student records
- `AddTeacher.java` - add faculty form
- `TeacherDetails.java` - view faculty records
- `EnterMarks.java` - enter examination marks
- `FeeStructure.java` - view fee details

## Author

**Saurabh Bhaskar**  
Roll Number: **23CSE77**  
Email: **iamsaurabhbhaskr@gmail.com**
