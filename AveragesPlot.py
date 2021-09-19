import matplotlib.pyplot as plt

array_sizes = [30, 100, 1000, 10000, 100000, 1000000]
array_sizes = list(map(str, array_sizes))
merge_insertion = [None, 140288, 256175, 2599687, 14540166, 1474830932]
merge = [20833, 119512, 232650, 2535012, 19867166, 1875832015]
selection = [15462, 147440, 591554, 36227004, 3213359366, 2*10**10]
insertion = [15716, 201332,  827479, 54606150, 5297283933, 2.5*10**10]
bubble = [22704, 191992, 1538958, 162662541, 20567778100, None]
sorting_algorithms = [merge_insertion, merge, selection, insertion, bubble]

colors = ['black', 'red', 'green', 'blue', 'yellow']

def main():
    for i in range(5):
        plt.plot(array_sizes, sorting_algorithms[i], color=colors[i])
    plt.ylim(0, 8*10**9)
    plt.xlabel('size of array')
    plt.ylabel('time in nanoseconds')
    plt.title('Averages of sorting algorithms')
    plt.legend(['merge_insertion',\
                'merge ',\
                'selection',\
                'insertion',\
                'bubble'])
    plt.show()

if __name__ == '__main__':
    main()