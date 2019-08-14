package com.abid.confiados.model

data class DestinationModel (
    var key: String? = null,
    var image: String? = null,
    var name: String? = null,
    var gender: String? = null,
    var noTelp: String? = null,
    var destination: String? = null,
    var startDate: String? = null,
    var endDate: String? = null,
    var iduser: String? = null,
    var bukti: String? = null,
    var user: UserModel? = null
)
//    constructor()
//    constructor(image: String, name: String, gender: String, destination: String, startDate: String, endDate: String) {
//        this.image = image
//        this.name = name
//        this.gender = gender
//        this.destination = destination
//        this.startDate = startDate
//        this.endDate = endDate
//    }
//
//    fun getImage(): String {
//        return image!!
//    }
//
//    fun getName(): String {
//        return name!!
//    }
//
//    fun getGender(): String {
//        return gender!!
//    }
//
//    fun getDestination(): String {
//        return destination!!
//    }
//
//    fun getKey(): String {
//        return key!!
//    }
//
//    fun getStartDate(): String {
//        return startDate!!
//    }
//
//    fun getEndDate(): String {
//        return endDate!!
//    }
//
//    fun setKey(key: String) {
//        this.key = key
//    }
//}