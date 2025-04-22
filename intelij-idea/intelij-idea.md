# Table of contents

- [Table of contents](#table-of-contents)
  - [Windows](#windows)
    - [Selection](#selection)
    - [Search](#search)
    - [Suggestions](#suggestions)
  - [Formatting](#formatting)
    - [Useful in distraction mode](#useful-in-distraction-mode)
    - [Navigation](#navigation)
    - [Edit](#edit)
    - [Copy paste](#copy-paste)
    - [Switch view mode](#switch-view-mode)
    - [Refactoring](#refactoring)
    - [VCS](#vcs)
    - [Run and Debug](#run-and-debug)
    - [Scratches](#scratches)
  - [Mac](#mac)
    - [General](#general)
    - [Navigation](#navigation-1)
    - [Caret navigation](#caret-navigation)
    - [Refactoring](#refactoring-1)
    - [Multiple carrets](#multiple-carrets)
    - [Tab operations](#tab-operations)
    - [Run](#run)
    - [Debug](#debug)
    - [Editing](#editing)
    - [Git](#git)
    - [Coding assistance](#coding-assistance)
    - [Usage](#usage)
    - [Find/replace](#findreplace)

## Windows

### Selection

- `Ctrl + Shift + Left / Right`  Select before the end of the word
- `Ctrl + W`    Select word, then method, then class
- `Ctrl + Shift + W` Decrease level of the selection (see `ctrl + w`)
- `Ctrl, Ctrl + Down` For multiple selection. 
- Multiple selection with a mouse
  - `Alt + Left Click and Down` one block 
  - `(Alt + Shift + Ctrl + Left Click ) multiple times` for multiple blocks
  - `Alt + Shift, Left Click, Left Click, Left Click..` To add multiple cursers in different places
- `Shift + Alt + Insert` Switch to and from a column mode selection. Then to select use Shift and Down. 
 
### Search

- `Ctrl + N`    Search a class
- `Ctrl + Shift + N` Search a file
- `Ctrl + Shift + F`  Search across the project
- `Double Shift`    generic search
- `Ctrl + Shift + A` Search some action. Just to insert some verbs you want to do

### Suggestions
- `Ctrl + Space`, `Alt + Enter`  get advice

## Formatting

- `Ctrl + Alt + L` Formatting
- `Ctrl + Alt + O`  Fix imports

### Useful in distraction mode
- `Ctrl + F12`  Open structure window

### Navigation

- `Escape`  Return to the editor
- `F12`  Return from the editor to the latest window
- `Ctrl + Z` Undo
- `Ctrl + Shift + Z` Redo
- `Alt + 1` Project window
- `Alt + 7` Structure window
- `Alt + 4` Run window
- `Alt + 2` Favorites window (to add file in favorites right click and select `add to favorites`)
- `Ctrl + E`    Show latest files
- `Ctrl + Shift + E` Show latest edited fragments
- `Ctrl + F4` Close tab
- `WIndow -> Editor Tabs -> Close Unmodifiable` Close tabs where there are no changes
- `Ctrl + Tab`  Open window to switch between tabs
- `Ctrl+Shift+F12`  Close/Open all windows except the editor
- `Ctrl + Shift + Alt + Arrow Keys` Change size of the current window
- `F4` or `Ctrl + B`  Go to source of the selected class or method. Go deep.
- `Ctrl + Alt + B`  Show list of implementation current selected interface, abstract class or method
- `Ctrl + H` Show window hierarchy of the current class or interface
- `Ctrl +` and `Ctrl -` Expand / collapse blocks of code
- `Alt + F1 then Project View` Show current file in the project structure
- `Ctrl + P` Show method arguments 
- `Ctrl+ Shift + BackSpace` Return to the latest change (may be to different file)
- `Ctrl + J`    Template window
- `Ctrl + Shift +  F7` Show current variable in current window. `F3` to the next item
- `Alt + F7` Show usage elsewhere
- `Ctrl + Alt + F7` Show usage in current window
- `Alt +  Home` Go to navigation bar
- `Alt + Button Down` If we in the project window this key open dropdown list to switch view 

### Edit

- `Ctrl + Shift + Up / Down` Move current row up or down. You can move block if you stay at the beginning. For example move whole method. Cool thing.
- `Ctrl + Alt + Shift + Left / Right`   Move argument to left or right
- `Ctrl+Shift+J`    Join with next row intelligently
- `Ctrl + /`    Single comment
- `Ctrl + Shift + /` Block comment  
- `Curl + Shift + U` Change register (uppercase and so on)

### Copy paste
- `Ctrl+ Shift + V` Paste from the history
- `Ctrl + Shift + C` Copy full path to a file
- `Ctrl + Shift + Alt + C`  Copy path to current row or method (you need to stay at the end of the row)
 
### Switch view mode
- `Ctrl + ` ` - Show popup to switch view mode.

### Refactoring

- `Ctrl + Alt + Shift + T` Show popup with refactoring options for current element
- `Shift + F6` Rename
  
### VCS
  
- `Alt + ` ` Show popup quick action for vcs
- `Ctrl + K`    Commit
- `Ctrl + T` Update
- `Ctrl + Shift + K` Push
 
### Run and Debug
  
- `Shift + F10` Run
- `Shift + F9` Debug
- `Ctrl + F8` Add breakpoint
- While in degug
  - `F7` Go inside (deep)
  - `F8` Go to next row
  - `Shift + F8`  Go to the level above
  - `F9` Go to the next breakpoint
  
### Scratches

- `Ctrl + Shift + Alt + Insert` Create scratch file
  
## Mac

[common keys](https://www.jetbrains.com/help/idea/reference-keymap-mac-default.html#multicaret)
  
### General

- commit view `Command 0`
- project view `Command 1`
- bookmarks view `Command 2`
- find view `Command 3` Seems not useful
- run view `Command 4`
- debug view `Command 5`
- problems view `Command 6`
- structure view `Command 7`
- services view `Command 8`
- git view `command 9`
- setting `Command ,`
- project structure `Command ;`
- create new in this directroy `Control Opt N`
- scratch file `Command Shift N`     

### Navigation

- Maximaze editor panel `Command Shift F12`
- Focus to editor from any window `Esc`
- Jump to the last active window `F12`
- Back `Command [`
- Forward `Command ]`
- Select Next  Tab `Command Shift ]`
- Select Previousp Tab `Command Shift [`
- Go to the previous changed line `Command Shift Delete`   
- go to class `Command O`
- Go to File... `Command Shift O`
- Go to Terminal `Opt F12`
- Recent Files `Command E`
- switcher for navigation `Control Tab`  + `Backspace` to delete items from tabs
- Jump to the navigation bar `Command UP`
- Change the IDE appearance `Control Tilda`
- Go to line `Command L`
- show current file in different views. `Opt F1`
- Go to declaration `Command B` or `F4` or `Command DOWN`
- Go to implementation `Command Opt B`
- Go to quick definition `Opt Space` or `Command Y`  use to show where is field or variable are declared or if it is class show source cod
- Go to type declaration `Command Shift B`. When you are on a variable and diffucult to know the type, 
- Go to super class or method `Command U`
- show pop up with file structure `command F12`
- show type hierarchy `Control H`
- go to next / previous highlited error `F2 / Shift F2`
- Create a bookmark `F3`
- Show all bookmarks `Command F3` also useful `Command 2` to show all 
- Create mnemonic bookmark `Opt F3`
- Go to mnemonic bookmark `Control key`
- Inspect current file `Opt Shift I`
- Open current file in new window `Shift F4`

### Caret navigation

- Next Previous Word `Opt Left/Right`   
- End or Finish of Line `Command Left/Right`    
- Move to brace `Command M`
- go to open close curly brackets (code block) `opt command []`
- go to next follow method `control shift UP DOWN`

### Refactoring

- Rename  `Shift F6` 
- Copy file `F5`
- Move file `F6`
- Inline code (put something together variables and methods) `Command Opt N`
- Extract method `Command Opt M`
- Extract variable `Command Opt V`
- Extract field `Command Opt F`
- Extract constant `Command Opt C`
- Extract parameter `Command Opt P`
- Refactor this `Control T`

### Multiple carrets

- Switch to column selection mode `Command Shift 8`
- Add carret above/down `Opt Opt UP/ DOWN`
- Add carret on each line in selection `Opt SHift G`
- Add carret to next finding. Just select something and then `Control G`
- Delete caret from last finding. `Control Shift G`
- Add curret to all findings. `Command Control G`

with mouse
- add carret `Opt Shift Click`
- drag and create multiple carrets `Opt Drag and Click`  
- multiple block carrets (many drags and click)  `Opt Drag and Click` and then `Command Opt Shift Drag and Click`

### Tab operations

- close tab `command W` 

### Run

- build project `Command F9` 
- compile and build selected module `Command Shift F9`
- select configuration to run `Control Opt R`
- select configuration to debug `Control Opt D`
- run current (test or runnable) from editor `Control Shift R`
- debug current (test or runnable) from editor  `Control Shift D`
- run prevous run config `Command R`    
- debug previous debug config `Command D`
- Stop `Command F2` 
  
### Debug

- Step over `F8` 
- Step into `F7`
- Smart step into. If we have several methods in oneline it is possible to choose, without it go to the first `Shift F7`
- Step up `Shift F8`. If we want to go to one up method. Without it we need steop over all lines till the end of method.
- Go to the cursor `Opt F9`
- Evaluate expression `Opt F8`
- Resume `F9`
- Create Delete Breakpoint `Command F8`
- SHow breakpoinsts `Command Shift F8` 

### Editing

- Comment `Command /` 
- Block comment `Command Opt /`
- Extend Selection `Opt UP/DOWN`
- Select till the end or start row `Command Shift Left/Right`
- Reformat Code `Command Opt L`
- Fix imports `Control Opt O`
- Fix indent for line `Control Opt I`
- Parameter info `Command P`
- quick documentation about class or method `F1` 
- Pop up short info using mouse `command + hover` 
- Generate (construct, getter, setter ...) `Command N`
- override method `Control O`
- implements method `Control I` 
- surround with template `Command Opt T`
- select deselect code `Opt UP/DOWN`
- paste from buffers `Command Shift V` 
- duplicate line or block `Command D`
- Delete line `Command Backspace`
- Delecte word `Opt Backspace`
- change case of current word `Command Shift U` 
- expand collaps block `Command +/-`
- expand collaps all `Command Shift +/-`
- collapse expand selection `Command .`
- Copy path `Command Shift C`
- Copy reference `Command Opt Shift C`
- Indent Selection `Tab`
- Undent line or selection `Shift Tab`
- move statement up/down `Command Shift UP/DOWN`

### Git

- Show pop up vcs actions `Control V` 
- view recent changes `Opt Shift C`
- Update project `Command T` <---------------->
- Reset changes in file `Command Opt Z`

### Coding assistance

- intention actions `Opt Enter`
- Basic Completion `Control Enter` Double press for searshing in not only current context. 
- Completion with filtering types. Type-Matching Completion. `Control Shift Enter`. Double press for searshing in not only current context. 

### Usage

- Show declaration and usages `Command B`,  `Opt F7`
- Go to implementaions `Command Opt B`
- Go to test `Command Shift T`
- Highlite in current file `Command Shift F7` then you can you `Command G` and `Shift Command G` to navigate

### Find/replace

- Find in current file `Command F`
- Go to next findings in file `Command G`
- Go to previous findings in file `Command Shift G`
- Replace in fine `Command R`
- Find in Files `Command Shift F`
- Replase in Files `Command Shift R`
- Find Actions `Command Shift A`
