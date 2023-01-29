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
    - [Contraints](#contraints)
    - [Создание модели таблицы (ERD)](#создание-модели-таблицы-erd)
    - [Концепция NULL значения в Oracle](#концепция-null-значения-в-oracle)
    - [Первичный ключ](#первичный-ключ)
    - [Натуральные и суррогатные первичные ключи](#натуральные-и-суррогатные-первичные-ключи)
    - [Нормализация](#нормализация)
      - [1-ая форма (Атомарность данных в колоноках)](#1-ая-форма-атомарность-данных-в-колоноках)
      - [Обозначение связей на ERD](#обозначение-связей-на-erd)
      - [Foreign ключи](#foreign-ключи)
      - [2-ая нормальная форма (зависимость колонок от первичного ключа)](#2-ая-нормальная-форма-зависимость-колонок-от-первичного-ключа)
      - [3-я форма (зависимость колонок только от первичного ключа, но не от других)](#3-я-форма-зависимость-колонок-только-от-первичного-ключа-но-не-от-других)
    - [Устройство Oracle](#устройство-oracle)
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
  
  
![](images/image44.png)

![](images/image215.png)

![](images/image60.png)

### Contraints

![](images/image107.png)

Check constraint - проверка бизнес правил при вставке записи.

Отличия unique constraint от primary key в том, что значение в колонке с unique constraint могут быть null значения.

И для unique и для primary key создается индекс.

![](images/image193.png)

Добавление check contraint

![](images/image10.png)

При вставке будем проверять, что дата не раньше чем 1900 год.

![](images/image19.png)

### Создание модели таблицы (ERD)

![](images/image123.png)

![](images/image219.png)

![](images/image65.png)

![](images/image3.png)

![](images/image21.png)

Можно создать модель базы данных в Oracle Data Modeller.

![](images/image129.png)

![](images/image35.png)

![](images/image94.png)

![](images/image20.png)

![](images/image217.png)

![](images/image138.png)

![](images/image36.png)

![](images/image12.png)

![](images/image199.png)

### Концепция NULL значения в Oracle

![](images/image224.png)

![](images/image187.png)

![](images/image205.png)

![](images/image183.png)

![](images/image200.png)

![](images/image79.png)

Повторим ERD в Oracle Data Modeller

![](images/image214.png)

### Первичный ключ

![](images/image190.png)

![](images/image26.png)

![](images/image172.png)

### Натуральные и суррогатные первичные ключи

![](images/image40.png)

![](images/image178.png)

### Нормализация

![](images/image11.png)

![](images/image110.png)

![](images/image56.png)

![](images/image220.png)![](images/image196.png)

#### 1-ая форма (Атомарность данных в колоноках)

![](images/image104.png)

Посмотрим на структуру таблицы

![](images/image169.png)

Тут видно, что телефон входит целиком. Но внутри телефона есть код города, который будет повторяться во многих телефонных номерах. Всегда стоит дилемма насколько глубоко дробить данные. Тут нужно смотреть на бизнес\-требования. Если возможно представить случай, когда данные понадобятся для анализа, следует данные нормализировать. В данном случае создать отдельное поле для кода \- города. Так создается 1-ая нормальная форма. Каждая колонка должна отражать отдельное свойство (атрибут) сущности (entity).

![](images/image149.png)

![](images/image137.png)

![](images/image177.png)

Что будет если нужно добавить несколько телефонных номеров

![](images/image32.png)

![](images/image41.png)

Тут есть проблема. Что если у человека может быть несколько телефонов одного типа. Т.к у нас в первичный ключ входит тип телефона в этой схеме это сделать нельзя.

#### Обозначение связей на ERD

![](images/image171.png)

![](images/image33.png)

![](images/image139.png)

![](images/image73.png)

![](images/image29.png)

Тут показано, что если вводим запись в депарартаменты, то на нее могут ссылаться 0 или более объектов работников. Но при вводе работника в таблицу работников, обязательно должны быть записи в департаментах одна или более.

В таких случаях часто вводят таблицу связку

![](images/image153.png)

#### Foreign ключи

![](images/image14.png)

Если добавляем работника с департаментом, которого нет в таблице департарментом, то будет ошибка вставки. Реализуем бизнес-требование.

![](images/image147.png)

#### 2-ая нормальная форма (зависимость колонок от первичного ключа)

![](images/image96.png)

![](images/image52.png)

![](images/image173.png)

Проверяем все ли колонки зависят от первичного ключа. Это проверка на вторую нормализованную форму. Тут проблемы.в таблицы с сертификация co_code входит в состав первичного ключа. Не может быть нескольких сертификатов у человека выданных одной компанией.

URL компании не зависит от всех полей первичного ключа. Логично вынести его в таблицу cert_company.

![](images/image100.png)

![](images/image126.png)

#### 3-я форма (зависимость колонок только от первичного ключа, но не от других)

![](images/image189.png)

Колонки должны зависеть только от первичного ключа. Если при изменении одной колонки мы должны править другие, значит у нас есть транзитивная зависимость.

![](images/image90.png)

![](images/image70.png)

### Устройство Oracle

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