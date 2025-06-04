Feature: Вход в системата

  Scenario: Вход в системата без име
    Given потребителя отваря екарана за вход
    When потребителя въвежда парола "123"
    And потребителя натиска бутона за вход
    Then визуализира се съобщение за грешка "Epic sadface: Username is required"

  Scenario: Вход в системата без парола
    Given потребителя отваря екарана за вход
    When потребителя въвежда име "ivan"
    And потребителя натиска бутона за вход
    Then визуализира се съобщение за грешка "Epic sadface: Password is required"

  Scenario: Вход в системата без име и парола
    Given потребителя отваря екарана за вход
    When потребителя натиска бутона за вход
    Then визуализира се съобщение за грешка "Epic sadface: Username is required"

  Scenario: Вход в системата валидни данни
    Given потребителя отваря екарана за вход
    When потребителя въвежда име "standard_user"
    And потребителя въвежда парола "secret_sauce"
    And потребителя натиска бутона за вход
    Then отваря се URL: "https://www.saucedemo.com/inventory.html"

  Scenario: Вход в системата невалидни данни
    Given потребителя отваря екарана за вход
    When потребителя въвежда име "ivan234"
    And потребителя въвежда парола "123"
    And потребителя натиска бутона за вход
    Then визуализира се съобщение за грешка "Epic sadface: Username and password do not match any user in this service"

