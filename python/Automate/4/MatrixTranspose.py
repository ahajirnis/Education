grid = [['.', '.', '.', '.', '.', '.'],
        ['.', 'O', 'O', '.', '.', '.'],
        ['O', 'O', 'O', 'O', '.', '.'],
        ['O', 'O', 'O', 'O', 'O', '.'],
        ['.', 'O', 'O', 'O', 'O', 'O'],
        ['O', 'O', 'O', 'O', 'O', '.'],
        ['O', 'O', 'O', 'O', '.', '.'],
        ['.', 'O', 'O', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.']]
# print(grid)
grid2 = []
for i in range(0, len(grid[0])):
    row = []
    for j in range(0, len(grid)):
        row.append(grid[j][i])
        # print(str(i) + ',' + str(j))
        # print(grid[j][i])
    # grid2.append(row)
    print(row)
