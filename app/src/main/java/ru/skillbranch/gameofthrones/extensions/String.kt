package ru.skillbranch.gameofthrones.extensions

fun String.getIdFromUrl() = this.split("/").last()