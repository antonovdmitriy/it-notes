# Содержание
- [Содержание](#содержание)
- [Install Kubernetes locally](#install-kubernetes-locally)
    - [Linux](#linux)
    - [kind](#kind)
  - [Mac](#mac)
    - [colima](#colima)
    - [install argo cd to colima](#install-argo-cd-to-colima)
    - [add test application to argo](#add-test-application-to-argo)
- [Getting help](#getting-help)
  - [About kubectl commands](#about-kubectl-commands)
- [Swtich between context](#swtich-between-context)
  - [Получение информации о созданных объектах](#получение-информации-о-созданных-объектах)
- [Создание и удаление объектов](#создание-и-удаление-объектов)
- [Получение логов](#получение-логов)


# Install Kubernetes locally

### Linux

### kind

```bash
curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.10.0/kind-linux-amd64
chmod +x ./kind
echo $PATH
sudo mv ./kind /usr/local/bin/kind
kind
kind create cluster
sudo snap install docker
kind create cluster
```

Подключиться получается только из под `root`. 

## Mac

### colima

```
brew install docker
brew install colima
brew install kubectl
colima start --with-kubernetes
```

to check after installation

```
colima status
kubectl get nodes
docker ps
```

### install argo cd to colima

```sh
kubectl create namespace argocd
```

```sh
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

kubectl get pods -n argocd -w
kubectl port-forward svc/argocd-server -n argocd 8080:443
```

then open via browser `https://localhost:8080`

login: admin 
password

```sh
kubectl get secret argocd-initial-admin-secret -n argocd -o jsonpath="{.data.password}" | base64 -d && echo
```

### add test application to argo

	1.	Нажми + NEW APP
	2.	Заполни поля:

🔧 Application Settings:
	•	Application Name: guestbook
	•	Project: default
	•	Sync Policy: можешь оставить пустым или включить Auto-Sync по желанию

📦 Source:
	•	Repository URL:
  https://github.com/argoproj/argocd-example-apps

  	Revision: HEAD
	•	Path: guestbook

🎯 Destination:
	•	Cluster URL: https://kubernetes.default.svc
	•	Namespace: default
(создаст автоматически, если его нет)

	3.	Нажми Create

  После создания:
	•	Ты увидишь дерево ресурсов (Service, Deployment, ReplicaSet, Pod)
	•	Нажми Sync → Synchronize

Приложение задеплоится, и ты сможешь пробросить порт:
kubectl port-forward svc/guestbook-ui 8081:80

Открой в браузере: http://localhost:8081￼

# Getting help

## About kubectl commands
```
Kubectl -h
```

Help about a certain command
```
kubectl command -h
```

![](images/image20.png)

# Swtich between context

to show all added contexts

```sh
kubectl config get-context
```

get current context

```sh
kubectl config current-context
```

## Получение информации о созданных объектах

```
kubectl get all
```

![](images/image51.png)

- Видим 1 deployment, который управляет одним replica set, в котором 2 поды.

Посмотреть все поды
```
kubectl get pods
```
![](images/image25.png)

Расширенная информация
```
kubectl get all -o wide 
kubectl get pods -o wide
```
![](images/image24.png)

# Создание и удаление объектов

Получить справку 
```
kubectl create deployment -h
```

Создать деплоймент
```
kubectl create deployment cmd-nginx --image=nginx
```

![](images/image40.png)

![](images/image25.png)

Создание объекта , описание которого находится в yml файле
```
kubectl create -f my_file.yml
```

Удаление объекта
```
Kubectl delete -f my_file.yml
```

# Получение логов

Зная имя поды можно получить логи с поды.
```
kubectl logs pod_name
```
![](images/image9.png)
