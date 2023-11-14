
- [History](#history)
- [Recommended sources to help](#recommended-sources-to-help)
- [Variables](#variables)
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
	- [Positional arguments](#positional-arguments)
	- [More complex arguments](#more-complex-arguments)
- [Оператор shift](#оператор-shift)
- [Command substitution](#command-substitution)
- [Parameter substitution](#parameter-substitution)
- [Here document](#here-document)
- [Function](#function)
	- [Arguments](#arguments)
	- [Variable scope](#variable-scope)
- [Simple script example](#simple-script-example)
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
	- [case](#case)
- [Циклы](#циклы)
	- [for](#for)
	- [while](#while)
	- [until (oposite while)](#until-oposite-while)
	- [break and contiunue](#break-and-contiunue)
- [Menu](#menu)
- [trap](#trap)
- [Arrays](#arrays)
	- [Types of arrays:](#types-of-arrays)
	- [Reference to arrya values](#reference-to-arrya-values)
	- [Example script indexed array](#example-script-indexed-array)
	- [Example of associative array](#example-of-associative-array)
	- [Reading output to an array](#reading-output-to-an-array)
	- [Looping on array](#looping-on-array)
	- [Lab about arrays](#lab-about-arrays)
- [Best Practises](#best-practises)
	- [Using BASH\_XTRACEFD for debug](#using-bash_xtracefd-for-debug)
- [Complex scripts](#complex-scripts)
	- [trivial restart if service down](#trivial-restart-if-service-down)
	- [check users are created](#check-users-are-created)
	- [install kube cluster](#install-kube-cluster)

# History

![](images/2.png)

![](images/3.png)

Bash это Bourne again shell

# Recommended sources to help

- `man bash`
- [Text book for Beginner. Recommended by Sander van Vugt](https://tldp.org/LDP/Bash-Beginners-Guide/html/)
- [Text book for Advanced. Recommended by Sander van Vugt](https://tldp.org/LDP/abs/html/)

# Variables
When you create new variable it can be seen only in current bash. Many commands invoke another bash. In that case you can use `export`

![](images/1.png)

we can create variable and at the same place export to all child bashes
```bash
export KEY=VALUE
```

> Variables is case-insensitive

to make variable null again
```bash
variable=
```

delete variable
```bash
unset variable
```

Ссылка на переменную:
- `$variable`
- `${variable}` рекомендуемый способ
- `echo "${variable}"`в некоторых случаех предпочтительно использовать ссылку внутри двойных кавычек

## Дефолтные переменные

`$RANDOM` - случайное число

`$SECONDS` - число секунд, которое работает текущий shell

`$LINENO` - номер строки текущего скрипта

`$HISTCMD`- номер текущей команды в истории команд

`$GROUPS`- массиd с именами групп, в которые входит текущий пользователь

`$DIRSTACK`- история недавно посещаемых директорий

`$BASH_ENV` `$BASH_OPT` - 

# Bash options

посмотреть все опции bash
```
man bash
```

![](images/bash_options_2.png)

## set
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

- `-e` - exit the script when a command fail
- `-i` - run script in interactive mode - line-by-line
- `-v` - verbose mode. A bit less details then `-x`

## shopt

Некоторые опции ставятеся через команду `shopt` . Они также описаны в `man bash`

показать все опции `shopt`

пример включения мониторинга джобов при выходе
```bash
shopt -s checkjobs
sleep 3600 &
exit
```
![](images/bash_options_3.png)


# Коды завершения
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

# Производительность.

- Для лучшей производительности лучше не использовать утилиты, подгружаемые с диска, например `sed` и `awk`. 
- По возможности использовать встроенными в баш командами. 
- Команда `help` выводит все встроенные команды в баш. 
- Команда `type` выводит тип команды. 
- Командой `time` можно проверить время исполнения конкретной команды. 
- Можно посмотреть от каких библиотек зависит команда, командой `ldd`. Детальнее смотри заметки по линуксу. 

# Начало скрипта

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

# Кавычки
`"` - двойные кавычки используются для указания того, что проблемы в подстроке относятся к одному аргументу. Все внедрения переменных через $ будут работать.

`'` - одинарные кавычки используются для остановки внедрения переменных и скриптов. 

# Типы данных
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

# Пользовательский ввод

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

# Ссылки на файлы с переменными и функциями
Есть механизм подключения файлов в текущий bash это называется sourcing

два способа, после начала скрипта написать:
```bash
source path_to_file_with_variables
```

```bash
. path_to_file_with_variables
```

# Аргументы скрипта

## Positional arguments
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

## More complex arguments


```bash
#!/bin/bash
while getopts "hs:" arg; do
case $arg in
	h)
		echo "usage"
		;;
	s)
		strength=$OPTARG
		echo $strength
		;;
	esac
done
```

![output](images/arguments_1.png)

complex example

```bash

#!/bin/bash
#makeusr [-u uid] [-g gid] [-i info] [-h homedir] [-s shell] username
	function usage
	{
			echo ‘usage: makeusr [-u uid] [-g gid] [-i info] [-h homedir] ‘
			echo ‘[-s shell] username
			exit 1
	}

	function helpmessage
	{
			echo "makeusr is a script ... "
			echo "blablabla"
	}

	while getopts "u:g:i:h:s:" opt; do
			case $opt in
				u ) uid=$OPTARG ;;
				g ) gid=$OPTARG ;;
				i ) info=$OPTARG ;;
				h ) home=$OPTARG ;;
				s ) shell=$OPTARG ;;
				? ) helpmessage ;;
				* ) usage ;;
			esac
	shift $(($OPTIND -1))
	done

	if [ -z "$1" ]; then
			usage
	fi

	if [ -n "$2" ]; then
			usage
	fi

	if [ -z "$uid" ]; then
			uid=500
			while cut -d : -f3 /etc/passwd | grep -x $uid
			do
				uid=$((uid+1)) > /dev/null
			done
	fi

	if [ -z "$gid" ]; then
			gid=$(grep users /etc/group | cut -d: -f3)
	fi

	if [ -z "$info" ]; then
			echo Provide information about the user.
			read info
	fi

	if [ -z "$home" ]; then
			home=/home/$1
	fi

	if [ -z "$shell" ]; then
			shell=/bin/bash
	fi

	echo $1:x:$uid:$gid:$info:$home:$shell >> /etc/passwd
	echo $1:::::::: >> /etc/shadow
	mkdir -p $home
	chmod 660 $home
	chown $1:users $home
	passwd $1
```

manual argument processing

```bash

#!/usr/bin/env bash

# File name
readonly PROGNAME=$(basename $0)
# File name, without the extension
readonly PROGBASENAME=${PROGNAME%.*}
# File directory
readonly PROGDIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)
# Arguments
readonly ARGS="$@"
# Arguments number
readonly ARGNUM="$#"

usage() {
	echo "Script description"
	echo
	echo "Usage: $PROGNAME -i <file> -o <file> [options]..."
	echo
	echo "Options:"
	echo
	echo "  -h, --help"
	echo "      This help text."
	echo
	echo "  -i <file>, --input <file>"
	echo "      Input file. If \"-\", stdin will be used instead."
	echo
	echo "  -o <file>, --output <file>"
	echo "      Output file."
	echo
	echo "  --"
	echo "      Do not interpret any more arguments as options."
	echo
}

while [ "$#" -gt 0 ]
do
	case "$1" in
	-h|--help)
		usage
		exit 0
		;;
	-i|--input)
		input="$2"

		# Jump over <file>, in case "-" is a valid input file 
		# (keyword to standard input). Jumping here prevents reaching
		# "-*)" case when parsing <file>
		shift
		;;
	-o|--output)
		output="$2"
		;;
	--)
		break
		;;
	-*)
		echo "Invalid option '$1'. Use --help to see the valid options" >&2
		exit 1
		;;
	# an option argument, continue
	*)	;;
	esac
	shift
done
```


# Оператор shift

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

# Command substitution 

Two cases

- one 
```bash
today=$(date +%d-%m-%y)
mykernel=$(uname -r)
```

- two
```bash
today=`date +%d-%m-%y`
mykernel=`uname -r`
```
for readablitiy use this `$()`

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

# Parameter substitution

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

тут происходит присваивание в случае отсутствия
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

# Here document

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

```bash
cat << REBOOT >> /root/completeme.sh
touch /tmp/after-reboot
rm -f /etc/profile
mv /etc/profile.bak /etc/profile
echo DONE
REBOOT

chmod +x /root/completeme.sh
cp /etc/profile/ etc/profile.bak
echo /etc/completeme.sh >> /etc/profile

reboot
```

# Function

Two option to write function

> spaces between braces are mot matter

```bash
function_name () {

}
```

```bash
function function {

}
```

## Arguments

> Function argument has local scope

```bash
#!/bin/bash
hello(){
    echo hello $1
}
hello bob
```

> Arguments for all script are unavailable for function

## Variable scope

> No matter where try are defined, variables always have a global scope - even if defined in a fuction

`local` keyword to define local variable

```bash
#!/bin/bash
var1=A

my_function () {
	local var2=B
	var3=C
	echo "inside function: var1: $var1, var2: $var2, var3: $var3"
}

echo "before runninng function: var1: $var1, var2: $var2, var3: $var3"

my_function

echo "after running function: var1: $var1, var2: $var2, var3: $var3"
```

![Funciton variables scope](images/variable_func_scope_1.png)

# Simple script example
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

# Pattern matching

Рекомендуется к использованию, а не `sed` т.к это нативный bash, ничего с диска не читается, sed - утилита на диске.

длинну аргумента. Количество символов.
```bash
${1#}
```

## почистить строку 

- `${var#pattern}` удаляет самый короткий результат поиска слева направо
- `${var##pattern}` удаляет самый длинный результат поиска слева направо 
- `${var%pattern}` удаляет самый короткий результат поиска справа налево
- `${var%%pattern}` удаляет самый длинный результат поиска справа налево

```bash
#!/bin/bash
#
# ...
# to test, use /usr/bin/blah

filename=${1#*/}
echo 'filename=${1#*/}'
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
echo 'the result of #*ba is' ${BLAH#*ba} 
echo 'the result of #*ba is' ${BLAH#*ba} 
echo 'the result of %%ba* is' ${BLAH%%ba*}
echo 'the result of %ba* is' ${BLAH%ba*}
```

 ![](images/pattern_matching_2.png)

## сделать замену в переменной

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

## Поменять регистр

- `${var^^}` переводит в верхний регистр
- `${var,,}` переводит в нижний регистр

```bash
#!/bin/bash

color=red
echo ${color^^}

color=BLUE
echo ${color,,}
```

## примеры скриптов

Заменить в текущей директории названия файлов с .txt  на название без расширения

```bash
#!/bin/bash

for i in *txt
do
    mv $i ${i%.*}
done    
```

# Примеры использования ext globing 

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

# Численные вычисления

## Операции с целыми числами

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
## Операции с дробными числами

## bc - утилита для дробных вычислений

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

## Полезные утилиты для вычислений

разложение на простые множители `factor`
```bash
factor 3444 
```
output: `3444: 2 2 3 7 41`

## Примеры скриптов

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

# Ветвление


## if

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
## case

Если ответ на вопрос yes или oui пишем nice, если ответ no пишем no, иначе пишем okay.
```bash
#!/bin/bash

echo are you good?
reed GOOD
GOOD=$(echo $GOOD | tr [:upper:] [:lower:])

case $GOOD in
yes|oui)
  echo nice
  ;;
no)
  echo not nice
  ;;
*)
  echo okay
  ;;
esac
```


# Циклы

## for

Итерируемся по массиву, либо по списку файлов.

однострочный цикл бежит по всем аргументам скрипта
```bash
for i in $@; do echo $i; done
```

сделаем хитрый массив range и проитерируемся по нему
```bash
for i in {115..127}; do echo $i; done
```

сделаем на основе цикла пинг
```bash
for i in {115..127}; do ping -c 1 192.168.0.$i; done
```

```bash
for i in anna liza andrey
do
  grep $i /etc/passwd > /dev/null 2>&1 || echo $i user does not exist
done  
```

```bash
#!/bin/bash

if [ -z $1]
then
  echo you have to provide at least one argument
  exit 3
fi

MEMFREE=$(free -m | grep Mem | awk '{ print $4 }')

if [ $MEMFREE -lt 256 ]
then
  echo insufficient memory available
  exit 4
fi

sudo apt install -y "$@"

for s in "$@"
do
  sudo systemctl enable --now $s
done  
```


## while

```bash
while true; do true; done
```

```bash
while true 
do 
  echo true 
done
```

```bash
#!/bin/bash

COUNTER=$1
COUNTER=$(( COUNTER * 60))

minusone(){
  COUNTER=$(( COUNTER - 1))
  sleep 1
}

while [ $COUNTER -gt 0 ]
do
  echo you still have $COUNTER seconds left
  minusone
done  

[ $COUNTER = 0] && echo time is up && minusone
[ $COUNTER = "-1" ] && echo you now are one second late && minusone

while true
do
  echo you now are ${COUNTER#-} second late
  minusone
done  
```

## until (oposite while)

```bash
until who | grep $1; do echo $1 in not logged in; done
```

```bash
until who | grep $1
do 
  echo $1 in not logged in
 done
```

## break and contiunue

```bash
#!/bin/bash

# backup script that stops if insufficient disk space is available

if [ -z $1 ]
then
	echo enter the name of a directory to back up
	read dir
else
	dir=$1
fi

[ -d ${dir}.backup ] || mkdir ${dir}.backup

for file in $dir/*
do
	used=$( df $dir | tail -1 | awk '{ print $5 }' | sed 's/%//' )
	if [ $used -gt 98 ]
	then
		echo stopping: low disk space
		break
	fi

	cp $file ${dir}.backup
done
```

```bash
#!/bin/bash

# convert file names to lower case if required

FILES=$(ls)

for file in $FILES
do
	if [[ "$file" != *[[:upper:]]* ]]; then
		echo "$file" doesn\'t contain uppercase
		continue
	fi

	OLD="$file"
	NEW=$(echo $file | tr '[:upper:]' '[:lower:]')

	mv "$OLD" "$NEW"
	echo "$OLD has been renamed to $NEW"
done
```

# Menu

```bash
#!/bin/bash

PS3='Enter your choice: '
options=("Option 1" "Option 2" "Option 3" "Quit")

select opt in "${options[@]}"
do
	case $opt in
		"Option 1")
			echo "you have selected option 1"
			;;
		"Option 2")
			echo "you have selected option 2"
			;;
		"Option 3")
			echo "you have selected $REPLY with is $opt"
			;;
		"Quit")
			break
			;;
		*) echo "invalid option $REPLY";;
	esac
```  

![menu](images/menu_1.png)

- Control C to interrupt.

# trap

Use to catch information about signals (exeprt -9).

For help `man 7 signal` and `trap -l`

```bash
#!/bin/bash
trap "echo ignoring signal" SIGINT SIGTERM
echo pid is $$

while :
do
	sleep 60
done
```
`EXIT` for normal exit. 
```bash
#!/bin/bash
tempfile=/tmp/tmpdata
touch $tempfile
ls -l $tempfile
trap "rm -f $tempfile" EXIT
```

# Arrays

Let's compare. We want to copy list of files to directory. With simple string it will not work with names with spaces.

```bash
files=$(ls *.doc); cp $files ~/backup
```
but with array it will work
```bash
files=(*.txt); cp "${files[@]}" ~/backup
```

## Types of arrays:
- indexed array.
  - do not required using `declare`
  - `my_array=(one two three)` 
  - don't confuse with command substitution. `myname=$(whoami)`
- associative array. 
  - ` declare -A`
  - key value
  - reference to one value of such array `${value[XYZ]}`
  - ordering is not guaranteed

## Reference to arrya values

> always use quotes. 

- Reference to All elements in the array.
  ```bash
  "${myarray[@]}"
  ```
- Reference to second element
  ```bash
  "${myarray[1]}"
  ```
- Reference to all keys in array
  ```bash
  "${!myarray[@]}"
  ```

## Example script indexed array

```bash
  #!/bin/bash
my_array=( a b c )

# print index value 1
echo ${my_array[1]}

# print all items in the array
echo ${my_array[@]}
echo ${my_array[*]}

# print all index values and not their value
echo ${!my_array[@]}

# print the length of the array
echo ${#my_array[@]}

# loop over all items in the array; printing all keys as well as all values
for i in "${!my_array[@]}"
do
	echo "$i" "${my_array[$i]}"
done

# loop on just the values and not the keys
for i in "${my_array[@]}"
do
	echo "$i" 
done

# adding a value at a specific position
# using 9 to make sure it is last
my_array[9]=d
echo ${my_array[@]}
echo ${my_array[9]}

# adding items to the end of the array, using the first available index
my_array+=( e f )
for i in "${!my_array[@]}"
do
        echo "$i" "${my_array[$i]}"
done
```

![](images/array_1.png)

## Example of associative array

```bash
declare -A my_array

my_array=([value1]=cow [value2]=sheep)
```

## Reading output to an array

- `mapfile`
```bash
mapfile -t my_array <<(my_command)
```

- `cycle with IFS and read`

```bash
my_array=()
while IFS= read -r line; do
  my_array+=( "$line")
done < <(my_command)
```

- `readarray`

```bash
readarray -t my_array < <(seq 5)
declare -p my_array # print array
# output: declare -a my_array=([0]="1" [1]="2" [2]="3" [3]="4" [4]="5" )
```

```bash
readarray -t myfiles < <(ls)
declare -p myfiles  # print array
```

with `cycle` 

```bash
#!/bin/bash

# scanning hosts on $NETWORK
echo enter the IP address of the network that you want to scan for available hosts
read NETWORK

# enabling some debugging so that we see what happens
set -x 
hosts=()
# below IFS is set at the same line as the read statement to make sure it affects the read statement only
# IFS is set to a space to make sure that as long as it finds a space after an item the script continues
while IFS= read -r line; do
	hosts+=( "$line" )
done < <( nmap -sn ${NETWORK}/24 | grep ${NETWORK%.*} | awk '{ print $5 }')
set +x

# the two lines below are for debugging only
echo press enter to continue
read

# and here we check that the array works as intended
for value in "${hosts[@]}"
do
	echo $value
```

with `mapfile`

```bash
#!/bin/bash

# generating SSH key for local user
[ -f /etc/.ssh/id_rsa ] || ssh-keygen

# scanning hosts on $NETWORK
echo enter the IP address of the network that you want to scan for available hosts
read NETWORK

# you can fill an array with command output in two ways. The lines below are not as efficient but also work
#hosts=()
#while IFS= read -r line; do
#	hosts+=( "$line" )
#done < <( nmap -sn ${NETWORK}/24 | grep ${NETWORK%.*} | awk '{ print $5 }')

# alternative notation
mapfile -t hosts < <(nmap -sn ${NETWORK}/24 | grep ${NETWORK%.*} | awk '{ print $5 }')

# this line shows debug information; useful while developing but can be removed now
for value in "${hosts[@]}"
do
	echo $value
done

PS3='which host do you want to setup? (Ctrl-C to quit) '
select host in "${hosts[@]}"
do
	case $host in
		*)
			echo you selected $host
			set -v
			ssh-copy-id root@$host
			scp /etc/hosts root@$host:/etc
			set +v
			echo this is enough for the proof of concept script
			;;
	esac

done
```

## Looping on array

```bash
#!/bin/bash
# poem.sh: Pretty-prints one of the ABS Guide author's favorite poems.
# credits: TLDP Advanced Bash Scripting Guide

# Lines of the poem (single stanza).
Line[1]="I do not know which to prefer,"
Line[2]="The beauty of inflections"
Line[3]="Or the beauty of innuendoes,"
Line[4]="The blackbird whistling"
Line[5]="Or just after."
# Note that quoting permits embedding whitespace.

# Attribution.
Attrib[1]=" Wallace Stevens"
Attrib[2]="\"Thirteen Ways of Looking at a Blackbird\""
# This poem is in the Public Domain (copyright expired).

echo

tput bold   # Bold print.

for index in 1 2 3 4 5    # Five lines.
do
  printf "     %s\n" "${Line[index]}"
done

for index in 1 2          # Two attribution lines.
do
  printf "          %s\n" "${Attrib[index]}"
done

tput sgr0   # Reset terminal.
            # See 'tput' docs.

echo

exit 0
```

## Lab about arrays

```bash
#!/bin/bash

# use readarray to create the associative names
echo enter names for Janitors from Mon-Sun \(seven names required\)
read name1 name2 name3 name4 name5 name6 name7

declare -A roster
roster[monday]=$name1
roster[tuesday]=$name2
roster[wednesday]=$name3
roster[thursday]=$name4
roster[friday]=$name5
roster[saturday]=$name6
roster[sunday]=$name7

# print the names of responsible janitors for each day
for i in "${!roaster[@]}"
do
	echo "$i" "${roster[$i]}"
done
```

with order array
```bash
#!/bin/bash

# use readarray to create the associative names
echo enter names for Janitors from Mon-Sun \(seven names required\)
read name1 name2 name3 name4 name5 name6 name7

declare -A roster; declare -a order
roster[monday]=$name1; order+=( "monday" )
roster[tuesday]=$name2; order+=( "tuesday" )
roster[wednesday]=$name3; order+=( "wednesday" )
roster[thursday]=$name4; order+=( "thursday" )
roster[friday]=$name5; order+=( "friday" )
roster[saturday]=$name6; order+=( "saturday" )
roster[sunday]=$name7; order+=( "sunday" )

# print the names of responsible janitors for each day
for i in "${order[@]}"
do
	echo "$i" "${roster[$i]}"
done
```

# Best Practises

- Starting with comments line
- Write and test each part of the script separately
- Use break lines
- use `set -x` and `set +x` to debug section. It's useful to dot degug all parts of scripts.
- use combination `echo just added the user press enter` and `read` to a problematic areas

## Using BASH_XTRACEFD for debug



```bash
#!/bin/bash

# Use FD 15 to capture the debug stream caused by "set -x". Mo magic in 15 nubmer, it's just more then 0 1 and 2 like stdin and etc.
exec 15>/tmp/bash-debug.log
# Tell bash about it  (there's nothing special about 15, its arbitrary)
export BASH_XTRACEFD=15

# turn on debugging:
set -x

# run some commands:
cd /etc
find 
echo "that was it"

# Close the debugging:
set +x

# Close the file descriptor
exec 15>&-

# See what we got:
cat /tmp/bash-debug.log
```

# Complex scripts

## trivial restart if service down

```bash
#!/bin/bash
#
# Monitoring process
#
COUNTER=0
while ps aux | grep $1 | grep -v grep | grep -v $0 > /dev/null
do
	COUNTER=$((COUNTER+1))
	sleep 1
	echo COUNTER is $COUNTER
done

logger HTTPMONITOR: $1 stopped at `date`
systemctl start $1
```

## check users are created

```bash
#!/bin/bash

# RHCSA labs grading script - SvV
# version 0.1

# verify password settings
grep 'PASS_MIN_LEN      6' /etc/login.defs >/dev/null 2>&1 || echo you did not set minimal password length to 6
grep 'PASS_MAX_DAYS     90' /etc/login.defs >/dev/null 2>&1 || echo max password validity is not set to 90 days

# verify new users
for i in anna audrey linda lisa
do
        grep $i /etc/passwd >/dev/null 2>&1 || echo user $i does not exist
done

#verify new file in user homedirs
for i in anna audrey linda lisa
do
        ls /home/$i/newfile >/dev/null 2>&1 || echo no newfile in $i home directory
done

# verify user group membership
id anna | grep profs >/dev/null 2>&1 || echo anna is not a member of group profs
id audrey | grep profs >/dev/null 2>&1 || echo audrey is not a member of group profs
id linda | grep sales >/dev/null 2>&1 || echo linda is not a member of group sales
id lisa | grep sales >/dev/null 2>&1 || echo lisa is not a member of group sales

# check that accounts linda and lisa are locked
passwd -S linda | grep locked >/dev/null 2>&1|| echo user linda password is not locked
passwd -S lisa | grep locked>/dev/null 2>&1 || echo user linda password is not locked

# evaluate passwords for anna and audrey
sshpass -p "password" ssh -o StrictHostKeyChecking=no anna@localhost exit >/dev/null 2>&1 || echo password for anna not set correctly
sshpass -p "password" ssh -o StrictHostKeyChecking=no audrey@localhost exit >/dev/null 2>&1 || echo password for audrey not set correctly

echo grading completed
```

## install kube cluster

```bash

#!/bin/bash
#
# verified on Fedora 31, 33 and Ubuntu LTS 20.04

echo this script works on Fedora 31, 33 and Ubuntu 20.04
echo it does NOT currently work on Fedora 32
echo it requires the machine where you run it to have 6GB of RAM or more
echo press Enter to continue
read

##########
echo ########################################
echo WARNING
echo ########################################
echo Nov 2020 - currently this script is NOT supported on Mac OS Big Sur
echo I will communicate here one Apple/VMware have provided updates that make it work again
echo
echo Check the Setup Guide provided in this repository for alternative installations
echo
echo press Enter to continue
read

# setting MYOS variable
MYOS=$(hostnamectl | awk '/Operating/ { print $3 }')
OSVERSION=$(hostnamectl | awk '/Operating/ { print $4 }')

egrep '^flags.*(vmx|svm)' /proc/cpuinfo || (echo enable CPU virtualization support and try again && exit 9)

# debug MYOS variable
echo MYOS is set to $MYOS

#### Fedora config
if [ $MYOS = "Fedora" ]
then
	if [ $OSVERSION = 32 ]
	then
		echo Fedora 32 is not currently supported
		exit 9
	fi
	
	sudo dnf clean all
	sudo dnf -y upgrade

	# install KVM software
	sudo dnf install @virtualization -y
	sudo systemctl enable --now libvirtd
	sudo usermod -aG libvirt `id -un`
fi

### Ubuntu config
if [ $MYOS = "Ubuntu" ]
then
	sudo apt-get update -y 
	sudo apt-get install -y apt-transport-https curl
	sudo apt-get upgrade -y
	sudo apt-get install -y qemu-kvm libvirt-daemon-system libvirt-clients bridge-utils

	sudo adduser `id -un` libvirt
	sudo adduser `id -un` kvm
fi

# install kubectl
curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl
chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/kubectl

# install minikube
echo downloading minikube, check version
curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64

sudo chmod +x minikube
sudo mv minikube /usr/local/bin

# start minikube
minikube start --memory 4096 --vm-driver=kvm2

echo if this script ends with an error, restart the virtual machine
echo and manually run minikube start --memory 4096 --vm-driver=kvm2
```

