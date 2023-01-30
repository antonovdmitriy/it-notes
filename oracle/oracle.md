# Table of contents

- [Table of contents](#table-of-contents)
- [Useful links](#useful-links)
- [Usefual commands](#usefual-commands)
- [Relational db foundation](#relational-db-foundation)
  - [Tables](#tables)
- [Data types](#data-types)
  - [NUMBER](#number)
  - [DATE](#date)
  - [CHAR](#char)
  - [VARCHAR 2](#varchar-2)
- [Contraints](#contraints)
  - [Check constraint example](#check-constraint-example)
- [Create table model (ERD)](#create-table-model-erd)
  - [Anylize of model](#anylize-of-model)
  - [Example of analysis](#example-of-analysis)
  - [NULL values](#null-values)
  - [Create table in Oracle Data Modeller](#create-table-in-oracle-data-modeller)
  - [Primary key. Natural and surrogate keys.](#primary-key-natural-and-surrogate-keys)
  - [Relationships in ERD](#relationships-in-erd)
    - [One-to-one](#one-to-one)
    - [One-to-many](#one-to-many)
    - [Many-to-many](#many-to-many)
    - [Foreign ключи](#foreign-ключи)
- [Normalization](#normalization)
  - [Process of normalization](#process-of-normalization)
  - [Pros vs cons](#pros-vs-cons)
  - [1NF (First normal form - Entity atomicity)](#1nf-first-normal-form---entity-atomicity)
  - [Second normal form (dependency columns from primary key)](#second-normal-form-dependency-columns-from-primary-key)
  - [Third normal form (columns depend only on the primary key, but not on others)](#third-normal-form-columns-depend-only-on-the-primary-key-but-not-on-others)
- [What is inside the Oracle](#what-is-inside-the-oracle)
  - [Oracle Database Instance](#oracle-database-instance)
    - [SGA](#sga)
      - [Database Buffer Cache](#database-buffer-cache)
      - [Shared Pool](#shared-pool)
    - [Oracle Database Instance background processes](#oracle-database-instance-background-processes)
  - [Analyzing an Existing Oracle Instance](#analyzing-an-existing-oracle-instance)
    - [Database Location](#database-location)
    - [How to know ORACLE\_SID](#how-to-know-oracle_sid)
    - [Important files](#important-files)
    - [Is Listener started](#is-listener-started)
- [Oracle instalation](#oracle-instalation)
  - [Installation Features](#installation-features)
  - [Environment variables](#environment-variables)
  - [Installer](#installer)
- [Install Oracle on Linux with x forwarding](#install-oracle-on-linux-with-x-forwarding)
- [Uninstall Oracle](#uninstall-oracle)
- [OFA Oracle Flexible Architecture](#ofa-oracle-flexible-architecture)
- [Resource planning](#resource-planning)
  - [DBCA (Oracle Database Configuration Assistant)](#dbca-oracle-database-configuration-assistant)
  - [Capasity Planning](#capasity-planning)
  - [OLTP or OLAP and RAC](#oltp-or-olap-and-rac)
  - [Physical Storage Requirements](#physical-storage-requirements)
  - [Database Memory requirements](#database-memory-requirements)
    - [Recomendations to start](#recomendations-to-start)
    - [Aproaches to setting memory](#aproaches-to-setting-memory)
    - [Advisor](#advisor)
    - [Tuning memory areas in SGA](#tuning-memory-areas-in-sga)
- [Connect to the Oracle](#connect-to-the-oracle)
  - [Oracle Net Stack](#oracle-net-stack)
  - [Service name](#service-name)
  - [Connection string](#connection-string)
- [User accounts](#user-accounts)
  - [How to query objects in different user schema](#how-to-query-objects-in-different-user-schema)
  - [Create Oracle User](#create-oracle-user)
  - [User privileges](#user-privileges)
  - [User Profiles](#user-profiles)
  - [Delete user and all his objects](#delete-user-and-all-his-objects)
  - [Change user attributes](#change-user-attributes)
  - [Create dba user , connect and create table](#create-dba-user--connect-and-create-table)
  - [Userul grants](#userul-grants)
- [Oracle data dictionary](#oracle-data-dictionary)
  - [Scope to what is seen in the dictionary view](#scope-to-what-is-seen-in-the-dictionary-view)
  - [Useful views](#useful-views)
- [Transactions](#transactions)
  - [Decription](#decription)
  - [ACID](#acid)
  - [How does Oracle support ACID](#how-does-oracle-support-acid)
  - [Read Consistency Model](#read-consistency-model)
    - [Undo segment](#undo-segment)
    - [Database timing (SCN)](#database-timing-scn)
    - [Example Read Consistency](#example-read-consistency)
    - [What if Oracle can't find the row in the Undo tablespace?](#what-if-oracle-cant-find-the-row-in-the-undo-tablespace)
  - [Oracle Locking](#oracle-locking)
    - [Example locking](#example-locking)
- [Control files](#control-files)
  - [Description](#description)
  - [Oracle instance starting stages](#oracle-instance-starting-stages)
  - [Creating the Control File](#creating-the-control-file)
  - [Adding a control file](#adding-a-control-file)
  - [Moving a control file](#moving-a-control-file)
  - [Removing a control file](#removing-a-control-file)
  - [Show control file path](#show-control-file-path)
  - [Control file data dictionary view](#control-file-data-dictionary-view)
- [Redo logs](#redo-logs)
  - [Redo Logs and Performance](#redo-logs-and-performance)
  - [Infications of Performance issues](#infications-of-performance-issues)
  - [Redo Log Administration](#redo-log-administration)


# Useful links

[Virtual Machine for Virtual Box  with Oracle 19](https://www.google.com/url?q=https://www.oracle.com/database/technologies/databaseappdev-vm.html&sa=D&source=editors&ust=1674949804304876&usg=AOvVaw2iaL0hD0EL7hZUdHVdkFIf)

# Usefual commands

Show table or view description
```sql
desc table_name 
```

![](images/image46.png)

Current user name
```sql
show user
```
![](images/image192.png)


# Relational db foundation

What is a relational database?
- A collection of "things" (entities)
- Tables provide a way of storing information about entities
- Rows indicate a unique entity
- Columns describ attributes related to an antity

![](images/image2.png)

- Provides a way to define rules that exist for the entities (tables) and their attributes (columns) we are storing in database (constraints)
- Provides a way of defining how different things are related (foreign keys)
  
![](images/image76.png)

## Tables
Data is organized into tables.
- Each table has rows and columns
- One or more columns in each row makes that row unique. This is known as the tables's `primary key`
- The general convention when naming a table is to use the singular form (driver vs. drivers)
- Another general convention is to upper case the table name as well as the names of all of the columns
- The primary key is always unique
- A column can be empty (NULL)
- The data in the table in not sorted
  
![](images/image7.png)

![](images/image45.png)

# Data types

## NUMBER

- Non-integer datatype used to store positive, negative numbers with a default precision of up to 38 digits total
- Optionally define precision and scale when defining a number
  - Precision and scale provide additional integrity checking
  - Precision - up to 38 digits
    - For example, precision of 4 is 1234. Precision of 6 is 123456
  - Scale - Number of digits after the decimal point. Part of the total precision
    - For example, precisition of 4 and scale of 2 is `12.35`. `1234.56` would cause an error.

![](images/image93.png)

## DATE

- Integrity checking on stored dates. No invalid leap years or 09/31/2015 dates will be stored in your database
- A single data type can store a date/time that can be displayed using any number of formats.
    - `01-JAN-2015 01:00:00`
    - `01/01/2015`
    - `1/1/2015 21:30:00`
    - `1/1/15 09:30:00`
- Support is provided for
  - Daylight savings
  - Different time zone offsets
  - Date/Time arithmetic. For example: `1/31/2015 - 1/1/2015 = 30 days`

## CHAR 
- Fixed length storage of character values
- `CHAR` data type can stope up to 2000 bytes of character data
- `CHAR(10)` can store up to 10 characters. However each entry will require the same amount of storage (generally 10 bytes for a `CHAR(10) but there are exceptions) for any of these values
  - CAR
  - CART
  - CARTWHEELS
- A lot of wasted space 

## VARCHAR 2

- Variable length storate of character values
- In Oracle Database 12c a VARCHAR2 can store either:
  - 4000 characters by default
  - 32737 characters if extended data types are enabled
- There is no overhead for a `VARCHAR2`. An emptry `VARCHAR2` data type consumes no storage
- Generally you should use `VARCHAR2` datatypes instead of `CHAR`

# Contraints

Relational database constraints:
- Datatypes
- Check (check business rules while inserting data)
- Primary key. Created index for this.
- Unique (differ from primary key in that it can be null value in the column). Created index for this.
- Foreign key

## Check constraint example

- Create table and show it
```sql
create table demo_table
(
    primary_row_id      number      primary key,
    date_row_created    date,
    some_comment        varchar2(30)
);

desc demo_table
```
![](images/image193.png)


- Add check constraint to check date after than 1900 year
```sql
alter table demo_table add constraint ck_not_to_old check (date_row_created > to_date('01-01-1900', 'mm/dd/yyyy'));
```

![](images/image10.png)

- try to insert wrong row

```sql
insert into demo_table values (1, to_date('01-01-1800', 'mm/dd/yyyy'), 'test2');
```
![](images/image19.png)

# Create table model (ERD)

## Anylize of model 

- Before we actually create a model, we need to perform some analysis and understand the data we are modeling
- Generally this is done with various stakeholders - people who understand the business, developers, managers who understand the data you are modeling and how it will be used
- This process is an iterative process and can take some time
- The model will start taking form as this analysis is done

The Entity Relationship (ER) Diagram (ERD)
- The ERD is a "picture" of the physical model of the database
- When you model a database you will do so by creating an ER diagram for the database

ERD provides details on
- individual tables, columns and column definitions
- Constraint definitions
- Relationships between tables

## Example of analysis

- Create in Oracle Data Modeller first table and called it PERSON (not PEOPLE)
- Oracle support lower or mixed case, but uppercase is the accepted standart

- The column and its name should represent a single atomic data element stored in the column. Don't combine city, state and zip code in one column.
- Carefully consider data type and lengths. Don't store dates in VARCHAR2 for example.
- Understand the business rules related to the table columns. These translate into column constraints. 
  - Valid language related characters
  - Standardized formats (Upper case?)
  - Valid data range (minimum or maximum data ranges?)
  - Security (Encryption/PCI?)

Our example:
- `LAST_NAME` and `FIRST_NAME`
  - Init-capped name is required
  - Required in each record
  - `VARCHAR2(30)`
- `MIDDLE_NAME`
  - The business rule calls for it to be a single capitalized initial
  - The middle name is optional
  - we will rename the column to `MIDDLE_INITIAL` to more properly describe the data it contains
  - `VARCHAR2(1)`
- `BIRTH_DATE`
  - Entered can not be over 100 years ago
- `SSN`
  - Unique
  - will not be stored with dashes or any other kind of delimiter
  - Each SSN must be 9 characters in length
  - No mathematical calculations on SSN's will be needed
- `ZIP_CODE`
  - We will change the name of the `POSTAL_CODE`
  - Because the `POSTAL_CODE` in many countries is not always numeric, we will make the `POSTAL_CODE` column a varchar2(10) column

##  NULL values

- NULL usuallly represents an unknown or undetermined state
- When designing tables you need to consider if a column should be allowed to be NULL or not. 
- If the column MUST contain data then it should be defined as `NOT NULL`
- If the column MIGHT contain data then it should not be defined as `NOT NULL`
- In cases where the business rules do not require the column to contain data then it should not be defined as `NOT NULL`
- By default, a column in a table can contain NULL values
- Make a column `NOT NULL` when you create the table or you can alter an existing column to be NOT NULL as long as it does not contain any NULL values
- A column that is going to be part of a primary key (for example SSN) is always going to be `NOT NULL`
  
  You can define columns as `NOT NULL` or `NULL` when:
    - You initially create a table
    - You use the `alter table` command to modify the column
    - Add a column to a table with the `alter table` command

## Create table in Oracle Data Modeller

![](images/image79.png)

- ERD in Oracle Data Modeller

![](images/image214.png)

## Primary key. Natural and surrogate keys.

![](images/image172.png)

- in our `PERSON` table we used the SSN in the row to identify each row uniquely
- In reality the SSN is what is known as a surrogate key
  - It is a number generated by the government that is supposed to be unique for each person
  - However, there is nothing about the number that forses it to be unique
- If we had a way to store the entire DNA of a person then that wouild represent a natual key
  - A natural key is a column or combination of columns that uniquely identifies a row in a natural way
  - For example, latitude and longtitude might be sufficient to uniquely identify a given building in a table that contains building information.

## Relationships in ERD

### One-to-one

- One record in table A will have zero or one record in table B
- One record in table B **must** have one record in table A


![](images/image171.png)

### One-to-many

- One record in the A table must have one record in the B table
- One record in the B table will have zero, one or many records in A table

![](images/image33.png)

### Many-to-many

- One record in table A will have zero, one or many records in table B
- One record in table B must have one or more records in table A

![](images/image73.png)

![](images/image29.png)

This shows that if we enter an entry in the departments, then 0 or more employee objects can refer to it. But when entering an employee in the table of employees, there must be one or more records in the departments.

In such cases, a associative table is often introduced

![](images/image153.png)

### Foreign ключи

![](images/image14.png)

If we insert an employee with a department that is not in the department table, then there will be an insert error

Relationsips are enforced through the definition of foreign keky constraints

FK constraints are defined during or after the creation of the table

FK contraintes are defined on the child table referencing the column of the parent table


# Normalization

## Process of normalization

- Normalizing a database model typically involves developing the model so that it is in what is called third mormal form (3NF)
- Normalizing a database model is a progressive process starting with first normal form and progressing from there (1NF, 2NF, 3NF)
- Each level of normalization requires the completion of the previous level of normalization
  
## Pros vs cons
Benefits of normalization:
- Reduction in overall logical and physical IO
- Reduction in data duplication/redundancy
- Data anomalies related to data modification less likely to occur
- Reduction in overall storage required
- Indexes tend to be smaller and therefore provide faster access

Negatives of normalization:
- A 3NF model can require more joins in a SQL statement making the SQL statement longer and potentially more complex
- In some rare cases a de-normalized table can perform better. More often than not in cases like this some basic SQL tuning - rather than de-normalizing the model - is the best solution.

## 1NF (First normal form - Entity atomicity)

- Data stored in each column of the table is "atomic" in value
- If a table has more than one entities information in it you separate that information into individual tables for each entity

Example: 
- Let's look at this table
  
![](images/image169.png)

- Here you can see that the phone is included in its entirety. But inside the phone there is an area code that will be repeated in many phone numbers. There is always a dilemma how deep to split the data. Here you need to look at the business requirements. If it is possible to imagine a case where the data is needed for analysis, the data should be normalized. In this case, create a separate field for the  country code. This creates the 1st normal form. Each column should reflect a separate property (attribute) of the entity.

![](images/image137.png)

- 1NF also prohibits repeating groups. 
- What if we wanted to have more than one phone number in our table?
- If we add more phone number like this, we violate 1NF because adding another phone number would create a repeating group
  
![](images/image32.png)

- To avoid this problem we will break the phone number information into its own table
  - Note that we also created a SSN column in the new PHONE table. This maintains the relationship between the person and their phone number
  - The combination of the SSN and the PNONE_TYPE are the pK of the PHONE table

![](images/image139.png)
  

## Second normal form (dependency columns from primary key)

- In 2NF all non-key columns must depends on the whole primary key to uniquely identify them
- The non-key columns must depend on the entire primary key in the case of a multiple column primary key
- As we did our analysis we discovered that a person might have certifications we want to track

Example:
- to track these we added certification table
- To track who they were certified by we added the certifier table

![](images/image173.png)

- Check if all columns depend on the primary key. This is a test for the second normalized form. There are problems here. In tables with `co_code` certification is part of the primary key. A person cannot have several certificates issued by one company.
- The company URL is independent of all primary key fields. It is logical to move it to the cert_company table.

![](images/image100.png)

![](images/image126.png)

## Third normal form (columns depend only on the primary key, but not on others)

- Moving data that is not solely dependent on a tables primary key into its own table
- If a column could change in a table because of a change to any non-primary key column in that table then that is a violation of 3NF. This is called a transient dependency
- Columns should only depend on the primary key. If, when changing one column, we must edit others, then we have a transitive dependency.

Example:
- The `PHONE_TYPE_DESC` column is not dependenent on the entire primary of `PHONE`
- It is only dependent on the `PHONE_TYPE` column
- Because of this we need to create another table to deal with `PHONE_TYPE`

![](images/image70.png)

# What is inside the Oracle 

- Oracle Database is a Relational Database Management System (RDBMS)
- There are two main parts to an Oracle Database
  - the Oracle Database instance
  - The Oracle database

## Oracle Database Instance

- Oracle database instance is a program - an operating system process that allows the database to work.
- Consisted of Processes/Threads/Services
- Instance is identified by its unique SID. 
- To connect to the Oracle database we have to know what `SID` we want to connect to

### SGA  
- Memory - Called the `SGA` (System Global Area) - memory area allocated at the start of the instance.
- The `SGA` is subdevided into smaller pools of memory
  -  Shared Pool
  -  Database Buffer Cache
  -  Relo Log Buffer
- The larger the SGA, the longer the objects are stored in memory. This greatly affects performance. If the data is not in the Buffer Cache, loading it there is expensive and time consuming.


![](images/image47.png)


#### Database Buffer Cache

- Dynamic storage of database data
- Data moves from disk to memory and back to disk
- Individual blocks of memory of the same size
- Size o the memory buffers is based on the DB block size
- DB Block size is defined when the database is created
- The size of blocks in RAM is the same as on disk.
- In Buffer Cache, client processes put data from disk.
- From Buffer Cache writes to disk process DBWR (Database Writer)

![](images/image175.png)

#### Shared Pool 

consists of several memory areas:
- **Shared SQL Area**. Responsible for executing SQL statements. When a client process starts sql Oracle puts this statement in the shared sql area. When an expression is no longer called frequently, Oracle removes it from the Shared SQL Area
- **Data Dictionary Cache**. Oracle system tables are loaded here

![](images/image135.png)

### Oracle Database Instance background processes

- Over 46 Linux processes in Oracle Database 12c when it's just idle, doing nothing
- Each of them has its own `PGA` memory area.
- If the base is loaded then there are much more processes.

The most important from them:
- **ARCH** - Archive Process
- **CKPT** - Checkpoint Process
- **DBWn** - Database Writer Process
- **LGWR** - Log Writer Process
- **PMON** - Process Monitor Process
- **SMON** - System Monitor Process 
- **Client Processes**
---

- If one of the 6 processes stops, it will most likely crash the database
- Client processes are created when a client session is opened.

## Analyzing an Existing Oracle Instance

### Database Location

- It is important to be able to look at the `ORACLE_HOME` environment variable in order to understand where the database is installed on the server.
- However, in the virtual machine examples from Oracle, the base can be installed here `/u01/app/oracle/product/version/db_1`

![](images/image9.png)

Важные файлы тут в каталоге `dbs`

![](images/image91.png)


### How to know ORACLE_SID

```
env | grep ORACLE_SID
```
![](images/image99.png)

All SIDs have a file ending with cdb. It is managed by oracle, but it can be opened and partially read by cat.
![](images/image66.png)

### Important files

- Instance and database parameter settings are set in the database parameter file
- The database parameter file is required to start the instance and then open the database
- Two kind of parameter files:
  - **SPFILE** - Automatically maintained by Oracle
  - **init.ora** - Manually managed parameter file. For example, the size of SGA.

### Is Listener started

```
lsnrctl status
```
![](images/image95.png)


# Oracle instalation

## Installation Features

- When allocating RAM, more attention is paid to memory for the database (SGA), but not for the memory of Oracle processes (PGA), which can significantly affect its operation.
- When allocating processor time, they devote most of the work to Oracle processes, but forget to leave a margin for client processes
- It is recommended that you allocate at least 4 times the amount of disk space plus 25 percent after determining future needs. 3 for the three versions of Oracle that can be shipped. 1 for a large patch, because the patch often takes the same as the oracle distribution and 25 percent for the logs of small patches
- It is not recommended to install Oracle on the root filesystem. There must be a separate partition and you cannot add oracle files to the root system, so that in any case the server does not crash. If Oracle fills up all the memory.

## Environment variables

- `ORACLE_BASE` directory where all software from oracle is installed. For example `/u01/app/oracle`

![](images/image142.png)

- `ORACLE_HOME` - directory where Oracle Database is installed. According to the OMF standard, it is located inside `ORACLE_BASE`
For example `$ORACLE_BASE/product/12.1.0.2`  `$ORACLE_BASE/product/11.2.0.3`

![](images/image57.png)

## Installer

- After downloading the file, you need to unzip the archives into a single folder under the root user

![](images/image25.png)

- See `runInstaller` script
- Give access rights for oracle user 

![](images/image13.png)

- Launch `runinstaller`

# Install Oracle on Linux with x forwarding

Via GUI with X11 forwarding

1. See X11 forwarding setup description in the Linux document [Linux Document](../linux/linux.md)
2. Install packages

  ```bash
  sudo yum install xdpyinfo
  sudo yum install xorg-x11-utils
  ```

3. Give permission to run to the user. It must not be root otherwise the installer will not start
```
sudo chown -R vagrant:vagrant *
sudo chown vagrant:vagrant ./oracle_distr/
```

3.  Export environment variable 
  
```bash
export CV_ASSUME_DISTID=OEL8.1
```

4.  Run installer

![](images/image184.png)

# Uninstall Oracle

In directory `$ORACLE_HOME/deinstall` there is a file  `deinstall`

![](images/image64.png)

# OFA Oracle Flexible Architecture

For database file placement the DBCA will use the Oracle Flexible Architecture (OFA) standart by default. OFA provides a standart that allows you to:
- Locate more than on set of Oracle Database software on a given server. Several databases.
- Standardized placement of database related files on the database server

Base file systems:
- `/u01` - Oracle software
- `/u02` - Oracle Diagnostic files
- `/u03` - Oracle files
- `/u04` - Oracle files

# Resource planning

Tasks to accomplish before you start creating an Oracle database:
- Understand the Oracle Database Configuration Assistant (DBCA) 
- Perform capacity planning
- Determine which databse options that will be required
- Determine your physical storage requirements
- Determine the database memory requirements

## DBCA (Oracle Database Configuration Assistant)

Database configuration assistance - a tool for creating a database. (not installation)

Most Oracle databases will be created using the DBCA. The DBCA will interview you asking questions about how you want to configure your database. It will then create the database for you. The DBCA will prompt you for information that we need to collect before we start creating the database. 

When using DBCA Oracle will create the directories and database files so that they adhere to OFA standards 

## Capasity Planning

- Database capacity planning is the process of determining the production capacity needed by your database to meet both current and future demands for it's services
- Design capacity is the maximum amount of work that a database can complete in a given period

Things that influence capacity planning:
- CPU's
  - Speed
  - Quantity
  - Type
- Memory
- Storage
- Network
- Location/power/colling/etc
- Support/Spare avaliability
- Refresh schedule
- The application 

More things that influence capacity planning:
- Concurrency
- Growth/Change
- Service Level Agreement (SLA) with respect to
  - Performance
  - Backup and revovery requirements
  - High Availability requirements

Considerations when you are capacity planning:
- Number of databases you wish to run on the hardware
- Database options you want to support (ie Parallel Query)
- How representative of reality is the workload in your testing?

Additional capacity considerations:
- Type of database (OLTP, Data Warehouse, hybrid)
  - Nature of queries/transactions that will be run
  - Distribution of query types
  - Physical and logical database design requirements
- Third party tools to be used
- Security schema to be used

## OLTP or OLAP and RAC

- **OLTP** (online transaction processing) - normalized model. Application database.
- **OLAP** (Data Warehouse) - online analytic processing. Usually unnormalized data. Layer over different sources, including OLAP. Used to run analytical reports.
- **RAC**  Real Application Clusters. For high availablility

## Physical Storage Requirements
The database consists of different kinds of physical files:
- Database files
- Control files
- Redo log files
- Archived redo log files

The DBCA will ask you where you want to place these files and how big you want them

## Database Memory requirements

Although there are recommendations to set no more than 60 percent of the server's memory, this is a rather arbitrary figure. So, if the server hosts a 500 MB database, allocating even 1 GB of RAM for it is an unnecessary allocation. Also, if the base is 200 GB, allocating 1 TB of memory is a lot. 

The memory depends on the activity of using the base - a more loaded base will require a larger SGA to perform a given performance. 

The size of the memory depends on the requirements for the response time (response time), if the response should be minimal, you can generally take all the data from memory, it will be faster than our ssd drives.

Memory areas you will need to plan for include
- **SGA**
  - Buffer Cache
  - Shared Pool
- **PGA (Private Global Area)**. Each user session allocates memory to this area. Not only user, but also Oracle processes. The memory size is set depending on the expected number of user sessions for the database) 

### Recomendations to start

- Determine the refresh cycle of your database hardware (for example 3 years)
- Determine how big you expect your database to be at the end of that refresh cycle
- Size the SGA to about 20% of that value

Example - 3 years refresh cycle
- Initial database size 100 GB
- Growth year 1 - 10 GB
- Growth year 2 - 100 GB
- Growth year 3 - 300 GB
- Total size year three - 510 GB
- SGA recommended size (10% to 20%) 50 to 100 GB

To start I typically add 100 to 200 MB to the `bufer cache size` to allow for sizing of the shared pool.

### Aproaches to setting memory

There are two approaches (paradigms) for setting memory:

- **AMM** - then edit the `MEMORY_TARGET` setting. 
  - In this case, oracle automatically sets the size of SGA and PGA and can change this size between these areas as needed at runtime, reallocating memory.
- **ASMM** - then edit the `SGA_TARGET` setting.
    - This setting automatically changes only the `SGA`. `PGA` is not redistributed.In this case use `PGA_AGGRIGATE_TARGET` is a target value for PGA, but not strict, the base will tend to use it.

If running on Linux, then recommend using ASMM and also using Linxu hugepages

### Advisor

- Oracle provides an Advisor framework to monitor the use of the SGA and PGA
- The Advisors provide information that you can use to increase or decrease the SGA and the PGA to make the best use of those memory resources

![](images/image185.png)

### Tuning memory areas in SGA

You can also configure memory settings for areas inside SGAs. 

This sets the minimum memory value for §shared_pool§ inside the SGA. It can be increased, but cannot be less than this figure

```sql
alter system set shared_pool_size=100m scope=spfile; 
```

# Connect to the Oracle

## Oracle Net Stack
Oracle provides it's own networking layer called the Oracle Net Stack.

The Oracle Net Stack fits into level 5 (session layer) of the OCI model

It's the job of Oracle Net to provide:
- Communications with the transport layer (TCP/IP) that your network is using
- Facilitate connectivity between the client and the database server and the services it provides

## Service name

Service names provide a way of abstracting the database from the clients attached to it

## Connection string

To connect to a database we use a database connection string. The most common are:
1. **TNS Connection String**
   
    ```
    login/password@serivice_name
    ```

2. **Easy connect naming**
   
   ```
   login/password//host:port/service_name
   ```



# User accounts

When you connect to an Oracle database you will connect to an Oracle database user account

A database account is associated with a database schema. User account has own schema. 

During database creation a default administrative account is created. This account is called **SYS**.
- Special administrative account
- Should only use in rare cases
- Used for things like upgrades, creating admin users
- Don't use on a regular basis

User accounts can own objects such as tables and indexes. Or they may own nothing at all and just provide a way to access the database.

Each user account has specific privileges called **grants** that are assigned to it. The DBA assigns these privileges. Grants can also be revoked or modified.

It can be possible to assign grant to access to objects in different schemes (users)

## How to query objects in different user schema

- View users if logged in as system user in Sql Developer

![](images/image204.png)

- By default, oracle has a test user **scott**

![](images/image160.png)

- Query from user system to user scott's table. The tables are created by scott and are in his schema. That is, if you try to specify a table without a schema, we will not find

```sql
select * from sample_dataset_intro
```
![](images/image67.png)

- correct command

```sql
select * from scott.sample_dataset_intro
```

![](images/image53.png)

## Create Oracle User

`create` command is used to create database user accounts and defines user account information such as:
- User account name
- password
- Default and Temporary tablespace assignments
- Tablespace space usage allowances
- Security settings (profiles)

When creating a user, a tablespace can be assigned - the physical location of its objects. And also specify what share of the tablespace the objects of this user can occupy, for example, the entire tablespace, or even prohibit him from creating objects.

Example:
```sql
create user robert identified by password
default tablespace users 
temporary tablespace temp 
quota inlimited on users;
```

## User privileges

When you create a user, by default it lacks any privileges to do anything in the database, even connect

Give create session grant
```sql
grant create session to robert;
```

## User Profiles

`resource_limit` parameter must be set to `TRUE`
  
Profiles are used to:
- Define basic resource usage limits
  - logical reads
  - idle time
  - total sesstion time
  - total sga usage 
- Manage password requirements
  - control the total number of failed attempts
  - define the lifetime of an individual password before it must be changed
  - grace time onse password lock time has passed
  - custom functions to enforce more complex password rules

create profile that locks the account for one hour after  failed login attempts
```sql
create profile security_profile limit 
Failed_login_attempts 5
Password_lock_time 1/24;
```

create a profile that controls resource usage. Limits a single call to one minute of CPU time. Limits a single connection to 60 minutes
```sql
create profile resource_hog limit
cpu_per_call 6000
connect time 60;
```

Once a profile is created it can be assigned to a user account
```sql
create user robert identified by password
default tablespace users
temporary tablespace temp
quota unlimited on users
Profile security_profile;
```

There is more advanced resouce management functionality is offered by Oracle
- Instance caging
- Resource manager
.png)

## Delete user and all his objects

drop a database user
```sql
drop user username;
```

If the user owns any database objects then you must include the `cascade` keyword
```sql
drop user username cascade;
```
![](images/image28.png)


Once you have dropped the user the only way to get those objects back to recover them using a backup taken **before the drop user command was issued**

## Change user attributes

Use the `alter user` command to administer most things related to user accounts (except security) including:
- change and expire passowrds
- lock or unlock accounts
- add/modify/remove tablespace quotas
- modify tablespace assignments
- assign profiles

change the password of the robert account
```sql
alter user robert identified by new_password;
```
![](images/image176.png)



add an unlimited tablespace quota to the users tablespace to the robert account
```sql
alter user robert quota unlimited on users
```

unlock the robert account
```sql
alter user robert account unlock;
```

## Create dba user , connect and create table

- create user

```sql
create user dba_one IDENTIFIED by password
default TABLESPACE users;
```
![](images/image71.png)

- try to connect
  
![](images/image194.png)

- Give grant to create session 
  ```sql
  grant CREATE SESSION TO dba_one
  ```

![](images/image159.png)

- Connect with created user
- Try to create a table

```sql
create table table_mine (id NUMBER)
```
![](images/image111.png)

- Give grant dba

```sql
grant dba to dba_one
```
![](images/image212.png)

- give rights to access tablespace

```sql
alter user data_owner quota unlimited on users;
```

- create table
```sql
create table table_mine (id NUMBER)
select owner, table_name fro all_tables where table_name='MY_TABLE'
```

![](images/image136.png)

![](images/image55.png)

## Userul grants

- `grantcreatetabletodata_owner`
- `grantcreateview`
- `createprocedure` 
- `createsequencetodata_owner`

# Oracle data dictionary

Informatation related to the database is in structure called the **data dictionary**
Examples of what's stored in it:
- Names of users
- Names of tables
- Names of indexes

This information is stored in tables and views in the database. These tables and views are owned by the `SYS` schema

Example. Query the data dictionary views with SQL
```sql
select tablespace_name from dba_tablespaces
```

![](images/image63.png)


## Scope to what is seen in the dictionary view

- `DBA`
  - Can see everything in the database
  - Must have `DBA` privileges 
- `ALL`
  - Can see only the objects you have privileges too
  - Can see own objects and objects on that granted in another schemas
- `USER`
  - Visibility to only the objects in the schema of the user you are connected too
  - Cannot cross schhemas

```sql
connect scott/password
select table_name from user_tables;
```

```
TABLE_NAME
---------
BONUS
SALGRADE
DEPT
EMP
```

```sql
connect scott/password
select owner, table_name from all_tables;
```

```
OWNER       TABLE_NAME
--------- ------------
SCOTT       EMP
SCOTT       DEPT
SCOTT       SALGRADE
SCOTT       BONUS
```

## Useful views

`ALL_INDEXES` to find all tables with indexes assigned to those tables owned by a specific user

```sql
select owner, table_name, index_name from all_indexes where owner='SCOTT'
```

```
OWNER       TABLE_NAME      INDEX_NAME
-----       -------         ------
SCOTT       DEPT            PK_DEPT
SCOTT       EMP             PK_EMP
```

Views related to users, objects they own and resource restrictions

- (DBA, ALL, USER) `USERS`
- (DBA) `PROFILES`
- (DBA, ALL, USER) `OBJECTS`
- (DBA, ALL, USER) `TABLES`
- (DBA, ALL, USER) `INDEXES`
- (DBA, ALL, USER) `RECYCLEBIN

Dynamic views related to users
- `V$SESSION` See who is on the database
- `V$PROCESS` Process related info

# Transactions

## Decription 

A transaction is the set of insert, update and delete statements (DML) that occur from the time you log into the database, issue the statements and then issue a `commit` command OR All DML issued between two `commit` commands OR All DML issued between login or the last commit and a DDL statement

## ACID

A relational database adheres to the principles of ACID:
- (A)tomicity - Each transaction is all or nothing
- (C)onsistency - Each transaction will be valid according to all defined rules (contraints, cascades, triggers and so on)
- (I)solation - No dirty reads. Results of concurrent transactions are as if the transactions were run serially.
- (D)urability - Once a commit occurs the database ensures that it has been stored permanently and is recoverable in the event of failure

## How does Oracle support ACID

- Atomicity - The `commit` comand
- Consistency - Constraints, undo segments, locking
- Isolation - Undo segments, locking
- Durability - Commit, redo logs, backups

## Read Consistency Model

Oracle's architecture provides for a read consistent version of database data:
- View of data is guaranteed to be accurate at the point in time you execute your SQL statement
- If you are writing data (insert, update or delete) then you many have to contend with other transactions to access to row you are trying to modify
- Locks only exist for individual rows that are modified. This reduces locking contetion
- Read consistency is made possible by a special kind of objects called an **undo segment**
- Along with undo segments Oracle uses locking mechanisms to ensure that transactions are consistent
- Selects are never blocked by locks. There may be a momentary lock when oracle loads data from disk, but this is not a block that can occur between transactions.
- DML (insert update and delete ) statements can be blocked by locks


### Undo segment

Undo sements are stored in special tablespaces called **undo tablespaces**

Undo is managed by Oracle automatically. All the DBA needs to do is create the undo tablespace and make sure it's large enought to support the transactional load

### Database timing (SCN)

Oracle assigns all database operations a number to indicate the order of when they happend. This number is called the System Change Nubmer (SQN)

Think of the SCN like a counter on a recording device. Like the timer the SQN is not a clock. It's just a nubmer that start at zero and increments

Like the time the SQN can loosely be related to a point-in-time, but its main purpose is to indicate a place in the transaction stream.

Every time a change is made in the database, the current SCN is assigned to that change and SCN is implemented

### Example Read Consistency

- User 1 will start a select statement
- User 2 will make a database change with an insert statement
- Oracle ensures that the database change made by user 2 doesn't change the result that user number one gets

Details:

- Janice starts a report of all employees and their total pay to date at 12:00 pm. The SCN is **12345** when the report is started. This report uses the EMPLOYEES table
- An application job starts printing checks at 2:30 which increases the total amount paid to date for each employee. The SCN is **12399**
- Janice's report reads a record in the EMPLOYEES table for employee **5503**. The block header indicates that the block was last changed/commited at SCN **10234** - since this was before the SCN at the time Janice started her report. It just reads the block in the table

    ![](images/image68.png)

- The application job then changes information in the EMLOYEES table for employee **5300**. This employee's active status is changed from TRUE to FALSE and commits the change. The CCN for this change is **12465**. 
- The row is locked
- The old block image is copied to the Undo tablespace with the old SCN
- The row is changed. The block is not marked as commited yet

    ![](images/image117.png)

- The application job then issues a commit. This indicates the change is permanent.
- The block in the table is marked as commited
  
    ![](images/image162.png)

- Any transaction that starts after the commit will use this block
- Janice's report wants to read the EMPLOYEES row for employee **5300** at SCN 12560
- Oracle checks the block for the row and finds that it's in a commited state. This meaans that the block can be used if the SCN on the block header is before the SCN when Janice started her report
- Janice started her report at SCN **123456** and the SCN in the block header is **12465**. This means this record was changed after Janice started her report. Oracle can't use this row. If Oracle did use this row, Janice would be using dirty data - or data that changed while her report was running. This couild result in inconsistent results in the report. The report will nedd to get the correct row from the Undo tablespace. 
- Oracle will search the Undo tablespace for a copy of the block with the highest SCN closest to the SCN when Janice started her report. Oracle finds two old versions of the block with two old versions of a row for EMPID **5300**. Oracle will use version **0765** since it's the closest to SCN **123456**. This is the row that's used by the report

    ![](images/image103.png)

### What if Oracle can't find the row in the Undo tablespace?

By default Undo records are preserved until a commit occurs. If the Undo tablespace is full Oracle will try to make it larger. If Oracle can't make the Undo tablespace larger it will end the transaction with an error.

Once a commit occurs Oracle writes to the Undo tablespace in round robin fashion. Oracle will not overwrite undo until the space is needed. Oracle will return **ORA-1555** if it can't find the Undo records it needs and the query will fail

## Oracle Locking

Locks are used to prevent simultaneous changes to a given row or set of rows.

The first session to make a change to a row acquires a lock on that row. This gives that user exclusive access to that row. Other sessions that want to change that row will need to wait for the lock to be released.

A lock is released when:
- The session that holds the lock commits their changes with the `commit` command
- The session that holds the lock issues a subsequent DDL command that causes an implicit commit to occur
- The session that holds the lock issues a rollback command and rolls the change back
- Other operations occur that cause a commit or rollback such as exiting a session.

You can see what objects are locked by using the view `V$LOCK`. The view shows the user session id, the kind of lock, the object that is locked

### Example locking

- Janice inserts a new row into the EMPLOYEE table for Marcus

```sql
insert into employees (empid, last_nm, first_nm, active, hire_date) values (102, 'Smith', 'Marcus', 'FALSE', sysdate)
```
- Oracle will create the row and lock it until Janice have commited or rolled back the insert
- Let's see what if any locks were created as a result of the insert that Janice just executed

```sql
select a.sid, a.type, b.object_name, a.lmode, a.request from v$lock a, dba_objects b where a.id1=b.object_id and b.object_name='EMPLOYEES';
```

```
SID     TYPE        OBJECT_NAME     LMODE       REQUEST
----    -----       ----------      -----       ------
166     TM          EMPLOYEES       3           0
```
- The insert created a TM lock. A TM lock occurs when a DML statemnt is executed against a table
- Anry logs in and she happens to execute the same insert command.
```sql
insert into employees (empid, last_nm, first_nm, active, hire_date) values (102, 'Smith', 'Marcus', 'FALSE', sysdate)
```
```
1 row created
```
- Now we have two inserts. Let's look at the locks again 
```sql
select a.sid, a.type, b.object_name, a.lmode, a.request from v$lock a, dba_objects b where a.id1=b.object_id and b.object_name='EMPLOYEES';
```

```
SID     TYPE        OBJECT_NAME     LMODE   REQUEST
----    -----       ----------      -----   ------
166     TM          EMPLOYEES       3       0
337     TM          EMPLOYEES       3       0
```
- We now have two different locks in place
- Both Users can commit the changes and the locks will be removed
- Did you notice that Oracle allowd us to insert two different records? This is because there are no constraints on the EMPLOYEE table. What if we add a primary key to the EMPLOYEES table?

- Add primary key to table end repeat two inserts without commit
```sql
trancate table employees;
alter table employees add constraint pk_employees primary key (empid);
```

- Now Arny inserts her record
```sql
select a.sid, a.type, b.object_name, a.lmode, a.request from v$lock a, dba_objects b where a.id1=b.object_id and b.object_name='EMPLOYEES';
```
- Oracle did not display the '1 row created' message
- Janice's session seem to have hung up
- Let's look at the lock again
```sql
select a.sid, a.type, b.object_name, a.lmode, a.request from v$lock a, dba_objects b where a.id1=b.object_id and b.object_name='EMPLOYEES';
```

```
SID     TYPE        OBJECT_NAME     LMODE   REQUEST
----    -----       ----------      -----   ------
166     TM          EMPLOYEES       3       0
337     TM          EMPLOYEES       3       0
```
- This looks the same. Clearly one session is blocking another. How do we tell who is blocking who?
- Remember the ID1 view containded the OBJECT_ID of the locked object
- The ID2 view contains the session identifier SID of the session that owns the lock
- Let's see who is blocking who
  
```sql
select l1.sid, 'IS BLOCKING SESSSION' , l2.sid from v$lock l1, v$lock l2 
where l1.block=1 
and l2.request > 0 
and l1.id1=l2.id1 
and l1.id2=l2.id2
```
```
SID     'IS BLOCKING SESSION'       SID
---     --------------------        ----
166     IS BLOCKING                 337
```
- So now we can see that session 166 is blocking session 337
- Another way we can see who is blocking who is to use the `V$SESSION` view as seen here
```sql
select sid, serial#, username, blocking_session
from v$session
where (blocking_sessioin is not null
or sid in (select distinct blocking_session from v$session);
```

```
SID     SERIAL#     USERNAME        BLOCKING_SESSION
---     -------     --------        ----------------
166     27667       JANICE          
337     25540       AMY             166
```
- When Janice commits her change Amy will then get an error that indicates she is trying to insert a duplicate row
- If Janice rolls her change back then Amy's change will be able to be commited
- One session ca easily lock many other sessions if it tries to change many rows

# Control files

## Description 

The control file is a non-text physical file that contains information that Oracle requires in order to be able to open the database

The control file contains database configuration information that includes:
- Database datafiles
- Database tablespaces
- Database redo logs
- The current database SCN
- RMAN backup information

Each Oracle database has one or more control files

You should have at least two control files in every database
- Having multiple control file is considered best practice
- Provides redundancy should one control file be lost
- Oracle writes to the control files in parallel
- Having multiple copies does not impact the database performance
- Locate each control file on file systems that are supported by separate physical disks

## Oracle instance starting stages

Modes that the database goes throught when it's being started
- **NOMOUNT** open parameters file and search control files.
- **MOUNT**. the control file is located and opened. Views from control file is assessible on this stage. V$.. 
- **OPEN**. Oracle uses the control file to locate the database datafiles and the online redo logs

At the mount stage, Oracle compares the SCN from the control file and data file, if they match, then Oracle can open the database, if not, the recovery procedure begins

## Creating the Control File

The ctonrol files are initially created when the database is created

You configure the locations of the control files in the databse parameter file using the `control_file` parameter

Oracle will create the control files for you in those locations

The database creation will fail if you do not create the directories defined in the database paramter file or if Oracle does not have read/write privileges to those directories

## Adding a control file

- To add a control file first create the directory where you want the control file to reside
- Modify the database parameter `control_files` adding the new control file location

```sql
alter system set
control_files='/u01/app/oracle/database/mydb/control/control01.ctl, /u01/app/oracle/database/mydb/control/control02.ctl, /u01/app/oracle/database/mydb/control/control03.ctl'
scope=spfile;
```

- copy an existing control file over to the new control file
- shutdonw and restart the database. The new control file will be used

## Moving a control file

- create the new directory where you want the moved control file to reside
- Modify the database parameter `control_files` adding the new control file location

```sql
alter system set
control_files='/u01/app/oracle/database/mydb/control/control01.ctl, /u01/app/oracle/database/mydb/control/control02.ctl, /u01/app/oracle/database/mydb/control/control03.ctl'
scope=spfile;
```

- shutdown the database
- move the control file from the old location to the new location
- restart the database

## Removing a control file

- Modify the database parameter `control_files`. Replace the existing string with the new string that does not include control file you wish to remove


```sql
alter system set
control_files='/u01/app/oracle/database/mydb/control/control01.ctl, /u01/app/oracle/database/mydb/control/control02.ctl'
scope=spfile;
```

- shutdown the database
- physically remove the control file (optional but recommended)
- restart the database

## Show control file path

```sql
select name, value from v$parameter where name='control_files'
```

![](images/image143.png)

## Control file data dictionary view

Many of the data dictionary views source their data from the database control file

Views that conaint control file information typically have a `V$` prefix followed by the content withing the view

- `V$DATABASE` Database information from the control file
- `V$DATAFILE` Database datafile information from the control file
- `V$TABLESPACE` Database tablespace information from the control file
- `V$CONTROLFILE` about control files and their path (like control_files params in v$parameter)

These views is ascessible after `mount` stage. If database is not mounted view is not accessible. `ORA-01507 database not mounted`.

Note that many V$ views are on varioous structures within the database not the control file. For example `V$INSTANCE` view provides information on the database instance once it's started

# Redo logs

Each change that happens in the database creates what is called redo

Redo is critical for recovery purposes

Redo is stored both in memory and disk at various times
- Initially redo is stored n an area of memory in the SGA called the **redo log buffer**
- When a commit occurs then the redo in the **redo log buffer** is flushed to physical files on disk called **online redo logs**

A commit record is also stored in the redo logs. As you remebmer about durability in ACID. 

Redo log and uncommitted transactions can get to disk, for example, if a lot of data is inserted and there is not enough memory in the redo log buffer.

An individual redo log is called a redo log member

One or more redo log members are assigned to a redo log group

All redo log members assigned to the same redo log group are mirrored copies
  - They are written to at the same time
  - They are written to in parallel
  - The mimmrors are used to provide redundancy
  - The mirrorrs should be palces on sepatate physical disks

An Oracle databes must have at least two redo log groups

Oracle writes to the redo logs in round-robin sequence. As a result, the contents of older redo logs get over written over time. Any time Oracle stops writing from one redo log group and starts writing to another, this is called a log switch

When a log switch occurs the new redo log group is assigned a sequence number. The number starts at 1 when the database is created. The number increments by one for each log switch. This helps to serizlize when the online redo log groups were written too, which is useful during recoveries. 

## Redo Logs and Performance

A commit can not complete until all the redo information in the redo log buffer has been flushed to the redo logs on disk

The session issuing the commit will have to wait until the commit is complete before it can continue

Thi smeans that database performance is sensitive to the write performance of the disks that the online redo logs are located on

Additionally once as online redo log fils up and a log switch is required all sessions will be blocked from completing any commits until the log switch is complete. This is another reason to make sure the online redo logs are on fast disk.

## Infications of Performance issues

Oracle provides a lot of metrics around performance

The oracle performance view `V$SYSTEM_EVENT` provides statistics of interest on redo log performance. These include
- log_file_sync
- log_file_parallel_write
- log_file_switch_completeion

This view provieds both a count for each time the event occurred and how long the events took in total

All times are in microseconds

```sql
select event, total_waits, time_waited, average_await from v$system_event where event like `%log%`
```

```
EVENT                       TOTAL_WAITS     TIME_WAITED         AVERAGE_WAIT
----                        ----------      ----------          -----------
log file sequential read    16              0                   0
log file single write       16              11                  .67
log file parallel write     232             23                  .99
switch log file command     2               16                  7.83
log file sync               27              55                  2.03
target log file size        127             75                  .59
```

Rapid log swithing can be a serious cause of performance issues

Log switches can be queried view the `V$LOG_HISTORY` view. We can then see how long there is between log switches

```sql
select sequence#, first_change#, first_time, 
trunc(1440*(first_time - lag(first_time)) over (order by first time) ) )
    as time_between_switch_min
from v$log_history
order by sequence#    
```

```
SEQUENCE#   FIRST_CHANGE#   FIRST_TIME              TIME_BETWEEN_SWITCH_MIN
----        ----------      ----------              -----------
30          1963095         10/09/2016 13:29:35     
31          1965817         10/09/2016 13:59:41     30
32          1986048         10/10/2016 00:00:54     601
```

## Redo Log Administration

As a DBA you will need to:
- Add and remove online redo log members to existing groups
- add and remove new online redo log groups
- Move members of existing online redo groups to different disk devices
- These oparations are done using the `alter database` command

To add a redo log member

```sql
select group#, members from v$log 
```

```
GROUP#      MEMBERS
------      -------
1           2
2           2
3           2
```

```sql
alter database add logfile member `u01/redo/member_3/redo01_01c.log` to group 1;
alter database add logfile member `u01/redo/member_3/redo01_02c.log` to group 2;
alter database add logfile member `u01/redo/member_3/redo01_03c.log` to group 3;
```


```sql
select group#, members from v$log 
```

```
GROUP#      MEMBERS
------      -------
1           3
2           3
3           3
```

To remove a redo log member

```sql
alter database drop logfile member `u01/redo/member_3/redo01_01c.log`;
alter database drop logfile member `u01/redo/member_3/redo01_02c.log`;
alter database drop logfile member `u01/redo/member_3/redo01_03c.log`;
```

when dropping a mamber or a log file group you might see this error
`ORA-01609 log 2 is the current log for thread 1 - cannot drop members`

You will need to perform a log switch in this case sinse you can't drop or change members of the current log group

```sql
alter system switch logfile
```

You can see the current log group throught this query 
```sql
select group#, status from v$log
```

![](images/image86.png)

After performing the switch you can drop the member