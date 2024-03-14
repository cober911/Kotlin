package Seminar1

import kotlin.system.exitProcess

var users = mutableMapOf<String?, List<String?>>()

fun main() {
    users["Ada"] = arrayListOf("5551234", "ada@example.com")
    println("Введите help для получения списка команд")
    while (true) {
        start()
    }
}

fun start() {
    val input = readlnOrNull()?.lowercase() //чтение из консоли
    when {
        input == "exit" -> {
            println("Конец программы")
            exitProcess(0)
        }
        input == "help" -> help()
        input == "add" -> add()
        input == "get" -> printPhoneBook()
        else -> {
            println("Некорректный ввод")
            help()
        }
    }
}

fun help() {
    println("exit для выхода")
    println("add для добавления контакта")
    println("get для получения контактов")
}

fun add() {
    val name = addName()
    println("Введите phone если хотите добавить номер телефона \nВведите email если хотите добавить почту")
    val input = readlnOrNull()?.lowercase() //чтение из консоли

    when {
        input == "exit" -> println("Выход")
        input == "phone" -> addPhoneBook(name, addPhone())
        input == "email" -> addPhoneBook(name, addEmail())
    }
}

fun printPhoneBook() {
    for (user in users) {
        println("")
        println("name: " + user.key)
        for (i in user.value) {
            println(i)
        }
    }
}

fun addPhoneBook(name: String?, contact: String?) {
    val contacts = arrayListOf(contact)
    for (user in users) {
        if (user.key == name) users[name] = users[name]!! + contacts
        else users[name] = contacts
        printPhoneBook()
    }
}

fun addPhone(): String? {
    println("Введите номер телефона")
    var phone = readlnOrNull()
    while (phone?.matches(Regex("""[0-9+]+""")) == false) {
        println("Некорректный ввод номера телефона")
        phone = readlnOrNull()
    }
    return phone
}

fun addName(): String? {
    println("Введите имя контакта")
    var name = readlnOrNull()

    while (name?.matches(Regex("""[A-Za-z а-яёА-ЯЁ]+""")) == false) {
        println("Некорректный ввод имени")
        name = readlnOrNull()
    }
    return name
}

fun addEmail(): String? {
    println("Введите почту")
    var email = readlnOrNull()
    while (email?.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+""")) == false) {
        println("Некорректный ввод")
        email = readlnOrNull()
    }
    return email
}

fun readlnOrNull(): String? = readLine()
