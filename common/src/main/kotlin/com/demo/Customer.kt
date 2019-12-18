package com.demo

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Customer(@Id val id: Long, val name: String, var state: String){
    constructor() : this(0, "", "")
}
