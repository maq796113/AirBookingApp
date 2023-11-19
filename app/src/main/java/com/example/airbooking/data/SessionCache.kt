package com.example.airbooking.data

interface SessionCache {
    fun saveSession(session: Session)

    fun getActiveSession(): Session?

    fun clearSession()
}