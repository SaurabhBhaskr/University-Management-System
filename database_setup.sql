CREATE DATABASE IF NOT EXISTS universitymanagementsystem;
USE universitymanagementsystem;

CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);

INSERT INTO login (username, password)
VALUES ('admin', 'admin')
ON DUPLICATE KEY UPDATE password = VALUES(password);

CREATE TABLE IF NOT EXISTS student (
    name VARCHAR(100),
    fname VARCHAR(100),
    rollno VARCHAR(30) PRIMARY KEY,
    dob VARCHAR(30),
    address VARCHAR(255),
    phone VARCHAR(30),
    email VARCHAR(100),
    class_x VARCHAR(20),
    class_xii VARCHAR(20),
    aadhar VARCHAR(30),
    course VARCHAR(50),
    branch VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS teacher (
    name VARCHAR(100),
    fname VARCHAR(100),
    empId VARCHAR(30) PRIMARY KEY,
    dob VARCHAR(30),
    address VARCHAR(255),
    phone VARCHAR(30),
    email VARCHAR(100),
    class_x VARCHAR(20),
    class_xii VARCHAR(20),
    aadhar VARCHAR(30),
    education VARCHAR(50),
    department VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS studentleave (
    rollno VARCHAR(30),
    date VARCHAR(30),
    duration VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS teacherleave (
    empId VARCHAR(30),
    date VARCHAR(30),
    duration VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS subject (
    rollno VARCHAR(30),
    semester VARCHAR(30),
    subject1 VARCHAR(100),
    subject2 VARCHAR(100),
    subject3 VARCHAR(100),
    subject4 VARCHAR(100),
    subject5 VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS marks (
    rollno VARCHAR(30),
    semester VARCHAR(30),
    marks1 VARCHAR(20),
    marks2 VARCHAR(20),
    marks3 VARCHAR(20),
    marks4 VARCHAR(20),
    marks5 VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS fee (
    course VARCHAR(50) PRIMARY KEY,
    Semester1 VARCHAR(20),
    Semester2 VARCHAR(20),
    Semester3 VARCHAR(20),
    Semester4 VARCHAR(20),
    Semester5 VARCHAR(20),
    Semester6 VARCHAR(20),
    Semester7 VARCHAR(20),
    Semester8 VARCHAR(20)
);

INSERT INTO fee
    (course, Semester1, Semester2, Semester3, Semester4, Semester5, Semester6, Semester7, Semester8)
VALUES
    ('BTech', '48000', '43000', '43000', '43000', '43000', '43000', '43000', '43000'),
    ('BBA',   '40000', '35000', '35000', '35000', '35000', '35000', '', ''),
    ('BCA',   '35000', '34000', '34000', '34000', '34000', '34000', '', ''),
    ('Bsc',   '25000', '20000', '20000', '20000', '20000', '20000', '', ''),
    ('Msc',   '30000', '25000', '25000', '25000', '', '', '', ''),
    ('MBA',   '65000', '60000', '60000', '60000', '', '', '', ''),
    ('MCA',   '55000', '50000', '50000', '50000', '', '', '', ''),
    ('MCom',  '30000', '30000', '30000', '30000', '', '', '', ''),
    ('MA',    '20000', '20000', '20000', '20000', '', '', '', ''),
    ('BA',    '15000', '15000', '15000', '15000', '15000', '15000', '', '')
ON DUPLICATE KEY UPDATE
    Semester1 = VALUES(Semester1),
    Semester2 = VALUES(Semester2),
    Semester3 = VALUES(Semester3),
    Semester4 = VALUES(Semester4),
    Semester5 = VALUES(Semester5),
    Semester6 = VALUES(Semester6),
    Semester7 = VALUES(Semester7),
    Semester8 = VALUES(Semester8);

CREATE TABLE IF NOT EXISTS collegefee (
    rollno VARCHAR(30),
    course VARCHAR(50),
    branch VARCHAR(100),
    semester VARCHAR(30),
    total VARCHAR(20)
);
