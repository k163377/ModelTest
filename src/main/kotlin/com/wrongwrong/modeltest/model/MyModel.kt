package com.wrongwrong.modeltest.model

import java.util.*
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class MyModel(
        @field:NotNull(message = "idはnull不許可")
        val id: Long?,
        @field:NotBlank(message = "nameは空白不許可")
        val name: String?,
        val create: Date?,
        val update: Date?
) {
    @AssertTrue(message = "updateがcreateより過去")
    fun isLater(): Boolean {
        if(create == null || update == null) return true
        return create.before(update) || create == update
    }
}