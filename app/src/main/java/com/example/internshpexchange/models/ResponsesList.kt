package com.example.internshpexchange.models

class ResponsesList {
    private val list = listOf(
        InternshipResponse(
            internship = Internship(
                company = "Яндекс",
                name = "Weekend Intern Mobile",
                price = "60000 ₽"
            ),
            status = ResponseStatus.Accepted
        ),
        InternshipResponse(
            internship = Internship(
                company = "Тинькофф",
                name = "Аналитика данных",
                price = "40000 ₽"
            ),
            status = ResponseStatus.Refused
        ),
        InternshipResponse(
            internship = Internship(
                company = "Сбербанк",
                name = "Стажировка Web-разработка",
                price = "20000 ₽"
            ),
            status = ResponseStatus.Considered
        )
    )

    fun getList() = list.shuffled()
}