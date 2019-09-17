import pprint

items = {'rope': 1, 'torch' : 6, 'gold coins': 42, 'dagger' : 1, 'arrow' : 12}

def displayInventory(inventory):
	item_total = 0
	for item, count in inventory.items():
		print(item+' : '+str(count))
		item_total += count
	print ('Total number of items in Inventory: '+str(item_total))

def addToInventory(inventory,addedItems):
	for itemToAdd in addedItems:
		inventory.setdefault(itemToAdd,0)
		inventory[itemToAdd] += 1
	return inventory

inv = {'gold coin' : 42, 'rope' : 1}
dragonLoot = ['gold coin', 'dagger', 'gold coin', 'gold coin', 'ruby']
inv = addToInventory(inv, dragonLoot)
displayInventory(inv)
