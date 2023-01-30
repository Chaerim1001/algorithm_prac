N = int(input()) #사람 숫자
time = list(map(int, input().split())) #입력받은 시간
time.sort() #오름차순으로 정렬

for i in range(1, N):
    time[i] += time[i-1]

print(sum(time))