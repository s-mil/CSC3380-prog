Sam Miller
CSC3380
3/3/2017


Compile:
javac arrayIncrementer.java

Run
java arrayIncrementer "textfile input here"

the text file should be a space delimited series of numbers eg 1 2 3 4
for example a command calling input.txt would look like:
java arrayIncrementer input.txt


Output:
Input  : [input array here]
Output : [the resulting array here]

with the example given above of input.txt consisting of 1 2 3 4
Input  : [1, 2, 3, 4]
Output : [1, 2, 3, 5]


Testing:
A convenient tester shell script is provided, it usage can be defined as follows:

while within the directory containing arrayIncrementer.java from a terminal run the command
./tester.sh

the tester will then run through a multitude of inputs and display the output as described above for each case sequentially.
The test cases included by default are:
2 2 5
2 4 9 9
9 9 9 9
1 2 3 4 5 6 7 8 9
9 8 7 6 5 4 3 2 1
0
9
9 9 1 2 3 4 5 6 7 8 9 9 9 9
99 1 2 3
1 # 3 4
