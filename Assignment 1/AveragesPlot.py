#this is the class that generated the average plot

import matplotlib.pyplot as plt

# the averages in these lists were calculated in the DataVisulazier class
array_sizes = ['100','1000','10000','100000']
merge_insertion = [58986, 129876, 1642954, 15599237]
merge = [69831, 227195, 2655326, 18529550]
selection = [103290, 647814, 35171845, 3216372900]
insertion = [61650,  400266, 10046600, 882877737]
bubble = [195231, 1408871, 160709362, 20754095272]
sorting_algorithms = [merge_insertion, merge, selection, insertion, bubble]

colors = ['black', 'red', 'green', 'blue', 'yellow']

def main():
    for i in range(5):
        plt.plot(array_sizes, sorting_algorithms[i], color=colors[i])
    plt.ylim(0, 7*10**8)
    plt.xlabel('size of array')
    plt.ylabel('time in nanoseconds')
    plt.title('Averages of sorting algorithms')
    plt.legend([
        'merge_insertion',\
                'merge ',\
                'selection',\
                'insertion',\
                'bubble'])
    plt.show()

if __name__ == '__main__':
    main()
