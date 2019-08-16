import random

secretNumber = random.randint(1,20)
# print('I am thinking of : '+str(secretNumber))
# print('Hi')

def takeAGuess(guess):
    if guess < secretNumber:
        return 'Too low!!'
    elif guess > secretNumber:
        return 'Too high!!'
    return 'Got it!'

print('I am thinking of a number between 1 and 20')
for i in range(1,7):
    print('Guess??')
    guess = int (input())
    print(takeAGuess(guess))
if (guess != secretNumber):
    print('Oops! You missed after 6 tries')
