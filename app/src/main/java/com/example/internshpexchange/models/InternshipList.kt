package com.example.internshpexchange.models

class InternshipList {
    private val list = listOf(
        Internship(
            company = "Яндекс",
            name = "Weekend Intern Mobile",
            price = "60000 ₽"
        ),
        Internship(
            company = "Тинькофф",
            name = "Аналитика данных",
            price = "40000 ₽"
        ),
        Internship(
            company = "Сбербанк",
            name = "Стажировка Web-разработка",
            price = "20000 ₽"
        )
    )

    fun getList() = list.shuffled()
}