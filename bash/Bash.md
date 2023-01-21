# Bash

- [Bash](#bash)
  - [История](#история)
  - [Рекомендуемые источники для справки](#рекомендуемые-источники-для-справки)
  - [Переменные](#переменные)
    - [Дефолтные переменные](#дефолтные-переменные)
  - [Bash options](#bash-options)
    - [set](#set)
    - [shopt](#shopt)
  - [Коды завершения](#коды-завершения)
  - [Производительность.](#производительность)
  - [Начало скрипта](#начало-скрипта)
  - [Кавычки](#кавычки)
  - [Типы данных](#типы-данных)
  - [Пользовательский ввод](#пользовательский-ввод)
  - [Ссылки на файлы с переменными и функциями](#ссылки-на-файлы-с-переменными-и-функциями)
  - [Аргументы скрипта](#аргументы-скрипта)
  - [Оператор shift](#оператор-shift)
  - [Command substitution](#command-substitution)
  - [Parameter substitution](#parameter-substitution)
  - [Here document](#here-document)
  - [Function](#function)
  - [Приммр простого скрипта](#приммр-простого-скрипта)
  - [Pattern matching](#pattern-matching)
    - [почистить строку](#почистить-строку)
    - [сделать замену в переменной](#сделать-замену-в-переменной)
    - [Поменять регистр](#поменять-регистр)
    - [примеры скриптов](#примеры-скриптов)
  - [Примеры использования ext globing](#примеры-использования-ext-globing)
  - [Численные вычисления](#численные-вычисления)
    - [Операции с целыми числами](#операции-с-целыми-числами)
    - [Операции с дробными числами](#операции-с-дробными-числами)
      - [bc - утилита для дробных вычислений](#bc---утилита-для-дробных-вычислений)
    - [Полезные утилиты для вычислений](#полезные-утилиты-для-вычислений)
    - [Примеры скриптов](#примеры-скриптов-1)
  - [Ветвление](#ветвление)
    - [if](#if)


## История

![](images/2.png)

![](images/3.png)

Bash это Bourne again shell

## Рекомендуемые источники для справки

- `man bash`
- [Самоучитель Beginner рекомендуемый Sandar van Vagt](https://tldp.org/LDP/Bash-Beginners-Guide/html/)
- [Самоучитель Advanced рекомендуемый Sandar van Vugt](https://tldp.org/LDP/abs/html/)

## Переменные
Важно понимать что при создании переменной в скрипте она видима только в текущем bash.
Многие команды исполняются в отдельном bash. В этом случае важно использовать `export`

![](images/1.png)

можно сразу создать переменную экспортировать во все дочерние shell и присвоить значение
```bash
export KEY=VALUE
```

> Переменные регистронезависимые

> Обычно переменные окружения пишутся с заглавных букв. Локальные переменные пишет кто как, автор курса пишет с большой буквы, но не все люди с этим согласны, аргумент, что происходит путанница.

чтобы обнулить значение переменной
```bash
variable=
```
удалить саму переменную
```bash
unset variable
```

Ссылка на переменную:
- `$variable`
- `${variable}` рекомендуемый способ
- `echo "${variable}"`в некоторых случаех предпочтительно использовать ссылку внутри двойных кавычек

### Дефолтные переменные

`$RANDOM` - случайное число

`$SECONDS` - число секунд, которое работает текущий shell

`$LINENO` - номер строки текущего скрипта

`$HISTCMD`- номер текущей команды в истории команд

`$GROUPS`- массис с именами групп, в которые входит текущий пользователь

`$DIRSTACK`- история недавно посещаемых директорий

`$BASH_ENV` `$BASH_OPT` - 

## Bash options

посмотреть все опции bash
```
man bash
```

![](images/bash_options_2.png)

### set
Меняют поведение программ. Например `-x` меняеn работe команд, при старте команды будет выводиться в stdout сама команда и ее аргументы. Удобно для дебага скриптов.
```
set -x
ls
set +x
```
![](images/bash_options_1.png)

Варианты использования:
- поставить в текущей консоли для временного использования (удобно для дебага) `bash -x ./my_script`
- поставить в скрипты для пользователя или пользователей при старте
- включать для действия в конкретном скрипте через `#!/bin/bash -x`


### shopt

Некоторые опции ставятеся через команду `shopt` . Они также описаны в `man bash`

показать все опции `shopt`

пример включения мониторинга джобов при выходе
```bash
shopt -s checkjobs
sleep 3600 &
exit
```
![](images/bash_options_3.png)


## Коды завершения
каждая команда заканчивается каким-то кодом

посмотреть предыдущий код
```
echo $?
```
0 - успешно
1 - ошибка общего характера general error
Обычно все что не 0 это какая-то проблема.

скрипт можно завершить кодом
```
exit n где n это код
``` 

## Производительность.

Для лучшей производительности лучше не использовать утилиты, подгружаемые с диска, например `sed` и `awk`. По возможности использовать встроенными в баш командами. Команда `help` выводит все встроенные команды в баш. Также команда `type` выводит тип команды. Командой `time` можно проверить время исполнения конкретной команды. Также можно посмотреть от каких библиотек зависит команда, командой `ldd`. Детальнее смотри заметки по линуксу. 

## Начало скрипта

Для надежности стоит писать в самом начале скрипта
```bash
#!/bin/bash
``` 

или
```bash
#!/usr/bin/env bash
``` 


в этом случае если текущий shell не bash, например zsh, все равно будет исполняться bash

проверить текущий shell
```bash
echo $SHELL 
``` 

## Кавычки
`"` - двойные кавычки используются для указания того, что проблемы в подстроке относятся к одному аргументы. Все внедрения переменных через $ будут работать.

`'` - одинакрные кавычки используются для остановки внедрения переменных и сприктов. 

## Типы данных
В баше нет типов данных, но есть массивы. 
Также есть ключевое слово `declare` , которое используюется для указания некоторых свойств переменных

Установка свойства read-only на переменную `ANSWER` со значением `yes`
```bash
declare -r ANSWER=yes
```

указание что переменная является индексированным или ассоциативным массивом
```bash
declare -a MYARRAY
```

печатает тип переменной 
```bash
declare -p VARIABLE
```

## Пользовательский ввод

самый простой способ
```bash
echo enter the value
read value
echo you have entered $value
```
если после `read` не указано переменной, ввод сохраняется в переменной `$REPLY`

удобный способ завершать скрипт с фразой `Press any key to continue`

```bash
echo Press Enter to continue
read
```

можно использовать для установки нескольких переменных
```bash
echo enter firstnane, lastname and city
read firstname lastname city
echo nice to meet you $firstname $lastname from $city
```

## Ссылки на файлы с переменными и функциями
Есть механизм подключения файлов в текущий bash это называется sourcing

два способа, после начала скрипта написать:
```bash
source path_to_file_with_variables
```

```bash
. path_to_file_with_variables
```

## Аргументы скрипта
Можно ссылать на аргументы скрипта через `$1` и до `$9` . Если аргументов больше тогда ссылки будут с использованием фигурных скобок `${10}`. 

Переменная `$0` содержит имя текущего скрипта. 

Переменная `$#` содержит количество аргументов

Также можно ссылаться сразу на все аргументы через `$@` и `$*`. Без кавычек эти способы равнозначны. С кавычками `$@` массив аргументов по которому можно итерироваться `$*` c кавычками помещает все аргументы в один аргумент. Рекомендуется использовать `$@` во всех случаях, если не нужно поместить все аргументы в массив.

```bash
#!/bin/bash
#
# ...

echo "Hello $1, how are you today"
echo " hello $2, how are you"
echo " hello $10, how are you"
echo " hello ${10}" 
echo " hello ${11}"
shift
echo hi $1
echo "\$0 is $0"
```

![output](images/positional_arguments_1.png)

```bash
#!/bin/bash
echo "Hello $1, how are you today"
echo "\$# gives $#"
echo "\$* gives $*"
echo "\$@ gives $@"
echo "\$0 is $0"

# trying to show every single argument on a separated line
echo showing the interpretation of \$* 
for i in "$*"
do
	echo $i
done

echo showing the interpretation of \$@
for i in "$@"
do
	echo $i
done
```

![output](images/positional_arguments_2.png)

## Оператор shift

Удаляет аргументы скрипта при использовании. 

Если не указывать ничего после `shift` сместит все аргументы влево, т.е первый аргумент будет удален, а второй займет его место и так далее. 

Если указать цифру после `shift` в этом случае произойдет смещение влево аргументов на величину цифры


```bash
#!/bin/bash
echo the script has $# arguments

echo print $1
shift 
echo print $1
shift 3
echo print $1
```
![output](images/shift_operator_1.png)

## Command substitution 

Можно использовать о скобки и тильду

```bash
today=$(date +%d-%m-%y)
mykernel=$(uname -r)
```
```bash
today=`date +%d-%m-%y`
mykernel=`uname -r`
```
для читаемости лучше использовать `$()`

```bash
#!/bin/bash
#simple demo backup script
#writes backup file to current directory and backs up everything provided as an argument

if [ -z $1]
then
    echo argument required
    exit 9
fi 

sudo tar -cvf $(date +%d-%m-%y).bak $@
```

## Parameter substitution

можно ставить дефолтное значение в случае отсутствия значения, либо вызывать выражение, которое определит значение

```bash
#!/bin/bash

echo press username or press enter to use default value
read username
echo ${username:-$(whoami)}
```

тут выполняется попытка чтения инпута в переменную username. Далее через `${}` осущесвляется ссылка на переменную, если она пустая, то вызывается command substitution whoami который возвращает имя текущего пользователя. При этом присвоение к usename не происходит, оно по-прежнему пустое.

Если `$1` не задан, то используется дефолтное значение и присваивается к `filename`
```bash
filename=${1:-$DEFAULT_FILENAME}
```

```bash
echo ${username:=$(whoami)}
filename=${1:=$DEFAULT_FILENAME}
```

```bash
#!/bin/bash
echo take one
echo ${var:-abc}
echo ${var}

echo take two
echo ${var:=abc}
echo ${var}
```


если переменная не задана пишем сообщение и выходим с кодом 1
```bash
echo ${myvar:?error_message}
```

## Here document

A here document is a special-purpose code block. It uses a form of I/O redirection to feed a command list to an interactive program or a command, such as ftp, cat, or the ex text editor.

```bash
COMMAND <<InputComesFromHERE
...
...
...
InputComesFromHERE
```

```bash
ssh $SERVER bash <<EOF
cd downloads/
read -e -p "Enter the path to the file: " FILEPATH
echo $FILEPATH
eval FILEPATH="$FILEPATH"

echo "Downloading $FILEPATH to $CLIENT"
EOF
```

## Function

Два способа обьявить функцию

пробелы между скобками не важны
```bash
function_name () {

}
```

```bash
function function {

}
```

> Аргументы функции имеют локальный скоуп. 

```bash
#!/bin/bash
hello(){
    echo hello $1
}
hello bob
```

> Аргументы всего скрипта при этом недоступны в функции

## Приммр простого скрипта
```bash
#!/bin/bash

if grep -i 'ubuntu' /etc/os-release > /dev/null
then
    PACKAGE_MANAGER=apt
fi

if grep -i 'red hat' /etc/os-release > /dev/null
then
    PACKAGE_MANAGER=yum
fi

if [ -z $1 ]
then
    echo enter package name to install
    read PACKAGE
else
    PACKAGE=$1    
fi

sudo $PACKAGE_MANAGER install $PACKAGE -y

```

## Pattern matching

Рекомендуется к использованию, а не `sed` т.к это нативный bash, ничего с диска не читается, sed - утилита на диске.

длинну аргумента. Количество символов.
```bash
${1#}
```

### почистить строку 

- `${var#pattern}` удаляет самый короткий результат поиска слева направо
- `${var##pattern}` удаляет самый длинный результат поиска слева направо 
- `${var%pattern}` удаляет самый короткий результат поиска справа налево
- `${var%%pattern}` удаляет самый длинный результат поиска справа налево

```bash
#!/bin/bash
#
# ...
# to test, use /usr/bin/blah

filename=${1##*/}
echo 'filename=${1##*/}'
echo "The name of the file is $filename"
directoryname=${1%/*}
echo 'directoryname=${1%/*}'
echo "the name of the directory is $directoryname"
```

![](images/pattern_matching_1.png)

```bash
#!/bin/bash
BLAH=rababarabarabarara
clear

echo BLAH=$BLAH
echo 'the result of ##*ba is' ${BLAH##*ba} 
echo 'the result of #*ba is' ${BLAH#*ba} 
echo 'the result of %%ba* is' ${BLAH%%ba*}
echo 'the result of %ba* is' ${BLAH%ba*}
```

 ![](images/pattern_matching_2.png)

### сделать замену в переменной

```bash
${var/pattern/replacement}
```
да очень похоже на `sed`

для глобальной замены, т.е много раз используем двойной слеш

```bash
${var//pattern/replacement}
```

делать замену, только если переменная начинается с паттерна
```bash
${var/#pattern/replacement}
```

делать замену, только если переменная заканчивается паттерном
```bash
${var/%pattern/replacement}
```

```bash
#!/bin/bash

VAR=donkey
echo $VAR

VAR=${VAR/donkey/horse}
echo $VAR
```

### Поменять регистр

- `${var^^}` переводит в верхний регистр
- `${var,,}` переводит в нижний регистр

```bash
#!/bin/bash

color=red
echo ${color^^}

color=BLUE
echo ${color,,}
```

### примеры скриптов

Заменить в текущей директории названия файлов с .txt  на название без расширения

```bash
#!/bin/bash

for i in *txt
do
    mv $i ${i%.*}
done    
```


## Примеры использования ext globing 

Итерируемся по файлам в текущей директории, пишем имя файла в переменную `i`. В случае если выполняется выражение, т.е файл не заканчивается на doc, txt, pdf выводится строка с именем файла, что это не документ, иначе выводится строка, что этот файл документ.
```bash
#!/bin/bash
shopt -s extglob
for i in *
do
	case $i in
	!(*.doc|*.txt|*.pdf))
		echo $i is not a document
		;;
	*)
		echo $i is a document
	;;
	esac
done
```

Итерируемся по файлам в текущей директории и выводим их список, но удаляем расширения определенные. 

```bash
#!/bin/bash
shopt -s extglob
for i in *
do
	echo ${i%%*(.doc|.txt|.pdf)}
done
```
чуть подправим, чтобы не показывал, а прямо переименовывал файлы

```bash
#!/bin/bash
shopt -s extglob
for i in *
do
	mv $i ${i%%*(.doc|.txt|.pdf)}
done
```

## Численные вычисления

### Операции с целыми числами

Несколько способов посчитать целочисленное выражение
- `let expression` встроенное в баш
- `expr expression` внешняя программа - редко используется. 
- `$(( expression ))` встроенное в баш. Рекомендуемый способ

Операторы: `+` , `++`, `-`, `%`, `*` , `/`

```bash
let a=1+2
echo $a
let a++
echo $a

echo $(( 1 * 3))
```

что-нибудь посложнее
```bash
echo $(( $(sudo fdisk -l | grep '/dev/sda:' | awk '{ pring $5 }') / 1024 ))
echo $(( $(sudo fdisk -l | grep '/dev/sda:' | awk '{ pring $5 }') / $(( 1024 * 1024 )) ))
```
### Операции с дробными числами

#### bc - утилита для дробных вычислений

К сожалению ее нету в gitbash
Обычно используется в pipes 

```bash
echo "12/5" | bc
```
для того чтобы в результате присутствовала дробная часть используется опция `-l`

```bash
echo "12/5" | bc -l
```

Поддерживает разные математические функции, например
```bash
echo "sqrt(1000)" | bc -l
```

### Полезные утилиты для вычислений

разложение на простые множители `factor`
```bash
factor 3444 
```
output: `3444: 2 2 3 7 41`

### Примеры скриптов

Заметим что `COUNTER` в выражении понимается как переменная и не требует ссылки через `$`
```bash
#!/bin/bash

COUNTER=$1
COUNTER=$(( COUNTER * 60 ))

while true
do
	echo $COUNTER seconds remaining in break
	COUNTER=$(( COUNTER - 1 ))
	sleep 1
done
```

## Ветвление


### if

внутри выражение обычно используются модификации команды `test`. О ней можно почитать в 
```
man test
```

![](images/image164.png)

вместе с тем что есть test как внешняя команда, есть test, который является внутренней командой. И получить помощь по ней можно как обычно по встроенным командам в баш `help test`


![](images/test_help.png)


Вот тут например `z` проверка на нулевую длину аргумента. Далее выходим `exit` с кодом 6. Код 0 успешно код 1 неуспешно.

```bash
if [ -z $1 ]
then
 echo'there is empty argument'
 exit 6
fi
echo'hello'
```

Можно указать ветку else
```bash
if [ -z $1 ]
then
 echo'there is empty argument'
 exit 6
else
 echo'hello'
fi
```

Тут обратите внимание на конструкцию `elif` внутри if секции.

```bash
if [ $1 = yes ]
then
  echo ok
elif [ $1 = no ]
then
  echo not ok
else
  echo sorry
fi
```

можно писать в одну строчку
```bash
if [ -f /etc/hosts ]; then echo file exists; fi
```

внутри if может быть любая команда. Происходит анализ кода заверршения этой команды, если этот код 0, тогда выполняется тело if. Выше мы использовали команду test в форме [ ]. Можно писать просто test. А также что-то такое.

```bash
if grep student /etc/passwd
then
  echo some text
fi  
```

можно использовать операторы И `&` или ИЛИ `||` 
```bash
if [ -d $1 ] && [ -f $2 ]
then
  echo $1
fi
```

можно использовать эти операторы для того чтобы сокращать вид ифа. Т.к тест проверяет возвращаемые код, в случае если первая команда выполнится с кодом 0, будет выполнена вторая
```bash
[ -f /etc/hosts ] && echo file exists
```

Есть еще один способ писать выражения, через [[]]. При этом будет использоваться не test, а еще один механизм встроенный в баш. 
Примеры:
```bash
[[ $VAR1 = yes && $VAR2 = red ]]
[[ 1 < 2 ]]
[[ -e $b ]]

[[ $var = img* && ($var = *.png || $var = *.jpg) ]] && echo $var starts with img and ends wirh .jpg or .png
```