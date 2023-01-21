- [Конфигурация](#конфигурация)
  - [Просмотр](#просмотр)
  - [Редактирование и добавление](#редактирование-и-добавление)
  - [Редактор](#редактор)
  - [Добавление proxy сервера](#добавление-proxy-сервера)
  - [Ccылки на команды (Alias)](#ccылки-на-команды-alias)
  - [Автокоррекция команд](#автокоррекция-команд)
  - [Игнорирование файлов.](#игнорирование-файлов)
    - [пример файла `.gitignore`](#пример-файла-gitignore)
- [Работа с репозиторием](#работа-с-репозиторием)
  - [Инициализация репозитория на клиенте init](#инициализация-репозитория-на-клиенте-init)
  - [Инициализация репозитория на сервере init](#инициализация-репозитория-на-сервере-init)
    - [Преобразование обычного репозитория в пустой](#преобразование-обычного-репозитория-в-пустой)
  - [Получение репозитория с сервера Clone](#получение-репозитория-с-сервера-clone)
  - [Просмотр состояния репозитория. Status](#просмотр-состояния-репозитория-status)
    - [Добавление в Staging Area. Add](#добавление-в-staging-area-add)
  - [Фиксация commit](#фиксация-commit)
  - [Публикация **push**](#публикация-push)
  - [Правки комитов.](#правки-комитов)
  - [Отмена изменений, отмена комитов](#отмена-изменений-отмена-комитов)
    - [Отмена последовательных комитов и индекса reset](#отмена-последовательных-комитов-и-индекса-reset)
    - [Отмена комита в середине дерева](#отмена-комита-в-середине-дерева)
  - [Ветвление](#ветвление)
    - [Создание и переключение веток](#создание-и-переключение-веток)
    - [Удаление ветки](#удаление-ветки)
    - [Переименование ветки](#переименование-ветки)
  - [PULL --rebase](#pull---rebase)
  - [Слияние веток.](#слияние-веток)
    - [merge](#merge)
    - [Rebase](#rebase)
    - [Ручное разрешение конфликтов](#ручное-разрешение-конфликтов)
    - [Где хранятся конфликты?](#где-хранятся-конфликты)
    - [Стратегии слияния](#стратегии-слияния)
  - [Диагностика](#диагностика)
    - [Посмотреть список веток](#посмотреть-список-веток)
    - [просмотр логов](#просмотр-логов)
    - [Просмотр изменений](#просмотр-изменений)
  - [Соединение с удаленным репозиторием](#соединение-с-удаленным-репозиторием)
  - [Автодополнение](#автодополнение)
  - [Чистка](#чистка)
    - [Чистка веток](#чистка-веток)
    - [Чиста дерева файлов](#чиста-дерева-файлов)
    - [Stashing](#stashing)
    - [Теги](#теги)
    - [Cherry pick](#cherry-pick)
    - [Обьекты в Git](#обьекты-в-git)
      - [Как гит сохраняет связанность истории?](#как-гит-сохраняет-связанность-истории)
      - [Как гит хранит обьекты?](#как-гит-хранит-обьекты)
  - [Архивирование](#архивирование)
  - [The seven rules of a great Git commit message](#the-seven-rules-of-a-great-git-commit-message)


# Конфигурация

Существуют несколько уровней конфигураций:
- **local** - файл в текущей директории с репозиторием `.git/config`
- **global** - файл в домашней директории пользователя `~/.gitconfig`
- **system** - файл настроек для всех пользоватаелей `/etc/gitconfig`

## Просмотр
Посмотреть лист всех настроек
```
git config --list 
```

Также можно ограничить конкретным уровнем. Уровни смотри выше
```
git config --list --local 
```

## Редактирование и добавление

Можно редактировать каждый параметр по отдельности так:
```
git config --{local,global,system} parameter_name value
```

```
git config --global user.name my_name&
git config --global user.email test@email.com
```
Можно открыть весь файл для правки в редакторе настроек определенного уровня
```
git config --global --edit  
```

## Редактор
Открывается в момент формирования сообщения о комите.

Установка текстового редактора для всех пользователей через команду
```
git config --system core.editor some_editor_from_the_list
```

Можно также его указать через переменные окружения GIT_EDITOR, EDITOR, или VISUAL


## Добавление proxy сервера

```
git config --global http.proxy http://proxyuser:proxypwd@proxy.server.com:8080
```

## Ccылки на команды (Alias)

Можно добавить ссылку на сложную команду и последовательность команд или даже составную.
```
$ git config --global alias.cp cherry-pick
```
в файле установить, обратить внимание на `!` это для chain команд.
```
[alias]
setup = "!git init; git add .; git commit"
```

## Автокоррекция команд

Указывается сколько десятых секунды нужно подождать прежде чем применить скорректированную команду. Можно отменить через Ctrl + C
```
$ git config --global help.autocorrect 10  
```

Пример использования:
```
$ git chekcout

WARNING: You called a Git command named 'chekcout', which does not exist.

Continuing under the assumption that you meant 'checkout'

in 1.0 seconds automatically...
```

## Игнорирование файлов.

Есть несколько мест, где можно указать какие файлы будут игнорированы

1. `.gitignore` файл внутри репозитория
2.  `git/info/exclude` на уровне репозитория
3.  Глобальные настройки `git config --global core.excludesfile ~/.gitignore`

### пример файла `.gitignore`  
  
```  
# комментарий — эта строка игнорируется  

# не обрабатывать файлы, имя которых заканчивается на .a  
*.a  
# НО отслеживать файл lib.a, несмотря на то, что мы игнорируем все .a файлы с помощью предыдущего правила  
!lib.a  
# игнорировать только файл TODO находящийся в корневом каталоге, не относится к файлам вида subdir/TODO  
/TODO  
# игнорировать все файлы в каталоге build/  
build/  
# игнорировать doc/notes.txt, но не doc/server/arch.txt  
doc/*.txt  
# игнорировать все .txt файлы в каталоге doc/  
doc/**/*.txt
```
# Работа с репозиторием

## Инициализация репозитория на клиенте init

Инициализация репозитория в текущей директории
```
git init
```

Создать репозитори в указанной директории. Если такой директории нет, она будет создана. Создается `.git`. 
```
git init directory
```

Создать репозиторий добавить содержимо текущей папки в индекс и сделать комит
```
git init
git add .
git commit -m 'Begin Project Foo!'
```


## Инициализация репозитория на сервере init

пустой репозиторий не предполагающий наличие содержимого в текущей папке. 
```
git init --bare directory
```

Принято репозиторий заканчивать с названием `.git`

```
git init --bare NewRepository.git
```

### Преобразование обычного репозитория в пустой

Может случиться, что вы начнете работать над проектом в локальном хранилище, а затем почувствуете необходимость переместить его на централизованный сервер, чтобы сделать его доступным для других людей или из других мест.
Вы можете легко преобразовать обычный репозиторий в пустой, используя команду `git clone` с той же опцией `--bare`
```
git clone --bare my_project my_project.git
```

## Получение репозитория с сервера Clone

Получение кода из удалённого репозитория.
```
git clone repo directory
```

## Просмотр состояния репозитория. Status

В пустом репозитории.

```
git status  

# On branch master  
nothing to commit, working directory clean
```


Если присутствуют новые файлы в каталоге

```
git status  

# On branch master  
# Untracked files:  
#   (use "git add file..." to include in what will be committed)
```

Если были добавлены новые файлы командой `add`
```
$ git status  
# On branch master  
# Changes to be committed:  
#   (use "git reset HEAD file..." to unstage)  
#  
#   new file:   READM
```

### Добавление в Staging Area. Add

Команда добавляет файл как blob обьект, если файл новый или изменился, добавляет запись в индекс для следующего комита.
```
git add file
```

добавление директории
```
git add directory
```


Добавить все измененные файлы и удаленные файлы. Если файл новый, то он не добавится в индекс и в хранилище
```
git add -u
```

Добавить все файлы в индекс и в хранилище
```
git add -A
```

Удаление файлов
```
git rm filename1 filename2
```

1. Ставит в индексе пометку, что при следующем комите файл удаляется
2. Удаляет физически файл с диска


Переименование файлов
```
git mv oldfilename newnfileame
```

1. mv foo bar переименовывает файл на уровне файловой системы
2. git add bar добавляет файл в индекс как новый


## Фиксация commit

Делает комит изменений занесенных в индекс. Запускает текстовый редактор, в котором нужно ввести описание изменений и сохранить файл.
```
git commit
```

передача описания комита без открывания редактора
```
commit -m "message"  
```

фиксация с добавлением в индекс
```
git commit -a
```
Эквивалентно (добавляем в индекс все изменения и удаления находящихся под версионным контролем и делаем комит)
```
git add -u  
git commit
```

Добавляет в сообщение diff изменений
```
git commit -v 
```

> Git не может хранить пустые директории. Он создает их только, если внутри директории есть файлы.

Рекомендуемый паттерн комита:

1. `git add` (with various options) зафиксировать изменения в индексе файлов, которые хочется включить в комит
2. `git stash --keep-index` Сохраняет изменения, которые не добавлены в индекс и откатывает их для текущего дерева.
3. Проверяем что фича работает, проект собирается
4. `git commit`
5. `git stash pop` для восстановления сделанных изменений, но не вошедших в прошлый комит

## Публикация **push**

Отправить в ветку в удаленный репозиторий, если это ветка уже есть в удаленном репозитории
```
git push origin branch_name
```

Публикация новой ветки, которой еще нет в удаленном репозитории
```
git push -u origin new
```

Публикация с переименованием ветки.
```
git branch -m old new
git push -u origin new
git push origin :old
```

## Правки комитов.


Если необходимо поправить в последнем комите делаем изменения , добавляем в индекс и выполняем, гит предложил также изменить сообщение
```
git commit --amend
```

Если никаких изменений не было, все равно можно поправить сообщение комита либо написать новое через
```
git --amend -m message
```

Сообщение можно и не менять и взять из предыдущего
```
git --amend -C HEAD
```


## Отмена изменений, отмена комитов

### Отмена последовательных комитов и индекса reset

Отменяет все изменения в индексе для следующего комита. Сбрасывает `add`
```
git reset
```

Команда отменяет последний комит и меняет working tree и индекс. В отличие от `git reset` которая сбрасывает только индекс. Команда смещает указатель HEAD. При этом комит остается в истории (локальной)

Но его также можно вернуть через reflog
```
git reset HEAD~  или HEAD~0
```

Тут число означает сколько комитов отменить.

Опции:

- `--mixed` по умолчанию. не трогает файлы, только отменяет индекс. Файлы остаются в working tree.
- `--soft`  не трогают файлы, индекс остается. Удобно, если нужно объединить неплохо комитов в один.
- `--merge`
- `--hard`  возвращает файлы как были в комита и сбрасывает индекс.

Также можно откатить на хеш комита. Например
```
 git reset 2daa99c --soft    
```

### Отмена комита в середине дерева

Отмена комита, указывается его хэш
```
git revert 9c6a1fad
```

Могут возникнуть конфликты.

При этом формируется комит отменяющий предыдущий комит. 

Если не хотим, чтобы оставались в истории отмены комитов (revert commit), Можно просто вернуть `git reset --soft` после `revert` на комит более ранний, при этом сформируется индекс, в котором не будет лишних файлов, которые мы ревертнули и сформировать уже нормальный комит.


## Ветвление

### Создание и переключение веток
Показывает на какой ветке сейчас находимся
```
git branch
```

Создает ветку от текущего комита. Но не переставляте указатель HEAD  на нее
```
git branch branch_name
```

Создать ветку dev и переключить HEAD на нее.
```
git checkout -b dev
```

Можно указывать хеш комита или имя ветки для переключения.

Если переключились на комит, в котором не было ветки, будет в состоянии отсоединнной HEAD, т.к HEAD указывает на комит без ветки.

Если подкачали изменения из удаленного репозитория, но не создали локальную ветку. Переключиться на ветку не получится, будет выведена ошибка, что такая ветка не существует. Для этого делаем вот это.
```
git checkout -b feat_branch origin/feat_branch
```

можно и короче. 
```
git checkout -t origin/feat_branch
```
### Удаление ветки 

удалить ветку
```
git branch -d simon 
```

Возможны предупреждения о том, что комиты принадлежащие этой ветке не входят ни в какую другую ветку и окажутся недостижимыми после ее удаления.  Можно форсить удаление опцией `-D`

удаление remote ветки
```
git push origin :simon 
```

Или так 
```
git push --delete origin siman
```

### Переименование ветки
```
git branch -m old new 
```


## PULL --rebase

Когда выполняем `pull` и удаленная ветка ушла вперед всегда появляется в истории комит merge. Например:
```
git pull

$ git log --graph --oneline
* 2ee20b94 (master, origin/master) Merge branch…
|\
| \* 3307465c the final word
* | baa699bc not quite
|/
* 3a9ee5f3 in principio
```

Можно обновить ветку так, чтобы избежать `merge`. При этом Git сформирует другие комиты, но история будет ровная
```
git pull --rebase

* 1e6f2cb2 the final word
* baa699bc not quite
* 3a9ee5f3 in principio
```

![](images/image16.png)

## Слияние веток.

### merge

Типичный паттерн слияния
```bash 
git checkout -b feature # Создаем ветку для фичи
git commit -am "must save brilliant thoughts" # Делаем изменения и комитим
git checkout master
git merge feature  
```

Ветку с фичей можно иногда мерджить с главной веткой
```
git merge master
```

Если в состоянии конфликта, то можно просто отменить `merge`
```
git merge --abort
```

Если конфликты делаем так:

1. Правим файлы
2. `git add file`
3. `git commit`
4. Дальше git сформирует сообщение о merge
```
Merge branch 'floyd' into chandra
Conflicts:
moebius
```

5. Далее в логах увидим merge commit
```
git log --graph --oneline
* aeba9d85 (HEAD, chandra) Merge branch 'floyd' in…
|\
| * a5374035 (floyd) back in black
* | e355785d thanks for all the fish!
|/
* 50769fc9 star child
```


### Rebase

Можно не делать `merge` , можно делать `rebase`. Тогда комиты из другой ветки, которые отличаются применятся к текущей ветки.

Можно перемещать последовательность комитов из одного узла в другое начало.

Пример:

```
git branch nuts 0e8b5cf
git log --oneline --graph --decorate --all

* 6409527 (HEAD -> master) Add a grape
* 603b9d1 Add a peach
| * a8c6219 (melons) Add a watermelon
| * ef6c382 (berries) Add a blackberry
|/
* 0e8b5cf (nuts) Add an orange
* e4a5e7b Add an apple
* a57d783 Add a banana to the shopping list

git checkout nuts

Switched to branch 'nuts'

echo "walnut" >> shoppingList.txt
git commit -am "Add a walnut"

[master 3d3ae9c] Add a walnut
 1 file changed, 1 insertion(+), 1 deletion(-)

git log --oneline --graph --decorate --all

* 9a52383 (HEAD -> nuts) Add a walnut
| * 6409527 (master) Add a grape
| * 603b9d1 Add a peach
|/
| * a8c6219 (melons) Add a watermelon
| * ef6c382 (berries) Add a blackberry
|/
\* 0e8b5cf Add an orange
\* e4a5e7b Add an apple
\* a57d783 Add a banana to the shopping list

git rebase master

First, rewinding head to replay your work on top of it...
Applying: Add a walnut
Using index info to reconstruct a base tree...
M   shoppingList.txt
Falling back to patching base and 3-way merge...
Auto-merging shoppingList.txt
CONFLICT (content): Merge conflict in shoppingList.txt
Patch failed at 0001 Add a walnut
The copy of the patch that failed is found in: .git/rebase-apply/patch
When you have resolved this problem, run "git rebase --continue".
If you prefer to skip this patch, run "git rebase --skip" instead.
To check out the original branch and stop rebasing, run "git rebase --abort".
error: Failed to merge in the changes.
```

После устранения конфликтов нужно вызывать
```
git rebase -continue.
```

Если текущий шаг нужно пропустить и перейти к следующему 
```
git rebase -skip
```

Если вообще отменить  
```
git rebase -abort.
```

```
$ vi shoppingList.txt
```

![](images/image5.png)

```
git add shoppingList.txt
git rebase --continue

Applying: Add a walnut

git log --oneline --graph --decorate --all
* 383d95d (HEAD -> nuts) Add a walnut
* 6409527 (master) Add a grape
* 603b9d1 Add a peach
| * a8c6219 (melons) Add a watermelon
| * ef6c382 (berries) Add a blackberry
|/
* 0e8b5cf Add an orange
* e4a5e7b Add an apple
* a57d783 Add a banana to the shopping list
```

### Ручное разрешение конфликтов

При конфликтах можно выбрать один из вариантов
```
git checkout --{ours,theirs} file
```

Применится либо текущая версия, либо та версия с которой мерджимся

Далее можно порционно мерджить файлы через опцию `-p`

```
git checkout -p simple_message Example.java

diff --git b/src/main/java/app/Example.java a/src/main/java/app/Example.java
index e7147ed..8dba36a 100644

--- b/src/main/java/app/Example.java
+++ a/src/main/java/app/Example.java
@@ -14,9 +14,10 @@ import java.util.TimerTask;

 public class Example {
     public static void main(String[] args)  {

-        int b = 6;
         SpringApplication.run(Example.class, args);
-        int a = 4;
+        System.out.printf("");
+        System.out.printf("");
+        System.out.printf("");
     }
 }
 No newline at end of file
Apply this hunk to index and worktree \[y,n,q,a,d,s,e,?\]?

Чтобы вызвать справку надо написать ?

Apply this hunk to index and worktree \[y,n,q,a,d,s,e,?\]? ?

y - apply this hunk to index and worktree
n - do not apply this hunk to index and worktree
q - quit; do not apply this hunk or any of the remaining ones
a - apply this hunk and all later hunks in the file
d - do not apply this hunk or any of the later hunks in the file
s - split the current hunk into smaller hunks
e - manually edit the current hunk
? \- print help
```

Для удобства , если это возможно, следует вызывать `s split mode`. Тогда изменения будут спрашиваться порциями. Можно вручную отредактировать изменения через `e`.

### Где хранятся конфликты?

Важно понимать, что гит хранит текущее состояние конфликта в индексе. Сразу три файла появляется из общего предка двух веток (1) и двух веток (2 и 3)

```
git merge master

Auto-merging src/main/java/app/HelloController.java
CONFLICT (content): Merge conflict in src/main/java/app/HelloController.java
Automatic merge failed; fix conflicts and then commit the result.

git ls-files -s

100644 d05ba5b603e2e741afd94bb9d8a07ec52e3c7d59 0       Example.java
100644 ffd0852056fc3be0f87a2cae2252701864ae1c97 1       HelloController.java
100755 4fcb60a010b08445dffd08f3a1800158fb3f42f8 2       HelloController.java
100644 50167797a94fc22dd825b21cb0417b2403ee646f 3       HelloController.java
```

Также опцией `u` можно вывести не весь индекс, а только комиты с конфликтами

```
git ls-files -u

100644 ffd0852056fc3be0f87a2cae2252701864ae1c97 1       HelloController.java
100755 4fcb60a010b08445dffd08f3a1800158fb3f42f8 2       HelloController.java
100644 50167797a94fc22dd825b21cb0417b2403ee646f 3       HelloController.java
```

### Стратегии слияния

Оставляет только изменения в нашей ветке
```
git merge -s ours  
```

## Диагностика

### Посмотреть список веток

```
 git branch --all  

  dev
  fix_version
* master
  remotes/origin/fix_version
  remotes/origin/master
```

Более расширенный вариант

```
git branch -vv

  dev         ad25086 good file
  fix_version 9aff10b [origin/fix_version] some file in branch
* master      2daa99c \[origin/master\] gitignore modified
```


Показывает разную инфу о состоянии удаленного репозитория
```
git remote show origin

\* remote origin
  Fetch URL: dima@192.168.100.6:/opt/git/test-project.git
  Push  URL: dima@192.168.100.6:/opt/git/test-project.git
  HEAD branch: master
  Remote branches:
    fix_version tracked
    master      tracked
  Local branches configured for 'git pull':
    fix_version merges with remote fix_version
    master      merges with remote master
  Local refs configured for 'git push':
    fix_version pushes to fix_version (up to date)
    master      pushes to master      (up to date)
```

### просмотр логов

Показывает история комитов. Пробел - перейти на следующий экран. Q - выход
```
git log
```


Все комиты бранча topic , даже если мы находимся в другом бранче
```
git log topic
```


Все комиты в ветках alvin и simon
```
git log alvin simon
```

Все комиты в master, которых нету в my_branch
```
git log master..my_branch
```

Можно использовать тег, хеш комита или выражение например `master~3`, а также чтобы выделить группу комитов

--{branches,tags,remotes}[=pattern]   например 

```
git log --branches='foo*'
```


Удобно отображать логи одной строкой. `--oneline` вообще это укороченная форма  `--format=oneline`

Форматы могут быть разными.

![](images/image2.png)

Также логи можно смотреть о конкретном файле

```
git log ile
```

Ограничение в выводе кол-ва комитов
```
git log -n limit
```

Отбросить n комитов перед отображением лога
```
git log --skip=n
```

Грепать по автору . также можно комбинировать с or или and
```
--{author,committer}=regexp
```

```
git log --author=Richard --author=Booboo --committer=Felix
```


Грепать по сообщению комита
```
--grep=regexp
```

Просмотр лога изменений
```
git log --stat  Расширенный вид
```

Только имена измененных файлов
```
git log --name-status 
```

Изменения в каждом файле. Самый детализированный лог.
```
git log -p  
```

По-умолчанию не показывает изменения в mergе, но есть опции

- `-m` изменения в мерджах
- `-c` изменения в формате мерджа
- `-сс` только конфликты


Процент изменений в директориях
```
git log --dirstat
```

Искать комиты где были первый раз добавлена эта фраза
```
git log -S string 
```

Если добавить `--pickaxe-all`, покажутся все комиты где были изменения с этой фразой

В рамках одного автора схлопывает комиты. Удобно для сборки  release notes. Можно ограничить тегам историю. git shortlog v1.0..v1.1
```
git shortlog
``` 

> НЕ ЗАБЫВАЕМ что git log показывает комиты текущей ветки.

Удобно пользоваться такой командой
```
git log --all --graph --oneline
```

Очень удобная команда логов
```
git log --oneline --decorate --graph --all
```

Если комит поменяли,  но потом поняли, что что-то неправильно. Можно посмотреть так называемый reflog
```
git log -g   
```

```
$ git log -g
e674ab77 HEAD@{0}: commit (amend): Digital Restrictio…
965dfda4 HEAD@{1}: commit: Digital Rights Management
dd31deb3 HEAD@{2}: commit: Mozart
3307465c HEAD@{3}: commit: Beethoven
6273a3b0 HEAD@{4}: merge topic: Fast-forward
d77b78fa HEAD@{5}: checkout: moving from sol to master
6273a3b0 HEAD@{6}: commit: amalthea
2ee20b94 HEAD@{7}: pull: Merge made by the 'recursive…
d77b78fa HEAD@{8}: checkout: moving from master to sol
1ad385f2 HEAD@{9}: commit (initial): Anfang
```

Узнав Id отмеченного комита можно посмотреть его diff
```
git show 965dfda4
```
Или переключиться на этот комит
```
git checkout 965dfd
```

### Просмотр изменений

Показывает изменения, которые были сделаны, но еще не добавлены в индекс. Изменения между working tree и staged area (индексом)
```
git diff
```

Показывает изменения, которые были сделаны в том числе в добавленных в индекс файлах. Изменения между staged ared (индексом) и последним 
```
git diff --staged 
```

Изменения working tree и последним комитом
```
git diff HEAD 
```
![](images/image12.png)

Показывает построчное авторство в файле.
```
git blame file 
```
![](images/image19.png)


## Соединение с удаленным репозиторием

добавить remote репозиторий
```
git remote add origin  
```
```
git remote add origin user@github.com:/opt/REPO.git
```


Посмотреть что репозиторий записался в конфиг
```
git remote -v.  
```

Также можно изменить репозиторий
```
git remote set-url
git push -u origin master
```

## Автодополнение

Удобно прописать скрипт автодополнения названия веток

Скрипт можно взять отсюда

[https://github.com/git/git/blob/master/contrib/completion/git-completion.bash](https://www.google.com/url?q=https://github.com/git/git/blob/master/contrib/completion/git-completion.bash&sa=D&source=editors&ust=1670517050772023&usg=AOvVaw0xtTJdxLQ_ZWnkvkSNKFL9)

И прописать его в .bashrc
```
source ~/.git-completion.bash
```

## Чистка 

### Чистка веток

осмотреть какие ветки, есть в локальном репозитории и которые больше не присутствуют в глобальном репозитории
```
git remote prune origin --dry-run
```

и потом удалить
```
git remote prune origin 
```

### Чиста дерева файлов

Удаляет файлы, которые не находятся под версионным контролем (untracked files)
```
git clean  
```

опции:
- `--dry-run (-n)` покажет что будет удалено. Рекомендую использовать перед `git clean`
- `--exclude=pattern (-e)`  Исключение для удаления
- -d Удалит также и директории. По-умолчанию `git clean` не удаляет директории

### Stashing

Поместить изменения во временное хранилище
```
git stash
```

Опции:
- --keep-index Не откатывать изменения, которые уже были добавлены в индекс
- --include-untracked (-u)  Сохранить в том числе не находящиеся под версионным контролем файлы

помещаем в стеш все изменения под версионным котролем, которые не добавлены в индекс. При это новые файлы, которые еще не добавлены в индекс не трогаем.
```
git stash -u --keep-index 
```

применяет последний стеш и удаляет из стека стешей
```
git stash pop  
```

Посмотреть список стешей
```
git stash list
```

применяет последний стеш, но не удаляет из списка стешей, как `git pop`
```
git stash apply 
```

удаляет все стеши
```
Git stash clear 
```

удаляет конкретный стеш
```
Git stash drop [stash] 
```

показать конкретный стеш
Git stash show [stash]

### Теги

Два типа тегов:

* Reference. Хранятся как и ветки в ./git/refs  Есть подпапка tags

В отличие от веток, при комите теги остаются на месте, а ветка двигается на последний комит.

* Annotated tags. Полноценный обьект в Git (как blog, trees, commits)

Хранятся также в ./git/refs/tags но ссылаются не хеш комита, а на хеш обьекта тега, который уже в свою очередь ссылается на комит

Посмотреть список тегов в репозитории

git tag

Есть два типа тегов. Легкие, которые просто создают указатель на комит. И аннотированные, которые создает обьект тега в репозитори.

Легкие теги

git tag tagname \[commit\] По-умолчанию  commit = HEAD Так создадим легкий тег

Если не указывать -m -s -a

опции

--delete (-d)

Удалить тег

После создания тега, нужно отправить его в удаленный репозиторий

Git push origin my_tag

Отправить все теги

git push origin --tags

Удалить тег в удаленном репозитории

git push origin :tagname

### Cherry pick

Пример

* Создать 3 ветки веток с разным набором файлов, но один общий
* Добавить файл в одно ветке и сделать комит
* Поправить общий файл и сделать комит
* Перенести эти два комита в две ветки через cherry pick

Видим в ветке master два новых комита, Которые нужно перенести еще в две ветки, причем один комит добавляет новый файл, а другой редактирует файл. Который есть во всех ветках

Git checkout master

Git log

![](images/image6.png)

Для удобства выводим лог комитов в одну линию, чтобы скопировать более короткий хеш.

Git log --oneline

![](images/image9.png)

Копируем хеши нужные нам двух комитов и переходим на ветку date_message

Git checkout date_message

И применяем cherry-pick

git cherry-pick b0c07e5 7f6eda3

Посмотрим лог git log

видим , что комиты были дублированы. Причем это новые комиты, хеш у них другой, нежели был в master

![](images/image8.png)

Можно переносить с опцией x, тогда будут в комитах сообщения о том, что они были перенесены, при этом оригинальное сообщение сохранится.

git cherry-pick -x b0c07e5 7f6eda3

![](images/image13.png)

Также можно вывести git cherry-pick -e b0c07e5 7f6eda3

Тогда для каждого комита можно будет отредактировать сообщение.

Также можно комбинировать с x. Тогда будет возможность также отредактировать сообщение

![](images/image10.png)

Также можно не делать комит, а просто применить changeset к ветке.  Опция n

Это зачастую преимущество имеет, т.к надо бы протестировать полученный результат.

![](images/image3.png)

И так далее для всех веток.

Если конфликты, правим конфликты и вызываем git cherry-pick --continue

Если хотим отменить git cherry-pick --abort

### Обьекты в Git

4 типа обьектов: blog, trees, annotated tags, commits.

Посмотреть детали обьекта. Git cat-file -p  _хеш_

![](images/image15.png)

![](images/image18.png)

Хеш каждого обьекта считается через функцию, например

$ echo "banana" | git hash-object --stdin

637a09b86af61897fb72f26bfb874f2ae726db82

Этот хеш будет одинаковым на любой машине. Также он будет одинаковым для файлов с одинаковым контентом, но разным названием. Если храните 100 одинаковых файлов в разных в местах, в репозитории Git будет хранится только один файл.

#### Как гит сохраняет связанность истории?

![](images/image7.png)

У каждого комита есть ссылка на дерево, в котором могут быть деревья и блобы, а также ссылку на хеш предыдущего комита.

#### Как гит хранит обьекты?

Если зайдем в каталог .git/objects

Увидим там много папок, состоящие из двух символов. Это первые два символы кеша обьектов. В папках лежат обьекты с именем оставшейся части хеша. Обьекты упакованы библиотекой zlib

![](images/image1.png)

![](images/image20.png)

Удивительный факт для меня. Т.к Git хранит не дельты , а целые обьекты при изменении, казалось бы репозиторий должен иметь намного больший размер чем Svn. Но нет.

[https://git.wiki.kernel.org/index.php/GitSvnComparsion](https://www.google.com/url?q=https://git.wiki.kernel.org/index.php/GitSvnComparsion&sa=D&source=editors&ust=1670517050788032&usg=AOvVaw2J9cujIUfVvD558qDB9yZi)

Ссылка описывает, что размер репозитория Mozila за 10 лет уменьшился с 12 GB до 400 Mb.

Ссылки (ветки, стеши, теги)

В каталоге .git/refs лежат папки

![](images/image17.png)

В heads лежат файлы с именем ветки и содержанием - хеш на комит

![](images/image4.png)

Ветки всегда двигаются и указывают на последний комит. Если сделаем комит в ветке, указатель ветки сменится и будет указывать на новый комит.

Ссылка на текущее положение HEAD

Это указатель \- файл с именем текущего положения, лежит в .git/HEAD

![](images/image14.png)

HEAD также двигается если делаем комит.

Архивирование
-------------

Иногда нужно сделать бекап ветки или передать тому, у кого нет гита. Также можно сделать архив определенного комита. Все это поможет сделать команда

git archive master --format=zip --output=../repoBackup.zip

 git archive HEAD --format=zip --output=../headBackup.zip

Есть команда, которая включает в bundle полную версию репозитория, со всеми ветками. Удобна для переноса репозитория

$ git bundle create ../repo.bundle master

Вот так можно восстановить из бандла

$ cd /OtherComputer/Folder

$ git clone repo.bundle repo -b master

![](images/image11.png)

## The seven rules of a great Git commit message

![Article](https://cbea.ms/git-commit)

- Separate subject from body with a blank line
- Limit the subject line to 50 characters
- Capitalize the subject line
- Do not end the subject line with a period
- Use the imperative mood in the subject line
- Wrap the body at 72 characters
- Use the body to explain what and why vs. how