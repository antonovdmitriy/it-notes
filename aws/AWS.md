
# Table of contents
- [Table of contents](#table-of-contents)
- [AWS Certification](#aws-certification)
  - [Advice for the Amazon exams](#advice-for-the-amazon-exams)
  - [Common links to cert path](#common-links-to-cert-path)
  - [Resources for](#resources-for)
- [Zones and Regions](#zones-and-regions)
- [IAM](#iam)
  - [Access control methods](#access-control-methods)
  - [MFA](#mfa)
  - [STS (Security Token Service)](#sts-security-token-service)
  - [Start on IAM](#start-on-iam)
  - [Generate secret key](#generate-secret-key)
  - [Billing](#billing)
  - [Assuming AWS role](#assuming-aws-role)
- [EC2 (Elastic compute cloud)](#ec2-elastic-compute-cloud)
  - [Create simple vm](#create-simple-vm)
  - [Simple network rules](#simple-network-rules)
  - [Horizontal scalling via create another ec2 instance](#horizontal-scalling-via-create-another-ec2-instance)
- [EBS Elastic block storage](#ebs-elastic-block-storage)
- [EFS Elastic file system](#efs-elastic-file-system)
- [S3 Simple storage service](#s3-simple-storage-service)
- [AWS ClI](#aws-cli)
  - [Installing](#installing)
  - [configure](#configure)
  - [help](#help)
  - [ec2 cli](#ec2-cli)
  - [s3 cli](#s3-cli)
  - [assuming a role](#assuming-a-role)
- [AWS SAM CLI](#aws-sam-cli)
  - [Installation](#installation)
- [Networking](#networking)
    - [VPS (Virtual private cloud)](#vps-virtual-private-cloud)
    - [availiablity zones](#availiablity-zones)
    - [Subnets](#subnets)
    - [Routing accross VPS and outside](#routing-accross-vps-and-outside)
    - [Internet access](#internet-access)
    - [Connect to the public AWS endpoint](#connect-to-the-public-aws-endpoint)
    - [NAT for private subnets](#nat-for-private-subnets)
    - [connect on-premises data center](#connect-on-premises-data-center)
    - [Firewall](#firewall)
    - [Examples](#examples)
- [Load balancing](#load-balancing)
- [Serverless](#serverless)
  - [BaaS (Backend as a service)](#baas-backend-as-a-service)
  - [FaaS (Function as a service)](#faas-function-as-a-service)
  - [AWS Lambda](#aws-lambda)
  - [How lambda can be invoked](#how-lambda-can-be-invoked)
  - [Examples](#examples-1)
    - [Web API](#web-api)
    - [File processing](#file-processing)
  - [Other](#other)
  - [First Java example (compile and deploy via SAM)](#first-java-example-compile-and-deploy-via-sam)
  - [Invoke lambda via AWS CLI](#invoke-lambda-via-aws-cli)
  - [Example with async lambda invocatoin and writing to log](#example-with-async-lambda-invocatoin-and-writing-to-log)
  - [The Lambda Execution Environment](#the-lambda-execution-environment)
  - [Lambda Function Method Signatures](#lambda-function-method-signatures)
    - [Example with basic types](#example-with-basic-types)
    - [Lists and Maps](#lists-and-maps)
    - [POJO in lambdas](#pojo-in-lambdas)
    - [Streams](#streams)
    - [Context](#context)
  - [Timeout](#timeout)
  - [Memory and CPU](#memory-and-cpu)
    - [Example pricing](#example-pricing)
  - [Environment Variables](#environment-variables)
  - [Spring cloud functions](#spring-cloud-functions)
    - [Main idea.](#main-idea)
    - [documentations and examples](#documentations-and-examples)
    - [pom and dependencies for aws and spring cloud functions](#pom-and-dependencies-for-aws-and-spring-cloud-functions)
    - [Internals](#internals)
    - [How to get a aws Context](#how-to-get-a-aws-context)
    - [Async lambdas](#async-lambdas)
    - [Get acces to env variable](#get-acces-to-env-variable)
    - [Using primitives in labmdas](#using-primitives-in-labmdas)
    - [Using inputstream like a payload](#using-inputstream-like-a-payload)
    - [Using pojo in lambdas](#using-pojo-in-lambdas)
    - [Testing](#testing)

# AWS Certification

## Advice for the Amazon exams

You should have three times to solve every task. Starting from first to last.:
1. We try to find easy questions and do it immediately. And mark others by categories.
2. We solve complex tasks but which we understood but we need just more time for them
3. Others which we don't know how to solve. We need to choose answers for each of the questions. Perhaps it will work

## Common links to cert path

- [Cert paths](https://aws.amazon.com/certification/?nc2=sb_ce_co)
- [AWS Certified Developer - Associate](https://aws.amazon.com/certification/certified-developer-associate/?ch=sec&sec=rmg&d=1)

## Resources for 

# Zones and Regions

AWS houses its computers in more than 60 data centers spread around the world as shown in Figure 1-2. In AWS terminology, each data center corresponds to an Availability Zone (AZ), and clusters of data centers in close proximity to each other are grouped into regions. AWS has more than 20 different regions, across 5 continents.

A compelling aspect of Amazon’s region model is that each region is largely independent, logistically and from a software management point of view. That means that if a physical problem like a power outage, or a software problem like a deployment bug, happens in one region, the others will almost certainly be unaffected. 

# IAM

Service to create:
- users (up to 5000 users in IAM)
- groups (sets of users). Users can be a member of up to 10 groups
- roles 
- policy (defines permissions for the identities or resources )
  - Permission policy
    - identity based policy for users, roles and groups
    - resource-based policy for resources like S3 bucket or DynamoDb tables
  - Trust policy. Check who can assume the role 
  
Users after its creation can only log in, nothing more, has no permissions. 

It's not possible to craate IAM entries for a specific region, only for all of them. 

## Access control methods 

Role based access control (RBAC)

Groups of users organized by job role. Permissions link to the group. User inherits permissions from the group. And principle of least previleges - the minimum permissions to get wob done. 

There are a lot of preconfigured job-function policies like:
- Administrator
- Billing
- Database-administrator
- Data scientist
- Developer power user
- Network administrator
- Security auditor
- Support user
- System administrator
- View-only user

Attribute-based access control (ABAC)

Permisson according to conditions. Users has a group and tags like metadata, for example department. And policy has condition on group and department tag. And it can have condition with tags which selected resources. Database has a tag environemnt and value production or test. And guy from admin group and with department DBAdmins can reboot database that has Environemnt tag like Production but not Test Database which has another value of the tag Environment.

## MFA

You can use Google Authenticator or a physical token which is possile to order from third parties companies.

![](images/iam_mfa_1.png)

![](images/iam_mfa_2.png)

![](images/iam_mfa_3.png)

![](images/iam_mfa_4.png)

## STS (Security Token Service)

What if you have an app on an EC2 instance and want to get access to S3 bucket. We need to create an instance profile and connect it to the IAM role. then to add trust policy and after that AWS STS could get temporary security credentials for ec2 instance. This credentionals includes AccessKeyId, Expiration, SecretAccessKey, SessionToken. 



## Start on IAM

There is root user, who has full rights for all operations in aws. As well there are IAM regular users, which possible to add to groups. To create IAM User we need first to activate capability to add such users. 

- Log in as root user
- Open Account Settings
- Find that sections 'IAM User and Role Access to Billing Information' and enable 'activate IAM access'

![Enable AIM users](images/1.png)

- Open AIM panel
![Enter to AIM management](images/2.png)

![Enter to AIM management2](images/3.png)

- Create admins group
![Group creation](images/group_creation.png)

- Put rights as AdministratorsAccess
![Rights to group](images/group_right_access.png)

У всего есть ARN идентификатор амазона, используется в ссылках на компоненты. вот у той группы которую создали. Тут цифра это ID аккаунта. 
![ARN for group](images/arn_for_group.png)

Создадим пользователя
![Create an user](images/create_user.png)

![Create an user](images/create_user_2.png)

![Create an user](images/create_user_3.png)

После создания пользователя будет показана ссылка, которую можно будет сохранить и использовать для логина. Потом нужно выйти из root account and then needs to log in by the previous link. After that regenerate a password and then you will be as a new user.

![Create an user](images/create_user_4.png)

## Generate secret key

if you log in as a user for whom you want to create a certificate

![Create security cred](images/security_cred.png)

![Create security cred](images/security_cred_2.png)

![Create security cred](images/security_cred_3.png)

Не рекомендуется создавать ключ доступа для root акаунта. Все ключи должны храниться в секретных местах. На той же странице можно настроить двухфакторную аутентификацию. Ключи нельзя посмотреть после, только отозвать и создать заново. 

it is possible to create certificate via IAM service on tabs Users for particular user.

![](images/iam_credentials_user.png)

## Billing
Зайти в Billing и выбрать.
![Billing prefs](images/billing_prefs.png)

Зайти во вкладку Budgets и создать бюджет при превышении которого будет отправляться оповещение

![budgets](images/budgets.png)

<!-- на этой же странице есть ссылка на Managed Billing Alerts. Откроется Cloud Watch сервис нотификаций амазона. В нем можно настроить мониторить сервисы, смотреть логи сервисов, а также настроить нотификации об оплате.  -->


другой способ, создать самому алерты

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

## Assuming AWS role

For example we create a new user without any access rights

![](images/iam_role_1.png)


![](images/iam_role_2.png)

then we need to get a ARN of a new user.

![](images/iam_role_3.png)

then we need to create a role

![](images/iam_role_4.png)

and put a custom policy where we paste a ARN of user

![](images/iam_role_5.png)

then click Next and put EC2AllAccess permisstion policy to the role

![](images/iam_role_6.png)

then click Next and add the name for the role and click next

![](images/iam_role_7.png)

role is created

![](images/iam_role_8.png)

then log in as a new created user

we can see that user do not have rights for ec2 access

![](images/iam_role_9.png)

but we can assume a role

![](images/iam_role_10.png)

to do it we need to know a id of account and name of the role

![](images/iam_role_11.png)

![](images/iam_role_12.png)


and finally we get the rights to ec2 from the role

![](images/iam_role_13.png)

it's possible to switch back

![](images/iam_role_14.png)


![](images/iam_role_15.png)


# EC2 (Elastic compute cloud)

EC2 was one of the first infrastructure-as-a-service **IaaS** products.

Amazon Machine Image - image with an operating system and configuration of the instance. 

You can create custom AMI. 

Benefits:
- Elasticity. launch to thousands of instances within minutes
- Full control the instances with root. 
- Flexible. Choice of instance types, operating systems and packages. 
- Reliable. high level of availablity and instances can be rapidly comissioned and replaced
- Secure. Fully integrated with VPS and security features.  
- Inexpensive. Pay for what you use

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

```bash
mv /mnt/c/Users/anton/Downloads/awsdemo.pem ~/.ssh

chmod 400 ~/.ssh/awsdemo.pem

ssh -i "~/.ssh/awsdemo.pem" ubuntu@ec2-54-157-214-250.compute-1.amazonaws.com
```

## Simple network rules

для проверки поставим apache сервер в инстанс
обновим индекс пакетов в vm
```bash
sudo apt-get update
sudo apt-get install apache2
```
потом попробуем подключиться из браузера на порт 80 по публичному dns имени, его можно найти в деталях инстанса
Затем зайдем в настройки security group и добавим доступ по 80 порту

![Add security rule to security group](images/security_group_1.png)

![Add security rule to security group](images/security_group_2.png)

![Add security rule to security group](images/security_group_3.png)

## Horizontal scalling via create another ec2 instance
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

## configure
```bash
aws configure
```
указать Access Key ID , AWS Secret Access Key далее регион, обычно us-east-1 формат json

for checking

```bash
aws iam get-user
```

output like this
```
{
  "User": {
    "Path": "/",
    "UserName": "book",
    "UserId": "AIDA111111111111111111",
    "Arn": "arn:aws:iam::181111111111:user/book",
    "CreateDate": "2019-10-21T20:27:05Z"
  }
}
```

> it is important to know that all keys are stored in the `.aws/credentials` file without any encryption. The region is stored in `.aws/config`.

it is possible to get errror
> An error occurred (RequestTimeTooSkewed) when calling the ListBuckets operation: The difference between the request time and the current time is too large.

I found it in wsl ubuntu. We need to sync time

```bash
sudo hwclock -s
```

it is possible to create many profiles on the same machine

```bash
aws configure --profile name_of_a_new_profile
```

then after that we can add different credentials for many profiles. All profiles are in `.aws/config` and `.aws/credentials`. 

after configuring it is possible to use profile with any command like this `aws command...... --profile %name_of_a_profile_to_use%`. without profile options the default profile is used. 

## help

to show list of all options
```bash
aws help
```

help about particular option

```bash
aws help ec2
```

## ec2 cli

```bash
aws ec2 describe-instances
```

info will be in json format.

## s3 cli

show list of s3 buckets
```bash
 aws s3api list-buckets
```
![cli S3](images/aws_cli_1.png)

list of all buckets
```bash
aws s3 ls
```

![cli S3](images/aws_cli_2.png)

create a bucket

```bash
aws s3 mb s3://mytestbucket-323423dsdfl
```

copy file to s3

```bash
aws s3 cp ./file.txt s3://tests355465646546/folder_3/
```

![cli S3](images/aws_cli_3.png)


to show a list of files in bucket

```bash
aws s3 ls s3://mytestbucket-323423dsdfl
```

to remove a bucket. But only for an empty bucket

```bash
aws s2 rb s3://mytestbucket-323423dsdfl
```

to forced remove a bucket 

```bash
aws s2 rb s3://mytestbucket-323423dsdfl --force
```

## assuming a role

to `.aws/config` add this

```
[profile my_profile]
  role_arn = %arn_of_role%
  source_profile = default
```

and then use this profile to assume a role

```bash
aws ec2 describe-instances --profile my_profile
```

# AWS SAM CLI

## Installation

```bash
curl "https://github.com/aws/aws-sam-cli/releases/latest/download/aws-sam-cli-linux-x86_64.zip" -o "aws-sam-cli.zip"
unzip aws-sam-cli.zip -d sam-installation
sudo ./aws/install
sam --version
```


# Networking

![](images/networking_1.png)


### VPS (Virtual private cloud)

**VPS** is a logically isolated portion of the AWS cloud within a region. A virtual network dedicated to AWS account. 

Each of VPSs has a different block of IP addresses (**CIDR** block) (Classless inter-domain routing)

When we create a VPS we must specify a range of IPv4 adresses for the VPSs in the form of CIDR block for example 10.0.0.0/16. A default VPS is created in each region with subnet in each AZ.

VPS spans all the AZ in the region. 

You have full controll over who access to the AWS resources inside your VPS

We can create diffrent VPS within a region. There is a default limit 5 to an amount of VPSs in one region but it's possible to apply to extend it. 

![](images/networking_2.png)

### availiablity zones

Within a region there are **availiablity zones** (AZ). This is physically isolated area like a datacenter. 

### Subnets 

Within AV there are **subnets**. They can be public or private. 

It is not possible to create a subnet across many AZ. But you can spread load on different AZ and subnets within them. 

Each subnets has block of IP addresses from the CIDR block

We can launch our resources (for example EC2 instance) in a subnets of our vps. 

### Routing accross VPS and outside

**VPS router** takes care or routing within the VPS and outside of the VPS. It is attached to the VPS. We can add rules to **route table**. It is possible to create a route to traffic across different VPSs without using public Internet. 

### Internet access 

If we want to connect to Internet we need to configure **Internet Gateway** OR **Egress only Internet Gateway** for IPV6. It is attached to the VPS. This thing allow to get a connection to the Internet, but does not allows connection from Internet. 

### Connect to the public AWS endpoint 

**VPS endpont** to connect to public AWS endpoints via private addresses. For example to connecto to S3 bucket, that is a public AWS endpoint. 

### NAT for private subnets

**NAT Instance** and **NAT Gateway** Allow instances in private subnets wich only have private IP addresses to be able to connect to the Internet. Network adress translation. 

### connect on-premises data center

If we want to set up VPN between on-premises data center and AWS we can create AWS VPN. There are two principal components to VPN : **Customer gateway** which is router and configuration in the on-premices data center. And then **Virtual Private Gateway** which is component one the AWS side. 

**AWS Direct Connect** is another way to connect on-premices data centers to AWS. Is uses private connection with high speed and bandwidth and low latency.

### Firewall

**Security groups** and **network ACL** are two different types of firewalls. 

![](images/networking_3.png)


ACL apply at the subnet level. They attached to each subnet. They apply only to traffic entering/exiting the subnet. They don't apply to traffic within the subnet. This is only engress and ingress traffic. 

ACL has inbound and outbound rules. There are a allow and deny rules. The rules are processed in order. So if the allow is found the the traffic is allowed. If not then eventually it will reach the deny at the end of rule set and the traffic will be denied. 

![](images/networking_5.png)

Security group are applied at the instance level. Actually they're applied to the Elastic Network Interfaces that are attached to any of EC2 instances. 

SG can be applied to many subnets. 


SG rules are defined for outbound traffic and inbound traffic. SG support only allow rules not a deny rule. 

SG source can be an IP address or SG ID

![](images/networking_4.png)

SG is statefull. If the traffic is allowed out, outbound. Any return traffic comming in will automatically be allowed if it's assotiated with the same connection. 
Whereas ACL is stateless. You need separate rule for outbound and the return traffic that's comming back inbound. 

### Examples

Let'c create VPS then two public and two private subnets in different availability zones. For private we will create route tables for our VPS attach them to our private and public subnets. 

We can see a default VPS which had been already created.

![](images/network_example_1.png)

let's create our new VPS.

![](images/network_example_2.png)

![](images/network_example_3.png)

then let's enable dns host names to enable dns hosts for any ec2 instances within this vps

> The DNS hostnames attribute determines whether instances launched in the VPC receive public DNS hostnames that correspond to their public IP addresses.

![](images/network_example_4.png)

![](images/network_example_5.png)

then create subnets

![](images/network_example_6.png)

here we can see default subnets for each AZ in a region

![](images/network_example_7.png)

![](images/network_example_8.png)

![](images/network_example_9.png)

![](images/network_example_10.png)

![](images/network_example_11.png)

![](images/network_example_12.png)

then let's enable public ip addresses for our public networks

> By default, nondefault subnets have the IPv4 public addressing attribute set to false, and default subnets have this attribute set to true
> An exception is a nondefault subnet created by the Amazon EC2 launch instance wizard — the wizard sets the attribute to true.

![](images/network_example_13.png)

![](images/network_example_14.png)

then let's create route tables for our subnets. Private-RT for privates and MAIN for publics.

![](images/network_example_15.png)

![](images/network_example_16.png)

![](images/network_example_17.png)

![](images/network_example_18.png)

for public network we already have a default route table. Let's just rename it to MAIN

![](images/network_example_19.png)

we can see that our public networks assotiates with MAIN network implicitly

![](images/network_example_20.png)

then let's create Internet Gateway for our public networks to have access from the public networks to the Internet. 

![](images/network_example_21.png)

![](images/network_example_22.png)

![](images/network_example_23.png)

![](images/network_example_24.png)

then we need to edit our MAIN route tables for public subnets to add a rule to access via created Internet Gateway to the Internet. 

![](images/network_example_25.png)

![](images/network_example_26.png)


# Load balancing
ELB - Elastic load balancer

# Serverless

All three of these ideas—`IaaS` (EC2 + S3 and etc), `PaaS` (Heroku.. etc), and `CaaS` (EKS with Kubernates etc) —can be grouped as compute as a service; in other words, they are different types of generic environments that we can run our own specialized software in. 

PaaS and CasS differ from IaaS by raising the level of abstraction further, allowing us to hand off more of our “heavy lifting” to others.

Serverless is the next evolution of cloud computing and can be divided into two ideas: backend as a service and functions as a service.

## BaaS (Backend as a service)
Backend as a service (`BaaS`) allows us to replace server-side components that we code and/or manage ourselves with off-the-shelf services. It’s closer in concept to software as a service (SaaS) than it is to things like virtual instances and containers. SaaS is typically about outsourcing business processes, though—think HR or sales tools or, on the technical side, products like GitHub—whereas with BaaS, we’re breaking up our applications into smaller pieces and implementing some of those pieces entirely with externally hosted products.

Example of BaaS:
- AWS Cognito. For authentication and user management
- Google Firebase. Database

## FaaS (Function as a service)

The other half of serverless is functions as a service (FaaS). FaaS, like IaaS, PaaS, and CaaS, is another form of compute as a service—a generic environment within which we can run our own software. Some people like to use the term serverless compute instead of FaaS.

With FaaS we deploy our code as independent functions or operations, and we configure those functions to be called, or triggered, when a specific event or request occurs within the FaaS platform. The platform itself calls our functions by instantiating a dedicated environment for each event—this environment consists of an ephemeral, fully managed lightweight virtual machine, or container; the FaaS runtime; and our code.

The functions are not constantly active in an application process,

Once the function has finished executing, the FaaS platform is free to tear it down. Alternatively, as an optimization, it may keep the function around for a little while until there’s another event to be processed.


## AWS Lambda

AWS Lambda was launched in 2014

Lambda implements the FaaS pattern by instantiating ephemeral, managed, Linux environments to host each of our function instances. Lambda guarantees that only one event is processed per environment at a time. 

Lambda also requires that the function completes processing of the event within 15 minutes; otherwise, the execution is aborted.

Since we are fully abstracted from the underlying host with Lambda, we can’t specify a number or type of underlying EC2 instances to use. Instead, we specify how much RAM our function requires (up to a maximum of 3GB), and other aspects of performance are tied to this too. 

If a particular data center/Availability Zone fails, then Lambda will automatically start environments in a different AZ in the same region.

## How lambda can be invoked

- Lambda functions can be called synchronously—named **RequestResponse** by AWS. In this scenario, an upstream component calls the Lambda function and waits for whatever response the Lambda function generates.

- Lambda function may be invoked asynchronously—named **Event** by AWS. This time the request from the upstream caller is responded to immediately by the Lambda platform, while the Lambda function proceeds with processing the request. No further response is returned to the caller in this scenario.

## Examples

### Web API

 While Lambda functions aren’t HTTP servers themselves, we can use another AWS component, API Gateway, to provide the HTTP protocol and routing logic

PI Gateway will invoke the Lambda function synchronously and will wait for the function to evaluate the request and return a response.

 ![](images/lambda_web_api_1.png)

 ### File processing

S3 can be configured to invoke the Lambda platform when the file is uploaded, specifying the function to be called, and passing a path to the file. As with the previous example, the Lambda platform then instantiates the Lambda function and calls it with the request details passed this time by S3. The difference now, though, is that this is an asynchronous invocation (S3 specified the Event invocation type)—no value is returned to S3 nor does S3 wait for a return value.

 ![](images/lambda_file_processing_1.png)

 ## Other

 - We can build message-processing applications, using message buses like Simple Notification Service (SNS), Simple Queue Service (SQS), EventBridge, or Kinesis as the event source.
 - We can build email-processing applications, using Simple Email Service (SES) as the event source
 - We can build scheduled-task applications, similar to cron programs, using CloudWatch Scheduled Events as the trigger.

## First Java example (compile and deploy via SAM)

- this class in simple maven project

```java
package book;

public class HelloWorld {
    public String handler(String s) {
        return "Hello, " + s;
    }
}
```
- `pom.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>my.groupId</groupId>
  <artifactId>HelloWorldLambdaJava</artifactId>
  <version>1.0-SNAPSHOT</version>

  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <build>
    <plugins>
      <plugin>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.2.1</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <finalName>lambda</finalName>
        </configuration>
      </plugin>
    </plugins>
  </build>

</project>
```
- `template.yml` Artifact to deploy jar file in aws lambda
```yml
AWSTemplateFormatVersion: 2010-09-09
Transform: AWS::Serverless-2016-10-31
Description: HelloWorldLambdaJava

Resources:

  HelloWorldLambda:
    Type: AWS::Serverless::Function
    Properties:
      Runtime: java8
      MemorySize: 512
      Handler: book.HelloWorld::handler # package class and method to invoke
      CodeUri: target/lambda.jar        # path to jar file where class is
```

- structure of project (just simple java maven project)
![](images/lambda_java_example_1.png)

- build project via simple `mvn clear package`
- create s3 bucket to uploading jar file

```bash
aws s3 mb s3://some_unique_name
```
![](images/lambda_java_example_2.png)

- change directory where `template.yml` file is inside 
- upload via sam compiled jar
  ```bash
   sam deploy \
  --s3-bucket tests465465465465 \
  --stack-name HelloWorldLambdaJava \
  --capabilities CAPABILITY_IAM
  ```

![](images/lambda_java_example_3.png)

- then open AWS Lambda web interface
![](images/lambda_java_example_4.png)

![](images/lambda_java_example_5.png)

![](images/lambda_java_example_6.png)

![](images/lambda_java_example_7.png)

- clear lambda 

```bash
aws cloudformation delete-stack --stack-name HelloWorldLambdaJava
```

## Invoke lambda via AWS CLI

- Edit an example above by adding `FunctionName`

```yml
AWSTemplateFormatVersion: 2010-09-09
Transform: AWS::Serverless-2016-10-31
Description: HelloWorldLambdaJava

Resources:

  HelloWorldLambda:
    Type: AWS::Serverless::Function
    Properties:
      FunctionName: HelloWorldJava
      Runtime: java8
      MemorySize: 512
      Handler: book.HelloWorld::handler 
      CodeUri: target/lambda.jar
```      

- deploy function 
- invoke lambda via cli

where `payload` is a Base64 String

```bash
 aws lambda invoke --invocation-type RequestResponse --function-name HelloWorldJava --payload IkhlbGxvIg== outputfile.txt
```

- result will be in `outputfile.txt`

if we changed as ``--invocation-type Event ``  we will get 202 Status "Accepted".

## Example with async lambda invocatoin and writing to log

- change example above

```java
public class HelloWorld {
        public void handler(String s) {

            System.out.println("Hello, " + s);
        }
}
```
- deploy with `sam`

  ```bash
   sam deploy \
  --s3-bucket tests465465465465 \
  --stack-name HelloWorldLambdaJava \
  --capabilities CAPABILITY_IAM
  ```

- invoke via cli

```bash
aws lambda invoke   --invocation-type Event --function-name HelloWorldJava   --payload IkhlbGxvIg== outputfile.txt
```

- open cloud watch logs

![](images/lambda_example_cloud_watch_1.png)

- open latest log stream

![](images/lambda_example_cloud_watch_2.png)

- find hello in logs

![](images/lambda_example_cloud_watch_3.png)


## The Lambda Execution Environment

![](images/lambda_env_1.png)

A lambda function is executed whenever the `invoke` command of the `AWS Lambda API` is called. 

This happens at the following times:
- When a function is triggered by an event source
- When you use the test harness in the web console
- When you call the Lambda API invoke command yourself, typically via the CLI or SDK, from your own code or scripts

After that:
- `Lambda service` will create a `host Linux environment`
- Lambda will start a language runtime within it. In our case a JVM. The JVM is started with a set of environment flags that we can’t change
- Starting `Lambda Java Runtime`, such as aws java application server. It is responsible for top-level error handling, logging, and more.

## Lambda Function Method Signatures

- `output-type handler-name(input-type input)`
- `output-type handler-name(input-type input, Context context)`
- `void handler-name(InputStream is, OutputStream os)`
- `void handler-name(InputStream is, OutputStream os, Context context)`

where:

- `output-type` can be `void`, a Java primitive, or a JSON-serializable type.
- `input-type` is a Java primitive, or a JSON-serializable type.
- `Context` refers to `com.amazonaws.services.lambda.runtime.Context` 
- `InputStream` and `OutputStream` refer to the types with those names in the `java.io` package.
- `handler-name` can be any valid Java method name, and we refer to it in our application’s configuration.

- Java Lambda methods can be either instance methods or static methods, but must be public.
- A class containing a Lambda function cannot be abstract and must have a no-argument constructor—either the default constructor (i.e., no constructor specified)
- You are not required to implement any interfaces or base classes, although you may do so if you desire. AWS provides a `RequestHandler` interface if you want to be very explicit about the type of your Lambda classes
- You may have multiple Lambda functions defined in one class with different names, but we don’t usually recommend this style

### Example with basic types

- for `true`, `false`, `"true"`, or `"false"`
- for `5` or `"5"`
```java
package book;

public class StringIntegerBooleanLambda {
  public void handlerString(String s) {
    System.out.println("Hello, " + s);
  }

  public boolean handlerBoolean(boolean input) {
    return !input;
  }

  public boolean handlerInt(int input) {
    return input > 100;
  }
}
```

### Lists and Maps

```java
package book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ListMapLambda {


// [ 1, 2, 3 ]  output [ 101, 102, 103 ]

  public List<Integer> handlerList(List<Integer> input) {
    List<Integer> newList = new ArrayList<>();
    input.forEach(x -> newList.add(100 + x));
    return newList;
  }

  // { "a" : "x", "b" : "y"}  output { "New Map → a" : "x", "New Map → b" : "y" }

  public Map<String,String> handlerMap(Map<String,String> input) {
    Map<String, String> newMap = new HashMap<>();
    input.forEach((k, v) -> newMap.put("New Map -> " + k, v));
    return newMap;
  }

/*
[
  { "m" : 1, "n" : 2 },
  { "x" : 8, "y" : 9 }
]
*/

/* Output
{
  "Nested at position 0": { "m" : 1, "n" : 2},
  "Nested at position 1": { "x": 8, "y" : 9}
}
*/
  public Map<String,Map<String, Integer>> handlerNestedCollection(List<Map<String, Integer>> input) {
    Map<String, Map<String, Integer>> newMap = new HashMap<>();
    IntStream.range(0, input.size())
          .forEach(i -> newMap.put("Nested at position " + i, input.get(i)));
    return newMap;
  }
}
```

### POJO in lambdas

- POJO input classes can be static nested classes or regular (outer) classes. 
- they need to have an empty constructor and have field setters that follow the naming of the expected fields to be deserialized from the input JSON. 
- If no JSON field is found with the same name as a setter, then the POJO field will be left null. 
- Input POJO objects need to be mutable since the runtime will modify them after they’ve been instantiated

- There are fewer limitations on POJO output classes—since they are not created or mutated by the Lambda runtime, you are free to construct them as you please and free to make them immutable.
-  Like input classes, POJO output classes can be static nested classes or regular (outer) classes.

```java
package book;


// { "a" : "Hello Lambda" }  output { "b" : "Input was Hello Lambda" }

public class PojoLambda {
  public PojoResponse handlerPojo(PojoInput input) {
    return new PojoResponse("Input was " + input.getA());
  }

  public static class PojoInput {
    private String a;

    public String getA() {
      return a;
    }

    public void setA(String a) {
      this.a = a;
    }
  }

  public static class PojoResponse {
    private final String b;

    PojoResponse(String b) {
      this.b = b;
    }

    public String getB() {
      return b;
    }
  }
}
```

```java
package book;

public class PojoLambda {
  public PojoResponse handlerPojo(PojoInput input) {
    return new PojoResponse("Input was " + input.c);
  }

  public static class PojoInput {
    public String c;
  }

  public static class PojoResponse {
    public final String d;

    PojoResponse(String d) {
      this.d = d;
    }
  }
}
```

One of the main uses for POJO input deserialization is when you tie your Lambda function to one of the AWS ecosystem Lambda event sources.

```java
public void handler(S3Event input) {
  // …
}
```

### Streams

```java
package book;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamLambda {
  public void handlerStream(InputStream inputStream, OutputStream outputStream) throws IOException {
    int letter;
    while((letter = inputStream.read()) != -1)
    {
      outputStream.write(Character.toUpperCase(letter));
    }
  }
}
```

### Context

```com.amazonaws.services.lambda.runtime.Context```


[Context documentation](https://docs.aws.amazon.com/lambda/latest/dg/java-context.html)

```java
package book;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.HashMap;
import java.util.Map;

public class ContextLambda {
  public Map<String,Object> handler (Object input, Context context) {
    Map<String, Object> toReturn = new HashMap<>();
    toReturn.put("getMemoryLimitInMB", context.getMemoryLimitInMB() + "");
    toReturn.put("getFunctionName",context.getFunctionName());
    toReturn.put("getFunctionVersion",context.getFunctionVersion());
    toReturn.put("getInvokedFunctionArn",context.getInvokedFunctionArn());
    toReturn.put("getAwsRequestId",context.getAwsRequestId());
    toReturn.put("getLogStreamName",context.getLogStreamName());
    toReturn.put("getLogGroupName",context.getLogGroupName());
    toReturn.put("getClientContext",context.getClientContext());
    toReturn.put("getIdentity",context.getIdentity());
    toReturn.put("getRemainingTimeInMillis",
                   context.getRemainingTimeInMillis() + "");
    return toReturn;
  }
}
```

```xml
<dependencies>
  <dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-lambda-java-core</artifactId>
    <version>1.2.0</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

output 
```json
{
  "getFunctionName": "ContextLambda",
  "getLogStreamName": "2019/07/24/[$LATEST]0f1b1111111111111111111111111111",
  "getInvokedFunctionArn":
    "arn:aws:lambda:us-west-2:181111111111:function:ContextLambda",
  "getIdentity": {
    "identityId": "",
    "identityPoolId": ""
  },
  "getRemainingTimeInMillis": "2967",
  "getLogGroupName": "/aws/lambda/ContextLambda",
  "getLogger": {},
  "getFunctionVersion": "$LATEST",
  "getMemoryLimitInMB": "512",
  "getClientContext": null,
  "getAwsRequestId": "2108d0a2-a271-11e8-8e33-cdbf63de49d2"
}
```

## Timeout

- You are able to specify this timeout when you create the function
- you can update it later in the function’s configuration.
- maximum timeout is 15 minutes. For a long time the maximum timeout was 5 minutes.
- it defaults to 3 seconds
- the timeout period is not started during the cold start of a function 

```yml
AWSTemplateFormatVersion: 2010-09-09
Transform: AWS::Serverless-2016-10-31
Description: HelloWorldLambdaJava

Resources:

  HelloWorldLambda:
    Type: AWS::Serverless::Function
    Properties:
      FunctionName: TimeoutLambda
      Timeout: 2 # 2s 
      Runtime: java8
      MemorySize: 512 # Mb
      Handler: book.TimeoutLambda::handler 
      CodeUri: target/lambda.jar
```      

```java
package book;

import com.amazonaws.services.lambda.runtime.Context;

public class TimeoutLambda {
  public void handler (Object input, Context context) throws InterruptedException {
    while(true) {
      Thread.sleep(100);
      System.out.println("Context.getRemainingTimeInMillis() : " +
        context.getRemainingTimeInMillis());
    }
  }
}
```

![](images/lambda_timeout_1.png)

```log
2023-02-12T23:45:18.725+01:00	INIT_START Runtime Version: java:8.v14 Runtime Version ARN: arn:aws:lambda:eu-north-1::runtime:976f6b03f8ebcf9a902c3d59a05ba4b7c260b2841a5a10b307bb8bbd15e34a03
2023-02-12T23:45:19.219+01:00	START RequestId: 2fee9e4c-4466-4b68-8f9d-e40bcd8b5015 Version: $LATEST
2023-02-12T23:45:19.370+01:00	Context.getRemainingTimeInMillis() : 1849
2023-02-12T23:45:19.470+01:00	Context.getRemainingTimeInMillis() : 1748
2023-02-12T23:45:19.570+01:00	Context.getRemainingTimeInMillis() : 1648
2023-02-12T23:45:19.670+01:00	Context.getRemainingTimeInMillis() : 1548
2023-02-12T23:45:19.771+01:00	Context.getRemainingTimeInMillis() : 1448
2023-02-12T23:45:19.871+01:00	Context.getRemainingTimeInMillis() : 1347
2023-02-12T23:45:19.971+01:00	Context.getRemainingTimeInMillis() : 1247
2023-02-12T23:45:20.071+01:00	Context.getRemainingTimeInMillis() : 1147
2023-02-12T23:45:20.171+01:00	Context.getRemainingTimeInMillis() : 1047
2023-02-12T23:45:20.272+01:00	Context.getRemainingTimeInMillis() : 947
2023-02-12T23:45:20.372+01:00	Context.getRemainingTimeInMillis() : 846
2023-02-12T23:45:20.472+01:00	Context.getRemainingTimeInMillis() : 746
2023-02-12T23:45:20.572+01:00	Context.getRemainingTimeInMillis() : 646
2023-02-12T23:45:20.672+01:00	Context.getRemainingTimeInMillis() : 546
2023-02-12T23:45:20.773+01:00	Context.getRemainingTimeInMillis() : 445
2023-02-12T23:45:20.873+01:00	Context.getRemainingTimeInMillis() : 345
2023-02-12T23:45:20.973+01:00	Context.getRemainingTimeInMillis() : 245
2023-02-12T23:45:21.073+01:00	Context.getRemainingTimeInMillis() : 145
2023-02-12T23:45:21.174+01:00	Context.getRemainingTimeInMillis() : 45
2023-02-12T23:45:21.224+01:00	2023-02-12T22:45:21.223Z 2fee9e4c-4466-4b68-8f9d-e40bcd8b5015 Task timed out after 2.00 seconds
2023-02-12T23:45:21.224+01:00	END RequestId: 2fee9e4c-4466-4b68-8f9d-e40bcd8b5015
2023-02-12T23:45:21.224+01:00	REPORT RequestId: 2fee9e4c-4466-4b68-8f9d-e40bcd8b5015 Duration: 2004.97 ms Billed Duration: 2000 ms Memory Size: 512 MB Max Memory Used: 72 MB Init Duration: 492.71 ms
2023-02-12T23:45:21.317+01:00	INIT_START Runtime Version: java:8.v14 Runtime Version ARN: arn:aws:lambda:eu-north-1::runtime:976f6b03f8ebcf9a902c3d59a05ba4b7c260b2841a5a10b307bb8bbd15e34a03
```

## Memory and CPU

`memory-size` can be as small as 64MB, although for Java Lambda functions you should probably use at least 256MB. memory-size must be a multiple of 64MB.

A very important thing to know is that the memory-size setting is not just for how much RAM your function can use—it also specifies how much CPU power you get. In fact, a Lambda function’s CPU power scales linearly from 64MB up to 1792MB. Therefore a Lambda function configured with 1024MB of RAM has twice the CPU power of one with 512MB of RAM.

AWS charges for Lambda functions by two primary factors:
- How long a function runs, rounded up to the nearest 100 ms
- How much memory a function is specified to use

In other words, given the same execution duration, a Lambda function that has 2GB of RAM costs twice as much to execute as one with 1GB of RAM. Or, one with 512MB of RAM costs 17% of one with 3008MB. This, at scale, could be a big difference.

### Example pricing

First, let’s think back to the photo resizer  Let’s say that we set that function to use 1.5GB RAM, it takes on average 10 seconds to run, and it processes 10,000 photos per day. Lambda pricing consists of two parts—request pricing, which is $0.20 per million requests, and duration pricing, which is $0.0000166667 per gigabyte-second. Therefore we need to calculate both parts to estimate cost for our photo resizer:

- The request cost is `$0.20 × .01 = $0.002/day`, or `$0.06/month`.
- The duration cost is `10 (seconds/invocation) × 10,000 (invocations) × 1.5 (GB) × $0.0000166667 = $2.50/day`, or `$75/month`.

Obviously the duration cost is the vast majority here.

$75/month is about the same cost as a “m5.large” EC2 instance—which is $70/month. An m5.large EC2 instance is the smallest size VM in the m5 “general purpose” family; it has 8GB RAM and two CPUs, so it would likely be about right as an alternative to host our photo resizer. However, Lambda has significant benefits as a solution, even though the costs appear at first glance about the same:

- Lambda doesn’t require the operations cost of managing an EC2 instance—there’s no need to think about operating system patches, user management, etc. Therefore our total cost of ownership (TCO) is lower for Lambda.
- Lambda already manages the “event driven” nature of the application, so we don’t need to build that into the version we would run on a regular server.
- Lambda will auto-scale without effort and so will handle, without concern, any spikes in traffic. A server-based solution may become overloaded or need to be built to include buffering. In fact, the more “spikey” your application’s load, the more cost effective Lambda is as a solution.
- Lambda is already highly available across AZs—to guarantee that availability with a server-based solution, we would need to double or triple our costs for two or three zones of availability.

Now let’s look back to our web API. Let’s say we set the web API Lambda functions to use 512MB RAM and each invocation takes no more than 100 ms to run. Let’s say the API processes on average 10 requests per second (864,000 requests/day) but can peak up to 100 requests per second.

- The request cost is `$0.20 × 0.864 = $0.17/day`, or `$5.18/month`.
- The duration cost is `0.1 × 864,000 × 0.5 × $0.0000166667 = $0.72/day`, or `$21.60/month`.

In other words, we need to spend $27/month to handle 10 requests/second average, and this system could happily could peak to 10x that rate, without breaking a sweat (or increasing the costs).

## Environment Variables

```java
package book;

public class EnvVarLambda {
  public void handler(Object event) {
    String databaseUrl = System.getenv("DATABASE_URL");
    if (databaseUrl == null || databaseUrl.isEmpty())
      System.out.println("DATABASE_URL is not set");
    else
      System.out.println("DATABASE_URL is set to: " + databaseUrl);
  }
}
```

```yml
HelloWorldLambda:
  Type: AWS::Serverless::Function
  Properties:
    FunctionName: HelloWorldJava
    Runtime: java8
    MemorySize: 512
    Handler: book.EnvVarLambda::handler
    CodeUri: target/lambda.jar
    Environment:
      Variables:
        DATABASE_URL: my-database-url
```        

## Spring cloud functions

### Main idea.

We can write class that implements `Function` `Consumer` `Supplier` and do not rewrite when we use another cloud provider, but only if you do not use specific class from cloud provider dependencies like `Context` from AWS. It works with class with one methods, it is not mandatory to implement standart interfaces but there are options and problems with it.

### documentations and examples

- [Spring cloud function docs](https://docs.spring.io/spring-cloud-function/docs/current/reference/html/aws.html#_introduction)
- [my projects for exepiments](https://github.com/antonovdmitriy/learning-aws-lambda-springboot)


### pom and dependencies for aws and spring cloud functions

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>learning-aws-lambdas-springboot</artifactId>
    <version>1.0.1</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.9</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <wrapper.version>1.0.27.RELEASE</wrapper.version>
        <aws-lambda-events.version>3.9.0</aws-lambda-events.version>
        <spring-cloud-function.version>3.2.9</spring-cloud-function.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-deploy-plugin</artifactId>
                <configuration>
                    <skip>true</skip>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.boot.experimental</groupId>
                        <artifactId>spring-boot-thin-layout</artifactId>
                        <version>${wrapper.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <configuration>
                    <createDependencyReducedPom>false</createDependencyReducedPom>
                    <shadedArtifactAttached>true</shadedArtifactAttached>
                    <shadedClassifierName>aws</shadedClassifierName>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <distributionManagement>
        <repository>
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/antonovdmitriy/learning-aws-lambdas-springboot</url>
        </repository>
    </distributionManagement>


    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-function-dependencies</artifactId>
                <version>${spring-cloud-function.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>


    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-function-adapter-aws</artifactId>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-lambda-java-events</artifactId>
            <version>${aws-lambda-events.version}</version>
        </dependency>
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-lambda-java-core</artifactId>
            <version>1.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

### Internals

For handler methods in `template.yml` we put link to `org.springframework.cloud.function.adapter.aws.FunctionInvoker` like this

```yml
  AsyncHelloWorldLambdaSpringBoot:
    Type: AWS::Serverless::Function
    Properties:
      Runtime: java11
      FunctionName: AsyncHelloWorldLambdaSpringBoot
      MemorySize: 512
      ## This path to lambda to invoke
      Handler: org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest
      CodeUri: target/learning-aws-lambdas-springboot-1.0.1-aws.jar
      Environment:
        Variables:
          SPRING_CLOUD_FUNCTION_DEFINITION: "asyncHelloWorld"
```

source of `FunctionInvoker`

```java
/*
 * Copyright 2019-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.function.adapter.aws;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.FunctionProperties;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.cloud.function.context.catalog.SimpleFunctionRegistry.FunctionInvocationWrapper;
import org.springframework.cloud.function.context.config.RoutingFunction;
import org.springframework.cloud.function.json.JacksonMapper;
import org.springframework.cloud.function.json.JsonMapper;
import org.springframework.cloud.function.utils.FunctionClassUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author Oleg Zhurakousky
 * @since 3.1
 *
 *        see
 *        https://docs.aws.amazon.com/apigateway/latest/developerguide/set-up-lambda-proxy-integrations.html#api-gateway-simple-proxy-for-lambda-output-format
 */
public class FunctionInvoker implements RequestStreamHandler {

	private static Log logger = LogFactory.getLog(FunctionInvoker.class);

	private JsonMapper jsonMapper;

	private FunctionInvocationWrapper function;

	private volatile String functionDefinition;

	public FunctionInvoker(String functionDefinition) {
		this.functionDefinition = functionDefinition;
		this.start();
	}

	public FunctionInvoker() {
		this(null);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		Message requestMessage = AWSLambdaUtils
				.generateMessage(StreamUtils.copyToByteArray(input), this.function.getInputType(), this.function.isSupplier(), jsonMapper, context);

		Object response = this.function.apply(requestMessage);
		byte[] responseBytes = this.buildResult(requestMessage, response);
		StreamUtils.copy(responseBytes, output);
		// any exception should propagate
	}

	@SuppressWarnings("unchecked")
	private byte[] buildResult(Message<?> requestMessage, Object output) throws IOException {
		Message<byte[]> responseMessage = null;
		if (output instanceof Publisher<?>) {
			List<Object> result = new ArrayList<>();
			for (Object value : Flux.from((Publisher<?>) output).toIterable()) {
				if (logger.isDebugEnabled()) {
					logger.debug("Response value: " + value);
				}
				result.add(value);
			}
			if (result.size() > 1) {
				output = result;
			}
			else if (result.size() == 1) {
				output = result.get(0);
			}
			else {
				output = null;
			}
			if (output != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("OUTPUT: " + output + " - " + output.getClass().getName());
				}
				byte[] payload = this.jsonMapper.toJson(output);
				responseMessage = MessageBuilder.withPayload(payload).build();
			}
		}
		else {
			responseMessage = (Message<byte[]>) output;
		}
		return AWSLambdaUtils.generateOutput(requestMessage, responseMessage, this.jsonMapper, function.getOutputType());
	}

	private void start() {
		Class<?> startClass = FunctionClassUtils.getStartClass();
		String[] properties = new String[] {"--spring.cloud.function.web.export.enabled=false", "--spring.main.web-application-type=none"};
		ConfigurableApplicationContext context = ApplicationContextInitializer.class.isAssignableFrom(startClass)
				? FunctionalSpringApplication.run(new Class[] {startClass, AWSCompanionAutoConfiguration.class}, properties)
						: SpringApplication.run(new Class[] {startClass, AWSCompanionAutoConfiguration.class}, properties);

		Environment environment = context.getEnvironment();
		if (!StringUtils.hasText(this.functionDefinition)) {
			this.functionDefinition = environment.getProperty(FunctionProperties.FUNCTION_DEFINITION);
		}

		FunctionCatalog functionCatalog = context.getBean(FunctionCatalog.class);
		this.jsonMapper = context.getBean(JsonMapper.class);
		if (this.jsonMapper instanceof JacksonMapper) {
			((JacksonMapper) this.jsonMapper).configureObjectMapper(objectMapper -> {
				if (!objectMapper.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)) {
					SimpleModule module = new SimpleModule();
					module.addDeserializer(Date.class, new JsonDeserializer<Date>() {
						@Override
						public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
								throws IOException {
							Calendar calendar = Calendar.getInstance();
							calendar.setTimeInMillis(jsonParser.getValueAsLong());
							return calendar.getTime();
						}
					});
					objectMapper.registerModule(module);
					objectMapper.registerModule(new JodaModule());
					objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
				}
			});
		}

		if (logger.isInfoEnabled()) {
			logger.info("Locating function: '" + this.functionDefinition + "'");
		}

		this.function = functionCatalog.lookup(this.functionDefinition, "application/json");

		if (this.function == null) {
			if (logger.isInfoEnabled()) {
				if (!StringUtils.hasText(this.functionDefinition)) {
					logger.info("Failed to determine default function. Please use 'spring.cloud.function.definition' property "
							+ "or pass function definition as a constructir argument to this FunctionInvoker");
				}
				Set<String> names = functionCatalog.getNames(null);
				if (names.size() == 1) {
					logger.info("Will default to RoutingFunction, since it is the only function available in FunctionCatalog."
							+ "Expecting 'spring.cloud.function.definition' or 'spring.cloud.function.routing-expression' as Message headers. "
							+ "If invocation is over API Gateway, Message headers can be provided as HTTP headers.");
				}
				else {
					logger.info("More then one function is available in FunctionCatalog. " + names
							+ " Will default to RoutingFunction, "
							+ "Expecting 'spring.cloud.function.definition' or 'spring.cloud.function.routing-expression' as Message headers. "
							+ "If invocation is over API Gateway, Message headers can be provided as HTTP headers.");
				}
			}
			this.function = functionCatalog.lookup(RoutingFunction.FUNCTION_NAME, "application/json");
		}

		if (this.function.isOutputTypePublisher()) {
			this.function.setSkipOutputConversion(true);
		}
		Assert.notNull(this.function, "Failed to lookup function " + this.functionDefinition);

		this.functionDefinition = this.function.getFunctionDefinition();
		if (logger.isInfoEnabled()) {
			logger.info("Located function: '" + this.functionDefinition + "'");
		}
	}
}
```

in `start()` method which is invoked in constuctor there is an attempt to find a function in spring context. A property `spring.cloud.function.definition` or env variable `SPRING_CLOUD_FUNCTION_DEFINITION` is used for resolve a function name. The bean of spring clound function dependency `functionCatalog` is used to search a function after resolving function definition. 

```java
this.function = functionCatalog.lookup(this.functionDefinition, "application/json")
```

when function is found `functionInvoker` invokes it with a `Message` argument then get a result of invocation and write result as byte array to outputstream.

```java
	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		Message requestMessage = AWSLambdaUtils
				.generateMessage(StreamUtils.copyToByteArray(input), this.function.getInputType(), this.function.isSupplier(), jsonMapper, context);

		Object response = this.function.apply(requestMessage);
		byte[] responseBytes = this.buildResult(requestMessage, response);
		StreamUtils.copy(responseBytes, output);
		// any exception should propagate
	}
```

There is some restrinctions. While we use just function and aws handler we can get `OutputStream` in our funcion. In Spring cloud fuction we do not have this opportunity.

While function invoker generates `Message` it puts headers map to it. It's possible to get `Message` and retrieve specific amazon object from it. There is static method `generateMessage` in class `AWSLambdaUtils` 

```java
	public static Message<byte[]> generateMessage(byte[] payload, Type inputType, boolean isSupplier, JsonMapper jsonMapper, Context context) {
		if (logger.isInfoEnabled()) {
			logger.info("Received: " + new String(payload, StandardCharsets.UTF_8));
		}

		Object structMessage = jsonMapper.fromJson(payload, Object.class);
		boolean isApiGateway = structMessage instanceof Map
				&& (((Map<String, Object>) structMessage).containsKey("httpMethod") ||
						(((Map<String, Object>) structMessage).containsKey("routeKey") && ((Map) structMessage).containsKey("version")));

		Message<byte[]> requestMessage;
		MessageBuilder<byte[]> builder = MessageBuilder.withPayload(payload);
		if (isApiGateway) {
			builder.setHeader(AWSLambdaUtils.AWS_API_GATEWAY, true);
		}
		if (!isSupplier && AWSLambdaUtils.isSupportedAWSType(inputType)) {
			builder.setHeader(AWSLambdaUtils.AWS_EVENT, true);
		}
		if (context != null) {
			builder.setHeader(AWSLambdaUtils.AWS_CONTEXT, context);
		}
		//
		if (structMessage instanceof Map && ((Map<String, Object>) structMessage).containsKey("headers")) {
			builder.copyHeaders((Map<String, Object>) ((Map<String, Object>) structMessage).get("headers"));
		}
		requestMessage = builder.build();
		return requestMessage;
	}
```

we can see that it puts header name with context object

```java
if (context != null) {
	builder.setHeader(AWSLambdaUtils.AWS_CONTEXT, context);
}
```

Let's see how works `functionCatalog`. There is a class `BeanFactoryAwareFunctionRegistry` and its parent class `SimpleFunctionRegistry` which implements `FunctionRegistry` interface that extended `FunctionCatalog` interface.

in `FunctionRegistry` there is a default method which is invoked in `FunctionInvoker`
```java
	default <T> T lookup(String functionDefinition, String... expectedOutputMimeTypes) {
		return this.lookup(null, functionDefinition, expectedOutputMimeTypes);
	}
```

in `BeanFactoryAwareFunctionRegistry` we have overrided method `lookup`

```java
	@Override
	public <T> T lookup(Class<?> type, String functionDefinition, String... expectedOutputMimeTypes) {
		functionDefinition = StringUtils.hasText(functionDefinition)
				? functionDefinition
						: this.applicationContext.getEnvironment().getProperty(FunctionProperties.FUNCTION_DEFINITION, "");
		if (!this.applicationContext.containsBean(functionDefinition) || !KotlinDetector.isKotlinType(this.applicationContext.getBean(functionDefinition).getClass())) {
			functionDefinition = this.normalizeFunctionDefinition(functionDefinition);
		}
		if (!StringUtils.hasText(functionDefinition)) {
			logger.info("Can't determine default function definition. Please "
					+ "use 'spring.cloud.function.definition' property to explicitly define it.");
			return null;
		}
		if (!isFunctionDefinitionEligible(functionDefinition)) {
			return null;
		}
		FunctionInvocationWrapper function = this.doLookup(type, functionDefinition, expectedOutputMimeTypes);
		Object syncInstance = functionDefinition == null ? this : functionDefinition;
		synchronized (syncInstance) {
			if (function == null) {
				Set<String> functionRegistratioinNames = super.getNames(null);
				String[] functionNames = StringUtils.delimitedListToStringArray(functionDefinition.replaceAll(",", "|").trim(), "|");
				for (String functionName : functionNames) {
					if (functionRegistratioinNames.contains(functionName) && logger.isDebugEnabled()) {
						logger.debug("Skipping function '" + functionName + "' since it is already present");
					}
					else {
						Object functionCandidate = this.discoverFunctionInBeanFactory(functionName);
						if (functionCandidate != null) {
							Type functionType = null;
							FunctionRegistration functionRegistration = null;
							if (functionCandidate instanceof FunctionRegistration) {
								functionRegistration = (FunctionRegistration) functionCandidate;
							}
							else if (functionCandidate instanceof BiFunction || functionCandidate instanceof BiConsumer) {
								functionRegistration = this.registerMessagingBiFunction(functionCandidate, functionName);
							}
							else if (KotlinDetector.isKotlinType(functionCandidate.getClass())) {
								KotlinLambdaToFunctionAutoConfiguration.KotlinFunctionWrapper wrapper =
									new KotlinLambdaToFunctionAutoConfiguration.KotlinFunctionWrapper(functionCandidate);
								wrapper.setName(functionName);
								wrapper.setBeanFactory(this.applicationContext.getBeanFactory());
								functionRegistration = wrapper.getFunctionRegistration();
							}
							else if (this.isFunctionPojo(functionCandidate, functionName)) {
								Method functionalMethod = FunctionTypeUtils.discoverFunctionalMethod(functionCandidate.getClass());
								functionCandidate = this.proxyTarget(functionCandidate, functionalMethod);
								functionType = FunctionTypeUtils.fromFunctionMethod(functionalMethod);
							}
							else if (this.isSpecialFunctionRegistration(functionNames, functionName)) {
								functionRegistration = this.applicationContext
										.getBean(functionName + FunctionRegistration.REGISTRATION_NAME_SUFFIX, FunctionRegistration.class);
							}
							else {
								functionType = FunctionTypeUtils.discoverFunctionType(functionCandidate, functionName, this.applicationContext);
							}
							if (functionRegistration == null) {
								functionRegistration = new FunctionRegistration(functionCandidate, functionName).type(functionType);
							}
							// Certain Kafka Streams functions such as KStream[] return types could be null (esp when using Kotlin).
							this.register(functionRegistration);
						}
						else {
							if (logger.isDebugEnabled()) {
								logger.debug("Function '" + functionName + "' is not available in FunctionCatalog or BeanFactory");
							}
						}
					}
				}
				function = super.doLookup(type, functionDefinition, expectedOutputMimeTypes);
			}
		}

		return (T) function;
	}
```

it's quite long method. But we have important issues here.

```java
		if (!this.applicationContext.containsBean(functionDefinition) || !KotlinDetector.isKotlinType(this.applicationContext.getBean(functionDefinition).getClass())) {
			functionDefinition = this.normalizeFunctionDefinition(functionDefinition);
		}
```

we have a bean with for example name `pojoLambda` in context but it is not kotlin type. Strange expression but it is true  and we go to the body of the if. And let's see what is inside `normalizeFunctionDefinition`

```java
	/**
	 * This method will make sure that if there is only one function in catalog
	 * it can be looked up by any name or no name.
	 * It does so by attempting to determine the default function name
	 * (the only function in catalog) and checking if it matches the provided name
	 * replacing it if it does not.
	 */
	String normalizeFunctionDefinition(String functionDefinition) {
		functionDefinition = StringUtils.hasText(functionDefinition)
				? functionDefinition.replaceAll(",", "|")
				: System.getProperty(FunctionProperties.FUNCTION_DEFINITION, "");

		Set<String> names = this.getNames(null);
		if (!names.contains(functionDefinition)) {
			List<String> eligibleFunction = names.stream()
					.filter(name -> !RoutingFunction.FUNCTION_NAME.equals(name))
					.filter(name -> !RoutingFunction.DEFAULT_ROUTE_HANDLER.equals(name))
					.collect(Collectors.toList());
			if (eligibleFunction.size() == 1
					&& !eligibleFunction.get(0).equals(functionDefinition)
					&& !functionDefinition.contains("|")
					&& !eligibleFunction.get(0).startsWith("&")) {
				functionDefinition = eligibleFunction.get(0);
			}
		}
		return functionDefinition;
	}
  ```

  this invoke `getNames` method first
  ```java
  	@Override
	public Set<String> getNames(Class<?> type) {
		Set<String> registeredNames = super.getNames(type);

		//--- see https://github.com/spring-cloud/spring-cloud-function/issues/947
		Set<String> arroundWrapperNeamnames = this.applicationContext.getBeansOfType(FunctionAroundWrapper.class).keySet();
		String[] names = this.applicationContext.getBeanNamesForType(BiFunction.class);
		List<String> biFunctions = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			if (!arroundWrapperNeamnames.contains(names[i])) {
				biFunctions.add(names[i]);
			}
		}
		///

		if (type == null) {
			registeredNames
				.addAll(Arrays.asList(this.applicationContext.getBeanNamesForType(Function.class)));
			registeredNames
				.addAll(Arrays.asList(this.applicationContext.getBeanNamesForType(Supplier.class)));
			registeredNames
				.addAll(Arrays.asList(this.applicationContext.getBeanNamesForType(Consumer.class)));
			registeredNames
				.addAll(biFunctions);
			registeredNames
				.addAll(Arrays.asList(this.applicationContext.getBeanNamesForType(BiConsumer.class)));
			registeredNames
				.addAll(Arrays.asList(this.applicationContext.getBeanNamesForType(FunctionRegistration.class)));
		}
		else {
			registeredNames.addAll(Arrays.asList(this.applicationContext.getBeanNamesForType(type)));
		}
		return registeredNames;
	}
```

It tries to find any standart function interfaces in spring context. If it has found just 1 `Function` it registred it even if this name does not match in function definition and this method replace actual function definition on a founded definition. That can be completelly differ. I've got this issue when I have lambda without `Function` interface and another bean which implements `Function`. Even if I write a name of bean, this thing changed definition on a wrong. But after I added another function then expression in `if` does not match and it starts work correcntrly

```java
	if (eligibleFunction.size() == 1
					&& !eligibleFunction.get(0).equals(functionDefinition)
					&& !functionDefinition.contains("|")
					&& !eligibleFunction.get(0).startsWith("&")) {
```

### How to get a aws Context

```java
    public Map<String, Object> handler(Message<String> input) {

        Context context = input.getHeaders().get(AWS_CONTEXT, Context.class);

        Map<String, Object> toReturn = new HashMap<>();
        toReturn.put("getMemoryLimitInMB", context.getMemoryLimitInMB() + "");
        return toReturn;
    }
```

### Async lambdas

I can find a way to write methods with void return type and use it with `FunctionInvoker`. It is possible to do that using `Consumer` interface implementation.

```java
@Component("asyncHelloWorld")
public class HelloWorldLambda implements Consumer<String> {


    private final Logger logger = LoggerFactory.getLogger(HelloWorldLambda.class);

  
    @Override
    public void accept(String s) {
        logger.info("Hello, " + s);
    }
}
```

### Get acces to env variable

```java
@Component
public class EnvVarLambda implements Consumer<Object> {

    private final Logger logger = LoggerFactory.getLogger(EnvVarLambda.class);
    @Value("${database.url:#{null}}")
    private String databaseUrl;

    @Override
    public void accept(Object o) {
        if (databaseUrl == null || databaseUrl.isEmpty())
            logger.info("DATABASE_URL is not set");
        else
            logger.info("DATABASE_URL is set to: " + databaseUrl);
    }
}
```

### Using primitives in labmdas

It does not work at all.

```java
/**
 * Does not work
 */
@Component
public class BooleanLambda {

    public boolean handlerBoolean(boolean input) {
        return !input;
    }
}
```

only with wrapper classes

```java
@Component
public class IntegerLambdaWithBoolean {

      public Boolean handlerInteger(Integer input) {
        return input > 100;
    }
}
```

### Using inputstream like a payload


it works

```java
@Component
public class StreamLambda {

    /**
     * to test use "my simple text"
     */
    public String handlerStream(InputStream inputStream) throws IOException {
        return new String(inputStream.readAllBytes()).toUpperCase();
    }
}
```

### Using pojo in lambdas

```java
@Component
public class PojoLambda {

    /**
     * to test  { "information" : "Hello Lambda" }  output { "result" : "Input was Hello Lambda" }
     */
    public Output handlerPojo(Input input) {
        return new Output("Input was " + input.getInformation());
    }
}
```

```java
public class Input {

    private String information;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
```

```java
public class Output {
    private final String result;

    public Output(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
```

### Testing

Annotation to configure spring cloud function tests

```java
package org.springframework.cloud.function.context.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author Dave Syer
 * @since 2.0
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(properties = "spring.functional.enabled=true")
@ContextConfiguration(loader = FunctionalTestContextLoader.class)
public @interface FunctionalSpringBootTest {

	@AliasFor(annotation = SpringBootTest.class, attribute = "properties")
	String[] value() default {};

	@AliasFor(annotation = SpringBootTest.class, attribute = "value")
	String[] properties() default {};

	@AliasFor(annotation = SpringBootTest.class, attribute = "classes")
	Class<?>[] classes() default {};

	@AliasFor(annotation = SpringBootTest.class, attribute = "webEnvironment")
	WebEnvironment webEnvironment() default WebEnvironment.MOCK;

```

example of tests

```java
@FunctionalSpringBootTest
class ListLambdaTest {

    public static final String FUNCTION_NAME = "listLambda";
    @Autowired
    private FunctionCatalog catalog;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void handlerList() {
        Function<List<Integer>, List<Integer>> function = catalog.lookup(Function.class, FUNCTION_NAME);
        List<Integer> result = function.apply(List.of(10, 20));
        assertEquals(List.of(110, 120), result);
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void handlerListJson() {
        Function<String, GenericMessage<byte[]>> function = catalog.lookup(Function.class, FUNCTION_NAME, "application/json");
        GenericMessage<byte[]> result = function.apply("[ 1, 2, 3 ]");
        assertEquals("[101,102,103]", new String(result.getPayload()));
    }
}
```

There are two ways to invoke functions. One with a object that match signature of a funtions and the another with a conversion from json

Using overriden properties

```java
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@FunctionalSpringBootTest(properties = "database.url=my_db")
class EnvVarLambdaWithDbUrlInPropertiesTest {

    @Autowired
    private EnvVarLambda envVarLambda;

    @Autowired
    private FunctionCatalog catalog;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void acceptPrintsMessageWhenDatabaseUrlIsNotSpecifiedInEnvVariable() {
        Logger mockLogger = mock(Logger.class);
        ReflectionTestUtils.setField(envVarLambda, "logger", mockLogger);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        Consumer<String> consumer = catalog.lookup(Consumer.class, "envVarLambda");
        consumer.accept("");

        verify(mockLogger).info(argumentCaptor.capture());
        assertEquals("DATABASE_URL is set to: my_db", argumentCaptor.getValue());
    }
}
```

```java
import com.amazonaws.services.lambda.runtime.Context;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Map;
import java.util.function.Function;

import static org.example.lambda.requestresponse.ContextLambda.REMAINING_TIME_IN_MILLIS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.cloud.function.adapter.aws.AWSLambdaUtils.AWS_CONTEXT;

@FunctionalSpringBootTest
@DirtiesContext
class ContextLambdaTest {


    @Autowired
    private FunctionCatalog catalog;

    @Test
    void handlerReturnsExpectedRemainingTIme() {
        Function<Message<String>, Map<String, Object>> function = catalog.lookup(Function.class, "contextLambda");
        MessageBuilder<String> messageBuilder = MessageBuilder.withPayload("tadam");
        Context mockContext = mock(Context.class);
        Integer expectedRemainingTime = 50;
        when(mockContext.getRemainingTimeInMillis()).thenReturn(expectedRemainingTime);
        messageBuilder.setHeader(AWS_CONTEXT, mockContext);

        Map<String, Object> result = function.apply(messageBuilder.build());

        assertNotNull(result);
        assertEquals(expectedRemainingTime.toString(), result.get(REMAINING_TIME_IN_MILLIS));
    }
}
```