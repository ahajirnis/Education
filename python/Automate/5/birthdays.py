
birthdays = {'Alice':'Apr 1','Roger':'Jan 12','!xobile': 'Dec 31'}

while True:
    print("Enter friend's name:")
    name = input()
    if name == '':
        break
    if name in birthdays:
        print(birthdays[name]+' is '+name+'\'s birthday')
    else:
        print('I do not know who this is. What is their birthday?')
        birthdate = input()
        birthdays[name] = birthdate
        print('Now I know')

    
