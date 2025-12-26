# Automation Tests - Practice Software Testing

## Description

This project contains automated tests for [Practice Software Testing](https://practicesoftwaretesting.com/). The tests are written using **Java**, **Selenium WebDriver**, **Cucumber**, and **JUnit**.  

The scenarios covered include:
- Registering a new account
- Adding products to the shopping cart
- Applying product filters and sorting
- Completing checkout with **Cash on Delivery** payment

> ⚠️ The tests are intentionally run slowly to allow visual tracking of actions on the website. This helps understand the flow and visually verify elements.

---

## Project Structure

- `pages/` - Page Object classes for each page: `MainPage`, `RegistrationPage`, `LoginPage`, `AccountPage`
- `stepDefinitions/` - Cucumber step definition classes for test scenarios
- `utils/` - Utility classes for dynamic data generation (`DataGeneration`) and WebDriver setup (`Hooks`)
- `features/` - `.feature` files with scenarios written in Gherkin
- `pom.xml` - Maven file containing all project dependencies

---

## Example Scenario Covered

1. Navigate to the main page
2. Register a new account with automatically generated data
3. Add 6 different products to the cart
4. Apply filters and sorting (CO₂ rating, price slider)
5. Complete the order using cash on delivery
6. Verify the username after login

> The test method `MainPage.test()` combines all these steps into a single flow.

---

## How to Run the Tests

1. Clone the repository:  
   ```bash
   git clone <repo-url>
