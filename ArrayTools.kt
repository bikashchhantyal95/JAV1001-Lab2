// Bikash Chhantyal
// A00265470
// JAV 1001
// App Development for Android

fun main(){

    // for average value
    testArrayAvg()

// for arrayContains function
    testArrayContains()

//    for reverse function
    testReverseFunc()

// for encrypt function
    println("Enter the String to encrypt:")
    var userInput = readln()
//check is the user input is empty or null
    if(userInput.trim().isNotEmpty() && userInput != null){
//        checks if the user input is integer
//        if the input is integer throw error mesage
        if (userInput.toIntOrNull() !=null ){
            println("Input cannot be integer")
        }else{
//            store the output of encrypt function if the user input is valid
            val encryptedValue = encrypt(string = userInput, shiftBy = 2)
//            prints the encrypted text of the user input
            print("The Caesar cipher text of $userInput is $encryptedValue")
        }
    }else{
//        if the input is empty print the message
        println("Enter String to encrypt text.")
    }

}


/**
 * First question: Create a Caesar cipher function
 * that accepts a String (the String to encrypt),
 * a shift value,
 * and returns the new String.
 **/

// Casesr Cipher function
//function to encryot string
fun encrypt(string: String, shiftBy:Int): String {
//    create array of characters from string
    val stringToChar = string.toCharArray()
//    iterate through stringToChar
    for(i in stringToChar.indices){
//        check if i is a letter
        if(stringToChar[i].isLetter()){
//            if char is letter perform shift to the character using shiftbit func
            stringToChar[i] = shiftBit(bit = shiftBy, char = stringToChar[i])
        }else {
//            if the char is not string do nothing and return char
            stringToChar[i]
        }
    }
//    return encrypted text
    return String(stringToChar)
}
// function to shift bit
fun shiftBit(bit: Int, char: Char): Char {
    val newShiftBit: Int
//    check if the char is uppercase
    if (char.isUpperCase()) {

        newShiftBit = ((char.code - 65 +bit + 26) % 26) + 65
        return newShiftBit.toChar()
    } else {
        newShiftBit = ((char.code - 97 + bit + 26) % 26) + 97
        return newShiftBit.toChar()
    }
}

//arrayAvg Write a function that accepts an array and produces
// the average of all values (array should be numeric type)

fun arrayAvg(numericArray: Array<Int>): Double {
//    initialize sum of array to zero
    var sumOfIntegerArray = 0.0
//    iterate through the numeric array
    for (element in numericArray){
//        add each iterative element to sumOfIntegerArray
        sumOfIntegerArray += element
    }
//    compute the average of array and return
    return sumOfIntegerArray / numericArray.size
}

fun testArrayAvg(){
    var listOfIntegers = arrayOf(arrayOf<Int>(1,2,3,4),arrayOf<Int>(1,5,7,9,10),arrayOf<Int>(9,8,3,4))
    var listOfResult = arrayOf(2.5, 6.4, 6.0)
    println("Test case for the array average function")
    for (i in listOfIntegers.indices){
        if (arrayAvg(numericArray = listOfIntegers[i])==listOfResult[i]){
            println("[${listOfIntegers[i].joinToString(",")}] has passed the test.")
        }
    }
}
/**
 * arrayContains Write a function that accepts an
 * array and a search value, and determines if the array contains
 * the value (true/false) (the array can use any data type you want)
 **/

fun arrayContains(array: Array<Int>, searchValue:Any): Boolean{
    var isFound: Boolean = false
    for(i in array){
        if(i == searchValue){
            isFound =  true
        }
    }
    return isFound
}

//function to test arrayContain function
fun testArrayContains(){
    var listOfIntegers = arrayOf(arrayOf<Int>(1,2,3,4),arrayOf<Int>(1,5,7,9,10),arrayOf<Int>(9,8,3,4))
    var listOfResult = arrayOf(true, false, true)
    println("Test case for the array Contain function")
    for (i in listOfIntegers.indices){
        if (arrayContains(array = listOfIntegers[i], searchValue = 4) ==listOfResult[i]){
            println("[${listOfIntegers[i].joinToString(",")}] has passed the test.")
        }
    }
}

/**
 * reverse Write a function that reverses an
 * array (gives a new array)
 * (the array can use any data type you want)
 **/

fun reverse(arr:Array<Int>): Array<Int> {
//    store a copy of input into temp var
    val temp = arr.copyOf()
//    iterate through the passed array
    for(i in arr.indices){
//        replace value at each index of temp with new value
        temp[i] = arr[arr.size -1-i]
    }
//    return the reversed array
    return temp
}

//function to test arrayContain function
fun testReverseFunc(){
    var listOfIntegers = arrayOf(arrayOf<Int>(1,2,3,4),arrayOf<Int>(1,5,7,9,10),arrayOf<Int>(9,8,3,4))
    var listOfResult = arrayOf(arrayOf<Int>(4,3,2,1,8), arrayOf<Int>(10,9,7,5,1), arrayOf<Int>(4,3,8,9))
    println("Test case for the Reverse function")
    for (i in listOfIntegers.indices){
        if (reverse(arr = listOfIntegers[i]).contentEquals(listOfResult[i])){
            println("[${listOfIntegers[i].joinToString(",")}] has passed the test.")
        }else{
            println("[${listOfIntegers[i].joinToString(",")}] has failed the test.")
        }
    }
}