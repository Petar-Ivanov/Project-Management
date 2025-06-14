Feature: Промяна на статуса на задача

  Scenario Outline: Успешна смяна на статус на задача
    Given потребителя отваря екарана за промяна на статус на задача
    When системата приема името на задачата "<taskTitle>"
    And системата приема името на потребителя "<userName>"
    And системата приема статус "<newStatus>"
    And потребителя натиска бутона за промяна на статуса на задачата
    Then визуализира се съобщение за сменен статус "Статусът е променен успешно"

    Examples:
      | taskTitle | userName | newStatus |
      | Task      | User     | To do     |
      | Task      | User     | Review    |
      | Task      | User     | Done      |

  Scenario Outline: Грешка при непопълнено задължително поле
    Given потребителя отваря екарана за промяна на статус на задача
    When системата приема името на задачата "<taskTitle>"
    And системата приема името на потребителя "<userName>"
    And системата приема статус "<newStatus>"
    And потребителя натиска бутона за промяна на статуса на задачата
    Then визуализира се съобщение за неуспешна смяна "<message>"

    Examples:
      | taskTitle | userName | newStatus | message                             |
      |           | User     | To do     | Моля, посочете заглавие на задача   |
      | Task      |          | To do     | Моля, посочете име на потребител    |
      | Task      | User     |           | Моля, посочете статус               |

  Scenario Outline: Грешка при неоткрит елемент или невалиден статус
    Given потребителя отваря екарана за промяна на статус на задача
    When системата приема името на задачата "<taskTitle>"
    And системата приема името на потребителя "<userName>"
    And системата приема статус "<newStatus>"
    And потребителя натиска бутона за промяна на статуса на задачата
    Then визуализира се съобщение за неуспешна смяна "<message>"

    Examples:
      | taskTitle | userName   | newStatus | message                             |
      | Task779   | Task       | To do     | Задачата не е открита               |
      | Task      | User778    | To do     | Потребителят не е открит            |
      | Task      | User       | Random    | Статусът не е валиден               |

  Scenario:
    Given потребителя отваря екарана за промяна на статус на задача
    When системата приема името на задачата "Task2"
    And системата приема името на потребителя "User"
    And системата приема статус "To do"
    And потребителя натиска бутона за промяна на статуса на задачата
    Then визуализира се съобщение за неуспешна смяна "Потребителя няма право да променя статусът"

