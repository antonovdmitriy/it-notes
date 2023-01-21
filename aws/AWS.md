
# Содержание
- [Содержание](#содержание)
- [Советы для прохождения экзамена](#советы-для-прохождения-экзамена)
- [User management](#user-management)
  - [Generate sectet key](#generate-sectet-key)
  - [Billing](#billing)
- [EC2 (Elastic compute cloud)](#ec2-elastic-compute-cloud)
  - [Create simple vm](#create-simple-vm)
  - [Simple network rules](#simple-network-rules)
  - [Горизонтальное масштабирование путем создания образа инстанса](#горизонтальное-масштабирование-путем-создания-образа-инстанса)
- [EBS Elastic block storage](#ebs-elastic-block-storage)
- [EFS Elastic file system](#efs-elastic-file-system)
- [S3 Simple storage service](#s3-simple-storage-service)
- [AWS ClI](#aws-cli)
  - [Installing](#installing)
  - [конфигурирование](#конфигурирование)
- [Networking](#networking)
- [Load balancing](#load-balancing)


# Советы для прохождения экзамена

Доллжно быть 3 прохода:
1. Ищем простые вопросы и отвечаем на них. Отмечаем все остальные
2. Решаем сложные вопросы, задания в которых понятны, но нужно больше времени чтобы дать верный ответ
3. Задания решать которые без понятия как. Нужно что-то выбрать.
Перед тем как отправить нужно поставить вариант ответа у каждого вопроса.

# User management

Есть Root user, при котором доступны все возможные операции с пользователями на aws и также IAM User регулярные пользователи, которые можно добавлять в группы. Для того чтобы возможно было создать IAM User нужно сначала активировать возможность добавления таких пользователей. 

![Enable AIM users](images/1.png)

Войдем в консоль пользователей
![Enter to AIM management](images/2.png)

![Enter to AIM management2](images/3.png)

Создадим группу admins
![Group creation](images/group_creation.png)

Поставим права AdministratorsAccess
![Rights to group](images/group_right_access.png)

У всего есть ARN идентификатор амазона, используется в ссылках на компоненты. вот у той группы которую создали. Тут цифра это ID аккаунта. 
![ARN for group](images/arn_for_group.png)

Создадим пользователя
![Create an user](images/create_user.png)

![Create an user](images/create_user_2.png)

![Create an user](images/create_user_3.png)

После создания пользователя будет показана ссылка, которую можно будет сохранить и использовать для логина. Потом нужно выйти из root account and then needs to log in by the previous link. After that regenerate a password and then you will be as a new user.

![Create an user](images/create_user_4.png)

## Generate sectet key

![Create security cred](images/security_cred.png)

![Create security cred](images/security_cred_2.png)

![Create security cred](images/security_cred_3.png)

Не рекомендуется создавать ключ доступа для root акаунта. Все ключи должны храниться в секретных местах. На той же странице можно настроить двухфакторную аутентификацию. Ключи нельзя посмотреть после, только отозвать и создать заново. 

## Billing
Зайти в Billing и выбрать.
![Billing prefs](images/billing_prefs.png)

на этой же странице есть ссылка на Managed Billing Alerts. Откроется Cloud Watch сервис нотификаций амазона. В нем можно настроить мониторить сервисы, смотреть логи сервисов, а также настроить нотификации об оплате. 

![Billing prefs](images/billing_prefs_2.png)

![Billing prefs](images/billing_prefs_3.png)

![Billing prefs](images/billing_prefs_4.png)

![Billing prefs](images/billing_prefs_5.png)

![Billing prefs](images/billing_prefs_6.png)

![Billing prefs](images/billing_prefs_7.png)


![Billing prefs](images/billing_prefs_8.png)


![Billing prefs](images/billing_prefs_9.png)


![Billing prefs](images/billing_prefs_10.png)

после этого подтвердить подписку на электронной почте и вот финальная картинка

![Billing prefs](images/billing_prefs_11.png)

# EC2 (Elastic compute cloud)

## Create simple vm

![Create EC2 instance](images/ec2_1.png)

![Create EC2 instance](images/ec2_2.png)

![Create EC2 instance](images/ec2_3.png)

![Create EC2 instance](images/ec2_4.png)

![Create EC2 instance](images/ec2_5.png)

![Create EC2 instance](images/ec2_6.png)

![Create EC2 instance](images/ec2_7.png)

![Create EC2 instance](images/ec2_8.png)

![Create EC2 instance](images/ec2_9.png)

Далее копируем публичный ключ, применяем права доступа и заходим через ssh

```
mv /mnt/c/Users/anton/Downloads/awsdemo.pem ~/.ssh

chmod 400 ~/.ssh/awsdemo.pem

ssh -i "~/.ssh/awsdemo.pem" ubuntu@ec2-54-157-214-250.compute-1.amazonaws.com
```

## Simple network rules

для проверки поставим apache сервер в инстанс
обновим индекс пакетов в vm
```
sudo apt-get update
```
```
sudo apt-get install apache2
```
потом попробуем подключиться из браузера на порт 80 по публичному dns имени, его можно найти в деталях инстанса
Затем зайдем в настройки security group и добавим доступ по 80 порту

![Add security rule to security group](images/security_group_1.png)

![Add security rule to security group](images/security_group_2.png)

![Add security rule to security group](images/security_group_3.png)

## Горизонтальное масштабирование путем создания образа инстанса
Идея простая. Настроили инстанс, потом можно создать его образ и раскатить еще один инстанс на основе этого образа.
Создадим шаблон

Созданим новый инсанс в другой зоне доступности с уже существующими ключами и правила security group

![Horisontal scaling based on image](images/create_image_1.png)

![Horisontal scaling based on image](images/create_image_2.png)

![Horisontal scaling based on image](images/create_image_3.png)

![Horisontal scaling based on image](images/create_image_4.png)

![Horisontal scaling based on image](images/create_image_5.png)

![Horisontal scaling based on image](images/create_image_6.png)

![Horisontal scaling based on image](images/create_image_7.png)

# EBS Elastic block storage
К каждому инстансу ec2 подключается volume который можно расширять по мере необходимости. 
Но он доступн в один момент времени только для одного инстанса. Можно делать периодические снепшоты с volume, т.е слепки файловой системы. Отличается от создание образов на основе инстанса т.к сохраняет только файловую систему.

![Volume view](images/ebs_1.png)


# EFS Elastic file system
Можно создать общую файловую систему, которую можно разделять между инстансами ec2.
Итого имеем 2 инстанса, хотим сделать общую папку между ними.

![Shared folder via EFS](images/efs_1.png)

Создадим файловую систему через efs

![Shared folder via EFS](images/efs_2.png)
![Shared folder via EFS](images/efs_3.png)
![Shared folder via EFS](images/efs_4.png)
![Shared folder via EFS](images/efs_5.png)
потом нужно подкрутить security group чтобы трафик мог ходить между сервисами aws
Добавляем для каждого инстанса
![Shared folder via EFS](images/efs_6.png)
![Shared folder via EFS](images/efs_7.png)

далее логинимся на каждый инстанс
![Shared folder via EFS](images/efs_8.png)

Устанавливаем пакет nfs-common

```bash
sudo apt install nfs-common
```

создадим каталог `/efs`
```bash
cd /
sudo mkdir /efs
```
далее можем создадить временную точку монтирования для проверки. Потом переделать на fstab
(постоянное монтирование)
команду можно найти в описании к efs
![Shared folder via EFS](images/efs_9.png)
![Shared folder via EFS](images/efs_10.png)
![Shared folder via EFS](images/efs_11.png)

```bash
cd /
sudo mount -t nfs4 -o nfsvers=4.1,rsize=1048576,wsize=1048576,hard,timeo=600,retrans=2,noresvport fs-0f1e7ae9d1a311501.efs.us-east-1.amazonaws.com:/ efs
```

![Shared folder via EFS](images/efs_12.png)

теперь можем шарить файлы между инстансами
![Shared folder via EFS](images/efs_13.png)

# S3 Simple storage service
![S3](images/s3_1.png)
![S3](images/s3_2.png)
Можно создавать бакеты (buckets) и в них создавать файлы. Доступ можно настраивать как на папки так и на бакеты. Лучше для публичных данных создавать отдельный бакет. 
Имя бакета уникально для всех пользователей. Т.е назвать tests3 нельзя. 
![S3](images/s3_3.png)
![S3](images/s3_4.png)

Есть также S3 Glacier метафора про холодильник, достать данные из которого потребует значительного времени, но дешевле чем S3. Подходит для бекапов, логов и тд, которые не нужно постоянно читать. Можно настроить политику переноса данных в Glasier после некоторого времени хранения. 

Также если нужен CDN , есть CloudFront. Например если делаем статический сайт и храним его в S3 бакете, можно настроить CloudFront так, чтобы в зависимости от расположения пользователя выбирался ближайший сервис, чтобы сделать загрузку быстрее.

# AWS ClI

## Installing

```bash
$ curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

## конфигурирование
```bash
aws configure
```
указать Access Key ID , AWS Secret Access Key далее регион, обычно us-east-1 формат json

посмотреть список бакетов s3 через api
```bash
 aws s3api list-buckets
```
![cli S3](images/aws_cli_1.png)

при подключении может быть ошибка 
> An error occurred (RequestTimeTooSkewed) when calling the ListBuckets operation: The difference between the request time and the current time is too large.

такое встречал в wsl ubuntu. Нужно синхронизировать время
```bash
sudo hwclock -s
```
посмотреть список бакетов  в простом формате
```bash
aws s3 ls
```

![cli S3](images/aws_cli_2.png)

скопировать файл в s3

```
aws s3 cp ./file.txt s3://tests355465646546/folder_3/
```
![cli S3](images/aws_cli_3.png)

# Networking

# Load balancing
ELB - Elastic load balancer


