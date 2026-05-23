package university.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "codeforinterview");
            s = c.createStatement();
        } catch (Exception e) {
            connectLocalDatabase(e);
        }
    }

    private void connectLocalDatabase(Exception mysqlException) {
        try {
            Class.forName("org.h2.Driver");
            c = DriverManager.getConnection(
                    "jdbc:h2:./data/universitymanagementsystem;MODE=MySQL;DATABASE_TO_LOWER=TRUE",
                    "sa",
                    ""
            );
            s = c.createStatement();
            initializeLocalDatabase();
        } catch (Exception h2Exception) {
            mysqlException.printStackTrace();
            h2Exception.printStackTrace();
        }
    }

    private void initializeLocalDatabase() throws SQLException {
        s.executeUpdate("create table if not exists login (username varchar(50) primary key, password varchar(100) not null)");
        s.executeUpdate("merge into login key(username) values ('admin', 'admin')");

        s.executeUpdate("create table if not exists student (name varchar(100), fname varchar(100), rollno varchar(30) primary key, dob varchar(30), address varchar(255), phone varchar(30), email varchar(100), class_x varchar(20), class_xii varchar(20), aadhar varchar(30), course varchar(50), branch varchar(100))");
        s.executeUpdate("create table if not exists teacher (name varchar(100), fname varchar(100), empId varchar(30) primary key, dob varchar(30), address varchar(255), phone varchar(30), email varchar(100), class_x varchar(20), class_xii varchar(20), aadhar varchar(30), education varchar(50), department varchar(100))");
        s.executeUpdate("create table if not exists studentleave (rollno varchar(30), date varchar(30), duration varchar(30))");
        s.executeUpdate("create table if not exists teacherleave (empId varchar(30), date varchar(30), duration varchar(30))");
        s.executeUpdate("create table if not exists subject (rollno varchar(30), semester varchar(30), subject1 varchar(100), subject2 varchar(100), subject3 varchar(100), subject4 varchar(100), subject5 varchar(100))");
        s.executeUpdate("create table if not exists marks (rollno varchar(30), semester varchar(30), marks1 varchar(20), marks2 varchar(20), marks3 varchar(20), marks4 varchar(20), marks5 varchar(20))");
        s.executeUpdate("create table if not exists fee (course varchar(50) primary key, Semester1 varchar(20), Semester2 varchar(20), Semester3 varchar(20), Semester4 varchar(20), Semester5 varchar(20), Semester6 varchar(20), Semester7 varchar(20), Semester8 varchar(20))");
        s.executeUpdate("create table if not exists collegefee (rollno varchar(30), course varchar(50), branch varchar(100), semester varchar(30), total varchar(20))");

        s.executeUpdate("merge into fee key(course) values ('BTech', '48000', '43000', '43000', '43000', '43000', '43000', '43000', '43000')");
        s.executeUpdate("merge into fee key(course) values ('BBA', '40000', '35000', '35000', '35000', '35000', '35000', '', '')");
        s.executeUpdate("merge into fee key(course) values ('BCA', '35000', '34000', '34000', '34000', '34000', '34000', '', '')");
        s.executeUpdate("merge into fee key(course) values ('Bsc', '25000', '20000', '20000', '20000', '20000', '20000', '', '')");
        s.executeUpdate("merge into fee key(course) values ('Msc', '30000', '25000', '25000', '25000', '', '', '', '')");
        s.executeUpdate("merge into fee key(course) values ('MBA', '65000', '60000', '60000', '60000', '', '', '', '')");
        s.executeUpdate("merge into fee key(course) values ('MCA', '55000', '50000', '50000', '50000', '', '', '', '')");
        s.executeUpdate("merge into fee key(course) values ('MCom', '30000', '30000', '30000', '30000', '', '', '', '')");
        s.executeUpdate("merge into fee key(course) values ('MA', '20000', '20000', '20000', '20000', '', '', '', '')");
        s.executeUpdate("merge into fee key(course) values ('BA', '15000', '15000', '15000', '15000', '15000', '15000', '', '')");
    }
}
