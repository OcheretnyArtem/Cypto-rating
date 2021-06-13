package com.uogames.longProject.HW8.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}