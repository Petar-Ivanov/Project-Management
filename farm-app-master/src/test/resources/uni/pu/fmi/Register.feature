Feature: Регистрация на потребител

  Scenario Outline:
    Given Потребителя отваря екрана за регистрация
    When потребителя въвежда потребителско име <name>
    And потребителя въвежда потребителака парола "<password>"
    And потребителя въвежда потвърдена парола "<confirmPassword>"
    And потребителя въвежда имейл "<email>"
    And потребителя натиска бутона за регистрация
    Then визуализира се съобщение <message>
    Examples:
      | name                    | password  | confirmPassword | email      | message                              |  |
      | "iv"                    | testpass1 | testpass1       | test@a.com | "Името трябва да е между 3 20 букви" |  |
      | "ivanivanivanivanivan1" | testpass1 | testpass1       | test@a.com | "Името трябва да е между 3 20 букви" |  |
      | "pesho"                 | testpass1 | testpass1       | test       | "Електронната поща е невалидна"      |  |
      | "pesho"                 | testpass1 | testpass1       | testa.com  | "Електронната поща е невалидна"      |  |
      | "pesho"                 | testpass1 | testpass1       | test@a.    | "Електронната поща е невалидна"      |  |
      | "pesho"                 | testpass1 | testpass1       | test@a.com | "Успешна регистрация"                |  |
      | "pesho"                 | testpass  | testpass1       | test@a.com | "Паролите са различни"               |  |
      | "ivan"                  | testpass1 | testpass1       | test@a.com | "Заето име"                          |  |