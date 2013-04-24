# Rock-paper-scissors-lizard-Spock template
# PLEASE NOTE MY VALUES ARE DIFFERENT FROM TEMPLATE


# Also as is tradition a Quote from Monty Python
#“-She turned me into a newt! 
#-A newt?
#-I got better...”

# The key idea of this program is to equate the strings
# "rock", "paper", "scissors", "lizard", "Spock" to numbers
# as follows:
#
# 5 - rock
# 4 - Spock
# 3 - paper
# 2 - lizard
# 1 - scissors

import random;
MapArray = ["scissors","lizard","paper","spock","rock"]

# helper functions

def number_to_name(number):
    """
    Convert a number in the range of 1-5 to its String equivalent
    """
    
    #Array Manipulation
    return MapArray[number-1];

    
def name_to_number(name):
    """
    Convert String to its numerical equivalent in a range of 1-5
    """

    # Array Manipulation
    return MapArray.index(name)+1;


def rpsls(name): 
    """
    Perform rpsls against User's choice and randomly generated Computer choice
    """
    losers = [1,2,-3,-4];
    winners = [-1,-2,3,4];

    # convert name to player_number using name_to_number
    print "Player chooses "+name;
    userChoice = name_to_number(name.lower());
    
    # compute random guess for comp_number using random.randrange()
    compChoice = random.randrange(1,6);
    print "Computer chooses "+number_to_name(compChoice);
    
    # compute difference of player_number and comp_number modulo five
    diff = userChoice - compChoice;
    
    
    # use if/elif/else to determine winner
    if (diff == 0):
        print "Player and computer tie!";
    elif(diff in winners):
        print "Player wins!";
    elif(diff in losers):
        print "Computer wins!";
    else:
        print "Is that even possible?";
    print "";
       

    
# test your code
rpsls("rock")
rpsls("Spock")
rpsls("paper")
rpsls("lizard")
rpsls("scissors")

# always remember to check your completed program against the grading rubric