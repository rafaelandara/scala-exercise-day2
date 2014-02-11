/*
Created by: Rafael Andara <rafael.andara@gmail.com>
Date: 2014-03-10
Usage: scala censor.scala article censorfile

Description: 
	Write a Censor trait with a method that will replace the curse words 
	Shoot and Darn with Pucky and Beans alternatives. 
	Use a map to store the curse words and their alternatives.

	Load the curse words and alternatives from a file.

*/


class Article(val file:String){
	var article = ""
	try {
		var source = scala.io.Source.fromFile(file) 
		article = source.mkString
		source.close()
	}
	catch {
		case e: Exception => println("Exception caught: " + e);
	}

	def publish(){
		println(article)
	}

}

trait Censor{

	def censorship(article:String,badwordsfile:String){
		try {
			var lines = scala.io.Source.fromFile(badwordsfile).getLines
			var badwords = new scala.collection.mutable.HashMap[String,String]
			lines.foreach{ line =>
				var w = line.split(";")
				var bw = w{0}
				var gw = w{1}
				badwords += bw -> gw
			}
			//var badwords = Map("shoot" -> "pucky", "darn" -> "beans")
			var words = article.split(" ")

			words.foreach{ word =>
				var show = true
				badwords.foreach{ hide =>

					if(word == hide._1){
						print(hide._2+" ")
						show = false
					}

				}
				if (show) print(word+" ")

			}
			println()
		}
		catch {
			case e: Exception => println("Exception caught: " + e);
		}

	}
}


class Publisher(override val file:String) extends Article(file) with Censor





var myarticle = new Publisher(args{0})
myarticle.publish
println("======= After censorship =======")
myarticle.censorship(myarticle.article,args{1})



