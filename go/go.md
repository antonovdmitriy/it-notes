- [Basics](#basics)
  - [Installation](#installation)
    - [Check go installation](#check-go-installation)
    - [Setup environment variable](#setup-environment-variable)
  - [First program](#first-program)
  - [Launch without a binary file](#launch-without-a-binary-file)
  - [Build a binary file](#build-a-binary-file)
  - [Install additional tols](#install-additional-tols)
  - [Example with linter usage](#example-with-linter-usage)
  - [Troubleshooting](#troubleshooting)
    - [Tabs and spaces](#tabs-and-spaces)
- [Literals](#literals)

# Basics

## Installation

### Check go installation

```
go version
```

![](images/image2.png)

### Setup environment variable

for linux
```bash
export GOPATH=$HOME/go
export PATH=$PATH:$GOPATH/bin
```

For windows
```bat
setx GOPATH %USERPROFILE%\go
setx path "%path%;%GOPATH%\bin"
```

## First program

```go
packagemain

import"fmt"

funcmain(){

 fmt.Println("Hello, world!")

}
```
- Save file as `hello.go`

## Launch without a binary file

- Launch 

    ```bash
    go run hello.go
    ```
    ![](images/image3.png)
- While launching binary file was created in temporary directory and deleted after program was finished


## Build a binary file

```bash
go build -o hello_world hello.go
```

![](images/image1.png)

## Install additional tols

You can install additional tools via `go install`

For example install aggregate linter (include many popular linters)

```
go install github.com/golangci/golangci-lint/cmd/golangci-lint@v1.46.2
```

## Example with linter usage

- create module for an application 

```
go mod init ch1
```

- create makefile for build. It will apply linter and create binary file

```makefile
.DEFAULT_GOAL:= build

fmt:
        go fmt ./...
.PHONY:fmt

lint:fmt
        golint ./...
.PHONY:lint

vet:fmt
        go vet ./...
.PHONY:vet

build:vet
        go build hello.go
.PHONY:build
```

After `:` defined previous `target`, link to previous task which has to been completed before current task

- launch build

  ```
  make
  ```

    ![](images/image7.png)

if you don't have `make` on Windows, you can install `choko` manager and then install `make`

```powershell
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('[https://community.chocolatey.org/install.ps1](https://www.google.com/url?q=https://community.chocolatey.org/install.ps1&sa=D&source=editors&ust=1675178682544290&usg=AOvVaw1Vvl_ZL3FJM_aIM1uyGrzj)'))

choco install make
```

## Troubleshooting

### Tabs and spaces 

In the process writing VS code change tab to spaces. Then I find an option

![](images/image6.png)

You can check indentation with halp of  `cat`

```
cat -e -t -v Makefile
```

![](images/image4.png)+

Before it was like this

![](images/image5.png)


# Literals

In integral literal you can write underscores `_`