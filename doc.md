# Configs

https://lighthouse-demo.evozon.com/login
User: lhdemo
Pass: LH@Evozon!2022

# Doc link
https://drive.google.com/drive/folders/1H-iDY3cmdnJWeRM8Q62wD6LsPel77usG?usp=sharing

# Testing Techniques

1. ## Coverage-based Techniques
   - Function Testing - Gheorghe
      - Test a set of functionalities of the app
         - IO1 - Verify the functionalities work as expected individually (check for happy case)
         - IO2 - Verify the functionalities work as expected orchestrated (check for happy case)
         - IO3 - Gheorghe found a bug in the Buildings Management
   - User Interface Testing - Raul
      - Test elements of the UI
         - IO1 - Test that elements are clickable everywhere
         - IO2 - Test that elements can be clicked multiple times

2. ## Risk-based Techniques
   - Quick Testing - Raul
      - Short, quick tests
         - IO1 - Test that pages load
         - IO2 - Test that elements on pages work
         - IO3 - Test if app can be accessed without auth
   - Load Testing - Horatiu
      - Test how the application works under load
         - IO1 - Test if the app pages respond under load
         - IO2 - Test maximum response time under load

3. ## Activity-based Techniques
   - Dumb Monkey Testing - Horatiu
      - Tests with random data
         - IO1 - Test inputs with Unicode & Alphanumeric characters
         - IO2 - Test inputs with long strings
         - IO3 - Test inputs with html code
   - Long Sequence Testing - David
      - Long Running, Several Tests
         - AC1 - e2e Test the entire application as User
         - AC2 - e2e Test the entire application as Admin