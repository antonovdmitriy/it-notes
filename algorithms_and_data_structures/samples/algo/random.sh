#!/bin/bash

# Если аргумент передан, используем его в качестве каталога; иначе используем текущий каталог
directory=${1:-.}

# Проверяем, существует ли указанный каталог
if [[ ! -d "$directory" ]]; then
    echo "Error: The specified directory does not exist."
    exit 1
fi

# Изменяем разделитель полей на символ новой строки
IFS=$'\n'

files=( $(find "$directory" -type f \( -iname "*.java"  \)) )

# Возвращаем разделитель полей обратно на пробел
unset IFS

# Проверяем, не пуст ли массив файлов
if [ ${#files[@]} -eq 0 ]; then
    echo "No book files found in the directory."
    exit 2
fi

# Выбираем случайный файл из массива
random_file="${files[$(( RANDOM % ${#files[@]} ))]}"

# Выводим полный путь к случайному файлу
echo "$random_file"
