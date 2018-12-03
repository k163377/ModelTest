package com.wrongwrong.modeltest.annotation

import javax.validation.*
import kotlin.reflect.KClass

//アノテーション
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ReportAsSingleViolation
@Constraint(validatedBy = [CanSplitBySpaceValidator::class])
annotation class CanSplitBySpace(
        val message: String = "message",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = []
)

//バリデーター本体
class CanSplitBySpaceValidator: ConstraintValidator<CanSplitBySpace, String>{
    override fun initialize(constraintAnnotation: CanSplitBySpace) {}

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        //nullなら何もしない
        if(value == null) return true
        //スペースで2分割できなければいけない
        return value.split(" ").size == 2
    }
}

