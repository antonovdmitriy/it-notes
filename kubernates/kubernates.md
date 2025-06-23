# Содержание
- [Содержание](#содержание)
- [Install Kubernetes locally](#install-kubernetes-locally)
    - [Linux](#linux)
    - [kind](#kind)
  - [Mac](#mac)
    - [colima](#colima)
- [Getting help](#getting-help)
  - [About kubectl commands](#about-kubectl-commands)
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
kubectl get nodes
docker ps
```


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
