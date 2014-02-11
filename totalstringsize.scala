/*
Created by: Rafael Andara <rafael.andara@gmail.com>
Date: 2014-03-10
Usage: scala totalstringsize.scala word1 word2 ... wordN

Description: 
	Use foldLeft to compute the total size of a list of strings.
	
*/


val list = args

var size = list.foldLeft(0)((sum,word) => sum + word.size)

print("Strings:")
args.foreach{ arg =>
	print(" "+arg)

}
println("\nTotal size: "+size)