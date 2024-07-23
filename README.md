# JDBC 
***JDBC (Java Database Connectivity) <br> is an API that allows Java applications to interact with various databases. It provides a standard interface for connecting to different Database Management Systems (DBMS) like MySQL, Oracle, PostgreSQL, etc.***
## life cycle
* git connection from the DriverManager with the consturctor of the url, username and password of the database
* preparedStatement from the connection and set the values to Wildcards using setInt(index, value), setLong(index, value), setString(index, value),....

* excute(excuteQuery(), excuteUpdate()) the preparedstatement and return the ResultSet(if it is query "excuteQuery()")
```
    ResultSet -> it is represent the table 
    * it has a pointer to the row previous to the first row
    * it has function (next()) if it hase another row the next() will move this pointer to the next row unitl there are not row in the reslut set(one-directional)
    * get the value from column using get methods like (getString(index), getInt(index),......)
``` 


## logger 
**logger is a tool used for recording log messages that can help developers diagnose issues<br> track application behavior, and maintain logs of application events.**
### Key Classes
* Logger: The core class for logging. It is used to log messages with different severity levels.
* Handler: Handles the output of log messages. Common handlers include ConsoleHandler, FileHandler, and SocketHandler.
* Formatter: Formats the log messages. Common formatters include SimpleFormatter and XMLFormatter.
* Level: Represents the severity of log messages. Levels include SEVERE, WARNING, INFO, CONFIG, FINE, FINER, and FINEST.
```
Logger logger = Logger.getLogger("MyLogger");

logger.setLevel(Level.INFO);
logger.info("This is an info message.");
logger.warning("This is a warning message.");
logger.severe("This is a severe message.");

FileHandler fileHandler = new FileHandler("app.log");
fileHandler.setFormatter(new SimpleFormatter());
logger.addHandler(fileHandler);
```
