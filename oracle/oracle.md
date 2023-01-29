# Table of contents

- [Table of contents](#table-of-contents)
- [Useful links](#useful-links)
- [Usefual commands](#usefual-commands)
- [Relational db foundation](#relational-db-foundation)
  - [ACID](#acid)
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
    - [Установка Oracle](#установка-oracle)
    - [Удаление Oracle](#удаление-oracle)
    - [Создание базы данных Oracle](#создание-базы-данных-oracle)
      - [Планирование мощностей](#планирование-мощностей)
      - [Создание базы данных через DBCA](#создание-базы-данных-через-dbca)
      - [Администрирования control files и redo logs](#администрирования-control-files-и-redo-logs)
      - [Redo logs](#redo-logs)


# Useful links

[Virtual Machine for Virtual Box  with Oracle 19](https://www.google.com/url?q=https://www.oracle.com/database/technologies/databaseappdev-vm.html&sa=D&source=editors&ust=1674949804304876&usg=AOvVaw2iaL0hD0EL7hZUdHVdkFIf)

# Usefual commands

Просмотр описания таблицы или view
```sql
desc table_name 
```

![](images/image46.png)

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

## ACID
A relational database adheres to the principles of ACID:
- (A)tomicity - Each transaction is all or nothing
- (C)onsistency - Each transaction will be valid according to all defined rules (contraints, cascades, triggers and so on)
- (I)solation - No dirty reads. Results of concurrent transactions are as if the transactions were run serially.
- (D)urability - Once a commit occurs the database ensures that it has been stored permanently and is recoverable in the event of failure

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

![](images/image147.png)


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

- Oracle 

![](images/image43.png)

![](images/image98.png)

Oracle database instance - это программа  - процесс операционной системы, которые позволяет работать базе данных работать.

SGA - область памяти, аллоцируемая при старте инстанса.

Может занимать от нескольких гигабайт до терабайт.

![](images/image167.png)

Разделена на более несколько пулов памяти.

![](images/image47.png)

Shared Pool

Database Buffer Cache

А также Redo Log Buffer и другие

![](images/image17.png)

Buffer Cache состоит из блоков фиксированного размера. Этот размер задается при создании базы данных. Т.е размер блоков в оперативной памяти такой же как и на диске.

![](images/image175.png)

В Buffer Cache клиентские процессы помещают данные с диска.

Из Buffer Cache записывает на диск процесс DBWR (Database Writer)

Shared Pool состоит из нескольких областей памяти.

Shared SQL Area. Отвечает за исполнение SQL выражений. Когда клиентский процесс запускает sql Oracle кладет это выражение в shared sql area. Когда выражение перестает часто вызываться Oracle убирает его зи Shared SQL Area

Также это Data Dictionary Cache. Сюда загружаются системные таблицы Oracle

![](images/image135.png)

Чем больше размер SGA тем дольше объекты сохраняются в памяти. Это сильно влияет на производительность. Если данные не находятся в Buffer Cache грузить их туда дорого и долго.

![](images/image54.png)

После старта инстанса, даже база ничего не делает, запущено более 46 процессов Linux. У каждого из них есть собственная область памяти PGA. Если база нагружена процессов намного больше.

Наиболее важные из них

![](images/image27.png)

Если один из 6 процессов остановится, скорее всего это приведет к поломке базы данных

Клиентские процессы создаются, когда открывается клиентская сессия.

Посмотрим параметры памяти:

show parameter memory

![](images/image38.png)

Важно уметь смотреть параметр ORACLE_HOME, чтобы понимать где установлена база данных на сервере.

env | grep ORACLE_SID

![](images/image99.png)

Обычно на расположение базы данных указывает переменная окружения ORACLE_HOME. Однако в примерах на виртуальных машинах от Oracle, база может быть установлена тут:

/u01/app/oracle/product/version/db_1

![](images/image9.png)

Важные файлы тут в каталоге dbs

![](images/image91.png)

Все SID имеют файл с окончанием cdb. Он управляется ораклом, но его можно открыть и частично прочитать cat.

![](images/image66.png)

![](images/image92.png)

В init.ora описываются параметры инстанса. Например размер SGA.

### Установка Oracle

При выделении оперативной памяти, больше внимание уделяют памяти для базы данных, но для памяти процессов Oracle, что может существенно влиять на его работу

При выделение процессорного времени большую часть уделяют работы процессов Oracle, но забывают оставить запас для клиентских процессов

Рекомендуется после определения будущих потребностей закладывать минимум в 4 раза больше плюс 25 процентов. 3 для трех версий Oracle , которые можно будет поставить. 1 для большого патча, т.к патч часто занимает также как и дистрибутив оракла и 25 процентов на логи маленькие патчи

Не рекомендуется ставить Oracle в root файловую систему. Должна быть отдельная партиция и нельзя добавлять файлы оракла в рутовую систему, чтобы в любом случае сервер не крашнулся. Если оракл забъет всю память.

ORACLE_BASE \- каталог куда остановлен весь софт от oracle

![](images/image142.png)

ORACLE\_HOME - каталог куда ставится Oracle Database. По стандарту OMF располагается внутри ORACLE\_BASE

![](images/image57.png)

![](images/image128.png)

После загрузки файла нужно разорхивировать архивы в единую папку под пользователем root

![](images/image25.png)

Увидим runInstaller

Дадим права на доступ пользователю oracle

![](images/image13.png)

Далее запустим runinstaller

### Удаление Oracle

В папке &ORACLE_HOME/deinstall есть файл deinstall

![](images/image64.png)

### Создание базы данных Oracle

#### Планирование мощностей

![](images/image165.png)

![](images/image37.png)

![](images/image158.png)

![](images/image225.png)

![](images/image209.png)

![](images/image156.png)

![](images/image114.png)

Тип OLTP (online transaction processing) - нормализированная модель. База данных приложений.

Тип OLAP (Data Warehouse) - online analytic processing. Обычно ненормализиованные данные. Слой над разными источниками, в том числи и OLAP. Используются для запуска аналитических отчетов.

![](images/image39.png)

RAC -, Real Application Clusters

это особый случай, потому что на самом деле он требует установки некоторого дополнительного программного обеспечения, называемого кластерным ПО. Таким образом, при установке Oracle Database вы не будете устанавливать программное обеспечение RAC, но RAC - это вариант для обеспечения высокой доступности. Это позволяет вам иметь несколько серверов баз данных, которые все подключены к одной и той же базе данных. Таким образом, если один из серверов баз данных выходит из строя, другие серверы баз данных берут на себя работу отказавшего сервера баз данных.

Partitioning опция, которая поставляется с носителями Oracle Database и позволяет вам брать таблицы и разбивать их на логические и физические единицы.

![](images/image24.png)

![](images/image191.png)

Database configuration assistance - средство для создания базы данных. (не установки)

![](images/image118.png)

![](images/image197.png)

![](images/image62.png)

![](images/image213.png)

Рекомендация лектора. Если на сервере предполагается только 1 база данных, выделяем памяти под нее не более 60 процентов.

PGA (Private Global Area). Каждая пользовательская сессия аллоцирует память в это области. Не только пользовательская, но и процессы Oracle. Размер памяти устанавливается в зависимости от ожидаемого количество пользовательских сессий у базы данных.

![](images/image170.png)

Существует два подхода (парадигмы) для установки памяти. AMM - тогда правим настройку MEMORY_TARGET . В этом случае оракл автоматически устанавливает размер SGA и PGA и может менять этот размер между этими областями по необходимости в рантайме, перераспределяя память.

![](images/image148.png)

или ASMM - тогда правим настройку SGA_TARGET.

Этой настройкой автоматически меняется только SGA. PGA не перераспределяется. PGA\_AGGRIGATE\_TARGET это целевое значение для PGA, но не строгое, база будет стремиться использовать его.

![](images/image223.png)

Также можно настраивать параметры памяти для отдельных областей SGA. Тут устанавливается минимально значение памяти для shared_pool внутри SGA. Он может быть увеличен, но не может быть меньше этой цифры.

![](images/image157.png)

Хотя и есть рекомендации ставить не более 60 процентов от памяти сервера, это достаточно условная цифра. Так, если на сервере размещена база в 500 МБ, выделять даже 1 ГБ оперативки для нее это излишнее выделения. Также и если база 200 ГБ, выделять 1 ТБ памяти это много. Также память зависит от активности использования базы -  более нагруженная база потребует большего SGA для выполнения заданной производительности. Также размер памяти зависит от требований к времени отклика (response time), если отклик должен быть минимальным, можно вообще все данные брать из памяти, это будет быстрее чем даше ssd диски.

![](images/image141.png)

С чего начать планировать ресурсы:

* Определить какое время будет существовать данные сервер до его замены. Например 3 года
* Определить размер данных в базе , который будет в конце этого срока.
* Поставить SGA 20% от этой цифры. Для начала.

![](images/image6.png)

![](images/image127.png)

![](images/image82.png)

![](images/image48.png)

![](images/image185.png)

#### Создание базы данных через DBCA

Через администратор можно пройти по нескольким шагам создать и создать базу данных. Нужен GUI

Посмотреть что Listener стартован

lsnrctl status

![](images/image95.png)

Пользователи

![](images/image85.png)

![](images/image174.png)

Схема = пользователь.

Можно давать гранты для доступа к оъектам других схем (пользователей)

![](images/image87.png)

![](images/image140.png)

![](images/image195.png)

![](images/image50.png)

![](images/image202.png)

Посмотреть пользователей .если зашли по system пользователем в Sql Developer

![](images/image204.png)

По-умолчанию у оракла есть тестовый пользователь scott

![](images/image160.png)

Сделать запрос от пользователя system в таблицу пользователя scott. Таблицы созданы scott и находятся в его схеме. Т.е если вы попытаетесь указать без схемы таблицу не найдем

![](images/image67.png)

![](images/image53.png)

SQL Developer подходит для разработки. Но для задач администрирования Oracle рекомендует использовать Oracle Enterprise Manager

![](images/image34.png)

При создании пользователю может быть присвоен tablespace - физическое место размещение его объектов. А также указать какую долю от tablespace могут занимать объекты этого пользователя, например весь tablespace, или вовсе запретить ему создавать объекты.

Также указывается профиль.

![](images/image8.png)

![](images/image161.png)

После создания пользователя у него нет никаких прав, даже на соединение с базой. Поэтому нужно выдать права, хотя бы на connect.

![](images/image116.png)

![](images/image115.png)

![](images/image83.png)

![](images/image58.png)

![](images/image121.png)

![](images/image144.png)

![](images/image31.png)

Удаление пользователя и всех его объектов

![](images/image131.png)

![](images/image30.png)

Изменение атрибутов пользователя

![](images/image23.png)

![](images/image61.png)

![](images/image71.png)

create user dba_one IDENTIFIED by password

default TABLESPACE users;

![](images/image194.png)

Выдадим грант на создание сессии

![](images/image159.png)

Теперь соединение проходит

Попробуем создать таблицу

![](images/image111.png)

Дадим пользователю роль dba , выдав грант

![](images/image212.png)

Как выяснилось и этого недостаточно. Нужно еще дать права на tablespace

alter user data_owner quota unlimited on users;

И потом уже можно создать таблицу

![](images/image136.png)

![](images/image55.png)

Полезные гранты

grantcreatetabletodata_owner;

grantcreateview, createprocedure, createsequencetodata_owner;

Поменять пароль

![](images/image176.png)

Удаляем пользователя

![](images/image28.png)

Словарь данных

![](images/image89.png)

![](images/image49.png)

![](images/image63.png)

![](images/image152.png)

![](images/image188.png)

Если указываем скоуп all. Значит видим все объекты, к которым имеем привилегии. Т.е объекты в собственной схеме + объекты в других схемах, на которые выданы гранты.

![](images/image163.png)

User видит объекты только в своей схеме.

![](images/image102.png)

![](images/image15.png)

![](images/image132.png)

* * *

![](images/image77.png)

![](images/image216.png)

![](images/image168.png)

⁹![](images/image218.png)

![](images/image192.png)

Можно создавать таблицу с одинаковыми именами в разных схемах.

![](images/image51.png)

![](images/image119.png)

![](images/image206.png)

![](images/image4.png)

![](images/image108.png)

![](images/image106.png)

![](images/image74.png)

Селекты никогда не блокируются локами. Может быть кратковременный лок, когда oracle подгружает данные с диска, но это не тот блок, который может произойти между транзакциями.

![](images/image211.png)

![](images/image97.png)

![](images/image146.png)

![](images/image68.png)

![](images/image117.png)

![](images/image162.png)

![](images/image109.png)

![](images/image207.png)

![](images/image103.png)

![](images/image75.png)

![](images/image181.png)

![](images/image145.png)![](images/image222.png)

![](images/image180.png)

![](images/image203.png)

![](images/image78.png)

![](images/image88.png)

![](images/image166.png)

![](images/image186.png)

![](images/image133.png)

![](images/image112.png)

![](images/image72.png)

![](images/image198.png)

#### Администрирования control files и redo logs

![](images/image155.png)

![](images/image150.png)

![](images/image221.png)

На стадии mount Oracle сравнивает SCN из control file и data file, если они совпадают, значит оракл может открыть базу данных, если нет - начинается процедура recovery

![](images/image84.png)

![](images/image179.png)

![](images/image201.png)

![](images/image42.png)

![](images/image208.png)

![](images/image143.png)

![](images/image113.png)

![](images/image1.png)

![](images/image151.png)

На стадии no_mount oracle открывает файл с параметрами parameters, поднимается oracle instance , аллоцируется память, запускаются процессы и считывает расположение control файлов.

Далее на стадии mount oracle находит эти ctl файлы и считывает их. После этого доступны вью V$.

Далее следует стадия open, где открывается дата-файлы.

![](images/image120.png)

#### Redo logs

![](images/image5.png)

До комита записи лога помещаются в область SGA redo log buffer. После коммита помещаются на диск. Именно это обеспечивает durablility в acid.

На диск могут попасть redo log и не закомиченных транзакций, например если вставляется множество данных и памяти в redo log buffer не хватает.

![](images/image22.png)

Если 3 зеркала redo logs после комита записывается в 3, но не синхронно. Синхронно (как я понимаю) только в 1.

Пример. Имеем две группы. В каждом 2 member ( можно думать о них как о файлах). Мемберы одинаковые в одной группе, просто зеркальные копии, их размер. Количество мемберов и их размеры в разных группах могут не совпадать

![](images/image125.png)

![](images/image122.png)

![](images/image134.png)

![](images/image69.png)

Размер redo logs важен. Если мы будем делать log switch из одной группы в другую, это будет существенно сказываться на производительности.

![](images/image18.png)

![](images/image101.png)

![](images/image59.png)

![](images/image16.png)

![](images/image154.png)

![](images/image81.png)

![](images/image182.png)

![](images/image130.png)

![](images/image86.png)

![](images/image80.png)

Установка Oracle на Lunux

Через графический интерфейс с пробросом X11

1.  См. Описание настройки проброса X11 в документе по Linux
2.  Поставить пакеты

sudo yum install xdpyinfo

sudo yum install xorg-x11-utils

Дать права на запуск пользователю. Это должен быть не root иначе не запуститься инсталлятор

sudo chown -R vagrant:vagrant *

sudo chown vagrant:vagrant ./oracle_distr/

3.  Экспортировать переменную окружения export CV\_ASSUME\_DISTID=OEL8.1
4.  Запустить инсталлер

![](images/image184.png)