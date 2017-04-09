#!/bin/bash

for filename in `\find . -name "*.class"`;
do
	rm $filename
done
