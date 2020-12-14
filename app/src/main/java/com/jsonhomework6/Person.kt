package com.jsonhomework6

data class Person(var name: String, var age: Int){

    var mother: Person? = null
    var father: Person? = null
    var adult : Boolean = age >= 18

    var siblings : MutableList<Person> = mutableListOf()     //list of brothers and sisters
        private set

    //add a sibling to the calling object
    fun addSib(sib : Person){
        sib.father = this.father
        sib.mother = this.mother
        //assign a sibling a link to the same parents
        siblings.add(sib)
    }

    private fun countRelativesWithMe() : Int{
        var count =  1 + this.siblings.size
        this.father?.let{
            count += it.countRelativesWithMe()
        }
        this.mother?.let{
            count += it.countRelativesWithMe()
        }

        return count
    }

    fun countRelatives() : Int = countRelativesWithMe() - 1

}