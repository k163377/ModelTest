package com.wrongwrong.modeltest.model

import com.wrongwrong.modeltest.annotation.CanSplitBySpace
import com.wrongwrong.modeltest.annotation.IsLater
import java.util.*
import javax.validation.constraints.NotNull

@IsLater(before = "create", after = "update", message = "updateがcreateより過去")
data class MyModel(
        @field:NotNull(message = "idはnull不許可")
        val id: Long?,
        @CanSplitBySpace(message = "名前が半角スペースで2つに分割できない")
        val name: String?,
        val create: Date?,
        val update: Date?
)