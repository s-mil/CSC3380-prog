#!/bin/bash
javac arrayIncrementer.java
for i in {1..7}
do
	if [[ $i -eq 1 ]]
	then
		echo "2 2 5" > input.txt
		java arrayIncrementer input.txt
	fi
	if [[ $i -eq 2 ]]
	then
		echo "2 3 9 9" > input.txt
		java arrayIncrementer input.txt
	fi
	if [[ $i -eq 3 ]]
	then
		echo "9 9 9 9" > input.txt
		java arrayIncrementer input.txt
	fi
	if [[ $i -eq 4 ]]
	then
		echo "1 2 3 4 5 6 7 8 9" > input.txt
		java arrayIncrementer input.txt
	fi
	if [[ $i -eq 5 ]]
	then
		echo "9 8 7 6 5 4 3 2 1" > input.txt
		java arrayIncrementer input.txt
	fi
		if [[ $i -eq 6 ]]
	then
		echo "0" > input.txt
		java arrayIncrementer input.txt
	fi
		if [[ $i -eq 7 ]]
	then
		echo "9" > input.txt
		java arrayIncrementer input.txt
	fi
done
