
# Table of contents
- [Table of contents](#table-of-contents)
- [AWS Certification](#aws-certification)
  - [Advice for the Amazon exams](#advice-for-the-amazon-exams)
  - [Common links to cert path](#common-links-to-cert-path)
  - [Resources for](#resources-for)
- [IAM](#iam)
  - [Access control methods](#access-control-methods)
    - [Role based access control (RBAC)](#role-based-access-control-rbac)
    - [Attribute-based access control (ABAC)](#attribute-based-access-control-abac)
  - [MFA](#mfa)
  - [STS (Security Token Service)](#sts-security-token-service)
  - [Start on IAM](#start-on-iam)
  - [Generate secret key](#generate-secret-key)
  - [Billing](#billing)
  - [Assuming AWS role](#assuming-aws-role)
- [AWS Organizations](#aws-organizations)
  - [Service control policies (scp)](#service-control-policies-scp)
  - [AWS Control Tower](#aws-control-tower)
- [EC2 (Elastic compute cloud)](#ec2-elastic-compute-cloud)
  - [Create simple vm](#create-simple-vm)
  - [Simple network rules](#simple-network-rules)
  - [Horizontal scalling via create another ec2 instance](#horizontal-scalling-via-create-another-ec2-instance)
  - [Horisonal scalling with auto scale groups](#horisonal-scalling-with-auto-scale-groups)
    - [Health checks](#health-checks)
    - [Health check grace period](#health-check-grace-period)
    - [Group metrics (ASG)](#group-metrics-asg)
    - [Basic monitoring (Instances)](#basic-monitoring-instances)
    - [Detailed monitoring (Instances)](#detailed-monitoring-instances)
    - [Scaling strategies](#scaling-strategies)
    - [Cooldowns](#cooldowns)
    - [ermination Policy](#ermination-policy)
    - [Termination Protection](#termination-protection)
    - [Standby State](#standby-state)
    - [Lifecycle Hooks](#lifecycle-hooks)
    - [Examples](#examples)
  - [User data](#user-data)
  - [Metadata](#metadata)
  - [Security access](#security-access)
  - [Placement Groups](#placement-groups)
    - [Cluster](#cluster)
    - [Spread](#spread)
    - [Partition](#partition)
    - [Differences](#differences)
  - [Billing and provisioning](#billing-and-provisioning)
    - [On demand](#on-demand)
    - [Spot](#spot)
    - [Reserved](#reserved)
    - [Comparison](#comparison)
    - [Limits](#limits)
  - [On-Demand Capacity Reservations](#on-demand-capacity-reservations)
  - [Dedicated hosts and instances](#dedicated-hosts-and-instances)
    - [Dedicated hosts](#dedicated-hosts)
    - [Dedicated instances](#dedicated-instances)
    - [Use cases](#use-cases)
  - [Saving plans](#saving-plans)
- [EBS Elastic block storage](#ebs-elastic-block-storage)
- [EFS Elastic file system](#efs-elastic-file-system)
  - [Using Amazon EFS with Lambda](#using-amazon-efs-with-lambda)
  - [Example](#example)
- [S3 Simple storage service](#s3-simple-storage-service)
  - [Overview](#overview)
  - [Accessing s3](#accessing-s3)
  - [Security](#security)
    - [Example using ACL](#example-using-acl)
    - [Using IAM policies and bucket policies](#using-iam-policies-and-bucket-policies)
      - [List buckets (user policy)](#list-buckets-user-policy)
      - [2 See root-level bucket items (user policy)](#2-see-root-level-bucket-items-user-policy)
      - [View the Department folder contents (user policy)](#view-the-department-folder-contents-user-policy)
      - [Get and put objects in the Department folder (user policy)](#get-and-put-objects-in-the-department-folder-user-policy)
      - [Explicitly grant access to user to list the Confidential folder (Bucket Policy) - use with policy 2 above](#explicitly-grant-access-to-user-to-list-the-confidential-folder-bucket-policy---use-with-policy-2-above)
  - [MFA](#mfa-1)
    - [S3 Multi Factor Authentication Delete (MFA Delete)](#s3-multi-factor-authentication-delete-mfa-delete)
    - [MFA protected API access (not only s3)](#mfa-protected-api-access-not-only-s3)
    - [Encryption](#encryption)
  - [S3 Event Notifications](#s3-event-notifications)
  - [Storage classes](#storage-classes)
  - [Example](#example-1)
  - [Preassigned temporary url](#preassigned-temporary-url)
  - [Log bucket events to the another bucket](#log-bucket-events-to-the-another-bucket)
  - [CORS with S3 bucket](#cors-with-s3-bucket)
  - [S3 Optimization patterns](#s3-optimization-patterns)
- [CloudFront (CDN)](#cloudfront-cdn)
  - [Origins](#origins)
  - [High availability with Origin Failover](#high-availability-with-origin-failover)
  - [Sign URL](#sign-url)
  - [Sign cookies](#sign-cookies)
  - [CloudFront origin access identity OAI](#cloudfront-origin-access-identity-oai)
  - [Cloudfront OAC](#cloudfront-oac)
  - [Origin response trigger](#origin-response-trigger)
  - [Example static website](#example-static-website)
- [Route 53](#route-53)
- [CloudFormation](#cloudformation)
  - [Nested stacks](#nested-stacks)
  - [Examples](#examples-1)
  - [Template features](#template-features)
    - [Resources](#resources)
    - [Parameters](#parameters)
    - [Mappings](#mappings)
    - [Outputs](#outputs)
    - [Conditions](#conditions)
    - [Transform](#transform)
    - [Intrinsic functions](#intrinsic-functions)
      - [Ref](#ref)
      - [Fn::GetAtt](#fngetatt)
      - [Fn:FindInMap](#fnfindinmap)
  - [Pseudo parameters](#pseudo-parameters)
- [Elastic Beanstalk](#elastic-beanstalk)
  - [Deployment options](#deployment-options)
    - [All at once](#all-at-once)
    - [Rolling](#rolling)
    - [Rolling with additional batch](#rolling-with-additional-batch)
    - [Immutable](#immutable)
    - [Blue/green](#bluegreen)
  - [AWS Elastic Beanstalk configuration files](#aws-elastic-beanstalk-configuration-files)
  - [SSL/TLS](#ssltls)
- [AWS ClI](#aws-cli)
  - [Installing](#installing)
  - [configure](#configure)
  - [help](#help)
  - [ec2 cli](#ec2-cli)
  - [alb and autoscaling group](#alb-and-autoscaling-group)
    - [create auto scaling group](#create-auto-scaling-group)
    - [create load balancer, create listener, and attach to TG1 to ASG2](#create-load-balancer-create-listener-and-attach-to-tg1-to-asg2)
    - [delete ASG2 and ALB2](#delete-asg2-and-alb2)
  - [s3 cli](#s3-cli)
  - [assuming a role](#assuming-a-role)
- [Networking](#networking)
  - [IP and Mask](#ip-and-mask)
  - [Choosing right CIDR](#choosing-right-cidr)
  - [Zones and Regions](#zones-and-regions)
  - [VPS (Virtual private cloud)](#vps-virtual-private-cloud)
  - [availiablity zones](#availiablity-zones)
  - [Subnets](#subnets)
    - [Routing accross VPS and outside](#routing-accross-vps-and-outside)
    - [Internet access](#internet-access)
    - [Connect to the public AWS endpoint](#connect-to-the-public-aws-endpoint)
    - [NAT for private subnets](#nat-for-private-subnets)
    - [connect on-premises data center](#connect-on-premises-data-center)
    - [Firewall](#firewall)
    - [Examples](#examples-2)
- [Load balancing ELB](#load-balancing-elb)
  - [ALB - Applicaton load balancer](#alb---applicaton-load-balancer)
    - [Routing ALB](#routing-alb)
    - [Example how to configure](#example-how-to-configure)
  - [NLB - Network Load Balancer](#nlb---network-load-balancer)
    - [NLB routing](#nlb-routing)
  - [CLB - Classic load balancer](#clb---classic-load-balancer)
  - [GLB - Gataway load balancer](#glb---gataway-load-balancer)
  - [Comparison](#comparison-1)
  - [Session info](#session-info)
  - [Cross-Zone Load Balancing](#cross-zone-load-balancing)
  - [ELB Security](#elb-security)
    - [ALB](#alb)
    - [NLB](#nlb)
- [Serverless](#serverless)
  - [BaaS (Backend as a service)](#baas-backend-as-a-service)
  - [FaaS (Function as a service)](#faas-function-as-a-service)
  - [AWS Lambda](#aws-lambda)
  - [How lambda can be invoked](#how-lambda-can-be-invoked)
  - [Examples](#examples-3)
    - [Web API](#web-api)
    - [File processing](#file-processing)
  - [Other](#other)
    - [First Java example (compile and deploy via SAM)](#first-java-example-compile-and-deploy-via-sam)
    - [Example with basic types](#example-with-basic-types)
    - [Lists and Maps](#lists-and-maps)
    - [POJO in lambdas](#pojo-in-lambdas)
    - [Streams](#streams)
    - [Context](#context)
  - [Timeout](#timeout)
  - [Types of lambda](#types-of-lambda)
    - [Synchronous](#synchronous)
    - [Asynchronous](#asynchronous)
    - [Event source mapping](#event-source-mapping)
  - [Invoke lambda via AWS CLI](#invoke-lambda-via-aws-cli)
  - [Example with async lambda invocatoin and writing to log](#example-with-async-lambda-invocatoin-and-writing-to-log)
  - [Create Event Source Mapping](#create-event-source-mapping)
  - [The Lambda Execution Environment](#the-lambda-execution-environment)
  - [Lambda versions](#lambda-versions)
  - [Lambda aliases](#lambda-aliases)
  - [Example with versions and label.](#example-with-versions-and-label)
  - [Deployment Packages and Environment variables](#deployment-packages-and-environment-variables)
    - [Container images](#container-images)
    - [Zip](#zip)
    - [Deployment through CloudFormation](#deployment-through-cloudformation)
    - [Lambda layers](#lambda-layers)
    - [Lambda Environment Variables](#lambda-environment-variables)
  - [Lambda limits](#lambda-limits)
  - [Destinations](#destinations)
  - [AWS SAM CLI](#aws-sam-cli)
    - [Installation](#installation)
    - [Features](#features)
    - [SAM Policy Templates](#sam-policy-templates)
    - [Commands](#commands)
    - [Environment Variables and SAM](#environment-variables-and-sam)
  - [Lambda Function Method Signatures](#lambda-function-method-signatures)
  - [Memory and CPU](#memory-and-cpu)
  - [Concurrency](#concurrency)
    - [Reserved Concurrency](#reserved-concurrency)
    - [Provisioned Concurrency](#provisioned-concurrency)
  - [Metrics, tracing, logs](#metrics-tracing-logs)
    - [Monitoring](#monitoring)
    - [Logging](#logging)
  - [Lambda in a VPC](#lambda-in-a-vpc)
  - [Lambda Function as a Target for an ALB](#lambda-function-as-a-target-for-an-alb)
  - [Security](#security-1)
  - [Best practicies](#best-practicies)
  - [Servless application repository](#servless-application-repository)
  - [Example pricing](#example-pricing)
  - [Database proxy for Amazon RDS](#database-proxy-for-amazon-rds)
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
- [Dynamo DB](#dynamo-db)
  - [DynamoDB API](#dynamodb-api)
  - [Data types](#data-types)
  - [Table classes](#table-classes)
  - [Access control](#access-control)
  - [DynamoDB Partitions and Primary Keys](#dynamodb-partitions-and-primary-keys)
    - [Partition key](#partition-key)
    - [Composite key](#composite-key)
    - [Limits](#limits-1)
    - [Best practices for partition keys:](#best-practices-for-partition-keys)
  - [DynamoDB Consistency Models](#dynamodb-consistency-models)
    - [Eventually consistent reads](#eventually-consistent-reads)
    - [Strongly consistent reads](#strongly-consistent-reads)
    - [Transactions](#transactions)
  - [DynamoDB Capacity Units (RCU/WCU)](#dynamodb-capacity-units-rcuwcu)
    - [Read Capacity Units (RCUs):](#read-capacity-units-rcus)
    - [Write Capacity Units (WCUs)](#write-capacity-units-wcus)
  - [DynamoDB On Demand Capacity](#dynamodb-on-demand-capacity)
  - [Performance](#performance)
  - [DynamoDB Scan and Query API](#dynamodb-scan-and-query-api)
    - [DynamoDB Scan API](#dynamodb-scan-api)
    - [DynamoDB Query API](#dynamodb-query-api)
    - [Examples cli](#examples-cli)
      - [Import data](#import-data)
      - [Perform scan of ProductOrders table:](#perform-scan-of-productorders-table)
      - [Use Page-Size Parameter:](#use-page-size-parameter)
      - [Use Max-Items Parameter:](#use-max-items-parameter)
      - [Use Projection-Expression Parameter:](#use-projection-expression-parameter)
      - [Use Filter-Expression Parameter:](#use-filter-expression-parameter)
      - [Use Key-Conditions Parameter:](#use-key-conditions-parameter)
      - [Use Key-Condition-Expression Parameter:](#use-key-condition-expression-parameter)
  - [Examples](#examples-4)
  - [DynamoDB LSI and GSI](#dynamodb-lsi-and-gsi)
    - [DynamoDB Local Secondary Index (LSI)](#dynamodb-local-secondary-index-lsi)
    - [DynamoDB Global Secondary Index (GSI)](#dynamodb-global-secondary-index-gsi)
  - [DynamoDB Optimistic Locking and Conditional Updates](#dynamodb-optimistic-locking-and-conditional-updates)
    - [DynamoDB Optimistic Locking](#dynamodb-optimistic-locking)
    - [DynamoDB Conditional Updates](#dynamodb-conditional-updates)
  - [Adding a time to live (TTL) to items](#adding-a-time-to-live-ttl-to-items)
  - [DynamoDB Streams](#dynamodb-streams)
  - [Amazon DynamoDB Accelerator (DAX)](#amazon-dynamodb-accelerator-dax)
    - [DAX vs ElastiCache](#dax-vs-elasticache)
  - [Amazon DynamoDB Global Tables](#amazon-dynamodb-global-tables)
  - [Amazon DynamoDB Encryption Client](#amazon-dynamodb-encryption-client)
- [SQS](#sqs)
  - [Queue types](#queue-types)
    - [Standart Queue](#standart-queue)
    - [FIFO Queue](#fifo-queue)
  - [Dead letter](#dead-letter)
  - [SQS Delay Queue](#sqs-delay-queue)
  - [Visibility Timeout](#visibility-timeout)
  - [SQS Long Polling vs Short Polling](#sqs-long-polling-vs-short-polling)
  - [SQS CLI examples](#sqs-cli-examples)
  - [Amazon SQS API](#amazon-sqs-api)
  - [What if the message is bigger than 256 KB? Java library](#what-if-the-message-is-bigger-than-256-kb-java-library)
- [SNS Simple Notification Service](#sns-simple-notification-service)
  - [Amazon SNS + Amazon SQS Fan Out](#amazon-sns--amazon-sqs-fan-out)
- [Simple serverless](#simple-serverless)
- [AWS Step Functions](#aws-step-functions)
- [Amazon EventBridge](#amazon-eventbridge)
- [Amazon API Gateway](#amazon-api-gateway)
  - [Feautures](#feautures)
  - [Deployment types](#deployment-types)
    - [Edge Optimized APIs](#edge-optimized-apis)
    - [Regional APIs](#regional-apis)
    - [Private endpoint](#private-endpoint)
  - [Structure of API](#structure-of-api)
  - [Integration Types](#integration-types)
    - [AWS integration](#aws-integration)
    - [AWS\_PROXY (or Lambda proxy integration)](#aws_proxy-or-lambda-proxy-integration)
    - [HTTP](#http)
    - [MOCK](#mock)
  - [Mapping Templates](#mapping-templates)
  - [API Gateway Stages and Deployments](#api-gateway-stages-and-deployments)
  - [Swagger and Open API 3](#swagger-and-open-api-3)
  - [Caching and Throttling](#caching-and-throttling)
    - [Caching](#caching)
    - [Throttling](#throttling)
  - [API Gateway Usage Plans and API Keys](#api-gateway-usage-plans-and-api-keys)
  - [API Gateway Access Control](#api-gateway-access-control)
    - [Resource Based Policies](#resource-based-policies)
    - [Lambda Authorizer](#lambda-authorizer)
    - [Cognito User Pool Authorizer](#cognito-user-pool-authorizer)
  - [Logging](#logging-1)
- [ECS](#ecs)
  - [Features](#features-1)
  - [Components](#components)
    - [Amazon ECS Clusters](#amazon-ecs-clusters)
    - [ECS Container Instances and Container Agent](#ecs-container-instances-and-container-agent)
    - [Amazon ECS Images](#amazon-ecs-images)
    - [Amazon ECS Tasks and Task Definitions](#amazon-ecs-tasks-and-task-definitions)
  - [Launch Types](#launch-types)
    - [Fargate Launch Type](#fargate-launch-type)
    - [EC2 Launch Type](#ec2-launch-type)
    - [External Launch Type](#external-launch-type)
  - [Amazon ECS and IAM Roles](#amazon-ecs-and-iam-roles)
  - [ECS Task Placement Strategies](#ecs-task-placement-strategies)
    - [Cluster Query Language](#cluster-query-language)
  - [Scaling Amazon ECS](#scaling-amazon-ecs)
    - [Service auto scaling](#service-auto-scaling)
    - [Cluster auto scaling](#cluster-auto-scaling)
  - [Amazon ECS with ALB](#amazon-ecs-with-alb)
  - [Example](#example-2)
  - [Amazon Elastic Container Registry (ECR)](#amazon-elastic-container-registry-ecr)
    - [Pushing an Image to a Private Repository](#pushing-an-image-to-a-private-repository)
    - [create an image and push to the ecr](#create-an-image-and-push-to-the-ecr)
    - [create a task definition and load balancer](#create-a-task-definition-and-load-balancer)
    - [create fargate cluster and service](#create-fargate-cluster-and-service)
    - [codedeploy application and pipeline](#codedeploy-application-and-pipeline)
    - [implement blue/green update](#implement-bluegreen-update)
- [EKS](#eks)
  - [Amazon EKS Auto Scaling](#amazon-eks-auto-scaling)
  - [Amazon EKS Pod Networking](#amazon-eks-pod-networking)
  - [Amazon EKS and Elastic Load Balancing](#amazon-eks-and-elastic-load-balancing)
- [Copilot](#copilot)
- [AWS CI/CD Tools](#aws-cicd-tools)
  - [Code Commit](#code-commit)
    - [Authentication and Access Control](#authentication-and-access-control)
    - [Authorization](#authorization)
    - [Notifications](#notifications)
  - [Code Pipeline](#code-pipeline)
    - [Notifications](#notifications-1)
    - [Troubleshooting](#troubleshooting)
    - [Example pipeline codecommit and beanstalk](#example-pipeline-codecommit-and-beanstalk)
  - [Code Build](#code-build)
    - [AWS CodeBuild Components](#aws-codebuild-components)
    - [Specifying Build Commands](#specifying-build-commands)
    - [CodeBuild Local Build](#codebuild-local-build)
    - [Customized Build Environments](#customized-build-environments)
  - [Example](#example-3)
  - [AWS CodeDeploy](#aws-codedeploy)
    - [EC2/On Premises:](#ec2on-premises)
    - [AWS Lambda:](#aws-lambda-1)
    - [Amazon ECS:](#amazon-ecs)
    - [In-place deployment:](#in-place-deployment)
    - [Blue/Green Traffic Shifting](#bluegreen-traffic-shifting)
      - [AWS Lambda](#aws-lambda-2)
    - [Amazon ECS](#amazon-ecs-1)
      - [EC2/OnPremises\*\*](#ec2onpremises)
    - [AppSpec File](#appspec-file)
      - [EC2/On-Premises AppSpec.yaml](#ec2on-premises-appspecyaml)
      - [AppSpec.yaml for ECS](#appspecyaml-for-ecs)
      - [AppSpec.yaml for AWS Lambda](#appspecyaml-for-aws-lambda)
    - [Revision](#revision)
  - [Amazon CodeGuru](#amazon-codeguru)
    - [Amazon CodeGuru Reviewer](#amazon-codeguru-reviewer)
    - [Amazon CodeGuru Profiler](#amazon-codeguru-profiler)
  - [Amazon CodeStar](#amazon-codestar)
  - [AWS Cloud9](#aws-cloud9)
  - [AWS CodeArtifact](#aws-codeartifact)
  - [AWS Amplify and AppSync](#aws-amplify-and-appsync)
    - [AWS AppSync’s API Cache](#aws-appsyncs-api-cache)
- [Amazon Relational Database Service (RDS)](#amazon-relational-database-service-rds)
  - [Amazon RDS Backup and Recovery](#amazon-rds-backup-and-recovery)
    - [Automated Backups](#automated-backups)
    - [Amazon RDS Manual Backups (Snapshot)](#amazon-rds-manual-backups-snapshot)
    - [Amazon RDS Maintenance Windows](#amazon-rds-maintenance-windows)
  - [Examples](#examples-5)
    - [create mysql database](#create-mysql-database)
    - [create manual snapshot](#create-manual-snapshot)
    - [create multi-AZ replicas](#create-multi-az-replicas)
  - [Amazon Aurora](#amazon-aurora)
  - [Amazon RDS Security](#amazon-rds-security)
- [Amazon ElastiCache](#amazon-elasticache)
  - [Amazon ElastiCache Use Cases](#amazon-elasticache-use-cases)
  - [Amazon ElastiCache Scalability](#amazon-elasticache-scalability)
    - [Memcached](#memcached)
    - [Redis](#redis)
  - [Examples](#examples-6)
  - [Caching strategies](#caching-strategies)
    - [Lazy Loading](#lazy-loading)
    - [Write Through](#write-through)
  - [Amazon MemoryDB for Redis](#amazon-memorydb-for-redis)
  - [MemoryDB for Redis vs ElastiCache](#memorydb-for-redis-vs-elasticache)
- [Amazon Kinesis Core](#amazon-kinesis-core)
  - [Kinesis Client Library (KCL)](#kinesis-client-library-kcl)
  - [Amazon Kinesis Data Streams](#amazon-kinesis-data-streams)
  - [Kinesis Data Firehose](#kinesis-data-firehose)
  - [Kinesis Data Analytics](#kinesis-data-analytics)
- [Amazon OpenSearch Service (ElasticSearch)](#amazon-opensearch-service-elasticsearch)
  - [OpenSearch Service Deployment](#opensearch-service-deployment)
  - [OpenSearch in an Amazon VPC](#opensearch-in-an-amazon-vpc)
  - [The ELK Stack](#the-elk-stack)
  - [OpenSearch Access Control](#opensearch-access-control)
  - [OpenSearch Best Practices](#opensearch-best-practices)
- [Amazon Athena and AWS Glue](#amazon-athena-and-aws-glue)
  - [Optimizing Athena for Performance](#optimizing-athena-for-performance)
  - [AWS Glue](#aws-glue)
- [AWS CDK](#aws-cdk)
- [AWS AppConfig](#aws-appconfig)
- [Amazon CloudWatch](#amazon-cloudwatch)
  - [Use cases / benefits include:](#use-cases--benefits-include)
  - [Features](#features-2)
  - [Amazon CloudWatch Metrics](#amazon-cloudwatch-metrics)
  - [Amazon CloudWatch Alarms](#amazon-cloudwatch-alarms)
  - [Amazon CloudWatch Logs](#amazon-cloudwatch-logs)
  - [The Unified CloudWatch Agent](#the-unified-cloudwatch-agent)
  - [VPC Flow logs](#vpc-flow-logs)
- [AWS CloudTrail](#aws-cloudtrail)
  - [CloudTrail Types of Events](#cloudtrail-types-of-events)
- [AWS Key Management Service (KMS)](#aws-key-management-service-kms)
  - [AWS KMS Keys (customer master keys (CMKs))](#aws-kms-keys-customer-master-keys-cmks)
    - [AWS Managed KMS keys](#aws-managed-kms-keys)
    - [Customer managed KMS keys:](#customer-managed-kms-keys)
    - [AWS Owned KMS Keys](#aws-owned-kms-keys)
    - [Data Encryption Keys](#data-encryption-keys)
  - [Alternative Key Stores](#alternative-key-stores)
  - [KMS Keys and Automatic Rotation](#kms-keys-and-automatic-rotation)
  - [Manual Rotation](#manual-rotation)
  - [Key Deletion](#key-deletion)
  - [Key Management with KMS](#key-management-with-kms)
  - [Data Encryption Scenarios](#data-encryption-scenarios)
  - [Additional Exam Tips](#additional-exam-tips)
  - [AWS KMS API and CLI](#aws-kms-api-and-cli)
  - [Throttling and Caching](#throttling-and-caching)
- [AWS Certificate Manager (ACM)](#aws-certificate-manager-acm)
- [AWS Systems Manager](#aws-systems-manager)
  - [AWS Systems Manager Patch Manager](#aws-systems-manager-patch-manager)
  - [AWS Systems Manager Compliance](#aws-systems-manager-compliance)
  - [AWS Systems Manager Session Manager](#aws-systems-manager-session-manager)
  - [AWS Systems Manager Parameter Store](#aws-systems-manager-parameter-store)
- [AWS Secrets Manager](#aws-secrets-manager)
  - [AWS CLI commands for Secrets Manager](#aws-cli-commands-for-secrets-manager)
- [Amazon Cognito](#amazon-cognito)
  - [Adaptive authentication](#adaptive-authentication)
  - [User Datasets](#user-datasets)
- [AWS Web Application Firewall (WAF)](#aws-web-application-firewall-waf)
- [Tracing with X-Ray](#tracing-with-x-ray)
  - [X-Ray on EC2 / On-premises:](#x-ray-on-ec2--on-premises)
  - [Lambda](#lambda)
  - [X-Ray on ECS/EKS/Fargate:](#x-ray-on-ecseksfargate)
  - [Elastic Beanstal](#elastic-beanstal)
  - [Key X-Ray terminology](#key-x-ray-terminology)
    - [Trace](#trace)
    - [Segments](#segments)
    - [Subsegments](#subsegments)
    - [Annotations:](#annotations)
    - [Sampling](#sampling)
    - [Metadata:](#metadata-1)
  - [Annotations and Filtering](#annotations-and-filtering)
  - [X-Ray Daemon](#x-ray-daemon)
  - [X-Ray SDK](#x-ray-sdk)
- [AWS Fault Injection Simulator](#aws-fault-injection-simulator)
- [AWS Resource Access Manager](#aws-resource-access-manager)
  - [Key benefits:](#key-benefits)
- [AWS Macie](#aws-macie)

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


# IAM

![](images/iam_2.png)

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

### Role based access control (RBAC)

Groups of users organized by job role. Permissions link to the group. User inherits permissions from the group. And principle of least previleges - the minimum permissions to get job done. 

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

### Attribute-based access control (ABAC)

- Permisson according to conditions. 
- Users has a group and tags like metadata, for example department. And policy has condition on group and department tag. And it can have condition with tags which selected resources. Database has a tag environemnt and value production or test. And guy from admin group and with department DBAdmins can reboot database that has Environemnt tag like Production but not Test Database which has another value of the tag Environment.

## MFA

You can use Google Authenticator or a physical token which is possile to order from third parties companies.

![](images/iam_mfa_1.png)

![](images/iam_mfa_2.png)

![](images/iam_mfa_3.png)

![](images/iam_mfa_4.png)

## STS (Security Token Service)

What if you have an app on an EC2 instance and want to get access to S3 bucket. We need to create an instance profile and connect it to the IAM role. then to add trust policy and after that AWS STS could get temporary security credentials for ec2 instance. This credentionals includes AccessKeyId, Expiration, SecretAccessKey, SessionToken. 

You can use the following AWS CLI commands to work with instance profiles in an AWS account:

- Create an instance profile: `aws iam create-instance-profile`
- Add a role to an instance profile: `aws iam add-role-to-instance-profile`
- List instance profiles: `aws iam list-instance-profiles, aws iam list-instance-profiles-for-role`
- Get information about an instance profile: `aws iam get-instance-profile`
- Remove a role from an instance profile: `aws iam remove-role-from-instance-profile`
- Delete an instance profile: `aws iam delete-instance-profile` 

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

# AWS Organizations
  
![](images/org_1.png)

- AWS organizations allows you to consolidate multiple AWS accounts into an organization that you create and centrally manage
- Available in two feature sets:
  - Consolidated Billing
  - All features
- Includes root accounts and organizational units
- Policies are applied to root accounts or OUs
- Consolidated billing includes:
  - Paying Account – independent and cannot access resources of other accounts
  - Linked Accounts – all linked accounts are independent

![](images/org_2.png)

## Service control policies (scp)

![](images/org_3.png)

## AWS Control Tower

![](images/org_4.png)

- Control Tower creates a well-architected multiaccount baseline based on best practices
- This is known as a landing zone
- Guardrails are used for governance and compliance:
  - Preventive guardrails are based on SCPs and disallow API actions
  - Detective guardrails are implemented using AWS Config rules and Lambda functions and monitor and govern compliance
- The root user in the management account can perform actions that guardrails would disallow


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

## Horisonal scalling with auto scale groups

![](images/ec2_scaling_21.png)

- EC2 Auto Scaling launches and terminates instances dynamically
- Scaling is horizontal (scales out)
- Provides elasticity and scalability
- Responds to EC2 status checks and CloudWatch metrics
- Can scale based on demand (performance) or on a schedule
- **Scaling policies** define how to respond to changes in demand
- **Auto Scaling groups** define collections of EC2 instances that are scaled and managed together

### Health checks

- EC2 = EC2 status checks
- ELB = Uses the ELB health checks in addition to EC2
status checks

### Health check grace period

- How long to wait before checking the health status of the instance
- Auto Scaling does not act on health checks until grace period expires

### Group metrics (ASG)

- Data points about the Auto Scaling group
- 1-minute granularity
- No charge
- Must be enabled

### Basic monitoring (Instances)

- 5-minute granularity
- No Charge

### Detailed monitoring (Instances)

- 1-minute granularity
- Charges apply

### Scaling strategies

![](images/ec2_scaling_22.png)

![](images/ec2_scaling_23.png)

![](images/ec2_scaling_24.png)

![](images/ec2_scaling_25.png)



### Cooldowns 

Used with simple scaling policy to prevent Auto Scaling from launching or terminating before effects of previous activities are visible. Default value is 300 seconds (5 minutes)

### ermination Policy 

Controls which instances to terminate first when a scale-in event occurs

### Termination Protection 

Prevents Auto Scaling from terminating protected instances

### Standby State 

Used to put an instance in the **InService** state into the **Standby** state, update or troubleshoot the instance

### Lifecycle Hooks

Used to perform custom actions by pausing instances as the ASG launches or terminates them

Use case:
- Run a script to download and install software after launching
- Pause an instance to process data before a scale-in (termination)

### Examples

1. Create a launch template for ec2 instance

![](images/ec2_scaling_1.png)

![](images/ec2_scaling_2.png)

![](images/ec2_scaling_3.png)

![](images/ec2_scaling_4.png)


```bash
#!/bin/bash
yum update -y
yum install -y httpd
systemctl start httpd
systemctl enable httpd
EC2AZ=$(TOKEN=`curl -X PUT "http://169.254.169.254/latest/api/token" -H "X-aws-ec2-metadata-token-ttl-seconds: 21600"` && curl -H "X-aws-ec2-metadata-token: $TOKEN" -v http://169.254.169.254/latest/meta-data/placement/availability-zone)
echo '<center><h1>This Amazon EC2 instance is located in Availability Zone: AZID </h1></center>' > /var/www/html/index.txt
sed "s/AZID/$EC2AZ/" /var/www/html/index.txt > /var/www/html/index.html
```

![](images/ec2_scaling_5.png)

2. create auto scaling group

![](images/ec2_scaling_6.png)

![](images/ec2_scaling_7.png)

![](images/ec2_scaling_8.png)

![](images/ec2_scaling_9.png)

![](images/ec2_scaling_10.png)

![](images/ec2_scaling_11.png)

![](images/ec2_scaling_12.png)

it's possible to manage auto scaling rules on the base of some metrics (CPU for example) or predicted hours of increasing load.

![](images/ec2_scaling_13.png)


## User data

It's posiible to launch user code after launching ec2 instance

![](images/ec2_11.png)

 This script is limited by 16 KB. 

 For Windows EC2 instance it is possible to run batch or power-shell scripts.

## Metadata 

It's possible to get metadata from ec2 instace by this address `http://169.254.169.254/latest/meta-data'. It is a local address! 

to see list of available metadata 
```bash
curl http://169.254.169.254/latest/meta-data
```

![](images/ec2_metadata.png)

to get some concrete part of meta-data 

```bash
curl http://169.254.169.254/latest/meta-data/local-ipv4
```

## Security access

Let's picture we want to access from ec2 instance to s3 bucket. There are two ways to do it.

![](images/ec2_sec_1.png)

![](images/ec2_sec_2.png)

## Placement Groups

Placement groups are a logical grouping of instances in one of the following configurations.

### Cluster 

![](images/ec2_placement_1.png)

- clusters instances into a low-latency group in a single AZ:
- A cluster placement group is a logical grouping of instances within a single Availability Zone.
- Cluster placement groups are recommended for applications that benefit from low network latency, high network throughput, or both, and if most of the network traffic is between the instances in the group.

### Spread

![](images/ec2_placement_2.png)

- spreads instances across underlying hardware (can span AZs):
- A spread placement group is a group of instances that are each placed on distinct underlying hardware.
- Spread placement groups are recommended for applications that have a small number of critical instances that should be kept separate from each other.

### Partition

![](images/ec2_placement_3.png)

- Partition divides each group into logical segments called partitions:
- Amazon EC2 ensures that each partition within a placement group has its own set of racks.
- Each rack has its own network and power source. No two partitions within a placement group share the same racks, allowing you to isolate the impact of hardware failure within your application.
- Distributed and replicated NoSQL database; requires separate hardware for node groups
- Partition placement groups can be used to deploy large distributed and replicated workloads, such as HDFS, HBase, and Cassandra, across distinct racks

### Differences

<table><tbody><tr><td>&nbsp;</td><td><strong>Clustered</strong></td><td><strong>Spread</strong></td><td><strong>Partition</strong></td></tr><tr><td>What</td><td>Instances are placed into a low-latency group within a single AZ</td><td>Instances are spread across underlying hardware</td><td>Instances are grouped into logical segments called partitions which use distinct hardware</td></tr><tr><td>When</td><td>Need low network latency and/or high network throughput</td><td>Reduce the risk of simultaneous instance failure if underlying hardware fails</td><td>Need control and visibility into instance placement</td></tr><tr><td>Pros</td><td>Get the most out of enhanced networking Instances</td><td>Can span multiple AZs</td><td>Reduces likelihood of correlated failures for large workloads.</td></tr><tr><td>Cons</td><td>Finite capacity: recommend launching all you might need up front</td><td>Maximum of 7 instances running per group, per AZ</td><td>Partition placement groups are not supported for Dedicated Hosts</td></tr></tbody></table>



## Billing and provisioning

![](images/ec2_billing_1.png)

There are several options for how you consume and pay for Amazon EC2 instances.

### On demand

- Pay for hours used with no commitment.
- Low cost and flexibility with no upfront cost.
- Ideal for auto scaling groups and unpredictable workloads.
- Good for dev/test.

### Spot

![](images/ec2_billing_4.png)

- Amazon EC2 Spot Instances let you take advantage of unused EC2 capacity in the AWS cloud.
- Spot Instances are available at up to a 90% discount compared to On-Demand prices.
- You can use Spot Instances for various stateless, fault-tolerant, or flexible applications such as big data, containerized workloads, CI/CD, web servers, high-performance computing (HPC), and other test & development workloads.
- You can request Spot Instances by using the Spot management console, CLI, API or the same interface that is used for launching On-Demand instances by indicating the option to use Spot.
- You can also select a Launch Template or a pre-configured or custom Amazon Machine Image (AMI), configure security and network access to your Spot instance, choose from multiple instance types and locations, use static IP endpoints, and attach persistent block storage to your Spot instances.
- New pricing model: The Spot price is determined by long term trends in supply and demand for EC2 spare capacity.
- You don’t have to bid for Spot Instances in the new pricing model, and you just pay the Spot price that’s in effect for the current hour for the instances that you launch.
- Spot Instances receive a two-minute interruption notice when these instances are about to be reclaimed by EC2, because EC2 needs the capacity back.
- Instances are not interrupted because of higher competing bids.
- To reduce the impact of interruptions and optimize Spot Instances, diversify, and run your application across multiple capacity pools.
- Each instance family, each instance size, in each Availability Zone, in every Region is a separate Spot pool.
- You can use the RequestSpotFleet API operation to launch thousands of Spot Instances and diversify resources automatically.
- To further reduce the impact of interruptions, you can also set up Spot Instances and Spot Fleets to respond to an interruption notice by stopping or hibernating rather than terminating instances when capacity is no longer available.

![](images/ec2_billing_5.png)

### Reserved

![](images/ec2_billing_2.png)

- Purchase (or agree to purchase) usage of EC2 instances in advance for significant discounts over On-Demand pricing.
- Provides a capacity reservation when used in a specific AZ.
- AWS Billing automatically applies discounted rates when you launch an instance that matches your purchased RI.
- Capacity is reserved for a term of 1 or 3 years.
- EC2 has three RI types: **Standard**, **Convertible**, and **Scheduled**.
- **Standard** = commitment of 1 or 3 years, charged whether it’s on or off.
- **Scheduled** = reserved for specific periods of time, accrue charges hourly, billed in monthly increments over the term (1 year).
- Scheduled RIs match your capacity reservation to a predictable recurring schedule.
- For the differences between standard and convertible RIs, see the table below.
- RIs are used for steady state workloads and predictable usage.
- Ideal for applications that need reserved capacity.
- Upfront payments can reduce the hourly rate.
- Can switch AZ within the same region.
- Can change the instance size within the same instance type.
- Instance type modifications are supported for Linux only.
- Cannot change the instance size of Windows RIs.
- Billed whether running or not.
- Can sell reservations on the AWS marketplace.
- Can be used in Auto Scaling Groups.
- Can be used in Placement Groups.
- Can be shared across multiple accounts within Consolidated Billing.
- If you don’t need your RI’s, you can try to sell them on the Reserved Instance Marketplace.

<table><tbody><tr><td>&nbsp;</td><td>Standard</td><td>Convertible</td></tr><tr><td>Terms</td><td>1 year, 3 year</td><td>1 year, 3 year</td></tr><tr><td>Average discount off On-Demand price</td><td>40% – 60%</td><td>31% – 54%</td></tr><tr><td>Change AZ, instance size, networking type</td><td>Yes via ModifyReservedInstance API or console</td><td>Yes via ExchangeReservedInstance API or console</td></tr><tr><td>Change instance family, OS, tenancy, payment options</td><td>No</td><td>Yes</td></tr><tr><td>Benefit from price reductions</td><td>No</td><td>Yes</td></tr></tbody></table>

### Comparison

<table><tbody><tr><td><strong>On-Demand</strong></td><td><strong>Reserved</strong></td><td><strong>Spot</strong></td></tr><tr><td>No upfront fee</td><td>Options: No upfront, partial upfront or all upfront</td><td>No upfront fee</td></tr><tr><td>Charged by hour or second</td><td>Charged by hour or second</td><td>Charged by hour or second</td></tr><tr><td>No commitment</td><td>1-year or 3-year commitment</td><td>No commitment</td></tr><tr><td>Ideal for short term needs or unpredictable workloads</td><td>Ideal for steady-state workloads and predictable usage</td><td>Ideal for cost-sensitive, compute intensive use cases that can withstand interruption</td></tr></tbody></table>

### Limits
 
You are limited to running up to a total of 20 On-Demand instances across the instance family, purchasing 20 Reserved Instances, and requesting Spot Instances per your dynamic spot limit per region (by default).

## On-Demand Capacity Reservations

- Reserve compute capacity for your Amazon EC2 instances in a specific Availability Zone
- Any duration can be specified
- Mitigates against the risk of being unable to get On-Demand capacity
- Does not require any term commitments and can be cancelled at any time
- When you create a Capacity Reservation, you specify:
  - The Availability Zone in which to reserve the capacity
  - The number of instances for which to reserve capacity
  - The instance attributes, including the instance type, tenancy, and platform/OS

## Dedicated hosts and instances

### Dedicated hosts

- Physical servers dedicated just for your use.
- You then have control over which instances are deployed on that host.
- Available as On-Demand or with Dedicated Host Reservation.
- Useful if you have server-bound software licenses that use metrics like per-core, per-socket, or per-VM.
- Each dedicated host can only run one EC2 instance size and type.
- Good for regulatory compliance or licensing requirements.
- Predictable performance.
- Complete isolation.
- Most expensive option.
- Billing is per host.

### Dedicated instances

- Virtualized instances on hardware just for you.
- Also uses physically dedicated EC2 servers.
- Does not provide the additional visibility and controls of dedicated hosts (e.g. how instances are placed on a server).
- Billing is per instance.
- May share hardware with other non-dedicated instances in the same account.
- Available as On-Demand, Reserved Instances, and Spot Instances.
- Cost additional $2 per hour per region.

<table><tbody><tr><td><strong>Characteristic</strong></td><td><strong>Dedicated Instances</strong></td><td><strong>Dedicated Hosts</strong></td></tr><tr><td>Enables the use of dedicated physical servers</td><td>X</td><td>X</td></tr><tr><td>Per instance billing (subject to a $2 per region fee)</td><td>X</td><td>&nbsp;</td></tr><tr><td>Per host billing</td><td>&nbsp;</td><td>X</td></tr><tr><td>Visibility of sockets, cores, host ID</td><td>&nbsp;</td><td>X</td></tr><tr><td>Affinity between a host and instance</td><td>&nbsp;</td><td>X</td></tr><tr><td>Targeted instance placement</td><td>&nbsp;</td><td>X</td></tr><tr><td>Automatic instance placement</td><td>X</td><td>X</td></tr><tr><td>Add capacity using an allocation request</td><td>&nbsp;</td><td>X</td></tr></tbody></table>

### Use cases

![](images/ec2_billing_6.png)

![](images/ec2_billing_7.png)


## Saving plans

![](images/ec2_billing_3.png)



# EBS Elastic block storage
К каждому инстансу ec2 подключается volume который можно расширять по мере необходимости. 
Но он доступн в один момент времени только для одного инстанса. Можно делать периодические снепшоты с volume, т.е слепки файловой системы. Отличается от создание образов на основе инстанса т.к сохраняет только файловую систему.

Volumes attaches over network. It is not physical storage on the Ec2 instances. It is network block storage. 

EBS volumes exists within AZ. And automatically replecated within the AZ

There are several types of EBS volumes.

![Volume view](images/ebs_1.png)

Instance store is attached physically to EC2 instance but it is not persisent. They come with some instance types. They offer extreamely high performance. 

It is possible to create snaphots of the EBS volumes. Actually it saved on the S3 - outside of the AZ of volume and instance. Each shaphost is incremental, it saves only changes between versions. 

Default volume created with a new EC2 instance, but it fade away after termination of the instance. 

Amazon EBS volumes are not encrypted by default without additional configuration.but can be encrypted for all current generation instance types and specific previous generation instance types. 


# EFS Elastic file system
Можно создать общую файловую систему, которую можно разделять между инстансами ec2.
Итого имеем 2 инстанса, хотим сделать общую папку между ними. But only within one region and only for linux instances using NFS protocol. (/efs-mnt)  

it is possible connect on-premice data center to EFS using direct connect or VPN

## Using Amazon EFS with Lambda

Lambda integrates with Amazon Elastic File System (Amazon EFS) to support secure, shared file system access for Lambda applications. You can configure functions to mount a file system during initialization with the NFS protocol over the local network within a VPC. Lambda manages the connection and encrypts all traffic to and from the file system.

The file system and the Lambda function must be in the same region. A Lambda function in one account can mount a file system in a different account. For this scenario, you configure VPC peering between the function VPC and the file system VPC.

Amazon EFS supports file locking to prevent corruption if multiple functions try to write to the same file system at the same time. Locking in Amazon EFS follows the NFS v4.1 protocol for advisory locking, and enables your applications to use both whole file and byte range locks.

Amazon EFS provides options to customize your file system based on your application's need to maintain high performance at scale. There are three primary factors to consider: the number of connections, throughput (in MiB per second), and IOPS.

## Example
![Shared folder via EFS](images/efs_1.png)

Создадим файловую систему через efs

![Shared folder via EFS](images/efs_2.png)
![Shared folder via EFS](images/efs_3.png)
![Shared folder via EFS](images/efs_4.png)
![Shared folder via EFS](images/efs_5.png)
потом нужно подкрутить security group чтобы трафик мог ходить между сервисами aws. 
Добавляем для каждого инстанса
![Shared folder via EFS](images/efs_6.png)
![Shared folder via EFS](images/efs_7.png)

На самом деле лучше создать отдельную SG где разрешить трафику ходить по NFS протоколу для обоих инстансов.

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

## Overview

- Можно создавать бакеты (buckets) и в них создавать файлы. 
- Доступ можно настраивать как на файлы так и на бакеты. Лучше для публичных данных создавать отдельный бакет. 
- Имя бакета уникально globally. Т.е назвать tests3 нельзя. 
- Size of files from 0 bytes to 5 TB
- Buckets are withing a region. Therefore it is a best practice to create buckets in regions that are physically closest to your users to reduce latency
- There is no hierarchy for objects within the bucket 
- From 2020 delivers strong read-after-write consistency (before there was eventual consistency)
![](images/s3_overview_1.png)

actually files hiararcy mimics through the key parts of url. 

![](images/s3_mimic_folder.png)

An object consists of:
- Key (the name of the object)
- Version ID
- Value (actual data)
- Metadata
- Subresources
- Access control information

## Accessing s3

![](images/s3_access.png)

- It is possible to access from vps to s3 bucket through the **internet gateway** via internet or using **s3 Gataway Endpoint** not using internet.  

## Security

Several means to secure s3

- IAM user identity-based policy (are attached to IAM users, groups, or roles)
- S3 resource-based policy (Can only be attached to Amazon S3 buckets)
- S3 Access Controls Lists (ACLs) (old approach) - Can be attached to a bucket or directly to an object

- The `Principal` element is not required in the policy
- AWS generally recommends using S3 bucket policies or IAM policies rather than ACLs

Use IAM policies if:

- You need to control access to AWS services other than S3
- You have numerous S3 buckets each with different permissions requirements (IAM policies will be easier to manage)
- You prefer to keep access control policies in the IAM environment

Use S3 bucket policies if:
- You want a simple way to grant cross account access to your S3 environment, without using IAM roles
-  Your IAM policies are reaching the size limits
- You prefer to keep access control policies in the S3 environment

By adding a condition to the S3 bucket policy that requires `aws:SecureTransport`, you are mandating that all interactions with the bucket must be encrypted in transit using SSL/TLS.

### Example using ACL

let's crate a bucket with enabled acl

![](images/s2_acl_1.png)

put some file there

![](images/s3_acl_2.png)

by default we do not have an access to this file

![](images/s3_acl_3.png)

add acl to the bucket 

![](images/s3_acl_4.png)

![](images/s3_acl_5.png)

![](images/s3_acl_6.png)

still denied

![](images/s3_acl_3.png)

again to permission
![](images/s3_acl_7.png)

acl to bucket
![](images/s3_acl_8.png)

still denied

![](images/s3_acl_3.png)

put acl to the object

![](images/s3_acl_9.png)

![](images/s3_acl_10.png)

and finally accessed

![](images/s3_acl_11.png)

### Using IAM policies and bucket policies

it possible to add user policy here

![](images/s3_policies_1.png)

#### List buckets (user policy)

```json
{
	"Version": "2012-10-17", 
	"Statement":[
		{
			"Sid": "AllowGroupToSeeBucketListInTheConsole",
			"Action": ["s3:ListAllMyBuckets"], 
			"Effect": "Allow", 
			"Resource": ["arn:aws:s3:::*"]
		}
	]
}
```

#### 2 See root-level bucket items (user policy)

```json
{
	"Version": "2012-10-17", 
	"Statement": [
		{
			"Sid": "AllowGroupToSeeBucketListAndAlsoAllowGetBucketLocationRequiredForListBucket", 
			"Action": [ "s3:ListAllMyBuckets", "s3:GetBucketLocation" ], 
			"Effect": "Allow", 
			"Resource": [ "arn:aws:s3:::*" ]
		},
		{
			"Sid": "AllowRootLevelListingOfCompanyBucket", 
			"Action": ["s3:ListBucket"], 
			"Effect": "Allow", 
			"Resource": ["arn:aws:s3:::YOURBUCKETNAME"], 
			"Condition":{ 
				"StringEquals":{
					"s3:prefix":[""], "s3:delimiter":["/"]
			}
				}
		}
	]
}
```

####  View the Department folder contents (user policy)

```json
{
	"Version": "2012-10-17", 
	"Statement": [
		{
			"Sid": "AllowGroupToSeeBucketListAndAlsoAllowGetBucketLocationRequiredForListBucket", 
			"Action": [ "s3:ListAllMyBuckets", "s3:GetBucketLocation" ], 
			"Effect": "Allow", 
			"Resource": [ "arn:aws:s3:::*" ]
		},
		{
			"Sid": "AllowRootLevelListingOfCompanyBucket", 
			"Action": ["s3:ListBucket"], 
			"Effect": "Allow", 
			"Resource": ["arn:aws:s3:::YOURBUCKETNAME"], 
			"Condition":{ 
				"StringEquals":{
					"s3:prefix":[""], "s3:delimiter":["/"]
			}
				}
		},
		{
		"Sid": "AllowListBucketIfSpecificPrefixIsIncludedInRequest", 
		"Action": ["s3:ListBucket"], 
		"Effect": "Allow", 
		"Resource": ["arn:aws:s3:::YOURBUCKETNAME"],
		"Condition":{ "StringLike":{"s3:prefix":["Department/*"]}
		}
	}
	]
}
```

#### Get and put objects in the Department folder (user policy)

```json
{
	"Version": "2012-10-17", 
	"Statement":[
	{
		"Sid": "AllowGroupToSeeBucketListAndAlsoAllowGetBucketLocationRequiredForListBucket", 
		"Action": [ "s3:ListAllMyBuckets", "s3:GetBucketLocation" ], 
		"Effect": "Allow", 
		"Resource": [ "arn:aws:s3:::*" ]
	},
	{
		"Sid": "AllowRootLevelListingOfCompanyBucket", 
		"Action": ["s3:ListBucket"], 
		"Effect": "Allow", 
		"Resource": ["arn:aws:s3:::YOURBUCKETNAME"], 
		"Condition":{ 
			"StringEquals":{
				"s3:prefix":[""], "s3:delimiter":["/"]
		}
			}
	},
	{
		"Sid":"AllowListBucketIfSpecificPrefixIsIncludedInRequest", "Action":["S3:ListBucket"], 
		"Effect":"Allow", 
		"Resource": ["arn:aws:s3:::YOURBUCKETNAME"], 
		"Condition":{
			"StringLike":{"s3:prefix":["Department/*"]
			}
		}
	},
{
		"Sid":"AllowUserToReadWriteObjectDataInDepartmentFolder", 
		"Action":["s3:GetObject", "s3:PutObject"], 
		"Effect":"Allow", 
		"Resource":["arn:aws:s3:::YOURBUCKETNAME/Department/*"]
	}
	]
}
```

#### Explicitly grant access to user to list the Confidential folder (Bucket Policy) - use with policy 2 above

it is possible to use a combination user-policies and bucket-policy.

to add a bucket policsy 

![](images/s3_policies_2.png)

```json
{
	"Version": "2012-10-17", 
	"Id": "Policy1561964929358", 
	"Statement":[
	{
		"Sid": "Stmt1561964454052", 
		"Effect": "Allow", 
		"Principal": {
			"AWS": "arn:aws:iam::138422235973:user/Paul"
		},
		"Action": "s3:*", 
		"Resource": "arn:aws:s3:::YOURBUCKETNAME",
		"Condition": {
			"StringLike": {
				"s3:prefix": "Confidential/*"
			}
		}
	}
	]
}
```

## MFA

### S3 Multi Factor Authentication Delete (MFA Delete)

Adds MFA requirement for bucket owners to the following operations:
- Changing the versioning state of a bucket
- Permanently deleting an object version

The `x-amz-mfa` request header must be included in the above requests

The second factor is a token generated by a hardware device or software program

Requires `versioning` to be enabled on the bucket

`Versioning` can be enabled by:
  - Bucket owners (root account)
  - AWS account that created the bucket
  - Authorized IAM users

MFA delete can be enabled by:
  - Bucket owner (root account)

### MFA protected API access (not only s3)

![](images/s3_mfa_1.png)

### Encryption

- All Amazon S3 buckets have encryption configured by default (from some moment of history)
- All new object uploads to Amazon S3 are automatically encrypted
- There is no additional cost and no impact on performance
- Objects are automatically encrypted by using server side encryption with Amazon S3 managed keys (SSE S3)
- To encrypt existing unencrypted Amazon S3 objects, you can use Amazon S3 Batch Operations
- You can also encrypt existing objects by using the CopyObject API operation or the copy object AWS CLI command

![](images/s3_encryption_1.png)

![](images/s3_encryption_2.png)

an example where we have a requirements to use encryption with kms

![](images/s3_encryption_3.png)

example bucket policy to deny without server-side encryption

```json
{
    "Version": "2012-10-17",
    "Id": "PutObjPolicy",
    "Statement": [
        {
            "Sid": "DenyUnEncryptedObjectUploads",
            "Effect": "Deny",
            "Principal": "*",
            "Action": "s3:PutObject",
            "Resource": "arn:aws:s3:::YOUR-BUCKET-NAME/*",
            "Condition": {
                "Null": {
                    "s3:x-amz-server-side-encryption": "true"
                }
            }
        }
    ]
}
```

and it is posiiible to apply a default encryption in bucket without policy just a by setting.



Command without encryption: 

```bash
aws s3 cp YOUR-FILE-NAME s3://YOUR-BUCKET-NAME`
```

Command with encryption: 

```bash
aws s3api put-object --body YOUR-FILE-NAME --key YOUR-FILE-NAME --bucket YOUR-BUCKET-NAME --server-side-encryption AES256`
```

## S3 Event Notifications

to add notification to en email via SNS service when file uploads to s3 bucket

create a SNS topic

![](images/s3_sns_1.png)

create subsription on sns topic 

![](images/s3_sns_2.png)

![](images/s3_sns_3.png)

then an email will be sent on a email for activate subscription, approval subscription required.

![](images/s3_sns_4.png)

configure access policy to our topic

copy arn of topic 

![](images/s3_sns_5.png)


put topic arn to `Resource` and copy account id from the arn to the `SourceAccount`.  And paste arn for bucket to `aws:SourceArn`

```json
{
 "Version": "2012-10-17",
 "Id": "AllowS3Publish",
 "Statement": [
  {
   "Sid": "S3EventNotification",
   "Effect": "Allow",
   "Principal": {
     "Service": "s3.amazonaws.com"  
   },
   "Action": [
    "SNS:Publish"
   ],
   "Resource": "arn:aws:sns:eu-north-1:967120122177:Email-Me",
   "Condition": {
      "ArnLike": { "aws:SourceArn": "arn:aws:s3:::test2342342223" },
      "StringEquals": { "aws:SourceAccount": "967120122177" }
   }
  }
 ]
}
```

and put that json to the access policy on topic. Actually is a grant to publish to this topic events from particular bucket.

![](images/s3_sns_6.png)

then we need to configure a notification event from bucket. Go to the bucket settings.

![](images/s3_sns_7.png)

![](images/s3_sns_8.png)

![](images/s3_sns_9.png)

![](images/s3_sns_10.png)

if we put a file to this bucket we will get similar email

![](images/s3_sns_11.png)


## Storage classes

![](images/s3_storage_type_1.png)

## Example

![S3](images/s3_1.png)
![S3](images/s3_2.png)
![S3](images/s3_3.png)
![S3](images/s3_4.png)

Есть также S3 Glacier метафора про холодильник, достать данные из которого потребует значительного времени, но дешевле чем S3. Подходит для бекапов, логов и тд, которые не нужно постоянно читать. Можно настроить политику переноса данных в Glasier после некоторого времени хранения. 

Также если нужен CDN , есть CloudFront. Например если делаем статический сайт и храним его в S3 бакете, можно настроить CloudFront так, чтобы в зависимости от расположения пользователя выбирался ближайший сервис, чтобы сделать загрузку быстрее.

## Preassigned temporary url

We have a bucket with an object and we do not have a public access to this object

![](images/s3_preassigned_url_1.png)

```bash
aws s3 presign s3://test2342342223/2880px-Hovhannes_Aivazovsky_-_The_Ninth_Wave_-_Google_Art_Project.jpg
```

![](images/s3_preassigned_url_2.png)

![](images/s3_preassigned_url_3.png)

temproray url with 3600 seconds by defualt.

## Log bucket events to the another bucket

-  Provides detailed records for the requests that are made to a bucket
- Details include the requester, bucket name, request time, request action, response status, and error code (if applicable)
- Disabled by default
- Only pay for the storage space used
- Must configure a separate bucket as the destination (can specifya prefix)
- Must grant write permissions to the Amazon S3 Log Delivery group on destination bucket

## CORS with S3 bucket

![](images/s3_cors_1.png)

Enabled through setting:
- Access-Control-Allow-Origin
- Access-Control-Allow-Methods
- Access-Control-Allow-Headers

- These settings are defined using rules
- Rules are added using JSON files in S3
- Rules added to that bucket that it will be accessed from different origin

![](images/s3_cors_2.png)

## S3 Optimization patterns

- S3 Automatically scales to high request rates with at least (per prefix):
  - 3,500 PUT/COPY/POST/DELETE requests/second
  - 5,500 GET/HEAD requests/second
- Can increase read and write performance by using parallelization across multiple prefixes
- To increase uploads over long distances, use Amazon S3 Transfer Acceleration
- Byte Range fetches use the Range HTTP header to transfer only specified byte range from an object
- Combine S3 and EC2 in the same AWS Region
- Use the latest version of the AWS SDKs
- Use caching services to cache the latest content:
  - Amazon CloudFront (CDN)
  - Amazon ElastiCache (in memory cache)
- Horizontally scale requests across S3 endpoints

# CloudFront (CDN)

![](images/cloudfront_1.png)

in cloudfront we create a distribution. 

![](images/cloudfront_2.png)

## Origins

An origin is the origin of the files that the CDN will distribute.

Origins can be
- S3 bucket
- EC2 instance
- Elastic Load Balancer,
- Route 53 – can also be external (non-AWS).

## High availability with Origin Failover

- Can set up CloudFront with origin failover for scenarios that require high availability.
- Uses an origin group in which you designate a primary origin for CloudFront plus a second origin that CloudFront automatically switches to when the primary origin returns specific HTTP status code failure responses.
- Also works with Lambda@Edge functions.

## Sign URL

An analogus to sign url for s3 bucket. It can be possible to use to get a cloud front after authenication via some different endpoint for example a lambda function.

![](images/cloudfront_3.png)

## Sign cookies

- Similar to Signed URLs
- Use signed cookies when you don’t want to change URLs
- Can also be used when you want to provide access to multiple restricted files (Signed URLs are for individual files)

## CloudFront origin access identity OAI

Only for s3 bucket. Access to bucket via bucket policy only for a specific cloudfront user. 

![](images/cloudfront_4.png)

Possible it can be deprecated soon.

## Cloudfront OAC

![](images/cloudfront_5.png)

## Origin response trigger

When CloudFront receives an HTTP response from the origin server, if there is an origin-response trigger associated with the cache behavior, you can modify the HTTP response to override what was returned from the origin.

Some common scenarios for updating HTTP responses include the following:

   • Changing the status to set an HTTP 200 status code and creating static body content to return to the viewer when an origin returns an error status code (4xx or 5xx)

   • Changing the status to set an HTTP 301 or HTTP 302 status code, to redirect the user to another website when an origin returns an error status code (4xx or 5xx)

When you're working with the HTTP response, Lambda@Edge does not expose the body that is returned by the origin server to the origin-response trigger. You can generate a static content body by setting it to the desired value, or remove the body inside the function by setting the value to be empty. If you don't update the body field in your function, the original body returned by the origin server is returned back to viewer.

## Example static website 

1. Create a s3 bucket.
2. updoad index.html and error.html to bucket

3. enable bucket properties to host static web site.

![](images/cloudfront_6.png)

after that bucket properties it is possible to find a url for static web site. But in this case is should be not accessible. 

![](images/cloudfront_7.png)

4. create distribution 

![](images/cloudfront_8.png)

![](images/cloudfront_9.png)

![](images/cloudfront_10.png)

after a couple of minutes it will be deployes around the world. It is possible to copy url to test a website.

![](images/cloudfront_11.png)

![](images/cloudfront_12.png)

# Route 53

![](images/route53_1.png)

![](images/route53_2.png)

![](images/route53_3.png)

# CloudFormation

![](images/cloudformation_1.png)

- Infrastructure is provisioned consistently with fewer human error
- Less time and effort than configuring resources manually 
- You can use version control and peer review for your CloudFormation templates
- free to use
- can be used to manage updates and dependencies
- can be used to rollback and delete the entire stack

**templates** - the JSON or YAML that contains the instruction for building out the AWS environment

**Stacks** - The entire environment described by the template and created updated and deleted as a single unit

**StackSets** - extends functionality of stacks by enabling you to create update or delete stacks across multiple accounts and regions with a single operation

**Change Sets** - A summary of proposed changes to your stack that will allow you to see how those changes might impact your existing resources before implementing them

- stacks are deployed through the Management Console, CLI or APIs.

Stack creating error:
  - Automatic rollback on error is enabled by default
  - you will be charged for resources provisioned even if there is an error

An administrator account is the AWS account in which you can crate **StackSets**

A target account is the account into which you create update delete one or more stacks in your stack set

## Nested stacks

Nested stacks allow re-use of CloudFormation code for common use cases

Create a standart template for each common use case and reference it from within your CloudFormation template

## Examples

create a bucket 

```yml
AWSTemplateFormatVersion: 2010-09-09
Resources:
  S3Bucket:
    Type: AWS::S3::Bucket
    Description: Create Amazon S3 bucket using CloudFormation
    Properties:
      BucketName: my-test-bucket-1342323
Outputs:
  S3Bucket:
    Description: S3 bucket created from a CloudFormation template
    Value: !Ref S3Bucket
```

create a bucket with default encryption

```yml
AWSTemplateFormatVersion: 2010-09-09
Resources:
  S3Bucket:
    Type: AWS::S3::Bucket
    Description: Create Amazon S3 bucket using CloudFormation
    Properties:
      BucketName: YOUR-BUCKET-NAME
      BucketEncryption:
        ServerSideEncryptionConfiguration:
          - ServerSideEncryptionByDefault:
              SSEAlgorithm: AES256
Outputs:
  S3Bucket:
    Description: S3 bucket created from a CloudFormation template
    Value: !Ref S3Bucket
```

bucket with versioning
```yml
AWSTemplateFormatVersion: 2010-09-09
Resources:
  S3Bucket:
    DeletionPolicy: Retain
    Type: AWS::S3::Bucket
    Description: Create Amazon S3 bucket using CloudFormation
    Properties:
      BucketName: my-test-bucket-1342323
      BucketEncryption:
        ServerSideEncryptionConfiguration:
          - ServerSideEncryptionByDefault:
              SSEAlgorithm: AES256
      VersioningConfiguration:
        Status: Enabled
Outputs:
  S3Bucket:
    Description: S3 bucket created from a CloudFormation template
    Value: !Ref S3Bucket
```

Let's create a simple bucket. 

![](images/cloudformation_2.png)
![](images/cloudformation_3.png)

select a file with "create a bucket " yaml

![](images/cloudformation_4.png)

![](images/cloudformation_5.png)
 
 outputs are from the yml file

![](images/cloudformation_6.png)


let's edit bucket and add versioning

![](images/cloudformation_7.png)

![](images/cloudformation_8.png)

it is possible to see that bucket will be changed after applying this template and how it will be changed

![](images/cloudformation_9.png)

![](images/cloudformation_10.png)

and then let's apply created change set

![](images/cloudformation_11.png)

![](images/cloudformation_12.png)

if we delete a stack, then resources also can be deleted. It depends on the their DeletePolicy in template. 

## Template features

**Logical ID** used to reference resources within the template

**Physical ID** identity resources outside of CloudFormation temlates, but only after the resources have been created

### Resources

The required Resources section declares the AWS resources that you want to include in the stack, such as an Amazon EC2 instance or an Amazon S3 bucket

This is a mandatory section

Resources are declared and can be reference each other

```yml
Resources:
  myEC2Instance:
    Type: "AWS::EC2::Instance"
    Properties:
      ImageId: "ami-4424323"
```

### Parameters

optionl Parameters section to customuze templates

Parameters enable you to input custom values to your template each time you create or update a stack

Useful for template reuse

```yml
Parameters:
  InstanceTypeParameter:
    Type: String
    Default: t2.micro
    AllowedValues:
      - t2.micro
      - m1.small
      - m1.large
    Description: "Enter instance type"
```

### Mappings

optional Mappings section matches a key to a corresponding set of named values

```yml
Mappings:
  RegionMap:
    us-east-1: 
      HVM64: "ami-234234234"
      HVMG2: "ami-sdfsdfs"
    us-west-1:
      HVM64: "ami-333"
      HVMG2: "ami-34545"
```

With mappings you can set values based on a region. 

### Outputs 

optional Outputs section declares output values that you can import into other stacks (to create cross-stacks references), return in response (to describe stack calls), or view on the AWS CloudFormation console

```yml
Outputs:
  StackVPC:
    Description: The ID of the VPC
    Value: !Ref MyVPC
    Export:
      Name: !Sub "${AWS::StackName}-VPCID"
```

### Conditions

optional Conditions section contains statements that define a circumstances under which entities are created or configured

```yml
Conditions:
  CreateProdResources: !Equals [ !Ref EnvType, prod ]
```

### Transform

optional Transfrom section specifies one or more macros that CloudFormation uses to process your template

can be used to reference additional code stored in S3, such as Lambda code or reusable snippets of CloudFormation code

`AWS::Serverless` transform specifies a version of the AWS Servless Applicaton Model (AWS SAM) to use. This model defines the AWS SAM syntax that you can use how CloudFormation processes it

`AWS::Include` transform works with template snippet that are stored separately from the main CloudFormation template

```yml
Transform: AWS::Serverless-2016-10-31
Resources:
  MyServerlessFunctionLogicalID:
    Type: AWS::Serverless::Function
    Properties:
      Handler: index.handler
      Runtime: nodejs8.10
      CodeUri: 's3://testBucket/mySourceCode.zip'
```

### Intrinsic functions

Use intrinsic functions in templates to assign values to properties that are not available until runtime

[Intrinsic functions](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/intrinsic-function-reference.html)

#### Ref

returns the value of the specified parameter or resource

When you specify a parameter's logical name, it returns the value of the parameter

When you specify a resource's logical name, it returns a value that you can typically use to refer to that resource, such as a physical ID

The following resource declaration for an Elastic IP address needs the instance ID of an EC2 instance and uses the Ref function to specify the intsance ID of the MyEC2Instance resource

```yml
MyEIP:
  Type: "AWS::EC2::EIP"
  Properties:
    InstanceId: !Ref MyEC2Instance
```

#### Fn::GetAtt

Returns the value of an attribute from a resource in the template

Full synstax (YAML)

```
Fn::GetAtt: [logicalNameOfResource, attributeName]
```

Short form (YAML)

```
!GetAtt logicalNameOfResource.attributeName
```

```yml
AWSTemplateFormatVersion: 2010-09-09
Resources:
  myELB:
    Type: AWS::ElasticLoadBalancing::LoadBalancer
    Properties:
      AvailabilityZones:
        - eu-west-1a
      Listeners:
        - LoadBalancerPort: '80'
          InstancePort: '80'
          Protocol: HTTP
  myELBIngressGroup:
    Type: AWS::EC2::SecurityGroup
    Properties:
      GroupDescription: ELB ingress group
      SecurityGroupIngress:
        - IpProtocol: tcp
          FromPort: '80'
          ToPort: '80'
          SourceSecurityGroupOwnerId: !GetAtt myELB.SourceSecurityGroup.OwnerAlias
          SourceSecurityGroupName: !GetAtt myELB.SourceSecurityGroup.GroupName
```

#### Fn:FindInMap

returns the value corresponding to keys in a two-level map that is declared in the Mappings section

Full Syntax (YAML)

```
Fn::FindInMap:[MapName, TopLevelKey, SecondLevelKey]
```

Short Syntax (YAML)

```
!FindInMap [MapName, TopLevelKey, SecondLevelKey]
```

```yml
Mappings:
  RegionMap:
    us-east-1: 
      HVM64: "ami-234234234"
      HVMG2: "ami-sdfsdfs"
    us-west-1:
      HVM64: "ami-333"
      HVMG2: "ami-34545"
Resources:
  myEC2Instance:
    Type: "AWS::EC2::Instance"
    Properties:
      ImageId: !FindInMap
        - RegionMap
        - !Ref 'AWS:Region'
        - HVM64
      InstanceType: m1.small
```

## Pseudo parameters

In AWS CloudFormation, the `AWS::Region` pseudo parameter automatically resolves to the Region where the stack is being created or updated. This makes it the most operationally efficient way to determine the Region in which the template is being deployed, as it doesn't require any additional input, processing, or external service calls.

# Elastic Beanstalk

Managed web apps. Abstraction on vpc, subnets, auto scaling groups and alb. 

![](images/beanstalk_1.png)

Supports Java, .NET, PHP, Node.js, Python, Ruby, Go, and Docker web applications

Supports the following languages and development stacks:
- Apache Tomcat for Java applications
- Apache HTTP Server for PHP applications
- Apache HTTP Server for Python applications
- Nginx or Apache HTTP Server for Node.js applications
- Passenger or Puma for Ruby applications
- Microsoft IIS 7.5, 8.0, and 8.5 for .NET applications
- Java SE
- Docker
- Go

There are several layers
Applications:
- Contain environments, environment configurations, and application versions
- You can have multiple application versions held within an application

Application version:
- A specific reference to a section of deployable code
- The application version will point typically to an Amazon S3 bucket containing the code

Environments:
- An application version that has been deployed on AWS resources
- The resources are configured and provisioned by AWS Elastic Beanstalk
- The environment is comprised of all the resources created by Elastic Beanstalk and not just an EC2 instance with your uploaded code

![](images/beanstalk_2.png)

Type of environenment:

**Web servers** are standard applications that listen for and then process HTTP requests, typically over port 80

**Workers** are specialized applications that have a background processing task that listens for messages on an Amazon SQS queue

Workers should be used for long running tasks

![](images/beanstalk_3.png)

## Deployment options

### All at once  

- Deploys the new version to all instances simultaneously. 
- All of your instances are out of service while the deployment takes place
- Fastest deployment
- Good for quick iterations in development environment
- You will experience an outage while the deployment is taking place not ideal for mission critical systems
- If the update fails, you need to roll back the changes by re deploying the original version to all of your instances
- No additional cost
  
![](images/beanstalk_4.png)

### Rolling

- Update a few instances at a time (batch), and then move onto the next batch once the first batch is healthy
- Downtime affects 1 batch at a time
-  Application is running both versions simultaneously
- Each batch of instances is taken out of service while the deployment takes place
- Your environment capacity will be reduced by the number of instances in a batch while the deployment takes place
-  Not ideal for performance sensitive systems
- If the update fails, you need to perform an additional rolling update to roll back the changes
- No additional cost
- Long deployment time

### Rolling with additional batch

- Like Rolling but launches new instances in a batch ensuring that there is full availability
- Application is running at capacity
- Can set the batch size
- Application is running both versions simultaneously
- Small additional cost
- Additional batch is removed at the end of the deployment
- Longer deployment
- Good for production environments

### Immutable 

![](images/beanstalk_5.png)

- Launches new instances in a new ASG and deploys the version update to these instances before swapping traffic to these instances once healthy
- Zero downtime
- New code is deployed to new instances using an ASG
- High cost as double the number of instances running during updates
- Longest deployment
- Quick rollback in case of failures
- Great for production environments

### Blue/green

![](images/beanstalk_6.png)

- This is not a feature within Elastic Beanstalk
- You create a new "staging" environment and deploy updates there
- The new environment (green) can be validated independently, and you can roll back if there are issues
- Route 53 can be setup using weighted policies to redirect a a percentage of traffic to the staging environment
- Using Elastic Beanstalk, you can "swap URLs" when done with the environment test
- Zero downtime

## AWS Elastic Beanstalk configuration files

- You can add AWS Elastic Beanstalk configuration files (.ebextensions) to your web application's source code to configure your environment and customize the AWS resources that it contains

- Configuration files are YAML or JSON formatted documents with a `.config` file extension that you place in a folder
named `.ebextensions` and deploy in your application source bundle

```yml
option_settings:
  aws:elasticbeanstalk:environment:
    LoadBalancerType: network
```

`option_settings` section of a configuration file defines values for configuration options

The `Resources` section lets you further customize the resources in your application's environment and define additional AWS resources beyond the functionality provided by configuration options

Additional sections of a configuration file let you configure the EC2 instances that are launched in your environment. These include packages, sources, files, users, groups, commands, container_commands, and services

## SSL/TLS

- SSL/TLS certificates can be assigned to an environment’s Elastic Load Balancer
- Can use AWS Certificate Manager (ACM)
- The connections between clients and the load balancer are secured
- Backend connections between the load balancer and EC2 instances are not secured

You can configure the certificate through the console or through .ebestenstions

```yml 
option_settings:
  aws:elbv2:listener:443:
    ListenerEnabled: 'true'
    Protocol: HTTPS
    SSLCertificateArns: arnXXX
```

- For end to end encryption you can encrypt the backend connections as well
- Can use a self signed certificate on the EC2 instances
- Configuration can be made using `.ebextensions` (load balancer dependent)
- For example, using the `.ebextensions/httpsreencrypt.alb.config` configuration file

```yml 
option_settings:
  aws:elbv2:listener:443:
    DefaultProtocol: https
    ListenerEnabled: 'true'
    Protocol: HTTPS
  aws:elasticbeanstalk:environment:process:https:
    Port: '443'
    Protocol: HTTPS
```

To configure HTTP to HTTPS redirection, do one of the following:

- Configure the instance web servers - configure EC2 web servers to respond to HTTP traffic with an HTTP redirection response status (platform dependent config)
- Configure the load balancer configure the ALB to send redirection responses to HTTP traffic

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

to launch ec2 instance 

```bash
aws ec2 run-instances --image-id <value> --instance-type <value> --security-group-ids <value> --subnet-id <value> --key-name <value> --user-data <value>
```
where `user-data` is a file with initial script to launch on the instance

an example
```bash
aws ec2 run-instances --image-id ami-0c858d4d1feca5370 --instance-type t3.micro --security-group-ids sg-0917c91808bf2ba66 --subnet-id subnet-038d00f0903190f25 --key-name wishlist --user-data file://data.txt
```

where in user script is
```bash
#!/bin/bash
yum update -y
yum install -y httpd
systemctl start httpd
systemctl enable httpd
INTERFACE=$(TOKEN=`curl -X PUT "http://169.254.169.254/latest/api/token" -H "X-aws-ec2-metadata-token-ttl-seconds: 21600"` && curl -H "X-aws-ec2-metadata-token: $TOKEN" -v http://169.254.169.254/latest/meta-data/network/interfaces/macs/)
SUBNETID=$(TOKEN=`curl -X PUT "http://169.254.169.254/latest/api/token" -H "X-aws-ec2-metadata-token-ttl-seconds: 21600"` && curl -H "X-aws-ec2-metadata-token: $TOKEN" -v http://169.254.169.254/latest/meta-data/network/interfaces/macs/${INTERFACE}/subnet-id)
echo '<center><h1>This instance is in the subnet wih ID: SUBNETID </h1></center>' > /var/www/html/index.txt
sed "s/SUBNETID/$SUBNETID/" /var/www/html/index.txt > /var/www/html/index.html
```

## alb and autoscaling group


### create auto scaling group
```bash
aws autoscaling create-auto-scaling-group --auto-scaling-group-name ASG2 --launch-template "LaunchTemplateName=MyEC2WebApp" --min-size 1 --max-size 3 --desired-capacity 2 --availability-zones "us-east-1a" "us-east-1b" --vpc-zone-identifier "subnet-02a94e365a7db9848, subnet-00fcec5c9dcd1077d"
```
### create load balancer, create listener, and attach to TG1 to ASG2

```bash
aws elbv2 create-load-balancer --name ALB2 --subnets subnet-02a94e365a7db9848 subnet-00fcec5c9dcd1077d --security-groups sg-018ef94c41893157d

aws elbv2 create-listener --load-balancer-arn arn:aws:elasticloadbalancing:us-east-1:821711655051:loadbalancer/app/ALB2/c3276fdb62a22113 --protocol HTTP --port 80 --default-actions Type=forward,TargetGroupArn=arn:aws:elasticloadbalancing:us-east-1:821711655051:targetgroup/TG1/e47504d36c5b8a7f

aws autoscaling attach-load-balancer-target-groups --auto-scaling-group-name ASG2 --target-group-arns arn:aws:elasticloadbalancing:us-east-1:821711655051:targetgroup/TG1/e47504d36c5b8a7f
```

### delete ASG2 and ALB2
```bash
aws elbv2 delete-load-balancer --load-balancer-arn arn:aws:elasticloadbalancing:us-east-1:821711655051:loadbalancer/app/ALB2/c3276fdb62a22113

aws autoscaling delete-auto-scaling-group --auto-scaling-group-name ASG2 --force-delete
```


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
aws s3 rb s3://mytestbucket-323423dsdfl
```

to forced remove a bucket 

```bash
aws s3 rb s3://mytestbucket-323423dsdfl --force
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


The AWS CLI `aws sts assume role` command will enable the Developer to assume the role and gain temporary security credentials. The Developer can then use those security credentials to troubleshoot access issues that are affecting the application.

# Networking

## IP and Mask

![](images/ip_1.png)

![](images/ip_2.png)

![](images/ip_3.png)

![](images/ip_4.png)

## Choosing right CIDR

- CIDR block size can be between /16 and /28
- The CIDR block must not overlap with any existing CIDR block at's associated with the VPC
- You cannot increase or decrease the size of an existing CIDR block
- The first four and last IP address are not available for use
- AWS recommend you use CIDR blocks from the RFC 1918 ranges

![](images/ip_5.png)

![](images/ip_6.png)

Additional Considerations:
- Ensure you have enough networks and hosts
- Bigger CIDR blocks are typically better (more flexibility)
- Smaller subnets are OK for most use cases
- Consider deploying application tiers per subnet
- Split your HA resources across subnets in different AZs
- VPC Peering requires non-overlapping CIDR blocks
- This is across all VPCs in all Regions / accounts you want to connect
- **Avoid overlapping CIDR blocks as much as possible**

![](images/ip_7.png)

## Zones and Regions

AWS houses its computers in more than 60 data centers spread around the world. In AWS terminology, each data center corresponds to an Availability Zone (AZ), and clusters of data centers in close proximity to each other are grouped into regions. AWS has more than 20 different regions, across 5 continents.

A compelling aspect of Amazon’s region model is that each region is largely independent, logistically and from a software management point of view. That means that if a physical problem like a power outage, or a software problem like a deployment bug, happens in one region, the others will almost certainly be unaffected. 

![](images/networking_1.png)


## VPS (Virtual private cloud)

**VPS** is a logically isolated portion of the AWS cloud within a region. A virtual network dedicated to AWS account. 

Each of VPSs has a different block of IP addresses (**CIDR** block) (Classless inter-domain routing)

When we create a VPS we must specify a range of IPv4 adresses for the VPSs in the form of CIDR block for example 10.0.0.0/16. A default VPS is created in each region with subnet in each AZ.

VPS spans all the AZ in the region. 

You have full controll over who access to the AWS resources inside your VPS

We can create diffrent VPS within a region. There is a default limit 5 to an amount of VPSs in one region but it's possible to apply to extend it. 

![](images/networking_2.png)

## availiablity zones

Within a region there are **availiablity zones** (AZ). This is physically isolated area like a datacenter. 

## Subnets 

Within AZ there are **subnets**. They can be public or private. 

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

and for access from our private subnets to the Internet  we need to create a NAT Gateway attached it to one of our public subnets and add the rule to Private-RT

![](images/network_example_27.png)

![](images/network_example_28.png)

![](images/network_example_29.png)

![](images/network_example_30.png)

then we need to create a security group

![](images/network_example_31.png)

![](images/network_example_32.png)


# Load balancing ELB

![](images/elb_1.png)

## ALB - Applicaton load balancer

![](images/elb_alb.png)

- Operates at the request level (7 level of OCI)
- Supports path-based routing, host-based routing, query string parameter-based routing  and source IP address-based routing
- Supports ec2 instances, IP addresses, Lambda functions, and containers as targets

Use cases:
- Web apps with L7 routing (HTTP/HTTPS)
- Microservices (Docker containers)
- Lambda targets

### Routing ALB

![](images/alb_routing_1.png)

### Example how to configure

We have autoscaling group for our app, subnets and security groups.

Let's create Target group but do not add to this a particular instance. We add them later. 

![](images/alb_configure_1.png)

![](images/alb_configure_2.png)

![](images/alb_configure_3.png)

![](images/alb_configure_4.png)

create alb and connect it to target group 

![](images/alb_configure_5.png)

![](images/alb_configure_6.png)

![](images/alb_configure_7.png)

![](images/alb_configure_8.png)

![](images/alb_configure_9.png)

connect auto scale group to target group

![](images/alb_configure_10.png)

![](images/alb_configure_11.png)

see changes in target groups

![](images/alb_configure_12.png)

![](images/alb_configure_13.png)

![](images/alb_configure_14.png)


## NLB - Network Load Balancer

![](images/elb_nlb.png)


- Operates at the connection level
- Routes connections based on IP protocol data (4 level of OCI)
- Offers ultra high performance , low latency, and TLS offloading at scale
- Can have a static IP/ Elastic IP
- Supports TCP, TLS, UDP, TCP_UDP and static IP addresses as targets

Use cases:
- TCP and UDP based apps
- Ultra-low latency
- Static IP addresses
- VPS endpoint services

### NLB routing

it is not possible to route by path or host header. But it is possible by port

![](images/nlb_routing_1.png)

## CLB - Classic load balancer

![](images/elb_clb.png)

- Old generation, not recommended to use for new apps
- Performes routing at Layer 4 and Layer 7
- Use for existing application running in EC2-CLassic

## GLB - Gataway load balancer

![](images/elb_glb.png)

- New thing (2023)
- Used in front of vurtial appliences such as firewalls , IDS/IPS, and deep packet inspection systems
- Operates on Layer 3 - listens for all packets on all ports
- Forwards traffic to the TG speciefied in the listener rules
- Exchanges traffic with appliences using the GENEVE protocol on port 6081 

Use cases:
- Load balance virtual appliances such as:
  - Intrustion detection systems (IDS)
  - Intrusion prevention systems (IPS)
  - Next generation firewalls (NGFW)
  - Web application firewalls (WAF)
  - Distributed denial of service protection systems (DDoS)
- Integrate with Auto Scaling groups for elasticity
- Apply network monitoring and logging for analytics


## Comparison

![](images/elb_comparison_1.png)

## Session info

![](images/session_state_1.png)

![](images/session_state_2.png)

## Cross-Zone Load Balancing

- When cross-zone load balancing is enabled Each load balancer node distributes traffic across the registered
targets in all enabled Availability Zones
- When cross-zone load balancing is disabled Each load balancer node distributes traffic only across the registered
targets in its Availability Zone
- With Application Load Balancers, cross-zone load balancing is always enabled
- With Network Load Balancers and Gateway Load Balancers, crosszone load balancing is disabled by default

![](images/elb_cross_zone_1.png)

![](images/elb_cross_zone_2.png)

## ELB Security


### ALB

2 options

![](images/elb_security_1.png)

### NLB

2 options

![](images/elb_security_2.png)



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

Lambda functions can be invoked directly through:
- The Lambda console
- A function URL HTTP(S) endpoint
-  The Lambda API
- An AWS SDK
-  The AWS CLI
- AWS Toolkits

- Lambda can be invoked by other AWS services
- Lambda can also be invoked when reading from a stream or queue

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

### First Java example (compile and deploy via SAM)

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

## Types of lambda 

### Synchronous

- CLI, SDK, API Gateway
- Wait for the function to process the event and return a response
- Error handling happens client side (retries, exponential backoff etc.)


### Asynchronous

- S3, SNS, CloudWatch Events etc.
- Event is queued for processing and a response is returned immediately
- Lambda retries up to 3 times
- Processing must be idempotent (due to retries)

### Event source mapping

- SQS, Kinesis Data Streams, DynamoDB Streams
- Lambda does the polling (polls the source)
- Records are processed in order (except for SQS standard)

+ SQS can also trigger Lambda without lambda polling

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


To get logs for an invocation from the command line, use the `--logtype` option. The response includes a `LogResult` field that contains up to 4 KB of base64-encoded logs from the invocation

```bash
aws lambda invoke --function-name my-function out --log-type Tail
```

![](images/lambda_1.png)

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

## Create Event Source Mapping

![](images/lambda_event_source_1.png)

1. Create a role for AWS lambda

![](images/lambda_event_source_2.png)

![](images/lambda_event_source_3.png)

![](images/lambda_event_source_4.png)

after that copy and save arn of the role

2. create sqs queue
   
![](images/lambda_event_source_5.png)

![](images/lambda_event_source_6.png)

after that copy and save arn of the queue

3. create lambda by cli

```javascript
exports.handler = async function(event, context) {
    event.Records.forEach(record => {
      const { body } = record;
      console.log(body);
    });
    return {};
  }
```

```bash
zip function.zip index.js
```

```bash
aws lambda create-function --function-name EventSourceSQS --zip-file fileb://function.zip --handler index.handler --runtime nodejs16.x --role arn:aws:iam::967120122177:role/my-sqs-role
```

4. create event-source mapping 

```bash
aws lambda create-event-source-mapping --function-name EventSourceSQS --batch-size 10 --event-source-arn arn:aws:sqs:eu-north-1:967120122177:MyQueue
```

to show event-source mapping

```bash
aws lambda list-event-source-mappings --function-name EventSourceSQS --event-source-arn arn:aws:sqs:eu-north-1:967120122177:MyQueue
```

![](images/lambda_event_source_7.png)

to delete event-seource mapping

```bash
aws lambda delete-event-source-mapping --uuid 3b439c3f-22d9-4d2b-9395-c25df2cf049d
```

5. test exucution by adding a message via sqs console

![](images/lambda_event_source_8.png)

![](images/lambda_event_source_9.png)

![](images/lambda_event_source_10.png)

![](images/lambda_event_source_11.png)

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

## Lambda versions

- Versioning means you can have multiple versions of your function
- The function version includes the following information:
  - The function code and all associated dependencies
  - The Lambda runtime that executes the function
  - All the function settings, including the environment variables
  - A unique Amazon Resource Name (ARN) to identify this version
of the function
- You can use versions to manage the deployment of your AWS Lambda functions
- For example, you can publish a new version of a function
for beta testing without affecting users of the stable
production version
- You work on `$LATEST`` which is the latest version of the code this is mutable (changeable)
- When you're ready to publish a Lambda function you create a version (these are numbered)
- Numbered versions are assigned a number starting with 1 and subsequent versions are incremented by 1
- Versions are immutable (code cannot be edited)
- Each version has its own ARN
- This allows you to effectively manage them for different environments like Production, Staging or Development

- A **qualified** ARN has a version suffix
  
 `arn:aws:lambda:us-east:1:23423423423:function:myfunction:2`

- An **unqualified** ARN does not have a version suffix
  
 `arn:aws:lambda:us-east:1:23423423423:function:myfunction`

- You cannot create an alias from an unqualified ARN
- When you invoke a function using an unqualified ARN, Lambda implicitly invokes `$LATEST`

## Lambda aliases

![](images/lambda_2.png)

- Lambda aliases are pointers to a specific Lambda version
- Using an alias, you can invoke a function without having to know which version of the function is being referenced
- Aliases are mutable (changeable)

![](images/lambda_3.png)

![](images/lambda_4.png)

- Aliases also have static ARNs but can point to any version of the same function
- Aliases enable stable configuration of event triggers / destinations
- Aliases enable blue / green deployment by assigning weights to Lambda version
- You must create a version for an alias, you cannot use `$LATEST``

## Example with versions and label.

1. Create lambda for python via wizard and then we can change a code. 

![](images/lambda_4.png)

2. next create a first version of lambda with "Hello from Lambda"

![](images/lambda_5.png)

![](images/lambda_6.png)

after this version is immutable.

![](images/lambda_7.png)

3. let's change a text a create new version v2.

![](images/lambda_8.png)

4. and now we can invoke labmdas with v1 and v2 version

```bash
aws lambda invoke --invocation-type RequestResponse --function-name myFunc:1 outputfile.txt
aws lambda invoke --invocation-type RequestResponse --function-name myFunc:2 outputfile.txt
```
![](images/lambda_9.png)

5. Let's create an alias an split load 50/50 between two versions

![](images/lambda_10.png)

![](images/lambda_11.png)

![](images/lambda_12.png)

## Deployment Packages and Environment variables

- A Lambda function's code consists of scripts or compiled programs and their dependencies
- A deployment package is used to deploy function code to Lambda
- Lambda supports two types of deployment packages:
  - Container images
  - .zip file archives

### Container images

A container image includes:
- The base operating system
- The runtime
- Lambda extensions
- Application code and its dependencies

- Container images are uploaded to the Amazon Elastic Container Registry (ECR)
- The image is then deployed to the Lambda function

### Zip

- A .zip file archive includes your application code and its dependencies
- The deployment package is uploaded from Amazon S3 or your computer
- There are limits to the size of zip archives:
  - 50 MB (zipped, for direct upload)
  - 250 MB (unzipped)
  - 3 MB (console editor)

### Deployment through CloudFormation

- The `AWS::Lambda::Function` resource creates a Lambda function
- The function code zip file must be stored in Amazon S3
-  The S3 bucket must be in the same region where you’re running CloudFormation
-  You also need a CloudFormation template file
- Set the package type to:
  - `Image` for container images
  - `Zip` for .zip archives

### Lambda layers 

- You can configure your Lambda function to pull in additional code and content in the form of layers
-  A layer is a ZIP archive that contains libraries, a custom runtime, or other dependencies
- With layers, you can use libraries in your function without needing to include them in your deployment package
-  A function can use up to 5 layers at a time
- Layers are extracted to the `/opt` directory in the function execution environment
- Each runtime looks for libraries in a different location under `/opt`, depending on the language

- To add layers to your function, use the `update-function-configuration` command

```bash
aws lambda update-function-configuration --function-name my-function --layers arn:lambda:us-east-2:234234:layer:my-layer:3 arn:lambda:us-east-2:234234:layer:their-layer:2 
```

### Lambda Environment Variables

- Environment variables can be used to adjust your function's behavior without updating code
- An environment variable is a pair of strings that is stored in a function's version specific configuration
- Environment variables are defined on the unpublished version of a function
- When you publish a version, the environment variables are locked for that version
- Environment variables are key/value pairs

```bash
aws lambda update-function-configuration --function-name my-function --environment "Variables={BUCKET=my-bucket,KEY=file.txt}"
```

to see lambda configuration use `get-function-configuration`

It can be possible to encrypt particular variables with key that is in KMS service. Then inside the code it is nessasary to decrypt with getting a key from KMS. It is nessasary to have a role for getting this key and put this role to lambda function. 

![](images/lambda_13.png)


## Lambda limits

| Resource                 | Quota                                            |
| ------------------------ | ------------------------------------------------ |
| Memory allocation        | 128MB to 10240MB in 1-MB increments              |
| Function timeout         | 900 seconds (15 minutes)                         |
| Environment variables    | 4KB for all the function's environment variables |
| Layers                   | up to 5                                          |
| Burst concurrency        | 500-3000 depending on the Region                 |
| Invocation payload       | 6MB for synchronous 256KB for async              |
| Deployment package (zip) | 50 MB zipped, 250MB unzipped, 3MB console        |
| Container image size     | 10 GB                                            |
| /tmp directory storage   | 512 MB to 10240MB in 1-MB increment              |

## Destinations

It is possible to send the result of the function to the next destination if the function is invoked asynchronously or if the function prcesses records from a stream.

![](images/lambda_dest_0.png)

![](images/lambda_dest_1.png)

The execution record contains details about the request and response in JSON format

Information sent includes:
- Version
- Timestamp
- Request context
- Request payload
- Response context
- Response payload

- A Dead Letter Queue saves unprocessed events for further processing
- Applies to asynchronous invocations
- The DLQ can be an Amazon SQS queue or an Amazon SNS topic
- When editing the asynchronous configuration, you can specify the number of retries:

![](images/lambda_dest_2.png)

![](images/lambda_dest_3.png)


## AWS SAM CLI

### Installation

```bash
curl "https://github.com/aws/aws-sam-cli/releases/latest/download/aws-sam-cli-linux-x86_64.zip" -o "aws-sam-cli.zip"
unzip aws-sam-cli.zip -d sam-installation
sudo ./aws/install
sam --version
```

### Features

- Provides a shorthand syntax to express functions, APIs, databases, and event source mappings
- Can be used to create Lambda functions, API endpoints, DynamoDB tables, and other resources

![](images/sam_1.png)

- A SAM template file is a YAML configuration that represents the architecture of a serverless application
- You use the template to declare all the AWS resources that comprise your serverless application in one place
- AWS SAM templates are an extension of AWS CloudFormation templates
- Any resource that you can declare in an AWS CloudFormation template can also be declared in an AWS SAM template

The “Transform” header indicates it’s a SAM template: `Transform: 'AWS::Serverless-2016-10-31`

There are several resources types:
- `AWS::Serverless::Function` (AWS Lambda)
- `AWS::Serverless::Api` (API Gateway)
- `AWS::Serverless::SimpleTable` (DynamoDB table)
- `AWS::Serverless::Application` (AWS Serverless Application Repository)
- `AWS::Serverless::HttpApi` (API Gateway HTTP)
- `AWS::Serverless::LayerVersion` (Lambda layer)


### SAM Policy Templates

SAM Policy Templates are a list of templates to apply permissions to your Lambda functions.

Examples:
- `S3ReadPolicy`
- `SQSPollerPolicy`
- `DynamoDBCrudPolicy`

### Commands

```bash
sam package -t template.yaml --s3-bucket dctlabs --output-template-file packaged-template.yaml
sam deploy --template-file packaged-template.yaml --stack-name my-cf-stack
```

Alternatively
```bash
aws cloudformation package --template-file template.yaml --s3-bucket dctlabs --output-template-file packaged template.yaml
aws cloudformation deploy --template-file packaged-template.yaml --stack-name my-cf-stack
```

Using the `sam local invoke` command with the specific Lambda function as an argument, you can execute the function locally.

### Environment Variables and SAM

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

## Memory and CPU

`memory-size` can be as small as 64MB, although for Java Lambda functions you should probably use at least 256MB. memory-size must be a multiple of 64MB.

A very important thing to know is that the memory-size setting is not just for how much RAM your function can use—it also specifies how much CPU power you get. In fact, a Lambda function’s CPU power scales linearly from 64MB up to 1792MB. Therefore a Lambda function configured with 1024MB of RAM has twice the CPU power of one with 512MB of RAM.

AWS charges for Lambda functions by two primary factors:
- How long a function runs, rounded up to the nearest 100 ms
- How much memory a function is specified to use

In other words, given the same execution duration, a Lambda function that has 2GB of RAM costs twice as much to execute as one with 1GB of RAM. Or, one with 512MB of RAM costs 17% of one with 3008MB. This, at scale, could be a big difference.

## Concurrency 

Burst concurrency quotas

3000 - US West (Oregon), US East (N.Viginia), Europe (Ireland)
1000 - Asia Pacific (Tokyo), Europe (Frankfurt), US East (Ohio)
500 - Other regions 

If the concurrency limit is exceeded throttling occurs with error "Rate exceeded" and a 429 "TooManyRequestException"

### Reserved Concurrency

- Reserved concurrency guarantees a set number of concurrent executions will be available for a critical function
- You can reserve up to the Unreserved account concurrency value, minus 100 for functions that don't have reserved concurrency
- To throttle a function, set the reserved concurrency to zero. This stops any events from being processed until you remove the limit

![](images/lambda_concur_1.png)

### Provisioned Concurrency

Setting the provisioned concurrency of the function to 1 ensures that only one instance of the function will be operating at any given time

- When provisioned concurrency is allocated, the function scales with the same burst behavior as standard concurrency
- After it's allocated, provisioned concurrency serves incoming requests with very low latency
- When all provisioned concurrency is in use, the function scales up normally to handle any additional requests
- Application Auto Scaling takes this a step further by providing autoscaling for provisioned concurrency

![](images/lambda_concur_2.png)

## Metrics, tracing, logs

### Monitoring

Lambda sends metrics to Amazon CloudWatch for performance monitoring

![](images/lambda_metrics_1.png)

### Logging 

- Execution logs are stored in Amazon CloudWatch Logs
- The Lambda function execution role must have permissions (IAM) to allow writes to CloudWatch Logs

## Lambda in a VPC

![](images/lambda_vpc_1.png)

- You must connect to a private subnet with a NAT Gateway for Internet access (no public IP)
- Careful with DNS resolution of public hostnames as it could add to function running time (cost)
- Cannot be connected to a dedicated tenancy VPC
- Only connect to a VPC if you need to, it can slow down function execution
- To connect to a VPC, your function's execution role must have the following permissions:
  - `ec2:CreateNetworkInterface`
  - `ec2:DescribeNetworkInterfaces`
  - `ec2:DeleteNetworkInterface`
- These permissions are included in the `AWSLambdaVPCAccessExecutionRole` managed policy

## Lambda Function as a Target for an ALB

- Application Load Balancers (ALBs) support AWS Lambda functions as targets
- You can register your Lambda functions as targets and configure a listener rule to forward requests to the target group for your Lambda function

![](images/lambda_alb_1.png)

There are some limits to understand:

- The Lambda function and target group must be in the same account and in the same Region
- The maximum size of the request body that you can send to a Lambda function is 1 MB
- The maximum size of the response JSON that the Lambda function can send is 1 MB
- WebSockets are not supported. Upgrade requests are rejected with an HTTP 400 code
- Local Zones are not supported

## Security

![](images/lambda_security_1.png)

Main points:
- Function execution role must provide permission to AWS services
- Lambda API endpoints only support TLS connections
- AWS recommend to use Secrets Manager instead of environment variables
- Files, deployment packages and environment variables are encrypted at rest with a KMS key

Signing of the code:
- AWS Signer is a fully managed code signing service
- Used to ensure the trust and integrity of code
- Code is validated against a digital signature
- With Lambda you can ensure only trusted code runs in Lambda functions
- Signer is used to create digitally signed packages for deployment
- IAM policies can enforce that functions can be created only if they have code signing enabled
- If a developer leaves you can revoke all versions of the signing profile so the code cannot run

## Best practicies

1. Separate the Lambda handler from your core logic. This allows you to make a more unit-testable function

```javascript
exports.myHandler = function(event, context, callback) {
	var foo = event.foo;
	var bar = event.bar;
	var result = MyLambdaFunction (foo, bar);

	callback(null, result);
}

function MyLambdaFunction (foo, bar) {
	// MyLambdaFunction logic here
}
```

2. Take advantage of execution environment reuse to improve the performance of your function
  - Initialize SDK clients and database connections outside of the function handler
  - Cache static assets locally in the /tmp directory
  - Subsequent invocations processed by the same instance of your function can reuse these resources
  - This saves cost by reducing function run time

3. Use a keep-alive directive to maintain persistent connections
   - Lambda purges idle connections over time and attempting to reuse an idle connection can result in an error

4. Use environment variables to pass operational parameters to your function
  - For example, use environment variables instead of hard coding S3 bucket names in code

5. Control the dependencies in your function's deployment package
   - Libraries and runtimes in the Lambda execution environment can be updated and may cause issues
   - To avoid errors, package dependencies in the deployment package

6. Minimize your deployment package size to its runtime necessities
   - This reduces the amount of time it takes for deAployment packages to be downloaded and unpacked ahead of invocation

7. Avoid using recursive code in your function
  - Don’t use code that calls itself until some arbitrary criteria is met
  - Can cause large volumes of invocations and increased costs

## Servless application repository

a set of open application to use. 

![](images/lambda_14.png)

## Example pricing

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

## Database proxy for Amazon RDS

RDS Proxy acts as an intermediary between your application and an RDS database. RDS Proxy establishes and manages the necessary connection pools to your database so that your application creates fewer database connections.

You can use RDS Proxy for any application that makes SQL calls to your database. But in the context of serverless, we focus on how this improves the Lambda experience. The proxy handles all database traffic that normally flows from your Lambda functions directly to the database.

Your Lambda functions interact with RDS Proxy instead of your database instance. It handles the connection pooling necessary for scaling many simultaneous connections created by concurrent Lambda functions. This allows your Lambda applications to reuse existing connections, rather than creating new connections for every function invocation.

The RDS Proxy scales automatically so that your database instance needs less memory and CPU resources for connection management. It also uses warm connection pools to increase performance. With RDS Proxy, you no longer need code that handles cleaning up idle connections and managing connection pools. Your function code is cleaner, simpler, and easier to maintain.

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

# Dynamo DB

- Fully managed NoSQL database service
- Key/value store and document store
- It is a non-relational, key value type of database
- Fully serverless service
- Push button scaling
- DynamoDB provides low latency (milliseconds)
- Microsecond latency can be achieved with **DynamoDB Accelerator (DAX)**. Fully managed in memory cache for DynamoDB that increases performance (microsecond latency)
- All data is stored on SSD storage
- Data is replicated across multiple AZs in a Region
- **DynamoDB Global Tables** synchronizes tables across Regions
- 99.99% availability SLA 99.999% for Global Tables
- Flexible schema, good for when data is not well structured or unpredictable
- **DynamoDB Streams** Captures a time ordered sequence of item level modifications in a DynamoDB table and durably stores
the information for up to 24 hours. Often used with Lambda and the Kinesis Client Library (KCL)
- Transaction options Strongly consistent or eventually consistent reads, support for ACID transactions
- Point in time recovery down to the second in last 35 days; On demand backup and restore

The basic DynamoDB components are:
- Tables
- Items (rows)
- Attributes (columns)

## DynamoDB API

API operations are categorized as **control plane** and **data plane**

Example control plane API actions:
- `CreateTable` Creates a new table
- `DescribeTable` Returns information about a table, such as its primary key schema, throughput settings, and index information
- `ListTables` Returns the names of all your tables in a list
- `UpdateTable` Modifies the settings of a table or its indexes
- `DeleteTable` Removes a table and all its dependent objects from DynamoDB

Data plane API actions can be performed using PartiQL (SQL compatible), or classic DynamoDB CRUD APIs

Example data plane API actions (DynamoDB CRUD ):
- `PutItem` Writes a single item to a table
- `BatchWriteItem` Writes up to 25 items to a table
- `GetItem` Retrieves a single item from a table
- `BatchGetItem` Retrieves up to 100 items from one or more tables
- `UpdateItem` Modifies one or more attributes in an item
- `DeleteItem` Deletes a single item from a table

## Data types

- **Scalar Types** represent exactly one value. The scalar types are number, string, binary, Boolean, and null
- **Document Types** A document type can represent a complex structure with nested attributes, such as you would find in a JSON document. The document types are list and map
- **Set Types** A set type can represent multiple scalar values. The set types are string set, number set, and binary set

## Table classes

**DynamoDB Standard** – default and recommended for most workloads

**DynamoDB Standard-Infrequent Access(DynamoDB Standard-IA)** - Lower cost storage for tables that store infrequently accessed data, such as:
- Application logs
- Old social media posts
- E-commerce order history
- Past gaming achievements

## Access control

All authentication and access control is managed using IAM

DynamoDB supports **identity-based** policies:
- Attach a permissions policy to a user or a group in your account
- Attach a permissions policy to a role (grant cross account permissions)

DynamoDB doesn't support **resource-based** policies

You can use a special IAM condition to restrict user access to only their own records

The primary DynamoDB resources are tables

Also supports additional resource types, indexes, and streams

You can create indexes and streams only in the context of an existing DynamoDB table (subresources)

These resources and subresources have unique ARNs associated with them, as shown in the following table:

Table `arn:aws:dynamodb:region:account-id:table/table-name`

Index `arn:aws:dynamodb:region:account-id:table/table-name/index/index-name`

Stream `arn:aws:dynamodb:region:account-id:table/table-name/stream/stream-label`

The following example policy grants permissioins for one DynamoDB action (dynamodb:ListTables)

```json
{
  "Version": "2012-10-17",
  "Statement":[
    {
      "Sid": "ListTables",
      "Effect": "Allow",
      "Action": [
        "dynamodb:ListTables"
      ],
      "Resource": "*"
    }
  ]
}
```

The following example policy grants permissions for three DynamoDB actions

```json
{
  "Version": "2012-10-17",
  "Statement":[
    {
      "Sid": "DescribeQueryScanBooksTable",
      "Effect": "Allow",
      "Action": [
        "dynamodb:DescribeTable",
        "dynamodb:Query",
        "dynamodb:Scan"
      ],
      "Resource": "arn:aws:dynamodb:us-west-2:account-id:table/Books"
    }
  ]
}
```

## DynamoDB Partitions and Primary Keys

- Amazon DynamoDB stores data in partitions
- A partition is an allocation of storage for a table that is automatically replicated across multiple AZs within an AWS Region
- DynamoDB manages partitions for you
- DynamoDB allocates sufficient partitions to support provisioned throughput requirements
- DynamoDB allocates additional partitions to a table in the following situations:
  - If you increase the table's provisioned throughput settings beyond what the existing partitions can support
  - If an existing partition fills to capacity and more storage space is required
  

- There are two types of Primary key: **Partition keys** and **composite keys**

### Partition key

- Partition key unique attribute (e.g. user ID)
- Value of the Partition key is input to an internal hash function which determines the partition or physical location on which the data is stored
-  If you are using the Partition key as your Primary key then no two items can have the same partition key

### Composite key

- Composite key = Partition key + Sort key in combination
- Example is user posting to a forum. Partition key would be the user ID, Sort key would be the timestamp of the post
- 2 items may have the same Partition key, but they must have a different Sort key
- All items with the same Partition key are stored together, then sorted according to the Sort key value
- Allows you to store multiple items with the same partition key


### Limits

- DynamoDB evenly distributes provisioned throughput read capacity units (RCUs) and write capacity units (WCUs) among partitions
- If your access pattern exceeds 3000 RCU or 1000 WCU for a single partition key value, your requests might be throttled
- Reading or writing above the limit can be caused by these issues:
  - Uneven distribution of data due to the wrong choice of partition key
  - Frequent access of the same key in a partition (the most popular item, also known as a hot key)
  - A request rate greater than the provisioned throughput

### Best practices for partition keys:

- Use high cardinality attributes e.g. e mailid, employee_no, customerid, sessionid, orderid, and so on
- Use composite attributes e.g. customerid+productid+countrycode as the partition key and order_date as the sort key
- Cache popular items use DynamoDB accelerator (DAX) for caching reads
- Add random numbers or digits from a predetermined range for write heavy use cases. For example, add a random suffix to an invoice
number such as `INV00023-04593`

## DynamoDB Consistency Models

DynamoDB supports eventually consistent and strongly consistent reads


### Eventually consistent reads

- DynamoDB uses eventually consistent reads by default
- When you read data from a DynamoDB table, the response might not reflect the results of a recently completed write operation
- The response might include some stale data
- If you repeat your read request after a short time, the response should return the latest data

### Strongly consistent reads

- DynamoDB returns a response with the most up to date data, reflecting the updates from all prior write operations that were successful
- A strongly consistent read might not be available if there is a network delay or outage. In this case, DynamoDB may return a server error (HTTP 500)
- Strongly consistent reads may have higher latency than eventually consistent reads
- Strongly consistent reads use more throughput capacity than eventually consistent reads
- Strongly consistent reads are not supported on global secondary indexes
- With a strongly consistent read, data will always be returned when reading after a successful write
- You can configure strongly consistent reads with the `GetItem` , `Query` and `Scan` APIs by setting the `consistent-read` (or `ConsistentRead`) parameter to true

### Transactions

- With DynamoDB transactions DynamoDB makes coordinated, all or nothing changes to multiple items both within and across tables
- Transactions provide atomicity, consistency, isolation, and durability (ACID) in DynamoDB
- Enables reading and writing of multiple items across multiple tables as an all or nothing operation
- Checks for a prerequisite condition before writing to a table
- There is no additional cost to enable transactions for DynamoDB tables
- You pay only for the reads or writes that are part of your transaction
- DynamoDB performs **two** underlying reads or writes of every item in the transaction: one to prepare the transaction and one to commit the transaction

- With the **transaction write API**, you can group multiple `Put` , `Update` , `Delete` , and `ConditionCheck` actions
- You can then submit the actions as a single `TransactWriteItems` operation that either succeeds or fails as a unit
- The same is true for multiple `Get` actions, which you can group and submit as a single `TransactGetItems` operation

## DynamoDB Capacity Units (RCU/WCU)

- Provisioned capacity is the default setting
- You specify the reads and write per second
- Can enabled auto scaling for dynamic adjustments
- Capacity is specified using:
  - Read Capacity Units
  - Write Capacity Units

![](images/dynamodb_7.png)

![](images/dynamodb_8.png)

### Read Capacity Units (RCUs):

- Each API call to read data from your table is a read request
- Read requests can be strongly consistent, eventually consistent, or transactional
- For items up to 4 KB in size, one RCU equals:
  - One strongly consistent read request per second
  - Two eventually consistent read requests per second
  - 0.5 transactional read requests per second
- Items larger than 4 KB require additional RCUs


10 strongly consistent reads per second of 4 KB each
$$
{{10 * 4 KB } \over 4 KB } = 10 RCU
$$

10 strongly consistent reads per second of 11 KB each
$$
{{10 * 12 KB } \over 4 KB } = 30 RCU
$$

20 eventually consistent reads per second of 12 KB each

$$
{20 \over 2} * {12 \over 4} = 30 RCU
$$

36 eventually consistent reads per second of 16 KB each 
$$
{36 \over 2} * {16 \over 4} = 72 RCU
$$

### Write Capacity Units (WCUs)

- Each API call to write data to your table is a write
request
-  For items up to 1 KB in size, one WCU can perform:
   - One standard write request per second
   - 0.5 transactional writes requests (one transactional write requires two WCUs)
- Items larger than 1 KB require additional WCUs

10 standard writes per second of 4 KB each
$$
10 * 4 = 40 WCU
$$

12 standard writes per second of 9.5 KB each (9.5 gets rounded)
$$
12 * 10 = 120 WCU
$$

10 transactional writes per second of 4 KB each
$$
10 * 2 * 4 = 80 WCU
$$

12 transactional writes per second of 9.5 KB each
$$
12 * 2 * 10 = 240 WCU
$$

## DynamoDB On Demand Capacity

- With on demand, you don't need to specify your requirements
- DynamoDB instantly scales up and down based on the activity of your application
- Great for unpredictable / spikey workloads or new workloads that aren't well understood
- You pay for what you use (pay per request)

## Performance

- Throttling occurs when the configured RCU or WCU are exceeded
- You may receive the following error `ProvisionedThroughputExceededException`. This error indicates that the request rate is too high for the read / write capacity provisioned for the table
- The AWS SDKs for DynamoDB automatically retry requests that receive this exception
- The request is eventually successful, unless the retry queue is too large to finish DynamoDB Performance and Throttling

Possible causes of performance issues:
- **Hot keys** one partition key is being read too often
- **Hot partitions** when data access is imbalanced, a "hot" partition can receive a higher volume of read and write traffic compared to other partitions
- **Large items** large items consume more RCUs and WCUs

Resolution:
- Reduce the frequency of requests and use exponential backoff
- Try to design your application for uniform activity across all logical partition keys in the table and its secondary indexes
- Use burst capacity effectively DynamoDB retains up to 5 minutes (300 seconds) of unused read and write capacity which can be consumed quickly
- Ensure Adaptive Capacity is enabled (default) this feature minimizes throttling due to throughput exceptions

## DynamoDB Scan and Query API

### DynamoDB Scan API

- The Scan operation returns one or more items and item attributes by accessing every item in a table or a secondary index
- To have DynamoDB return fewer items, you can provide a `FilterExpression` operation
- A single Scan operation reads up to the maximum number of items set (if using the `Limit` parameter), or a maximum of 1 MB
- Scan API calls can use a lot of RCUs as they access every item in the table
- Scan operations proceed sequentially
- Applications can request a parallel Scan operation by providing the `Segment` and `TotalSegments` parameters
- Scan uses eventually consistent reads when accessing the data in a table
- If you need a consistent copy of the data, as of the time that the Scan begins, you can set the `ConsistentRead` parameter to true

![](images/dynamodb_9.png)

In this example the scan will return all posts in the forum that were posted within a date range and that have more than 50 replies:

![](images/dynamodb_10.png)

![](images/dynamodb_11.png)

### DynamoDB Query API

- A query operation finds items in your table based on the primary key attribute and a distinct value to search for
- For example, you might search for a user ID value and all attributes related to that item would be returned
- You can use an optional sort key name and value to refine the results
- For example, if your sort key is a timestamp, you can refine the query to only select items with a timestamp of the last 7 days
- All attributes are returned for the items by default
- You can also use the `ProjectionExpression` parameter if you want the query to only return the attributes you want to see
- By default, queries are eventually consistent
- To use strongly consistent, you need to explicitly set this in the query

![](images/dynamodb_12.png)

In this example the query returns only items with the client id of chris@example.com that were created within a certain date range and that are in the category pen

![](images/dynamodb_13.png)

### Examples cli

All examples below can be repetead by console portal. Here will be examples for cli. 


mystore.json

```json
{
    "mystore": [
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "john@example.com"
                    },
                    "created": {
                        "S": "2020-03-9T08:12Z"
                    },
                    "sku": {
                        "S": "SKU-S523"
                    },
                    "category": {
                        "S": "T-Shirt"
                    },
                    "size": {
                        "S": "Small"
                    },
                    "colour": {
                        "S": "Red"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "30"
                    },
                    "weight": {
                        "S": "Light"
                    } 
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "chris@example.com"
                    },
                    "created": {
                        "S": "2020-03-10T14:30Z"
                    },
                    "sku": {
                        "S": "SKU-J091"
                    },
                    "category": {
                        "S": "Pen"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "14.99"
                    },
                    "colour": {
                        "S": "Blue"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "chris@example.com"
                    },
                    "created": {
                        "S": "2020-03-10T15:30Z"
                    },
                    "sku": {
                        "S": "SKU-A234"
                    },
                    "category": {
                        "S": "Mug"
                    },
                    "qty": {
                        "N": "2"
                    },
                    "price": {
                        "N": "8.99"
                    },
                    "size": {
                        "N": "12"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "sarah@example.com"
                    },
                    "created": {
                        "S": "2020-03-12T7:42Z"
                    },
                    "sku": {
                        "S": "SKU-R873"
                    },
                    "category": {
                        "S": "Chair"
                    },
                    "size": {
                        "N": "94"
                    },
                    "qty": {
                        "N": "6"
                    },
                    "price": {
                        "N": "82.99"
                    },
                    "weight": {
                        "N": "4011"
                    } 
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "jenny@example.com"
                    },
                    "created": {
                        "S": "2020-03-13T18:29Z"
                    },
                    "sku": {
                        "S": "SKU-I019"
                    },
                    "category": {
                        "S": "Plate"
                    },
                    "qty": {
                        "N": "12"
                    },
                    "price": {
                        "N": "119.99"
                    },
                    "size": {
                        "N": "30"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "jose@example.com"
                    },
                    "created": {
                        "S": "2020-04-01T20:01Z"
                    },
                    "sku": {
                        "S": "SKU-U812"
                    },
                    "category": {
                        "S": "Phone Case"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "19.99"
                    },
                    "size": {
                        "S": "iPhone 8"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "jess@example.com"
                    },
                    "created": {
                        "S": "2020-04-02T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-P122"
                    },
                    "category": {
                        "S": "book"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "24.95"
                    },
                    "weight": {
                        "N": "200"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "cindy@example.com"
                    },
                    "created": {
                        "S": "2020-03-28T20:29Z"
                    },
                    "sku": {
                        "S": "SKU-L398"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "12.99"
                    },
                    "category": {
                        "S": "Charger"
                    }
                  
                }
            }
        },{
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "adam@example.com"
                    },
                    "created": {
                        "S": "2020-03-18T04:54Z"
                    },
                    "sku": {
                        "S": "SKU-K101"
                    },
                    "category": {
                        "S": "Bowl"
                    },
                    "size": {
                        "N": "20"
                    },
                    "price": {
                        "N": "32"
                    },
                    "qty": {
                        "N": "4"
                    }
                  
                }
            }
        },{
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "safin@example.com"
                    },
                    "created": {
                        "S": "2020-03-21T22:27Z"
                    },
                    "sku": {
                        "S": "SKU-M011"
                    },
                    "category": {
                        "S": "Glasses"
                    },
                    "model": {
                        "S": "Champagne"
                    },
                    "qty": {
                        "N": "10"
                    },
                    "price": {
                        "N": "249.99"
                    },
                    "finish": {
                        "S": "Crystal"
                    }
                  
                }
            }
        },{
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "carol@example.com"
                    },
                    "created": {
                        "S": "2020-03-27T19:19Z"
                    },
                    "category": {
                        "S": "Watch"
                    },
                    "model": {
                        "S": "NXC021Z"
                    },
                    "qty": {
                        "N": "2"
                    },
                    "price": {
                        "N": "349.99"
                    },
                    "brand": {
                        "S": "Garmin"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "jake@example.com"
                    },
                    "created": {
                        "S": "2020-03-18T19:29Z"
                    },
                    "sku": {
                        "S": "SKU-Q012"
                    },
                    "category": {
                        "S": "Camera"
                    },
                    "brand": {
                        "S": "Cannon"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "429.99"
                    },
                    "model": {
                        "S": "EOS 5D MIV"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "chris@example.com"
                    },
                    "created": {
                        "S": "2020-04-01T12:30Z"
                    },
                    "sku": {
                        "S": "SKU-B123"
                    },
                    "category": {
                        "S": "Batteries"
                    },
                    "qty": {
                        "N": "12"
                    },
                    "price": {
                        "N": "22.99"
                    },
                    "size": {
                        "S": "A3"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "chris@example.com"
                    },
                    "created": {
                        "S": "2020-03-28T18:01Z"
                    },
                    "sku": {
                        "S": "SKU-C765"
                    },
                    "category": {
                        "S": "Ear Plugs"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "6.99"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "pj@example.com"
                    },
                    "created": {
                        "S": "2020-04-03T07:04Z"
                    },
                    "sku": {
                        "S": "SKU-P122"
                    },
                    "category": {
                        "S": "book"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "24.95"
                    },
                    "weight": {
                        "N": "200"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "werner@example.com"
                    },
                    "created": {
                        "S": "2020-04-02T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-P122"
                    },
                    "category": {
                        "S": "book"
                    },
                    "qty": {
                        "N": "1"
                    },
                    "price": {
                        "N": "24.95"
                    },
                    "weight": {
                        "N": "200"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "charles@example.com"
                    },
                    "created": {
                        "S": "2020-04-02T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-P122"
                    },
                    "category": {
                        "S": "book"
                    },
                    "qty": {
                        "N": "4"
                    },
                    "price": {
                        "N": "24.95"
                    },
                    "weight": {
                        "N": "200"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "kathy@example.com"
                    },
                    "created": {
                        "S": "2020-04-02T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-P122"
                    },
                    "category": {
                        "S": "book"
                    },
                    "qty": {
                        "N": "2"
                    },
                    "price": {
                        "N": "24.95"
                    },
                    "weight": {
                        "N": "200"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "leonard@example.com"
                    },
                    "created": {
                        "S": "2020-04-03T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-T122"
                    },
                    "category": {
                        "S": "Phone Case"
                    },
                    "qty": {
                        "N": "2"
                    },
                    "price": {
                        "N": "19.95"
                    },
                    "weight": {
                        "S": "iPhone 8"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "pat@example.com"
                    },
                    "created": {
                        "S": "2020-04-03T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-T122"
                    },
                    "category": {
                        "S": "Phone Case"
                    },
                    "qty": {
                        "N": "2"
                    },
                    "price": {
                        "N": "19.95"
                    },
                    "weight": {
                        "S": "iPhone 8"
                    }
                  
                }
            }
        },
        {
            "PutRequest": {
                "Item": {
                    "clientid": {
                        "S": "colin@example.com"
                    },
                    "created": {
                        "S": "2020-04-03T06:04Z"
                    },
                    "sku": {
                        "S": "SKU-T122"
                    },
                    "category": {
                        "S": "Phone Case"
                    },
                    "qty": {
                        "N": "4"
                    },
                    "price": {
                        "N": "19.95"
                    },
                    "weight": {
                        "S": "iPhone 8"
                    }
                  
                }
            }
        }
      
    ]
}
```

#### Import data
```bash
aws dynamodb batch-write-item --request-items file://mystore.json
```

#### Perform scan of ProductOrders table:

```bash
aws dynamodb scan --table-name mystore
```

#### Use Page-Size Parameter:

```bash
aws dynamodb scan --table-name mystore --page-size 1
aws dynamodb scan --table-name mystore --page-size 2
```

#### Use Max-Items Parameter:

```bash
aws dynamodb scan --table-name mystore --max-items 1
```

#### Use Projection-Expression Parameter:

```bash
aws dynamodb scan --table-name mystore --projection-expression "created"
aws dynamodb scan --table-name mystore --projection-expression "category"
aws dynamodb scan --table-name mystore --projection-expression "colour"
```

#### Use Filter-Expression Parameter:

```bash
aws dynamodb scan --table-name mystore --filter-expression "clientid = :username" --expression-attribute-values '{ ":username": { "S": "chris@example.com" }}'
aws dynamodb scan --table-name mystore --filter-expression "size = :n" --expression-attribute-values '{ ":n": { "N": "12" }}'
aws dynamodb scan --table-name mystore --filter-expression "size > :n" --expression-attribute-values '{ ":n": { "N": "12" }}'
```

#### Use Key-Conditions Parameter:

```bash
aws dynamodb query  --table-name mystore --key-conditions '{ "clientid":{ "ComparisonOperator":"EQ", "AttributeValueList": [ {"S": "chris@example.com"} ] } }'
```

#### Use Key-Condition-Expression Parameter:

```bash
aws dynamodb query --table-name mystore --key-condition-expression "clientid = :name" --expression-attribute-values '{":name":{"S":"chris@example.com"}}'
```

## Examples

1. Crate a table through a console with a compund key = partinion key + sorted key(optional)

![](images/dynamodb_1.png)
![](images/dynamodb_2.png)

2. add some row. 
![](images/dynamodb_3.png)

![](images/dynamodb_4.png)

![](images/dynamodb_5.png)

![](images/dynamodb_6.png)

## DynamoDB LSI and GSI

### DynamoDB Local Secondary Index (LSI)

- Provides an alternative sort key to use for scans and queries
- Can create up to 5 LSIs per table
- Must be created at table creation time
- You cannot add, remove, or modify it later
- It has the same partition key as your original table (different sort key)
- Gives you a different view of your data, organized by alternative sort key
- Any queries based on this sort key are much faster using the index than the main table

![](images/dynamodb_14.png)

![](images/dynamodb_15.png)

### DynamoDB Global Secondary Index (GSI)

- Used to speed up queries on non key attributes
- You can create when you create your table or at any time
- Can specify a different partition key as well as a different sort key
- Gives a completely different view of the data
- Speeds up any queries relating to this alternative partition and sort key

![](images/dynamodb_16.png)

![](images/dynamodb_17.png)

## DynamoDB Optimistic Locking and Conditional Updates

### DynamoDB Optimistic Locking

- Optimistic locking is a strategy to ensure that the client side item that you are updating (or deleting) is the same as the item in Amazon DynamoDB
- Protects database writes from being overwritten by the writes of others, and vice versa

![](images/dynamodb_18.png)

### DynamoDB Conditional Updates

- To manipulate data in an Amazon DynamoDB table, you use the `PutItem` , `UpdateItem` , and `DeleteItem` operations
- You can optionally specify a condition expression to determine which items should be modified
- If the condition expression evaluates to true, the operation succeeds; otherwise, the operation fails

![](images/dynamodb_19.png)

![](images/dynamodb_20.png)

## Adding a time to live (TTL) to items

- TTL lets you define when items in a table expire so that they can be automatically deleted from the database
- With TTL enabled on a table, you can set a timestamp for deletion on a per item basis
- No extra cost and does not use WCU / RCU
- Helps reduce storage and manage the table size over time

![](images/dynamodb_21.png)

we need to add new attibute (column) with expiry date with linux-epoch time. And then put the name of this attibute here. 

![](images/dynamodb_22.png)

## DynamoDB Streams

![](images/dynamodb_streams_1.png)

- DynamoDB Streams captures a time ordered sequence of item level modifications in any DynamoDB table
- The information is stored in a log for up to 24 hours
- Applications can access this log and view the data items as they appeared before and after they were modified, in near real time
- You can also use the `CreateTable` or `UpdateTable` API operations to enable or modify a stream
- The `StreamSpecification` parameter determines how the stream is configured:
  - `StreamEnabled` Specifies whether a stream is enabled (true) or disabled (false) for the table
  - `StreamViewType` Specifies the information that will be written to the stream whenever data in the table is modified:
    - `KEYS_ONLY` Only the key attributes of the modified item
    - `NEW_IMAGE` The entire item, as it appears after it was modified
    - `OLD_IMAGE` The entire item, as it appeared before it was modified
    - `NEW_AND_OLD_IMAGES` Both the new and the old images of the item

## Amazon DynamoDB Accelerator (DAX)

- DAX is a managed service that provides in memory acceleration for DynamoDB tables
- Improves performance from milliseconds to microseconds , even at millions of requests per second
- Provides managed cache invalidation, data population, and cluster management
- DAX is used to improve READ performance (not writes)
- You do not need to modify application logic, since DAX is compatible with existing DynamoDB API calls

![](images/dynamodb_dax_1.png)

- You can enable DAX with just a few clicks in the AWS Management Console or using the AWS SDK
- Just as with DynamoDB, you only pay for the capacity you provision
- Provisioned through clusters and charged by the node (runs on EC2 instances)
- Pricing is per node hour consumed and is dependent on the instance type you select

### DAX vs ElastiCache

- DAX is optimized for DynamoDB
- With ElastiCache you have more management overhead (e.g. invalidation)
- With ElastiCache you need to modify application code to point to cache
- ElastiCache supports more datastores

## Amazon DynamoDB Global Tables

- DynamoDB global tables is a fully managed solution for deploying a multi region, multi master database
- When you create a global table, you specify the AWS Regions where you want the table to be available
- DynamoDB performs all the necessary tasks to create identical tables in these regions, and propagate ongoing data changes to all of them

![](images/dynamodb_global_1.png)

![](images/dynamodb_global_2.png)

![](images/dynamodb_global_3.png)

## Amazon DynamoDB Encryption Client

In addition to encryption at rest, which is a server-side encryption feature, AWS provides the Amazon DynamoDB Encryption Client. This client-side encryption library enables you to protect your table data before submitting it to DynamoDB. With server-side encryption, your data is encrypted in transit over an HTTPS connection, decrypted at the DynamoDB endpoint, and then re-encrypted before being stored in DynamoDB. Client-side encryption provides end-to-end protection for your data from its source to storage in DynamoDB.

# SQS

![](images/sqs_1.png)

- Amazon SQS is pull based , not push based (like SNS)
- Messages are up to 256KB in size
- Larger messages can be sent using the Amazon SQS Extended Client Library for Java
- Messages can be kept in the queue from 1 minute to 14 days
- Default retention period is 4 days
- Amazon SQS guarantees that your messages will be processed at least once

## Queue types

![](images/sqs_2.png)

### Standart Queue

- Unlimited Throughput: Standard queues support a nearly unlimited number of transactions per second (TPS) per API
- Best Effort Ordering: Occasionally, messages might be delivered in an order different from which they were sent
- At Least Once Delivery: A message is delivered at least once, but occasionally more than one copy of a message is delivered

### FIFO Queue

- High Throughput: FIFO queues support up to 300 messages per second (300 send, receive, or delete operations per second). When you batch 10 messages per operation (maximum), FIFO queues can support up to 3,000 messages per second
- First ln First out Delivery: The order in which messages are sent and received is strictly preserved
- Exactly Once Processing: A message is delivered once and remains available until a consumer processes and deletes it. Duplicates are not introduced into the queue

- FIFO queues require the **Message Group ID** and **Message Deduplication ID** parameters to be added to messages

**Message Group ID** `MessageGroupId`

- The tag that specifies that a message belongs to a specific message group
- Messages that belong to the same message group are guaranteed to be processed in a FIFO manner
- Messages with a different Group ID may be received out of order

**Message Deduplication ID** `MessageDeduplicationId`

- The token used for deduplication of messages within the deduplication interval
- The deduplication interval is 5 minutes
- Generated as the SHA 256 with the message body

## Dead letter

![](images/sqs_3.png)

- The main task of a dead letter queue is handling message failure
- A dead letter queue lets you set aside and isolate messages that can’t be processed correctly to determine why their processing didn’t succeed
- It is not a queue type, it is a standard or FIFO queue that has been specified as a dead letter queue in the configuration of another standard or FIFO queue

![](images/sqs_4.png)

- Messages are moved to the dead letter queue when the `ReceiveCount` for a message exceeds the `maxReceiveCount` for a queue
- Dead letter queues should not be used with standard queues when your application will keep retrying transmission
- Dead letter queues will break the order of messages in FIFO queues

## SQS Delay Queue

![](images/sqs_5.png)

When to use a delay queue:
- Large distributed applications which may need to introduce a delay in processing
- You need to apply a delay to an entire queue of messages
- For example, adding a delay of a few seconds to allow updates to sales or stock control databases before sending a notification to a customer confirming an online transaction

## Visibility Timeout

- The amount of time a message is invisible in the queue after a reader picks it up
- Provided the job is processed before the visibility timeout expires, the message will then be deleted from the queue
- If the job is not processed within the visibility timeout, the message will become visible again and another reader will process it
- This could result in the same message being delivered twice
- Default visibility timeout is 30 seconds
- Maximum is 12 hours

## SQS Long Polling vs Short Polling

![](images/sqs_6.png)

- SQS **Long polling** is a way to retrieve messages from SQS queues waits for messages to arrive. 
- SQS **Short polling** returns immediately (even if the message queue is empty)
- SQS Long polling can lower costs
- SQS Long polling can be enabled at the queue level or at the API level using `WaitTimeSeconds`. The maximum amount of time that a long polling receive call will wait for a message to become available before returning an empty response.
- SQS Long polling is in effect when the Receive Message Wait Time is a value greater than 0 seconds and up to 20 seconds

## SQS CLI examples

```bash
aws sqs list-queues

aws sqs send-message --queue-url QUEUE-URL --message-body test-message-1 --delay-seconds 10

aws sqs receive-message --queue-url QUEUE-URL --wait-time-seconds 10

aws sqs send-message --queue-url QUEUE-URL --message-body test-long-short-polling
```

## Amazon SQS API

`ChangeMessageVisibility`

- Changes the visibility timeout of a specified message in a queue to a new value
- Default is 30 seconds; minimum is 0 seconds; maximum is 12 hours

`GetQueueAttributes` and `SetQueueAttributes`

- Gets/sets attributes for the specified queue
- Lots of possible values and recommend reviewing them in the AWS API reference
- Key attributes for the exam:
  - `DelaySeconds` Configures a delay queue. 0/s to 900/s (default 0/s)
  - `ReceiveMessageWaitTimeSeconds` Sets short/long polling. 0/s to 20/s (default 0s)
  - `VisibilityTimeout` The visibility timeout for the queue. 0/ to 43,200/s (12 hours) (default 30/s)

`ReceiveMessage`

- Retrieves one or more messages (up to 10), from the specified queue
- Using the `WaitTimeSeconds` parameter enables long poll support

`SendMessage`

- `DelaySeconds` parameter delays a message
- `MessageDeduplicationId` parameter adds a deduplication ID (FIFO only)
- `MessageGroupId` parameter adds a tag for a message group (FIFO only)

## What if the message is bigger than 256 KB? Java library

![](images/sqs_7.png)

- Maximum messages size in SQS is 256 KB
- You can use Amazon S3 and the Amazon SQS Extended Client Library for Java to manage Amazon SQS messages
- Useful for storing and consuming messages up to 2 GB in size
- You can use the Amazon SQS Extended Client Library for Java library to do the following:
  - Specify whether messages are always stored in Amazon S3 or only when the size of a message exceeds 256 KB
  - Send a message that references a single message object stored in an Amazon S3 bucket
  - Get the corresponding message object from an Amazon S3 bucket
  - Delete the corresponding message object from an Amazon S3 bucket

# SNS Simple Notification Service

![](images/sns_1.png)

- Amazon SNS is a highly available, durable, secure, fully managed pub/sub messaging service
- Amazon SNS provides topics for high throughput, push based, many to many messaging
- Publisher systems can fan out messages to a large number of subscriber endpoints
  - Amazon SQS queues
  - AWS Lambda functions
  - HTTP/S webhooks
  - Mobile push
  - SMS
  - Email

- Multiple recipients can be grouped using Topics
- A topic is an “access point” for allowing recipients to dynamically subscribe for identical copies of the same notification
- One topic can support deliveries to multiple endpoint types
- Flexible message delivery over multiple transport protocols

## Amazon SNS + Amazon SQS Fan Out
- You can subscribe one or more Amazon SQS queues to an Amazon SNS topic
- Amazon SQS manages the subscription and any necessary permissions
- When you publish a message to a topic, Amazon SNS sends the message to every subscribed queue

![](images/sns_2.png)

# Simple serverless

![](images/simple_serverless_1.png)

# AWS Step Functions

![](images/sf_1.png)

- AWS Step Functions is used to build distributed applications as a series of steps in a visual workflow.
- You can quickly build and run state machines to execute the steps of your application

How it works:
1. Define the steps of your workflow in the JSON based Amazon States Language. The visual console automatically graphs each step in the order of execution
2. Start an execution to visualize and verify the steps of your application are operating as intended. The console highlights the real time status of each step and provides a detailed history of every execution
3. AWS Step Functions operates and scales the steps of your application and underlying compute for you to help ensure your application executes reliably under increasing demand

![](images/sf_2.png)

In the Amazon States Language, these fields filter and control the flow of JSON from state to state:

- InputPath
- OutputPath
- ResultPath
- Parameters
- ResultSelector

Use **ResultPath** to combine a task result with task input, or to select one of these. The path you provide to ResultPath controls what information passes to the output. Use ResultPath in a Catch to include the error with the original input, instead of replacing it.

# Amazon EventBridge

![](images/event_bridge_1.png)

![](images/event_bridge_2.png)

![](images/event_bridge_3.png)

![](images/event_bridge_4.png)

# Amazon API Gateway

![](images/gateway_1.png)

Amazon API Gateway supports:

- **REST APIs** support OIDC and OAuth 2.0 authorization, and come with built in support for CORS and automatic deployments
- **HTTP APIs** designed for low latency, cost effective integrations with AWS services, including AWS Lambda, and HTTP endpoints
- **WebSocket APIs** deployed as a stateful frontend for an AWS service (such as Lambda or DynamoDB) or for an HTTP endpoint
- REST APIs and HTTP APIs support authorizers for AWS Lambda, IAM, and Amazon Cognito
- WebSocket APIs support IAM authorization and Lambda authorizers

## Feautures

Support for RESTful APIs and WebSocket APIs: With API Gateway, you can create RESTful APIs using either HTTP APIs or REST APIs

Private integrations with AWS ELB & AWS Cloud Map: Route requests to private resources in your VPC. Using HTTP APIs, you can build APIs for services behind private ALBs, private NLBs, and IP based services registered in AWS Cloud Map, such as ECS tasks

Metering: Define plans that meter and restrict third-party developer access to APIs

Security: API Gateway provides multiple tools to authorize access to APIs and control service operation access

Resiliency: Manage traffic with throttling so that backend operations can withstand traffic spikes

Operations Monitoring: API Gateway provides a metrics dashboard to monitor calls to services

Lifecycle Management: Operate multiple API versions and multiple stages for each version simultaneously so that existing applications can continue to call previous versions after new API versions are published

AWS Authorization: Support for signature version 4 for REST APIs and WebSocket APIs, IAM access policies, and authorization with bearer tokens (e.g. JWT, SAML) using Lambda functions

## Deployment types

![](images/gateway_2.png)

### Edge Optimized APIs

- An edge optimized API endpoint is best for geographically distributed clients
- API requests are routed to the nearest CloudFront Point of Presence (POP)
- This is the default endpoint type for API Gateway REST APIs
- Edge optimized APIs capitalize the names of HTTP headers

### Regional APIs

- A regional API endpoint is intended for clients in the same region
- Reduces connection overhead for connections from the same Region
- Any custom domain name that you use is specific to the region where the API is deployed
- If you deploy a regional API in multiple regions, it can have the same custom domain name in all regions

### Private endpoint

Private REST APIs can only be accessed from within a VPC using an interface VPC endpoint

![](images/gateway_3.png)

## Structure of API

![](images/gateway_4.png)

- A Method resource is integrated with an Integration resource
- **Method request**: The public interface of a REST API method in API Gateway that defines the parameters and body that an app developer must send in requests to access the backend through the API
- **Method response**: The public interface of a REST API that defines the status codes, headers, and body models that an app developer should expect in responses from the API
  
- API methods are integrated with backend endpoints using API integrations
- Backend endpoints are known as “integration endpoints”
- **Integration request**: 
  - The internal interface of a WebSocket API route or REST API method in API Gateway
  - Maps the body of a route request or the parameters and body of a method request to the formats required by the backend
- **Integration response:**:
  - The internal interface of a WebSocket API route or REST API method in API Gateway
  - Maps the status codes, headers, and payload that are received from the backend to the response format that is returned to a client app

## Integration Types

- You choose an API integration type according to the types of integration endpoint you work with and how you want data to pass to and from the integration endpoint
- For a Lambda function, you can have the **Lambda proxy integration** , or the **Lambda custom integration**
- For an HTTP endpoint, you can have the **HTTP proxy** integration or the **HTTP custom integration**
- For an AWS service action, you have the **AWS integration** of the non proxy type only
- API Gateway also supports the mock integration, where API Gateway serves as an integration endpoint to respond to a method request

### AWS integration

- This type of integration lets an API expose AWS service actions
- Must configure both the integration request and integration response and set up necessary data mappings from the method request to the integration request, and from the integration response to the method response

![](images/gateway_5.png)

### AWS_PROXY (or Lambda proxy integration)

- This integration relies on direct interactions between the client and the integrated Lambda function
- With this type of integration, also known as the **Lambda proxy integration**, you do not set the integration request or the
integration response
- API Gateway passes the incoming request from the client as the input to the backend Lambda function
- The integrated Lambda function takes the input of this format and parses the input from all available sources, including request headers, URL path variables, query string parameters and applicable body
- The function returns the result following this output format

![](images/gateway_6.png)

### HTTP

- This type of integration lets an API expose HTTP endpoints in the backend
- With the HTTP integration, also known as the **HTTP custom integration**, you must configure both the integration request and integration response
- You must set up necessary data mappings from the method request to the integration request, and from the integration response to the method response

![](images/gateway_7.png)

### MOCK

- This type of integration lets API Gateway return a response without sending the request further to the backend
- Used to test the integration set up without incurring charges for using the backend and to enable collaborative development of an API
- A team can isolate their development effort by setting up simulations of API components owned by other teams by using the MOCK integrations

## Mapping Templates

- An API's method request can take a payload in a different format from the corresponding integration request payload, as required in the backend
- Similarly, the backend may return an integration response payload different from the method response payload, as expected by the frontend
- API Gateway lets you use mapping templates to map the payload from a method request to the corresponding integration request and from an integration response to the corresponding method response
- A mapping template is a script expressed in Velocity Template Language (VTL) and applied to the payload using JSONPath expressions

![](images/gateway_8.png)

## API Gateway Stages and Deployments

- **Deployments** are a snapshot of the APIs resources and methods
-  Deployments must be created and associated with a **stage** for anyone to access the API
- A stage is a logical reference to a lifecycle state of your REST or WebSocket API (e.g. `dev`, `prod`, `beta`, `v2`)
- API stages are identified by API ID and stage name 
- Stage variables are like environment variables for API Gateway
- Stage variables can be used in:
  - Lambda function ARN
  - HTTP endpoint
  - Parameter mapping templates

![](images/gateway_9.png)

Use cases for stage variables:
- Configure HTTP endpoints your stages talk to (dev, test, prod etc.)
- Pass configuration parameters to AWS Lambda through mapping templates
- Stage variables are passed to the “context” object in Lambda
- Stage variables are used with Lambda aliases
- You can create a stage variable to indicate the corresponding Lambda alias
- You can create canary deployments for any stage and choose the % of traffic the canary channel receives

## Swagger and Open API 3

- You can import existing Swagger / Open API 3.0 definitions (written in YAML or JSON) to API Gateway
- This is a common way of defining REST APIs using API definition as code
- Can also export current APIs as Swagger / Open API 3.0 definition
- Uses the API Gateway Import API feature to import an API from an external definition
- You specify the options using a mode query parameter in the request URL

## Caching and Throttling

### Caching

- You can add caching to API calls by provisioning an Amazon API Gateway cache and specifying its size in gigabytes
- Caching allows you to cache the endpoint's response
- Caching can reduce number of calls to the backend and improve latency of requests to the API

![](images/gateway_10.png)

- API Gateway caches responses for a specific amount of time (time to live or TTL)
- The default TTL is 300 seconds (min 0, max 3600)
- Caches are defined per stage
- You can encrypt caches
- The cache capacity is between 0.5GB to 237GB
- It is possible to override cache settings for specific methods
- You can flush the entire cache (invalidate it) immediately if required
- Clients can invalidate the cache with the header: `Cache-Control: max age=0`

### Throttling

- API Gateway sets a limit on a steady state rate and a burst of request submissions against all APIs in your account
- Limits:
  - By default, API Gateway limits the steady state request rate to 10,000 requests per second
  - The maximum concurrent requests is 5,000 requests across all APIs within an AWS account
  - If you go over 10,000 requests per second or 5,000 concurrent requests, you will receive a 429 Too Many Requests error response
- Upon catching such exceptions, the client can resubmit the failed requests in a way that is rate limiting, while complying with the API Gateway throttling limits
- Amazon API Gateway provides two basic types of throttling related settings:
  - **Server-side** throttling limits are applied across all clients. These limit settings exist to prevent your API and your
account from being overwhelmed by too many requests
  - **Per-client** throttling limits are applied to clients that use API keys associated with your usage policy as client
identifier
- API Gateway throttling related settings are applied in the following order:
  - Per-client per method limits that you set for an API stage in a usage plan
  - Per-client limits that you set in a usage plan
  - Default per-method limits and individual per method limitsvthat you set in API stage settings
  - Account level throttling

## API Gateway Usage Plans and API Keys

![](images/gateway_11.png)

- A usage plan specifies who can access one or more deployed API stages and methods and how much and how fast they can access them
- You can use a usage plan to configure throttling and quota limits, which are enforced on individual client API keys
- The plan uses API keys to identify API clients and meters access to the associated API stages for each key
- It also lets you configure throttling limits and quota limits that are enforced on individual client API keys
- You can use API keys together with usage plans or Lambda authorizers to control access to your APIs

- API keys are alphanumeric string values that you distribute to application developer customers to grant access to your API. 
- You can use API keys together with usage plans or Lambda authorizers to control access to your APIs. 
- API Gateway can generate API keys on your behalf, or you can import them from a CSV file. You can generate an API key in API Gateway, or import it into API Gateway from an external source.
- To associate the newly created key with a usage plan the `CreatUsagePlanKey` API can be called. This creates a usage plan key for adding an existing API key to a usage plan.


In your WebSocket API, incoming JSON messages are directed to backend integrations based on routes that you configure. (Non-JSON messages are directed to a $default route that you configure.)

A route includes a route key, which is the value that is expected once a route selection expression is evaluated. The routeSelectionExpression is an attribute defined at the API level. It specifies a JSON property that is expected to be present in the message payload.

For example, if your JSON messages contain an action property and you want to perform different actions based on this property, your route selection expression might be `${request.body.action}`. Your routing table would specify which action to perform by matching the value of the action property against the custom route key values that you have defined in the table.

## API Gateway Access Control

There are several mechanisms for controlling and managing access to an API:
- Resource-based policies
- Identity-based policies
- IAM Tags
- Endpoint policies for interface VPC endpoints
- Lambda authorizers
- Amazon Cognito user pools

### Resource Based Policies 

- Amazon API Gateway resource policies are JSON policy documents that you attach to an API
- Control whether a specified principal can invoke the API

![](images/gateway_12.png)

![](images/gateway_13.png)

### Lambda Authorizer

- A Lambda authorizer is an API Gateway feature that uses a Lambda function to control access to your API
- API Gateway calls the Lambda authorizer, which takes the caller's identity as input and returns an IAM policy as output
- There are two types of Lambda authorizers:
  - A token based Lambda authorizer receives the caller's identity in a bearer token, such as a JSON Web Token (JWT) or an OAuth token.
  - A request parameter based Lambda authorizer receives the caller's identity in a combination of headers, query string parameters, stageVariables, and $context variables
- For WebSocket APIs, only request parameter based authorizers are supported

![](images/gateway_14.png)

### Cognito User Pool Authorizer

- A user pool is a user directory in Amazon Cognito
- With a user pool, users can sign into a web or mobile app through Amazon Cognito
- Users can also sign in through social identity providers like Google, Facebook, Amazon, or Apple, and through SAML identity providers
- You can use an Amazon Cognito user pool to control who can access your API in Amazon API Gateway
- You create an authorizer of the `COGNITO_USER_POOLS` type and then configure an API method to use that authorizer

![](images/gateway_15.png)



## Logging

There are two types of API logging in CloudWatch: execution logging and access logging. In execution logging, API Gateway manages the CloudWatch Logs. The process includes creating log groups and log streams, and reporting to the log streams any caller's requests and responses.

The logged data includes errors or execution traces (such as request or response parameter values or payloads), data used by Lambda authorizers, whether API keys are required, whether usage plans are enabled, and so on.

In access logging, you, as an API Developer, want to log who has accessed your API and how the caller accessed the API. You can create your own log group or choose an existing log group that could be managed by API Gateway.

# ECS

![](images/ecs_1.png)

## Features

- Serverless with AWS Fargate managed for you and fully scalable
- Fully managed container orchestration control plane is managed for you
- Docker support run and manage Docker containers with integration into the Docker Compose CLI
- Windows container support ECS supports management of Windows containers
- Elastic Load Balancing integration distribute traffic across containers using ALB or NLB
- Amazon ECS Anywhere (NEW) enables the use of Amazon ECS control plane to manage on premises implementations

## Components

**Cluster** - Logical grouping of tasks or services

**Container instance** - EC2 instance running the the ECS agent

**Task Definition** - Blueprint that describes how a docker container should launch

**Task** - A running container using settings in a Task Definition

**Service**  - Defines long running tasks can control task count with Auto Scaling and attach an ELB

### Amazon ECS Clusters

- ECS Clusters are a logical grouping of container instances that you can place tasks on
- A default cluster is created but you can then create multiple clusters to separate resources
- ECS allows the definition of a specified number (desired count) of tasks to run in the cluster
- Clusters can contain tasks using the **Fargate** and **EC2 launch type**
- EC2 launch type clusters can contain different container instance types
- Each container instance may only be part of one cluster at a time
- Clusters are region specific
- You can create IAM policies for your clusters to allow or restrict users' access to specific clusters

### ECS Container Instances and Container Agent

- You can use any AMI that meets the Amazon ECS AMI specification
- The EC2 instances used as container hosts must run an ECS agent
- The ECS container agent allows container instances to connect to the cluster
- The container agent runs on each infrastructure resource on an ECS cluster

### Amazon ECS Images

- Containers are created from a read-only template called an image which has the instructions for creating a Docker container
- Images are built from a Dockerfile
- Only Docker containers are supported on ECS
- Images are stored in a registry such as DockerHub or Amazon Elastic Container Registry (ECR)
- ECR is a managed AWS Docker registry service that is secure, scalable and reliable
- ECR supports private Docker repositories with resource based permissions using AWS IAM in order to access repositories and images
- You can use the Docker CLI to push, pull and manage images

### Amazon ECS Tasks and Task Definitions

- A task definition is required to run Docker containers in Amazon ECS
- A task definition is a text file in JSON format that describes one or more containers, up to a maximum of 10
- Task definitions use Docker images to launch containers
- You specify the number of tasks to run ((i.e. the number of containers)

Some of the parameters you can specify in a task definition include:
- Which Docker images to use with the containers in your task
- How much CPU and memory to use with each container
- Whether containers are linked together in a task
- The Docker networking mode to use for the containers in your task
- What (if any) ports from the container are mapped to the host container instances
- Whether the task should continue if the container finished or fails
- The commands the container should run when it is started
- Environment variables that should be passed to the container when it starts
- Data volumes that should be used with the containers in the task
- IAM role the task should use for permissions

## Launch Types

### Fargate Launch Type

![](images/ecs_2.png)

- Run containers without the need to provision and manage the backend infrastructure
- AWS Fargate is the serverless way to host your Amazon ECS workloads
- Fargate automatically provisions resources
- Fargate provisions and manages compute
- Charged for running tasks
- No EBS integration
- Fargate handles cluster optimization
- Limited control, infrastructure is automated

### EC2 Launch Type

![](images/ecs_3.png)

- Run containers on a cluster of Amazon EC2 instances that you manage
- You explicitly provision EC2 instances
- You’re responsible for upgrading, patching, care of EC2 pool
- You’re responsible for managing EC2 instances
- Charged per running EC2 instance
- EFS and EBS integration
- You handle cluster optimization
- More granular control over infrastructure

### External Launch Type

- Run containers on your on-premises servers or virtual machines (VMs) uses Amazon ECS Anywhere

## Amazon ECS and IAM Roles

![](images/ecs_4.png)

![](images/ecs_5.png)

## ECS Task Placement Strategies

- A task placement strategy is an algorithm for selecting instances for task placement or tasks for termination
- Task placement strategies can be specified when either running a task or creating a new service
- This is relevant only to the EC2 launch type
- Amazon ECS supports the following task placement strategies:
  - **binpack** place tasks based on the least available amount of CPU or memory. This minimizes the number of instances in use - **random** place tasks randomly
  - **spread** place tasks evenly based on the specified value
    - Accepted values are `instanceId` or `host` (same effect)
    - Or any platform or custom attribute that is applied to a container instance, such as `attribute:ecs.availability-zone`
    - Service tasks are spread based on the tasks from that service
    - Standalone tasks are spread based on the tasks from the same task group- 

The following strategy distributes tasks evenly across Availability Zones

```json
"placementStrategy": [
  {
    "field": "attribute:ecs:availability-zone",
    "type": "spread"
  }
]
```

The following strategy distributes tasks evenly across all instances


```json
"placementStrategy": [
  {
    "field": "instanceId",
    "type": "spread"
  }
]
```

The following strategy bin packs tasks based on memory


```json
"placementStrategy": [
  {
    "field": "memory",
    "type": "binpack"
  }
]
```

The following strategy distributes tasks evenly across Availability Zones and then bin packs tasks based on memory within each Availability Zone

```json
"placementStrategy": [
  {
    "field": "attribute:ecs:availability-zone",
    "type": "spread"
  },  
  {
    "field": "memory",
    "type": "binpack"
  }
]
```

- A task placement constraint is a rule that is considered during task placement
- Amazon ECS supports the following types of task placement constraints:
  - **distinctInstance** Place each task on a different container instance
  - **memberOf** Place tasks on container instances that satisfy an expression

### Cluster Query Language

- Cluster queries are expressions that enable you to group objects
- For example, you can group container instances by attributes such as Availability Zone , instance type , or custom metadata
- Expressions have the following syntax: `subject operator [argument]`

Example 1:

The following expression selects instances with the specified instance type:

```
attribute:ecs.instance-type == t2.small
```

Example 2:

The following expression selects instances in the us east 1a or us east 1b Availability Zone:

```
attribute:ecs.availabllity-zone in [us-east-1a, us-east-1b]
```


Example 3:

The following expression selects instances that are hosting tasks in the `service:production` group:

```
task:group == service:production
```

## Scaling Amazon ECS

### Service auto scaling

![](images/ecs_7.png)

- automatically adjusts the desired task count up or down using the Application Auto Scaling service

Amazon ECS Service Auto Scaling supports the following types of scaling policies:

- **Target Tracking Scaling Policies** Increase or decrease the number of tasks that your service runs based on a target value for a specific CloudWatch metric

- **Step Scaling Policies** Increase or decrease the number of tasks that your service runs in response to CloudWatch alarms. Step scaling is based on a set of scaling adjustments, known as step adjustments, which vary based on the size of the alarm breach
  
- **Scheduled Scaling** Increase or decrease the number of tasks that your service runs based on the date and time

### Cluster auto scaling

![](images/ecs_8.png)

- uses a Capacity Provider to scale the number of EC2 cluster instances using EC2 Auto Scaling

- Uses an ECS resource type called a **Capacity Provider**

- A Capacity Provider can be associated with an EC2 **Auto Scaling Group** (ASG)

- ASG can automatically scale using:

  - **Managed scaling** with an automatically created scaling policy on your ASG
  - **Managed instance termination protection** which enables container aware termination of instances in the ASG when scale in happens

## Amazon ECS with ALB

![](images/ecs_9.png)

## Example

1. Create a role for working with ec2 instances and ecs
  
![](images/ec2_example_1.png)

![](images/ecs_example_2.png)

![](images/ecs_example_3.png)

2. create a cluster with manual instance configuration
  
![](images/ecs_example_4.png)

![](images/ecs_example_5.png)

3. Go to the [link](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/ecs-optimized_AMI.html) to get aim id for instance for our region

4. configure ec2 instance
![](images/ecs_example_6.png)

![](images/ecs_example_7.png)

![](images/ecs_example_8.png)

```bash
#!/bin/bash
echo ECS_CLUSTER=myecs-cluster >> /etc/ecs/ecs.config
```

![](images/ecs_example_9.png)

5. Check adding instance to the ecs cluster 
  
![](images/ecs_example_10.png)

6. Create a task definition

![](images/ecs_example_11.png)

![](images/ecs_example_12.png)

7. Run task in a cluster
  
![](images/ecs_example_13.png)

![](images/ecs_example_14.png)

![](images/ecs_example_15.png)

the stop that task.

Now we want to create a service , not a task.

1. create a service
   
![](images/ecs_example_16.png)

![](images/ecs_example_17.png)

![](images/ecs_example_18.png)

2. check that alb is created

![](images/ecs_example_19.png)

![](images/ecs_example_20.png)


3. check default security group settings to allow http trafic
  
![](images/ecs_example_21.png)

4. copy public dns for load balancer and check service

[](images/ecs_example_22.png)

## Amazon Elastic Container Registry (ECR)

-  Amazon ECR is a fully managed container registry
- Integrated with Amazon ECS and Amazon EKS
- Supports Open Container Initiative (OCI) and Docker Registry HTTP API V2 standards
- You can use Docker tools and Docker CLI commands such as `push` , `pull` , `list` , and `tag`
- Can be accessed from any Docker environment in the cloud, on premises, or on you machine
- Container images and artifacts are stored in S3
- You can use namespaces to organize repositories
- Public repositories allow everyone to access container images
- Access control applies to private repositories:
  - IAM access control. Set policies to define access to container images in private repositories
  - Resource-based policies. Access control down to the individual API action such as `create` , `list` , `describe` , `delete` , and `get`

**Registry** An Amazon ECR private registry is provided to each AWS account; you can create one or more repositories in your registry and store images in them

**Authorization token** Your client must authenticate to Amazon ECR registries as an AWS user before it can push and pull images

**Repository** An Amazon ECR repository contains your Docker images, OCI images, and OCI compatible artifacts

**Repository policy** You can control access to your repositories and the images within them with repository policies

**Image** You can push and pull container images to your repositories

**Lifecycle policies** manage the lifecycle of the images in your repositories

**Image scanning** identify software vulnerabilities in your container images

**Cross-Region and cross-account replication** replicate images across accounts/Region

**Pull through cache rules** cache repositories in remote public registries in your private Amazon ECR registry

![](images/ecr_1.png)

### Pushing an Image to a Private Repository

![](images/ecr_2.png)

1. First, authenticate the Docker client to ECR:

```bash
aws ecr get-login-password --region region | docker login --username AWS --password-stdin aws_account_id.dkr.ecr.region.amazonaws.com
```

2. Tag your image with the Amazon ECR registry, repository, and image tag name to use
  
```bash
docker tag e9ae3c220b23 aws_account_id.dkr.ecr.region.amazonaws.com/my-repository:tag
```

3. Push the image using the docker push command

```bash
docker push aws_account_id.dkr.ecr.region.amazonaws.com/my-repository:tag
```

### create an image and push to the ecr

1. Preparation
  
```bash
sudo su
yum update
yum install docker
systemctl enable docker.service
systemctl start docker.service
docker pull nginx
docker images
```

2. Create policy and role
Policy

```json
{
    "Version": "2012-10-17",
    "Id": "ECRPolicy",
    "Statement": [
        {
            "Sid": "AllowAll",
            "Effect": "Allow",
            "Action": "ecr:*",
            "Resource": "*"
        }
    ]
}
```
create a role "Ecr-role"

3. modiry ec2 instance to put the iam role to this
4. create repository

```bash
aws ecr create-repository --repository-name nginx --region eu-north-1
```

5. tag an image
  
```bash
docker tag nginx:latest 967120122177.dkr.ecr.eu-north-1.amazonaws.com/nginx:latest
```

6. login to repository

```bash
aws ecr get-login-password --region eu-north-1 | docker login --username AWS --password-stdin 967120122177.dkr.ecr.eu-north-1.amazonaws.com/nginx
```

7. push image to the registry

```bash
docker push 967120122177.dkr.ecr.eu-north-1.amazonaws.com/nginx:latest
```

![](images/ecr_3.png)

![](images/ecr_4.png)

### create a task definition and load balancer

```json
{
    "executionRoleArn": "arn:aws:iam::967120122177:role/ecsTaskExecutionRole",
    "containerDefinitions": [
        {
            "name": "sample-website",
            "image": "nginx",
            "essential": true,
            "portMappings": [
                {
                    "hostPort": 80,
                    "protocol": "tcp",
                    "containerPort": 80
                }
            ]
        }
    ],
    "requiresCompatibilities": [
        "FARGATE"
    ],
    "networkMode": "awsvpc",
    "cpu": "256",
    "memory": "512",
    "family": "ecs-lab"
}
```

```bash
aws ecs register-task-definition --cli-input-json file://taskdef.json
```

- Create an Application Load Balancer
- Should be internet facing
- Listen on HTTP port 80
- Add a second listener on HTTP 8080
- Choose 2 public subnets in different AZs
- Create a new TG - target-group-1, protocol HTTP 80, target type = IP address
- Creat a second TG - target-group-2, protocol HTTP 8080, target type = IP address
- For the second listener, forward to target-group-2
- Update security group to allow inbound on 80 and 8080

![](images/ecr_5.png)

### create fargate cluster and service

![](images/ecr_6.png)

```json
{
    "taskDefinition": "ecs-lab:1",
    "cluster": "my-ecs-lab-cluster",
    "loadBalancers": [
        {
            "targetGroupArn": "arn:aws:elasticloadbalancing:eu-north-1:967120122177:targetgroup/target-group-1/e643ef57b116e03b",
            "containerName": "sample-website",
            "containerPort": 80
        }
    ],
    "desiredCount": 1,
    "launchType": "FARGATE",
    "schedulingStrategy": "REPLICA",
    "deploymentController": {
        "type": "CODE_DEPLOY"
    },
    "networkConfiguration": {
        "awsvpcConfiguration": {
            "subnets": [
                "subnet-06de25a3fe9cbc2d5",
                "subnet-04aad41493971da07"
            ],
            "securityGroups": [
                "sg-0e8b189c4b4611c55":
            ],
            "assignPublicIp": "ENABLED"
        }
    }
}
```

```bash
aws ecs create-service --service-name my-service --cli-input-json file://create-service.json
```

### codedeploy application and pipeline

current state 
![](images/lab_1.png)

1. create code commit repository ecs-lab (via UI console)
2. clone repo

paste this in file taskdef.json

```json
{
    "executionRoleArn": "arn:aws:iam::967120122177:role/ecsTaskExecutionRole",
    "containerDefinitions": [
        {
            "name": "sample-website",
            "image": "<IMAGE_NAME>",
            "essential": true,
            "portMappings": [
                {
                    "hostPort": 80,
                    "protocol": "tcp",
                    "containerPort": 80
                }
            ]
        }
    ],
    "requiresCompatibilities": [
        "FARGATE"
    ],
    "networkMode": "awsvpc",
    "cpu": "256",
    "memory": "512",
    "family": "ecs-lab"
}
```

and to `appspec.yaml`

```json
version: 0.0
Resources:
  - TargetService:
      Type: AWS::ECS::Service
      Properties:
        TaskDefinition: <TASK_DEFINITION>
        LoadBalancerInfo:
          ContainerName: "sample-website"
          ContainerPort: 80
```

3. create a role for deploy to ecs `CodeDeployECSRole`
  
![](images/lab_2.png)

4. create application in code deploy

![](images/lab_3.png)

![](images/lab_4.png)

5. create deployment group

![](images/lab_5.png)

![](images/lab_6.png)

![](images/lab_7.png)

6. create a pipeline
  
![](images/lab_8.png)

![](images/lab_9.png)

![](images/lab_01.png)

![](images/lab_02.png)

7. Add image image action to first stage

![](images/lab_03.png)

![](images/lab_04.png)

![](images/lab_05.png)

8. Edit deploy action
  
![](images/lab_06.png)

9. release changes

![](images/lab_07.png)


10. We can see that traffic started to switch to another target group
    
![](images/lab_08.png)

![](images/lab_09.png)

then rollback pipeline. 

### implement blue/green update

1. delete and push the image again
  
and in details it is possible to see how changed traffic

![](images/lab_001.png)

state after switching

![](images/lab_002.png)

# EKS

![](images/eks_1.png)

- Amazon Elastic Kubernetes Service (Amazon EKS) is a managed service
- Use when you need to **standardize** container orchestration across multiple environments using a **managed** Kubernetes implementation
- **Hybrid Deployment** manage Kubernetes clusters and applications across hybrid environments (AWS + On premises)
- **Batch Processing** run sequential or parallel batch workloads on your EKS cluster using the Kubernetes Jobs API. Plan, schedule and execute batch workloads
- **Machine Learning** use Kubeflow with EKS to model your machine learning workflows and efficiently run distributed training jobs using the latest EC2 GPU powered instances, including Inferentia
- **Web Applications** build web applications that automatically scale up and down and run in a highly available configuration across multiple Availability Zones

## Amazon EKS Auto Scaling

Cluster Auto Scaling:
- **Vertical Pod Autoscaler** automatically adjusts the CPU and memory reservations for your pods to help "right size" your applications
- **Horizontal Pod Autoscaler** automatically scales the number of pods in a deployment, replication controller, or replica set based on that resource's CPU utilization 
  
Workload Auto Scaling:
- Amazon EKS supports two autoscaling products:
  - Kubernetes Cluster Autoscaler
  - Karpenter open source autoscaling project.

- The cluster autoscaler uses AWS scaling groups, while Karpenter works directly with the Amazon EC2 fleet

## Amazon EKS Pod Networking

- Amazon EKS supports native VPC networking with the Amazon VPC Container Network Interface (CNI) plugin for Kubernetes
- This plugin assigns a private IPv4 or IPv6 address from your VPC to each pod
-  The VPC CNI plugin for Kubernetes is deployed with each of your Amazon EC2 nodes in a Daemonset with the name `aws-node`
- The plugin consists of two components:
  - **L-IPAM** daemon Responsible for creating network interfaces and attaching the network interfaces to Amazon EC2 instances, assigning secondary IP addresses to network interfaces, and maintaining a warm pool of IP addresses on each node for assignment to Kubernetes pods when they are scheduled
  - **CNI plugin** Responsible for wiring the host network (for example, configuring the network interfaces and virtual Ethernet pairs) and adding the correct network interface to the pod namespace

## Amazon EKS and Elastic Load Balancing

- Amazon EKS supports **Network Load Balancer** and **Application Load Balancers**
- The AWS Load Balancer Controller manages AWS Elastic Load Balancers for a Kubernetes cluster
- Install the AWS Load Balancer Controller using Helm V3 or later or by applying a Kubernetes manifest
- The controller provisions the following resources:
  - An AWS Application Load Balancer (ALB) when you create a Kubernetes Ingress
  - An AWS Network Load Balancer (NLB) when you create a Kubernetes service of type `LoadBalancer`
- In the past, the Kubernetes network load balancer was used for instance targets, but the AWS Load balancer Controller was used for IP targets
-  With the AWS Load Balancer Controller version 2.3.0 or later, you can create NLBs using either target type
  
# Copilot 

- Command line interface for launching and managing containers
- Used with ECS, Fargate, and AWS AppRunner
- Based on Infrastructure as Code (IaC) templates
- Simple commands to build containerized environments

build a copilot environment
```bash
copilot init
```

show info about environments and services

```bash
copilot app show
```

show info about environments

```bash
copilot env ls
```

list of all services in an applicaition

```bash
copilot svc ls
```

show service status

```bash
copilot svc status
```

Install the Copilot CLI
```bash
sudo curl -Lo /usr/local/bin/copilot https://github.com/aws/copilot-cli/releases/latest/download/copilot-linux && sudo chmod +x /usr/local/bin/copilot && copilot --help
```

clone sample app

```bash
git clone https://github.com/aws-samples/amazon-ecs-cli-sample-app.git demo-app
```

init and deploy sample app

```bash
copilot init --app demo --name api --type 'Load Balanced Web Service' --dockerfile './Dockerfile' --port 80 --deploy
```

after that actually cloud formation will be started. It is possible to see a cloud formations events and logs.

Delete the app by running the following command
```bash
copilot app delete
```

# AWS CI/CD Tools

![](images/devops_1.png)

![](images/devops_2.png)

![](images/devops_3.png)

## Code Commit

- AWS CodeCommit is a fully managed source control service that hosts secure Git based repositories
- Git is an Open Source distributed source control system:
- Centralized repository for all of your code, binaries, images,
and libraries
- Tracks and manages code changes
- Maintains version history
- Manages updates from multiple sources
- Enables collaboration
- **CodeCommit repositories are private**
- CodeCommit scales seamlessly
- Repositories are automatically encrypted at rest through AWS Key Management Service (AWS KMS) using customer-specific keys.
- CodeCommit is integrated with Jenkins, CodeBuild and other CI tools
- You can transfer your files to and from AWS CodeCommit using HTTPS or SSH
- Repositories are automatically encrypted at rest through AWS Key Management Service (AWS KMS) using customer specific keys

### Authentication and Access Control

- AWS CodeCommit uses AWS IAM to control and monitor who can access data as well as how, when, and where they can access it.
- CodeCommit helps monitor your repositories via AWS CloudTrail and AWS CloudWatch.
- You need to configure your Git client to communicate with CodeCommit repositories
- IAM supports CodeCommit with three types of credentials:

  - **Git credentials** an IAM generated user name and password pair you can use to communicate with CodeCommit repositories over HTTPS
  - **SSH keys** a locally generated public private key pair that you can associate with your IAM user to communicate with CodeCommit repositories over SSH
  - **AWS access keys** which you can use with the credential helper included with the AWS CLI to communicate with CodeCommit repositories over HTTPS 

![](images/devops_4.png)

![](images/devops_5.png)

![](images/devops_6.png)

![](images/devops_7.png)

Edit Local SSH Configuration
Edit your SSH configuration file`~/.ssh/config`. Add the following lines to the file

```
Host git-codecommit.*.amazonaws.com
User Your-IAM-SSH-Key-ID-Here
IdentityFile ~/.ssh/Your-Private-Key-File-Name-Here
```

![](images/devops_8.png)

### Authorization

- IAM policies for authorizing access for users/roles to repositories.
- CodeCommit only supports identity-based policies, not resource-based policies.
- You can attach tags to CodeCommit resources or pass tags in a request to CodeCommit.
- To control access based on tags, you provide tag information in the condition element of a policy using the `codecommit:ResourceTag/key-name`, `aws:RequestTag/key-name`, or `aws:TagKeys` condition keys.

### Notifications

You can trigger notifications in CodeCommit using **AWS SNS** or **AWS Lambda** or **AWS CloudWatch Event** rules.

Notifications are in relation to pull request and comment events – triggers are related to pushing to a branch or creating / deleting a branch.

Use cases for notifications **SNS** / **AWS Lambda**:

- Deletion of branches.
- Trigger for pushes that happen in the master branch.
- Notify external build system.
- Trigger AWS Lambda function to perform codebase analysis.

Use cases for **CloudWatch Event Rules**:

- Trigger for pull request updates (created / updated / deleted / commented).
- Commit comment events.
- CloudWatch Event Rules go into an SNS Topic.

## Code Pipeline

- Fully managed continuous delivery service that helps you automate your release pipelines for fast and reliable application and infrastructure updates
- Automates the build, test, and deploy phases of your release process every time there is a code change, based on the release model you define
- CodePipeline provides tooling integrations for many AWS and third party software at each stage of the pipeline including:
  - **Source stage** S3, CodeCommit , Github , ECR, Bitbucket Cloud (
  - **Build** CodeBuild ,Jenkins
  - **Deploy stage** CloudFormation, CodeDeploy, ECS, Elastic Beanstalk, AWS, Service Catalog, S3
- **Pipelines** A workflow that describes how software changes go through the release process
- **Artifacts**
  - Files or changes that will be worked on by the actions and stages in the pipeline
  - Each pipeline stage can create "artifacts"
  - Artifacts are passed, stored in Amazon S3 and then passed on to the next stage
- **Stages**
  - Pipelines are broken up into stages
  - Each stage can have sequential actions and or parallel actions
  - Stage examples would be build, test, deploy, load test etc.
  - Manual approval can be defined at any stage
- **Actions**
  - Stages contain at least one action
  - Actions affect artifacts and will have artifacts as either an input, and output, or both
- **Transitions**
  - The progressing from one stage to another inside of a pipeline- 

### Notifications

- CodePipeline state changes happen in AWS CloudWatch Events which can create SNS notifications
- Notifications may include failed pipelines or cancelled stages.
- You can also audit API calls with AWS CloudTrail.

### Troubleshooting

If CodePipeline cannot perform an action, check that the IAM service role attached to the pipeline has the correct permissions.

### Example pipeline codecommit and beanstalk

![](images/devops_9.png)

1. create web-server environment in beanstalk

![](images/devops_10.png)

2. create pipeline 
 
![](images/devops_11.png)

![](images/devops_12.png)

![](images/devops_13.png)

![](images/devops_14.png)

![](images/devops_15.png)

## Code Build

- AWS CodeBuild is a fully managed continuous integration (CI) service
- With CodeBuild, you don’t need to provision, manage, and scale your own build servers.
- CodeBuild is an alternative to other build tools such as Jenkins.
- AWS CodeBuild runs your builds in preconfigured build environments that contain the operating system, programming language runtime, and build tools (e.g., Apache Maven, Gradle, npm) required to complete the task.
- It is possible to extend capabilities by leveraging your own Docker images.
- Compiles source code, runs tests, and produces software packages that are ready to deploy
- CodeBuild scales continuously and processes multiple builds concurrently
- You pay based on the time it takes to complete the builds
- CodeBuild takes source code from **GitHub**, **CodeCommit**, **CodePipeline** , **S3**
- Build instructions can be defined in the code `buildspec.yml` **in the root of your source code**
- Output logs can be sent to Amazon S3 & Amazon CloudWatch Logs
- There are metrics to monitor CodeBuild statistics.
- You can use CloudWatch alarms to detect failed builds and trigger SNS notifications.
- CodeBuild is integrated with KMS for encryption of build artifacts, IAM for build permissions, VPC for network security, and CloudTrail for logging API calls.
- Builds can be defined within CodePipeline or CodeBuild itself.

### AWS CodeBuild Components

**Build project** defines how CodeBuild will run a build defines settings including:
  - Location of the source code
  - The build environment to use
  - The build commands to run
  - Where to store the output of the build

**Build environment** the operating system, language runtime, and tools that CodeBuild uses for the build

AWS CodeBuild provides build environments for Java, Python, Node.js, Ruby, Go, Android, .NET Core for Linux, and Docker.

**Build Specification** a YAML file that describes the collection off commands and settings for CodeBuild to run a build

### Specifying Build Commands

- The build specification is a YAML file that lets you choose the commands to run at each phase of the build and other settings.
- You can override the default buildspec file name and location


| Option                | Description                                                                                         | Phase Type |
|-----------------------|-----------------------------------------------------------------------------------------------------|------------|
| `phases/*/run`        | Specifies a Linux user that runs its commands                                                        | Optional   |
| `phases/*/on failure` | Specifies the action to take if failure occurs during the phase (ABORT or CONTINUE)                   | Optional   |
| `phases/*/finally`    | Runs commands after commands in the commands block (even if the commands in the commands block fail) | Optional   |
| `phases/install`      | Commands to run during installation                                                                 | Optional   |
| `phases/pre_build`    | Commands to run before the build                                                                     | Optional   |
| `phases/build`        | Commands to run during the build                                                                     | Optional   |
| `phases/post_build`   | Commands to run after the build                                                                      | Optional   |

```yml
version: 0.2

phases:

install:

runtime-versions:

docker: 18

pre_build:

commands:

- echo Logging in to Amazon ECR...

- $(aws ecr get-login --no-include-email --region $AWS_DEFAULT_REGION)

build:

commands:

- echo Build started on `date`

- echo Building the Docker image...

- docker build -t $IMAGE_REPO_NAME:$IMAGE_TAG .

- docker tag $IMAGE_REPO_NAME:$IMAGE_TAG $AWS_ACCOUNT_ID.dkr.ecr.$AWS_DEFAULT_REGION.amazonaws.com/$IMAGE_REPO_NAME:$IMAGE_TAG

post_build:

commands:

- echo Build completed on `date`

- echo Pushing the Docker image...

- docker push $AWS_ACCOUNT_ID.dkr.ecr.$AWS_DEFAULT_REGION.amazonaws.com/$IMAGE_REPO_NAME:$IMAGE_TAG
```

You can define environment variables:
- Plaintext variables.
- Secure secrets using the SSM Parameter store

**Artifacts**: these get uploaded to S3 (encrypted with KMS).

**Cache**: files to cache (usually dependencies) to S3 for future builds.

### CodeBuild Local Build

In case you need to do deep troubleshooting beyond analyzing log files.

Can run CodeBuild locally on your computer using Docker.

Leverages the **CodeBuild agent**.

### Customized Build Environments
You can bring your own build environments to use with AWS CodeBuild, such as for the Microsoft .NET Framework.

You can package the runtime and tools for your build into a Docker image and upload it to a public Docker Hub repository or Amazon EC2 Container Registry (Amazon ECR).

When you create a new build project, you can specify the location of your Docker image, and CodeBuild will pull the image and use it as the build project configuration.

## Example 

![](images/devops_17.png)

put this file to source code as `buildspec.yml`

```json
version: 0.2

phases:
    install:
        commands:
            - echo "Entered the install phase..."
    pre_build:
        commands:
            - echo "Entered the pre_build phase..."
    build:
        commands:
            - echo "Entered the build phase..."
            - echo "Build started on `date`"
            - find production.txt
    post_build:
        commands:
            - echo "Entered the post_build phase..."
            - echo "Build completed on `date`"
```

create build project

![](images/devops_18.png)

![](images/devops_19.png)

![](images/devops_20.png)

![](images/devops_21.png)

add build stage to a pipeline

![](images/devops_22.png)

![](images/devops_23.png)

![](images/devops_24.png)

![](images/devops_25.png)

![](images/devops_26.png)

![](images/devops_27.png)

![](images/devops_28.png)

![](images/devops_29.png)

![](images/devops_30.png)

![](images/devops_31.png)

test stage is failed. Because we have an expression `find production.txt` in our file `buildspec.yml`. Let's add file to the repository.

![](image/devops_32.png)

and then push our approval stage.

![](images/devops_33.png)

![](images/devops_34.png)

## AWS CodeDeploy

- CodeDeploy is a deployment service that automates application deployments
- Deploys to 
  - Amazon EC2 instances
  - on-premises instances
  - Lambda functions
  - Amazon ECS
- Similar open source tools include Ansible, Terraform, Chef, Puppet etc.
- You can deploy a nearly unlimited variety of application content, including:
  - Serverless AWS Lambda functions
  - Web and configuration files
  - Executables
  - Packages
  - Scripts
  - Multimedia files
- CodeDeploy can be connected to CodePipeline and use artifacts from there.
- CodeDeploy can deploy application content that stored in:
  - Amazon S3 buckets
  - GitHub repositories
  - Bitbucket repositories.
- You do not need to make changes to your existing code before you can use CodeDeploy.
- Can be used to automatically deploy applications to many EC2 instances.
- Integrates with various CI/CD tools including Jenkins, GitHub, Atlassian, AWS CodePipeline as well as config management tools like Ansible, Puppet and Chef.

- CodeDeploy application contains information about what to deploy and how to deploy it
- Need to choose the compute platform:
  - EC2/Onpremises
  - AWS Lambda
  - Amazon ECS

### EC2/On Premises:
- Amazon EC2, on premises servers, or both
- CodeDeploy does not provision the resources – it deploys applications not EC2 instances.
- EC2 instances are identified by CodeDeploy by using tags or an Auto Scaling Group name.
- Each Amazon EC2 instance must have the correct IAM instance profile attached.
- The CodeDeploy agent must be installed and running on each instance
- The agent continuously polls for work to do.
- CodeDeploy sends the `appspec.yml` file (which must be at the root of your source code).
- The application code is pulled from GitHub or S3.
- CodeDeploy agent will report of success / failure of deployment on the instance.
- EC2 instances are grouped by deployment group (e.g. dev, test, prod).
- Traffic is directed using an **in place** or **blue/green** deployment type
![](images/devops_35.png)

### AWS Lambda:
- Used to deploy applications that consist of an updated version of a Lambda function
- You can manage the way in which traffic is shifted to the updated Lambda function versions during a deployment by choosing a **canary**, **linear**, or **all-at-once** configuration

![](images/devops_36.png)

### Amazon ECS:

- Used to deploy an Amazon ECS containerized application as a task set
- CodeDeploy performs a **blue/green** deployment by installing an updated version of the application as a new replacement task set
- CodeDeploy reroutes production traffic from the original application task set to the replacement task set
- The original task set is terminated after a successful deployment
- You can manage the way in which traffic is shifted to the updated task set during a deployment by choosing a
**canary** , **linear** , or **all-at-once** configuration

![](images/devops_37.png)

### In-place deployment:

- The application on each instance in the deployment group is stopped, the latest application revision is installed, and the new version of the application is started and validated.
- You can use a load balancer so that each instance is deregistered during its deployment and then restored to service after the deployment is complete.
- Only deployments that use the EC2/On-Premises compute platform can use in-place deployments.

- The application on each instance in the deployment group is stopped, the latest application revision is installed, and the new version of the application is started and validated.
- You can use a load balancer so that each instance is deregistered during its deployment and then restored to service after the deployment is complete.
- Only deployments that use the EC2/On-Premises compute platform can use in-place deployments.

### Blue/Green Traffic Shifting

#### AWS Lambda

- Traffic is shifted from your current serverless environment to one with your updated Lambda function versions.
- You can specify Lambda functions that perform validation tests and choose the way in which the traffic shifting occurs.
- All AWS Lambda compute platform deployments are blue/green deployments.
For this reason, you do not need to specify a deployment type.

### Amazon ECS

- Traffic is shifted from the task set with the original version of an application in an Amazon ECS service to a replacement task set in the same service.
- You can set the traffic shifting to **linear** or **canary** through the deployment configuration.
- The protocol and port of a specified load balancer listener is used to reroute production traffic.
- During a deployment, a test listener can be used to serve traffic to the replacement task set while validation tests are run.

#### EC2/OnPremises**

Traffic is shifted from one set of instances in the original environment to a replacement set of instances

The instances in a deployment group (the original environment) are replaced by a different set of instances (the replacement environment) using these steps:
- Instances are provisioned for the replacement environment.
- The latest application revision is installed on the replacement instances.
- An optional wait time occurs for activities such as application testing and system verification.
- Instances in the replacement environment are registered with an Elastic Load Balancing load balancer, causing traffic to be rerouted to them.
- Instances in the original environment are deregistered and can be terminated or kept running for other uses.

Note: All AWS Lambda and Amazon ECS deployments are blue/green. An EC2/On-Premises deployment can be in place or blue/green

For **Amazon ECS** and **AWS Lambda** there are three ways traffic can be shifted during a deployment:

- **Canary** Traffic is shifted in two increments. You can choose from predefined canary options that specify the percentage of traffic shifted to your updated Amazon ECS task set / Lambda function in the first increment and the interval, in minutes, before the remaining traffic is shifted in the second increment

- **Linear** Traffic is shifted in equal increments with an equal number of minutes between each increment. You can choose from predefined linear options that specify the percentage of traffic shifted in each increment and the number of minutes between each increment

- **All-at-once** All traffic is shifted from the original Amazon ECS task set / Lambda function to the updated Amazon ECS task set / Lambda function all at once

### AppSpec File

The application specification file (AppSpec file) is a YAML-formatted, or JSON-formatted file used by CodeDeploy to manage a deployment.

The AppSpec file defines the deployment actions you want AWS CodeDeploy to execute.

The name of the AppSpec file for an EC2/On-Premises deployment must be `appspec.yml`. The name of the AppSpec file for an Amazon ECS or AWS Lambda deployment must be `appspec.yaml` or `appspec.yml`.

#### EC2/On-Premises AppSpec.yaml

The following code sample shows the format of an appspec.yml file for an Amazon EC2 instance with WordPress:

```yml
version: 0.0

os: linux

files:

- source: /

destination: /var/www/html/WordPress

hooks 

BeforeInstall:

- location: scripts/install_dependencies.sh

timeout: 300

runas: root

AfterInstall:

- location: scripts/change_permissions.sh

timeout: 300

runas: root

ApplicationStart:

- location: scripts/start_server.sh

- location: scripts/create_test_db.sh

timeout: 300

runas: root

ApplicationStop:

- location: scripts/stop_server.sh

timeout: 300

runas: root
```

The files section specifies how to source and copy from S3 / GitHub to the filesystem.

hooks are a set of instructions to be run to deploy the new version (hooks have timeouts).

#### AppSpec.yaml for ECS

The Amazon ECS task definition file must be specified with its ARN in the TaskDefinition instruction in the AppSpec file.

The container and port in your replacement task set where your Application Load Balancer or Network Load Balancer reroutes traffic during a deployment must be specified with the LoadBalancerInfo instruction in the AppSpec file.

Here is an example of an AppSpec file written in YAML for deploying an Amazon ECS service

```yml
version: 0.0

Resources:

- TargetService:

Type: AWS::ECS::Service

Properties:

TaskDefinition: "arn:aws:ecs:us-east-1:111222333444:task-definition/my-task-definition-family-name:1"

LoadBalancerInfo:

ContainerName: "SampleApplicationName"

ContainerPort: 80

# Optional properties

PlatformVersion: "LATEST"

NetworkConfiguration:

AwsvpcConfiguration:

Subnets: ["subnet-1234abcd","subnet-5678abcd"]

SecurityGroups: ["sg-12345678"]

AssignPublicIp: "ENABLED"

Hooks:

- BeforeInstall: "LambdaFunctionToValidateBeforeInstall"

- AfterInstall: "LambdaFunctionToValidateAfterTraffic"

- AfterAllowTestTraffic: "LambdaFunctionToValidateAfterTestTrafficStarts"

- BeforeAllowTraffic: "LambdaFunctionToValidateBeforeAllowingProductionTraffic"

- AfterAllowTraffic: "LambdaFunctionToValidateAfterAllowingProductionTraffic"
```

#### AppSpec.yaml for AWS Lambda

```yml
version: 0.0

Resources:

- myLambdaFunction:

Type: AWS::Lambda::Function

Properties:

Name: "myLambdaFunction"

Alias: "myLambdaFunctionAlias"

CurrentVersion: "1"

TargetVersion: "2"

Hooks:

- BeforeAllowTraffic: "LambdaFunctionToValidateBeforeTrafficShift"

- AfterAllowTraffic: "LambdaFunctionToValidateAfterTrafficShift"
```

### Revision

When updating to a new version a Revision includes everything needed to deploy the new version: 
- AppSpec file
- application files
- executables
- config files.

## Amazon CodeGuru

Provides intelligent recommendations for improving application performance, efficiency, and code quality

### Amazon CodeGuru Reviewer

- Reviews Java and Python code and offers suggestions for improvement
- Suggestions are best on best practices
- Finds complex issues such as resource leak and security analysis
- Integrations with Secrets Manager to use a secrets detector that finds unprotected secrets in code
- Supports the following source providers:
  - AWS CodeCommit
  - Bitbucket
  - GitHub
  - GitHub Enterprise Cloud
  - GitHub Enterprise Server

### Amazon CodeGuru Profiler

- Collects runtime performance data from your live applications
- Provides recommendations that can help you fine tune your application performance
- Provides different visualizations to identify:
  - What code is running on the CPU
  - How much time is consumed
  - Ways to reduce CPU utilization
- Profiling includes:
  - Latency and CPU utilization issues in your application
  - Ways to reduce the infrastructure costs of running an application
  - Identify application performance issues
  - Understand your application's heap utilization over time

## Amazon CodeStar 

![](images/devops_01.png)

- AWS CodeStar enables you to quickly develop, build, and deploy applications on AWS
- It is a preconfigured continuous delivery toolchain for developing, building, testing, and deploying
- Use project templates to develop applications on services such as:
  - Amazon EC2
  - AWS Lambda
  - Elastic Beanstalk
- You can use code editors such as Visual Studio, Eclipse or the AWS CLI
- Uses IAM to manage developer identities
- Built-in role based policies for secure team access
- Share projects with three access levels:
  - Owners
  - Contributors
  - Viewers
- Application code is stored in CodeCommit
- Compiles and packages source code with CodeBuild
- A preconfigured pipeline is used through CodePipeline
- Automated deployments with CodeDeploy and CloudFormation

Exam tip: If an exam scenario requires a unified development toolchain, and mentions collaboration between team members, synchronization, and centralized management of the CI/CD pipeline this will be CodeStar rather than CodePipeline or CodeCommit.

## AWS Cloud9

- AWS Cloud9 is an integrated development environment (IDE)
- Used by developers to write, run, and debug code
- Editor provides syntax highlighting, code completion, and error checking
- Terminal is used to navigate the file system, run commands, and manage code
- Provides collaboration features that allow multiple developers to work on the same codebase simultaneously
- Provides a range of debugging tools to identify and fix errors in code
- Integrates with many AWS services including AWS Lambda, Amazon EC2, and AWS CodePipeline

## AWS CodeArtifact

- AWS CodeArtifact is a fully managed artifact repository service.
- You can use AWS CodeArtifact to securely store, publish, and share software packages.
- CodeArtifact can be configured to automatically fetch software packages and dependencies from public artifact repositories.
- CodeArtifact works with commonly used package managers and build tools like:
  -  Maven
  -  Gradle
  -  npm 
  -  yarn
  -  twine
  -  pip 
  -  NuGet
  
## AWS Amplify and AppSync

- Tools and features for building full-stack applications on AWS
- Build web and mobile backends, and web frontend UIs
- **AWS Amplify Studio** is a visual interface for building web and mobile apps:
  - Use the visual interface to define a data model, user authentication, and file storage without backend expertise
  - Easily add AWS services not available within Amplify Studio using the AWS Cloud Development Kit (CDK)
  - Connect mobile and web apps using Amplify Libraries for iOS, Android, Flutter, React Native, and web (JavaScript)
- **AWS Amplify Hosting** is a fully managed CI/CD and hosting service for fast, secure, and reliable static and server side rendered apps
- **AWS AppSync** is a fully managed service that makes it easy to develop GraphQL APIs
- Applications can securely access, manipulate, and receive real time updates from multiple data sources such as databases or APIs
- AWS AppSync automatically scales a GraphQL API execution engine up and down to meet API request volumes
- Uses GraphQL , a data language that enables client apps to fetch, change and subscribe to data from servers
- AWS AppSync lets you specify which portions of your data should be available in a real time manner using GraphQL Subscriptions
- AWS AppSync supports AWS Lambda, Amazon DynamoDB, and Amazon Elasticsearch
- Server side data caching capabilities reduce the need to directly access data sources
- AppSync is fully managed and eliminates the operational overhead of managing cache clusters

![](images/devops_02.png)

### AWS AppSync’s API Cache 

provides three options: 
- None
- Full request caching
- Per-resolver caching

Cache encryption comes in the following two flavors. These are similar to the settings that ElastiCache for Redis allows. You can enable the encryption settings only when first enabling caching for your AWS AppSync API.

Encryption in transit – Requests between AWS AppSync, the cache, and data sources (except insecure HTTP data sources) are encrypted at the network level. Because there is some processing needed to encrypt and decrypt the data at the endpoints, in-transit encryption can impact performance.

Encryption at rest – Data saved to disk from memory during swap operations are encrypted at the cache instance. This setting also impacts performance.

To invalidate cache entries, you can make a flush cache API call using either the AWS AppSync console or the AWS Command Line Interface (AWS CLI).

# Amazon Relational Database Service (RDS)

![](images/rds_1.png)


RDS supports the following database engines:
- Amazon Aurora
- MySQL
- MariaDB
- Oracle
- Microsoft SQL Server
- PostgreSQL

![](images/rds_2.png)

![](images/rds_3.png)

- RDS uses EC2 instances, so you must choose an instance family/type
- RDS is an Online Transaction Processing (OLTP) type of database
- Easy to setup, highly available, fault tolerant, and scalable
- Common use cases include online stores and banking systems
- You can encrypt your Amazon RDS instances and snapshots at rest by enabling the encryption option for your Amazon RDS DB instance (during creation)
- Encryption uses AWS Key Management Service (KMS)
- Scales up by increasing instance size (compute and storage)
- Read replicas option for read heavy workloads (scales out for reads/queries only)
- Disaster recovery with Multi AZ option

## Amazon RDS Backup and Recovery

### Automated Backups

![](images/rds_4.png)

### Amazon RDS Manual Backups (Snapshot)

- Backs up the entire DB instance, not just individual databases
- For single AZ DB instances there is a brief suspension of I/O
- For Multi AZ SQL Server, I/O activity is briefly suspended on primary
- For Multi AZ MariaDB, MySQL, Oracle and PostgreSQL the snapshot is taken from the standby
- Snapshots do not expire (no retention period)

### Amazon RDS Maintenance Windows

- Operating system and DB patching can require taking the database offline
- These tasks take place during a maintenance window
- By default a weekly maintenance window is configured
- You can choose your own maintenance window

![](images/rds_5.png)

## Examples

### create mysql database

![](images/rds_6.png)

![](images/rds_7.png)

![](images/rds_8.png)

![](images/rds_9.png)

![](images/rds_01.png)

![](images/rds_02.png)

![](images/rds_03.png)

![](images/rds_04.png)

### create manual snapshot

![](images/rds_05.png)

![](images/rds_06.png)

![](images/rds_07.png)

### create multi-AZ replicas

create a read-only replica

![](images/rds_08.png)

![](images/rds_09.png)

create a stand-by replica

![](images/rds_001.png)

![](images/rds_002.png)

![](images/rds_003.png)

![](images/rds_004.png)

reboot the primary with failover to switch master to stand-by

![](images/rds_005.png)

![](images/rds_006.png)

## Amazon Aurora

- Amazon Aurora is an AWS database offering in the RDS family
- Amazon Aurora is a MySQL and PostgreSQL compatible relational database built for the cloud
- Amazon Aurora is up to five times faster than standard MySQL databases and three times faster than standard PostgreSQL databases
- Amazon Aurora features a distributed, fault tolerant, self healing storage system that auto scales up to 128TB per database instance

![](images/rds_007.png)

**High performance and scalability**. Offers high performance, self healing storage that scales up to 128TB, point in time
recovery and continuous backup to S3

**DB compatibility**. Compatible with existing MySQL and PostgreSQL open source databases 

**Aurora Replicas** In-region read scaling and failover target up to 15 (can use Auto Scaling)

**MySQL Read Replicas** Cross-region cluster with read scaling and failover target up to 5 (each can have up to 15 Aurora Replicas)

**Global Database** Cross-region cluster with read scaling (fast replication / low latency reads). Can remove secondary and promote

**Multi-Master** Scales out writes within a region. In preview currently and will not appear on the exam

**Serverless** On-demand, autoscaling configuration for Amazon Aurora does not support read replicas or public IPs (can only access through VPC or Direct Connect not VPN)

| Feature                                         | Aurora Replica                | MySQL Replica              |
|-------------------------------------------------|-------------------------------|-----------------------------|
| Number of replicas                              | Up to 15                      | Up to 5                    |
| Replication type                                | Asynchronous (milliseconds)   | Asynchronous (seconds)      |
| Performance impact on primary                   | Low                           | High                       |
| Replica location                                | In region                     | Cross region               |
| Act as failover target                          | Yes (no data loss)            | Yes (potentially minutes of data loss) |
| Automated failover                              | Yes                           | No                         |
| Support for user-defined replication delay      | No                            | Yes                        |
| Support for different data or schema vs. primary| No                            | Yes                        |

## Amazon RDS Security

![](images/rds_008.png)

- Encryption at rest can be enabled includes DB storage, backups, read replicas and snapshots
- You can only enable encryption for an Amazon RDS DB instance when you create it, not after the DB instance is created
- DB instances that are encrypted can't be modified to disable encryption
- Uses AES 256 encryption and encryption is transparent with minimal performance impact
- RDS for Oracle and SQL Server is also supported using Transparent Data Encryption (TDE) (may have performance impact)
- AWS KMS is used for managing encryption keys
- You **can not** have:
  - An encrypted read replica of an unencrypted DB instance
  - An unencrypted read replica of an encrypted DB instance
- Read replicas of encrypted primary instances are encrypted
- The same KMS key is used if in the same Region as the primary 
- If the read replica is in a different Region, a different KMS key is used
- You can't restore an unencrypted backup or snapshot to an encrypted DB instance

![](images/rds_009.png)

# Amazon ElastiCache

- Fully managed implementations **Redis** and **Memcached**
- ElastiCache is a key/value store
- In-memory database offering high performance and low latency
- Can be put in front of databases such as RDS and DynamoDB
- ElastiCache nodes run on Amazon EC2 instances, so you must choose an instance family/type

![](images/cache_1.png)

| Feature                                        | Memcached                                        | Redis (cluster mode disabled)                        | Redis (cluster mode enabled)                        |
|------------------------------------------------|--------------------------------------------------|------------------------------------------------------|-----------------------------------------------------|
| Data persistence                               | No                                               | Yes                                                  | Yes                                                 |
| Data types                                     | Simple                                           | Complex                                              | Complex                                             |
| Data partitioning                              | Yes                                              | No                                                   | Yes                                                 |
| Encryption                                     | No                                               | Yes                                                  | Yes                                                 |
| High availability (replication)                | No                                               | Yes                                                  | Yes                                                 |
| Multi-AZ                                       | Yes, place nodes in multiple AZs. No failover or replication | Yes, with auto-failover. Uses read replicas (0-5 per shard) | Yes, with auto-failover. Uses read replicas (0-5 per shard) |
| Scaling                                        | Up (node type); out (add nodes)                  | Up (node type); out (add replica)                    | Up (node type); out (add shards)                    |
| Multithreaded                                  | Yes                                              | No                                                   | No                                                  |
| Backup and restore                             | No (and no snapshots)                            | Yes, automatic and manual snapshots                  | Yes, automatic and manual snapshots                 |

## Amazon ElastiCache Use Cases

- Data that is relatively **static** and **frequently accessed**
- Applications that are tolerant of stale data
- Data is slow and expensive to get compared to cache retrieval
- Require push button scalability for memory, writes and reads
- Often used for storing session state

| Use Case                 | Benefit                                                                                                                                                     |
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Web session store        | In cases with load balanced web servers, store web session information in Redis so if a server is lost, the session info is not lost, and another web server can pick it up        |
| Database caching         | Use Memcached in front of AWS RDS to cache popular queries to offload work from RDS and return results faster to users                                        |
| Leaderboards             | Use Redis to provide a live leaderboard for millions of users of your mobile app                                                                             |
| Streaming data dashboards| Provide a landing spot for streaming sensor data on the factory floor, providing live real-time dashboard displays                                            |

## Amazon ElastiCache Scalability

### Memcached

- Add nodes to a cluster
- Scale vertically (node type) must create a new cluster manually

![](images/cache_2.png)

### Redis

- Cluster mode disabled :
  - Add replica or change node type creates a new cluster and migrates data

![](images/cache_4.png)

Cluster mode enabled :
- Online resharding to add or remove shards; vertical scaling to change node type
- Offline resharding to add or remove shards change node type or upgrade engine (more flexible than online)

![](images/cache_3.png)

## Examples

![](images/cache_5.png)

![](images/cache_6.png)

![](images/cache_7.png)

![](images/cache_8.png)

![](images/cache_9.png)

![](images/cache_01.png)

## Caching strategies

There are two caching strategies available: Lazy Loading and Write-Through:

### Lazy Loading
- Loads the data into the cache only when necessary (if a cache miss occurs).
- Lazy loading avoids filling up the cache with data that won’t be requested.
- If requested data is in the cache, ElastiCache returns the data to the application.
- If the data is not in the cache or has expired, ElastiCache returns a null.
- The application then fetches the data from the database and writes the data received into the cache so that it is available for next time.
- Data in the cache can become stale if Lazy Loading is implemented without other strategies (such as TTL)

### Write Through
- When using a write-through strategy, the cache is updated whenever a new write or update is made to the underlying database.
- Allows cache data to remain up to date.
- This can add wait time to write operations in your application.
- Without a TTL you can end up with a lot of cached data that is never read.

## Amazon MemoryDB for Redis

- Redis compatible, durable, in memory database service that delivers ultra-fast performance
- Entire dataset is stored in memory - entire DB solution
- Purpose built for modern applications with microservices architectures
- Build applications using the same flexible and friendly Redis data structures, APIs, and commands
- Microsecond read and single digit millisecond write latency and high-throughput
- Data stored durably across multiple AZs using a distributed transactional log
- Supports write scaling with sharding and read scaling by adding replicas

Service-linked roles are tied to the resource with predefined permissions. The default policy associated Amazon MemoryDB for Redis is `AmazonMemoryDBFullAccess`. This comes pre-provisioned with permission that the service requires to create a service link that is used to create resources and access other AWS resources and services.

You might decide not to use the default policy and instead to use a custom-managed policy. In this case, make sure that you have either permissions to call `iam:createServiceLinkedRole` or that you have created the MemoryDB service-linked role.

## MemoryDB for Redis vs ElastiCache

- Use ElastiCache for caching DB queries
- Use MemoryDB for a full DB solution combining DB and cache 
- MemoryDB offers higher performance with lower latency
- MemoryDB offers strong consistency for primary nodes and eventual consistency for replica nodes
- With ElastiCache there can be some inconsistency and latency depending on the engine and caching strategy

# Amazon Kinesis Core

![](images/kinesis_1.png)

- Producers send data to Kinesis, data is stored in Shards for 24 hours (by default, up to 7 days)
- Consumers then take the data and process it data can then be saved into another AWS service
- Real time (~200ms)

![](images/kinesis_2.png)

## Kinesis Client Library (KCL)

The Kinesis Client Library (KCL) helps you consume and process data from a Kinesis data stream

![](images/kinesis_3.png)

- Each shard is processed by exactly one KCL worker and has exactly one corresponding record processor
- One worker can process any number of shards, so it's fine if the number of shards exceeds the number of instances

![](images/kinesis_4.png)

- The KCL is different from the Kinesis Data Streams API that is available in the AWS SDKs
- The Kinesis Data Streams API helps you manage many aspects of Kinesis Data Streams (including creating streams, resharding , and putting and getting records)
- The KCL provides a layer of abstraction specifically for processing data in a consumer role


## Amazon Kinesis Data Streams

![](images/kinesis_5.png)

## Kinesis Data Firehose

- Producers send data to Firehose
- There are no Shards, completely automated (scalability is elastic)
- Firehose data is sent to another AWS service for storing, data can be optionally processed/transformed using AWS Lambda
- Near real time delivery (~60 seconds latency)

![](images/kinesis_6.png)

Kinesis Data Firehose destinations:
- RedShift (via an intermediate S3 bucket)
- Elasticsearch
- Amazon S3
- Splunk
- Datadog
- MongoDB
- New Relic
- HTTP Endpoint

## Kinesis Data Analytics

- Provides real time SQL processing for streaming data
- Provides analytics for data coming in from Kinesis Data Streams and Kinesis Data Firehose
- Destinations can be Kinesis Data Streams, Kinesis Data Firehose, or AWS Lambda

![](images/kinesis_7.png)

# Amazon OpenSearch Service (ElasticSearch)

![](images/search_1.png)

- Distributed search and analytics suite
- Based on the popular open source Elasticsearch
- Supports queries using SQL syntax
- Integrates with open source tools
- Scale by adding or removing instances
- Availability in up to three Availability Zones
- Backup using snapshots
- Encryption at rest and in transit

## OpenSearch Service Deployment

- Clusters are created (Management Console, API, or CLI)
- Clusters are also known as OpenSearch Service domains
- You specify the number of instances and instance types
- Storage options include UltraWarm or Cold storage

![](images/search_2.png)

## OpenSearch in an Amazon VPC

- Clusters can be deployed in a VPC for secure intra-VPC communications
- VPN or proxy required to connect from the internet (public domains are directly accessible)
- Cannot use IP-based access policies

Limitations of VPC deployments:
- You can’t switch from VPC to a public endpoint. The reverse is also true
- You can’t launch your domain within a VPC that uses dedicated tenancy
- After you place a domain within a VPC, you can’t move it to a different VPC, but you can change the subnets and security group settings

## The ELK Stack

- ELK stands for Elasticsearch, Logstash, and Kibana
- This is a popular combination of projects
- Aggregate logs from systems and applications, analyze these logs, and create visualizations
- Use cases include:
  - Visualizing application and infrastructure monitoring data
  - Troubleshooting
  - Security analytics

## OpenSearch Access Control

Resource-based policies-  often called a domain access policy

Identity-based policies attached to users or roles (principals)

IP-based policies Restrict access to one or more IP addresses or CIDR blocks

Fine-grained access control Provides:
- Role-based access control
- Security at the index, document, and field level
- OpenSearch Dashboards multi-tenancy
- HTTP basic authentication for OpenSearch and penSearch Dashboards


Authentication options include:
- Federation using SAML to on-premises directories
- Amazon Cognito and social identity providers

## OpenSearch Best Practices

- Deploy OpenSearch data instances across three Availability Zones (AZs) for the best availability
- Provision instances in multiples of three for equal distribution across AZs
- If three AZs are not available use two AZs with equal numbers of instances
- Use three dedicated master nodes
- Configure at least one replica for each index
- Apply restrictive resource-based access policies to the domain (or use fine-grained access control)
- Create the domain within an Amazon VPC
- For sensitive data enable node-to-node encryption and encryption at rest

# Amazon Athena and AWS Glue

![](images/athena_1.png)

![](images/athena_2.png)

- Athena queries data in S3 using SQL
- Can be connected to other data sources with Lambda
- Data can be in CSV, TSV, JSON, Parquet and ORC formats
- Uses a managed Data Catalog (AWS Glue) to store information and schemas about the databases and tables

## Optimizing Athena for Performance

- Partition your data
- Bucket your data - bucket the data within a single partition
- Use Compression. AWS recommend using either Apache Parquet or Apache ORC
- Optimize file sizes
- Optimize columnar data store generation. Apache Parquet and Apache ORC are popular columnar data stores
- Optimize ORDER BY and Optimize GROUP BY
- Use approximate functions
- Only include the columns that you need

## AWS Glue

- Fully managed extract, transform and load (ETL) service
- Used for preparing data for analytics
- AWS Glue runs the ETL jobs on a fully managed, scale out Apache Spark environment
- AWS Glue discovers data and stores the associated metadata (e.g. table definition and schema) in the AWS Glue Data Catalog
- Works with data lakes (e.g. data on S3), data-warehouses (including RedShift), and data stores (including RDS or EC2 databases)
- You can use a **crawler** to populate the AWS Glue Data Catalog with tables
- A crawler can crawl multiple data stores in a single run
- Upon completion, the crawler creates or updates one or more tables in your Data Catalog.
- ETL jobs that you define in AWS Glue use the Data Catalog tables as sources and targets

# AWS CDK

- Build apps in the cloud with standard programming languages
- Supports TypeScript, JavaScript, Python, Java, C#/ C#/.Net , and Go
- Use these languages to create reusable **Constructs**
- Compose them into **Stacks** and **Apps**
- Command line toolkit
- ‘Synthesizes’ AWS CloudFormation templates

![](images/cdk_1.png)

# AWS AppConfig

- Create, manage, and deploy application configurations
- Capability of AWS Systems Manager
- A configuration is a collection of settings that influence the behavior of your application
- Applications can be hosted on:
  - Amazon EC2 instances
  - AWS Lambda
  - Mobile applications
  - IoT devices
- Reduces errors associated with configuration changes and streamlines deployment
- Configurations can be stored in:
  - Amazon S3
  - AWS AppConfig
  - Systems Manager Parameter Store
  - Systems Manager Document Store
  - Bitbucket, GitHub, CodeCommit (via CodePipeline)
- Applications must be updated to check for and retrieve configuration data
- API actions include:
  - `StartConfigurationSession`
  - `GetLatestConfiguration`

Validators are used to ensure that configuration data is syntactically and semantically correct

Validators are either:
  - JSON Schema Validators
  - AWS Lambda Validators

Deployment type is either:
  - Linear. uses a growth factor which is a step %
  - Exponential. uses the exponential formula G*(2^N)

Deployment strategies:
- `AppConfig.AllAtOnce` all targets at once
- `AppConfig.Linear50PercentEvery30Seconds` 50% of targets every 30 seconds

AWS AppConfig will automatically encrypt data at rest using AWS owned keys and AWS Key Management Service (KMS). This layer cannot be disabled or altered by the customer. The customer can add a second layer of encryption protection that they can control and manage using customer managed keys.

# Amazon CloudWatch

CloudWatch is used for performance monitoring, alarms, log collection and automated actions

## Use cases / benefits include:

- Collect performance metrics from AWS and on premises systems
- Automate responses to operational changes
- Improve operational performance and resource optimization
- Derive actionable insights from logs
- Get operational visibility and insight

## Features

- **CloudWatch Metrics** services send time ordered data points to CloudWatch
- **CloudWatch Alarms** monitor metrics and initiate actions
- **CloudWatch Logs** centralized collection of system and application logs
- **CloudWatch Events** stream of system events describing changes to AWS resources and can trigger actions

## Amazon CloudWatch Metrics

- Metrics are sent to CloudWatch for many AWS services
- EC2 metrics are sent every 5 minutes by default (free)
- Detailed EC2 monitoring sends every 1 minute (chargable)
- Unified CloudWatch Agent sends system level metrics for EC2 and on premises servers
- System-level metrics include memory and disk usage

![](images/cloudwatch_1.png)

- Can publish custom metrics using CLI or API
- Custom metrics are one of the following resolutions:
  - **Standard resolution** - data having a one minute granularity
  - **High resolution** data at a granularity of one second
- AWS metrics are standard resolution by default

## Amazon CloudWatch Alarms

Two types of alarms
- **Metric alarm**. Performs one or more actions based on a single metric
- **Composite alarm**. Uses a rule expression and takes into account multiple alarms

Metric alarm states:
- `OK`. Metric is within a threshold
- `ALARM`. Metric is outside a threshold
- `INSUFFICIENT_DATA`. not enough data

![](images/cloudwatch_2.png)

## Amazon CloudWatch Logs

![](images/cloudwatch_3.png)

## The Unified CloudWatch Agent

The unified CloudWatch agent enables you to do the following:
- Collect internal system level metrics from Amazon EC2 instances across operating systems
- Collect system level metrics from on premises servers
- Retrieve custom metrics from your applications or services using the StatsD and collectd protocols
- Collect logs from Amazon EC2 instances and on-premises servers (Windows / Linux)

Agent must be installed on the server

Can be installed on:
- Amazon EC2 instances
- On-premises servers
- Linux, Windows Server, or macOS

## VPC Flow logs

VPC Flow Logs is a feature that enables you to capture information about the IP traffic going to and from network interfaces in your VPC. Flow log data can be published to the following locations: Amazon CloudWatch Logs, Amazon S3, or Amazon Kinesis Data Firehose. After you create a flow log, you can retrieve and view the flow log records in the log group, bucket, or delivery stream that you configured.

Flow logs can help you with a number of tasks, such as:

- Diagnosing overly restrictive security group rules
- Monitoring the traffic that is reaching your instance
- Determining the direction of the traffic to and from the network interfaces

# AWS CloudTrail

- CloudTrail logs API activity for auditing
- By default, management events are logged and retained for 90 days
- A CloudTrail Trail logs any events to S3 for indefinite retention
- Trail can be within Region or all Regions
- CloudWatch Events can triggered based on API calls in CloudTrail
- Events can be streamed to CloudWatch Logs

![](images/cloudtrail_1.png)

## CloudTrail Types of Events

- **Management events** provide information about management operations that are performed on resources in your AWS account
- **Data events** provide information about the resource operations performed on or in a resource
- **Insights events** identify and respond to unusual activity associated with write API calls by continuously analyzing CloudTrail management events

# AWS Key Management Service (KMS)

- AWS Key Management Store (KMS) is a managed service that enables you to easily encrypt your data.
- AWS KMS provides a highly available key storage, management, and auditing solution for you to encrypt data within your own applications and control the encryption of stored data across AWS services.
- Create and managed symmetric and asymmetric encryption keys
- AWS KMS allows you to centrally manage and securely store your keys. These are known as AWS KMS keys formerly known as customer master keys (CMKs).
- KMS is validated by many compliance schemes (e.g. PCI DSS Level 1, FIPS 140-2 Level 2).

Exam tip: Encryption keys are regional.

![](images/kms_1.png)


## AWS KMS Keys (customer master keys (CMKs))

- The KMS keys are protected by hardware security modules (HSMs)
- KMS keys are the primary resources in AWS KMS
- AWS KMS supports symmetric and asymmetric KMS keys.
- Used to be known as “customer master keys” or CMKs
- The KMS key also contains the key material used to encrypt and decrypt data
- By default, AWS KMS creates the key material for a KMS key
- You can also import your own key material
- A KMS key can encrypt data up to 4KB in size
- A KMS key can generate, encrypt and decrypt Data Encryption Keys (DEKs)
- KMS keys are created in AWS KMS. Symmetric KMS keys and the private keys of asymmetric KMS keys never leave AWS KMS unencrypted.
- By default, AWS KMS creates the key material for a KMS key.
- A KMS key can never be exported from KMS (CloudHSM allows this).

A KMS key consists of:
- Alias.
- Creation date.
- 
- Description.
- Key state.
- Key material (either customer provided or AWS provided).

The KMS key includes metadata
- key ID
- creation date
- description
- key state.


### AWS Managed KMS keys

- AWS managed KMS keys are KMS keys in your account that are created, managed, and used on your behalf by an AWS service that is integrated with AWS KMS.
- KMS keys managed by AWS are used by AWS services that interact with KMS to encrypt data.
- They can only be used by the service that created them within a particular region.
- They are created on the first time you implement encryption using that service.
- You cannot manage these KMS keys, rotate them, or change their key policies.
- You also cannot use AWS managed KMS keys in cryptographic operations directly; the service that creates them uses them on your behalf.
- You do not pay a monthly fee for AWS managed KMS keys. They can be subject to fees for use in excess of the free tier, but some AWS services cover these costs for you.

If Amazon EC2 instance is saving files on a proprietary network-attached file system and this will not have support for AWS managed CMKs.


### Customer managed KMS keys:

- Customer managed KMS keys are KMS keys in your AWS account that you create, own, and manage.
- You have full control over these KMS keys, including establishing and maintaining their key policies, IAM policies, and grants, enabling and disabling them, rotating their cryptographic material, adding tags, creating aliases that refer to the KMS key, and scheduling the KMS keys for deletion.
- You can perform rotation, governing access, and key policy configuration.
- You are able to enable and disable the key when it is no longer required.
- Customer managed KMS keys incur a monthly fee and a fee for use in excess of the free tier.

### AWS Owned KMS Keys

- AWS owned KMS keys are a collection of KMS keys that an AWS service owns and manages for use in multiple AWS accounts.
- Although AWS owned KMS keys are not in your AWS account, an AWS service can use its AWS owned KMS keys to protect the resources in your account.
- You do not need to create or manage the AWS owned KMS keys.
- However, you cannot view, use, track, or audit them.
- You are not charged a monthly fee or usage fee for AWS owned KMS keys and they do not count against the AWS KMS quotas for your account.

### Data Encryption Keys

- Data keys are encryption keys that you can use to encrypt large amounts of data
- You can use AWS KMS keys to generate, encrypt, and decrypt data keys
- AWS KMS does not store, manage, or track your data keys, or perform cryptographic operations with data keys
- You must use and manage data keys outside of AWS KMS

Data keys are encryption keys that you can use to encrypt data, including large amounts of data and other data encryption keys. You can use AWS KMS CMKs to generate, encrypt, and decrypt data keys. However, AWS KMS does not store, manage, or track your data keys, or perform cryptographic operations with data keys. You must use and manage data keys outside of AWS KMS – this is potentially less secure as you need to manage the security of these keys.

If the user requesting data from the AWS service is authorized to decrypt under your master key policy, the service will receive the decrypted data key from KMS with which it can decrypt your data and return it in plaintext.

## Alternative Key Stores

**External Key Store**

- Keys can be stored outside of AWS to meet regulatory requirements
- You can create a KMS key in an AWS KMS external key store (XKS)
- All keys are generated and stored in an external key manager
- When using an XKS, key material never leaves your HSM Custom Key Store

**Custom Key Store**

- You can create KMS keys in an AWS CloudHSM custom key store
- All keys are generated and stored in an AWS CloudHSM cluster that you own and manage
- Cryptographic operations are performed solely in the AWS CloudHSM cluster you own and manage
- Custom key stores are not available for asymmetric KMS keys



## KMS Keys and Automatic Rotation

| Type of KMS Key          | Can view | Can manage | Used only for my AWS account | Automatic rotation          |
|--------------------------|----------|------------|------------------------------|-----------------------------|
| Customer managed key     | Yes      | Yes        | Yes                          | Optional. Every 365 days    |
| AWS managed key          | Yes      | No         | Yes                          | Required. Every 365 days    |
| AWS owned key            | No       | No         | No                           | Varies                      |

- You cannot enable or disable key rotation for AWS owned keys
- Automatic key rotation is supported only on symmetric encryption KMS keys
- with key material that AWS KMS generates `Origin = AWS_KMS`
- Automatic rotation generates new key material every year optional for customer managed keys
- Rotation only changes the key material used for encryption, the KMS key remains the same

![](images/kms_2.png)

With automatic key rotation:

- The properties of the KMS key, including its key ID, key ARN, region, policies, and permissions, do not change when the key is rotated
- You do not need to change applications or aliases that refer to the key ID or key ARN of the KMS key
- After you enable key rotation, AWS KMS rotates the KMS key automatically every year

Automatic key rotation is not supported on the following types of KMS keys (Note: You can rotate these KMS keys manually):
- Asymmetric KMS keys
- HMAC KMS keys
- KMS keys in custom key stores
- KMS keys with imported key material

## Manual Rotation

- Manual rotation is creating a new KMS key with a different key ID
- You must then update your applications with the new key ID
- You can use an alias to represent a KMS key so you don’t need to modify your application code

![](images/kms_3.png)

## Key Deletion

You can schedule a customer master key and associated metadata that you created in AWS KMS for deletion, with a configurable waiting period from 7 to 30 days.

This waiting period allows you to verify the impact of deleting a key on your applications and users that depend on it.

The default waiting period is 30 days.

You can cancel key deletion during the waiting period.

## Key Management with KMS

You can perform the following key management functions in AWS KMS:

- Create keys with a unique alias and description.
- Import your own key material.
- Define which IAM users and roles can manage keys.
- Define which IAM users and roles can use keys to encrypt and decrypt data.
- Choose to have AWS KMS automatically rotate your keys on an annual basis.
- Temporarily disable keys so they cannot be used by anyone.
- Re-enable disabled keys.
- Delete keys that you no longer use.
- Audit use of keys by inspecting logs in AWS CloudTrail.
- Create custom key stores*.
- Connect and disconnect custom key stores*.
- Delete custom key stores*.

 The use of custom key stores requires CloudHSM resources to be available in your account.

 ## Data Encryption Scenarios

 Typically, data is encrypted in one of the following three scenarios:

- You can use KMS APIs directly to encrypt and decrypt data using your master keys stored in KMS.
- You can choose to have AWS services encrypt your data using your master keys stored in KMS. In this case data is encrypted using data keys that are protected by your master keys in KMS.
- You can use the AWS Encryption SDK that is integrated with AWS KMS to perform encryption within your own applications, whether they operate in AWS or not.

## Additional Exam Tips

- To share snapshots with another account you must specify `Decrypt` and `CreateGrant` permissions
- The `kms:ViaService` condition key can be used to limit key usage to specific AWS services
- Cryptographic erasure means removing the ability to decrypt data and can be achieved when using imported key material and deleting that key material
- You must use the `DeletelmportedKeyMaterial` API to remove the key material
- An `InvalidKeyId` exception when using SSM Parameter Store indicates the KMS key is not enabled
- Make sure you know the differences between AWS managed and customer managed KMS keys and automatic vs manual rotation



## AWS KMS API and CLI

**Encrypt** (`aws kms encrypt`)

- Encrypts plaintext into ciphertext by using a KMS key
- You can encrypt small amounts of arbitrary data, such as a personal identifier or database password, or other sensitive information
- You can use the Encrypt operation to move encrypted data from one AWS region to another

**Decrypt** (`aws kms decrypt`)

- Decrypts ciphertext that was encrypted by an KMS key using any of the following operations:
  - `Encrypt`
  - `GenerateDataKey`
  - `GenerateDataKeyPair`
  - `GenerateDataKeyWithoutPlaintext`
  - `GenerateDataKeyPairWithoutPlaintext`

**Re-encrypt** (`aws kms re-encrypt`)

- Decrypts ciphertext and then re-encrypts it entirely within AWS KMS
- You can use this operation to change the KMS key under which data is encrypted, such as when you manually rotate a KMS key or change the KMS key that protects a ciphertext
- You can also use it to re-encrypt ciphertext under the same KMS key, such as to change the encryption context of a ciphertext

Enable-key-rotation:
- Enables automatic rotation of the key material for the specified symmetric KMS key
- You cannot perform this operation on a KMS key in a different AWS account

**GenerateDataKey** (`aws kms generate-data-key`) 

- Generates a unique symmetric data key
- This operation returns a plaintext copy of the data key and a copy that is encrypted under a KMS key that you specify
- You can use the plaintext key to encrypt your data outside of AWS KMS and store the encrypted data key with the encrypted data

**GenerateDataKeyWithoutPlaintext** (`generate-data-key-without-plaintext`)

- Generates a unique symmetric data key
- This operation returns a data key that is encrypted under a KMS key that you specify
- To request an asymmetric data key pair, use the `GenerateDataKeyPair` or `GenerateDataKeyPairWithoutPlaintext` operations

## Throttling and Caching

AWS KMS has two types of quotas:
- Resource quotas
- Request quotas

If you exceed a resource limit, requests to create an additional resource of that type generate an LimitExceededException error message

Request quotas apply to API actions such as `Encrypt` , `Decrypt` , `ReEncrypt` , and `GenerateDataKey`

To prevent throttling, you can:
- Implement a backoff and retry strategy
- Request a service quota increase
- Implement data key caching

Data key caching stores data keys and related cryptographic material in a cache

Useful if your application:
- Can reuse data keys
- Generates numerous data keys
- Runs cryptographic operations that are unacceptably slow, expensive, limited, or resource intensive

You can create a local cache using the AWS Encryption SDK and the `LocalCryptoMaterialsCache` feature

# AWS Certificate Manager (ACM)

- Create, store and renew SSL/TLS X.509 certificates
- Single domains, multiple domain names and wildcards
- Integrates with several AWS services including:
  - Elastic Load Balancing
  - Amazon CloudFront
  - AWS Elastic Beanstalk
  - AWS Nitro Enclaves
  - AWS CloudFormation

- Public certificates are signed by the AWS public Certificate Authority
- You can also create a Private CA with ACM
- Can then issue private certificates
- You can also import certificates from third-party issuers

# AWS Systems Manager

Manages many AWS resources including Amazon EC2, Amazon S3, Amazon RDS etc.

Systems Manager Components:
- Automation
- Run Command
- Inventory
- Patch Manager
- Session Manager
- Parameter Store

![](images/manager_1.png)

![](images/manager_2.png)

![](images/manager_3.png)

## AWS Systems Manager Patch Manager

- Helps you select and deploy operating system and software patches automatically across large groups of Amazon EC2 or on premises instances
- Patch baselines:
  - Set rules to auto approve select categories of patches to be installed
  - Specify a list of patches that override these rules and are automatically approved or rejected
- You can also schedule maintenance windows for your patches so that they are only applied during predefined times
- Systems Manager helps ensure that your software is up to date and meets your compliance policies

## AWS Systems Manager Compliance

- AWS Systems Manager lets you scan your managed instances for patch compliance and configuration inconsistencies
- You can collect and aggregate data from multiple AWS accounts and Regions, and then drill down into specific resources that aren’t compliant
- By default, AWS Systems Manager displays data about patching and associations
- You can also customize the service and create your own compliance types based on your requirements (must use the AWS CLI, AWS Tools for Windows PowerShell, or the SDKs)

## AWS Systems Manager Session Manager

- Secure remote management of your instances at scale without logging into your servers
- Replaces the need for bastion hosts, SSH, or remote PowerShell
- Integrates with IAM for granular permissions
- All actions taken with Systems Manager are recorded by AWS CloudTrail
- Can store session logs in an S3 and output to CloudWatch Logs
- Requires IAM permissions for EC2 instance to access SSM, S3, and CloudWatch Logs

## AWS Systems Manager Parameter Store

- Parameter Store provides secure, hierarchical storage for configuration data management and secrets management
- Highly scalable, available, and durable
- Store data such as passwords, database strings, and license codes as parameter values
- Store values as plaintext (unencrypted data) or ciphertext (encrypted data)
- Reference values by using the unique name that you specified when you created the parameter
- No native rotation of keys (difference with AWS Secrets Manager which does it automatically)

![](images/manager_4.png)

# AWS Secrets Manager

- Stores and rotate secrets safely without the need for code deployments
- Users and applications retrieve secrets with a call to Secrets Manager APIs, eliminating the need to hardcode sensitive information in plain text.
- Secrets Manager offers automatic rotation of credentials (built in) for:
  - Amazon RDS (MySQL, PostgreSQL, and Amazon Aurora)
  - Amazon Redshift
  - Amazon DocumentDB
- For other services you can write your own AWS Lambda function for automatic rotation
- Also, the service is extensible to other types of secrets, including API keys and OAuth tokens. In addition, Secrets Manager enables you to control access to secrets using fine-grained permissions and audit secret rotation centrally for resources in the AWS Cloud, third-party services, and on-premises.
- AWS Secrets Manager encrypts secrets at rest using encryption keys that you own and store in AWS Key Management Service (KMS).
- When you retrieve a secret, Secrets Manager decrypts the secret and transmits it securely over TLS to your local environmen
- You can control access to the secret using fine-grained IAM policies and resource-based policies.
- You can also tag secrets individually and apply tag-based access controls.
- With AWS Secrets Manager, you can rotate secrets on a schedule or on demand by using the Secrets Manager console, AWS SDK, or AWS CLI.
- For example, to rotate a database password, you provide the database type, rotation frequency, and master database credentials when storing the password in Secrets Manager.
- You can store and retrieve secrets using the AWS Secrets Manager console, AWS SDK, AWS CLI, or AWS CloudFormation.  
- You can configure VPC endpoints to keep traffic between your VPC and Secrets Manager within the AWS network.
- You can also use Secrets Manager client-side caching libraries to improve the availability and reduce the latency of using your secrets.
- AWS Secrets Manager enables you to audit and monitor secrets through integration with AWS logging, monitoring, and notification services.

![](images/secrets_1.png)

| Feature                     | Secrets Manager                                 | SSM Parameter Store                       |
|-----------------------------|--------------------------------------------------|------------------------------------------|
| Automatic Key Rotation      | Yes, built-in for some services, use Lambda for others | No native key rotation; can use custom Lambda |
| Key/Value Type              | String or Binary (encrypted)                    | String, StringList, SecureString         |
| Hierarchical Keys           | No                                              | Yes                                      |
| Price                       | Charges apply per secret                        | Free for standard, charges for advanced  |


## AWS CLI commands for Secrets Manager

```bash
aws secretsmanager list-secrets

aws secretsmanager create-secret --name dev-db-secret --description "This is the password for the development DB" --secret-string "MySecretSecureStringXYZ"

aws secretsmanager get-secret-value --secret-id dev-db-secret

aws secretsmanager describe-secret --secret-id dev-db-secret

aws secretsmanager update-secret --secret-id dev-db-secret --secret-string "NewSecretStringXYZ"

aws secretsmanager delete-secret --secret-id dev-db-secret
```

# Amazon Cognito

![](images/cognito_1.png)

![](images/cognito_2.png)

![](images/cognito_3.png)

## Adaptive authentication

With adaptive authentication, you can configure your user pool to block suspicious sign-ins or add second factor authentication in response to an increased risk level.

For each sign-in attempt, Amazon Cognito generates a risk score for how likely the sign-in request is to be from a compromised source. This risk score is based on many factors, including whether it detects a new device, user location, or IP address.

For each risk level, you can choose from the following options:

- Allow - Users can sign in without an additional factor.
- Optional MFA - Users who have a second factor configured must complete a second factor challenge to sign in.
- Require MFA - Users who have a second factor configured must complete a second factor challenge to sign in. Amazon Cognito blocks sign-in for users who don't have a second factor configured.
- Block - Amazon Cognito blocks all sign-in attempts at the designated risk level.

## User Datasets

Amazon Cognito lets you save end user data in datasets containing key-value pairs. This data is associated with an Amazon Cognito identity, so that it can be accessed across logins and devices. To sync this data between the Amazon Cognito service and an end user’s devices, invoke the synchronize method. Each dataset can have a maximum size of 1 MB. You can associate up to 20 datasets with an identity.

The Amazon Cognito Sync client creates a local cache for the identity data. Your app talks to this local cache when it reads and writes keys. This guarantees that all of your changes made on the device are immediately available on the device, even when you are offline. When the synchronize method is called, changes from the service are pulled to the device, and any local changes are pushed to the service. At this point the changes are available to other devices to synchronize.

# AWS Web Application Firewall (WAF)

- AWS WAF is a web application firewall
- WAF lets you create rules to filter web traffic based on conditions that include IP addresses, HTTP headers and body, or custom URIs
- WAF makes it easy to create rules that block common web exploits like SQL injection and cross site scripting

![](images/waf_1.png)

- **Web ACLs** You use a web access control list (ACL) to protect a set of AWS resources
- **Rules** Each rule contains a statement that defines the inspection criteria, and an action to take if a web request meets the criteria
- **Rule groups** You can use rules individually or in reusable rule groups
- **IP Sets** An IP set provides a collection of IP addresses and IP address ranges that you want to use together in a rule statement
- **Regex pattern set** A regex pattern set provides a collection of regular expressions that you want to use together in a rule statement

A **rule action** tells AWS WAF what to do with a web request when it matches the criteria defined in the rule:
- **Count**. AWS WAF counts the request but doesn't determine whether to allow it or block it. With this action, AWS WAF continues processing the remaining rules in the web ACL
- **Allow** AWS WAF allows the request to be forwarded to the AWS resource for processing and response
- **Block** AWS WAF blocks the request and the AWS resource responds with an HTTP 403 (Forbidden) status code

**Match** statements compare the web request or its origin against conditions that you provide

| Match Statement          | Description                                                                                      |
|--------------------------|--------------------------------------------------------------------------------------------------|
| Geographic match         | Inspects the request's country of origin                                                         |
| IP set match             | Inspects the request against a set of IP addresses and address ranges                            |
| Regex pattern set        | Compares regex patterns against a specified request component                                    |
| Size constraint          | Checks size constraints against a specified request component                                    |
| SQLi attack              | Inspects for malicious SQL code in a specified request component                                 |
| String match             | Compares a string to a specified request component                                               |
| XSS scripting attack     | Inspects for cross-site scripting attacks in a specified request component                       |

# Tracing with X-Ray

- You can use X-Ray to analyze both applications in development and in production, from simple three-tier applications to complex microservices applications consisting of thousands of services.
- X-Ray should not be used as an audit or compliance tool because it does not guarantee data completeness.
- You can use AWS X-Ray to visualize the components of your application, identify performance bottlenecks, and troubleshoot requests that resulted in an error

- AWS X-Ray supports applications running on:
  - Amazon Elastic Compute Cloud (Amazon EC2).
  - Amazon EC2 Container Service (Amazon ECS).
  - AWS Lambda.
  - AWS Elastic Beanstalk.

- AWS X-Ray supports tracing for applications that are written in Node.js, Java, and .NET.
- The X-Ray SDK captures metadata for requests made to MySQL and PostgreSQL databases (self-hosted, Amazon RDS, Amazon Aurora), and Amazon DynamoDB.
- It also captures metadata for requests made to Amazon SQS and SNS.
- The X-Ray SDK is installed in your application and forwards to the X-Ray daemon which forwards to the X-Ray API.

## X-Ray on EC2 / On-premises:

- Linux system must run the X-Ray daemon.
- IAM instance role if EC2, other AWS credentials on on-premises instance.

## Lambda 

-  Your Lambda functions send trace data to X-Ray, and X-Ray processes the data to generate a service map and searchable trace summaries
- Make sure the X-Ray integration is ticked in the Lambda configuration (Lambda will run the daemon).
- IAM role is the Lambda role.

![](images/lambda_metrics_2.png)

- When you trace your Lambda function, the X-Ray daemon automatically runs in the Lambda environment to gather trace data and send it to X Ray
- The function needs permissions to write to X-Ray in the execution role

## X-Ray on ECS/EKS/Fargate:

- Create a Docker image that runs the daemon or use the official X-Ray Docker image.
- Ensure port mappings and network settings are correct and IAM task roles are defined.

In Amazon ECS, create a Docker image that runs the X-Ray daemon, upload it to a Docker image repository, and then deploy it to your Amazon ECS cluster. You can use port mappings and network mode settings in your task definition file to allow your application to communicate with the daemon container.

## Elastic Beanstal

- Set configuration in the Elastic Beanstalk console.
- Or use the Beanstalk extension (`.ebextensions/xray-daemon.config`)

## Key X-Ray terminology

### Trace

An X-Ray trace is a set of data points that share the same trace ID.


### Segments

- An X-Ray segment encapsulates all the data points for a single component (for example, authorization service) of the distributed application.
- Segments include system-defined and user-defined data in the form of annotations and are composed of one or more sub-segments that represent remote calls made from the service.

### Subsegments

- Subsegments provide more granular timing information and details about downstream calls that your application made to fulfill the original request.
- A subsegment can contain additional details about a call to an AWS service, an external HTTP API, or an SQL database.
- You can even define arbitrary subsegments to instrument specific functions or lines of code in your application.
- For services that don’t send their own segments, like Amazon DynamoDB, X-Ray uses subsegments to generate inferred segments and downstream nodes on the service map.
- This lets you see all your downstream dependencies, even if they don’t support tracing, or are external.

### Annotations:

- An X-Ray annotation is system-defined, or user-defined data associated with a segment.
- System-defined annotations include data added to the segment by AWS services, whereas user-defined annotations are metadata added to a segment by a developer.
- A segment can contain multiple annotations.
- These are key / value pairs used to index traces and use with filters.
- Use annotations to record information on segments or subsegments that you want indexed for search.

### Sampling

- To provide a performant and cost-effective experience, X-Ray does not collect data for every request that is sent to an application.
- Instead, it collects data for a statistically significant number of requests.

### Metadata:

Key / value pairs, not indexed and not used for searching.

Exam tip: Remember that annotations can be used for adding system or user-defined data to segments and subsegments that you want to index for search. Metadata is not indexed and cannot be used for searching.

## Annotations and Filtering

- AWS X-Ray lets you add annotations to data emitted from specific components or services in your application.
- You can use this to append business-specific metadata that help you better diagnose issues.
- You can also view and filter data for traces by properties such as annotation value, average latencies, HTTP response status, timestamp, database table used, and more.

## X-Ray Daemon

- The AWS X-Ray Daemon is a software application that gathers raw segment data and relays it to the AWS X-Ray service

- The daemon works in conjunction with the AWS X-Ray SDKs so that data sent by the SDKs can reach the X-Ray service

The X-Ray daemon agent has a config to send traces cross account:

- Make sure the IAM permissions are correct – the agent will assume a role.
- This allows to have a central account for all your application tracing.


## X-Ray SDK

The X-Ray SDK is installed in your application and forwards to the X-Ray daemon which forwards to the X-Ray API.

You can then visualize what is happening in the X-Ray console.

The X-Ray SDK provides:

Interceptors to add your code to trace incoming HTTP requests.
Client handlers to instrument AWS SDK client that your application uses to call other AWS services.
An HTTP client to use to instrument calls to other internal and external HTTP web services.
Code must be instrumented to use the AWS X-Ray SDK.

The IAM role must be correct to send traces to X-Ray.

# AWS Fault Injection Simulator

- AWS Fault Injection Simulator is a fully managed service for running fault injection experiments on AWS.

- Makes it easier to improve an application’s performance, observability, and resiliency.

- Fault injection experiments are used in chaos engineering, which is the practice of stressing an application in testing or production environments by creating disruptive events.

- Fault injection experiment helps teams create the real-world conditions needed to uncover the hidden bugs, monitoring blind spots, and performance bottlenecks that are difficult to find in distributed systems.

# AWS Resource Access Manager

- AWS Resource Access Manager (RAM) is a service that enables you to share AWS resources easily and securely with any AWS account or within your AWS Organization.
- You can share:
  - AWS Transit Gateways
  - Subnets
  - AWS License Manager configurations 
  - Amazon Route 53 Resolver rules resources with RAM.
- RAM eliminates the need to create duplicate resources in multiple accounts, reducing the operational overhead of managing those resources in every single account you own.
- You can create resources centrally in a multi-account environment, and use RAM to share those resources across accounts in three simple steps:
  1. Create a Resource Share.
  1. Specify resources.
  1. Specify accounts.
- RAM is available at no additional charge.


## Key benefits:

- Reduce Operational Overhead – Procure AWS resources centrally and use RAM to share resources such as subnets or License Manager configurations with other accounts. This eliminates the need to provision duplicate resources in every account in a multi-account environment.
- Improve Security and Visibility – RAM leverages existing policies and permissions set in AWS Identity and Access Management (IAM) to govern the consumption of shared resources. RAM also provides comprehensive visibility into shared resources to set alarms and visualize logs through integration with Amazon CloudWatch and AWS CloudTrail.
- Optimize Costs – Sharing resources such as AWS License Manager configurations across accounts allows you to leverage licenses in multiple parts of your company to increase utilization and optimize costs.

# AWS Macie

Amazon Macie is a fully managed data privacy and security service that uses machine learning and pattern matching to discover and protect sensitive data in AWS, such as PII. This includes being able to scan CloudWatch logs for PII

