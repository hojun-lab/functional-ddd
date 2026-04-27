package com.kalrap.ordertaking.common

abstract class Entity<T: Any> {
    abstract val id: T

    override fun equals(other: Any?): Boolean {
       return this === other || (
               other != null &&
               this::class == other::class &&
               other is Entity<*> &&
               this.id == other.id
               )
    }

    override fun hashCode(): Int = id.hashCode()
}