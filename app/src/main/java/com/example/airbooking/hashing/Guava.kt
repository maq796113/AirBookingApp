package com.example.airbooking.hashing

import com.google.common.hash.Hashing


class Guava {
    fun hashingSha256(string: String) : String{
        val hashFunction = Hashing.sha256()
        val hv = hashFunction
            .newHasher()
            .putString(string, Charsets.UTF_8)
            .hash()
        return hv.toString()
    }
}