package com.wrongwrong.modeltest.annotation

import org.springframework.beans.BeanWrapperImpl
import java.util.*
import javax.validation.*
import kotlin.reflect.KClass

//アノテーション
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ReportAsSingleViolation
@Constraint(validatedBy = [IsLaterValidator::class])
annotation class IsLater(
        val message: String = "message",
        val groups: Array<KClass<out Any>> = [],
        val payload: Array<KClass<out Payload>> = [],
        val before: String,
        val after: String
)

//バリデーター本体
class IsLaterValidator: ConstraintValidator<IsLater, Any> {
    lateinit var beforeName: String
    lateinit var afterName: String

    override fun initialize(constraintAnnotation: IsLater) {
        beforeName = constraintAnnotation.before
        afterName = constraintAnnotation.after
    }

    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {
        //valueがnullなら何もしない
        if(value == null) return true
        val beanWrapper = BeanWrapperImpl(value)

        //入力から値を取り出す
        val before = beanWrapper.getPropertyValue(beforeName) as Date?
        val after = beanWrapper.getPropertyValue(afterName) as Date?

        //比較結果を返却
        if(before == null || after == null) return true
        return before.before(after) || before == after
    }
}