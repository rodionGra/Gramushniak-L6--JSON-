package com.jsonhomework6

import com.google.gson.Gson
import java.io.*
import java.util.*


/**
 * Описати FamilyTree у форматі JSON.
 *
 * Повинен бути JSON файл у якому описана структура з такими властивостями,
 * як ім’я, вік, повнолітність (чи повнолітня ця людина), кількість родичів та тато і мама, які в свою чергу теж JSON об’єкти.
 *
 * Створити відповідні їм data класи. Серіалізувати та десеріалізувати їх за допомогою GSON
*/
fun main() {

    //fill in the information about me
    val me = Person("Rodion", 18)
    me.mother = Person("Tatiana", 50)
    me.father = Person("Alex", 51)
    me.addSib(Person("Artem", 28))

    println(me.toString())
    println("Brother: ${me.siblings}")
    println("Mother: ${me.mother} , father: ${me.father} \n")

    //Serializing to file
    val writer = FileWriter("text.json")
    writer.use {
        //use - Executes the given block function on this resource and then
        // closes it down correctly whether an exception is thrown or not.
        it.write(Gson().toJson(me))
    }

    //Deserialize from file
    val textFromFile = Scanner(File("text.json")).nextLine()
    val meFromFile = Gson().fromJson<Person>(textFromFile, Person::class.java)


    println("Info about me from file: $meFromFile")
    println("Info about brother from file: ${meFromFile.siblings}")
}
