package com.abid.confiados.model

class DestinationModel {
    private var key: String? = null
    private var image: String? = null
    private var name: String? = null
    private var gender: String? = null
    private var destination: String? = null
    private var startDate: String? = null
    private var endDate: String? = null

    constructor()
    constructor(image: String, name: String, gender: String, destination: String, startDate: String, endDate: String) {
        this.image = image
        this.name = name
        this.gender = gender
        this.destination = destination
        this.startDate = startDate
        this.endDate = endDate
    }

    fun getImage(): String {
        return image!!
    }

    fun getName(): String {
        return name!!
    }

    fun getGender(): String {
        return gender!!
    }

    fun getDestination(): String {
        return destination!!
    }

    fun getKey(): String {
        return key!!
    }

    fun getStartDate(): String {
        return startDate!!
    }

    fun getEndDate(): String {
        return endDate!!
    }

    fun setKey(key: String) {
        this.key = key
    }
}