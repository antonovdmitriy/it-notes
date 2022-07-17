# Тестирование

## Тесты нужны
Если нет тестов, нет уверенности, что изменения не сломают продукт.
Если тесты есть но грязные и плохие со временем цепочка: чем хуже тесты тем сложнее их рефакторить и править. Код продукта меняется и нужно постоянно править плохие тесты. Со временем эти правки занимают большую долю от времени разработки фичи. В конце концов от них отказываются или частично отказываются, чтобы не тормозить с выпуском фич. Далее нет никакой уверенности, что новые изменения в коде не сломают старый функционал. Появляется страх. Страх рефакторить код, чтобы не сломать рабочий код. Код начинает гнить. Нет регресса. Растет количество дефектов и недовольство клиентов. В итоге получаем грязный код, отсутствие тестов и недовольных клиентов.
**The moral of the story is simple: Test code is just as important as production code. It is not a second-class citizen. It requires thought, design, and care. It must be kept as clean as production code.**

По поводу одного асерта на тест:
I think the best thing we can say is that the number of asserts in a test ought to be minimized.

## Single Concept per Test F.I.R.S.T.

### Fast Tests should be fast.
They should run quickly. When tests run slow, you won’t want to run them frequently. If you don’t run them frequently, you won’t find problems early enough to fix them easily. You won’t feel as free to clean up the code. Eventually the code will begin to rot.

### Independent
Tests should not depend on each other. One test should not set up the conditions for the next test. You should be able to run each test independently and run the tests in any order you like. When tests depend on each other, then the first one to fail causes a cascade of downstream failures, making diagnosis difficult and hiding downstream defects.

### Repeatable

Tests should be repeatable in any environment. You should be able to run the tests in the production environment, in the QA environment, and on your laptop while riding home on the train without a network. If your tests aren’t repeatable in any environment, then you’ll always have an excuse for why they fail. You’ll also find yourself unable to run the tests when the environment isn’t available.

### Self-Validating
The tests should have a boolean output. Either they pass or fail. You should not have to read through a log file to tell whether the tests pass. You should not have to manually compare two different text files to see whether the tests pass. If the tests aren’t self-validating, then failure can become subjective and running the tests can require a long manual evaluation.
### Timely 
The tests need to be written in a timely fashion. Unit tests should be written just before the production code that makes them pass. If you write tests after the production code, then you may find the production code to be hard to test. You may decide that some production code is too hard to test. You may not design the production code to be testable.