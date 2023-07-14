arr1 = [[1,2],[2,3]]
arr2 = [[3,4],[5,6]]

answer = arr1
for i in range(len(arr1)):
    # answer.append([0])
    for j in range(len(arr1[0])):
            answer[i][j] = arr1[i][j]+arr2[i][j]
            # print("1")

print(answer)