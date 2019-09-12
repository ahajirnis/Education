catNames = []

while True:
    print('Enter the name of your cat:')
    name=input()
    if len(name) == 0:
        break
    catNames.append(name)
print('Your cats are :')
for name in catNames:
    print(' '+name, end='')
