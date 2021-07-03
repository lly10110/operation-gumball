import random

def strToList(s):
    l = []
    for i in s: l.append(int(i))
    return l

def generate(length):
    s = ""
    for i in range(length):
        r = random.randint(0, 9)
        s += str(r)
    return strToList(s)

def c(sequence, guess,n):
    # all correct
    if sequence == guess:
        for i in range(n):
            print("GREEN ", sep='', end='')
        print("\nCorrect!")
        return True
    #still guessing
    else:
        #green
        for i in range(n-1,-1,-1):
            for j in range(1,10):

                #print(guess,i,j,guess[i],sequence[i])
                if int(guess[i]) == j and int(sequence[i]) == j:
                    print("GREEN ",sep='', end='')
                    n-=1
                    guess.remove(j)
                    sequence.remove(j)
                    break


        #red
        for i in range(n-1,-1,-1):
            for j in range(1,10):
                if sequence[i] == j and j in guess:
                    print("RED ",sep='', end='')


print("Welcome to Operation Gumball!")
print("Please input how many gumballs you would like to guess.")
n = int(input())

sequence = generate(n)
print(sequence)

# guess
guess_count = 0
correct = False
while guess_count < 10 and correct is False:
    print("Guess:")
    guess = input()
    if guess.isdigit() and len(guess) == n:
        guess = strToList(guess)
        correct = c(sequence, guess,n)

    else:
        print("Guess is invalid. Try again.")
        continue
    guess_count += 1
