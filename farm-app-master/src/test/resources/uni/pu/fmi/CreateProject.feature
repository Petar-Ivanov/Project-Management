Feature: Създаване на проект

  Scenario Outline: Успешно създаване на проект
    Given потребителя отваря екрана за създаване на проект
    When потребителя въвежда заглавие "<title>"
    And системата приема името на създателя "<creator>"
    And потребителя въвежда описание "<description>"
    And потребителя въвежда крайна дата "<date>"
    And потребителя натиска бутона за създаване на нов проект
    Then визуализира се съобщение за успех "<message>"

    Examples:
      | title     | creator | description          | date               | message                     |
      | Project70 | User    |                      |                    | Успешно създаден проект     |
      | Project70 | User    | Това е нов проект    |                    | Успешно създаден проект     |
      | Project70 | User    | Това е нов проект    | 2025-06-30 15:00   | Успешно създаден проект     |
      | Project70 | User    |                      | 2025-06-30 15:00   | Успешно създаден проект     |

  Scenario Outline: Грешка при липсващо заглавие и/или потребителско име
    Given потребителя отваря екрана за създаване на проект
    When потребителя въвежда заглавие "<title>"
    And системата приема името на създателя "<creator>"
    And потребителя натиска бутона за създаване на нов проект
    Then визуализира се съобщение за неуспех "<message>"

    Examples:
      | title     | creator | message                             |
      | Project70 | User99  | Потребителят не е открит            |
      |           | User    | Моля, въведете заглавие             |
      | Project70 |         | Липсва потребителско име            |
      |           |         | Липсват заглавие и потребителско име |

  Scenario Outline: Невалидна дължина на заглавие
    Given потребителя отваря екрана за създаване на проект
    When потребителя въвежда заглавие "<title>"
    And системата приема името на създателя "<creator>"
    And потребителя натиска бутона за създаване на нов проект
    Then визуализира се съобщение за неуспех "<message>"

    Examples:
      | title                                                                                                                                                                                                                                      | creator | message                     |
      | Pr                                                                                                                                                                                                                                         | User    | Късо заглавие!!!            |
      | hfgbcvdeqwgdcvdsxadfvhrtreqwhfgbcvdeqwgdcvdsxadfvhrtreqwhfgbcvdeqwgdcvdsxadfvhrtreqwhfgbcvdeqwgdcvdsxadfvhrtreqw | User    | Прекалено дълго заглавие!!! |

  Scenario: Невалидна дължина на описание
    Given потребителя отваря екрана за създаване на проект
    When потребителя въвежда заглавие "Project70"
    And системата приема името на създателя "User"
    And потребителя въвежда описание "hfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfrhfgvbdscxasdwqerfdsxzcvfr"
    And потребителя натиска бутона за създаване на нов проект
    Then визуализира се съобщение за неуспех "Прекалено дълго описание!!!"

  Scenario Outline: Невалидна крайна дата
    Given потребителя отваря екрана за създаване на проект
    When потребителя въвежда заглавие "<title>"
    And системата приема името на създателя "<creator>"
    And потребителя въвежда крайна дата "<date>"
    And потребителя натиска бутона за създаване на нов проект
    Then визуализира се съобщение за неуспех "Невалидна крайна дата"

    Examples:
      | title     | creator | date              |
      | Project70 | User    | 1925-06-30 15:00  |