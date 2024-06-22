# 2018 KAKAO BLIND RECRUITMENT [3차] 방금그곡

def solution(m, musicinfos):
    answer = []
    m = changeWord(m)
    
    for musicinfo in musicinfos:
        start, end, title, song = musicinfo.split(',')
        start = hourTomin(start)
        end = hourTomin(end)
        song = changeWord(song)
        
        time = (end - start)
        song_size = len(song)
        plus_song = song[:(time % song_size)]
        song *= (time // song_size)
        song += plus_song
        # print(f"title={title}, song={song}")
        
        if m in song:
            answer.append(title)
        
    answer.sort(key= lambda x:len(x))
        
    if not answer:
        return "(None)"
        
    return answer[-1]

# 음악이 00:00를 넘겨서까지 재생되는 일은 없다.
def hourTomin(time):
    h, m = time.split(':')
    
    return int(h) * 60 + int(m)

def changeWord(m):
    return m.replace('C#','c').replace('D#','d').replace('F#','f').replace('G#','g').replace('A#','a');

# A C D F G
def incorr_changeWord(song):
    song = list(song)
    
    for i in range(len(song)-1):
        temp = song[i] + song[i+1]
        if temp == "A#": song[i] = "a"
        elif temp == "C#": song[i] = "c"
        elif temp == "D#": song[i] = "d"
        elif temp == "F#": song[i] = "f"
        elif temp == "G#": song[i] = "g"
        
        if song[i] == '#': song[i] = ''
    
    a = ''.join(song)
    a = a.split()
    return ''.join(a)